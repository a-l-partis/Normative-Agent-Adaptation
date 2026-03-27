package agentAdaptionCode;
import circus.robocalc.sleec.sLEEC.*;;

public class Defeater {
	MBoolExpr guard;
	String response;

	public Defeater(MBoolExpr guard, String body) {
		this.guard = guard;
		this.response = body;
	}
		
	public String toString() {
		if(this.response == null) {
			return "unless " + SLEECTKIntegration.exprToString(this.guard);
			
		} else {
			return "unless " + SLEECTKIntegration.exprToString(this.guard) + " then " + this.response;
		}
	}
}
