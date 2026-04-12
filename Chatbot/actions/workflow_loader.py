# actions/workflow_loader.py
import os
import json
import re
from glob import glob
from typing import Any, Dict, Optional, Tuple, List

WORKFLOW_DIR = os.environ.get("WORKFLOW_DIR")  # optional override
DEFAULT_DIR_NAMES = ["MAPE-K/base_workflow", "."]

# ---------- Dir resolution ----------

def find_workflow_dir() -> str:
    if WORKFLOW_DIR and os.path.isdir(WORKFLOW_DIR):
        return WORKFLOW_DIR

    here = os.getcwd()
    candidates = [
        os.path.join(here, "MAPE-K", "base_workflow"),
        os.path.join(here, "workflows"),
        os.path.join(here, "actions", "workflows"),
        here,
    ]

    for cand in candidates:
        if os.path.isdir(cand):
            for fn in os.listdir(cand):
                if fn.endswith(".workflowspec"):
                    return cand

    return os.path.join(here, "MAPE-K", "base_workflow")


def _read_file(path: str) -> str:
    with open(path, "r", encoding="utf-8") as f:
        return f.read()

# ---------- Active-file resolver ----------

def resolve_active_workflow(name: Optional[str] = None) -> Tuple[str, str]:
    """
    Decide which .workflowspec to load.
    Returns (file_stem_without_ext, absolute_path).
    Selection order if 'name' is None:
      1) env WORKFLOW_ACTIVE (stem)
      2) active.workflowspec in the folder
      3) if exactly one *.workflowspec file, use it
      4) otherwise use the most recently modified *.workflowspec
    """
    base = find_workflow_dir()

    # Explicit name wins
    if name:
        path = os.path.join(base, f"{name}.workflowspec")
        if not os.path.isfile(path):
            raise FileNotFoundError(f"Workflow file not found: {path}")
        print(f"[WORKFLOW LOADER] Using workflow file: {path}")
        return name, path

    # Env var
    env_name = os.environ.get("WORKFLOW_ACTIVE")
    if env_name:
        p = os.path.join(base, f"{env_name}.workflowspec")
        if os.path.isfile(p):
            print(f"[WORKFLOW LOADER] Using workflow file: {p}")
            return env_name, p

    # active.workflowspec
    active = os.path.join(base, "active.workflowspec")
    if os.path.isfile(active):
        print(f"[WORKFLOW LOADER] Using workflow file: {active}")
        return "active", active

    # Files in folder
    files = sorted(glob(os.path.join(base, "*.workflowspec")), key=os.path.getmtime, reverse=True)
    if not files:
        raise FileNotFoundError(f"No .workflowspec files found under {base}")

    if len(files) == 1:
        stem = os.path.splitext(os.path.basename(files[0]))[0]
        print(f"[WORKFLOW LOADER] Using workflow file: {files[0]}")
        return stem, files[0]

    newest = files[0]
    stem = os.path.splitext(os.path.basename(newest))[0]
    print(f"[WORKFLOW LOADER] Using workflow file: {newest}")
    return stem, newest

# ---------- Public API: load ONE workflowspec (name optional) ----------

def load_workflow(name: Optional[str] = None) -> Dict[str, Any]:
    """
    Loads and parses one workflowspec (by name or using the active-file resolver).
    Returns a normalized dict: {"type":"Sequence","steps":[...]}.
    Raises FileNotFoundError or ValueError if not found/invalid.
    """
    _, path = resolve_active_workflow(name)
    text = _read_file(path)
    parsed = parse_workflowspec(text)
    if not isinstance(parsed, dict) or not parsed.get("type"):
        raise ValueError(f"Workflow parsed but invalid top structure in {path}")
    return parsed

# ---------- DSL Parser (depth-aware & robust) ----------

def parse_workflowspec(text: str) -> Dict[str, Any]:
    src = _strip_comments(text).strip()

    # allow raw JSON for convenience
    try:
        maybe = json.loads(src)
        if isinstance(maybe, dict) and "type" in maybe:
            return maybe
    except Exception:
        pass

    m = re.search(r"\bWorkflowStructure\s*\{", src)
    if not m:
        raise ValueError("Top-level 'WorkflowStructure { ... }' not found.")

    block, _ = _extract_block(src, m.end() - 1)
    k = re.search(r"\bworkflowspec\s+Sequence\s*\{", block)
    if not k:
        raise ValueError("Expected 'workflowspec Sequence { ... }'")

    seq_block, _ = _extract_block(block, k.end() - 1)
    return _parse_sequence_block(seq_block)

def _parse_sequence_block(seq_block: str) -> Dict[str, Any]:
    sub = _find_top_level_block(seq_block, "subworkflows")
    if not sub:
        return {"type": "Sequence", "steps": []}
    inner, _ = sub

    steps: List[Dict[str, Any]] = []
    pos = 0
    while True:
        nxt = _find_top_level_keyword(inner, ["Task", "Loop", "Decision"], pos)
        if not nxt:
            break
        kind, start = nxt
        brace = inner.find("{", start)
        if brace < 0:
            raise ValueError(f"Expected '{{' after {kind}")
        child_block, end_i = _extract_block(inner, brace)

        if kind == "Task":
            steps.append(_parse_task_block(child_block))
        elif kind == "Loop":
            steps.append(_parse_loop_block(child_block))
        elif kind == "Decision":
            steps.append(_parse_decision_block(child_block))

        pos = end_i
    return {"type": "Sequence", "steps": steps}

