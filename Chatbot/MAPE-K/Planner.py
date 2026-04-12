import subprocess

from KnowledgeBase import KnowledgeBase

class Planner():
    def run_planner(self,kb):
        print("Initialising Planner")

        self.BuildRules(kb)
        self.RunPlanning()

        return True

    def BuildRules(self,kb):

        rules_path = 'planning_files/rules.sleec'

        currentUser = kb.get_current_user()
        ruleset = kb.get_rules(currentUser)
        common_rules = kb.get_common_rules()

        rule_counter = 0
        
        merged_events = list(set(ruleset.events) | set(common_rules.events))
        merged_measures = list(set(ruleset.measures) | set(common_rules.measures))
        merged_rules = list(set(ruleset.rules) | set(common_rules.rules))

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

    def RunPlanning(self):
        print("performing adaptation")

        output = subprocess.check_output(['sh', 'planning_files/planner-script.sh'], text=True)
        
    