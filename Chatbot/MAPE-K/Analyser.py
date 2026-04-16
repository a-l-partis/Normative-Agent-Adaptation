from KnowledgeBase import KnowledgeBase

class Analyser():
    def run_analyser(self,kb):

        if self.compareRules(kb):
            
            print("Analysis result: Planning required")
            return True

        else:
            print("Analysis result: No Planning needed, returning to Monitor")
            return False
            
    def compareRules(self,kb):

        currentUser = kb.get_current_user()
        activeUser = kb.get_active_user()
        currentRules = kb.get_rules(currentUser)
        activeRules = kb.get_rules(activeUser)

        if len(currentRules.rules) == 0:
            return True

        if currentRules == None:
            return False
        currentRules = currentRules.rules



        
        if activeRules == None:
            return False
        
        activeRules = activeRules.rules

        checkCurrent = sorted(set(currentRules))
        checkActive = sorted(set(activeRules))
        PlannerNeeded = False

        if checkCurrent != checkActive:
            PlannerNeeded = True

        return PlannerNeeded