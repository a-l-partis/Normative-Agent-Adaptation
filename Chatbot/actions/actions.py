import json
import re
from dataclasses import dataclass
from typing import Any, Dict, List, Optional, Tuple

from rasa_sdk import Action, Tracker
from rasa_sdk.executor import CollectingDispatcher
from rasa_sdk.events import SlotSet as RasaSlotSet, EventType

try:
    from .workflow_loader import load_workflow, resolve_active_workflow
except Exception:
    load_workflow = None
    resolve_active_workflow = None


# -----------------------------
# Small NLP helpers / heuristics
# -----------------------------
ORDER_NUM_RE = re.compile(r"\b\d{3,}\b", re.IGNORECASE)
EMAIL_RE = re.compile(r"[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}", re.IGNORECASE)
PHONE_RE = re.compile(r"(?<!\d)(?:\+?\d[\s().-]?){10,}(?!\d)")
FRUSTRATION_RE = re.compile(
    r"\b(frustrated|angry|upset|annoyed|furious|ridiculous|worst|useless|unacceptable|"
    r"tired of|fed up|cancel.*order|complain|complaint|speak to (?:a )?human|agent now)\b",
    re.IGNORECASE,
)

# Detect explicit requests to talk to a human/agent
AGENT_REQUEST_RE = re.compile(
    r"\b(human|agent|representative|real person|live person|operator)\b|"
    r"\b(talk|speak|connect)\s+(to|with)\s+(a\s+)?(human|agent|representative|person|operator)\b",
    re.IGNORECASE,
)

def wants_agent(text: str) -> bool:
    return bool(AGENT_REQUEST_RE.search(text or ""))

def looks_frustrated(text: str) -> bool:
    return bool(FRUSTRATION_RE.search(text or ""))

def extract_order_number(text: str) -> Optional[str]:
    m = ORDER_NUM_RE.search(text or "")
    return m.group(0) if m else None

def looks_like_personal_info(text: str) -> bool:
    t = text or ""
    if EMAIL_RE.search(t):
        return True
    digits = sum(ch.isdigit() for ch in t)
    if digits >= 10 and PHONE_RE.search(t):
        return True
    return False

def interpret_menu_choice(text: str) -> Optional[str]:
    t = (text or "").strip().lower()
    if t in {"1", "one"}:
        return "status"
    if t in {"2", "two"}:
        return "return"
    if any(k in t for k in ["status", "track", "tracking", "order status"]):
        return "status"
    if any(k in t for k in ["return", "refund", "send back"]):
        return "return"
    return None

def is_yes(text: str) -> bool:
    return (text or "").strip().lower() in {"yes", "y", "yep", "yeah", "sure", "ok", "okay"}

def is_no(text: str) -> bool:
    return (text or "").strip().lower() in {"no", "n", "nope", "nah"}


# -----------------------------
# Data structures for executor
# -----------------------------
@dataclass
class WFGuard:
    id: str
    negated: bool = False

@dataclass
class WFTask:
    id: str

@dataclass
class WFSequence:
    steps: List[Any]  # WFTask | WFLoop | WFDecision

@dataclass
class WFLoop:
    body: Any          # WFSequence | WFTask | WFDecision
    guard: WFGuard

@dataclass
class WFDecision:
    options: List[Tuple[WFGuard, Any]]  # (guard, body)


# -----------------------------
# Normalization from parsed dict
# -----------------------------
def _norm_guard(g: Dict[str, Any]) -> WFGuard:
    return WFGuard(id=g.get("id", "TRUE"), negated=bool(g.get("negated", False)))

def _norm_node(node: Dict[str, Any]) -> Any:
    t = node.get("type")
    if t == "Task":
        return WFTask(id=node.get("id", ""))
    if t == "Sequence":
        return WFSequence(steps=[_norm_node(s) for s in node.get("steps", [])])
    if t == "Loop":
        return WFLoop(
            body=_norm_node(node.get("body", {"type": "Sequence", "steps": []})),
            guard=_norm_guard(node.get("guard", {"id": "TRUE", "negated": False})),
        )
    if t == "Decision":
        opts: List[Tuple[WFGuard, Any]] = []
        for opt in node.get("options", []):
            guard = _norm_guard(opt.get("guard", {"id": "TRUE", "negated": False}))
            body = _norm_node(opt.get("body", {"type": "Sequence", "steps": []}))
            opts.append((guard, body))
        return WFDecision(options=opts)
    return WFSequence(steps=[])


