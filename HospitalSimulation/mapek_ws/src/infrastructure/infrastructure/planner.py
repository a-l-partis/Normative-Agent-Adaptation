import rclpy
from rclpy.executors import ExternalShutdownException
from rclpy.node import Node

from std_msgs.msg import String, Empty

from infrastructure.framework.mapek import MAPEK_Node

from mapek_interfaces.srv import GetUserData, GetState

import subprocess

class Planner(MAPEK_Node):
    def create_data_access(self):        
        self.get_user_data = self.create_client(GetUserData, 'get_user_data', callback_group=self.client_callback_group)
        while not self.get_user_data.wait_for_service(timeout_sec=1.0):
            self.get_logger().info('service not available, waiting again...')

        self.get_state = self.create_client(GetState, 'get_state', callback_group=self.client_callback_group)
        while not self.get_state.wait_for_service(timeout_sec=1.0):
            self.get_logger().info('service not available, waiting again...')

    def input_callback(self,msg):
        self.get_logger().info('Replanning controller')

        # Retrieve user information from knowledge base, plan adaption and generate code on scratch fonlder, and publish a request to the executor.
        req1 = GetState.Request()
        response1 = self.get_state.call(req1)
        current_user = response1.user

        self.get_logger().info("Current user: %s" % current_user)

        req2 = GetUserData.Request()
        req2.id = current_user
        response2 = self.get_user_data.call(req2)

        output = subprocess.check_output(['sh', 'tools/clean.sh'], text=True)
        self.get_logger().info('Clean script output:\n\n\t%s\n' % output)

        # build .workflowspec files
        with open("scratch/spec.workflowspec", "w") as f:
            f.write('''
WorkflowStructure {
	workflowspec Sequence {
		subworkflows {
			Task {
				ID "AssessRoom"
			},
			Decision {
				options {
					GuardedWorkflow {
						body Task {
							ID "CleanFloor"
							}
						guard Atom {
							measureID "floorNeedsCleaning"
						}
					},
					GuardedWorkflow {
						body Task {
							ID "Skip"
							}
						guard Not {
							op "not"
							expr Atom {
								measureID "floorNeedsCleaning"
							}
						}
					}
				}
			}	
		}	
	}	
}
            ''')

        # build SLEEC file
        filename = 'scratch/rules.sleec'
        with open(filename, "w") as f:
            f.write('def_start\n')
            for e in response2.events:
                f.write('\tevent %s\n' % e)
            for m in response2.measures:
                f.write('\tmeasure %s\n' % m)
            f.write('def_end\n')

            f.write('rule_start\n')
            for r in response2.rules:
                f.write('\t%s %s\n' % (r.name, r.definition))
            f.write('rule_end\n')
        
        # calling scripts
        output = subprocess.check_output(['sh', 'tools/planner-script.sh'], text=True)
        
        self.get_logger().info('Script output:\n\n\t%s\n' % output)

        self.send_output()

        self.get_logger().info('Planning completed.')
    def execute(self):
        pass
        

def main(args=None):
    Planner.main('planner', 'plan', 'execute', Empty, Empty)

if __name__ == '__main__':
    main()