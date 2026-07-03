package agentAdaptionCode;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import circus.robocalc.sleec.sLEEC.BoolOp;
import circus.robocalc.sleec.sLEEC.RelOp;
import agentAdaptionCode.SLEECTKIntegration.GuardAndType;
import workflowspec.Atom;
import workflowspec.BoolComp;
import workflowspec.MBoolExpr;
import workflowspec.Not;
import workflowspec.RelComp;
import workflowspec.WorkflowspecFactory;

public class RoboSimConverter{
		
	public static void Convert(WWorkflow wf,String outputName,String sleecPath) {
		try {
			FileWriter file = new FileWriter("RoboSimOutput/" + outputName + ".rst");
			genRoboSim(wf,file, sleecPath);
			
			if(file != null) try {
				file.close();
			} catch (Exception ex) {
				System.out.println("CRASHING HERE");
			}
		}
		catch (IOException e) {
		      System.out.println("File handling error.");
		      e.printStackTrace();
		}
	}
	
    public static class SearchResult {
        public List<String> taskList;
        public List<String> guardList;
        public List<String> guardTypeList;
        public SearchResult(List<String> tasks, List<String> guards,List<String> guardTypeList) {
            this.taskList = tasks;
            this.guardList = guards;
            this.guardTypeList = guardTypeList;
        }
    }

    public static SearchResult searchTasksGuardsNew(WWorkflow wf, List<String> taskList, List<String> guardList,List<String> guardTypeList) {
        if (wf instanceof WSequence) {
            for (WWorkflow subworkflow : ((WSequence) wf).subworkflows) {
                SearchResult result = searchTasksGuardsNew(subworkflow, taskList, guardList,guardTypeList);
                taskList = result.taskList;
                guardList = result.guardList;
                guardTypeList = result.guardTypeList;
            }
        } else if (wf instanceof WLoop) {
        	WLoop myLoop = (WLoop) wf;
        	workflowspec.MBoolExpr expr = myLoop.loop.guard;
        	ArrayList<GuardAndType> guardOutput = SLEECTKIntegration.extractGuardsAndTypes(expr,false);
        	for (GuardAndType recieved : guardOutput) {
        		guardList.add(recieved.guard);
        		guardTypeList.add(recieved.type);

        	}
            SearchResult result = searchTasksGuardsNew(((WLoop) wf).loop.body, taskList, guardList, guardTypeList);
            taskList = result.taskList;
            guardList = result.guardList;
            guardTypeList = result.guardTypeList;
            
        } else if (wf instanceof WDecision) {
            for (WGuardedWorkflow branch : ((WDecision) wf).options) {
            	ArrayList<GuardAndType> guardOutput = SLEECTKIntegration.extractGuardsAndTypes(branch.guard,false);
            	for (GuardAndType recieved : guardOutput) {

            		guardList.add(recieved.guard);
            		guardTypeList.add(recieved.type);
            	}
                SearchResult result = searchTasksGuardsNew(branch.body, taskList, guardList,guardTypeList);
                taskList = result.taskList;
                guardList = result.guardList;
                guardTypeList = result.guardTypeList;

            }
        } else if (wf instanceof WTask) {
            taskList.add(((WTask) wf).ID);
        }
        
        return new SearchResult(taskList, guardList,guardTypeList);
    }

    public static void genInterfaces(WWorkflow wf, FileWriter file,int indents,Set<String> guards,
    		Set<String> tasks, String sleecPath, ArrayList<MeasurePair> measuresList) throws IOException {

    	String sleecDef = getSLEECDefs(sleecPath);
    	guards.addAll(getSLEECGuards(sleecDef));

    	
        file.write(getIndents(indents) + "interface TasksStartI {\n");
        for (String task : tasks) {
            file.write(getIndents(indents) + "\t" + task + "Start()\n");
        }
        file.write(getIndents(indents) + "}\n");

        file.write(getIndents(indents) + "interface TasksEndI {\n");
        for (String task : tasks) {
            file.write(getIndents(indents) + "\tevent " + task + "End\n");
        }
        file.write(getIndents(indents) + "}\n");

        file.write(getIndents(indents) + "interface GuardsI {\n");
        
        //get workflow guards:
        
        SearchResult guardsResult = searchTasksGuardsNew(wf, new ArrayList<>(), new ArrayList<>(),new ArrayList<>());        
        ArrayList<String> workflowGuards = new ArrayList<String>();
        ArrayList<String> workflowGuardTypes = new ArrayList<String>();
        
        //SLEEC GUARDS:
        for (String guard : guards) {
        	//NEED TO CHECK GUARD AGAINST SLEEC RULES
        	String guardType = getGuardType(sleecDef,guard);
        	if(guardType == null) {
        		for(MeasurePair m : measuresList) {
        			if(m.guardName.equals(guard)) {
        				guardType = m.type;
        				break;
        			}
        		}
        	}
        }
        

        file.write(getIndents(indents) + "}\n");
    }
    
