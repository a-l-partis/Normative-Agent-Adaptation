#!/bin/bash

# === Try to activate virtualenv (optional) ===
VENV_PATH="$HOME/virtualenvs/rasa_env"

if [ -f "$VENV_PATH/bin/activate" ]; then
  source "$VENV_PATH/bin/activate"
else
  echo "⚠️  Virtualenv not found at $VENV_PATH"
  echo "⚠️  Proceeding with system Python/Rasa..."
fi

# --- Resolve paths ---
SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
CLIENT_NAME="$(basename "$SCRIPT_DIR")"
PROJECT_ROOT="$(cd "$SCRIPT_DIR/../.." && pwd)"
MAPEK_DIR="$PROJECT_ROOT/MAPE-K"
USERS_DIR="$MAPEK_DIR/users"
ACTIVE_WORKFLOW="$MAPEK_DIR/base_workflow/active.workflowspec"
CLIENT_INFO="$PROJECT_ROOT/client.info"

echo "=============================================="
echo " 💬 Starting chat for '$CLIENT_NAME'"
echo "=============================================="

# --- Validate MAPE-K users directory ---
if [ ! -d "$USERS_DIR" ]; then
  echo "❌ MAPE-K users folder not found at:"
  echo "  $USERS_DIR"
  exit 1
fi

# --- Find exactly one JSON profile in this client folder ---
JSON_FILES=$(find "$SCRIPT_DIR" -maxdepth 1 -type f -name "*.json" | sort)
JSON_COUNT=$(printf "%s\n" "$JSON_FILES" | sed '/^$/d' | wc -l | tr -d ' ')

if [ "$JSON_COUNT" -eq 0 ]; then
  echo "❌ No .json profile found in $SCRIPT_DIR"
  exit 1
fi

if [ "$JSON_COUNT" -gt 1 ]; then
  echo "❌ Multiple .json profiles found in $SCRIPT_DIR"
  printf "%s\n" "$JSON_FILES"
  echo "Keep exactly one .json file per client folder."
  exit 1
fi

PROFILE_JSON="$JSON_FILES"
PROFILE_BASENAME="$(basename "$PROFILE_JSON")"

# --- Capture current workflow hash before triggering MAPE-K ---
OLD_HASH=""
if [ -f "$ACTIVE_WORKFLOW" ]; then
  OLD_HASH="$(shasum "$ACTIVE_WORKFLOW" 2>/dev/null | awk '{print $1}')"
fi

# --- Trigger MAPE-K by replacing the active user file ---
rm -f "$USERS_DIR"/*.json
cp "$PROFILE_JSON" "$USERS_DIR/"

# --- Tell server which client launched ---
printf "%s\n" "$CLIENT_NAME" > "$CLIENT_INFO"

# --- Wait for workflow adaptation to complete (hash-based) ---
UPDATED=0
for _ in $(seq 1 40); do
  if [ -f "$ACTIVE_WORKFLOW" ]; then
    NEW_HASH="$(shasum "$ACTIVE_WORKFLOW" 2>/dev/null | awk '{print $1}')"
    if [ -n "$NEW_HASH" ] && [ "$NEW_HASH" != "$OLD_HASH" ]; then
      UPDATED=1
      break
    fi
  fi
  sleep 0.25
done

# --- Resolve rasa command ---
if [ -x "$VENV_PATH/bin/rasa" ]; then
  RASA_CMD="$VENV_PATH/bin/rasa"
else
  RASA_CMD="$(command -v rasa)"
fi

if [ -z "$RASA_CMD" ]; then
  echo "❌ Rasa executable not found."
  echo "Please install Rasa or activate a virtual environment first."
  exit 1
fi

CONV_ID="${CLIENT_NAME}-$(date +%s)"
cd "$PROJECT_ROOT"
PYTHONWARNINGS="ignore" RASA_LOG_LEVEL=ERROR "$RASA_CMD" shell --quiet --conversation-id "$CONV_ID" 2>/dev/null