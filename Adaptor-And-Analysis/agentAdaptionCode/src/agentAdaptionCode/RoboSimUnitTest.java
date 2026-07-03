package agentAdaptionCode;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;

import circus.robocalc.sleec.sLEEC.SLEECFactory;
import agentAdaptionCode.RoboSimConverter;
import agentAdaptionCode.WWorkflow;
import workflowspec.WorkflowStructure;
import workflowspec.WorkflowspecFactory;
import workflowspec.WorkflowspecPackage;

public class RoboSimUnitTest {
	
	public WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
    public SLEECFactory factory1 = SLEECFactory.eINSTANCE;
	public boolean save = true;
	
	// The following tests do not provide verification of the component on their own:
	// it is their intention that that their output .rst files should be moved into
	// robosim tool, which will automatically generate csp representations.
	// then you should run the csp traces provided in the Supplementary folder
	// of the repository:
	//(/home/alp565/AgentAdaptionFolders/uploadingJuly/Normative-Agent-Adaptation/Adaptor-And-Analysis/Supplements/csp-Traces-RoboSimTesting/
	
	// Loop_BooCompGuard, Dec_RelComp, and Dec_RelComp2 are not from AdaptionUnitTest.java: they are
	// new for RoboSimUnitTest/java, devised to cover the full range of guards.

	
	@Test
	public void test_task_start_end() throws IOException {
		final WorkflowspecPackage einstance = WorkflowspecPackage.eINSTANCE;
        
		WWorkflow result = Implementation.runAlgorithm("testing/testTask.workflowspec","sleec/testStartAndEndRules.sleec","test-Task",save);
		RoboSimConverter.Convert(result,"TestOutput/test-Task","sleec/testStartAndEndRules.sleec");
	}
	
	@Test
	public void test_Sequence_start_end() throws IOException {
		WWorkflow result = Implementation.runAlgorithm("testing/testSequence.workflowspec","sleec/testStartAndEndRules.sleec","test-Sequence",save);
		RoboSimConverter.Convert(result,"TestOutput/test-Sequence","sleec/testStartAndEndRules.sleec");
	}
	
	@Test
	public void test_Loop_start_end() throws IOException {
        WWorkflow result = Implementation.runAlgorithm("testing/testLoop.workflowspec","sleec/testStartAndEndRules.sleec","test-Loop",save);
        RoboSimConverter.Convert(result,"TestOutput/test-Loop","sleec/testStartAndEndRules.sleec");
	}
	
	@Test
	public void test_Decision_OneBranch_start_end() throws IOException {

        WWorkflow result = Implementation.runAlgorithm("testing/testDecisionOneBranch.workflowspec","sleec/testStartAndEndRules.sleec","test-OneBranch-Dec",save);
        RoboSimConverter.Convert(result,"TestOutput/A-OneBranch-Dec","sleec/testStartAndEndRules.sleec");
	}
	
	@Test
	public void test_Decision_MultiBranch_start_end() throws IOException {
        WWorkflow result = Implementation.runAlgorithm("testing/testDecisionMultBranch.workflowspec","sleec/testStartAndEndRules.sleec","test-MultiBranch-Dec",save);
        RoboSimConverter.Convert(result,"TestOutput/A-MultiBranch-Dec","sleec/testStartAndEndRules.sleec");
	}

	@Test
	public void test_SeqinSeq_start_end() throws IOException {
        WWorkflow result = Implementation.runAlgorithm("testing/testSeqinSeq.workflowspec","sleec/testStartAndEndRules.sleec","Test-SeqInSeq",save);
        RoboSimConverter.Convert(result,"TestOutput/test-SeqInSeq","sleec/testStartAndEndRules.sleec");
	}
	
	@Test
	public void test_SeqinSeq1_start_end() throws IOException {
        WWorkflow result = Implementation.runAlgorithm("testing/testSeqinSeq1.workflowspec","sleec/testStartAndEndRules.sleec","Test-SeqInSeq1",save);
        RoboSimConverter.Convert(result,"TestOutput/test-SeqInSeq1","sleec/testStartAndEndRules.sleec");
	}
	