def _parse_task_block(task_block: str) -> Dict[str, Any]:
    m = re.search(r'\bID\s*"([^"]+)"', task_block)
    if not m:
        raise ValueError("Task block missing ID")
    return {"type": "Task", "id": m.group(1)}

def _parse_loop_block(loop_block: str) -> Dict[str, Any]:
    gw = _find_top_level_block(loop_block, "GuardedWorkflow")
    if not gw:
        body_kind_inner = _find_top_level_body(loop_block)
        if body_kind_inner:
            body = _parse_body_by_kind(body_kind_inner)
        else:
            body = {"type": "Sequence", "steps": []}
        guard = _find_top_level_guard(loop_block) or {"id": "TRUE", "negated": False}
        return {"type": "Loop", "body": body, "guard": guard}

    gw_block, _ = gw

    body_kind_inner = _find_top_level_body(gw_block)
    if body_kind_inner:
        body = _parse_body_by_kind(body_kind_inner)
    else:
        body = {"type": "Sequence", "steps": []}

    guard = _find_top_level_guard(gw_block) or {"id": "TRUE", "negated": False}
    return {"type": "Loop", "body": body, "guard": guard}

def _parse_body_by_kind(kind_inner: Tuple[str, str]) -> Dict[str, Any]:
    kind, inner = kind_inner
    if kind == "Sequence":
        return _parse_sequence_block(inner)
    if kind == "Task":
        return _parse_task_block(inner)
    if kind == "Decision":
        return _parse_decision_block(inner)
    return {"type": "Sequence", "steps": []}

def _parse_decision_block(dec_block: str) -> Dict[str, Any]:
    options: List[Dict[str, Any]] = []
    sub = _find_top_level_block(dec_block, "options")
    if not sub:
        return {"type": "Decision", "options": options}
    opt_block, _ = sub

    pos = 0
    while True:
        gw = _find_top_level_block(opt_block, "GuardedWorkflow", pos)
        if not gw:
            break
        gw_block, end_i = gw

        body_kind_inner = _find_top_level_body(gw_block)
        if body_kind_inner:
            body_node = _parse_body_by_kind(body_kind_inner)
        else:
            body_node = {"type": "Sequence", "steps": []}

        guard = _find_top_level_guard(gw_block) or {"id": "TRUE", "negated": False}

        options.append({"guard": guard, "body": body_node})
        pos = end_i

    return {"type": "Decision", "options": options}

# ---------- depth-aware helpers ----------

def _scan_top_level(s: str, start_idx: int = 0):
    token_re = re.compile(r'\b(Task|Loop|Decision|GuardedWorkflow|body|guard|options|subworkflows)\b')
    depth = 0
    i = start_idx
    n = len(s)
    while i < n:
        c = s[i]
        if c == '{':
            depth += 1
            i += 1
            continue
        if c == '}':
            depth -= 1
            i += 1
            continue
        if depth == 0:
            m = token_re.match(s, i)
            if m:
                yield (m.group(1), i)
                i = m.end()
                continue
        i += 1

def _find_top_level_keyword(s: str, keywords: list, pos: int = 0) -> Optional[Tuple[str, int]]:
    for tok, idx in _scan_top_level(s, start_idx=pos):
        if tok in keywords:
            return tok, idx
    return None

def _find_top_level_block(s: str, kw: str, pos: int = 0) -> Optional[Tuple[str, int]]:
    for tok, idx in _scan_top_level(s, start_idx=pos):
        if tok == kw:
            brace_start = s.find('{', idx)
            if brace_start == -1:
                raise ValueError(f"Expected '{{' after {kw}")
            inner, end_i = _extract_block(s, brace_start)
            return inner, end_i
    return None

def _find_top_level_guard(block: str) -> Optional[Dict[str, Any]]:
    guard_idx = None
    for tok, idx in _scan_top_level(block, 0):
        if tok == 'guard':
            guard_idx = idx
            break
    if guard_idx is None:
        return None

    m = re.search(r'\b(Atom|Not)\s*\{', block[guard_idx:])
    if not m:
        return None
    kind = m.group(1)
    brace_start = guard_idx + m.start(0) + m.group(0).find('{')
    g_block, _ = _extract_block(block, brace_start)

    mm = re.search(r'\bmeasureID\s*"([^"]+)"', g_block)
    if not mm:
        return None
    if kind == "Atom":
        return {"id": mm.group(1), "negated": False}
    else:
        return {"id": mm.group(1), "negated": True}

def _find_top_level_body(block: str) -> Optional[Tuple[str, str]]:
    body_idx = None
    for tok, idx in _scan_top_level(block, 0):
        if tok == 'body':
            body_idx = idx
            break
    if body_idx is None:
        return None

    m = re.search(r'\b(Sequence|Task|Decision)\s*\{', block[body_idx:])
    if not m:
        return None
    kind = m.group(1)
    brace_start = body_idx + m.start(0) + m.group(0).find('{')
    inner, _ = _extract_block(block, brace_start)
    return kind, inner

# ---------- legacy helpers kept for compatibility ----------

def _strip_comments(s: str) -> str:
    return re.sub(r"//.*", "", s)

def _extract_block(s: str, brace_start_index: int) -> Tuple[str, int]:
    start = s.find("{", brace_start_index)
    if start < 0:
        raise ValueError("Expected '{'")
    depth = 0
    i = start
    n = len(s)
    while i < n:
        if s[i] == "{":
            depth += 1
        elif s[i] == "}":
            depth -= 1
            if depth == 0:
                return s[start + 1 : i], i + 1
        i += 1
    raise ValueError("Unbalanced braces")