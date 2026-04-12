from tinydb import TinyDB, Query

class KnowledgeBase():
    def __init__(self):
        self.db = TinyDB('db.json')
        State = Query()
        state = self.db.get(State.type == 'state')
        if state == None:
            print("Database is empty; initialising it.")
            self.init(self.db)
        else:
            print("Database exists.")
            
        self.currentUser = None

    def get_rules(self,userID):
        User = Query()
        user = self.db.get((User.type == 'user') & (User.name == userID))

        try:
            ruleIDs = user['rules']

            ruleList = self.db.search(Query().name.one_of(ruleIDs))

            ruletext = [rule['def'] for rule in ruleList]
            return RuleData(ruletext,user['events'],user['measures'])
        except:
            print("Error: no rules matching userID: " + userID)
            return None
            

    def get_common_rules(self):
        return self.get_rules("*")

    def get_current_user(self):
        User = Query()
        return self.db.search(User.type == 'state')[0]['currentUser']

    def set_current_user(self,newUser):
        User = Query()
        self.db.update({'currentUser': newUser}, User.type == 'state')

    def get_active_user(self):
        User = Query()
        return self.db.search(User.type == 'state')[0]['activeUser']
    
    def set_active_user(self,newUser):
        User = Query()
        self.db.update({'activeUser': newUser}, User.type == 'state')
    
    def init(self,db):
        ### need to store user state and rules
        db.insert
        
        ### Common Rules ###
        
        db.insert({'type':'rule', 'name':'c1', 'def':'when ExplainCantReturnEnd then ExplainLegalRights'})
        db.insert({'type':'rule', 'name':'c2', 'def':'when ReadResponseEnd and personalInfo then RedactInformation'})
        
        ### FirstTimeUser Rules ###
        
        db.insert({'type':'rule', 'name':'f1', 'def':'when ReadCustomerGreetingEnd and newUser then SetMoreThoroughExplanationMode'})
        db.insert({'type':'rule', 'name':'f2', 'def':'when ExplainCantReturnEnd then Apologise unless userRequestsHumanOperator then PassOntoHumanOperator'})
        db.insert({'type':'rule', 'name':'f3', 'def':'when ReadResponseEnd and personalInfo then RedactInformation'})

        ### AnxiousUser Rules ###
        
        db.insert({'type':'rule', 'name':'a1', 'def':'when ReadCustomerGreetingEnd and userFrustrated then SetSympatheticTone'})
        db.insert({'type':'rule', 'name':'a2', 'def':'when PassOntoHumanOperatorStart then WarnUser'})
        
        ### Users ###
        
        db.insert({'type': 'user', 'name': 'FirstTimeUser', 'rules': ['f1', 'f2', 'f3'], 'events': ['ReadCustomerGreetingEnd', 'SetMoreThoroughExplanationMode', 'ExplainCantReturnEnd', 'Apologise', 'PassOntoHumanOperator', 'ReadResponseEnd','RedactInformation'], 'measures': ['newUser : boolean','userRequestsHumanOperator : boolean','personalInfo : boolean']})
        
        db.insert({'type': 'user', 'name': 'AnxiousUser', 'rules': ['a1','a2'], 'events': ['ReadCustomerGreetingEnd', 'SetSympatheticTone', 'PassOntoHumanOperatorStart', 'WarnUser'], 'measures': ['userFrustrated : boolean']})

        db.insert({'type': 'user', 'name': '*', 'rules': ['c1','c2'], 'events': ['ExplainCantReturnEnd', 'ExplainLegalRights', 'ReadResponseEnd', 'RedactInformation'], 'measures': ['personalInfo : boolean']})

        db.insert({'type': 'user', 'name': '-', 'rules': [], 'events': [], 'measures': []})

        ### setup ###

        db.insert({'type': 'state', 'currentUser': '-', 'package': '','activeUser':'-'})

class RuleData():
    def __init__(self,rules,events,measures):
        self.rules = rules
        self.events = events
        self.measures = measures
        