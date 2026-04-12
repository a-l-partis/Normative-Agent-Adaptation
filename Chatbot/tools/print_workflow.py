import sys
from typing import Any, Dict, List, Tuple

try:
    from .safe_loader import load_workflow_only   
except ImportError:
    from safe_loader import load_workflow_only   

def norm_guard(g: Dict[str, Any]) -> Tuple[str, bool]:
    return g.get("id", "TRUE"), bool(g.get("negated", False))

def walk(node: Dict[str, Any], indent: int = 0):
    pad = "  " * indent
    t = node.get("type")
    if t == "Task":
        print(f"{pad}Task: {node.get('id')}")
        return

    if t == "Sequence":
        steps = node.get("steps", [])
        print(f"{pad}Sequence[{len(steps)}]")
        for s in steps:
            walk(s, indent + 1)
        return

    if t == "Loop":
        guard = node.get("guard", {})
        gid, neg = norm_guard(guard)
        print(f"{pad}Loop (guard: {'NOT ' if neg else ''}{gid})")
        body = node.get("body", {"type": "Sequence", "steps": []})
        walk(body, indent + 1)
        return

    if t == "Decision":
        opts = node.get("options", [])
        print(f"{pad}Decision (options: {len(opts)})")
        for i, opt in enumerate(opts):
            gid, neg = norm_guard(opt.get("guard", {}))
            print(f"{pad}  ├─ Option[{i}] guard: {'NOT ' if neg else ''}{gid}")
            walk(opt.get("body", {"type": "Sequence", "steps": []}), indent + 2)
        return

    print(f"{pad}{t or 'UNKNOWN'}: {node}")

def list_guards(node: Dict[str, Any], out: set):
    t = node.get("type")
    if t == "Loop":
        g = node.get("guard", {})
        if "id" in g:
            out.add(("!" if g.get("negated") else "") + g["id"])
        list_guards(node.get("body", {}), out)
    elif t == "Decision":
        for opt in node.get("options", []):
            g = opt.get("guard", {})
            if "id" in g:
                out.add(("!" if g.get("negated") else "") + g["id"])
            list_guards(opt.get("body", {}), out)
    elif t == "Sequence":
        for s in node.get("steps", []):
            list_guards(s, out)

def list_tasks(node: Dict[str, Any], out: List[str]):
    t = node.get("type")
    if t == "Task":
        out.append(node.get("id"))
    elif t == "Sequence":
        for s in node.get("steps", []):
            list_tasks(s, out)
    elif t == "Loop":
        list_tasks(node.get("body", {}), out)
    elif t == "Decision":
        for opt in node.get("options", []):
            list_tasks(opt.get("body", {}), out)

def main():
    if len(sys.argv) < 2:
        print("Usage: python -m tools.print_workflow <WorkflowName>")
        sys.exit(2)

    wf_name = sys.argv[1]
    load_workflow = load_workflow_only()
    spec = load_workflow(wf_name)  # raw dict from your workflow_loader

    print(f"[OK] Loaded workflow '{wf_name}'.\n")
    print("=== WORKFLOW TREE ===")
    walk(spec, 0)

    # summaries
    guards = set()
    list_guards(spec, guards)
    tasks: List[str] = []
    list_tasks(spec, tasks)
    loops = sum(1 for _ in guards if _ == _)  # dummy, we’ll count below

    def count_type(node: Dict[str, Any], tp: str) -> int:
        t = node.get("type")
        cnt = 1 if t == tp else 0
        if t == "Sequence":
            return cnt + sum(count_type(s, tp) for s in node.get("steps", []))
        if t == "Loop":
            return cnt + count_type(node.get("body", {}), tp)
        if t == "Decision":
            return cnt + sum(count_type(opt.get("body", {}), tp) for opt in node.get("options", []))
        return cnt

    print("\n=== SUMMARY ===")
    print(f"Tasks: {len(tasks)} → {tasks}")
    print(f"Decisions: {count_type(spec,'Decision')}, Loops: {count_type(spec,'Loop')}")
    print("Guards discovered:")
    for g in sorted(guards):
        print(f"  - {g}")

if __name__ == "__main__":
    main()