	@Test
	public void test_SeqinSeq2_start_end() throws IOException {
        WWorkflow result = Implementation.runAlgorithm("testing/testSeqinSeq2.workflowspec","sleec/testStartAndEndRules.sleec","Test-SeqInSeq2",save);
        RoboSimConverter.Convert(result,"TestOutput/test-SeqInSeq2","sleec/testStartAndEndRules.sleec");
	}

	@Test
	public void test_LoopInLoop_start_end() throws IOException {
        WWorkflow result = Implementation.runAlgorithm("testing/testLoopInLoop.workflowspec","sleec/testStartAndEndRules.sleec","Test-LoopInLoop",save);
        RoboSimConverter.Convert(result,"TestOutput/test-ALoopInLoop","sleec/testStartAndEndRules.sleec");
	}
	

	
	
	@Test
	public void test_DecInDec_start_end() throws IOException {
        WWorkflow result = Implementation.runAlgorithm("testing/testDecinDec.workflowspec","sleec/testStartAndEndRules.sleec","Test-DecInDec",save);
        RoboSimConverter.Convert(result,"TestOutput/Test-DecInDec","sleec/testStartAndEndRules.sleec");
	}
	

	@Test
	public void test_SeqInLoop_start_end() throws IOException {
        WWorkflow result = Implementation.runAlgorithm("testing/testSeqinLoop.workflowspec","sleec/testStartAndEndRules.sleec","Test-SeqInLoop",save);
        RoboSimConverter.Convert(result,"TestOutput/Test-SeqInLoop","sleec/testStartAndEndRules.sleec");
	}
	
	
	
	@Test
	public void test_DecInLoop_start_end() throws IOException {
        WWorkflow result = Implementation.runAlgorithm("testing/testDecinLoop.workflowspec","sleec/testStartAndEndRules.sleec","Test-DecInLoop",save);
        RoboSimConverter.Convert(result,"TestOutput/Test-DecInLoop","sleec/testStartAndEndRules.sleec");
	}
	
	
	
	@Test
	public void test_DecInSeq_start_end() throws IOException {
        WWorkflow result = Implementation.runAlgorithm("testing/testDecInSeq.workflowspec","sleec/testStartAndEndRules.sleec","Test-DecInSeq",save);
        RoboSimConverter.Convert(result,"TestOutput/Test-DecInSeq","sleec/testStartAndEndRules.sleec");
	}
	
	
	@Test
	public void test_LoopInSeq_start_end() throws IOException {
        WWorkflow result = Implementation.runAlgorithm("testing/testLoopinSeq.workflowspec","sleec/testStartAndEndRules.sleec","Test-LoopInSeq",save);
        RoboSimConverter.Convert(result,"TestOutput/Test-LoopInSeq","sleec/testStartAndEndRules.sleec");
	}
	
	
	
	@Test
	public void test_SeqInDec_start_end() throws IOException {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testSeqinDec.workflowspec","sleec/testStartAndEndRules.sleec","Test-SeqInDec",save);
        RoboSimConverter.Convert(result,"TestOutput/Test-SeqInDec","sleec/testStartAndEndRules.sleec");
	}
	
	
	
	@Test
	public void test_LoopInDec_start_end() throws IOException {
        WWorkflow result = Implementation.runAlgorithm("testing/testLoopinDec.workflowspec","sleec/testStartAndEndRules.sleec","Test-LoopInDec",save);
        RoboSimConverter.Convert(result,"TestOutput/Test-LoopInDec","sleec/testStartAndEndRules.sleec");
	}
	

	
	
	@Test
	public void test_Seq_simpleGuard() throws IOException {
        WWorkflow result = Implementation.runAlgorithm("testing/testSequence.workflowspec","sleec/testSimpleGuard.sleec","Test-Seq-SimpleGuard",save);
        RoboSimConverter.Convert(result,"TestOutput/Test-Seq-SimpleGuard","sleec/testSimpleGuard.sleec");
	}
	