# -----------------------------
# Minimal workflow interpreter
# -----------------------------
@dataclass
class InterpreterState:
    spec: Any                 # normalized top-level node (usually Sequence)
    stack: List[Dict[str, Any]]
    vars: Dict[str, Any]
    await_input: bool
    last_task: Optional[str]

def _default_vars() -> Dict[str, Any]:
    return {
        "personalInfo": False,
        "validOrderNum": False,
        "helpNeeded": True,
        "option:GetOrderStatus": False,
        "option:ReturnProduct": False,
        "canReturn": False,
        "order_number": None,
        "awaiting_anything_else": False,
        "awaiting_order_number": False,
        "userFrustrated": False,
        "tone_empathetic": False,
        "awaiting_menu_choice": False,
        "newUser": False,                 
        "explainModeThorough": False,     
        "userRequestsHumanOperator": False,
        "handoffPermitted": False
    }

def _eval_guard(g: WFGuard, vars: Dict[str, Any]) -> bool:
    if g.id == "TRUE":
        val = True
    else:
        val = bool(vars.get(g.id, False))
    return (not val) if g.negated else val

def _push(stack: List[Dict[str, Any]], frame: Dict[str, Any]) -> None:
    stack.append(frame)

def _pop(stack: List[Dict[str, Any]]) -> Dict[str, Any]:
    return stack.pop() if stack else {}

def _node_kind(node: Any) -> str:
    if isinstance(node, WFSequence): return "Sequence"
    if isinstance(node, WFTask):     return "Task"
    if isinstance(node, WFDecision): return "Decision"
    if isinstance(node, WFLoop):     return "Loop"
    return "Unknown"

def _make_top(spec: Any) -> InterpreterState:
    st = InterpreterState(
        spec=spec,
        stack=[],
        vars=_default_vars(),
        await_input=False,
        last_task=None,
    )
    _push(st.stack, {"node": spec, "index": 0} if isinstance(spec, WFSequence) else {"node": spec})
    return st


def _serialize_state(st: InterpreterState) -> str:
    def enc(o):
        if isinstance(o, WFTask):
            return {"type": "Task", "id": o.id}
        if isinstance(o, WFLoop):
            return {"type": "Loop", "body": enc(o.body), "guard": enc(o.guard)}
        if isinstance(o, WFDecision):
            return {"type": "Decision", "options": [{"guard": enc(g), "body": enc(b)} for g, b in o.options]}
        if isinstance(o, WFSequence):
            return {"type": "Sequence", "steps": [enc(s) for s in o.steps]}
        if isinstance(o, WFGuard):
            return {"id": o.id, "negated": o.negated}
        return o

    stack_json = []
    for f in st.stack:
        f_json = {}
        for k, v in f.items():
            f_json[k] = enc(v) if k == "node" else v
        stack_json.append(f_json)

    payload = {
        "spec": enc(st.spec),
        "stack": stack_json,
        "vars": st.vars,
        "await_input": st.await_input,
        "last_task": st.last_task,
    }
    return json.dumps(payload, ensure_ascii=False)

def _deserialize_state(payload: str) -> Optional[InterpreterState]:
    try:
        raw = json.loads(payload)
        spec = _norm_node(raw["spec"])
        stack = []
        for f in raw["stack"]:
            node = _norm_node(f["node"])
            frame = dict(f); frame["node"] = node
            stack.append(frame)
        st = InterpreterState(
            spec=spec,
            stack=stack,
            vars=raw.get("vars", _default_vars()),
            await_input=bool(raw.get("await_input", False)),
            last_task=raw.get("last_task"),
        )
        return st
    except Exception:
        return None


