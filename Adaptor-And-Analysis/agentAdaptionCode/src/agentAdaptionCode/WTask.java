package agentAdaptionCode;

public class WTask extends WWorkflow{
	
	public String ID;

	public WTask(String ID) {
		this.ID = ID;

	}
	public String getStr(int depth) {
		String tabs = "";
		for(int i = 0; i < depth; i++) {
			tabs += "\t";
		}
		return tabs + "Task(" + this.ID + ")";
	}
	@Override
	public String toString() {
		return "Task(" + this.ID + ")";
	}
}
