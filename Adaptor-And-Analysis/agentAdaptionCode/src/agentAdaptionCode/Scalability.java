package agentAdaptionCode;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import agent.adaption.xtext.workflow.*;

import circus.robocalc.sleec.SLEECStandaloneSetup;
import circus.robocalc.sleec.sLEEC.SLEECFactory;
import circus.robocalc.sleec.sLEEC.Specification;
import agentAdaptionCode.*;
import workflowspec.WorkflowStructure;
import workflowspec.WorkflowspecFactory;
import workflowspec.WorkflowspecPackage;

public class Scalability {
	public static void main(String[] args) {
		//ExperimentDefeaterRules();

		ExperimentSLEECRules();
		System.out.println("done");
	}
	
	public static long average(ArrayList<Long> nums) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) 
        {
        	long x = nums.get(i);
            sum += x;
        }
        long average = (long)sum / nums.size();
        return average;
		
	}
	
	public static long runMultTimes(int times,String workflowFile, String sleecFile) {
		SLEECStandaloneSetup.doSetup();
		WorkflowStandaloneSetup.doSetup();
		final WorkflowspecPackage einstance = WorkflowspecPackage.eINSTANCE;
	    WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
	    SLEECFactory factory1 = SLEECFactory.eINSTANCE;
	    
	    Specification sleec = Implementation.SLEECparser(sleecFile);

	    WorkflowStructure workflow = Implementation.workflowParser(workflowFile);
	    
	    WWorkflow toAdapt = Implementation.buildWorkflow(workflow,factory);

		ArrayList<Rule> ruleset = Implementation.buildSLEECRuleSet(sleec,factory1);
		
		for(int x = 0; x <= 200; x++) {
			Adaptor.AdaptWorkflow(toAdapt,ruleset);
		}
		ArrayList<Long> timesList = new ArrayList<Long>();

		for(int x=0;x<times;x++) {
			long start = System.currentTimeMillis();
			WWorkflow result = Adaptor.AdaptWorkflow(toAdapt,ruleset);
			//Implementation.toOutputWorkflow(result,"",false);
			long end = System.currentTimeMillis();
			timesList.add(end-start);

		}
		System.out.println("av: " + average(timesList));
		return average(timesList);
	}
	
	public static void ExperimentDefeaterRules() {
		SLEECStandaloneSetup.doSetup();
		
		WorkflowStandaloneSetup.doSetup();
		final WorkflowspecPackage einstance = WorkflowspecPackage.eINSTANCE;


        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        SLEECFactory factory1 = SLEECFactory.eINSTANCE;
        
        ArrayList<String> taskCount = new ArrayList<String>();
        ArrayList<String> times = new ArrayList<String>();
        
        System.out.println(runMultTimes(500,"scalability/workflows/scalability1.workflowspec","scalability/sleecRules/rulestest25.sleec"));
        //3
        for(int defeaterNum = 3; defeaterNum <= 10; defeaterNum = 3*defeaterNum) {
        	
        	
        	String sleecFile = "scalability/defeaterRules/defeaters" + defeaterNum + ".sleec";
        	Specification sleec = Implementation.SLEECparser(sleecFile);

    	    WorkflowStructure workflow = Implementation.workflowParser("scalability/workflows/scalability1.workflowspec");
    	    
    	    WWorkflow toAdapt = Implementation.buildWorkflow(workflow,factory);

    		ArrayList<Rule> ruleset = Implementation.buildSLEECRuleSet(sleec,factory1);
    		
    		for(int x = 0; x <= 50; x++) {
    			Adaptor.AdaptWorkflow(toAdapt,ruleset);
    		}

    		for(int x = 1; x < 1000; x++) {
				String path = "scalability/workflows/scalability" + Integer.toString(x) + ".workflowspec";
				Path formalPath = Paths.get(path);
				
				if (Files.exists(formalPath)) {
					taskCount.add(Integer.toString(x));
					times.add(Long.toString(runMultTimes(10,path,sleecFile)));
					}
			}
			String fileName = "results-VaryingDefeaters-"+ defeaterNum + "Defeaters";
			writeToCSV(taskCount,times,fileName);
			taskCount.removeAll(taskCount);
			times.removeAll(times);
        }
	}
	
	
	public static void ExperimentSLEECRules() {
		SLEECStandaloneSetup.doSetup();
		
		WorkflowStandaloneSetup.doSetup();

        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        SLEECFactory factory1 = SLEECFactory.eINSTANCE;
        
        ArrayList<String> taskCount = new ArrayList<String>();
        ArrayList<String> times = new ArrayList<String>();
        
        System.out.println(runMultTimes(500,"scalability/workflows/scalability1.workflowspec","scalability/sleecRules/rulestest25.sleec"));
        for(int SLEECNum = 25; SLEECNum < 626; SLEECNum = 5* SLEECNum) {
        	
        	String sleecFile = "scalability/sleecRules/rulestest" + SLEECNum + ".sleec";
			for(int x = 0; x < 1000; x++) {
				String path = "scalability/workflows/scalability" + Integer.toString(x) + ".workflowspec";
				Path formalPath = Paths.get(path);
				
				if (Files.exists(formalPath)) {
					System.out.println(x);
					
					//WorkflowStructure workflow = Implementation.workflowParser(path);
					taskCount.add(Integer.toString(x));
					times.add(Long.toString(runMultTimes(10,path,sleecFile)));
					}
			}
			String fileName = "results-VaryingSLEEC-"+ SLEECNum + "Rules";
			writeToCSV(taskCount,times,fileName);
			taskCount.removeAll(taskCount);
			times.removeAll(times);
			
        }
	}
	
	public static void writeToCSV(ArrayList<String> taskCount,ArrayList<String> times,String fileName) {
		String taskCountLine = toCSVFormat(taskCount) + "\n";
		String timesLine = toCSVFormat(times);
		
		try {
			FileWriter file = new FileWriter("scalability/csvFiles/" + fileName + ".csv");
			file.write(taskCountLine);
			file.write(timesLine);
			
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
	
	public static String toCSVFormat(ArrayList<String> list) {
		String output = "";
		for(String x : list) {
			output += x + ",";
		}
		output = output.substring(0,output.length()-1);
		return output;
	}
	
}
