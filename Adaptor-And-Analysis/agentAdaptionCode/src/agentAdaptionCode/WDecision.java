package agentAdaptionCode;
import java.util.ArrayList;

public class WDecision extends WWorkflow {
	public ArrayList<WGuardedWorkflow> options = new ArrayList<>();

	public WDecision (ArrayList<WGuardedWorkflow> options) {
		if(!(options.isEmpty() || options == null)) {
			for(WGuardedWorkflow branch : options) {
				if(branch.body == null) {
					branch.body = new WTask("Skip");
				} else {
				this.options.add(branch);
				}
			}
		}
	}
	
	public String getStr(int depth) {
		String tabs = "";
		for(int i = 0; i < depth; i++) {
			tabs += "\t";	
		}
		String output = tabs + "Decision(\n";
		for(int i = 0; i < this.options.size()-1; i++) {
			output += this.options.get(i).getStr(depth+1) + ", \n";
		}
		
		output += this.options.get(this.options.size()-1).getStr(depth+1) + ")";
		return output;
	}
	
	public String toString() {
		return this.getStr(0);
	}
	

}
