package agentAdaptionCode;

import circus.robocalc.sleec.sLEEC.*;

public class Rule {
	String trigger;
	MBoolExpr guard;
	String response;
	Defeater[] defeaters;

	public Rule(String trigger, MBoolExpr guard, String body,Defeater[] defeaters) {
		this.trigger = trigger;
		this.guard = guard;
		this.response = body;
		this.defeaters = defeaters;
	}
	
	public String toString() {
		if (!(guard == null)) {
		String output = "When " + this.trigger + " and " + SLEECTKIntegration.exprToString(guard) + " then " + response;
		return output + this.toStringDefeaters();
		} else {
			String output = "When " + this.trigger + " then " + response;
			return output + this.toStringDefeaters();
		}
	}
	
	public String toStringDefeaters() {
		String output = "\n";
		for(Defeater defeater : this.defeaters) {
			output += defeater.toString() + "\n";
		}
		return output;
	}
}
