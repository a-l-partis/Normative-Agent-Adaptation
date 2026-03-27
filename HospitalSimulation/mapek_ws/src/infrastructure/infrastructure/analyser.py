import rclpy
from rclpy.executors import ExternalShutdownException
from rclpy.node import Node

from std_msgs.msg import String, Empty

from infrastructure.framework.mapek import MAPEK_Node

from mapek_interfaces.srv import GetUserData, GetState, GetRules

class Analyser(MAPEK_Node):
    def execute(self):
        pass

    def create_data_access(self):
        self.get_rules = self.create_client(GetRules, 'get_rules', callback_group=self.client_callback_group)
        while not self.get_rules.wait_for_service(timeout_sec=1.0):
            self.get_logger().info('service not available, waiting again...')

        self.get_state = self.create_client(GetState, 'get_state', callback_group=self.client_callback_group)
        while not self.get_state.wait_for_service(timeout_sec=1.0):
            self.get_logger().info('service not available, waiting again...')

        self.set_user = self.create_publisher(String, 'set_user', 10, callback_group=self.publisher_callback_group)

    def input_callback(self, msg):
        self.get_logger().info('Analysing user: "%s"' % msg.data)

        user = msg.data

        # Retrieve user information from knowledge base, analyse it and publish a request to the planner if necessary.
        req2 = GetState.Request()
        response2 = self.get_state.call(req2)
        current_user = response2.user

        plan = False
        if current_user == '':
            self.get_logger().info('No current user. Planning in required.')
            plan = True
        else:
            req1 = GetRules.Request()
            req1.id = user
            response1 = self.get_rules.call(req1)

            self.get_logger().info('Analysing current user: "%s"' % current_user)

            req3 = GetRules.Request()
            req3.id = current_user
            response3 = self.get_rules.call(req3)



            rule_set1 = set(response1.rules)
            rule_set2 = set(response3.rules)

            event_set2 = set(response1.events)
            event_set2 = set(response3.events)

            measure_set2 = set(response1.measures)
            measure_set2 = set(response3.measures)

            if rule_set1 != rule_set2 or event_set1 != event_set2 or measure_set1 != measure_set2:
                self.get_logger().info('Rule, events or measure are different.')
                plan = True
            else:
                self.get_logger().info('Rule, events and measures are the same')

        if plan:
            msg = String()
            msg.data = user
            self.set_user.publish(msg)
            self.send_output()

def main(args=None):
    Analyser.main('analyser', 'analyse', 'plan', String, Empty)

if __name__ == '__main__':
    main()