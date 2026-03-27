package agentAdaptionCode;
import static org.junit.Assert.*;
import org.junit.Test;
import agent.adaption.xtext.workflow.*;

import circus.robocalc.sleec.SLEECStandaloneSetup;
import circus.robocalc.sleec.sLEEC.SLEECFactory;
import workflowspec.WorkflowStructure;
import workflowspec.WorkflowspecFactory;
import workflowspec.WorkflowspecPackage;

public class AdaptionUnitTest {
	
	public boolean save = false;
	
	@Test
	public void test_task_start_end() {
		final WorkflowspecPackage einstance = WorkflowspecPackage.eINSTANCE;
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        SLEECFactory factory1 = SLEECFactory.eINSTANCE;
		WWorkflow result = Implementation.runAlgorithm("testing/testTask.workflowspec","sleec/testStartAndEndRules.sleec","Test-Task",save);
		WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_task_start_end.workflowspec");
		WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);

		assertEquals(result.toString(),correct.toString());
	}
	@Test
	public void test_Sequence_start_end() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
		WWorkflow result = Implementation.runAlgorithm("testing/testSequence.workflowspec","sleec/testStartAndEndRules.sleec","Test-Sequence",save);
		WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_sequence_start_end.workflowspec");
		WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);

		assertEquals(result.toString(),correct.toString());
	}
	@Test
	public void test_Loop_start_end() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testLoop.workflowspec","sleec/testStartAndEndRules.sleec","Test-Loop",save);
		WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_loop_start_end.workflowspec");
		WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);

		assertEquals(result.toString(),correct.toString());
	}
	
	@Test
	public void test_Decision_OneBranch_start_end() {
		SLEECStandaloneSetup.doSetup();
		WorkflowStandaloneSetup.doSetup();
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testDecisionOneBranch.workflowspec","sleec/testStartAndEndRules.sleec","Test-OneBranch-Dec",save);
		//System.out.println(result);
		WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_dec_onebranch_start_end.workflowspec");
		WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
		assertEquals(result.toString(),correct.toString());
	}
	@Test
	public void test_Decision_MultiBranch_start_end() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testDecisionMultBranch.workflowspec","sleec/testStartAndEndRules.sleec","Test-MultiBranch-Dec",save);
		WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_dec_multibranch_start_end.workflowspec");
		WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
		assertEquals(result.toString(),correct.toString());
	}
	@Test
	public void test_SeqinSeq_start_end() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testSeqinSeq.workflowspec","sleec/testStartAndEndRules.sleec","Test-SeqInSeq",save);
		//System.out.println(result);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_seqInSeq_start_end.workflowspec");
		WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
		assertEquals(result.toString(),correct.toString());
	}
	
	@Test
	public void test_SeqinSeq1_start_end() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testSeqinSeq1.workflowspec","sleec/testStartAndEndRules.sleec","Test-SeqInSeq1",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_seqInSeq_start_end.workflowspec");
		WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
		assertEquals(result.toString(),correct.toString());
	}
	@Test
	public void test_SeqinSeq2_start_end() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testSeqinSeq2.workflowspec","sleec/testStartAndEndRules.sleec","Test-SeqInSeq2",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_seqInSeq2_start_end.workflowspec");
		WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
		assertEquals(result.toString(),correct.toString());
	}
	@Test
	public void test_LoopInLoop_start_end() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testLoopInLoop.workflowspec","sleec/testStartAndEndRules.sleec","Test-LoopInLoop",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_loopInLoop_start_end.workflowspec");
		WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
		assertEquals(result.toString(),correct.toString());
	}
	
	@Test
	public void test_DecInDec_start_end() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testDecinDec.workflowspec","sleec/testStartAndEndRules.sleec","Test-DecInDec",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_decInDec_start_end.workflowspec");
        WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
		assertEquals(result.toString(),correct.toString());
	}
	
	@Test
	public void test_SeqInLoop_start_end() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testSeqinLoop.workflowspec","sleec/testStartAndEndRules.sleec","Test-SeqInLoop",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_seqInLoop_start_end.workflowspec");
        WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
		assertEquals(result.toString(),correct.toString());
	}
	@Test
	public void test_DecInLoop_start_end() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testDecinLoop.workflowspec","sleec/testStartAndEndRules.sleec","Test-DecInLoop",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_decInLoop_start_end.workflowspec");
        WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
		assertEquals(result.toString(),correct.toString());
	}
	@Test
	public void test_DecInSeq_start_end() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testDecInSeq.workflowspec","sleec/testStartAndEndRules.sleec","Test-DecInSeq",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_decInSeq_start_end.workflowspec");
        WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
		assertEquals(result.toString(),correct.toString());
	}
	@Test
	public void test_LoopInSeq_start_end() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testLoopinSeq.workflowspec","sleec/testStartAndEndRules.sleec","Test-LoopInSeq",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_loopInSeq_start_end.workflowspec");
        WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
		assertEquals(result.toString(),correct.toString());
	}
	
	@Test
	public void test_SeqInDec_start_end() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testSeqinDec.workflowspec","sleec/testStartAndEndRules.sleec","Test-SeqInDec",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_seqInDec_start_end.workflowspec");
        WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
		assertEquals(result.toString(),correct.toString());
	}
	@Test
	public void test_LoopInDec_start_end() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testLoopinDec.workflowspec","sleec/testStartAndEndRules.sleec","Test-LoopInDec",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_loopInDec_start_end.workflowspec");
        WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
        assertEquals(result.toString(),correct.toString());
	}
	
