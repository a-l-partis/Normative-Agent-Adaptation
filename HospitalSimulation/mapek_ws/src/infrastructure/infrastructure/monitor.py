import rclpy
from rclpy.executors import ExternalShutdownException, MultiThreadedExecutor
from rclpy.callback_groups import MutuallyExclusiveCallbackGroup
from rclpy.node import Node

from std_msgs.msg import Empty, String

from mapek_interfaces.srv import GetUserData, GetState

from infrastructure.framework.mapek import MAPEK_Node

class Monitor(MAPEK_Node):

    def create_data_access(self):
        # set up application specific publishers and subscribers
        self.user_id = self.create_subscription(
            String,
            'user_id',
            self.user_id_callback,
            10)
        self.user_id  # prevent unused variable warning

        # set up application specific data publishers and services
        self.get_state = self.create_client(GetState, 'get_state', callback_group=self.client_callback_group)
        while not self.get_state.wait_for_service(timeout_sec=1.0):
            self.get_logger().info('service not available, waiting again...')

        self.active = False

    def execute(self):
        self.active = True
        self.get_logger().info('Monitor is active.')

    def user_id_callback(self, msg):
        if self.active:
            user = msg.data
            self.get_logger().info('Observed user: "%s"' % user)

            # get current user from knowledge base
            req = GetState.Request()
            response = self.get_state.call(req)

            current_user = response.user
            # self.get_logger().info('Current user: "%s"' % current_user)

            if (current_user != user):
                self.get_logger().info('User is different than current user. Analysis is required.')

                # trigger analyser
                self.send_output(user)
                # self.get_logger().info('Publishing request to analyse software for user "%s"' % user)

                self.active = False
                self.get_logger().info('Deactivating monitor.')
            else:
                self.get_logger().info('User has not changed; no further analysis required.')
        else:
            self.get_logger().info('Received user data, but ignored it be cause monitor is inactive.')

    def input_callback(self,msg):
        if not self.active:
            self.get_logger().info('Activating monitor')
            self.active = True

def main(args=None):
    Monitor.main('monitor', 'monitor', 'analyse', Empty, String)

if __name__ == '__main__':
    main()