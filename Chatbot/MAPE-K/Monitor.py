import glob
import os
import time

from KnowledgeBase import KnowledgeBase

class Monitor():

    def run_monitor(self,kb):
        print("Monitor waiting for user change")
        AnalyserNeeded = False
        currentUser = kb.get_current_user().strip("\n")


        while not AnalyserNeeded:
            newUser = self.check_for_user()
            if newUser != None and newUser != currentUser:
                AnalyserNeeded = True

        print("Detected new userID:" + newUser)

        kb.set_current_user(newUser.strip("\n"))

        return True

    def check_for_user(self):

        ### Path to search for new user files
        directory_path = os.path.join('users')

        files = glob.glob(os.path.join(directory_path, "*.json"))
        if files:
            user_file = files[0]
            
            time.sleep(0.1) 
            
            try:
                with open(user_file, 'r', encoding='utf-8') as f:
                    user_id = f.read()
                return user_id.strip("\n")
            except Exception as e:
                return None