# -----------------------------
# Shared helpers
# -----------------------------
def _do_handoff(dispatcher: CollectingDispatcher, vars: Dict[str, Any]) -> List[EventType]:
    red = "\033[31m"; yellow = "\033[33m"; reset = "\033[0m"
    if vars.pop("invalid_order_attempt", False):
        dispatcher.utter_message(text="I couldn't find a valid order number.")
    dispatcher.utter_message(text="Connecting you to a human operator now.")
    dispatcher.utter_message(text=f"{red}Chatbot left the chat{reset}")
    dispatcher.utter_message(text=f"{yellow}Please wait for an agent to connect...{reset}")
    vars.update({
        "helpNeeded": False,
        "awaiting_anything_else": False,
        "awaiting_order_number": False,
        "awaiting_menu_choice": False,
        "option:GetOrderStatus": False,
        "option:ReturnProduct": False,
    })
    return [RasaSlotSet("handoff", True)]

def _workflow_references_vars(node: Any, keys: List[str]) -> bool:
    if isinstance(node, WFGuard):
        return node.id in keys
    elif isinstance(node, WFSequence):
        return any(_workflow_references_vars(s, keys) for s in node.steps)
    elif isinstance(node, WFTask):
        return False
    elif isinstance(node, WFDecision):
        return any(
            _workflow_references_vars(g, keys) or _workflow_references_vars(b, keys)
            for g, b in node.options
        )
    elif isinstance(node, WFLoop):
        return _workflow_references_vars(node.guard, keys) or _workflow_references_vars(node.body, keys)
    return False

