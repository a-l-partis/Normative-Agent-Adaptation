#!/usr/bin/env python3
# -*- coding: utf-8 -*-
import random
import os
TASK_COUNT = 0
GUARD_NUM = 0
tToWfRatio = [0,0]
LIVEBRANCHES = 1

def getTaskProb(tasksToGen):
    global tToWfRatio
    global TASK_COUNT
    if tasksToGen-1 <= TASK_COUNT:
        taskprob = 1
    elif LIVEBRANCHES == 1 and tasksToGen < TASK_COUNT:
        taskprob = 0
    elif tToWfRatio[1] > tToWfRatio[0]:
        taskprob = 1
    elif TASK_COUNT > tasksToGen/2:
        taskprob = TASK_COUNT/tasksToGen
    else:
        taskprob = 0.6

    return taskprob


def genGuard(indents):
    global GUARD_NUM
    
    guard =  'Atom {\n' + indent(indents+1) + 'measureID \"guard' + str(GUARD_NUM) \
        + '\"\n' + indent(indents) + "}"
    GUARD_NUM += 1
    return guard

def genExpr(file,indents,lastElement,cSize):
    

    if lastElement == "RelComp":
        posElements = ["Value","Atom","RelComp"]
        
    elif lastElement == "BoolComp" or lastElement == "Not":
        posElements = ["Atom","BoolComp", "Not","RelComp"]
    
    else:
        posElements = ["Atom","BoolComp","Not","RelComp"]
    
    if random.uniform(0,1) < cSize/10:
        expr = posElements[0]
    else:
        expr = random.choice(posElements)
    
    match(expr):
        
        case "BoolComp":
            andOr = random.choice(["AND","OR"])
            file.write("BoolComp {\n"+indent(indents+1) + "op " + andOr)
            file.write("\n" + indent(indents+1) + "right ")
            genExpr(file,indents+1,"BoolComp",cSize+1)
            file.write("\n" + indent(indents+1) + "left ")
            genExpr(file,indents+1,"BoolComp",cSize+1)
            file.write("\n" + indent(indents) + "}")
        
        case "Atom":
            file.write(genGuard(indents))
            
        #Removed because this isn't useful
        #case "BoolValue":
            #output = random.choice["value BoolValue","BoolValue"]
            
        case "Not":
            file.write("Not {\n" + indent(indents+1) + "op " + "not")
            file.write("\n" + indent(indents+1) + "expr ")
            genExpr(file,indents+1,"Not",cSize+1)
            file.write("\n" + indent(indents) + "}")
        
        case "RelComp":
            comp = random.choice(["LESS_THAN","GREATER_THAN",
                     "NOT_EQUAL","LESS_EQUAL",
                     "GREATER_EQUAL","EQUAL"])
            
            file.write("RelComp {\n"+indent(indents+1) + "op " + comp)
            file.write("\n" + indent(indents+1) + "left ")
            
            genExpr(file,indents+1,"RelComp",cSize+1)
            file.write("\n" + indent(indents+1) + "right ")
            genExpr(file,indents+1,"RelComp",cSize+1)
            file.write("\n" + indent(indents) + "}")
            
        case "Value":
            file.write("Value {\n" + indent(indents+1) + "value " \
                       + str(random.randint(0,50)) + "\n" \
                           + indent(indents) + "}")
                
        case _:
            print("ERROR")



def selectWorkflow():
    options = ["Sequence","Loop","Decision"]
    return random.choice(options)
    

def indent(indents):
    return "\t"*indents


def generatingWorkflow(file,indents,lastWF,tasksToGen):
    global TASK_COUNT
    global LIVEBRANCHES
    global tToWfRatio
    taskprob = getTaskProb(tasksToGen)
    if taskprob >= random.random():
        workflow = "Task"
    else:
        workflow = selectWorkflow()
    if tasksToGen <= TASK_COUNT:
        workflow = "Task"
        
    match(workflow):
        
        case "Task":
            tToWfRatio[0] = tToWfRatio[0] + 1
            
            file.write("Task {\n" + indent(indents+1) + "ID \n\"Task" +
                       str(TASK_COUNT) + "\"}")
            TASK_COUNT = TASK_COUNT + 1
            if lastWF == "Decision" or lastWF == "Loop":
                LIVEBRANCHES -= 1
            
        case "Sequence":
            tToWfRatio[1] = tToWfRatio[1] + 1
            file.write("Sequence {\n" + indent(indents+1) + "subworkflows {\n"
                       + indent(indents+2))
            length = random.randint(2,6)
            for subwf in range(0,length-1):
                generatingWorkflow(file, indents+2,"Sequence",tasksToGen)
                file.write(",\n" + indent(indents+2))
            generatingWorkflow(file, indents+2,"Sequence",tasksToGen)
            file.write("\n" + indent(indents+1) + "}\n" + indent(indents) + "}")
            
        
        case "Loop":
            tToWfRatio[1] = tToWfRatio[1] + 1
            file.write("Loop {\n" + indent(indents+1) + "loop GuardedWorkflow " \
                       + "{\n" + indent(indents + 2) + "body ")
            generatingWorkflow(file,indents+2,"Loop",tasksToGen)
            file.write("\n" + indent(indents+2) + "guard ")
            genExpr(file,indents+2,None,0)
            file.write("\n" + indent(indents+1) + "}\n" + indent(indents) + "}")
            
        
        case "Decision":
            tToWfRatio[1] = tToWfRatio[1] + 1
            branches = random.randint(2,5)
            file.write("Decision {\n" + indent(indents+1) + "options {\n" \
                       + indent(indents+2))
                
            for branch in range(0,branches-1):
                LIVEBRANCHES +=1
                file.write("GuardedWorkflow {\n" + indent(indents+3) + "body ")
                generatingWorkflow(file, indents+3,"Decision",tasksToGen)
                file.write("\n" + indent(indents+3) + "guard ")
                genExpr(file,indents+3,None,0)
                file.write("\n" + indent(indents+2) + "},\n" + indent(indents+2))
 
            file.write("GuardedWorkflow {\n" + indent(indents+3) + "body ")
            generatingWorkflow(file, indents+3,"Decision",tasksToGen)
            file.write("\n" + indent(indents+3) + "guard " + genGuard(indents+3) \
                       + "\n" + indent(indents+2) + "}\n" + indent(indents + 1) \
                           + "}\n" + indent(indents) + "}")


def generateWorkflow(file,tasksToGen):
    file.write("WorkflowStructure {\n\t workflowspec ")
    generatingWorkflow(file,1,None,tasksToGen)
    file.write("\n}")
    
def gen(maxTasks,increment):
    global LIVEBRANCHES
    global TASK_COUNT
    global GUARD_NUM
    
    for x in range(1,maxTasks,increment):
        LIVEBRANCHES = 1
        TASK_COUNT = 0
        GUARD_NUM = 0
        
        file = open("workflow-new.text","a+")
        generateWorkflow(file,x)
        file.close()
        os.rename("workflow-new.text",f"workflow-{TASK_COUNT}Tasks.workflowspec")
        file = open("workflow-new.text","a+")
        LIVEBRANCHES = 1
        TASK_COUNT = 0
        GUARD_NUM = 0
        generateWorkflow(file,x)
        file.close()
        os.rename("workflow-new.text",f"workflow-{TASK_COUNT}Tasks.workflowspec")
        print(x)
    print("Done")
        
    
def setup():
    maxTasks = int(input("Please enter the maximum number of tasks: "))
    increment = int(input("Please enter the task increments: "))
    gen(maxTasks,increment)
    
setup()