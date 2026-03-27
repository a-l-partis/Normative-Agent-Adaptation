package agentAdaptionCode;

public class WLoop extends WWorkflow{
	public WGuardedWorkflow loop;

	public WLoop(WGuardedWorkflow gw) {
		this.loop = gw;
	}
	
	public String getStr(int depth) {
		String tabs = "";
		for(int i = 0; i < depth; i++) {
			tabs += "\t";
		}
		return tabs + "Loop(\n" + this.loop.getStr(depth+1) + ")";
	}
	
	public String toString() {
		return this.getStr(0);
	}

}
