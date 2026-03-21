#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import random

DEFEATER_NUM = 3

GUARD_NUM = 0
GUARDS = []
EVENTS = []
RULE_NUM = 0

        
def generateRules(file,numOfRules,numDefeaters,defeaters,fileName):
    global EVENTS,GUARDS,RULE_NUM
    RULE_NUM = numOfRules
    file.write("rule_start\n")
    for x in range(1,numOfRules+1):
        ruleType = random.choice(["Start","End"])
        file.write(f"\tRule{x} when Task{x}{ruleType}")
        EVENTS.append(f"event Task{x}{ruleType}")
        
        if random.choice([True,False]):
            file.write(" and ")
            genExpr(file,None,0,None,False)
        y = RULE_NUM + 1
        RULE_NUM += 1   
        file.write(f" then Response{y}")
        EVENTS.append(f"event Response{y}")
        for y in range(0,numDefeaters):
            genDefeater(y,file)
        file.write("\n")
    file.write("rule_end\n")
    file.close();
    file = open(fileName,"r")
    #file.seek(0)
    content = file.read()
    print("RUNNING")
    open(fileName, 'w').close()
    file = open(fileName,"a")
    file.write("def_start\n")
    for element in GUARDS:
        file.write("\t" + element + "\n")
    EVENTS = list(dict.fromkeys(EVENTS))
    for element in EVENTS:
        file.write("\t" + element + "\n")

    file.write("def_end\n")
    
    file.write(content)
    
def genDefeater(orderNum,file):
    global RULE_NUM
    if orderNum == 0:
        file.write("\n")
    file.write("\tunless ")
    genExpr(file,None,0,None,False)
    x = RULE_NUM + 1
    RULE_NUM += 1
    file.write(f" then Response{x}\n")
    EVENTS.append(f"event Response{x}")

def genExpr(file,lastElement,cSize,lastLastElement,LeftEl):
    global GUARD_NUM

    if lastElement == "RelComp":
        posElements = ["Value","Atom"]
        
    elif lastElement == "BoolComp":
        if lastLastElement == "Not":
            posElements = ["Atom","BoolComp","RelComp"]
        elif not LeftEl:
            posElements = ["Atom","BoolComp", "Not","RelComp"]
        else:
            posElements = ["Atom","BoolComp","RelComp"]
        
    elif lastElement == "Not":
        posElements = ["Atom","BoolComp","RelComp"]
    
    elif not LeftEl:
        posElements = ["Atom","BoolComp","Not","RelComp"]
    else:
        posElements = ["Atom","BoolComp","RelComp"]
    
    if random.uniform(0,1) < cSize/5:
        expr = posElements[0]
    else:
        expr = random.choice(posElements)
    
    match(expr):
        
        case "BoolComp":
            andOr = random.choice(["and","or"])
            genExpr(file,"BoolComp",cSize+1,lastElement,True)
            file.write(" " + andOr + " ")
            genExpr(file,"BoolComp",cSize+1,lastElement,False)
        
        case "Atom":
            file.write(f"guard{GUARD_NUM}")
            if lastElement == "RelComp":
                atomType = "numeric"
            else:
                atomType = "boolean"
            GUARDS.append(f"measure guard{GUARD_NUM} : {atomType}")
            GUARD_NUM += 1
            
            
        case "Not":
            file.write("not ")
            genExpr(file,"Not",cSize+1,lastElement,False)
        
        case "RelComp":
            comp = random.choice(["<",">",
                     "<>","<=",
                     ">=","="])
            genExpr(file,"RelComp",cSize+1,lastElement,True)
            file.write(" " + comp + " ")
            genExpr(file,"RelComp",cSize+1,lastElement,False)
            
        case "Value":
            file.write(str(random.randint(0,50)))
                
        case _:
            print("ERROR")
            
def setup():
    numRules = int(input("Please specify the number of rules to generate: "))
    numDefeaters = int(input("Please specify the number of defeaters to generate per rule: "))
    file = open(f"{numRules}Rules-{numDefeaters}Defeaters.sleec","a+")
    if numDefeaters == 0:
        defeaters = False
    else:
        defeaters = True
    generateRules(file,numRules,numDefeaters,defeaters,f"{numRules}Rules-{numDefeaters}Defeaters.sleec")
    file.close()


setup()