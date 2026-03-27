import rclpy
from rclpy.executors import ExternalShutdownException
from rclpy.node import Node

from std_msgs.msg import Empty

from infrastructure.framework.mapek import MAPEK_Node
from datetime import datetime

import os
import subprocess

class Executor(MAPEK_Node):
    def create_data_access(self):
        pass

    def input_callback(self,msg):
        self.get_logger().info('Executor started.')

        # timestamp = datetime.now().strftime("%Y%m%d_%H%M%S")
        # node_name = "node_"+timestamp
        pkg_name = 'hosppatient1'

        output = subprocess.run(['sh', 'tools/executor-script.sh', pkg_name])
        self.get_logger().info('ROS2 code generated in scratch folder.')

        output = subprocess.run(['bash', 'tools/move_build.sh', pkg_name])
        self.get_logger().info('ROS2 code moved to root folder and compiled.')

        self.get_logger().info('Shutting down previous controller.')
        subprocess.run(['ros2', 'lifecycle', 'set', '/wfSTM', 'shutdown'])

        self.get_logger().info('Starting new controller.')
        # subprocess.Popen(['bash', 'tools/restart.sh',pkg_name])
        os.system('bash tools/restart.sh '+pkg_name)

        self.send_output()

        self.get_logger().info('Executor completed.')

    def execute(self):
        pass

def main(args=None):
    Executor.main('executor', 'execute', 'monitor', Empty, Empty)

if __name__ == '__main__':
    main()