    public static void genModuleController(WWorkflow wf,FileWriter file,Set<String> guards, Set<String> tasks,int indents,ArrayList<MeasurePair> measuresList) throws IOException {
    	file.write(getIndents(indents) + "module M {"+ "\n");
    	file.write(getIndents(indents) + "\tcycleDef cycle == 1"+ "\n");
    	file.write(getIndents(indents) + "\trobotic platform RP {"+ "\n");
    	//Events - inputs or outputs?
    	
    	file.write(getIndents(indents) + "\t\tuses TasksEndI uses GuardsI provides TasksStartI\n");
    	
    	file.write(getIndents(indents) +"\t}"+ "\n");
    	
    	file.write(getIndents(indents) + "\tcontroller C {"+ "\n");
    	
    	file.write(getIndents(indents) + "\t\trequires TasksStartI uses GuardsI uses TasksEndI cycleDef true\n");
    	//file.write(getIndents(indents) + "\t\tcycleDef cycle == 1" + "\n");    	
    	//guards/variables - the interface reference goes in the controller
    	
    	ArrayList<String> guardList = new ArrayList<String>(guards);
    	
    	genSTM(wf, file,indents+2,tasks,guardList,measuresList);
    	
    	file.write(getIndents(indents) + "\t}\n");
    	//Put connections here!
    	for(String event : tasks) {
    		//file.write(getIndents(indents) + "\tconnection C on " + event + "Start to RP on " + event + "Start (_async)\n");
    		//file.write(getIndents(indents) + "\tconnection RP on " + event + "Start to C on " + event + "Start (_async)\n");
    		file.write(getIndents(indents) + "\tconnection RP on " + event + "End to C on " + event + "End (_async)\n");
    		//file.write(getIndents(indents) + "\tconnection RP on M" + event + "End to C on C" + event + "End (_async)\n");
    	}
    	for(String nextGuard : guardList) {
    		file.write(getIndents(indents) + "\tconnection RP on " + nextGuard + " to C on " + nextGuard + " (_async)\n");

    	}
    	
    	file.write(getIndents(indents) + "}\n");
 
    }

    public static void genSTM(WWorkflow wf, FileWriter file, int indents,Set<String> tasks,List<String> guardList,ArrayList<MeasurePair> measuresList) throws IOException {
    	//file.write("module mod0");
        file.write(getIndents(indents) + "stm wfSTM {\n");
        //declaring local vars
                
        ArrayList<String> alreadyAdded = new ArrayList<String>();
        for(MeasurePair measure : measuresList) {
        	String currentType = "real";
        	if(measure.type.contains("bool")) {
        		currentType = "boolean";
        	}
        	if(!alreadyAdded.contains(measure.guardName.toLowerCase())) {
        		file.write(getIndents(indents) + "\tvar local" + measure.guardName + " : " + currentType + "\n");
        		alreadyAdded.add(measure.guardName.toLowerCase());
        	}
        }
        
        file.write(getIndents(indents) + "\tinput context { uses TasksEndI uses GuardsI }\n");
        file.write(getIndents(indents) + "\toutput context { requires TasksStartI }\n");
        file.write(getIndents(indents) + "\tcycleDef true\n");
        file.write(getIndents(indents) + "\tinitial s0\n");


        file.write(getIndents(indents) + "\ttransition t0 {\n");
        file.write(getIndents(indents) + "\t\tfrom s0\n");
        file.write(getIndents(indents) + "\t\tto s1\n");
        file.write(getIndents(indents) + "\t}\n");
        file.write(getIndents(indents) + "\tfinal s2\n");

        genWorkflow(wf, file, 1, 2, 1, 3,indents,guardList,0);

        file.write(getIndents(indents) + "}\n");
      //connections between events
    	for(String event : tasks) {
    		//file.write(getIndents(indents) + "connection wfSTM on " + event + "Start to C on C" + event + "Start (_async)\n");
    		//file.write(getIndents(indents) + "connection C on C" + event + "Start to wfSTM on " +event + "Start (_async)\n");
    		file.write(getIndents(indents) + "connection C on " + event + "End to wfSTM on " + event + "End (_async)\n");
    		//file.write(getIndents(indents) + "connection C on C" + event + "End to wfSTM on " +event + "End (_async)\n");
    	}
    	
    	for(String nextGuard : guardList) {
    		file.write(getIndents(indents) + "connection C on " + nextGuard + " to wfSTM on " + nextGuard + " (_async)\n");

    	}
    }

