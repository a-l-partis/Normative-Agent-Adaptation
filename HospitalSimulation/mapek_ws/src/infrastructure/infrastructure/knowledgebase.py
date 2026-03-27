import rclpy
from rclpy.executors import ExternalShutdownException
from rclpy.node import Node

from mapek_interfaces.srv import GetUserData, GetState, GetRules
from mapek_interfaces.msg import Rule

from std_msgs.msg import String

from tinydb import TinyDB, Query

class KnowledgeBase(Node):

    def __init__(self):
        super().__init__('knowledgebase')

        # self.db = UnQLite()
        self.db = TinyDB('db.json')

        State = Query()
        state = self.db.get(State.type == 'state')
        if state == None:
            self.get_logger().info("Database is empty; initialising it.")
            init(self.db)
        else:
            self.get_logger().info("Database exists.")

        self.currentUser = None

        # services
        self.get_user_data = self.create_service(GetUserData, 'get_user_data', self.get_user_data_callback)
        self.get_state = self.create_service(GetState, 'get_state', self.get_state_callback)
        self.get_rules = self.create_service(GetRules, 'get_rules', self.get_rules_callback)

        # topics
        self.subscription = self.create_subscription(
            String,
            'execute',
            self.get_user_data_callback,
            10)

        self.set_user = self.create_subscription(
            String,
            'set_user',
            self.set_user_callback,
            10)

        self.subscription  # prevent unused variable warning
        self.set_user

        self.publisher_ = self.create_publisher(String, 'monitor', 10)

    def get_rules_callback(self, request, response):
        id = request.id
        self.get_logger().info('Collecting rules for user: %s' % id)
        # access database and collect information about user
        User = Query()
        user = self.db.get(User.type == 'user' and User.name == id)
        
        # build response
        response.rules = user['rules']
        response.events = user['events']
        response.measures = user['measures']
        return response

    def get_user_data_callback(self, request, response):
        id = request.id

        self.get_logger().info('Collecting information about user: %s' % id)
        # access database and collect information about user
        User = Query()
        user = self.db.get(User.type == 'user' and User.name == id)

        self.get_logger().info('Information: %s' % user)

        if user != None:
            rules = []
            for r in user['rules']:
                RuleQ = Query()
                ru = self.db.get(RuleQ.type == 'rule' and RuleQ.name == r)
                rule = Rule()
                rule.name = ru['name']
                rule.definition = ru['def']
                rules.append(rule)

            response.rules = rules
            # build response
            response.name = user['name']
            response.gender = ''
            response.language = ''
            response.events = user['events']
            response.measures = user['measures']
            return response
        else:
            return None

    def get_state_callback(self, request, response):
        
        self.get_logger().info('Collecting current state')
        # access database and collect information about user
        State = Query()
        state = self.db.get(State.type == 'state')
        self.get_logger().info('Collected current state %s' % state)
        # build response
        if state['currentUser'] == None:
            response.user = ''
        else:
            response.user = state['currentUser']
        self.get_logger().info('Returning current state')
        return response

    def set_user_callback(self, msg):
        id = msg.data
        self.get_logger().info('Updating state information about user: %s' % id)
        
        # access database and get state and update it
        State = Query()
        state = self.db.get(State.type == 'state')
        if state != None:
            doc_id = state.doc_id
            self.db.update({'currentUser':id}, doc_ids=[doc_id])
            
            self.get_logger().info('State found; updating it')
        else:
            self.get_logger().info('No state found')

def init(db):
    # db.insert({'type':'rule', 'name':'Rule1a', 'def':'when AssessRoomStart then NotifyPatient'})
    # db.insert({'type':'rule', 'name':'Rule1b', 'def':'when CleanFloorStart and personResting then SilentFloorCleaning'})
    # db.insert({'type':'rule', 'name':'Rule2a', 'def':'when DustFurnitureStart then OpenWindow'})
    # db.insert({'type':'rule', 'name':'Rule2b', 'def':'when CleanFloorEnd then WarnAboutWetFloor unless prayingTime then PlaceWetFloorSign'})
    # db.insert({'type':'rule', 'name':'Rule1', 'def':'when AssessRoomEnd then DisplayCleaningPlanEnd'})

    db.insert({'type':'rule', 'name':'Rule3a', 'def':'when AssessRoomEnd then DisplayCleaningPlan'})
    db.insert({'type':'rule', 'name':'Rule3b', 'def':'when AssessRoomStart then NotifyPatient'})
    db.insert({'type':'rule', 'name':'Rule3c', 'def':'when CleanFloorStart and personResting then SetSilentFloorCleaning'})

    db.insert({'type': 'user', 'name': 'Alex', 'rules': ['Rule3a', 'Rule3b', 'Rule3c'], 'events': ['AssessRoomStart', 'AssessRoomEnd', 'DisplayCleaningPlan', 'NotifyPatient', 'CleanFloorStart', 'SetSilentFloorCleaning'], 'measures': ['personResting : boolean']})
    db.insert({'type': 'user', 'name': '*', 'rules': [], 'events': [], 'measures': []})

    # db.insert({'type': 'user', 'name': 'Alex', 'rules': ['Rule1a', 'Rule1b'], 'events': ['AssessRoomStart', 'NotifyPatient', 'CleanFloorStart', 'SilentFloorCleaning'], 'measures': ['personResting : boolean']})
    # db.insert({'type': 'user', 'name': 'Casey', 'rules': ['Rule2a', 'Rule2b'], 'events': ['DustFurnitureStart', 'CleanFloorEnd', 'OpenWindow', 'WarnAboutWetFloor', 'PlaceWetFloorSign'], 'measures': ['prayingTime : boolean']})
    # db.insert({'type': 'user', 'name': '*', 'rules': ['Rule1'], 'events': ['AssessRoomEnd', 'DisplayCleaningPlanEnd'], 'measures': []})
    

    db.insert({'type': 'state', 'currentUser': '*', 'package': ''})

def main(args=None):
    try:
        rclpy.init(args=args)

        kb = KnowledgeBase()

        rclpy.spin(kb)
    except KeyboardInterrupt:
        pass

    # It seems handling keyboard interrupt shuts rclpy down.
    # Destroy the node explicitly
    # (optional - otherwise it will be done automatically
    # when the garbage collector destroys the node object)
    # monitor.destroy_node()
    # rclpy.shutdown()


if __name__ == '__main__':
    main()