# -----------------------------
# Task implementations
# -----------------------------
def _emit_task(
    task_id: str,
    dispatcher: CollectingDispatcher,
    user_text: str,
    vars: Dict[str, Any],
) -> Tuple[List[EventType], bool]:
    """
    Return (events, wants_user_input_now)
    """
    events: List[EventType] = []
    wants_input = False

    red = "\033[31m"; yellow = "\033[33m"; green = "\033[32m"; reset = "\033[0m"

    # --- Conversation/UI tasks ---
    if task_id == "ReadCustomerGreeting":
        dispatcher.utter_message(text=f"{green}Chatbot has entered the chat{reset}")
        if vars.get("explainModeThorough"):
            dispatcher.utter_message(text="Welcome! I’ll provide guidance for new users so nothing gets missed. How can I assist you today?")
        else:
            dispatcher.utter_message(text="Hello! How can I assist you today?")
        wants_input = True

    elif task_id == "ProvideHelpOptions":
        # Don't show menu while we await another input phase
        if vars.get("awaiting_order_number") or vars.get("awaiting_anything_else"):
            wants_input = False
        # If an option is already chosen, continue silently
        elif vars.get("option:GetOrderStatus") or vars.get("option:ReturnProduct"):
            wants_input = False
        # If we've already shown the menu and are still waiting, don't re-send it
        elif vars.get("awaiting_menu_choice"):
            wants_input = True
        else:
            dispatcher.utter_message(text="Please select one of the following:")
            dispatcher.utter_message(text="1) Order status  2) Return a product.")
            vars["awaiting_menu_choice"] = True
            wants_input = True

    elif task_id == "AskForOrderNum":
        prefix_parts = []
        # If we already have a valid order number, skip asking again.
        if vars.get("validOrderNum") and vars.get("order_number"):
            vars["awaiting_order_number"] = False
            wants_input = False
            return events, False
        if vars.get("tone_empathetic"):
            prefix_parts.append("Thanks for bearing with me.")
        if vars.get("explainModeThorough"):
            prefix_parts.append("To get started, I’ll guide you step by step.")
        prefix = (" ".join(prefix_parts) + " ").strip() + (" " if prefix_parts else "")
        vars["order_number"] = None
        vars["validOrderNum"] = False
        vars["awaiting_order_number"] = True
        vars["awaiting_menu_choice"] = False
        dispatcher.utter_message(text=f"{prefix}Can I have your order number?")
        wants_input = True

    elif task_id == "AskIfCanHelpWithAnythingElse":
        dispatcher.utter_message(text="Anything else I can help with? (1: status / 2: return)")
        vars["awaiting_anything_else"] = True
        vars["helpNeeded"] = False
        vars["awaiting_menu_choice"] = False
        wants_input = True

    # --- Business logic outputs ---
    elif task_id == "provideOrderStatus":
        if vars.get("validOrderNum"):
            dispatcher.utter_message(text="Your order is currently being processed and will arrive soon.")
            vars["returnDenied"] = False
        else:
            dispatcher.utter_message(text="I couldn't find a valid order number. Let me connect you to an agent.")
            dispatcher.utter_message(text=f"{red}Chatbot left the chat{reset}")
            dispatcher.utter_message(text=f"{yellow}Please wait for an agent to connect...{reset}")
            events.append(RasaSlotSet("handoff", True))

    elif task_id in {"ExplainCan'tReturn", "ExplainCantReturn"}:
        dispatcher.utter_message(text="Sorry, this item isn't eligible for return based on our policy.")
        vars["returnDenied"] = True

    elif task_id == "ExplainHowToReturn":
        dispatcher.utter_message(text=(
            "Here’s how to return your item:\n"
            "1) Log in to your account and open **Orders**.\n"
            "2) Select the item and click **Start a return**.\n"
            "3) Choose a reason and confirm.\n"
            "4) Print the label or show the QR code at the drop-off.\n"
            "5) Keep the receipt — refund is processed after we receive the item."
        ))
        vars["returnDenied"] = False
        wants_input = False

    # --- Meta/system tasks ---
    elif task_id == "PassOntoHumanOperator":
        events.extend(_do_handoff(dispatcher, vars))
        return events, False

    elif task_id == "RedactInformation":
        dispatcher.utter_message(text="For your safety, please avoid sharing personal contact details here.")
        vars["personalInfo"] = False  # reset after warning

    elif task_id == "WarnNotToProvidePersonalInfo":
        dispatcher.utter_message(text="Reminder: Please do not share personal information in chat.")

    elif task_id == "ExplainLegalRights":
        dispatcher.utter_message(text="Note: You may still have statutory rights depending on your location.")

    elif task_id == "SetSympatheticTone":
        # If we've already set the tone, don't repeat the message
        if vars.get("tone_empathetic"):
            return events, False
        vars["tone_empathetic"] = True
        dispatcher.utter_message(
            text="I’m really sorry this has been frustrating. I’m here to help and we’ll sort this out together."
        )
        wants_input = False

    elif task_id == "WarnUser":
        dispatcher.utter_message(
            text="Let me get a human specialist to deal with this issue promptly."
        )
        wants_input = False

    # --- FirstTimeUser support tasks ---
    elif task_id == "SetMoreThoroughExplanationMode":
        # Enable extra explanations in subsequent prompts
        vars["explainModeThorough"] = True
        wants_input = False
    
    elif task_id == "MarkNewUserOnLoad":
        vars["newUser"] = True
        # Optionally enable thorough mode right away:
        vars["explainModeThorough"] = True
        wants_input = False

    elif task_id == "Apologise":
        # When returns are not possible and the DSL didn't route to human automatically
        dispatcher.utter_message(
            text="I’m sorry for the inconvenience. If you’d like, I can ask a specialist to review this."
        )
        wants_input = False

    elif task_id == "ReadResponse":
        # 1) PII check
        if looks_like_personal_info(user_text):
            vars["personalInfo"] = True

        # 1.1) Human request — allow only after invalid order OR (new user AND return denied)
        if wants_agent(user_text):
            vars["userRequestsHumanOperator"] = True
            allowed = bool(vars.get("invalid_order_attempt")) or (bool(vars.get("newUser")) and bool(vars.get("returnDenied")))
            if allowed:
                events.extend(_do_handoff(dispatcher, vars))
                return events, False

            # Not allowed yet → deflect politely
            if not vars.get("validOrderNum"):
                if not vars.get("awaiting_order_number"):
                    dispatcher.utter_message(
                        text="I can connect you to a specialist right after we look up your order. "
                            "Could you share your order number?"
                    )
                vars["awaiting_order_number"] = True
                vars["awaiting_menu_choice"] = False
                vars["awaiting_anything_else"] = False
                vars["option:GetOrderStatus"] = False
                vars["option:ReturnProduct"] = False
                return events, True
            else:
                if not vars.get("newUser"):
                    dispatcher.utter_message(
                        text="Speaking to a human agent is not possible at this time."
                    )
                    dispatcher.utter_message(
                        text="Is there anything else I can help you with? (1: status / 2: return)"
                    )
                    vars["awaiting_anything_else"] = True
                    vars["awaiting_menu_choice"] = False
                    vars["helpNeeded"] = False
                elif not vars.get("awaiting_menu_choice") and not vars.get("awaiting_anything_else"):
                    dispatcher.utter_message(
                        text="Let’s first finish checking what I can do here. "
                            "If it isn’t eligible for return, I’ll bring in a specialist."
                    )
                    dispatcher.utter_message(text="Please select one of the following:")
                    dispatcher.utter_message(text="1) Order status  2) Return a product.")
                    vars["awaiting_menu_choice"] = True
                    vars["awaiting_anything_else"] = False
                    vars["helpNeeded"] = True
                return events, True

        # 2) If we are currently expecting ONLY an order number, treat this turn as such
        if vars.get("awaiting_order_number"):
            num = extract_order_number(user_text)
            vars["order_number"] = num if num else None
            vars["validOrderNum"] = bool(num)
            vars["awaiting_order_number"] = False
            vars["invalid_order_attempt"] = not bool(num)

            if not vars["validOrderNum"]:
                # Now you ARE allowed to hand off (policy)
                events.extend(_do_handoff(dispatcher, vars))
                return events, False

            # Valid number: show the menu immediately so there’s no silent turn
            if not (vars.get("option:GetOrderStatus") or vars.get("option:ReturnProduct")):
                dispatcher.utter_message(text="Please select one of the following:")
                dispatcher.utter_message(text="1) Order status  2) Return a product.")
                vars["awaiting_menu_choice"] = True
                return events, True

            return events, False

        # 3) If we were at the "anything else?" prompt
        if vars.get("awaiting_anything_else") and is_no(user_text):
            dispatcher.utter_message(text="Thank you for contacting us.")
            dispatcher.utter_message(text=f"{red}Chatbot left the chat{reset}")
            vars["helpNeeded"] = False
            return events, False

        if vars.get("awaiting_anything_else") and is_yes(user_text):
            vars["awaiting_anything_else"] = False
            vars["helpNeeded"] = True

        # 4) Otherwise this turn is a menu/intent turn
        choice = interpret_menu_choice(user_text)
        if choice is not None:
            vars["option:GetOrderStatus"] = (choice == "status")
            vars["option:ReturnProduct"]  = (choice == "return")
            vars["awaiting_menu_choice"] = False
            if vars.get("awaiting_anything_else"):
                vars["awaiting_anything_else"] = False
                vars["helpNeeded"] = True

        # 5) Opportunistic capture of numbers even in menu turns
        num2 = extract_order_number(user_text)
        if num2:
            vars["order_number"] = num2
            vars["validOrderNum"] = True

        wants_input = False

    else:
        # Unknown task id: no-op keeps engine robust
        wants_input = False

    return events, wants_input