    public static SearchResultState genWorkflow(WWorkflow wf, FileWriter file, int nextState, int targetState, int transNum, int stateNum,int indents,List<String> guardList,int inputNum) throws IOException {
    	
    	if (wf instanceof WTask) {
            WTask task = (WTask) wf;
            file.write(getIndents(indents) + "\tstate s" + nextState + " {\n");
            file.write(getIndents(indents) + "\t\tentry $ " + task.ID + "Start() ; exec\n");
            file.write(getIndents(indents) + "\t}\n");

            transNum += 1;
            
            file.write(getIndents(indents) + "\tstate x" + inputNum + " {}\n");
            
            file.write(getIndents(indents) + "\ttransition t" + transNum + " {\n");
            file.write(getIndents(indents) + "\t\tfrom x" + inputNum + "\n");
            file.write(getIndents(indents) + "\t\tto x" + inputNum + "\n");
            file.write(getIndents(indents) + "\t\texec\n");
            file.write(getIndents(indents) + "\t\tcondition not $" + task.ID + "End\n");
            file.write(getIndents(indents) + "\t}\n");
            transNum += 1;
            
            
            file.write(getIndents(indents) + "\ttransition t" + transNum + " {\n");
            file.write(getIndents(indents) + "\t\tfrom s" + nextState + "\n");
            file.write(getIndents(indents) + "\t\tto x" + inputNum + "\n");
            file.write(getIndents(indents) + "\t}\n");
            transNum += 1;
            
            file.write(getIndents(indents) + "\ttransition t" + transNum + " {\n");
            file.write(getIndents(indents) + "\t\tfrom x" + inputNum + "\n");
            file.write(getIndents(indents) + "\t\tto s" + targetState + "\n");
            file.write(getIndents(indents) + "\t\texec\n");
            file.write(getIndents(indents) + "\t\tcondition $" + task.ID + "End\n");
            file.write(getIndents(indents) + "\t}\n");
            transNum += 1;
            
            
            
            stateNum += 1;
            transNum += 1;
            inputNum += 1;
            nextState = targetState;

            return new SearchResultState(nextState, transNum, stateNum,inputNum);
            
        } else if (wf instanceof WSequence) {
            WSequence seq = (WSequence) wf;

            for (int i = 0; i < seq.subworkflows.size() - 1; i++) {
                WWorkflow subwf = seq.subworkflows.get(i);

                if (subwf instanceof WTask) {
                    SearchResultState result = genWorkflow(subwf, file, nextState, stateNum + 1, transNum, stateNum,indents,guardList,inputNum);
                    nextState = result.nextState;
                    transNum = result.transNum;
                    stateNum = result.stateNum;
                    inputNum = result.inputNum;
                } else {
                    int endState = stateNum + 1;
                    file.write(getIndents(indents) + "\tstate s" + endState + " {}\n");
                    stateNum++;
                    SearchResultState result = genWorkflow(subwf, file, nextState, endState, transNum, stateNum + 2,indents,guardList,inputNum);
                    nextState = result.nextState;
                    transNum = result.transNum;
                    stateNum = result.stateNum;
                    inputNum = result.inputNum;

                    file.write(getIndents(indents) + "\ttransition t" + transNum + " {\n");
                    file.write(getIndents(indents) + "\t\tfrom s" + endState + "\n");
                    file.write(getIndents(indents) + "\t\tto s" + stateNum + "\n");
                    file.write(getIndents(indents) + "\t}\n");
                    nextState = stateNum;
                    stateNum++;
                    transNum++;
                }
            }

            WWorkflow lastSubwf = seq.subworkflows.get(seq.subworkflows.size() - 1);
            return genWorkflow(lastSubwf, file, nextState, targetState, transNum, stateNum,indents,guardList,inputNum);

        } else if (wf instanceof WDecision) {
            WDecision decision = (WDecision) wf;
            

            ArrayList<String> realGuards = new ArrayList<String>();
            //Get the real guards
            
            for (WGuardedWorkflow branch : decision.options) {
            	workflowspec.MBoolExpr currentGuard = branch.guard;
            	realGuards.addAll(SLEECTKIntegration.getRealGuards(currentGuard, false));
            }
            

      
            realGuards = new ArrayList<>(new HashSet<>(realGuards));
            
            //Start of the decision
            int junctionState = nextState;
            
            file.write(getIndents(indents) + "\tstate s" + junctionState + " {}\n");
            stateNum++;

            //End of the decision
            int endDecState = stateNum;
            file.write(getIndents(indents) + "\tstate s" + endDecState + " {}\n");
            stateNum++;

            file.write(getIndents(indents) + "\ttransition t" + transNum + " {\n");
            file.write(getIndents(indents) + "\t\tfrom s" + endDecState + "\n");
            file.write(getIndents(indents) + "\t\tto s" + targetState + "\n");
            file.write(getIndents(indents) + "\t}\n");
            transNum++;
            
            String juncStateType = "s";
            
            
            if(!realGuards.isEmpty()) {
            	juncStateType = "x";
            	
            	
	            // Gen first transition
            	file.write(getIndents(indents) + "\ttransition t" + transNum + " {\n");
            	file.write(getIndents(indents) + "\t\tfrom s" + junctionState + "\n");
            	file.write(getIndents(indents) + "\t\tto x" + inputNum + "\n");
            	file.write(getIndents(indents) + "\t}\n");

            	transNum += 1;

            	for(int i = 0; i < realGuards.size()-1;i++) {
            		
            		file.write(getIndents(indents) + "\tstate x" + inputNum + " {}\n");
            		
            		// looping to prevent deadlock
            		
            		file.write(getIndents(indents) + "\ttransition t" + transNum + " {\n");
            		file.write(getIndents(indents) + "\t\tfrom x" + inputNum + "\n");
            		file.write(getIndents(indents) + "\t\tto x" + inputNum + "\n");
                    file.write(getIndents(indents) + "\t\texec\n");

            		file.write(getIndents(indents) + "\t\tcondition not $" + realGuards.get(i) +  " ? local" + realGuards.get(i)+"\n");

            		file.write(getIndents(indents) + "\t}\n");
            		transNum += 1;
            		
            		
            		file.write(getIndents(indents) + "\ttransition t" + transNum + " {\n");
            		file.write(getIndents(indents) + "\t\tfrom x" + inputNum + "\n");
            		inputNum += 1;
            		file.write(getIndents(indents) + "\t\tto x" + inputNum + "\n");
            		file.write(getIndents(indents) + "\t\tcondition " + "$ " + realGuards.get(i) + " ? local" + realGuards.get(i)+"\n");
            		file.write(getIndents(indents) + "\t}\n");
            		transNum += 1;
            	}

            	// Last one: connecting to junction
            	file.write(getIndents(indents) + "\tstate x" + inputNum + " {}\n");
            	
            	// looping to prevent deadlock
        		
        		file.write(getIndents(indents) + "\ttransition t" + transNum + " {\n");
        		file.write(getIndents(indents) + "\t\tfrom x" + inputNum + "\n");
        		file.write(getIndents(indents) + "\t\tto x" + inputNum + "\n");
                file.write(getIndents(indents) + "\t\texec\n");
        		file.write(getIndents(indents) + "\t\tcondition not $" + realGuards.get(realGuards.size()-1) + " ? local" + realGuards.get(realGuards.size()-1)+"\n");

        		file.write(getIndents(indents) + "\t}\n");
        		transNum += 1;
            	
            	file.write(getIndents(indents) + "\ttransition t" + transNum + " {\n");
        		file.write(getIndents(indents) + "\t\tfrom x" + inputNum + "\n");
        		inputNum += 1;
        		file.write(getIndents(indents) + "\t\tto j" + inputNum + "\n");
        		file.write(getIndents(indents) + "\t\tcondition " + "$ " + realGuards.get(realGuards.size()-1) + " ? local" + realGuards.get(realGuards.size()-1) +"\n");
        		file.write(getIndents(indents) + "\t}\n");
        		transNum += 1;


            	file.write(getIndents(indents) + "\tjunction j" + inputNum + "\n");

            	junctionState = inputNum;
            	inputNum += 1;
            	
            	juncStateType = "j";

            	// Gen last state

            	// link last state 
            
            //once generated the input chains, change the value of junction state to the last state
                
            } else {
            	//Removed
//            	juncStateType = "s";

            }
            

            
            
            
            for (WGuardedWorkflow branch : decision.options) {
            	
                //String guard = SLEECTKIntegration.exprToString(branch.guard);
                WWorkflow body = branch.body;                

	                if (body instanceof WTask && "Skip".equals(((WTask) body).ID)) {
	                    file.write(getIndents(indents) + "\ttransition t" + transNum + " {\n");
	                    file.write(getIndents(indents) + "\t\tfrom " + juncStateType + junctionState + "\n");
	                    
	                    file.write(getIndents(indents) + "\t\tto s" + endDecState + "\n");
	                    file.write(getIndents(indents) + "\t\tcondition " + SLEECTKIntegration.exprToString(branch.guard,true,realGuards)+ "\n");
	
	                    file.write(getIndents(indents) + "\t}\n");
	                    transNum++;
	                } else {
	                    int newDecState = stateNum;
	                    file.write(getIndents(indents) + "\ttransition t" + transNum + " {\n");
	                    file.write(getIndents(indents) + "\t\tfrom " + juncStateType + junctionState + "\n");
	                    file.write(getIndents(indents) + "\t\tto s" + newDecState + "\n");
	                    
	                    file.write(getIndents(indents) + "\t\tcondition " + SLEECTKIntegration.exprToString(branch.guard,true,realGuards) + "\n");
	                    file.write(getIndents(indents) + "\t}\n");
	                    transNum++;
	
	                    SearchResultState result = genWorkflow(body, file, newDecState, endDecState, transNum, stateNum,indents,guardList,inputNum);
	                    nextState = result.nextState;
	                    transNum = result.transNum;
	                    stateNum = result.stateNum;
	                    inputNum = result.inputNum;
	                }
	                stateNum++;
            }

            return new SearchResultState(nextState, transNum, stateNum,inputNum);

        } else if (wf instanceof WLoop) {
        	
        	
            WLoop loop = (WLoop) wf;
            
            ArrayList<String> realGuards = new ArrayList<String>();
            //Get the real guards
            
            workflowspec.MBoolExpr currentGuard = loop.loop.guard;
            realGuards.addAll(SLEECTKIntegration.getRealGuards(currentGuard, false));
      
            realGuards = new ArrayList<>(new HashSet<>(realGuards));
            

            //String guard = SLEECTKIntegration.exprToString(loop.loop.guard);
            
            if (realGuards.isEmpty()) {
	//removed
//	            int loopState = nextState;
//	            file.write(getIndents(indents) + "\tstate s" + loopState + " {}\n");
//	            stateNum++;
//	
//	            file.write(getIndents(indents) + "\ttransition t" + transNum + " {\n");
//	            file.write(getIndents(indents) + "\t\tfrom s" + loopState + "\n");
//	            file.write(getIndents(indents) + "\t\tto s" + stateNum + "\n");
//	            
//	            file.write(getIndents(indents) + "\t\tcondition " + SLEECTKIntegration.exprToString(loop.loop.guard,true,true,realGuards) + "\n");
//	            file.write(getIndents(indents) + "\t}\n");
//	            transNum++;
//	
//	            SearchResultState result = genWorkflow(loop.loop.body, file, stateNum, loopState, transNum, stateNum,indents,guardList,inputNum);
//	            nextState = result.nextState;
//	            transNum = result.transNum;
//	            stateNum = result.stateNum;
//	            inputNum = result.inputNum;
//	
//	            Not notExpr = WorkflowspecFactory.eINSTANCE.createNot();
//	            notExpr.setOp("not");
//	            notExpr.setExpr(loop.loop.guard);
//	            
//	            file.write(getIndents(indents) + "\ttransition t" + transNum + " {\n");
//	            file.write(getIndents(indents) + "\t\tfrom s" + loopState + "\n");
//	            file.write(getIndents(indents) + "\t\tto s" + targetState + "\n");
//	            file.write(getIndents(indents) + "\t\tcondition " + SLEECTKIntegration.exprToString(notExpr,true,true,realGuards) + "\n");
//	            file.write(getIndents(indents) + "\t}\n");
//	            transNum++;
//	
//	            return new SearchResultState(nextState, transNum, stateNum,inputNum);
            } else {
            	// REAL GUARDS IMPLEMENTATION
            	
            	//Catches the connection
            	int firstState = nextState;
            	file.write(getIndents(indents) + "\tstate s" + firstState + " {}\n");
            	//First input transition
            	
            	// looping to prevent deadlock
        		
        		file.write(getIndents(indents) + "\ttransition t" + transNum + " {\n");
        		file.write(getIndents(indents) + "\t\tfrom s" + firstState + "\n");
        		file.write(getIndents(indents) + "\t\tto s" + firstState + "\n");
                file.write(getIndents(indents) + "\t\texec\n");
        		file.write(getIndents(indents) + "\t\tcondition not $" + realGuards.get(0) + " ? local" + realGuards.get(0)+"\n");

        		file.write(getIndents(indents) + "\t}\n");
        		transNum += 1;
            	
                file.write(getIndents(indents) + "\ttransition t" + transNum + " {\n");
                file.write(getIndents(indents) + "\t\tfrom s" + firstState + "\n");
                
                file.write(getIndents(indents) + "\t\tto x" + inputNum + "\n");
                file.write(getIndents(indents) + "\t\tcondition " + "$ " + realGuards.get(0) + " ? local" + realGuards.get(0)+"\n");
                file.write(getIndents(indents) + "\t}\n");
                
                
                transNum += 1;
                
                
                ArrayList<String> guardsLeft = new ArrayList<String>(realGuards);
                guardsLeft.remove(0);
                //Looping x input states and transitions
                
                for(String guard : guardsLeft) {
                	file.write(getIndents(indents) + "\tstate x" + inputNum + " {}\n");
                	
                	//looping to prevent deadlock
            		file.write(getIndents(indents) + "\ttransition t" + transNum + " {\n");
            		file.write(getIndents(indents) + "\t\tfrom x" + inputNum + "\n");
            		file.write(getIndents(indents) + "\t\tto x" + inputNum + "\n");
                    file.write(getIndents(indents) + "\t\texec\n");
            		file.write(getIndents(indents) + "\t\tcondition not $" + guard + " ? local" + guard +"\n");

            		file.write(getIndents(indents) + "\t}\n");
            		transNum += 1;
                	
                    file.write(getIndents(indents) + "\ttransition t" + transNum + " {\n");
                    file.write(getIndents(indents) + "\t\tfrom x" +inputNum + "\n");
                    inputNum += 1;
                    file.write(getIndents(indents) + "\t\tto x" + inputNum + "\n");
                    file.write(getIndents(indents) + "\t\tcondition " + "$ " + guard + " ? local" + guard +"\n");
                    file.write(getIndents(indents) + "\t}\n");
                    transNum += 1; 	
                }
                
                //starting the loop
                

                int loopState = stateNum+maxStateGen(loop.loop.body);
                stateNum = loopState + 1;
                file.write(getIndents(indents) + "\tstate s" + loopState + " {}\n");

                //Connecting x inputs to loopState
            	file.write(getIndents(indents) + "\tstate x" + inputNum + " {}\n");
            	file.write(getIndents(indents) + "\ttransition t" + transNum + " {\n");
                file.write(getIndents(indents) + "\t\tfrom x" + inputNum + "\n");
                inputNum += 1;
                file.write(getIndents(indents) + "\t\tto s" + loopState + "\n");
                file.write(getIndents(indents) + "\t}\n");
                transNum += 1; 	
                
                //Hanging transition for contents
	            file.write(getIndents(indents) + "\ttransition t" + transNum + " {\n");
	            file.write(getIndents(indents) + "\t\tfrom s" + loopState + "\n");
	            file.write(getIndents(indents) + "\t\tto s" + stateNum + "\n");
	            file.write(getIndents(indents) + "\t\tcondition " + SLEECTKIntegration.exprToString(loop.loop.guard,true,realGuards) + "\n");
	            file.write(getIndents(indents) + "\t}\n");
	            transNum++;
                
	            //Creation of new state for the workflows to connect to before x inputs
	            int connectionNum = stateNum+maxStateGen(loop.loop.body);
            	file.write(getIndents(indents) + "\tstate s" + connectionNum + " {}\n");

	            
            	//body
	            
	            SearchResultState result = genWorkflow(loop.loop.body, file, stateNum, connectionNum, transNum, stateNum,indents,guardList,inputNum);
	            nextState = result.nextState;
	            transNum = result.transNum;
	            stateNum = result.stateNum;
	            inputNum = result.inputNum;
	            
	            //connection to second round of x inputs
	            
	            
	            
                file.write(getIndents(indents) + "\ttransition t" + transNum + " {\n");
                file.write(getIndents(indents) + "\t\tfrom s" + connectionNum + "\n");
                inputNum += 2;
                file.write(getIndents(indents) + "\t\tto x" + inputNum + "\n");
                file.write(getIndents(indents) + "\t\texec");
                file.write(getIndents(indents) + "\t}\n");
                transNum += 1;
	            
	            //second round of x inputs
	            
                for(String guard : realGuards) {
                	file.write(getIndents(indents) + "\tstate x" + inputNum + " {}\n");
                	
                	//looping to prevent deadlocks
            		file.write(getIndents(indents) + "\ttransition t" + transNum + " {\n");
            		file.write(getIndents(indents) + "\t\tfrom x" + inputNum + "\n");
            		file.write(getIndents(indents) + "\t\tto x" + inputNum + "\n");
                    file.write(getIndents(indents) + "\t\texec\n");
            		file.write(getIndents(indents) + "\t\tcondition not $" + guard +" ? local" + guard +"\n");

            		file.write(getIndents(indents) + "\t}\n");
            		transNum += 1;
                	
                    file.write(getIndents(indents) + "\ttransition t" + transNum + " {\n");
                    file.write(getIndents(indents) + "\t\tfrom x" +inputNum + "\n");
                    inputNum += 1;
                    file.write(getIndents(indents) + "\t\tto x" + inputNum + "\n");
                    file.write(getIndents(indents) + "\t\tcondition " + "$ " + guard + " ? local" + guard +"\n");
                    file.write(getIndents(indents) + "\t}\n");
                    transNum += 1; 	
                }
                
                //connecting second round of inputs to loop state
                
            	file.write(getIndents(indents) + "\tstate x" + inputNum + " {}\n");

                
            	file.write(getIndents(indents) + "\ttransition t" + transNum + " {\n");
                file.write(getIndents(indents) + "\t\tfrom x" + inputNum + "\n");
                inputNum += 1;
                file.write(getIndents(indents) + "\t\tto s" + loopState + "\n");
                file.write(getIndents(indents) + "\t}\n");
                transNum += 1; 	
                
                //connecting loopstate to target
	            Not notExpr = WorkflowspecFactory.eINSTANCE.createNot();
	            notExpr.setOp("not");
	            notExpr.setExpr(loop.loop.guard);
	            
	            file.write(getIndents(indents) + "\ttransition t" + transNum + " {\n");
	            file.write(getIndents(indents) + "\t\tfrom s" + loopState + "\n");
	            file.write(getIndents(indents) + "\t\tto s" + targetState + "\n");
	            file.write(getIndents(indents) + "\t\tcondition " + SLEECTKIntegration.exprToString(notExpr,true,realGuards) + "\n");
	            file.write(getIndents(indents) + "\t}\n");
	            transNum++;
	            return new SearchResultState(nextState, transNum, stateNum,inputNum);
            }
        }
        return null;
    }

