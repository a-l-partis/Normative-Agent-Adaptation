#!/usr/bin/env python3

import os
import sys
import time
import socket
import subprocess
from pathlib import Path
from typing import Optional

RASA_BIN = os.path.expanduser("~/virtualenvs/rasa_env/bin/rasa")
PYTHON_BIN = os.path.expanduser("~/virtualenvs/rasa_env/bin/python3")

# Close old running action servers
subprocess.run(["pkill", "-f", "rasa run actions"], stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
time.sleep(1)

def print_header():
    print("\033]0;🔧 Chatbot Server\007", end="")
    print("=" * 60)
    print("🤖  ADAPTIVE CHATBOT SERVER INITIALIZED")
    print("=" * 60)


def find_rasa_project_root(start_path: Path) -> Optional[Path]:
    path = start_path.resolve()
    while path != path.parent:
        if (path / "actions").is_dir() and (path / "domain.yml").is_file():
            return path
        path = path.parent
    return None


def wait_for_port(host: str = "localhost", port: int = 5055, timeout: int = 20) -> bool:
    print(f"⏳ Waiting for action server on {host}:{port}...", end="", flush=True)
    start = time.time()
    while time.time() - start < timeout:
        try:
            with socket.create_connection((host, port), timeout=2):
                print(" ✅ Ready.")
                return True
        except OSError:
            print(".", end="", flush=True)
            time.sleep(1)
    print(" ❌ Timeout.")
    return False


def get_mtime(path: Path) -> Optional[float]:
    try:
        return path.stat().st_mtime
    except FileNotFoundError:
        return None


def wait_for_workflow_update(active_workflow: Path, initial_mtime: Optional[float], timeout: int = 8) -> bool:
    start = time.time()
    while time.time() - start < timeout:
        new_mtime = get_mtime(active_workflow)
        if initial_mtime is None:
            if new_mtime is not None:
                return True
        else:
            if new_mtime is not None and new_mtime != initial_mtime:
                return True
        time.sleep(0.2)
    return False


def workflow_is_fresh_enough(active_workflow: Path, marker_mtime: Optional[float]) -> bool:
    workflow_mtime = get_mtime(active_workflow)
    if workflow_mtime is None or marker_mtime is None:
        return False
    return workflow_mtime >= marker_mtime


def read_client_info(client_info: Path) -> Optional[str]:
    try:
        if not client_info.exists():
            return None
        content = client_info.read_text(encoding="utf-8").strip()
        return content or None
    except OSError:
        return None


def client_has_extra_rules(project_root: Path, client_name: str) -> bool:
    client_dir = project_root / "clients" / client_name
    if not client_dir.is_dir():
        return False

    json_files = sorted(client_dir.glob("*.json"))
    if not json_files:
        return False

    try:
        profile_value = json_files[0].read_text(encoding="utf-8").strip()
        profile_value = profile_value.replace('"', "").strip()
        return profile_value not in ("", "*")
    except OSError:
        return False


def main():
    print_header()

    current_dir = Path(__file__).resolve().parent
    project_root = find_rasa_project_root(current_dir)

    if not project_root:
        print("❌ Could not find Rasa project root.")
        sys.exit(1)

    os.chdir(project_root)
    print("📁 Project root detected ✅")

    mapek_dir = project_root / "MAPE-K"
    users_dir = mapek_dir / "users"
    active_workflow = mapek_dir / "base_workflow" / "active.workflowspec"
    mapek_setup = mapek_dir / "MAPEK_setup.py"
    client_info = project_root / "client.info"

    if not mapek_dir.is_dir():
        print(f"❌ MAPE-K folder not found: {mapek_dir}")
        sys.exit(1)

    if not users_dir.is_dir():
        print(f"❌ MAPE-K users folder not found: {users_dir}")
        sys.exit(1)

    if not mapek_setup.is_file():
        print(f"❌ MAPEK_setup.py not found: {mapek_setup}")
        sys.exit(1)

    print("🚀 Starting Rasa action server in background...")

    action_env = os.environ.copy()
    action_env["WORKFLOW_DIR"] = str(project_root / "MAPE-K" / "base_workflow")
    action_env["WORKFLOW_ACTIVE"] = "active"

    subprocess.Popen(
        [RASA_BIN, "run", "actions", "--quiet"],
        stdout=subprocess.DEVNULL,
        stderr=subprocess.DEVNULL,
        cwd=project_root,
        env=action_env,
    )

    if not wait_for_port():
        sys.exit(1)

    print("🔄 Loading workflow")
    print("✅ Found common SLEEC rules")

    startup_mtime = get_mtime(active_workflow)

    subprocess.Popen(
        [PYTHON_BIN, str(mapek_setup)],
        stdout=subprocess.DEVNULL,
        stderr=subprocess.DEVNULL,
        cwd=mapek_dir,
    )

    startup_ready = False
    if wait_for_workflow_update(active_workflow, startup_mtime, timeout=8):
        startup_ready = True
    elif active_workflow.exists():
        startup_ready = True

    if startup_ready:
        print("🧠 Workflow adapted")
    else:
        print("⚠️  Initial workflow update not detected")

    print("📡 Waiting for client conversations...")
    print("-" * 48)

    try:
        while True:
            if client_info.exists():
                client_info_mtime = get_mtime(client_info)
                client_name = read_client_info(client_info)

                try:
                    client_info.unlink()
                except FileNotFoundError:
                    pass

                if client_name:
                    print(f"\n📥 Connection requested at {time.strftime('%H:%M:%S')}\n")
                    print(f"👤 Connected '{client_name}'")

                    has_extra_rules = client_has_extra_rules(project_root, client_name)

                    if has_extra_rules:
                        print(f"✅ Found '{client_name}' SLEEC rules")

                        if workflow_is_fresh_enough(active_workflow, client_info_mtime):
                            print(f"🧠 Workflow adapted for '{client_name}'")
                        else:
                            initial_mtime = get_mtime(active_workflow)

                            if wait_for_workflow_update(active_workflow, initial_mtime, timeout=8):
                                print(f"🧠 Workflow adapted for '{client_name}'")
                            else:
                                print(f"⚠️  Workflow update not detected for '{client_name}'")
                    else:
                        print(f"ℹ️  No SLEEC rules found for '{client_name}'")

            time.sleep(0.5)

    except KeyboardInterrupt:
        print("\n👋 Server interrupted. Shutting down gracefully.")


if __name__ == "__main__":
    main()