# -----------------------------
# Engine: advance one step
# -----------------------------
def _advance_once(
    dispatcher: CollectingDispatcher,
    st: InterpreterState,
    user_text: str,
) -> Tuple[List[EventType], bool, Optional[str]]:
    events: List[EventType] = []

    while st.stack:
        frame = st.stack[-1]
        node = frame["node"]
        kind = _node_kind(node)

        if kind == "Sequence":
            seq: WFSequence = node  # type: ignore
            idx = frame.get("index", 0)
            if idx >= len(seq.steps):
                _pop(st.stack); continue
            step = seq.steps[idx]
            frame["index"] = idx + 1

            if isinstance(step, WFTask):
                task_events, wants_input = _emit_task(step.id, dispatcher, user_text, st.vars)
                events.extend(task_events)
                st.last_task = step.id

                # >>> NEW: stop immediately if a handoff was triggered
                if any(_is_handoff_event(e) for e in task_events):
                    st.await_input = False
                    st.stack.clear()
                    return events, False, step.id
                # <<<

                if wants_input:
                    st.await_input = True
                    return events, True, step.id
                continue

            if isinstance(step, WFSequence):
                _push(st.stack, {"node": step, "index": 0}); continue

            if isinstance(step, WFLoop):
                _push(st.stack, {"node": step, "phase": None}); continue

            if isinstance(step, WFDecision):
                chosen = None
                for g, b in step.options:
                    if _eval_guard(g, st.vars):
                        chosen = b; break
                if chosen is None:
                    continue
                _push(st.stack, {"node": chosen}); continue

            continue

        if kind == "Task":
            task: WFTask = node  # type: ignore
            task_events, wants_input = _emit_task(task.id, dispatcher, user_text, st.vars)
            events.extend(task_events)
            st.last_task = task.id
            _pop(st.stack)

            # >>> NEW: stop immediately if a handoff was triggered
            if any(_is_handoff_event(e) for e in task_events):
                st.await_input = False
                st.stack.clear()
                return events, False, task.id
            # <<<

            if wants_input:
                st.await_input = True
                return events, True, task.id
            continue

        if kind == "Decision":
            dec: WFDecision = node  # type: ignore
            chosen = None
            for g, b in dec.options:
                if _eval_guard(g, st.vars):
                    chosen = b; break
            if chosen is None:
                _pop(st.stack); continue
            frame["node"] = chosen
            continue

        if kind == "Loop":
            lp: WFLoop = node  # type: ignore
            phase = frame.get("phase")
            if phase is None:
                frame["phase"] = "body"
                if isinstance(lp.body, WFSequence):
                    _push(st.stack, {"node": lp.body, "index": 0})
                else:
                    _push(st.stack, {"node": lp.body})
                continue
            if phase == "body":
                if _eval_guard(lp.guard, st.vars):
                    if isinstance(lp.body, WFSequence):
                        _push(st.stack, {"node": lp.body, "index": 0})
                    else:
                        _push(st.stack, {"node": lp.body})
                    continue
                _pop(st.stack); continue
            _pop(st.stack); continue

        _pop(st.stack); continue

    return events, False, st.last_task