    public static class MeasurePair{
    	public String guardName;
    	public String type;
    	public MeasurePair(String guardName,String type) {
    		this.guardName = guardName;
    		this.type = type;
    	}
    	

    }

    public static void genRoboSim(WWorkflow wf, FileWriter file, String sleecPath) throws IOException {
    	
    	SearchResult result = searchTasksGuardsNew(wf, new ArrayList<>(), new ArrayList<>(),new ArrayList<>());

    	
    	ArrayList<MeasurePair> measuresList = new ArrayList<MeasurePair>();
        Set<String> guards = new HashSet<>();
        Set<String> tasks = new HashSet<>();

        for (String guard : result.guardList) {
            if (!guard.contains("¬")) {
                guards.add(guard);
            }
        }
        for (String task : result.taskList) {
            if (!task.contains("Skip")) {
                tasks.add(task);
            }
        }

        
        //Extracting measures so that local var can be defined when STM is generated
        for(int x = 0; x < result.guardList.size();x++) {
        	if(result.guardTypeList.get(x).contains("real") || result.guardTypeList.get(x).contains("bool")) {
        		measuresList.add(new MeasurePair(result.guardList.get(x),result.guardTypeList.get(x)));
        		
        	}
        }

//        ArrayList<String> newMeasuresList = new ArrayList<String>();
//        for(MeasurePair measure : measuresList) {
//        	ArrayList<String> measureName = new ArrayList<String>();
//        	measureName.add(measure.guardName);
//        	
//        	
//        	
//        	//newMeasuresList.addAll(stripGuards(measureName));
//        	}
//        
        // removing duplicates
//        measuresList = new ArrayList<String>(stripGuards(measuresList));
        guards = new HashSet<String>(guards);
        measuresList = new ArrayList<>(new LinkedHashSet<>(measuresList));
        //bumper
        
    	genInterfaces(wf, file,0,guards,tasks,sleecPath,measuresList);
    	try {
    		genModuleController(wf,file,guards,tasks,0,measuresList);
    		} catch (Exception ex) {
    			System.out.println("IOERROR");
    		}
    	//WWorkflow wf,FileWriter file,Set<String> guards, Set<String> tasks,int indents
    }
    
