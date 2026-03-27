import rclpy
from rclpy.node import Node
from rclpy.executors import ExternalShutdownException, MultiThreadedExecutor
from rclpy.callback_groups import MutuallyExclusiveCallbackGroup

from abc import ABC, abstractmethod
from std_msgs.msg import Empty

class MAPEK_Node(Node):
    def create_input_subscription(self, topic, type=Empty):
        self.input = self.create_subscription(
            type,
            topic,
            self.input_callback,
            10)
        self.input  # prevent unused variable warning

    def create_output_publisher(self, topic, type=Empty):
        self.output = self.create_publisher(type, topic, 10, callback_group=self.publisher_callback_group)

    @abstractmethod
    def create_data_access(self):
        pass

    @abstractmethod
    def input_callback(self,msg):
        pass

    def send_output(self, value=None):
        self.get_logger().info('Sending output request: %s.' % self.output_topic)
        msg = self.output_type()
        if value != None:
            msg.data = value
        self.output.publish(msg)

    @abstractmethod
    def execute(self):
        pass

    def __init__(self, name,input_topic, output_topic, input_type=Empty, output_type=Empty):
        super().__init__(name)

        self.name = name
        self.input_topic = input_topic
        self.input_type = input_type
        self.output_topic = output_topic
        self.output_type = output_type

        # Mutually exclusive callback groups
        self.client_callback_group = MutuallyExclusiveCallbackGroup()
        self.publisher_callback_group = MutuallyExclusiveCallbackGroup()
        self.service_callback_group = MutuallyExclusiveCallbackGroup()

        # Should a MAPEK_Node have two states, active and inactive, where behaviours are not executed when inactive?
        # Or should this be done at the level of the application?

        
        self.create_output_publisher(output_topic, output_type)
        self.create_input_subscription(input_topic, input_type)
        self.create_data_access()
        

        self.execute()

    @classmethod
    def main(cls, name, input_topic, output_topic, input_type, output_type, args=None):
        rclpy.init(args=args)
        node = cls(name, input_topic, output_topic, input_type, output_type)
    
        executor = MultiThreadedExecutor()
        executor.add_node(node)
        try:
            executor.spin()
        except KeyboardInterrupt:
            pass
        finally:
            executor.shutdown()
            node.destroy_node()
            rclpy.try_shutdown()
        
        # It seems handling keyboard interrupt shuts rclpy down.
        # Destroy the node explicitly
        # (optional - otherwise it will be done automatically
        # when the garbage collector destroys the node object)
        # monitor.destroy_node()
        # rclpy.shutdown()
        