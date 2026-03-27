# from tinydb import TinyDB, Query
# db = TinyDB('db.json')

def init(db):
    db.insert({'type':'rule', 'name':'Rule1a', 'def':'when AssessRoomStart then NotifyPatient'})
    db.insert({'type':'rule', 'name':'Rule1b', 'def':'when CleanFloorStart and personResting then SilentFloorCleaning'})
    db.insert({'type':'rule', 'name':'Rule2a', 'def':'when DustFurnitureStart then OpenWindow'})
    db.insert({'type':'rule', 'name':'Rule2b', 'def':'when CleanFloorEnd then WarnAboutWetFloor unless prayingTime then PlaceWetFloorSign'})
    db.insert({'type':'rule', 'name':'Rule1', 'def':'when AssessRoomEnd then DisplayCleaningPlan'})

    db.insert({'type': 'user', 'name': 'Alex', 'rules': ['Rule1a', 'Rule1b'], 'events': ['AssessRoomStart', 'NotifyPatient', 'CleanFloorStart', 'SilentFloorCleaning'], 'measures': ['personResting : boolean']})
    db.insert({'type': 'user', 'name': 'Casey', 'rules': ['Rule2a', 'Rule2b'], 'events': ['DustFurnitureStart', 'CleanFloorEnd', 'OpenWindow', 'WarnAboutWetFloor', 'PlaceWetFloorSign'], 'measures': ['prayingTime : boolean']})
    db.insert({'type': 'user', 'name': '*', 'rules': ['Rule1'], 'events': ['AssessRoomEnd', 'DisplayCleaningPlan'], 'measures': []})

    db.insert({'type': 'state', 'currentUser': None})


	