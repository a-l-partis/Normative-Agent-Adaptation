package agentAdaptionCode;

import circus.robocalc.sleec.sLEEC.*;

import workflowspec.*;

public class WGuardedWorkflow extends WWorkflow{
	public workflowspec.MBoolExpr guard;
	public WWorkflow body;

	public WGuardedWorkflow (workflowspec.MBoolExpr guard,WWorkflow body) {
		this.guard = guard;
		
		if(body instanceof WTask) {
			if (((WTask)body).ID == null){
				this.body = new WTask("Skip");
			} else {
				this.body = body;
			}
			
		} else {
			this.body = body;
		}
	}
	
	public String getStr(int depth) {
		String tabs = "";
		for(int i = 0; i < depth; i++) {
			tabs += "\t";
		}
		if(this.body instanceof WTask) {
			WTask castBody = (WTask) this.body;
			return tabs + "GuardedWorkflow(guard: " + SLEECTKIntegration.exprToString(this.guard,true,false) + ", body:" + castBody.toString() + ")";	
		} else {
			return tabs + "GuardedWorkflow(guard: " + SLEECTKIntegration.exprToString(this.guard,true,false) + ", body:\n" + this.body.getStr(depth+1) + ")";
		}
	}
	
	public String toString() {
		return this.getStr(0);
	}

}