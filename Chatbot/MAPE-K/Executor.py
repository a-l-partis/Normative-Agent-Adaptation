
from KnowledgeBase import KnowledgeBase

import shutil
import os

class Executor():
    def run_executor(self,kb):
        currentUser = kb.get_current_user()
        kb.set_active_user(currentUser)
        self.copyFile()

        return True

    def copyFile(self):
        project_root = os.path.dirname(os.path.abspath(__file__))

        copy_from = os.path.join(project_root, "planning_files", "active.workflowspec")
        paste_to = os.path.join(project_root, "base_workflow", "active.workflowspec")

        os.makedirs(os.path.dirname(paste_to), exist_ok=True)

        try:
            shutil.copy2(copy_from, paste_to)
            print("Initialised workflow")
        except FileNotFoundError:
            print("Could not move file; incorrect path")