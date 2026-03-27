package agent.adaption.xtext.workflow.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import agent.adaption.xtext.workflow.services.WorkflowGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalWorkflowParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'WorkflowStructure'", "'{'", "'workflowspec'", "'}'", "'Sequence'", "'subworkflows'", "','", "'Task'", "'ID'", "'Loop'", "'loop'", "'Decision'", "'options'", "'GuardedWorkflow'", "'body'", "'guard'", "'MBoolExpr'", "'Value'", "'value'", "'BoolValue'", "'BoolComp'", "'op'", "'right'", "'left'", "'Not'", "'expr'", "'RelComp'", "'Atom'", "'measureID'", "'-'", "'AND'", "'OR'", "'LESS_THAN'", "'GREATER_THAN'", "'NOT_EQUAL'", "'LESS_EQUAL'", "'GREATER_EQUAL'", "'EQUAL'"
    };
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int RULE_ID=5;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__48=48;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalWorkflowParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalWorkflowParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalWorkflowParser.tokenNames; }
    public String getGrammarFileName() { return "InternalWorkflow.g"; }



     	private WorkflowGrammarAccess grammarAccess;

        public InternalWorkflowParser(TokenStream input, WorkflowGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "WorkflowStructure";
       	}

       	@Override
       	protected WorkflowGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleWorkflowStructure"
    // InternalWorkflow.g:65:1: entryRuleWorkflowStructure returns [EObject current=null] : iv_ruleWorkflowStructure= ruleWorkflowStructure EOF ;
    public final EObject entryRuleWorkflowStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWorkflowStructure = null;


        try {
            // InternalWorkflow.g:65:58: (iv_ruleWorkflowStructure= ruleWorkflowStructure EOF )
            // InternalWorkflow.g:66:2: iv_ruleWorkflowStructure= ruleWorkflowStructure EOF
            {
             newCompositeNode(grammarAccess.getWorkflowStructureRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWorkflowStructure=ruleWorkflowStructure();

            state._fsp--;

             current =iv_ruleWorkflowStructure; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWorkflowStructure"


    // $ANTLR start "ruleWorkflowStructure"
    // InternalWorkflow.g:72:1: ruleWorkflowStructure returns [EObject current=null] : (otherlv_0= 'WorkflowStructure' otherlv_1= '{' otherlv_2= 'workflowspec' ( (lv_workflowspec_3_0= ruleWorkflow ) ) otherlv_4= '}' ) ;
    public final EObject ruleWorkflowStructure() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_workflowspec_3_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:78:2: ( (otherlv_0= 'WorkflowStructure' otherlv_1= '{' otherlv_2= 'workflowspec' ( (lv_workflowspec_3_0= ruleWorkflow ) ) otherlv_4= '}' ) )
            // InternalWorkflow.g:79:2: (otherlv_0= 'WorkflowStructure' otherlv_1= '{' otherlv_2= 'workflowspec' ( (lv_workflowspec_3_0= ruleWorkflow ) ) otherlv_4= '}' )
            {
            // InternalWorkflow.g:79:2: (otherlv_0= 'WorkflowStructure' otherlv_1= '{' otherlv_2= 'workflowspec' ( (lv_workflowspec_3_0= ruleWorkflow ) ) otherlv_4= '}' )
            // InternalWorkflow.g:80:3: otherlv_0= 'WorkflowStructure' otherlv_1= '{' otherlv_2= 'workflowspec' ( (lv_workflowspec_3_0= ruleWorkflow ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getWorkflowStructureAccess().getWorkflowStructureKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getWorkflowStructureAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,13,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getWorkflowStructureAccess().getWorkflowspecKeyword_2());
            		
            // InternalWorkflow.g:92:3: ( (lv_workflowspec_3_0= ruleWorkflow ) )
            // InternalWorkflow.g:93:4: (lv_workflowspec_3_0= ruleWorkflow )
            {
            // InternalWorkflow.g:93:4: (lv_workflowspec_3_0= ruleWorkflow )
            // InternalWorkflow.g:94:5: lv_workflowspec_3_0= ruleWorkflow
            {

            					newCompositeNode(grammarAccess.getWorkflowStructureAccess().getWorkflowspecWorkflowParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_6);
            lv_workflowspec_3_0=ruleWorkflow();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWorkflowStructureRule());
            					}
            					set(
            						current,
            						"workflowspec",
            						lv_workflowspec_3_0,
            						"agent.adaption.xtext.workflow.Workflow.Workflow");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getWorkflowStructureAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWorkflowStructure"


    // $ANTLR start "entryRuleWorkflow"
    // InternalWorkflow.g:119:1: entryRuleWorkflow returns [EObject current=null] : iv_ruleWorkflow= ruleWorkflow EOF ;
    public final EObject entryRuleWorkflow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWorkflow = null;


        try {
            // InternalWorkflow.g:119:49: (iv_ruleWorkflow= ruleWorkflow EOF )
            // InternalWorkflow.g:120:2: iv_ruleWorkflow= ruleWorkflow EOF
            {
             newCompositeNode(grammarAccess.getWorkflowRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWorkflow=ruleWorkflow();

            state._fsp--;

             current =iv_ruleWorkflow; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWorkflow"


    // $ANTLR start "ruleWorkflow"
    // InternalWorkflow.g:126:1: ruleWorkflow returns [EObject current=null] : (this_Sequence_0= ruleSequence | this_Task_1= ruleTask | this_Loop_2= ruleLoop | this_Decision_3= ruleDecision ) ;
    public final EObject ruleWorkflow() throws RecognitionException {
        EObject current = null;

        EObject this_Sequence_0 = null;

        EObject this_Task_1 = null;

        EObject this_Loop_2 = null;

        EObject this_Decision_3 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:132:2: ( (this_Sequence_0= ruleSequence | this_Task_1= ruleTask | this_Loop_2= ruleLoop | this_Decision_3= ruleDecision ) )
            // InternalWorkflow.g:133:2: (this_Sequence_0= ruleSequence | this_Task_1= ruleTask | this_Loop_2= ruleLoop | this_Decision_3= ruleDecision )
            {
            // InternalWorkflow.g:133:2: (this_Sequence_0= ruleSequence | this_Task_1= ruleTask | this_Loop_2= ruleLoop | this_Decision_3= ruleDecision )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt1=1;
                }
                break;
            case 18:
                {
                alt1=2;
                }
                break;
            case 20:
                {
                alt1=3;
                }
                break;
            case 22:
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalWorkflow.g:134:3: this_Sequence_0= ruleSequence
                    {

                    			newCompositeNode(grammarAccess.getWorkflowAccess().getSequenceParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Sequence_0=ruleSequence();

                    state._fsp--;


                    			current = this_Sequence_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:143:3: this_Task_1= ruleTask
                    {

                    			newCompositeNode(grammarAccess.getWorkflowAccess().getTaskParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Task_1=ruleTask();

                    state._fsp--;


                    			current = this_Task_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:152:3: this_Loop_2= ruleLoop
                    {

                    			newCompositeNode(grammarAccess.getWorkflowAccess().getLoopParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Loop_2=ruleLoop();

                    state._fsp--;


                    			current = this_Loop_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalWorkflow.g:161:3: this_Decision_3= ruleDecision
                    {

                    			newCompositeNode(grammarAccess.getWorkflowAccess().getDecisionParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Decision_3=ruleDecision();

                    state._fsp--;


                    			current = this_Decision_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWorkflow"


    // $ANTLR start "entryRuleMBoolExpr"
    // InternalWorkflow.g:173:1: entryRuleMBoolExpr returns [EObject current=null] : iv_ruleMBoolExpr= ruleMBoolExpr EOF ;
    public final EObject entryRuleMBoolExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMBoolExpr = null;


        try {
            // InternalWorkflow.g:173:50: (iv_ruleMBoolExpr= ruleMBoolExpr EOF )
            // InternalWorkflow.g:174:2: iv_ruleMBoolExpr= ruleMBoolExpr EOF
            {
             newCompositeNode(grammarAccess.getMBoolExprRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMBoolExpr=ruleMBoolExpr();

            state._fsp--;

             current =iv_ruleMBoolExpr; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMBoolExpr"


    // $ANTLR start "ruleMBoolExpr"
    // InternalWorkflow.g:180:1: ruleMBoolExpr returns [EObject current=null] : (this_MBoolExpr_Impl_0= ruleMBoolExpr_Impl | this_Value_1= ruleValue | this_BoolValue_2= ruleBoolValue | this_BoolComp_3= ruleBoolComp | this_Not_4= ruleNot | this_RelComp_5= ruleRelComp | this_Atom_6= ruleAtom ) ;
    public final EObject ruleMBoolExpr() throws RecognitionException {
        EObject current = null;

        EObject this_MBoolExpr_Impl_0 = null;

        EObject this_Value_1 = null;

        EObject this_BoolValue_2 = null;

        EObject this_BoolComp_3 = null;

        EObject this_Not_4 = null;

        EObject this_RelComp_5 = null;

        EObject this_Atom_6 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:186:2: ( (this_MBoolExpr_Impl_0= ruleMBoolExpr_Impl | this_Value_1= ruleValue | this_BoolValue_2= ruleBoolValue | this_BoolComp_3= ruleBoolComp | this_Not_4= ruleNot | this_RelComp_5= ruleRelComp | this_Atom_6= ruleAtom ) )
            // InternalWorkflow.g:187:2: (this_MBoolExpr_Impl_0= ruleMBoolExpr_Impl | this_Value_1= ruleValue | this_BoolValue_2= ruleBoolValue | this_BoolComp_3= ruleBoolComp | this_Not_4= ruleNot | this_RelComp_5= ruleRelComp | this_Atom_6= ruleAtom )
            {
            // InternalWorkflow.g:187:2: (this_MBoolExpr_Impl_0= ruleMBoolExpr_Impl | this_Value_1= ruleValue | this_BoolValue_2= ruleBoolValue | this_BoolComp_3= ruleBoolComp | this_Not_4= ruleNot | this_RelComp_5= ruleRelComp | this_Atom_6= ruleAtom )
            int alt2=7;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt2=1;
                }
                break;
            case 28:
                {
                alt2=2;
                }
                break;
            case 29:
            case 30:
                {
                alt2=3;
                }
                break;
            case 31:
                {
                alt2=4;
                }
                break;
            case 35:
                {
                alt2=5;
                }
                break;
            case 37:
                {
                alt2=6;
                }
                break;
            case 38:
                {
                alt2=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalWorkflow.g:188:3: this_MBoolExpr_Impl_0= ruleMBoolExpr_Impl
                    {

                    			newCompositeNode(grammarAccess.getMBoolExprAccess().getMBoolExpr_ImplParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_MBoolExpr_Impl_0=ruleMBoolExpr_Impl();

                    state._fsp--;


                    			current = this_MBoolExpr_Impl_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:197:3: this_Value_1= ruleValue
                    {

                    			newCompositeNode(grammarAccess.getMBoolExprAccess().getValueParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Value_1=ruleValue();

                    state._fsp--;


                    			current = this_Value_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:206:3: this_BoolValue_2= ruleBoolValue
                    {

                    			newCompositeNode(grammarAccess.getMBoolExprAccess().getBoolValueParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_BoolValue_2=ruleBoolValue();

                    state._fsp--;


                    			current = this_BoolValue_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalWorkflow.g:215:3: this_BoolComp_3= ruleBoolComp
                    {

                    			newCompositeNode(grammarAccess.getMBoolExprAccess().getBoolCompParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_BoolComp_3=ruleBoolComp();

                    state._fsp--;


                    			current = this_BoolComp_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalWorkflow.g:224:3: this_Not_4= ruleNot
                    {

                    			newCompositeNode(grammarAccess.getMBoolExprAccess().getNotParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Not_4=ruleNot();

                    state._fsp--;


                    			current = this_Not_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalWorkflow.g:233:3: this_RelComp_5= ruleRelComp
                    {

                    			newCompositeNode(grammarAccess.getMBoolExprAccess().getRelCompParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_RelComp_5=ruleRelComp();

                    state._fsp--;


                    			current = this_RelComp_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalWorkflow.g:242:3: this_Atom_6= ruleAtom
                    {

                    			newCompositeNode(grammarAccess.getMBoolExprAccess().getAtomParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_Atom_6=ruleAtom();

                    state._fsp--;


                    			current = this_Atom_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMBoolExpr"


    // $ANTLR start "entryRuleSequence"
    // InternalWorkflow.g:254:1: entryRuleSequence returns [EObject current=null] : iv_ruleSequence= ruleSequence EOF ;
    public final EObject entryRuleSequence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequence = null;


        try {
            // InternalWorkflow.g:254:49: (iv_ruleSequence= ruleSequence EOF )
            // InternalWorkflow.g:255:2: iv_ruleSequence= ruleSequence EOF
            {
             newCompositeNode(grammarAccess.getSequenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSequence=ruleSequence();

            state._fsp--;

             current =iv_ruleSequence; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSequence"


    // $ANTLR start "ruleSequence"
    // InternalWorkflow.g:261:1: ruleSequence returns [EObject current=null] : (otherlv_0= 'Sequence' otherlv_1= '{' otherlv_2= 'subworkflows' otherlv_3= '{' ( (lv_subworkflows_4_0= ruleWorkflow ) ) (otherlv_5= ',' ( (lv_subworkflows_6_0= ruleWorkflow ) ) )* otherlv_7= '}' otherlv_8= '}' ) ;
    public final EObject ruleSequence() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_subworkflows_4_0 = null;

        EObject lv_subworkflows_6_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:267:2: ( (otherlv_0= 'Sequence' otherlv_1= '{' otherlv_2= 'subworkflows' otherlv_3= '{' ( (lv_subworkflows_4_0= ruleWorkflow ) ) (otherlv_5= ',' ( (lv_subworkflows_6_0= ruleWorkflow ) ) )* otherlv_7= '}' otherlv_8= '}' ) )
            // InternalWorkflow.g:268:2: (otherlv_0= 'Sequence' otherlv_1= '{' otherlv_2= 'subworkflows' otherlv_3= '{' ( (lv_subworkflows_4_0= ruleWorkflow ) ) (otherlv_5= ',' ( (lv_subworkflows_6_0= ruleWorkflow ) ) )* otherlv_7= '}' otherlv_8= '}' )
            {
            // InternalWorkflow.g:268:2: (otherlv_0= 'Sequence' otherlv_1= '{' otherlv_2= 'subworkflows' otherlv_3= '{' ( (lv_subworkflows_4_0= ruleWorkflow ) ) (otherlv_5= ',' ( (lv_subworkflows_6_0= ruleWorkflow ) ) )* otherlv_7= '}' otherlv_8= '}' )
            // InternalWorkflow.g:269:3: otherlv_0= 'Sequence' otherlv_1= '{' otherlv_2= 'subworkflows' otherlv_3= '{' ( (lv_subworkflows_4_0= ruleWorkflow ) ) (otherlv_5= ',' ( (lv_subworkflows_6_0= ruleWorkflow ) ) )* otherlv_7= '}' otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getSequenceAccess().getSequenceKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getSequenceAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,16,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getSequenceAccess().getSubworkflowsKeyword_2());
            		
            otherlv_3=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getSequenceAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalWorkflow.g:285:3: ( (lv_subworkflows_4_0= ruleWorkflow ) )
            // InternalWorkflow.g:286:4: (lv_subworkflows_4_0= ruleWorkflow )
            {
            // InternalWorkflow.g:286:4: (lv_subworkflows_4_0= ruleWorkflow )
            // InternalWorkflow.g:287:5: lv_subworkflows_4_0= ruleWorkflow
            {

            					newCompositeNode(grammarAccess.getSequenceAccess().getSubworkflowsWorkflowParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_8);
            lv_subworkflows_4_0=ruleWorkflow();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSequenceRule());
            					}
            					add(
            						current,
            						"subworkflows",
            						lv_subworkflows_4_0,
            						"agent.adaption.xtext.workflow.Workflow.Workflow");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflow.g:304:3: (otherlv_5= ',' ( (lv_subworkflows_6_0= ruleWorkflow ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==17) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalWorkflow.g:305:4: otherlv_5= ',' ( (lv_subworkflows_6_0= ruleWorkflow ) )
            	    {
            	    otherlv_5=(Token)match(input,17,FOLLOW_5); 

            	    				newLeafNode(otherlv_5, grammarAccess.getSequenceAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalWorkflow.g:309:4: ( (lv_subworkflows_6_0= ruleWorkflow ) )
            	    // InternalWorkflow.g:310:5: (lv_subworkflows_6_0= ruleWorkflow )
            	    {
            	    // InternalWorkflow.g:310:5: (lv_subworkflows_6_0= ruleWorkflow )
            	    // InternalWorkflow.g:311:6: lv_subworkflows_6_0= ruleWorkflow
            	    {

            	    						newCompositeNode(grammarAccess.getSequenceAccess().getSubworkflowsWorkflowParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_8);
            	    lv_subworkflows_6_0=ruleWorkflow();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getSequenceRule());
            	    						}
            	    						add(
            	    							current,
            	    							"subworkflows",
            	    							lv_subworkflows_6_0,
            	    							"agent.adaption.xtext.workflow.Workflow.Workflow");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_7=(Token)match(input,14,FOLLOW_6); 

            			newLeafNode(otherlv_7, grammarAccess.getSequenceAccess().getRightCurlyBracketKeyword_6());
            		
            otherlv_8=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getSequenceAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSequence"


    // $ANTLR start "entryRuleTask"
    // InternalWorkflow.g:341:1: entryRuleTask returns [EObject current=null] : iv_ruleTask= ruleTask EOF ;
    public final EObject entryRuleTask() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTask = null;


        try {
            // InternalWorkflow.g:341:45: (iv_ruleTask= ruleTask EOF )
            // InternalWorkflow.g:342:2: iv_ruleTask= ruleTask EOF
            {
             newCompositeNode(grammarAccess.getTaskRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTask=ruleTask();

            state._fsp--;

             current =iv_ruleTask; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTask"


    // $ANTLR start "ruleTask"
    // InternalWorkflow.g:348:1: ruleTask returns [EObject current=null] : (otherlv_0= 'Task' otherlv_1= '{' otherlv_2= 'ID' ( (lv_ID_3_0= ruleEString ) ) otherlv_4= '}' ) ;
    public final EObject ruleTask() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_ID_3_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:354:2: ( (otherlv_0= 'Task' otherlv_1= '{' otherlv_2= 'ID' ( (lv_ID_3_0= ruleEString ) ) otherlv_4= '}' ) )
            // InternalWorkflow.g:355:2: (otherlv_0= 'Task' otherlv_1= '{' otherlv_2= 'ID' ( (lv_ID_3_0= ruleEString ) ) otherlv_4= '}' )
            {
            // InternalWorkflow.g:355:2: (otherlv_0= 'Task' otherlv_1= '{' otherlv_2= 'ID' ( (lv_ID_3_0= ruleEString ) ) otherlv_4= '}' )
            // InternalWorkflow.g:356:3: otherlv_0= 'Task' otherlv_1= '{' otherlv_2= 'ID' ( (lv_ID_3_0= ruleEString ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getTaskAccess().getTaskKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getTaskAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,19,FOLLOW_10); 

            			newLeafNode(otherlv_2, grammarAccess.getTaskAccess().getIDKeyword_2());
            		
            // InternalWorkflow.g:368:3: ( (lv_ID_3_0= ruleEString ) )
            // InternalWorkflow.g:369:4: (lv_ID_3_0= ruleEString )
            {
            // InternalWorkflow.g:369:4: (lv_ID_3_0= ruleEString )
            // InternalWorkflow.g:370:5: lv_ID_3_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getTaskAccess().getIDEStringParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_6);
            lv_ID_3_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTaskRule());
            					}
            					set(
            						current,
            						"ID",
            						lv_ID_3_0,
            						"agent.adaption.xtext.workflow.Workflow.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getTaskAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTask"


    // $ANTLR start "entryRuleLoop"
    // InternalWorkflow.g:395:1: entryRuleLoop returns [EObject current=null] : iv_ruleLoop= ruleLoop EOF ;
    public final EObject entryRuleLoop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop = null;


        try {
            // InternalWorkflow.g:395:45: (iv_ruleLoop= ruleLoop EOF )
            // InternalWorkflow.g:396:2: iv_ruleLoop= ruleLoop EOF
            {
             newCompositeNode(grammarAccess.getLoopRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLoop=ruleLoop();

            state._fsp--;

             current =iv_ruleLoop; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLoop"


    // $ANTLR start "ruleLoop"
    // InternalWorkflow.g:402:1: ruleLoop returns [EObject current=null] : (otherlv_0= 'Loop' otherlv_1= '{' otherlv_2= 'loop' ( (lv_loop_3_0= ruleGuardedWorkflow ) ) otherlv_4= '}' ) ;
    public final EObject ruleLoop() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_loop_3_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:408:2: ( (otherlv_0= 'Loop' otherlv_1= '{' otherlv_2= 'loop' ( (lv_loop_3_0= ruleGuardedWorkflow ) ) otherlv_4= '}' ) )
            // InternalWorkflow.g:409:2: (otherlv_0= 'Loop' otherlv_1= '{' otherlv_2= 'loop' ( (lv_loop_3_0= ruleGuardedWorkflow ) ) otherlv_4= '}' )
            {
            // InternalWorkflow.g:409:2: (otherlv_0= 'Loop' otherlv_1= '{' otherlv_2= 'loop' ( (lv_loop_3_0= ruleGuardedWorkflow ) ) otherlv_4= '}' )
            // InternalWorkflow.g:410:3: otherlv_0= 'Loop' otherlv_1= '{' otherlv_2= 'loop' ( (lv_loop_3_0= ruleGuardedWorkflow ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getLoopAccess().getLoopKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getLoopAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,21,FOLLOW_12); 

            			newLeafNode(otherlv_2, grammarAccess.getLoopAccess().getLoopKeyword_2());
            		
            // InternalWorkflow.g:422:3: ( (lv_loop_3_0= ruleGuardedWorkflow ) )
            // InternalWorkflow.g:423:4: (lv_loop_3_0= ruleGuardedWorkflow )
            {
            // InternalWorkflow.g:423:4: (lv_loop_3_0= ruleGuardedWorkflow )
            // InternalWorkflow.g:424:5: lv_loop_3_0= ruleGuardedWorkflow
            {

            					newCompositeNode(grammarAccess.getLoopAccess().getLoopGuardedWorkflowParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_6);
            lv_loop_3_0=ruleGuardedWorkflow();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLoopRule());
            					}
            					set(
            						current,
            						"loop",
            						lv_loop_3_0,
            						"agent.adaption.xtext.workflow.Workflow.GuardedWorkflow");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getLoopAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLoop"


    // $ANTLR start "entryRuleDecision"
    // InternalWorkflow.g:449:1: entryRuleDecision returns [EObject current=null] : iv_ruleDecision= ruleDecision EOF ;
    public final EObject entryRuleDecision() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecision = null;


        try {
            // InternalWorkflow.g:449:49: (iv_ruleDecision= ruleDecision EOF )
            // InternalWorkflow.g:450:2: iv_ruleDecision= ruleDecision EOF
            {
             newCompositeNode(grammarAccess.getDecisionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDecision=ruleDecision();

            state._fsp--;

             current =iv_ruleDecision; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDecision"


    // $ANTLR start "ruleDecision"
    // InternalWorkflow.g:456:1: ruleDecision returns [EObject current=null] : (otherlv_0= 'Decision' otherlv_1= '{' otherlv_2= 'options' otherlv_3= '{' ( (lv_options_4_0= ruleGuardedWorkflow ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleGuardedWorkflow ) ) )* otherlv_7= '}' otherlv_8= '}' ) ;
    public final EObject ruleDecision() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_options_4_0 = null;

        EObject lv_options_6_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:462:2: ( (otherlv_0= 'Decision' otherlv_1= '{' otherlv_2= 'options' otherlv_3= '{' ( (lv_options_4_0= ruleGuardedWorkflow ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleGuardedWorkflow ) ) )* otherlv_7= '}' otherlv_8= '}' ) )
            // InternalWorkflow.g:463:2: (otherlv_0= 'Decision' otherlv_1= '{' otherlv_2= 'options' otherlv_3= '{' ( (lv_options_4_0= ruleGuardedWorkflow ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleGuardedWorkflow ) ) )* otherlv_7= '}' otherlv_8= '}' )
            {
            // InternalWorkflow.g:463:2: (otherlv_0= 'Decision' otherlv_1= '{' otherlv_2= 'options' otherlv_3= '{' ( (lv_options_4_0= ruleGuardedWorkflow ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleGuardedWorkflow ) ) )* otherlv_7= '}' otherlv_8= '}' )
            // InternalWorkflow.g:464:3: otherlv_0= 'Decision' otherlv_1= '{' otherlv_2= 'options' otherlv_3= '{' ( (lv_options_4_0= ruleGuardedWorkflow ) ) (otherlv_5= ',' ( (lv_options_6_0= ruleGuardedWorkflow ) ) )* otherlv_7= '}' otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDecisionAccess().getDecisionKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getDecisionAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,23,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getDecisionAccess().getOptionsKeyword_2());
            		
            otherlv_3=(Token)match(input,12,FOLLOW_12); 

            			newLeafNode(otherlv_3, grammarAccess.getDecisionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalWorkflow.g:480:3: ( (lv_options_4_0= ruleGuardedWorkflow ) )
            // InternalWorkflow.g:481:4: (lv_options_4_0= ruleGuardedWorkflow )
            {
            // InternalWorkflow.g:481:4: (lv_options_4_0= ruleGuardedWorkflow )
            // InternalWorkflow.g:482:5: lv_options_4_0= ruleGuardedWorkflow
            {

            					newCompositeNode(grammarAccess.getDecisionAccess().getOptionsGuardedWorkflowParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_8);
            lv_options_4_0=ruleGuardedWorkflow();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDecisionRule());
            					}
            					add(
            						current,
            						"options",
            						lv_options_4_0,
            						"agent.adaption.xtext.workflow.Workflow.GuardedWorkflow");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWorkflow.g:499:3: (otherlv_5= ',' ( (lv_options_6_0= ruleGuardedWorkflow ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==17) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalWorkflow.g:500:4: otherlv_5= ',' ( (lv_options_6_0= ruleGuardedWorkflow ) )
            	    {
            	    otherlv_5=(Token)match(input,17,FOLLOW_12); 

            	    				newLeafNode(otherlv_5, grammarAccess.getDecisionAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalWorkflow.g:504:4: ( (lv_options_6_0= ruleGuardedWorkflow ) )
            	    // InternalWorkflow.g:505:5: (lv_options_6_0= ruleGuardedWorkflow )
            	    {
            	    // InternalWorkflow.g:505:5: (lv_options_6_0= ruleGuardedWorkflow )
            	    // InternalWorkflow.g:506:6: lv_options_6_0= ruleGuardedWorkflow
            	    {

            	    						newCompositeNode(grammarAccess.getDecisionAccess().getOptionsGuardedWorkflowParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_8);
            	    lv_options_6_0=ruleGuardedWorkflow();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDecisionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"options",
            	    							lv_options_6_0,
            	    							"agent.adaption.xtext.workflow.Workflow.GuardedWorkflow");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_7=(Token)match(input,14,FOLLOW_6); 

            			newLeafNode(otherlv_7, grammarAccess.getDecisionAccess().getRightCurlyBracketKeyword_6());
            		
            otherlv_8=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getDecisionAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDecision"


    // $ANTLR start "entryRuleEString"
    // InternalWorkflow.g:536:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalWorkflow.g:536:47: (iv_ruleEString= ruleEString EOF )
            // InternalWorkflow.g:537:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalWorkflow.g:543:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalWorkflow.g:549:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalWorkflow.g:550:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalWorkflow.g:550:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_STRING) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_ID) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalWorkflow.g:551:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:559:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleGuardedWorkflow"
    // InternalWorkflow.g:570:1: entryRuleGuardedWorkflow returns [EObject current=null] : iv_ruleGuardedWorkflow= ruleGuardedWorkflow EOF ;
    public final EObject entryRuleGuardedWorkflow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuardedWorkflow = null;


        try {
            // InternalWorkflow.g:570:56: (iv_ruleGuardedWorkflow= ruleGuardedWorkflow EOF )
            // InternalWorkflow.g:571:2: iv_ruleGuardedWorkflow= ruleGuardedWorkflow EOF
            {
             newCompositeNode(grammarAccess.getGuardedWorkflowRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGuardedWorkflow=ruleGuardedWorkflow();

            state._fsp--;

             current =iv_ruleGuardedWorkflow; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGuardedWorkflow"


    // $ANTLR start "ruleGuardedWorkflow"
    // InternalWorkflow.g:577:1: ruleGuardedWorkflow returns [EObject current=null] : (otherlv_0= 'GuardedWorkflow' otherlv_1= '{' otherlv_2= 'body' ( (lv_body_3_0= ruleWorkflow ) ) otherlv_4= 'guard' ( (lv_guard_5_0= ruleMBoolExpr ) ) otherlv_6= '}' ) ;
    public final EObject ruleGuardedWorkflow() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_body_3_0 = null;

        EObject lv_guard_5_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:583:2: ( (otherlv_0= 'GuardedWorkflow' otherlv_1= '{' otherlv_2= 'body' ( (lv_body_3_0= ruleWorkflow ) ) otherlv_4= 'guard' ( (lv_guard_5_0= ruleMBoolExpr ) ) otherlv_6= '}' ) )
            // InternalWorkflow.g:584:2: (otherlv_0= 'GuardedWorkflow' otherlv_1= '{' otherlv_2= 'body' ( (lv_body_3_0= ruleWorkflow ) ) otherlv_4= 'guard' ( (lv_guard_5_0= ruleMBoolExpr ) ) otherlv_6= '}' )
            {
            // InternalWorkflow.g:584:2: (otherlv_0= 'GuardedWorkflow' otherlv_1= '{' otherlv_2= 'body' ( (lv_body_3_0= ruleWorkflow ) ) otherlv_4= 'guard' ( (lv_guard_5_0= ruleMBoolExpr ) ) otherlv_6= '}' )
            // InternalWorkflow.g:585:3: otherlv_0= 'GuardedWorkflow' otherlv_1= '{' otherlv_2= 'body' ( (lv_body_3_0= ruleWorkflow ) ) otherlv_4= 'guard' ( (lv_guard_5_0= ruleMBoolExpr ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getGuardedWorkflowAccess().getGuardedWorkflowKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_14); 

            			newLeafNode(otherlv_1, grammarAccess.getGuardedWorkflowAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,25,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getGuardedWorkflowAccess().getBodyKeyword_2());
            		
            // InternalWorkflow.g:597:3: ( (lv_body_3_0= ruleWorkflow ) )
            // InternalWorkflow.g:598:4: (lv_body_3_0= ruleWorkflow )
            {
            // InternalWorkflow.g:598:4: (lv_body_3_0= ruleWorkflow )
            // InternalWorkflow.g:599:5: lv_body_3_0= ruleWorkflow
            {

            					newCompositeNode(grammarAccess.getGuardedWorkflowAccess().getBodyWorkflowParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_15);
            lv_body_3_0=ruleWorkflow();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGuardedWorkflowRule());
            					}
            					set(
            						current,
            						"body",
            						lv_body_3_0,
            						"agent.adaption.xtext.workflow.Workflow.Workflow");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,26,FOLLOW_16); 

            			newLeafNode(otherlv_4, grammarAccess.getGuardedWorkflowAccess().getGuardKeyword_4());
            		
            // InternalWorkflow.g:620:3: ( (lv_guard_5_0= ruleMBoolExpr ) )
            // InternalWorkflow.g:621:4: (lv_guard_5_0= ruleMBoolExpr )
            {
            // InternalWorkflow.g:621:4: (lv_guard_5_0= ruleMBoolExpr )
            // InternalWorkflow.g:622:5: lv_guard_5_0= ruleMBoolExpr
            {

            					newCompositeNode(grammarAccess.getGuardedWorkflowAccess().getGuardMBoolExprParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_6);
            lv_guard_5_0=ruleMBoolExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGuardedWorkflowRule());
            					}
            					set(
            						current,
            						"guard",
            						lv_guard_5_0,
            						"agent.adaption.xtext.workflow.Workflow.MBoolExpr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getGuardedWorkflowAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGuardedWorkflow"


    // $ANTLR start "entryRuleMBoolExpr_Impl"
    // InternalWorkflow.g:647:1: entryRuleMBoolExpr_Impl returns [EObject current=null] : iv_ruleMBoolExpr_Impl= ruleMBoolExpr_Impl EOF ;
    public final EObject entryRuleMBoolExpr_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMBoolExpr_Impl = null;


        try {
            // InternalWorkflow.g:647:55: (iv_ruleMBoolExpr_Impl= ruleMBoolExpr_Impl EOF )
            // InternalWorkflow.g:648:2: iv_ruleMBoolExpr_Impl= ruleMBoolExpr_Impl EOF
            {
             newCompositeNode(grammarAccess.getMBoolExpr_ImplRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMBoolExpr_Impl=ruleMBoolExpr_Impl();

            state._fsp--;

             current =iv_ruleMBoolExpr_Impl; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMBoolExpr_Impl"


    // $ANTLR start "ruleMBoolExpr_Impl"
    // InternalWorkflow.g:654:1: ruleMBoolExpr_Impl returns [EObject current=null] : ( () otherlv_1= 'MBoolExpr' ) ;
    public final EObject ruleMBoolExpr_Impl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalWorkflow.g:660:2: ( ( () otherlv_1= 'MBoolExpr' ) )
            // InternalWorkflow.g:661:2: ( () otherlv_1= 'MBoolExpr' )
            {
            // InternalWorkflow.g:661:2: ( () otherlv_1= 'MBoolExpr' )
            // InternalWorkflow.g:662:3: () otherlv_1= 'MBoolExpr'
            {
            // InternalWorkflow.g:662:3: ()
            // InternalWorkflow.g:663:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMBoolExpr_ImplAccess().getMBoolExprAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getMBoolExpr_ImplAccess().getMBoolExprKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMBoolExpr_Impl"


    // $ANTLR start "entryRuleValue"
    // InternalWorkflow.g:677:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // InternalWorkflow.g:677:46: (iv_ruleValue= ruleValue EOF )
            // InternalWorkflow.g:678:2: iv_ruleValue= ruleValue EOF
            {
             newCompositeNode(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValue=ruleValue();

            state._fsp--;

             current =iv_ruleValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // InternalWorkflow.g:684:1: ruleValue returns [EObject current=null] : ( () otherlv_1= 'Value' otherlv_2= '{' (otherlv_3= 'value' ( (lv_value_4_0= ruleEInt ) ) )? otherlv_5= '}' ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:690:2: ( ( () otherlv_1= 'Value' otherlv_2= '{' (otherlv_3= 'value' ( (lv_value_4_0= ruleEInt ) ) )? otherlv_5= '}' ) )
            // InternalWorkflow.g:691:2: ( () otherlv_1= 'Value' otherlv_2= '{' (otherlv_3= 'value' ( (lv_value_4_0= ruleEInt ) ) )? otherlv_5= '}' )
            {
            // InternalWorkflow.g:691:2: ( () otherlv_1= 'Value' otherlv_2= '{' (otherlv_3= 'value' ( (lv_value_4_0= ruleEInt ) ) )? otherlv_5= '}' )
            // InternalWorkflow.g:692:3: () otherlv_1= 'Value' otherlv_2= '{' (otherlv_3= 'value' ( (lv_value_4_0= ruleEInt ) ) )? otherlv_5= '}'
            {
            // InternalWorkflow.g:692:3: ()
            // InternalWorkflow.g:693:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getValueAccess().getValueAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,28,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getValueAccess().getValueKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_17); 

            			newLeafNode(otherlv_2, grammarAccess.getValueAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalWorkflow.g:707:3: (otherlv_3= 'value' ( (lv_value_4_0= ruleEInt ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==29) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalWorkflow.g:708:4: otherlv_3= 'value' ( (lv_value_4_0= ruleEInt ) )
                    {
                    otherlv_3=(Token)match(input,29,FOLLOW_18); 

                    				newLeafNode(otherlv_3, grammarAccess.getValueAccess().getValueKeyword_3_0());
                    			
                    // InternalWorkflow.g:712:4: ( (lv_value_4_0= ruleEInt ) )
                    // InternalWorkflow.g:713:5: (lv_value_4_0= ruleEInt )
                    {
                    // InternalWorkflow.g:713:5: (lv_value_4_0= ruleEInt )
                    // InternalWorkflow.g:714:6: lv_value_4_0= ruleEInt
                    {

                    						newCompositeNode(grammarAccess.getValueAccess().getValueEIntParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_6);
                    lv_value_4_0=ruleEInt();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getValueRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_4_0,
                    							"agent.adaption.xtext.workflow.Workflow.EInt");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getValueAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleBoolValue"
    // InternalWorkflow.g:740:1: entryRuleBoolValue returns [EObject current=null] : iv_ruleBoolValue= ruleBoolValue EOF ;
    public final EObject entryRuleBoolValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolValue = null;


        try {
            // InternalWorkflow.g:740:50: (iv_ruleBoolValue= ruleBoolValue EOF )
            // InternalWorkflow.g:741:2: iv_ruleBoolValue= ruleBoolValue EOF
            {
             newCompositeNode(grammarAccess.getBoolValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBoolValue=ruleBoolValue();

            state._fsp--;

             current =iv_ruleBoolValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoolValue"


    // $ANTLR start "ruleBoolValue"
    // InternalWorkflow.g:747:1: ruleBoolValue returns [EObject current=null] : ( () ( (lv_value_1_0= 'value' ) )? otherlv_2= 'BoolValue' ) ;
    public final EObject ruleBoolValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalWorkflow.g:753:2: ( ( () ( (lv_value_1_0= 'value' ) )? otherlv_2= 'BoolValue' ) )
            // InternalWorkflow.g:754:2: ( () ( (lv_value_1_0= 'value' ) )? otherlv_2= 'BoolValue' )
            {
            // InternalWorkflow.g:754:2: ( () ( (lv_value_1_0= 'value' ) )? otherlv_2= 'BoolValue' )
            // InternalWorkflow.g:755:3: () ( (lv_value_1_0= 'value' ) )? otherlv_2= 'BoolValue'
            {
            // InternalWorkflow.g:755:3: ()
            // InternalWorkflow.g:756:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBoolValueAccess().getBoolValueAction_0(),
            					current);
            			

            }

            // InternalWorkflow.g:762:3: ( (lv_value_1_0= 'value' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==29) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalWorkflow.g:763:4: (lv_value_1_0= 'value' )
                    {
                    // InternalWorkflow.g:763:4: (lv_value_1_0= 'value' )
                    // InternalWorkflow.g:764:5: lv_value_1_0= 'value'
                    {
                    lv_value_1_0=(Token)match(input,29,FOLLOW_19); 

                    					newLeafNode(lv_value_1_0, grammarAccess.getBoolValueAccess().getValueValueKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBoolValueRule());
                    					}
                    					setWithLastConsumed(current, "value", lv_value_1_0 != null, "value");
                    				

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,30,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getBoolValueAccess().getBoolValueKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoolValue"


    // $ANTLR start "entryRuleBoolComp"
    // InternalWorkflow.g:784:1: entryRuleBoolComp returns [EObject current=null] : iv_ruleBoolComp= ruleBoolComp EOF ;
    public final EObject entryRuleBoolComp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolComp = null;


        try {
            // InternalWorkflow.g:784:49: (iv_ruleBoolComp= ruleBoolComp EOF )
            // InternalWorkflow.g:785:2: iv_ruleBoolComp= ruleBoolComp EOF
            {
             newCompositeNode(grammarAccess.getBoolCompRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBoolComp=ruleBoolComp();

            state._fsp--;

             current =iv_ruleBoolComp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoolComp"


    // $ANTLR start "ruleBoolComp"
    // InternalWorkflow.g:791:1: ruleBoolComp returns [EObject current=null] : ( () otherlv_1= 'BoolComp' otherlv_2= '{' (otherlv_3= 'op' ( (lv_op_4_0= ruleBoolOp ) ) )? (otherlv_5= 'right' ( (lv_right_6_0= ruleMBoolExpr ) ) )? (otherlv_7= 'left' ( (lv_left_8_0= ruleMBoolExpr ) ) )? otherlv_9= '}' ) ;
    public final EObject ruleBoolComp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Enumerator lv_op_4_0 = null;

        EObject lv_right_6_0 = null;

        EObject lv_left_8_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:797:2: ( ( () otherlv_1= 'BoolComp' otherlv_2= '{' (otherlv_3= 'op' ( (lv_op_4_0= ruleBoolOp ) ) )? (otherlv_5= 'right' ( (lv_right_6_0= ruleMBoolExpr ) ) )? (otherlv_7= 'left' ( (lv_left_8_0= ruleMBoolExpr ) ) )? otherlv_9= '}' ) )
            // InternalWorkflow.g:798:2: ( () otherlv_1= 'BoolComp' otherlv_2= '{' (otherlv_3= 'op' ( (lv_op_4_0= ruleBoolOp ) ) )? (otherlv_5= 'right' ( (lv_right_6_0= ruleMBoolExpr ) ) )? (otherlv_7= 'left' ( (lv_left_8_0= ruleMBoolExpr ) ) )? otherlv_9= '}' )
            {
            // InternalWorkflow.g:798:2: ( () otherlv_1= 'BoolComp' otherlv_2= '{' (otherlv_3= 'op' ( (lv_op_4_0= ruleBoolOp ) ) )? (otherlv_5= 'right' ( (lv_right_6_0= ruleMBoolExpr ) ) )? (otherlv_7= 'left' ( (lv_left_8_0= ruleMBoolExpr ) ) )? otherlv_9= '}' )
            // InternalWorkflow.g:799:3: () otherlv_1= 'BoolComp' otherlv_2= '{' (otherlv_3= 'op' ( (lv_op_4_0= ruleBoolOp ) ) )? (otherlv_5= 'right' ( (lv_right_6_0= ruleMBoolExpr ) ) )? (otherlv_7= 'left' ( (lv_left_8_0= ruleMBoolExpr ) ) )? otherlv_9= '}'
            {
            // InternalWorkflow.g:799:3: ()
            // InternalWorkflow.g:800:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBoolCompAccess().getBoolCompAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,31,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getBoolCompAccess().getBoolCompKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_20); 

            			newLeafNode(otherlv_2, grammarAccess.getBoolCompAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalWorkflow.g:814:3: (otherlv_3= 'op' ( (lv_op_4_0= ruleBoolOp ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==32) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalWorkflow.g:815:4: otherlv_3= 'op' ( (lv_op_4_0= ruleBoolOp ) )
                    {
                    otherlv_3=(Token)match(input,32,FOLLOW_21); 

                    				newLeafNode(otherlv_3, grammarAccess.getBoolCompAccess().getOpKeyword_3_0());
                    			
                    // InternalWorkflow.g:819:4: ( (lv_op_4_0= ruleBoolOp ) )
                    // InternalWorkflow.g:820:5: (lv_op_4_0= ruleBoolOp )
                    {
                    // InternalWorkflow.g:820:5: (lv_op_4_0= ruleBoolOp )
                    // InternalWorkflow.g:821:6: lv_op_4_0= ruleBoolOp
                    {

                    						newCompositeNode(grammarAccess.getBoolCompAccess().getOpBoolOpEnumRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_op_4_0=ruleBoolOp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBoolCompRule());
                    						}
                    						set(
                    							current,
                    							"op",
                    							lv_op_4_0,
                    							"agent.adaption.xtext.workflow.Workflow.BoolOp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:839:3: (otherlv_5= 'right' ( (lv_right_6_0= ruleMBoolExpr ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==33) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalWorkflow.g:840:4: otherlv_5= 'right' ( (lv_right_6_0= ruleMBoolExpr ) )
                    {
                    otherlv_5=(Token)match(input,33,FOLLOW_16); 

                    				newLeafNode(otherlv_5, grammarAccess.getBoolCompAccess().getRightKeyword_4_0());
                    			
                    // InternalWorkflow.g:844:4: ( (lv_right_6_0= ruleMBoolExpr ) )
                    // InternalWorkflow.g:845:5: (lv_right_6_0= ruleMBoolExpr )
                    {
                    // InternalWorkflow.g:845:5: (lv_right_6_0= ruleMBoolExpr )
                    // InternalWorkflow.g:846:6: lv_right_6_0= ruleMBoolExpr
                    {

                    						newCompositeNode(grammarAccess.getBoolCompAccess().getRightMBoolExprParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_23);
                    lv_right_6_0=ruleMBoolExpr();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBoolCompRule());
                    						}
                    						set(
                    							current,
                    							"right",
                    							lv_right_6_0,
                    							"agent.adaption.xtext.workflow.Workflow.MBoolExpr");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:864:3: (otherlv_7= 'left' ( (lv_left_8_0= ruleMBoolExpr ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==34) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalWorkflow.g:865:4: otherlv_7= 'left' ( (lv_left_8_0= ruleMBoolExpr ) )
                    {
                    otherlv_7=(Token)match(input,34,FOLLOW_16); 

                    				newLeafNode(otherlv_7, grammarAccess.getBoolCompAccess().getLeftKeyword_5_0());
                    			
                    // InternalWorkflow.g:869:4: ( (lv_left_8_0= ruleMBoolExpr ) )
                    // InternalWorkflow.g:870:5: (lv_left_8_0= ruleMBoolExpr )
                    {
                    // InternalWorkflow.g:870:5: (lv_left_8_0= ruleMBoolExpr )
                    // InternalWorkflow.g:871:6: lv_left_8_0= ruleMBoolExpr
                    {

                    						newCompositeNode(grammarAccess.getBoolCompAccess().getLeftMBoolExprParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_6);
                    lv_left_8_0=ruleMBoolExpr();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBoolCompRule());
                    						}
                    						set(
                    							current,
                    							"left",
                    							lv_left_8_0,
                    							"agent.adaption.xtext.workflow.Workflow.MBoolExpr");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getBoolCompAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoolComp"


    // $ANTLR start "entryRuleNot"
    // InternalWorkflow.g:897:1: entryRuleNot returns [EObject current=null] : iv_ruleNot= ruleNot EOF ;
    public final EObject entryRuleNot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNot = null;


        try {
            // InternalWorkflow.g:897:44: (iv_ruleNot= ruleNot EOF )
            // InternalWorkflow.g:898:2: iv_ruleNot= ruleNot EOF
            {
             newCompositeNode(grammarAccess.getNotRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNot=ruleNot();

            state._fsp--;

             current =iv_ruleNot; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNot"


    // $ANTLR start "ruleNot"
    // InternalWorkflow.g:904:1: ruleNot returns [EObject current=null] : ( () otherlv_1= 'Not' otherlv_2= '{' (otherlv_3= 'op' ( (lv_op_4_0= ruleEString ) ) )? (otherlv_5= 'expr' ( (lv_expr_6_0= ruleMBoolExpr ) ) )? otherlv_7= '}' ) ;
    public final EObject ruleNot() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_op_4_0 = null;

        EObject lv_expr_6_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:910:2: ( ( () otherlv_1= 'Not' otherlv_2= '{' (otherlv_3= 'op' ( (lv_op_4_0= ruleEString ) ) )? (otherlv_5= 'expr' ( (lv_expr_6_0= ruleMBoolExpr ) ) )? otherlv_7= '}' ) )
            // InternalWorkflow.g:911:2: ( () otherlv_1= 'Not' otherlv_2= '{' (otherlv_3= 'op' ( (lv_op_4_0= ruleEString ) ) )? (otherlv_5= 'expr' ( (lv_expr_6_0= ruleMBoolExpr ) ) )? otherlv_7= '}' )
            {
            // InternalWorkflow.g:911:2: ( () otherlv_1= 'Not' otherlv_2= '{' (otherlv_3= 'op' ( (lv_op_4_0= ruleEString ) ) )? (otherlv_5= 'expr' ( (lv_expr_6_0= ruleMBoolExpr ) ) )? otherlv_7= '}' )
            // InternalWorkflow.g:912:3: () otherlv_1= 'Not' otherlv_2= '{' (otherlv_3= 'op' ( (lv_op_4_0= ruleEString ) ) )? (otherlv_5= 'expr' ( (lv_expr_6_0= ruleMBoolExpr ) ) )? otherlv_7= '}'
            {
            // InternalWorkflow.g:912:3: ()
            // InternalWorkflow.g:913:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNotAccess().getNotAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,35,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getNotAccess().getNotKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_24); 

            			newLeafNode(otherlv_2, grammarAccess.getNotAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalWorkflow.g:927:3: (otherlv_3= 'op' ( (lv_op_4_0= ruleEString ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==32) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalWorkflow.g:928:4: otherlv_3= 'op' ( (lv_op_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,32,FOLLOW_10); 

                    				newLeafNode(otherlv_3, grammarAccess.getNotAccess().getOpKeyword_3_0());
                    			
                    // InternalWorkflow.g:932:4: ( (lv_op_4_0= ruleEString ) )
                    // InternalWorkflow.g:933:5: (lv_op_4_0= ruleEString )
                    {
                    // InternalWorkflow.g:933:5: (lv_op_4_0= ruleEString )
                    // InternalWorkflow.g:934:6: lv_op_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getNotAccess().getOpEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_25);
                    lv_op_4_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getNotRule());
                    						}
                    						set(
                    							current,
                    							"op",
                    							lv_op_4_0,
                    							"agent.adaption.xtext.workflow.Workflow.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:952:3: (otherlv_5= 'expr' ( (lv_expr_6_0= ruleMBoolExpr ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==36) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalWorkflow.g:953:4: otherlv_5= 'expr' ( (lv_expr_6_0= ruleMBoolExpr ) )
                    {
                    otherlv_5=(Token)match(input,36,FOLLOW_16); 

                    				newLeafNode(otherlv_5, grammarAccess.getNotAccess().getExprKeyword_4_0());
                    			
                    // InternalWorkflow.g:957:4: ( (lv_expr_6_0= ruleMBoolExpr ) )
                    // InternalWorkflow.g:958:5: (lv_expr_6_0= ruleMBoolExpr )
                    {
                    // InternalWorkflow.g:958:5: (lv_expr_6_0= ruleMBoolExpr )
                    // InternalWorkflow.g:959:6: lv_expr_6_0= ruleMBoolExpr
                    {

                    						newCompositeNode(grammarAccess.getNotAccess().getExprMBoolExprParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_6);
                    lv_expr_6_0=ruleMBoolExpr();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getNotRule());
                    						}
                    						set(
                    							current,
                    							"expr",
                    							lv_expr_6_0,
                    							"agent.adaption.xtext.workflow.Workflow.MBoolExpr");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getNotAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNot"


    // $ANTLR start "entryRuleRelComp"
    // InternalWorkflow.g:985:1: entryRuleRelComp returns [EObject current=null] : iv_ruleRelComp= ruleRelComp EOF ;
    public final EObject entryRuleRelComp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelComp = null;


        try {
            // InternalWorkflow.g:985:48: (iv_ruleRelComp= ruleRelComp EOF )
            // InternalWorkflow.g:986:2: iv_ruleRelComp= ruleRelComp EOF
            {
             newCompositeNode(grammarAccess.getRelCompRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRelComp=ruleRelComp();

            state._fsp--;

             current =iv_ruleRelComp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelComp"


    // $ANTLR start "ruleRelComp"
    // InternalWorkflow.g:992:1: ruleRelComp returns [EObject current=null] : ( () otherlv_1= 'RelComp' otherlv_2= '{' (otherlv_3= 'op' ( (lv_op_4_0= ruleRelOp ) ) )? (otherlv_5= 'left' ( (lv_left_6_0= ruleMBoolExpr ) ) )? (otherlv_7= 'right' ( (lv_right_8_0= ruleMBoolExpr ) ) )? otherlv_9= '}' ) ;
    public final EObject ruleRelComp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Enumerator lv_op_4_0 = null;

        EObject lv_left_6_0 = null;

        EObject lv_right_8_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:998:2: ( ( () otherlv_1= 'RelComp' otherlv_2= '{' (otherlv_3= 'op' ( (lv_op_4_0= ruleRelOp ) ) )? (otherlv_5= 'left' ( (lv_left_6_0= ruleMBoolExpr ) ) )? (otherlv_7= 'right' ( (lv_right_8_0= ruleMBoolExpr ) ) )? otherlv_9= '}' ) )
            // InternalWorkflow.g:999:2: ( () otherlv_1= 'RelComp' otherlv_2= '{' (otherlv_3= 'op' ( (lv_op_4_0= ruleRelOp ) ) )? (otherlv_5= 'left' ( (lv_left_6_0= ruleMBoolExpr ) ) )? (otherlv_7= 'right' ( (lv_right_8_0= ruleMBoolExpr ) ) )? otherlv_9= '}' )
            {
            // InternalWorkflow.g:999:2: ( () otherlv_1= 'RelComp' otherlv_2= '{' (otherlv_3= 'op' ( (lv_op_4_0= ruleRelOp ) ) )? (otherlv_5= 'left' ( (lv_left_6_0= ruleMBoolExpr ) ) )? (otherlv_7= 'right' ( (lv_right_8_0= ruleMBoolExpr ) ) )? otherlv_9= '}' )
            // InternalWorkflow.g:1000:3: () otherlv_1= 'RelComp' otherlv_2= '{' (otherlv_3= 'op' ( (lv_op_4_0= ruleRelOp ) ) )? (otherlv_5= 'left' ( (lv_left_6_0= ruleMBoolExpr ) ) )? (otherlv_7= 'right' ( (lv_right_8_0= ruleMBoolExpr ) ) )? otherlv_9= '}'
            {
            // InternalWorkflow.g:1000:3: ()
            // InternalWorkflow.g:1001:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRelCompAccess().getRelCompAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,37,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getRelCompAccess().getRelCompKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_20); 

            			newLeafNode(otherlv_2, grammarAccess.getRelCompAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalWorkflow.g:1015:3: (otherlv_3= 'op' ( (lv_op_4_0= ruleRelOp ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==32) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalWorkflow.g:1016:4: otherlv_3= 'op' ( (lv_op_4_0= ruleRelOp ) )
                    {
                    otherlv_3=(Token)match(input,32,FOLLOW_26); 

                    				newLeafNode(otherlv_3, grammarAccess.getRelCompAccess().getOpKeyword_3_0());
                    			
                    // InternalWorkflow.g:1020:4: ( (lv_op_4_0= ruleRelOp ) )
                    // InternalWorkflow.g:1021:5: (lv_op_4_0= ruleRelOp )
                    {
                    // InternalWorkflow.g:1021:5: (lv_op_4_0= ruleRelOp )
                    // InternalWorkflow.g:1022:6: lv_op_4_0= ruleRelOp
                    {

                    						newCompositeNode(grammarAccess.getRelCompAccess().getOpRelOpEnumRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_op_4_0=ruleRelOp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRelCompRule());
                    						}
                    						set(
                    							current,
                    							"op",
                    							lv_op_4_0,
                    							"agent.adaption.xtext.workflow.Workflow.RelOp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:1040:3: (otherlv_5= 'left' ( (lv_left_6_0= ruleMBoolExpr ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==34) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalWorkflow.g:1041:4: otherlv_5= 'left' ( (lv_left_6_0= ruleMBoolExpr ) )
                    {
                    otherlv_5=(Token)match(input,34,FOLLOW_16); 

                    				newLeafNode(otherlv_5, grammarAccess.getRelCompAccess().getLeftKeyword_4_0());
                    			
                    // InternalWorkflow.g:1045:4: ( (lv_left_6_0= ruleMBoolExpr ) )
                    // InternalWorkflow.g:1046:5: (lv_left_6_0= ruleMBoolExpr )
                    {
                    // InternalWorkflow.g:1046:5: (lv_left_6_0= ruleMBoolExpr )
                    // InternalWorkflow.g:1047:6: lv_left_6_0= ruleMBoolExpr
                    {

                    						newCompositeNode(grammarAccess.getRelCompAccess().getLeftMBoolExprParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_27);
                    lv_left_6_0=ruleMBoolExpr();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRelCompRule());
                    						}
                    						set(
                    							current,
                    							"left",
                    							lv_left_6_0,
                    							"agent.adaption.xtext.workflow.Workflow.MBoolExpr");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:1065:3: (otherlv_7= 'right' ( (lv_right_8_0= ruleMBoolExpr ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==33) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalWorkflow.g:1066:4: otherlv_7= 'right' ( (lv_right_8_0= ruleMBoolExpr ) )
                    {
                    otherlv_7=(Token)match(input,33,FOLLOW_16); 

                    				newLeafNode(otherlv_7, grammarAccess.getRelCompAccess().getRightKeyword_5_0());
                    			
                    // InternalWorkflow.g:1070:4: ( (lv_right_8_0= ruleMBoolExpr ) )
                    // InternalWorkflow.g:1071:5: (lv_right_8_0= ruleMBoolExpr )
                    {
                    // InternalWorkflow.g:1071:5: (lv_right_8_0= ruleMBoolExpr )
                    // InternalWorkflow.g:1072:6: lv_right_8_0= ruleMBoolExpr
                    {

                    						newCompositeNode(grammarAccess.getRelCompAccess().getRightMBoolExprParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_6);
                    lv_right_8_0=ruleMBoolExpr();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRelCompRule());
                    						}
                    						set(
                    							current,
                    							"right",
                    							lv_right_8_0,
                    							"agent.adaption.xtext.workflow.Workflow.MBoolExpr");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getRelCompAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelComp"


    // $ANTLR start "entryRuleAtom"
    // InternalWorkflow.g:1098:1: entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF ;
    public final EObject entryRuleAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtom = null;


        try {
            // InternalWorkflow.g:1098:45: (iv_ruleAtom= ruleAtom EOF )
            // InternalWorkflow.g:1099:2: iv_ruleAtom= ruleAtom EOF
            {
             newCompositeNode(grammarAccess.getAtomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAtom=ruleAtom();

            state._fsp--;

             current =iv_ruleAtom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAtom"


    // $ANTLR start "ruleAtom"
    // InternalWorkflow.g:1105:1: ruleAtom returns [EObject current=null] : ( () otherlv_1= 'Atom' otherlv_2= '{' (otherlv_3= 'measureID' ( (lv_measureID_4_0= ruleEString ) ) )? otherlv_5= '}' ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_measureID_4_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:1111:2: ( ( () otherlv_1= 'Atom' otherlv_2= '{' (otherlv_3= 'measureID' ( (lv_measureID_4_0= ruleEString ) ) )? otherlv_5= '}' ) )
            // InternalWorkflow.g:1112:2: ( () otherlv_1= 'Atom' otherlv_2= '{' (otherlv_3= 'measureID' ( (lv_measureID_4_0= ruleEString ) ) )? otherlv_5= '}' )
            {
            // InternalWorkflow.g:1112:2: ( () otherlv_1= 'Atom' otherlv_2= '{' (otherlv_3= 'measureID' ( (lv_measureID_4_0= ruleEString ) ) )? otherlv_5= '}' )
            // InternalWorkflow.g:1113:3: () otherlv_1= 'Atom' otherlv_2= '{' (otherlv_3= 'measureID' ( (lv_measureID_4_0= ruleEString ) ) )? otherlv_5= '}'
            {
            // InternalWorkflow.g:1113:3: ()
            // InternalWorkflow.g:1114:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getAtomAccess().getAtomAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,38,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getAtomAccess().getAtomKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getAtomAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalWorkflow.g:1128:3: (otherlv_3= 'measureID' ( (lv_measureID_4_0= ruleEString ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==39) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalWorkflow.g:1129:4: otherlv_3= 'measureID' ( (lv_measureID_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,39,FOLLOW_10); 

                    				newLeafNode(otherlv_3, grammarAccess.getAtomAccess().getMeasureIDKeyword_3_0());
                    			
                    // InternalWorkflow.g:1133:4: ( (lv_measureID_4_0= ruleEString ) )
                    // InternalWorkflow.g:1134:5: (lv_measureID_4_0= ruleEString )
                    {
                    // InternalWorkflow.g:1134:5: (lv_measureID_4_0= ruleEString )
                    // InternalWorkflow.g:1135:6: lv_measureID_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getAtomAccess().getMeasureIDEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_6);
                    lv_measureID_4_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAtomRule());
                    						}
                    						set(
                    							current,
                    							"measureID",
                    							lv_measureID_4_0,
                    							"agent.adaption.xtext.workflow.Workflow.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getAtomAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAtom"


    // $ANTLR start "entryRuleEInt"
    // InternalWorkflow.g:1161:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // InternalWorkflow.g:1161:44: (iv_ruleEInt= ruleEInt EOF )
            // InternalWorkflow.g:1162:2: iv_ruleEInt= ruleEInt EOF
            {
             newCompositeNode(grammarAccess.getEIntRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEInt=ruleEInt();

            state._fsp--;

             current =iv_ruleEInt.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // InternalWorkflow.g:1168:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalWorkflow.g:1174:2: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // InternalWorkflow.g:1175:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // InternalWorkflow.g:1175:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            // InternalWorkflow.g:1176:3: (kw= '-' )? this_INT_1= RULE_INT
            {
            // InternalWorkflow.g:1176:3: (kw= '-' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==40) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalWorkflow.g:1177:4: kw= '-'
                    {
                    kw=(Token)match(input,40,FOLLOW_29); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEIntAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_2); 

            			current.merge(this_INT_1);
            		

            			newLeafNode(this_INT_1, grammarAccess.getEIntAccess().getINTTerminalRuleCall_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEInt"


    // $ANTLR start "ruleBoolOp"
    // InternalWorkflow.g:1194:1: ruleBoolOp returns [Enumerator current=null] : ( (enumLiteral_0= 'AND' ) | (enumLiteral_1= 'OR' ) ) ;
    public final Enumerator ruleBoolOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalWorkflow.g:1200:2: ( ( (enumLiteral_0= 'AND' ) | (enumLiteral_1= 'OR' ) ) )
            // InternalWorkflow.g:1201:2: ( (enumLiteral_0= 'AND' ) | (enumLiteral_1= 'OR' ) )
            {
            // InternalWorkflow.g:1201:2: ( (enumLiteral_0= 'AND' ) | (enumLiteral_1= 'OR' ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==41) ) {
                alt18=1;
            }
            else if ( (LA18_0==42) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalWorkflow.g:1202:3: (enumLiteral_0= 'AND' )
                    {
                    // InternalWorkflow.g:1202:3: (enumLiteral_0= 'AND' )
                    // InternalWorkflow.g:1203:4: enumLiteral_0= 'AND'
                    {
                    enumLiteral_0=(Token)match(input,41,FOLLOW_2); 

                    				current = grammarAccess.getBoolOpAccess().getANDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getBoolOpAccess().getANDEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:1210:3: (enumLiteral_1= 'OR' )
                    {
                    // InternalWorkflow.g:1210:3: (enumLiteral_1= 'OR' )
                    // InternalWorkflow.g:1211:4: enumLiteral_1= 'OR'
                    {
                    enumLiteral_1=(Token)match(input,42,FOLLOW_2); 

                    				current = grammarAccess.getBoolOpAccess().getOREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getBoolOpAccess().getOREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoolOp"


    // $ANTLR start "ruleRelOp"
    // InternalWorkflow.g:1221:1: ruleRelOp returns [Enumerator current=null] : ( (enumLiteral_0= 'LESS_THAN' ) | (enumLiteral_1= 'GREATER_THAN' ) | (enumLiteral_2= 'NOT_EQUAL' ) | (enumLiteral_3= 'LESS_EQUAL' ) | (enumLiteral_4= 'GREATER_EQUAL' ) | (enumLiteral_5= 'EQUAL' ) ) ;
    public final Enumerator ruleRelOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalWorkflow.g:1227:2: ( ( (enumLiteral_0= 'LESS_THAN' ) | (enumLiteral_1= 'GREATER_THAN' ) | (enumLiteral_2= 'NOT_EQUAL' ) | (enumLiteral_3= 'LESS_EQUAL' ) | (enumLiteral_4= 'GREATER_EQUAL' ) | (enumLiteral_5= 'EQUAL' ) ) )
            // InternalWorkflow.g:1228:2: ( (enumLiteral_0= 'LESS_THAN' ) | (enumLiteral_1= 'GREATER_THAN' ) | (enumLiteral_2= 'NOT_EQUAL' ) | (enumLiteral_3= 'LESS_EQUAL' ) | (enumLiteral_4= 'GREATER_EQUAL' ) | (enumLiteral_5= 'EQUAL' ) )
            {
            // InternalWorkflow.g:1228:2: ( (enumLiteral_0= 'LESS_THAN' ) | (enumLiteral_1= 'GREATER_THAN' ) | (enumLiteral_2= 'NOT_EQUAL' ) | (enumLiteral_3= 'LESS_EQUAL' ) | (enumLiteral_4= 'GREATER_EQUAL' ) | (enumLiteral_5= 'EQUAL' ) )
            int alt19=6;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt19=1;
                }
                break;
            case 44:
                {
                alt19=2;
                }
                break;
            case 45:
                {
                alt19=3;
                }
                break;
            case 46:
                {
                alt19=4;
                }
                break;
            case 47:
                {
                alt19=5;
                }
                break;
            case 48:
                {
                alt19=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalWorkflow.g:1229:3: (enumLiteral_0= 'LESS_THAN' )
                    {
                    // InternalWorkflow.g:1229:3: (enumLiteral_0= 'LESS_THAN' )
                    // InternalWorkflow.g:1230:4: enumLiteral_0= 'LESS_THAN'
                    {
                    enumLiteral_0=(Token)match(input,43,FOLLOW_2); 

                    				current = grammarAccess.getRelOpAccess().getLESS_THANEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getRelOpAccess().getLESS_THANEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:1237:3: (enumLiteral_1= 'GREATER_THAN' )
                    {
                    // InternalWorkflow.g:1237:3: (enumLiteral_1= 'GREATER_THAN' )
                    // InternalWorkflow.g:1238:4: enumLiteral_1= 'GREATER_THAN'
                    {
                    enumLiteral_1=(Token)match(input,44,FOLLOW_2); 

                    				current = grammarAccess.getRelOpAccess().getGREATER_THANEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getRelOpAccess().getGREATER_THANEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:1245:3: (enumLiteral_2= 'NOT_EQUAL' )
                    {
                    // InternalWorkflow.g:1245:3: (enumLiteral_2= 'NOT_EQUAL' )
                    // InternalWorkflow.g:1246:4: enumLiteral_2= 'NOT_EQUAL'
                    {
                    enumLiteral_2=(Token)match(input,45,FOLLOW_2); 

                    				current = grammarAccess.getRelOpAccess().getNOT_EQUALEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getRelOpAccess().getNOT_EQUALEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalWorkflow.g:1253:3: (enumLiteral_3= 'LESS_EQUAL' )
                    {
                    // InternalWorkflow.g:1253:3: (enumLiteral_3= 'LESS_EQUAL' )
                    // InternalWorkflow.g:1254:4: enumLiteral_3= 'LESS_EQUAL'
                    {
                    enumLiteral_3=(Token)match(input,46,FOLLOW_2); 

                    				current = grammarAccess.getRelOpAccess().getLESS_EQUALEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getRelOpAccess().getLESS_EQUALEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalWorkflow.g:1261:3: (enumLiteral_4= 'GREATER_EQUAL' )
                    {
                    // InternalWorkflow.g:1261:3: (enumLiteral_4= 'GREATER_EQUAL' )
                    // InternalWorkflow.g:1262:4: enumLiteral_4= 'GREATER_EQUAL'
                    {
                    enumLiteral_4=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getRelOpAccess().getGREATER_EQUALEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getRelOpAccess().getGREATER_EQUALEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalWorkflow.g:1269:3: (enumLiteral_5= 'EQUAL' )
                    {
                    // InternalWorkflow.g:1269:3: (enumLiteral_5= 'EQUAL' )
                    // InternalWorkflow.g:1270:4: enumLiteral_5= 'EQUAL'
                    {
                    enumLiteral_5=(Token)match(input,48,FOLLOW_2); 

                    				current = grammarAccess.getRelOpAccess().getEQUALEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getRelOpAccess().getEQUALEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelOp"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000548000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x00000068F8000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000020004000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000010000000040L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000700004000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000600004000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000001100004000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000001000004000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0001F80000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000200004000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000008000004000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000040L});

}