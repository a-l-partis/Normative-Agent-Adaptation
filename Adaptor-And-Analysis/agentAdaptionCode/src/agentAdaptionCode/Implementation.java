package agentAdaptionCode;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;

import agent.adaption.xtext.workflow.WorkflowStandaloneSetup;
import circus.robocalc.sleec.SLEECStandaloneSetup;
import circus.robocalc.sleec.sLEEC.RuleBlock;
import circus.robocalc.sleec.sLEEC.SLEECFactory;
import circus.robocalc.sleec.sLEEC.Specification;
import workflowspec.Decision;
import workflowspec.GuardedWorkflow;
import workflowspec.Loop;
import workflowspec.MBoolExpr;
import workflowspec.Sequence;
import workflowspec.Task;
import workflowspec.Workflow;
import workflowspec.WorkflowStructure;
import workflowspec.WorkflowspecFactory;
import workflowspec.WorkflowspecPackage;

public class Implementation {

	public static void main(String[] args) {
		runAlgorithm("inputFiles/caseStudy/Chatbot.workflowspec","inputFiles/caseStudy/Chatbot-UniversalRules.sleec","output",true);
	}
	
public static WWorkflow runAlgorithm(String workflowPath, String sleecPath,String outputName,boolean save) {
	SLEECStandaloneSetup.doSetup();
	WorkflowStandaloneSetup.doSetup();
	
	final WorkflowspecPackage einstance = WorkflowspecPackage.eINSTANCE;
	
    WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
    
    //WfXMIToDSL();
    
    SLEECFactory factory1 = SLEECFactory.eINSTANCE;

    Specification sleec = SLEECparser(sleecPath);

    WorkflowStructure workflow = workflowParser(workflowPath);

	WWorkflow toAdapt = buildWorkflow(workflow,factory);

	ArrayList<Rule> ruleset = buildSLEECRuleSet(sleec,factory1);
	
	WWorkflow result = Adaptor.AdaptWorkflow(toAdapt,ruleset);

	toOutputWorkflow(result,outputName,save);
	
	if(save) {
		System.out.println("output workflow in: outputworkflows/" + outputName + ".workflowspec");
	}
	return result;
}
	
public static WorkflowStructure workflowParser(String workflowFilePath) {
	File wf = new File(workflowFilePath);
	try {
	URL url = wf.toURI().toURL();
	org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createURI(url.toString());
	XtextResourceSet rs = new XtextResourceSet();
	Resource r = rs.getResource(uri, true);
	try {
		r.load(null);
		WorkflowStructure wfInput = (WorkflowStructure) r.getContents().get(0);
		if(!r.getErrors().isEmpty()) {
			System.out.println("MALFORMED INPUT FILE:\n" + r.getErrors());
		}
		return wfInput;
	
	} catch (FileNotFoundException e) {
		return null;
	} catch (IOException e) {
		System.out.println("CAN'T LOAD");
		return null;
	}
	} catch (MalformedURLException e) {
		System.out.println("MALFORMED INPUT");
		return null;
	}
}

public static void toOutputWorkflow(WWorkflow wf,String outputName,boolean save) {
	if(save) {
		try {
			FileWriter file = new FileWriter("outputWorkflows/outputWorkflow-" + outputName + ".workflowspec");
			OutputWorkflow(wf,file);
			file.close();
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
}

public static void OutputWorkflow(WWorkflow wf,FileWriter file) throws IOException {
	file.write("WorkflowStructure {\n\t workflowspec ");
	writeOutput(wf,file,1);
	file.write("\n}");
}

public static String indent(int indents) {
	String output = "";
	for(int x = 0; x < indents; x++) {
		output += "\t";
	}
	return output;
}

public static void writeOutput(WWorkflow wf, FileWriter file,int indents)throws IOException {
	switch(wf) {
	
		case WTask x:
			WTask task = (WTask) x; 
			file.write("Task {\n" + indent(indents+1) + "ID \"" + task.ID + "\"}");
			break;
			
		case WSequence x:
			WSequence seq = (WSequence) x;
			file.write("Sequence {\n" + indent(indents+1) + "subworkflows {\n");
			file.write(indent(indents+2));
			int length = seq.subworkflows.size();
			for(int subwfNum = 0; subwfNum < length-1; subwfNum++) {
				writeOutput(seq.subworkflows.get(subwfNum),file,indents+2);
				file.write(",\n" + indent(indents+2));
			}
			writeOutput(seq.subworkflows.getLast(),file,indents+2);
			file.write("\n" + indent(indents+1) + "}\n" + indent(indents) + "}");
			break;
			
		case WLoop x:
			WLoop loop = (WLoop) x;
			file.write("Loop {\n" + indent(indents+1) + "loop GuardedWorkflow ");
			file.write("{\n" + indent(indents+2) + "body ");
			writeOutput(loop.loop.body,file,indents+2);
			file.write("\n" + indent(indents+2) + "guard ");
			writeExpr(loop.loop.guard,file,indents+2);
			file.write("\n" + indent(indents+1) + "}\n" + indent(indents) + "}");
			break;
			
		case WDecision x:
			WDecision dec = (WDecision) x;
			file.write("Decision {\n" + indent(indents+1) + "options {\n");
			file.write(indent(indents+2));
			int width = dec.options.size();
			for(int opwfNum = 0; opwfNum < width-1; opwfNum++) {
				file.write("GuardedWorkflow {\n" + indent(indents+3) + "body ");
				writeOutput(dec.options.get(opwfNum).body,file,indents+3);
				file.write("\n" + indent(indents+3) + "guard ");
				writeExpr(dec.options.get(opwfNum).guard,file,indents+3);
				file.write("\n" + indent(indents+2) + "},\n" + indent(indents+2));
			}
			file.write("GuardedWorkflow {\n" + indent(indents+3) + "body ");
			writeOutput(dec.options.getLast().body,file,indents+3);
			file.write("\n" + indent(indents+3) + "guard ");
			writeExpr(dec.options.getLast().guard,file,indents+3);
			file.write("\n" + indent(indents+2) + "}\n" + indent(indents+1));
			file.write("}\n" + indent(indents) + "}");
			break;
	default:
		System.out.println("ERROR");
	}
}

public static void writeExpr(workflowspec.MBoolExpr expr,FileWriter file, int indents)throws IOException{
	switch(expr) {

		case workflowspec.BoolComp x:
			workflowspec.BoolComp comp = (workflowspec.BoolComp) x;
			
			String andOr = comp.getOp().toString();
			file.write("BoolComp {\n" + indent(indents+1) + "op " + andOr);
			file.write("\n" + indent(indents+1) + "right ");
			writeExpr(comp.getRight(),file,indents+1);
			file.write("\n" + indent(indents+1) + "left ");
			writeExpr(comp.getLeft(),file,indents+1);
			file.write("\n" + indent(indents) + "}");
			break;
		
		case workflowspec.Atom x:
			workflowspec.Atom atom = (workflowspec.Atom) x;
			file.write("Atom {\n" + indent(indents+1) + "measureID \"");
			file.write(atom.getMeasureID() + "\"\n" + indent(indents) + "}");
			break;
			
		case workflowspec.Not x:
			workflowspec.Not not = (workflowspec.Not) x;
			file.write("Not {\n" + indent(indents+1) + "op " + "not");
			file.write("\n" + indent(indents+1) + "expr ");
			writeExpr(not.getExpr(),file,indents);
			file.write("\n" + indent(indents) + "}");
			break;
		
		case workflowspec.RelComp x:
			workflowspec.RelComp relcomp = (workflowspec.RelComp) x;
			String rel = relcomp.getOp().toString();
			file.write("RelComp {\n" + indent(indents+1) + "op " + rel);
			file.write("\n" + indent(indents+1) + "left ");
			writeExpr(relcomp.getLeft(),file,indents+1);
			file.write("\n" + indent(indents+1) + "right ");
			writeExpr(relcomp.getRight(),file,indents+1);
			file.write("\n" + indent(indents) + "}");
			break;
		case workflowspec.Value x:
			workflowspec.Value value = (workflowspec.Value) x;
			file.write("Value {\n" + indent(indents+1) + "value ");
			file.write(value.getValue() + "\n" + indent(indents) + "}");
			break;
		default:
			System.out.println("ERROR");
	}
}
	
public static Specification SLEECparser(String sleecFilePath) {
	File sleec = new File(sleecFilePath);
	try {
	URL url = sleec.toURI().toURL();
	org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createURI(url.toString());
	XtextResourceSet rs = new XtextResourceSet();
	Resource r = rs.getResource(uri, true);
	//InputStream in = new FileInputStream(f);
	//InputStream in = new ByteArrayInputStream("Project Acme {}".getBytes());
	try {
		r.load(null);
		Specification sleecInput = (Specification) r.getContents().get(0);
		if(!r.getErrors().isEmpty()) {
			System.out.println("SLEEC Problems:" +  r.getErrors());
		}
		return sleecInput;
		
	} catch (IOException e) {
		System.out.println("CAN'T LOAD");
		return null;
	}
	} catch (MalformedURLException e) {
		System.out.println("MALFORMED");
		return null;
	}
}

	public static ArrayList<Rule> buildSLEECRuleSet(Specification sleecModel,SLEECFactory factory) {
		RuleBlock ruleBlock = sleecModel.getRuleBlock();
		ArrayList<agentAdaptionCode.Rule> compiledRules = new ArrayList<Rule>();
		for(circus.robocalc.sleec.sLEEC.Rule currentRule : ruleBlock.getRules()) {
			compiledRules.add(buildSLEECRule(currentRule,factory));
		}
		return compiledRules;
	}
	
	public static agentAdaptionCode.Rule buildSLEECRule(circus.robocalc.sleec.sLEEC.Rule rule, SLEECFactory factory) {
		String trigger = rule.getTrigger().getEvent().getName();
		circus.robocalc.sleec.sLEEC.MBoolExpr guard = rule.getTrigger().getExpr();
		ArrayList<agentAdaptionCode.Defeater> defeaters =
				new ArrayList<agentAdaptionCode.Defeater>();
		String response = rule.getResponse().getConstraint().getEvent().getName();
		
		for(circus.robocalc.sleec.sLEEC.Defeater defeater : rule.getResponse().getDefeater()) {
			defeaters.add(buildSLEECDefeater(defeater));
		}
		agentAdaptionCode.Defeater[] allDefeaters = 
				new agentAdaptionCode.Defeater[defeaters.size()];
				
		allDefeaters = defeaters.toArray(allDefeaters);
        
		String ruleResponse = rule.getResponse().getConstraint().getEvent().getName();
		
		
		return new agentAdaptionCode.Rule(trigger,guard,ruleResponse,allDefeaters);
	}
	
	public static agentAdaptionCode.Defeater buildSLEECDefeater(circus.robocalc.sleec.sLEEC.Defeater defeater){
		try {
			String response = defeater.getResponse().getConstraint().getEvent().getName();
			circus.robocalc.sleec.sLEEC.MBoolExpr guard = defeater.getExpr();
			return new agentAdaptionCode.Defeater(guard,response);
		} catch (NullPointerException e) {
			circus.robocalc.sleec.sLEEC.MBoolExpr guard = defeater.getExpr();
			return new agentAdaptionCode.Defeater(guard, null);
		}
	}
	
	
	public static WWorkflow buildWorkflow(WorkflowStructure modelWorkflow,WorkflowspecFactory factory) {
		workflowspec.Workflow topLevel = modelWorkflow.getWorkflowspec();
		if(topLevel == null) {
			System.out.println("Error: malformed workflow");
		}
		
		switch(topLevel) {
		
			case Task t:
				WTask task = new WTask(t.getID()); 
				return task;
				
			case Sequence e:
				ArrayList<WWorkflow> subElements = new ArrayList<>();
				while(!(e.getSubworkflows().isEmpty())) {
					
					Workflow subworkflow = e.getSubworkflows().getFirst();
					WorkflowStructure struct = factory.createWorkflowStructure();
					struct.setWorkflowspec(subworkflow);
					WWorkflow returned = buildWorkflow(struct,factory);
					subElements.add(returned);
				}
				return new WSequence(subElements);
				
			case Decision e:
				ArrayList<WGuardedWorkflow> options = new ArrayList<>();
				
				Iterator<GuardedWorkflow> recievedOptions = e.getOptions().iterator();
				
				while(recievedOptions.hasNext()) {
					GuardedWorkflow branch = recievedOptions.next();
					WorkflowStructure struct = factory.createWorkflowStructure();
					Workflow body = branch.getBody();
					struct.setWorkflowspec(body);
					
					WWorkflow convertedBody = buildWorkflow(struct, factory);
					workflowspec.MBoolExpr guard = branch.getGuard();
					options.add(new WGuardedWorkflow(guard,convertedBody));

				}
				return new WDecision(options);
				
			case Loop e:
//				workflowspec.MBoolExpr guard = e.getLoop().getGuard();
//				GuardedWorkflow var = e.getLoop();
//				WWorkflow body = buildWorkflow((WorkflowStructure) e.getLoop().getBody(),factory);
//				WGuardedWorkflow gW = new WGuardedWorkflow(guard,body);
//				
				// NEW BIT:
				
				GuardedWorkflow guarded = e.getLoop();
				WorkflowStructure struct = factory.createWorkflowStructure();
				Workflow gwBody = guarded.getBody();
				struct.setWorkflowspec(gwBody);
				
				WWorkflow convertedBody = buildWorkflow(struct, factory);
				workflowspec.MBoolExpr gwguard = guarded.getGuard();
				WGuardedWorkflow newGw = new WGuardedWorkflow(gwguard,convertedBody);
				return new WLoop(newGw);
				//return new WLoop(gW);
			default:
				// should never run
				System.out.println("ERROR: Unmatched workflow");
				return new WTask("");
		}
	}

}