// SEQUENCES WITH MORE COMPLEX RULES	
	
	@Test
	public void test_Seq_simpleGuard() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testSequence.workflowspec","sleec/testSimpleGuard.sleec","Test-Seq-SimpleGuard",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_Seq_singleGuard.workflowspec");
        WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
        assertEquals(result.toString(),correct.toString());
	}
	
	@Test
	public void test_Seq_andGuard() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testSequence.workflowspec","sleec/testAndGuard.sleec","Test-Seq-AndGuard",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_Seq_AndGuard.workflowspec");
        WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
        assertEquals(result.toString(),correct.toString());
	}
	@Test
	public void test_Seq_orGuard() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testSequence.workflowspec","sleec/testOrGuard.sleec","Test-Seq-AndGuard",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_Seq_OrGuard.workflowspec");
        WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
        assertEquals(result.toString(),correct.toString());
	}
	@Test
	public void test_Seq_SimpleNotGuard() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testSequence.workflowspec","sleec/testSimpleNotGuard.sleec","Test-Seq-SimpleNotGuard",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_Seq_SimpleNotGuard.workflowspec");
        WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
        assertEquals(result.toString(),correct.toString());
	}
	@Test
	public void test_Seq_ComplexNotGuard() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testSequence.workflowspec","sleec/TestComplexNotGuard.sleec","Test-Seq-ComplexNotGuard",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_Seq_complexNotGuard.workflowspec");
        WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
        assertEquals(result.toString(),correct.toString());
	}
	@Test
	public void test_Seq_OneDefeaterNoBody() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testSequence.workflowspec","sleec/testOneDefeaterNoBody.sleec","Test-Seq-OneDefeaterNoBody",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_Seq_OneDefeater.workflowspec");
        WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
        assertEquals(result.toString(),correct.toString());
	}
	@Test
	public void test_Seq_OneDefeaterWithBody() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testSequence.workflowspec","sleec/testOneDefeaterWithBody.sleec","Test-Seq-OneDefeaterWithBody",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_Seq_OneDefeaterWithBody.workflowspec");
        WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
        assertEquals(result.toString(),correct.toString());
	}
	@Test
	public void test_Seq_RelComp() {
		WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testSequence.workflowspec","sleec/testRelCompGuard.sleec","Test-Seq-RelCompGuard",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_Seq_RelComp.workflowspec");
        WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
        assertEquals(result.toString(),correct.toString());
		
	}
	
	// LOOPS WITH MORE COMPLEX RULES
	
	@Test
	public void test_Loop_simpleGuard() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testLoop.workflowspec","sleec/testSimpleGuard.sleec","Test-Loop-SimpleGuard",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_Loop_simpleGuard.workflowspec");
        WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
        assertEquals(result.toString(),correct.toString());
	}
	
	@Test
	public void test_Loop_andGuard() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testLoop.workflowspec","sleec/testAndGuard.sleec","Test-Loop-AndGuard",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_Loop_AndGuard.workflowspec");
        WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
        assertEquals(result.toString(),correct.toString());
	}
	
	@Test
	public void test_Loop_orGuard() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testLoop.workflowspec","sleec/testOrGuard.sleec","Test-Loop-OrGuard",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_Loop_OrGuard.workflowspec");
        WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
        assertEquals(result.toString(),correct.toString());
	}
	
	@Test
	public void test_Loop_SimpleNotGuard() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testLoop.workflowspec","sleec/testSimpleNotGuard.sleec","Test-Loop-SimpleNotGuard",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_Loop_SimpleNotGuard.workflowspec");
        WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
        assertEquals(result.toString(),correct.toString());
	}
	
	@Test
	public void test_Loop_ComplexNotGuard() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testLoop.workflowspec","sleec/TestComplexNotGuard.sleec","Test-Loop-ComplexNotGuard",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_Loop_ComplexNotGuard.workflowspec");
        WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
        assertEquals(result.toString(),correct.toString());
	}
	@Test
	public void test_Loop_OneDefeaterNoBody() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testLoop.workflowspec","sleec/testOneDefeaterNoBody.sleec","Test-Loop-OneDefeaterNoBody",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_Loop_OneDefeater_NoBody.workflowspec");
        WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
        assertEquals(result.toString(),correct.toString());
	}
	@Test
	public void test_Loop_OneDefeaterWithBody() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testLoop.workflowspec","sleec/testOneDefeaterWithBody.sleec","test-Loop-OneDefeaterWithBody",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_Loop_OneDefeaterWithBody.workflowspec");
        WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
        assertEquals(result.toString(),correct.toString());
	}
	@Test
	public void test_Loop_RelCompGuard() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testLoop.workflowspec","sleec/testRelCompGuard.sleec","Test-Loop-RelCompGuard",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_Loop_RelCompGuard.workflowspec");
        WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
        assertEquals(result.toString(),correct.toString());
	}
	
	//DECISIONS WITH MORE COMPLEX RULES
	
	@Test
	public void test_Decision_MultiBranch_simpleGuard() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testDecisionMultBranch.workflowspec","sleec/testSimpleGuard.sleec","Test-Dec-SimpleGuard",save);
		WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_Dec_MultiBranch_SimpleGuard.workflowspec");
		WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
		assertEquals(result.toString(),correct.toString());
	}
	
	@Test
	public void test_Decision_MultiBranch_andGuard() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testDecisionMultBranch.workflowspec","sleec/testAndGuard.sleec","Test-Dec-AndGuard",save);
		WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_Dec_MultiBranch_AndGuard.workflowspec");
		WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
		assertEquals(result.toString(),correct.toString());
	}
	
	@Test
	public void test_Decision_MultiBranch_OrGuard() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testDecisionMultBranch.workflowspec","sleec/testOrGuard.sleec","Test-Dec-OrGuard",save);
		WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_Dec_OrGuard.workflowspec");
		WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
		assertEquals(result.toString(),correct.toString());
	}
	
	@Test
	public void test_Decision_MultiBranch_SimpleNotGuard() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testDecisionMultBranch.workflowspec","sleec/testSimpleNotGuard.sleec","Test-Dec-SimpleNotGuard",save);
		WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_Dec_SimpleNotGuard.workflowspec");
		WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
		assertEquals(result.toString(),correct.toString());
	}
	
	@Test
	public void test_Dec_ComplexNotGuard() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testDecisionMultBranch.workflowspec","sleec/TestComplexNotGuard.sleec","Test-Dec-ComplexNotGuard",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_Dec_ComplexNotGuard.workflowspec");
        WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
        assertEquals(result.toString(),correct.toString());
	}
	
	@Test
	public void test_Dec_OneDefeaterNoBody() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testDecisionMultBranch.workflowspec","sleec/testOneDefeaterNoBody.sleec","Test-Dec-OneDefeaterNobody",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_Dec_OneDefeaterNoBody.workflowspec");
        WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
        assertEquals(result.toString(),correct.toString());
	}
	
	@Test
	public void test_Dec_OneDefeaterWithBody() {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testDecisionMultBranch.workflowspec","sleec/testOneDefeaterWithBody.sleec","Test-Dec-OneDefeaterWithBody",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_dec_OneDefeaterWithBody.workflowspec");
        WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
        assertEquals(result.toString(),correct.toString());
	}
	
	@Test
	public void test_Dec_RelComp() {
		WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testDecisionMultBranch.workflowspec","sleec/testRelCompGuard.sleec","Test-Dec-RelCompGuard",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_Dec_RelComp.workflowspec");
        WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
        assertEquals(result.toString(),correct.toString());
	}
	
	@Test
	public void test_Seq_ManyDefeaters() {
		WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testSequence.workflowspec","sleec/testManyDefeaters.sleec","Test-Seq-ManyDefeaters",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_Seq_ManyDefeaters.workflowspec");
        WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
        assertEquals(result.toString(),correct.toString());
	}
	
	@Test
	public void test_Dec_ManyDefeaters() {
		WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testDecisionMultBranch.workflowspec","sleec/testManyDefeaters.sleec","Test-Seq-ManyDefeaters",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_Dec_ManyDefeaters.workflowspec");
        WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
        assertEquals(result.toString(),correct.toString());
	}
	
	@Test
	public void test_Loop_ManyDefeaters() {
		WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        WWorkflow result = Implementation.runAlgorithm("testing/testLoop.workflowspec","sleec/testManyDefeaters.sleec","Test-Seq-ManyDefeaters",save);
        WorkflowStructure correctoutput = Implementation.workflowParser("testing/correctoutput/test_Loop_ManyDefeaters.workflowspec");
        WWorkflow correct = Implementation.buildWorkflow(correctoutput,factory);
        assertEquals(result.toString(),correct.toString());
	}
}

