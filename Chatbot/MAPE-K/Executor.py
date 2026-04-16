
from KnowledgeBase import KnowledgeBase

import os

class Executor():
    def run_executor(self,kb):
        print("Executing...")
        currentUser = kb.get_current_user()
        kb.set_active_user(currentUser)
        self.copyFile()

        return True

    def copyFile(self):

        project_root = os.path.dirname(os.path.abspath(__file__))

        copy_from = os.path.join(project_root, "planning_files", "active.workflowspec")
        paste_to = os.path.join(project_root, "base_workflow", "active.workflowspec")

        try:
            with open(copy_from, "rb") as f_src:
                content = f_src.read()

            os.makedirs(os.path.dirname(paste_to), exist_ok=True)

            with open(paste_to, "wb") as f_dest:
                f_dest.write(content)

            print("Initialised workflow")

        except FileNotFoundError:
            print("Could not move file; incorrect path")
        except PermissionError:
            print("Permission denied: Check your read/write access for these directories")
        except Exception as e:
            print(f"An unexpected error occurred: {e}")