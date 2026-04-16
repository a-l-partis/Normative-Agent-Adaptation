import subprocess
import os 

from KnowledgeBase import KnowledgeBase

class Planner():
    def run_planner(self,kb):
        print("Initialising Planner")

        rulesFound = self.BuildRules(kb)
        if rulesFound:
            self.RunPlanning()
        else:
            self.returnToDefault()

    def BuildRules(self,kb):

        rules_path = 'planning_files/rules.sleec'

        currentUser = kb.get_current_user()
        ruleset = kb.get_rules(currentUser)
        common_rules = kb.get_common_rules()

        rule_counter = 0
        
        merged_events = list(set(ruleset.events))
        merged_measures = list(set(ruleset.measures))
        merged_rules = list(set(ruleset.rules))

        if len(merged_rules) == 0:
            return False

        with open(rules_path, "w") as f:
            f.write('def_start\n')

            for e in merged_events:
                f.write('\tevent %s\n' % e)

            for m in merged_measures:
                f.write('\tmeasure %s\n' % m)

            f.write('def_end\n')

            f.write('rule_start\n')
            for r in merged_rules:
                f.write('\t%s %s\n' % ("Rule" + str(rule_counter), r))
                rule_counter += 1
                
            # for r in common_rules.rules:
            #     f.write('\t%s %s\n' % (str(rule_counter), r))

            f.write('rule_end\n')
            return True

    def RunPlanning(self):
        print("performing adaptation")

        output = subprocess.check_output(['sh', 'planning_files/planner-script.sh'], text=True)
        
    def returnToDefault(self):
        project_root = os.path.dirname(os.path.abspath(__file__))

        source_path = os.path.join(project_root, "planning_files", "ChatbotDefault.workflowspec")
        destination_path = os.path.join(project_root, "planning_files", "active.workflowspec")

        try:
            with open(source_path, "rb") as src:
                content = src.read()

            with open(destination_path, "wb") as dest:
                dest.write(content)

            print("Successfully updated active.workflowspec with default settings.")

        except FileNotFoundError:
            print("Error: One of the paths is incorrect. Please verify the file locations.")
        except PermissionError:
            print("Error: Permission denied. Check your access rights to the planning_files directory.")