    static class SearchResultState {
        int nextState;
        int transNum;
        int stateNum;
        int inputNum;

        SearchResultState(int nextState, int transNum, int stateNum,int inputNum) {
            this.nextState = nextState;
            this.transNum = transNum;
            this.stateNum = stateNum;
            this.inputNum = inputNum;
        }
    }
    
    public static String getIndents(int num) {
    	String inds = "";
    	for(int i = 0; i < num; i++) {
    		inds += "\t";
    	}
    	return inds;
    }
    
    public static String getSLEECDefs(String path) {
        String sleecDefs = "";

        try {
            Scanner scan = new Scanner(new File(path));
            scan.useDelimiter("def_end");

            if (scan.hasNext()) {
                sleecDefs = scan.next(); // only read until first "def_end"
            }

            scan.close();
            return sleecDefs;

        } catch (IOException e) {
            System.out.println("SLEEC FILE PATH ERROR");
        }

        return sleecDefs;
    }

    
    public static Set<String> getSLEECGuards(String sleecDefs) {
    	Set<String> SLEECGuards = new HashSet<String>();
    	Scanner scan = new Scanner(sleecDefs);
    	if (scan.hasNextLine()) {
            scan.nextLine();
        }
    	try {
		    while (scan.hasNextLine()) {
		        String line = scan.nextLine();
		        if(line.contains("def_end")) {
		        	break;
		        }
		        if(line.contains(":")) {
			        SLEECGuards.add(line.split(" ")[1]);
		        }
		    }
    	} catch (ArrayIndexOutOfBoundsException e) {
    		return SLEECGuards;
    	}
	        
        return SLEECGuards;
    }
    