def _can_set_slot(tracker: Tracker, slot_name: str) -> bool:
    return slot_name in (tracker.slots or {})

def _is_handoff_event(e: EventType) -> bool:
    """
    True if 'e' is effectively SlotSet('handoff', True), for dict or SDK events.
    """
    if isinstance(e, dict):
        return e.get("event") == "slot" and e.get("name") == "handoff" and bool(e.get("value"))
    name = getattr(e, "event_name", None)
    if callable(name):
        try:
            if name() == "slot" and getattr(e, "key", None) == "handoff" and bool(getattr(e, "value", None)):
                return True
        except Exception:
            pass
    if getattr(e, "key", None) == "handoff" and bool(getattr(e, "value", None)):
        return True
    return False


# -----------------------------
# Rasa Action
# -----------------------------
class ActionHandleQuestion(Action):
    def name(self) -> str:
        return "action_handle_question"

    def _load_profile(self, tracker: Tracker) -> Tuple[str, Any]:
        """
        Always load the active workflowspec from disk.
        Returns (active_name, normalized_spec).
        """
        if load_workflow is None or resolve_active_workflow is None:
            return "unknown", _norm_node({"type": "Sequence", "steps": []})

        try:
            active_name, _ = resolve_active_workflow(None)   # pick active file
            spec_dict = load_workflow(active_name)           # parse that exact file
            spec_node = _norm_node(spec_dict)

             # Check if workflow references newUser
            if _workflow_references_vars(spec_node, ["newUser", "explainModeThorough"]):
                spec_node = WFSequence(steps=[WFTask(id="MarkNewUserOnLoad"), spec_node])

            return active_name, spec_node
        except Exception as e:
            print(f"[WF] Loader error: {e}")
            return "unknown", _norm_node({"type": "Sequence", "steps": []})

    def run(self, dispatcher: CollectingDispatcher, tracker: Tracker, domain: Dict[str, Any]) -> List[EventType]:
        text: str = (tracker.latest_message.get("text") or "").strip()
        intent = tracker.latest_message.get("intent", {}).get("name")

        # --- Allow resuming even if in handoff ---
        if tracker.get_slot("handoff") and intent != "resume_bot":
            return []

        # --- Resume intent: clear handoff + reset workflow and greet ---
        if intent == "resume_bot":
            evs: List[EventType] = [RasaSlotSet("handoff", False), RasaSlotSet("wf_state", None)]
            name, spec = self._load_profile(tracker)
            st = _make_top(spec)

            while True:
                extra_events, waiting, _ = _advance_once(dispatcher, st, user_text="")
                evs.extend(extra_events)
                if waiting or not st.stack:
                    break

            evs.append(RasaSlotSet("wf_state", _serialize_state(st)))
            if _can_set_slot(tracker, "active_workflow"):
                evs.append(RasaSlotSet("active_workflow", name))
            return evs

        # --- Load or resume interpreter state ---
        st: Optional[InterpreterState] = None
        current_state_raw = tracker.get_slot("wf_state")
        if current_state_raw:
            st = _deserialize_state(current_state_raw)

        if st is None:
            # First entry: load active workflow and advance until input is needed.
            name, spec = self._load_profile(tracker)
            st = _make_top(spec)

            # PRIME frustration on the very first user text
            first_text = (tracker.latest_message.get("text") or "").strip()
            st.vars["userFrustrated"] = looks_frustrated(first_text)

            events_out: List[EventType] = []
            while True:
                extra_events, waiting, _ = _advance_once(dispatcher, st, user_text="")
                events_out.extend(extra_events)
                if waiting or not st.stack:
                    break

            serialized = _serialize_state(st)
            events_out.append(RasaSlotSet("wf_state", serialized))
            if _can_set_slot(tracker, "active_workflow"):
                events_out.append(RasaSlotSet("active_workflow", name))
            return events_out

        # --- Normal turn: feed user text, advance until needs input or halts ---
        events_out: List[EventType] = []
        st.await_input = False  # we are providing input now

        # PRIME frustration flag so SetSympatheticTone decisions (before ReadResponse) can see it
        if text and looks_frustrated(text):
            st.vars["userFrustrated"] = True

        extra_events, waiting, _ = _advance_once(dispatcher, st, user_text=text)
        events_out.extend(extra_events)

        # If we handed off, end the workflow right away (no more messages).
        if any(_is_handoff_event(e) for e in extra_events):
            if _can_set_slot(tracker, "handoff"):
                events_out.append(RasaSlotSet("handoff", True))
            events_out.append(RasaSlotSet("wf_state", None))
            return events_out

        if waiting:
            serialized = _serialize_state(st)
            events_out.append(RasaSlotSet("wf_state", serialized))
            return events_out

        # Keep executing until a task asks for input or program ends
        while st.stack:
            extra_events2, waiting2, _ = _advance_once(dispatcher, st, user_text="")
            events_out.extend(extra_events2)

            if any(_is_handoff_event(e) for e in extra_events2):
                if _can_set_slot(tracker, "handoff"):
                    events_out.append(RasaSlotSet("handoff", True))
                events_out.append(RasaSlotSet("wf_state", None))
                return events_out

            if waiting2:
                break

        # Save / finish
        if st.stack:
            serialized = _serialize_state(st)
            events_out.append(RasaSlotSet("wf_state", serialized))
        else:
            events_out.append(RasaSlotSet("wf_state", None))

        if _can_set_slot(tracker, "handoff") and any(_is_handoff_event(e) for e in events_out):
            events_out.append(RasaSlotSet("handoff", True))

        return events_out