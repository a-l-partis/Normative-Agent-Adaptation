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
		JulyExperimentDefeaters();
		JulyExperimentSLEECRules();
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

		ArrayList<Rule> ruleset = Implementation.buildSLEECRuleSet(sleec,factory1);

		WWorkflow toAdapt = Implementation.buildWorkflow(workflow,factory);


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


	
	public static void writeToCSV(int sleecNum,int indexNum,ArrayList<String> taskCount,ArrayList<Long> times,String folder) {
		
		String taskCountLine = toCSVFormatFromString(taskCount) + "\n";
		String timesLine = toCSVFormatFromLong(times);

		
		
		String fileName = "SLEEC" + Integer.toString(sleecNum) + "-" + Integer.toString(indexNum);
		
		try {
			FileWriter file = new FileWriter("scalabilityJuly/" + folder + "/" + fileName + ".csv");
			file.write(taskCountLine);
			file.write(timesLine);

			if(file != null) try {
				file.close();
			} catch (Exception ex) {
				System.out.println("CRASHING HERE");
			}
		} catch (IOException e) {
			System.out.println("File handling error.");
			e.printStackTrace();
		}
	}

	public static String toCSVFormatFromString(ArrayList<String> list) {
		String output = "";
		for(String x : list) {
			output += x + ",";
		}
		output = output.substring(0,output.length()-1);
		return output;
	}
	
	public static String toCSVFormatFromLong(ArrayList<Long> list) {
		String output = "";
		for(Long x : list) {
			output += x.toString() + ",";
		}
		
		output = output.substring(0,output.length()-1);
		return output;
	}

	public static void JulyExperimentSLEECRules() {

		SLEECStandaloneSetup.doSetup();
		WorkflowStandaloneSetup.doSetup();
		final WorkflowspecPackage einstance = WorkflowspecPackage.eINSTANCE;
		WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
		SLEECFactory factory1 = SLEECFactory.eINSTANCE;


		int[] indexes = {1,2,3,4,5,6,7,8,9,10};
		for(int x : indexes) {
			//Contains the numbers of the workflows used and the related time results
			ArrayList<String> taskCount = new ArrayList<String>();


			String sleecPath25 = "scalabilityJuly/SLEECInput/SLEEC25/25" + "Rules" + Integer.toString(x) + ".sleec";
			String sleecPath125 = "scalabilityJuly/SLEECInput/SLEEC125/125" + "Rules" + Integer.toString(x) + ".sleec";
			String sleecPath625 = "scalabilityJuly/SLEECInput/SLEEC625/625" + "Rules" + Integer.toString(x) + ".sleec";


			Specification sleec25 = Implementation.SLEECparser(sleecPath25);
			ArrayList<Rule> ruleset25 = Implementation.buildSLEECRuleSet(sleec25,factory1);
			
			Specification sleec125 = Implementation.SLEECparser(sleecPath125);
			ArrayList<Rule> ruleset125 = Implementation.buildSLEECRuleSet(sleec125,factory1);

			Specification sleec625 = Implementation.SLEECparser(sleecPath625);
			ArrayList<Rule> ruleset625 = Implementation.buildSLEECRuleSet(sleec625,factory1);

			ArrayList<Long> times25 = new ArrayList<Long>();
			ArrayList<Long> times125 = new ArrayList<Long>();
			ArrayList<Long> times625 = new ArrayList<Long>();

			for(int w = 0; w < 11000; w++) {
				String path = "scalabilityJuly/InputWorkflows/WorkflowSet" + Integer.toString(x) + 
						"/workflow-" + Integer.toString(w) + "Tasks.workflowspec";
				Path wfPath = Paths.get(path);
				//Find the workflow numbers
				if (Files.exists(wfPath)) {
					taskCount.add(Integer.toString(w));

				WorkflowStructure workflow = Implementation.workflowParser(path); 
				WWorkflow wf = Implementation.buildWorkflow(workflow,factory);
				long start25 = System.nanoTime();
				WWorkflow result25 = Adaptor.AdaptWorkflow(wf,ruleset25);
				long end25 = System.nanoTime();
				long time25 = end25 - start25;
				times25.add(time25);
				
				if (result25 == null) System.out.println("Error"); //
				
				long start125 = System.nanoTime();
				WWorkflow result125 = Adaptor.AdaptWorkflow(wf,ruleset125);
				long end125 = System.nanoTime();
				long time125 = end125 - start125;
				times125.add(time125);
				
				if (result125 == null) System.out.println("Error"); //
				

				long start625 = System.nanoTime();
				WWorkflow result625 = Adaptor.AdaptWorkflow(wf,ruleset625);
				long end625 = System.nanoTime();
				long time625 = end625 - start625;
				times625.add(time625);
				
				if (result625 == null) System.out.println("Error"); //

				}
				
				
			}
			System.out.println(taskCount);
			System.out.println("\n");
			System.out.println(times25);
			writeToCSV(25,x,taskCount,times25,"SleecCSVOutput");
			writeToCSV(125,x,taskCount,times125,"SleecCSVOutput");
			writeToCSV(625,x,taskCount,times625,"SleecCSVOutput");
		}
	}

	public static void JulyExperimentDefeaters() {

		SLEECStandaloneSetup.doSetup();
		WorkflowStandaloneSetup.doSetup();
		final WorkflowspecPackage einstance = WorkflowspecPackage.eINSTANCE;
		WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
		SLEECFactory factory1 = SLEECFactory.eINSTANCE;


		int[] indexes = {1,2,3,4,5,6,7,8,9,10};
		for(int x : indexes) {
			//Contains the numbers of the workflows used and the related time results
			ArrayList<String> taskCount = new ArrayList<String>();


			String sleecPath3 = "scalabilityJuly/SLEECInput/SLEECDef3/10000" + "Rules-3Defeaters" + Integer.toString(x) + ".sleec";
			String sleecPath9 = "scalabilityJuly/SLEECInput/SLEECDef9/10000" + "Rules-9Defeaters" + Integer.toString(x) + ".sleec";
			String sleecPath27 = "scalabilityJuly/SLEECInput/SLEECDef27/10000" + "Rules-27Defeaters" + Integer.toString(x) + ".sleec";


			Specification sleec3 = Implementation.SLEECparser(sleecPath3);
			ArrayList<Rule> ruleset3 = Implementation.buildSLEECRuleSet(sleec3,factory1);
			
			Specification sleec9 = Implementation.SLEECparser(sleecPath9);
			ArrayList<Rule> ruleset9 = Implementation.buildSLEECRuleSet(sleec9,factory1);

			Specification sleec27 = Implementation.SLEECparser(sleecPath27);
			ArrayList<Rule> ruleset27 = Implementation.buildSLEECRuleSet(sleec27,factory1);

			ArrayList<Long> times3 = new ArrayList<Long>();
			ArrayList<Long> times9 = new ArrayList<Long>();
			ArrayList<Long> times27 = new ArrayList<Long>();

			for(int w = 0; w < 11000; w++) {
				String path = "scalabilityJuly/InputWorkflows/WorkflowSet" + Integer.toString(x) + 
						"/workflow-" + Integer.toString(w) + "Tasks.workflowspec";
				Path wfPath = Paths.get(path);
				//Find the workflow numbers
				if (Files.exists(wfPath)) {
					taskCount.add(Integer.toString(w));
				
				


				WorkflowStructure workflow = Implementation.workflowParser(path); 
				WWorkflow wf = Implementation.buildWorkflow(workflow,factory);


				long start3 = System.nanoTime();
				WWorkflow result3 = Adaptor.AdaptWorkflow(wf,ruleset3);
				long end3 = System.nanoTime();
				long time3 = end3 - start3;
				times3.add(time3);
				
				if (result3 == null) System.out.println("Error"); //
				
				long start9 = System.nanoTime();
				WWorkflow result9 = Adaptor.AdaptWorkflow(wf,ruleset9);
				long end9 = System.nanoTime();
				long time9 = end9 - start9;
				times9.add(time9);
				
				if (result9 == null) System.out.println("Error"); //
				

				long start27 = System.nanoTime();
				WWorkflow result27 = Adaptor.AdaptWorkflow(wf,ruleset27);
				long end27 = System.nanoTime();
				long time27 = end27 - start27;
				times27.add(time27);
				
				if (result27 == null) System.out.println("Error"); //

				}
				
				
			}
			
			System.out.println(x);

			writeToCSV(3,x,taskCount,times3,"DefeatersCSVOutput");
			writeToCSV(9,x,taskCount,times9,"DefeatersCSVOutput");
			writeToCSV(27,x,taskCount,times27,"DefeatersCSVOutput");
		}
	}

}
