package agentAdaptionCode;

import java.util.ArrayList;
import java.util.Arrays;
import workflowspec.*;

public class Adaptor {
	public static WWorkflow AdaptWorkflow(WWorkflow workflow,
			ArrayList<Rule> ruleset) {
		switch(workflow) {
			case WTask x:
				WTask task = (WTask) workflow;
				ArrayList<Rule> startRules = 
						getRulesByTriggerEvent(ruleset,task.ID+"Start");
				ArrayList<Rule> endRules = 
						getRulesByTriggerEvent(ruleset,task.ID+"End");
				if(startRules.isEmpty() && endRules.isEmpty()) {
					return workflow;
				}
				WSequence sequence  = new WSequence(new ArrayList<WWorkflow>());
				for(Rule rule : startRules) {
					WWorkflow SLEECWorkflow = genFromSLEEC(rule);
					sequence = addSubWorkflow(sequence,SLEECWorkflow);
				}
				sequence = addSubWorkflow(sequence,workflow);
				
				for(Rule rule : endRules) {
					WWorkflow SLEECWorkflow = genFromSLEEC(rule);
					sequence = addSubWorkflow(sequence,SLEECWorkflow);
				}
				return sequence;
				
			case WSequence x:
				WSequence castSequence = (WSequence) workflow;
				WSequence refinedSequence = new WSequence(new ArrayList<WWorkflow>());
				for(WWorkflow subworkflow : castSequence.subworkflows) {
					WWorkflow refinedSubworkflow = AdaptWorkflow(subworkflow,ruleset);
					refinedSequence = addSubWorkflow(refinedSequence, refinedSubworkflow);
				}
				
				return refinedSequence;
		
		case WDecision x :
			WDecision castDecision = (WDecision) workflow;
			ArrayList<WGuardedWorkflow> SLEECOptions = new ArrayList<>();
			for(WGuardedWorkflow branch : castDecision.options) {
				SLEECOptions.add(new WGuardedWorkflow(branch.guard,
						AdaptWorkflow(branch.body,ruleset)));
			}
			WDecision refinedDecision = new WDecision(SLEECOptions);
			return refinedDecision;
		
		case WLoop x:
			WLoop castLoop = (WLoop) workflow;
			WWorkflow refinedBody = AdaptWorkflow(castLoop.loop.body,ruleset);
			WLoop refinedLoop = new WLoop(new WGuardedWorkflow(castLoop.loop.guard,
					refinedBody));
			return refinedLoop;
		default:
			//should never run
			System.out.println("ERROR: Unmatched workflow");
			return workflow;
		}
	}
	
	public static ArrayList<Rule> getRulesByTriggerEvent(ArrayList<Rule> ruleset, 
			String trigger){
		ArrayList<Rule> Triggered = new ArrayList<>();
		for(int i = 0; i < ruleset.size(); i++) {
			Rule rule = ruleset.get(i);
			if(rule.trigger.equals(trigger)) {
				Triggered.add(rule);
			}
		}
		return Triggered;
	}
	
	
	public static WSequence addSubWorkflow(WSequence workflow, 
			WWorkflow toAdd) {
		switch(toAdd) {

		case WSequence x:
			WSequence addingSeq = (WSequence) toAdd;
			for(WWorkflow element : addingSeq.subworkflows) {
				workflow.subworkflows.add(element);
			}
			break;
			
		default:
			workflow.subworkflows.add(toAdd);
			break;
		}
		return workflow;
		
	}
	
	public static WWorkflow RuleWorkflow(Rule rule) {
		if(rule.guard == null) {
			return new WTask(rule.response);
		} else {
			ArrayList<WGuardedWorkflow> decisionList = new ArrayList<>();
			decisionList.add(new WGuardedWorkflow(SLEECTKIntegration.convExpr(rule.guard), 
					new WTask(rule.response)));
			decisionList.add(new WGuardedWorkflow(SLEECTKIntegration.not(SLEECTKIntegration.convExpr(rule.guard)), 
					new WTask("Skip")));
			return new WDecision(decisionList);
		}
	}
	
	public static WWorkflow genFromSLEEC(Rule rule) {
		WWorkflow ruleGen = RuleWorkflow(rule);
		ArrayList<Defeater> defeaters = new ArrayList<>(Arrays.asList(rule.defeaters));
		return genDefeaters(ruleGen,defeaters);
	}
	
	public static WWorkflow genDefeaters(WWorkflow ruleGen,
			ArrayList<Defeater> defeaters) {
		if(defeaters.isEmpty()) {
			return ruleGen;
		} else {
			ArrayList<WGuardedWorkflow> decisionList = new ArrayList<>();
			
			decisionList.add(
					new WGuardedWorkflow(SLEECTKIntegration.convExpr(defeaters.get(defeaters.size()-1).guard),
					new WTask(defeaters.get(defeaters.size()-1).response)));
			
			ArrayList<Defeater> nextDefeaters = new ArrayList<>();
			for(int i = 0; i < defeaters.size()-1; i++) {
				nextDefeaters.add(defeaters.get(i));
			}
			workflowspec.MBoolExpr guard = SLEECTKIntegration.convExpr(defeaters.get(defeaters.size()-1).guard);
			decisionList.add(
					new WGuardedWorkflow(SLEECTKIntegration.not(guard),
					genDefeaters(ruleGen,nextDefeaters)));
			return new WDecision(decisionList);
			
		}
	}
	
	

}