	@Test
	public void test_Seq_andGuard() throws IOException {
        WWorkflow result = Implementation.runAlgorithm("testing/testSequence.workflowspec","sleec/testAndGuard.sleec","Test-Seq-AndGuard",save);
        RoboSimConverter.Convert(result,"TestOutput/Test-Seq-AndGuard","sleec/testAndGuard.sleec");
	}
	
	
	
	@Test
	public void test_Seq_orGuard() throws IOException {
        WWorkflow result = Implementation.runAlgorithm("testing/testSequence.workflowspec","sleec/testOrGuard.sleec","Test-Seq-OrGuard",save);
        RoboSimConverter.Convert(result,"TestOutput/Test-Seq-OrGuard","sleec/testOrGuard.sleec");
	}
	


	
	@Test
	public void test_Seq_SimpleNotGuard() throws IOException {
        WWorkflow result = Implementation.runAlgorithm("testing/testSequence.workflowspec","sleec/testSimpleNotGuard.sleec","Test-Seq-SimpleNotGuard",save);
        RoboSimConverter.Convert(result,"TestOutput/Test-Seq-SimpleNotGuard","sleec/testSimpleNotGuard.sleec");
	}	
	

	
	@Test
	public void test_Seq_ComplexNotGuard() throws IOException {
        WWorkflow result = Implementation.runAlgorithm("testing/testSequence.workflowspec","sleec/TestComplexNotGuard.sleec","Test-Seq-ComplexNotGuard",save);
        RoboSimConverter.Convert(result,"TestOutput/Test-Seq-ComplexNotGuard","sleec/TestComplexNotGuard.sleec");
	}
	
	
	
	@Test
	public void test_Seq_OneDefeaterNoBody() throws IOException {
        WWorkflow result = Implementation.runAlgorithm("testing/testSequence.workflowspec","sleec/testOneDefeaterNoBody.sleec","Test-Seq-OneDefeaterNoBody",save);
        RoboSimConverter.Convert(result,"TestOutput/Test-Seq-OneDefeaterNoBody","sleec/testOneDefeaterNoBody.sleec");
	}
	
	@Test
	public void test_Loop_BoolCompGuard() throws IOException{
        WWorkflow result = Implementation.runAlgorithm("testing/smallLoop.workflowspec","sleec/testRelCompGuard.sleec","Test-BoolComp",save);
        RoboSimConverter.Convert(result,"TestOutput/Test-BoolComp","sleec/testRelCompGuard.sleec");

	}
	
	@Test
	public void test_Loop_ComplexNotGuard() throws IOException{
        WWorkflow result = Implementation.runAlgorithm("testing/testLoop.workflowspec","sleec/TestComplexNotGuard.sleec","Test-Loop-ComplexNotGuard",save);
        RoboSimConverter.Convert(result,"TestOutput/Test-Loop-ComplexNotGuard","sleec/TestComplexNotGuard.sleec");

	}
	
	
	@Test
	public void test_Loop_RelComp() throws IOException {
        WWorkflow result = Implementation.runAlgorithm("testing/testLoop.workflowspec","sleec/testRelCompGuard.sleec","Test-Loop-RelCompGuard",save);
        RoboSimConverter.Convert(result,"TestOutput/Test-Loop-RelCompGuard","sleec/testRelCompGuard.sleec");

	}	
	@Test
	public void test_Dec_RelComp() throws IOException {
        WWorkflow result = Implementation.runAlgorithm("testing/testDecRelComp.workflowspec","sleec/testStartAndEndRules.sleec","Test-Dec-RelComp",save);
        RoboSimConverter.Convert(result,"TestOutput/Test-Dec-RelComp","sleec/testStartAndEndRules.sleec");

	}	
	
	@Test
	public void test_Dec_RelComp2() throws IOException {
        WWorkflow result = Implementation.runAlgorithm("testing/testDecRelComp2.workflowspec","sleec/testStartAndEndRules.sleec","Test-Dec-RelComp2",save);
        RoboSimConverter.Convert(result,"TestOutput/Test-Dec-RelComp2","sleec/testStartAndEndRules.sleec");

	}	
	

}