    public static String getGuardType(String sleecDefs,String guard) {
        String result = "";

        Scanner scan = new Scanner(sleecDefs);
	    while (scan.hasNextLine()) {
	    	String line = scan.nextLine();
	
	        if (line.contains(guard) && line.contains(":")) {
	        	result = line;
	            break; // stop after first match
	        } else if (line.contains("def_end")) {
	        	break;
	        }
	    }

	    if(result.strip().equals("")) {
	    	return null;
	    }
        scan.close();

        if(result.contains("numeric")) {
        	return "real";
        } else {
        	return "boolean";
        }
    }
    
    
    public static int maxStateGen(WWorkflow workflow) {
    	ArrayList<Integer> counted = countElements(workflow);
    	
    	return (counted.get(0) *2) + counted.get(1) +  
    			(counted.get(2) *5) + (counted.get(4)*4) +
    			(counted.get(6)*2);
    }
    
    public static ArrayList<Integer> countElements(WWorkflow workflow) {
        int[] counts = new int[7];

        visitWorkflow(workflow, counts);

        ArrayList<Integer> result = new ArrayList<>(7);
        for (int c : counts) {
            result.add(c);
        }

        return result;
    }
    
    private static void visitWorkflow(WWorkflow wf, int[] counts) {
    	

        if (wf == null) {
            return;
        }

        if (wf instanceof WTask) {

            counts[0]++;

        } else if (wf instanceof WSequence) {

            counts[1]++;

            for (WWorkflow child :
                    ((WSequence) wf).subworkflows) {

                visitWorkflow(child, counts);
            }

        } else if (wf instanceof WLoop) {

            counts[2]++;

            WGuardedWorkflow loop =
                    ((WLoop) wf).loop;

            if (loop != null) {
                counts[3]++;          // loop option
                visitGuardedWorkflow(loop, counts);
            }

        } else if (wf instanceof WDecision) {

            counts[4]++;

            for (WGuardedWorkflow option :
                    ((WDecision) wf).options) {

                counts[5]++;          // decision option
                visitGuardedWorkflow(option, counts);
            }
        }
    }
    
    private static void visitGuardedWorkflow(
            WGuardedWorkflow gw,
            int[] counts) {

        if (gw == null) {
            return;
        }

        visitBoolExpr(gw.guard, counts);

        visitWorkflow(gw.body, counts);
    }
    
    private static void visitBoolExpr(
            MBoolExpr expr,
            int[] counts) {
    	
        if (expr == null) {
            return;
        }

        if (expr instanceof Atom) {

            counts[6]++;

        } else if (expr instanceof Not) {

            visitBoolExpr(
                ((Not) expr).getExpr(),
                counts);

        } else if (expr instanceof BoolComp) {

            BoolComp bc = (BoolComp) expr;

            visitBoolExpr(bc.getLeft(), counts);
            visitBoolExpr(bc.getRight(), counts);

        } else if (expr instanceof RelComp) {

            RelComp rc = (RelComp) expr;

            visitBoolExpr(rc.getLeft(), counts);
            visitBoolExpr(rc.getRight(), counts);

        }
        
    }
    
    
}

