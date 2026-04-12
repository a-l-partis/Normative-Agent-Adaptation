from Monitor import Monitor
from Analyser import Analyser
from Planner import Planner
from Executor import Executor

from KnowledgeBase import KnowledgeBase

def setup():
    kb = KnowledgeBase()

    mon = Monitor()
    an = Analyser()
    plan = Planner()
    exe = Executor()

    while True:
        mon.run_monitor(kb)

        
        adaptation_needed = an.run_analyser(kb)
        if adaptation_needed:

            plan.run_planner(kb)
            exe.run_executor(kb)

if __name__ == "__main__":
    setup()