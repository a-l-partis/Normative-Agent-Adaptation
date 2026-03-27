package agentAdaptionCode;


import java.util.ArrayList;

public class WSequence extends WWorkflow{
	public ArrayList<WWorkflow> subworkflows;

	public WSequence(ArrayList<WWorkflow> subworkflows) {
		this.subworkflows = subworkflows;
	}
	
	public String getStr(int depth) {
		String tabs = "";
		for(int i = 0; i < depth; i++) {
			tabs += "\t";
		}
		String output = tabs + "Sequence(\n";
		for(WWorkflow element : this.subworkflows) {
			if(element == null) {
				output += "ERROR HERE: NULL ELEMENT\n";
			} else {
				output += element.getStr(depth+1) + ",\n";
			}
		}
		output = output.substring(0,output.length()-2);
		output += ")";
		return output;
	}
	
	public String toString() {
		if(this.subworkflows.size() == 0) {
			return "Sequence()";
		} else {
			return this.getStr(0);
		}
	}
}
