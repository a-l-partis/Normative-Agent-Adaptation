package agent.adaption.xtext.workflow.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import agent.adaption.xtext.workflow.services.WorkflowGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalWorkflowParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'AND'", "'OR'", "'LESS_THAN'", "'GREATER_THAN'", "'NOT_EQUAL'", "'LESS_EQUAL'", "'GREATER_EQUAL'", "'EQUAL'", "'WorkflowStructure'", "'{'", "'workflowspec'", "'}'", "'Sequence'", "'subworkflows'", "','", "'Task'", "'ID'", "'Loop'", "'loop'", "'Decision'", "'options'", "'GuardedWorkflow'", "'body'", "'guard'", "'MBoolExpr'", "'Value'", "'value'", "'BoolValue'", "'BoolComp'", "'op'", "'right'", "'left'", "'Not'", "'expr'", "'RelComp'", "'Atom'", "'measureID'", "'-'"
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

    	public void setGrammarAccess(WorkflowGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleWorkflowStructure"
    // InternalWorkflow.g:53:1: entryRuleWorkflowStructure : ruleWorkflowStructure EOF ;
    public final void entryRuleWorkflowStructure() throws RecognitionException {
        try {
            // InternalWorkflow.g:54:1: ( ruleWorkflowStructure EOF )
            // InternalWorkflow.g:55:1: ruleWorkflowStructure EOF
            {
             before(grammarAccess.getWorkflowStructureRule()); 
            pushFollow(FOLLOW_1);
            ruleWorkflowStructure();

            state._fsp--;

             after(grammarAccess.getWorkflowStructureRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleWorkflowStructure"


    // $ANTLR start "ruleWorkflowStructure"
    // InternalWorkflow.g:62:1: ruleWorkflowStructure : ( ( rule__WorkflowStructure__Group__0 ) ) ;
    public final void ruleWorkflowStructure() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:66:2: ( ( ( rule__WorkflowStructure__Group__0 ) ) )
            // InternalWorkflow.g:67:2: ( ( rule__WorkflowStructure__Group__0 ) )
            {
            // InternalWorkflow.g:67:2: ( ( rule__WorkflowStructure__Group__0 ) )
            // InternalWorkflow.g:68:3: ( rule__WorkflowStructure__Group__0 )
            {
             before(grammarAccess.getWorkflowStructureAccess().getGroup()); 
            // InternalWorkflow.g:69:3: ( rule__WorkflowStructure__Group__0 )
            // InternalWorkflow.g:69:4: rule__WorkflowStructure__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__WorkflowStructure__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getWorkflowStructureAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWorkflowStructure"


    // $ANTLR start "entryRuleWorkflow"
    // InternalWorkflow.g:78:1: entryRuleWorkflow : ruleWorkflow EOF ;
    public final void entryRuleWorkflow() throws RecognitionException {
        try {
            // InternalWorkflow.g:79:1: ( ruleWorkflow EOF )
            // InternalWorkflow.g:80:1: ruleWorkflow EOF
            {
             before(grammarAccess.getWorkflowRule()); 
            pushFollow(FOLLOW_1);
            ruleWorkflow();

            state._fsp--;

             after(grammarAccess.getWorkflowRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleWorkflow"


    // $ANTLR start "ruleWorkflow"
    // InternalWorkflow.g:87:1: ruleWorkflow : ( ( rule__Workflow__Alternatives ) ) ;
    public final void ruleWorkflow() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:91:2: ( ( ( rule__Workflow__Alternatives ) ) )
            // InternalWorkflow.g:92:2: ( ( rule__Workflow__Alternatives ) )
            {
            // InternalWorkflow.g:92:2: ( ( rule__Workflow__Alternatives ) )
            // InternalWorkflow.g:93:3: ( rule__Workflow__Alternatives )
            {
             before(grammarAccess.getWorkflowAccess().getAlternatives()); 
            // InternalWorkflow.g:94:3: ( rule__Workflow__Alternatives )
            // InternalWorkflow.g:94:4: rule__Workflow__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Workflow__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getWorkflowAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWorkflow"


    // $ANTLR start "entryRuleMBoolExpr"
    // InternalWorkflow.g:103:1: entryRuleMBoolExpr : ruleMBoolExpr EOF ;
    public final void entryRuleMBoolExpr() throws RecognitionException {
        try {
            // InternalWorkflow.g:104:1: ( ruleMBoolExpr EOF )
            // InternalWorkflow.g:105:1: ruleMBoolExpr EOF
            {
             before(grammarAccess.getMBoolExprRule()); 
            pushFollow(FOLLOW_1);
            ruleMBoolExpr();

            state._fsp--;

             after(grammarAccess.getMBoolExprRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMBoolExpr"


    // $ANTLR start "ruleMBoolExpr"
    // InternalWorkflow.g:112:1: ruleMBoolExpr : ( ( rule__MBoolExpr__Alternatives ) ) ;
    public final void ruleMBoolExpr() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:116:2: ( ( ( rule__MBoolExpr__Alternatives ) ) )
            // InternalWorkflow.g:117:2: ( ( rule__MBoolExpr__Alternatives ) )
            {
            // InternalWorkflow.g:117:2: ( ( rule__MBoolExpr__Alternatives ) )
            // InternalWorkflow.g:118:3: ( rule__MBoolExpr__Alternatives )
            {
             before(grammarAccess.getMBoolExprAccess().getAlternatives()); 
            // InternalWorkflow.g:119:3: ( rule__MBoolExpr__Alternatives )
            // InternalWorkflow.g:119:4: rule__MBoolExpr__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__MBoolExpr__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getMBoolExprAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMBoolExpr"


    // $ANTLR start "entryRuleSequence"
    // InternalWorkflow.g:128:1: entryRuleSequence : ruleSequence EOF ;
    public final void entryRuleSequence() throws RecognitionException {
        try {
            // InternalWorkflow.g:129:1: ( ruleSequence EOF )
            // InternalWorkflow.g:130:1: ruleSequence EOF
            {
             before(grammarAccess.getSequenceRule()); 
            pushFollow(FOLLOW_1);
            ruleSequence();

            state._fsp--;

             after(grammarAccess.getSequenceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSequence"


    // $ANTLR start "ruleSequence"
    // InternalWorkflow.g:137:1: ruleSequence : ( ( rule__Sequence__Group__0 ) ) ;
    public final void ruleSequence() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:141:2: ( ( ( rule__Sequence__Group__0 ) ) )
            // InternalWorkflow.g:142:2: ( ( rule__Sequence__Group__0 ) )
            {
            // InternalWorkflow.g:142:2: ( ( rule__Sequence__Group__0 ) )
            // InternalWorkflow.g:143:3: ( rule__Sequence__Group__0 )
            {
             before(grammarAccess.getSequenceAccess().getGroup()); 
            // InternalWorkflow.g:144:3: ( rule__Sequence__Group__0 )
            // InternalWorkflow.g:144:4: rule__Sequence__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Sequence__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSequenceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSequence"


    // $ANTLR start "entryRuleTask"
    // InternalWorkflow.g:153:1: entryRuleTask : ruleTask EOF ;
    public final void entryRuleTask() throws RecognitionException {
        try {
            // InternalWorkflow.g:154:1: ( ruleTask EOF )
            // InternalWorkflow.g:155:1: ruleTask EOF
            {
             before(grammarAccess.getTaskRule()); 
            pushFollow(FOLLOW_1);
            ruleTask();

            state._fsp--;

             after(grammarAccess.getTaskRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTask"


    // $ANTLR start "ruleTask"
    // InternalWorkflow.g:162:1: ruleTask : ( ( rule__Task__Group__0 ) ) ;
    public final void ruleTask() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:166:2: ( ( ( rule__Task__Group__0 ) ) )
            // InternalWorkflow.g:167:2: ( ( rule__Task__Group__0 ) )
            {
            // InternalWorkflow.g:167:2: ( ( rule__Task__Group__0 ) )
            // InternalWorkflow.g:168:3: ( rule__Task__Group__0 )
            {
             before(grammarAccess.getTaskAccess().getGroup()); 
            // InternalWorkflow.g:169:3: ( rule__Task__Group__0 )
            // InternalWorkflow.g:169:4: rule__Task__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Task__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTaskAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTask"


    // $ANTLR start "entryRuleLoop"
    // InternalWorkflow.g:178:1: entryRuleLoop : ruleLoop EOF ;
    public final void entryRuleLoop() throws RecognitionException {
        try {
            // InternalWorkflow.g:179:1: ( ruleLoop EOF )
            // InternalWorkflow.g:180:1: ruleLoop EOF
            {
             before(grammarAccess.getLoopRule()); 
            pushFollow(FOLLOW_1);
            ruleLoop();

            state._fsp--;

             after(grammarAccess.getLoopRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLoop"


    // $ANTLR start "ruleLoop"
    // InternalWorkflow.g:187:1: ruleLoop : ( ( rule__Loop__Group__0 ) ) ;
    public final void ruleLoop() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:191:2: ( ( ( rule__Loop__Group__0 ) ) )
            // InternalWorkflow.g:192:2: ( ( rule__Loop__Group__0 ) )
            {
            // InternalWorkflow.g:192:2: ( ( rule__Loop__Group__0 ) )
            // InternalWorkflow.g:193:3: ( rule__Loop__Group__0 )
            {
             before(grammarAccess.getLoopAccess().getGroup()); 
            // InternalWorkflow.g:194:3: ( rule__Loop__Group__0 )
            // InternalWorkflow.g:194:4: rule__Loop__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Loop__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLoopAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLoop"


    // $ANTLR start "entryRuleDecision"
    // InternalWorkflow.g:203:1: entryRuleDecision : ruleDecision EOF ;
    public final void entryRuleDecision() throws RecognitionException {
        try {
            // InternalWorkflow.g:204:1: ( ruleDecision EOF )
            // InternalWorkflow.g:205:1: ruleDecision EOF
            {
             before(grammarAccess.getDecisionRule()); 
            pushFollow(FOLLOW_1);
            ruleDecision();

            state._fsp--;

             after(grammarAccess.getDecisionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDecision"


    // $ANTLR start "ruleDecision"
    // InternalWorkflow.g:212:1: ruleDecision : ( ( rule__Decision__Group__0 ) ) ;
    public final void ruleDecision() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:216:2: ( ( ( rule__Decision__Group__0 ) ) )
            // InternalWorkflow.g:217:2: ( ( rule__Decision__Group__0 ) )
            {
            // InternalWorkflow.g:217:2: ( ( rule__Decision__Group__0 ) )
            // InternalWorkflow.g:218:3: ( rule__Decision__Group__0 )
            {
             before(grammarAccess.getDecisionAccess().getGroup()); 
            // InternalWorkflow.g:219:3: ( rule__Decision__Group__0 )
            // InternalWorkflow.g:219:4: rule__Decision__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Decision__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDecisionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDecision"


    // $ANTLR start "entryRuleEString"
    // InternalWorkflow.g:228:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalWorkflow.g:229:1: ( ruleEString EOF )
            // InternalWorkflow.g:230:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEStringRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalWorkflow.g:237:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:241:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalWorkflow.g:242:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalWorkflow.g:242:2: ( ( rule__EString__Alternatives ) )
            // InternalWorkflow.g:243:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalWorkflow.g:244:3: ( rule__EString__Alternatives )
            // InternalWorkflow.g:244:4: rule__EString__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EString__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEStringAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleGuardedWorkflow"
    // InternalWorkflow.g:253:1: entryRuleGuardedWorkflow : ruleGuardedWorkflow EOF ;
    public final void entryRuleGuardedWorkflow() throws RecognitionException {
        try {
            // InternalWorkflow.g:254:1: ( ruleGuardedWorkflow EOF )
            // InternalWorkflow.g:255:1: ruleGuardedWorkflow EOF
            {
             before(grammarAccess.getGuardedWorkflowRule()); 
            pushFollow(FOLLOW_1);
            ruleGuardedWorkflow();

            state._fsp--;

             after(grammarAccess.getGuardedWorkflowRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGuardedWorkflow"


    // $ANTLR start "ruleGuardedWorkflow"
    // InternalWorkflow.g:262:1: ruleGuardedWorkflow : ( ( rule__GuardedWorkflow__Group__0 ) ) ;
    public final void ruleGuardedWorkflow() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:266:2: ( ( ( rule__GuardedWorkflow__Group__0 ) ) )
            // InternalWorkflow.g:267:2: ( ( rule__GuardedWorkflow__Group__0 ) )
            {
            // InternalWorkflow.g:267:2: ( ( rule__GuardedWorkflow__Group__0 ) )
            // InternalWorkflow.g:268:3: ( rule__GuardedWorkflow__Group__0 )
            {
             before(grammarAccess.getGuardedWorkflowAccess().getGroup()); 
            // InternalWorkflow.g:269:3: ( rule__GuardedWorkflow__Group__0 )
            // InternalWorkflow.g:269:4: rule__GuardedWorkflow__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__GuardedWorkflow__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGuardedWorkflowAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGuardedWorkflow"


    // $ANTLR start "entryRuleMBoolExpr_Impl"
    // InternalWorkflow.g:278:1: entryRuleMBoolExpr_Impl : ruleMBoolExpr_Impl EOF ;
    public final void entryRuleMBoolExpr_Impl() throws RecognitionException {
        try {
            // InternalWorkflow.g:279:1: ( ruleMBoolExpr_Impl EOF )
            // InternalWorkflow.g:280:1: ruleMBoolExpr_Impl EOF
            {
             before(grammarAccess.getMBoolExpr_ImplRule()); 
            pushFollow(FOLLOW_1);
            ruleMBoolExpr_Impl();

            state._fsp--;

             after(grammarAccess.getMBoolExpr_ImplRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMBoolExpr_Impl"


    // $ANTLR start "ruleMBoolExpr_Impl"
    // InternalWorkflow.g:287:1: ruleMBoolExpr_Impl : ( ( rule__MBoolExpr_Impl__Group__0 ) ) ;
    public final void ruleMBoolExpr_Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:291:2: ( ( ( rule__MBoolExpr_Impl__Group__0 ) ) )
            // InternalWorkflow.g:292:2: ( ( rule__MBoolExpr_Impl__Group__0 ) )
            {
            // InternalWorkflow.g:292:2: ( ( rule__MBoolExpr_Impl__Group__0 ) )
            // InternalWorkflow.g:293:3: ( rule__MBoolExpr_Impl__Group__0 )
            {
             before(grammarAccess.getMBoolExpr_ImplAccess().getGroup()); 
            // InternalWorkflow.g:294:3: ( rule__MBoolExpr_Impl__Group__0 )
            // InternalWorkflow.g:294:4: rule__MBoolExpr_Impl__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MBoolExpr_Impl__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMBoolExpr_ImplAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMBoolExpr_Impl"


    // $ANTLR start "entryRuleValue"
    // InternalWorkflow.g:303:1: entryRuleValue : ruleValue EOF ;
    public final void entryRuleValue() throws RecognitionException {
        try {
            // InternalWorkflow.g:304:1: ( ruleValue EOF )
            // InternalWorkflow.g:305:1: ruleValue EOF
            {
             before(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_1);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // InternalWorkflow.g:312:1: ruleValue : ( ( rule__Value__Group__0 ) ) ;
    public final void ruleValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:316:2: ( ( ( rule__Value__Group__0 ) ) )
            // InternalWorkflow.g:317:2: ( ( rule__Value__Group__0 ) )
            {
            // InternalWorkflow.g:317:2: ( ( rule__Value__Group__0 ) )
            // InternalWorkflow.g:318:3: ( rule__Value__Group__0 )
            {
             before(grammarAccess.getValueAccess().getGroup()); 
            // InternalWorkflow.g:319:3: ( rule__Value__Group__0 )
            // InternalWorkflow.g:319:4: rule__Value__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Value__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getValueAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleBoolValue"
    // InternalWorkflow.g:328:1: entryRuleBoolValue : ruleBoolValue EOF ;
    public final void entryRuleBoolValue() throws RecognitionException {
        try {
            // InternalWorkflow.g:329:1: ( ruleBoolValue EOF )
            // InternalWorkflow.g:330:1: ruleBoolValue EOF
            {
             before(grammarAccess.getBoolValueRule()); 
            pushFollow(FOLLOW_1);
            ruleBoolValue();

            state._fsp--;

             after(grammarAccess.getBoolValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBoolValue"


    // $ANTLR start "ruleBoolValue"
    // InternalWorkflow.g:337:1: ruleBoolValue : ( ( rule__BoolValue__Group__0 ) ) ;
    public final void ruleBoolValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:341:2: ( ( ( rule__BoolValue__Group__0 ) ) )
            // InternalWorkflow.g:342:2: ( ( rule__BoolValue__Group__0 ) )
            {
            // InternalWorkflow.g:342:2: ( ( rule__BoolValue__Group__0 ) )
            // InternalWorkflow.g:343:3: ( rule__BoolValue__Group__0 )
            {
             before(grammarAccess.getBoolValueAccess().getGroup()); 
            // InternalWorkflow.g:344:3: ( rule__BoolValue__Group__0 )
            // InternalWorkflow.g:344:4: rule__BoolValue__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BoolValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBoolValueAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBoolValue"


    // $ANTLR start "entryRuleBoolComp"
    // InternalWorkflow.g:353:1: entryRuleBoolComp : ruleBoolComp EOF ;
    public final void entryRuleBoolComp() throws RecognitionException {
        try {
            // InternalWorkflow.g:354:1: ( ruleBoolComp EOF )
            // InternalWorkflow.g:355:1: ruleBoolComp EOF
            {
             before(grammarAccess.getBoolCompRule()); 
            pushFollow(FOLLOW_1);
            ruleBoolComp();

            state._fsp--;

             after(grammarAccess.getBoolCompRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBoolComp"


    // $ANTLR start "ruleBoolComp"
    // InternalWorkflow.g:362:1: ruleBoolComp : ( ( rule__BoolComp__Group__0 ) ) ;
    public final void ruleBoolComp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:366:2: ( ( ( rule__BoolComp__Group__0 ) ) )
            // InternalWorkflow.g:367:2: ( ( rule__BoolComp__Group__0 ) )
            {
            // InternalWorkflow.g:367:2: ( ( rule__BoolComp__Group__0 ) )
            // InternalWorkflow.g:368:3: ( rule__BoolComp__Group__0 )
            {
             before(grammarAccess.getBoolCompAccess().getGroup()); 
            // InternalWorkflow.g:369:3: ( rule__BoolComp__Group__0 )
            // InternalWorkflow.g:369:4: rule__BoolComp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BoolComp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBoolCompAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBoolComp"


    // $ANTLR start "entryRuleNot"
    // InternalWorkflow.g:378:1: entryRuleNot : ruleNot EOF ;
    public final void entryRuleNot() throws RecognitionException {
        try {
            // InternalWorkflow.g:379:1: ( ruleNot EOF )
            // InternalWorkflow.g:380:1: ruleNot EOF
            {
             before(grammarAccess.getNotRule()); 
            pushFollow(FOLLOW_1);
            ruleNot();

            state._fsp--;

             after(grammarAccess.getNotRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNot"


    // $ANTLR start "ruleNot"
    // InternalWorkflow.g:387:1: ruleNot : ( ( rule__Not__Group__0 ) ) ;
    public final void ruleNot() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:391:2: ( ( ( rule__Not__Group__0 ) ) )
            // InternalWorkflow.g:392:2: ( ( rule__Not__Group__0 ) )
            {
            // InternalWorkflow.g:392:2: ( ( rule__Not__Group__0 ) )
            // InternalWorkflow.g:393:3: ( rule__Not__Group__0 )
            {
             before(grammarAccess.getNotAccess().getGroup()); 
            // InternalWorkflow.g:394:3: ( rule__Not__Group__0 )
            // InternalWorkflow.g:394:4: rule__Not__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Not__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNotAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNot"


    // $ANTLR start "entryRuleRelComp"
    // InternalWorkflow.g:403:1: entryRuleRelComp : ruleRelComp EOF ;
    public final void entryRuleRelComp() throws RecognitionException {
        try {
            // InternalWorkflow.g:404:1: ( ruleRelComp EOF )
            // InternalWorkflow.g:405:1: ruleRelComp EOF
            {
             before(grammarAccess.getRelCompRule()); 
            pushFollow(FOLLOW_1);
            ruleRelComp();

            state._fsp--;

             after(grammarAccess.getRelCompRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRelComp"


    // $ANTLR start "ruleRelComp"
    // InternalWorkflow.g:412:1: ruleRelComp : ( ( rule__RelComp__Group__0 ) ) ;
    public final void ruleRelComp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:416:2: ( ( ( rule__RelComp__Group__0 ) ) )
            // InternalWorkflow.g:417:2: ( ( rule__RelComp__Group__0 ) )
            {
            // InternalWorkflow.g:417:2: ( ( rule__RelComp__Group__0 ) )
            // InternalWorkflow.g:418:3: ( rule__RelComp__Group__0 )
            {
             before(grammarAccess.getRelCompAccess().getGroup()); 
            // InternalWorkflow.g:419:3: ( rule__RelComp__Group__0 )
            // InternalWorkflow.g:419:4: rule__RelComp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RelComp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRelCompAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRelComp"


    // $ANTLR start "entryRuleAtom"
    // InternalWorkflow.g:428:1: entryRuleAtom : ruleAtom EOF ;
    public final void entryRuleAtom() throws RecognitionException {
        try {
            // InternalWorkflow.g:429:1: ( ruleAtom EOF )
            // InternalWorkflow.g:430:1: ruleAtom EOF
            {
             before(grammarAccess.getAtomRule()); 
            pushFollow(FOLLOW_1);
            ruleAtom();

            state._fsp--;

             after(grammarAccess.getAtomRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAtom"


    // $ANTLR start "ruleAtom"
    // InternalWorkflow.g:437:1: ruleAtom : ( ( rule__Atom__Group__0 ) ) ;
    public final void ruleAtom() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:441:2: ( ( ( rule__Atom__Group__0 ) ) )
            // InternalWorkflow.g:442:2: ( ( rule__Atom__Group__0 ) )
            {
            // InternalWorkflow.g:442:2: ( ( rule__Atom__Group__0 ) )
            // InternalWorkflow.g:443:3: ( rule__Atom__Group__0 )
            {
             before(grammarAccess.getAtomAccess().getGroup()); 
            // InternalWorkflow.g:444:3: ( rule__Atom__Group__0 )
            // InternalWorkflow.g:444:4: rule__Atom__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Atom__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAtomAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAtom"


    // $ANTLR start "entryRuleEInt"
    // InternalWorkflow.g:453:1: entryRuleEInt : ruleEInt EOF ;
    public final void entryRuleEInt() throws RecognitionException {
        try {
            // InternalWorkflow.g:454:1: ( ruleEInt EOF )
            // InternalWorkflow.g:455:1: ruleEInt EOF
            {
             before(grammarAccess.getEIntRule()); 
            pushFollow(FOLLOW_1);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getEIntRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // InternalWorkflow.g:462:1: ruleEInt : ( ( rule__EInt__Group__0 ) ) ;
    public final void ruleEInt() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:466:2: ( ( ( rule__EInt__Group__0 ) ) )
            // InternalWorkflow.g:467:2: ( ( rule__EInt__Group__0 ) )
            {
            // InternalWorkflow.g:467:2: ( ( rule__EInt__Group__0 ) )
            // InternalWorkflow.g:468:3: ( rule__EInt__Group__0 )
            {
             before(grammarAccess.getEIntAccess().getGroup()); 
            // InternalWorkflow.g:469:3: ( rule__EInt__Group__0 )
            // InternalWorkflow.g:469:4: rule__EInt__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EInt__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEIntAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEInt"


    // $ANTLR start "ruleBoolOp"
    // InternalWorkflow.g:478:1: ruleBoolOp : ( ( rule__BoolOp__Alternatives ) ) ;
    public final void ruleBoolOp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:482:1: ( ( ( rule__BoolOp__Alternatives ) ) )
            // InternalWorkflow.g:483:2: ( ( rule__BoolOp__Alternatives ) )
            {
            // InternalWorkflow.g:483:2: ( ( rule__BoolOp__Alternatives ) )
            // InternalWorkflow.g:484:3: ( rule__BoolOp__Alternatives )
            {
             before(grammarAccess.getBoolOpAccess().getAlternatives()); 
            // InternalWorkflow.g:485:3: ( rule__BoolOp__Alternatives )
            // InternalWorkflow.g:485:4: rule__BoolOp__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__BoolOp__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getBoolOpAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBoolOp"


    // $ANTLR start "ruleRelOp"
    // InternalWorkflow.g:494:1: ruleRelOp : ( ( rule__RelOp__Alternatives ) ) ;
    public final void ruleRelOp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:498:1: ( ( ( rule__RelOp__Alternatives ) ) )
            // InternalWorkflow.g:499:2: ( ( rule__RelOp__Alternatives ) )
            {
            // InternalWorkflow.g:499:2: ( ( rule__RelOp__Alternatives ) )
            // InternalWorkflow.g:500:3: ( rule__RelOp__Alternatives )
            {
             before(grammarAccess.getRelOpAccess().getAlternatives()); 
            // InternalWorkflow.g:501:3: ( rule__RelOp__Alternatives )
            // InternalWorkflow.g:501:4: rule__RelOp__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__RelOp__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getRelOpAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRelOp"


    // $ANTLR start "rule__Workflow__Alternatives"
    // InternalWorkflow.g:509:1: rule__Workflow__Alternatives : ( ( ruleSequence ) | ( ruleTask ) | ( ruleLoop ) | ( ruleDecision ) );
    public final void rule__Workflow__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:513:1: ( ( ruleSequence ) | ( ruleTask ) | ( ruleLoop ) | ( ruleDecision ) )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt1=1;
                }
                break;
            case 26:
                {
                alt1=2;
                }
                break;
            case 28:
                {
                alt1=3;
                }
                break;
            case 30:
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
                    // InternalWorkflow.g:514:2: ( ruleSequence )
                    {
                    // InternalWorkflow.g:514:2: ( ruleSequence )
                    // InternalWorkflow.g:515:3: ruleSequence
                    {
                     before(grammarAccess.getWorkflowAccess().getSequenceParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleSequence();

                    state._fsp--;

                     after(grammarAccess.getWorkflowAccess().getSequenceParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:520:2: ( ruleTask )
                    {
                    // InternalWorkflow.g:520:2: ( ruleTask )
                    // InternalWorkflow.g:521:3: ruleTask
                    {
                     before(grammarAccess.getWorkflowAccess().getTaskParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleTask();

                    state._fsp--;

                     after(grammarAccess.getWorkflowAccess().getTaskParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:526:2: ( ruleLoop )
                    {
                    // InternalWorkflow.g:526:2: ( ruleLoop )
                    // InternalWorkflow.g:527:3: ruleLoop
                    {
                     before(grammarAccess.getWorkflowAccess().getLoopParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleLoop();

                    state._fsp--;

                     after(grammarAccess.getWorkflowAccess().getLoopParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalWorkflow.g:532:2: ( ruleDecision )
                    {
                    // InternalWorkflow.g:532:2: ( ruleDecision )
                    // InternalWorkflow.g:533:3: ruleDecision
                    {
                     before(grammarAccess.getWorkflowAccess().getDecisionParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleDecision();

                    state._fsp--;

                     after(grammarAccess.getWorkflowAccess().getDecisionParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Workflow__Alternatives"


    // $ANTLR start "rule__MBoolExpr__Alternatives"
    // InternalWorkflow.g:542:1: rule__MBoolExpr__Alternatives : ( ( ruleMBoolExpr_Impl ) | ( ruleValue ) | ( ruleBoolValue ) | ( ruleBoolComp ) | ( ruleNot ) | ( ruleRelComp ) | ( ruleAtom ) );
    public final void rule__MBoolExpr__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:546:1: ( ( ruleMBoolExpr_Impl ) | ( ruleValue ) | ( ruleBoolValue ) | ( ruleBoolComp ) | ( ruleNot ) | ( ruleRelComp ) | ( ruleAtom ) )
            int alt2=7;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt2=1;
                }
                break;
            case 36:
                {
                alt2=2;
                }
                break;
            case 37:
            case 38:
                {
                alt2=3;
                }
                break;
            case 39:
                {
                alt2=4;
                }
                break;
            case 43:
                {
                alt2=5;
                }
                break;
            case 45:
                {
                alt2=6;
                }
                break;
            case 46:
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
                    // InternalWorkflow.g:547:2: ( ruleMBoolExpr_Impl )
                    {
                    // InternalWorkflow.g:547:2: ( ruleMBoolExpr_Impl )
                    // InternalWorkflow.g:548:3: ruleMBoolExpr_Impl
                    {
                     before(grammarAccess.getMBoolExprAccess().getMBoolExpr_ImplParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleMBoolExpr_Impl();

                    state._fsp--;

                     after(grammarAccess.getMBoolExprAccess().getMBoolExpr_ImplParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:553:2: ( ruleValue )
                    {
                    // InternalWorkflow.g:553:2: ( ruleValue )
                    // InternalWorkflow.g:554:3: ruleValue
                    {
                     before(grammarAccess.getMBoolExprAccess().getValueParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleValue();

                    state._fsp--;

                     after(grammarAccess.getMBoolExprAccess().getValueParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:559:2: ( ruleBoolValue )
                    {
                    // InternalWorkflow.g:559:2: ( ruleBoolValue )
                    // InternalWorkflow.g:560:3: ruleBoolValue
                    {
                     before(grammarAccess.getMBoolExprAccess().getBoolValueParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleBoolValue();

                    state._fsp--;

                     after(grammarAccess.getMBoolExprAccess().getBoolValueParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalWorkflow.g:565:2: ( ruleBoolComp )
                    {
                    // InternalWorkflow.g:565:2: ( ruleBoolComp )
                    // InternalWorkflow.g:566:3: ruleBoolComp
                    {
                     before(grammarAccess.getMBoolExprAccess().getBoolCompParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleBoolComp();

                    state._fsp--;

                     after(grammarAccess.getMBoolExprAccess().getBoolCompParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalWorkflow.g:571:2: ( ruleNot )
                    {
                    // InternalWorkflow.g:571:2: ( ruleNot )
                    // InternalWorkflow.g:572:3: ruleNot
                    {
                     before(grammarAccess.getMBoolExprAccess().getNotParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleNot();

                    state._fsp--;

                     after(grammarAccess.getMBoolExprAccess().getNotParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalWorkflow.g:577:2: ( ruleRelComp )
                    {
                    // InternalWorkflow.g:577:2: ( ruleRelComp )
                    // InternalWorkflow.g:578:3: ruleRelComp
                    {
                     before(grammarAccess.getMBoolExprAccess().getRelCompParserRuleCall_5()); 
                    pushFollow(FOLLOW_2);
                    ruleRelComp();

                    state._fsp--;

                     after(grammarAccess.getMBoolExprAccess().getRelCompParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalWorkflow.g:583:2: ( ruleAtom )
                    {
                    // InternalWorkflow.g:583:2: ( ruleAtom )
                    // InternalWorkflow.g:584:3: ruleAtom
                    {
                     before(grammarAccess.getMBoolExprAccess().getAtomParserRuleCall_6()); 
                    pushFollow(FOLLOW_2);
                    ruleAtom();

                    state._fsp--;

                     after(grammarAccess.getMBoolExprAccess().getAtomParserRuleCall_6()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MBoolExpr__Alternatives"


    // $ANTLR start "rule__EString__Alternatives"
    // InternalWorkflow.g:593:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:597:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_STRING) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_ID) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalWorkflow.g:598:2: ( RULE_STRING )
                    {
                    // InternalWorkflow.g:598:2: ( RULE_STRING )
                    // InternalWorkflow.g:599:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:604:2: ( RULE_ID )
                    {
                    // InternalWorkflow.g:604:2: ( RULE_ID )
                    // InternalWorkflow.g:605:3: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EString__Alternatives"


    // $ANTLR start "rule__BoolOp__Alternatives"
    // InternalWorkflow.g:614:1: rule__BoolOp__Alternatives : ( ( ( 'AND' ) ) | ( ( 'OR' ) ) );
    public final void rule__BoolOp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:618:1: ( ( ( 'AND' ) ) | ( ( 'OR' ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==11) ) {
                alt4=1;
            }
            else if ( (LA4_0==12) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalWorkflow.g:619:2: ( ( 'AND' ) )
                    {
                    // InternalWorkflow.g:619:2: ( ( 'AND' ) )
                    // InternalWorkflow.g:620:3: ( 'AND' )
                    {
                     before(grammarAccess.getBoolOpAccess().getANDEnumLiteralDeclaration_0()); 
                    // InternalWorkflow.g:621:3: ( 'AND' )
                    // InternalWorkflow.g:621:4: 'AND'
                    {
                    match(input,11,FOLLOW_2); 

                    }

                     after(grammarAccess.getBoolOpAccess().getANDEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:625:2: ( ( 'OR' ) )
                    {
                    // InternalWorkflow.g:625:2: ( ( 'OR' ) )
                    // InternalWorkflow.g:626:3: ( 'OR' )
                    {
                     before(grammarAccess.getBoolOpAccess().getOREnumLiteralDeclaration_1()); 
                    // InternalWorkflow.g:627:3: ( 'OR' )
                    // InternalWorkflow.g:627:4: 'OR'
                    {
                    match(input,12,FOLLOW_2); 

                    }

                     after(grammarAccess.getBoolOpAccess().getOREnumLiteralDeclaration_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolOp__Alternatives"


    // $ANTLR start "rule__RelOp__Alternatives"
    // InternalWorkflow.g:635:1: rule__RelOp__Alternatives : ( ( ( 'LESS_THAN' ) ) | ( ( 'GREATER_THAN' ) ) | ( ( 'NOT_EQUAL' ) ) | ( ( 'LESS_EQUAL' ) ) | ( ( 'GREATER_EQUAL' ) ) | ( ( 'EQUAL' ) ) );
    public final void rule__RelOp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:639:1: ( ( ( 'LESS_THAN' ) ) | ( ( 'GREATER_THAN' ) ) | ( ( 'NOT_EQUAL' ) ) | ( ( 'LESS_EQUAL' ) ) | ( ( 'GREATER_EQUAL' ) ) | ( ( 'EQUAL' ) ) )
            int alt5=6;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt5=1;
                }
                break;
            case 14:
                {
                alt5=2;
                }
                break;
            case 15:
                {
                alt5=3;
                }
                break;
            case 16:
                {
                alt5=4;
                }
                break;
            case 17:
                {
                alt5=5;
                }
                break;
            case 18:
                {
                alt5=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalWorkflow.g:640:2: ( ( 'LESS_THAN' ) )
                    {
                    // InternalWorkflow.g:640:2: ( ( 'LESS_THAN' ) )
                    // InternalWorkflow.g:641:3: ( 'LESS_THAN' )
                    {
                     before(grammarAccess.getRelOpAccess().getLESS_THANEnumLiteralDeclaration_0()); 
                    // InternalWorkflow.g:642:3: ( 'LESS_THAN' )
                    // InternalWorkflow.g:642:4: 'LESS_THAN'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getRelOpAccess().getLESS_THANEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:646:2: ( ( 'GREATER_THAN' ) )
                    {
                    // InternalWorkflow.g:646:2: ( ( 'GREATER_THAN' ) )
                    // InternalWorkflow.g:647:3: ( 'GREATER_THAN' )
                    {
                     before(grammarAccess.getRelOpAccess().getGREATER_THANEnumLiteralDeclaration_1()); 
                    // InternalWorkflow.g:648:3: ( 'GREATER_THAN' )
                    // InternalWorkflow.g:648:4: 'GREATER_THAN'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getRelOpAccess().getGREATER_THANEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:652:2: ( ( 'NOT_EQUAL' ) )
                    {
                    // InternalWorkflow.g:652:2: ( ( 'NOT_EQUAL' ) )
                    // InternalWorkflow.g:653:3: ( 'NOT_EQUAL' )
                    {
                     before(grammarAccess.getRelOpAccess().getNOT_EQUALEnumLiteralDeclaration_2()); 
                    // InternalWorkflow.g:654:3: ( 'NOT_EQUAL' )
                    // InternalWorkflow.g:654:4: 'NOT_EQUAL'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getRelOpAccess().getNOT_EQUALEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalWorkflow.g:658:2: ( ( 'LESS_EQUAL' ) )
                    {
                    // InternalWorkflow.g:658:2: ( ( 'LESS_EQUAL' ) )
                    // InternalWorkflow.g:659:3: ( 'LESS_EQUAL' )
                    {
                     before(grammarAccess.getRelOpAccess().getLESS_EQUALEnumLiteralDeclaration_3()); 
                    // InternalWorkflow.g:660:3: ( 'LESS_EQUAL' )
                    // InternalWorkflow.g:660:4: 'LESS_EQUAL'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getRelOpAccess().getLESS_EQUALEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalWorkflow.g:664:2: ( ( 'GREATER_EQUAL' ) )
                    {
                    // InternalWorkflow.g:664:2: ( ( 'GREATER_EQUAL' ) )
                    // InternalWorkflow.g:665:3: ( 'GREATER_EQUAL' )
                    {
                     before(grammarAccess.getRelOpAccess().getGREATER_EQUALEnumLiteralDeclaration_4()); 
                    // InternalWorkflow.g:666:3: ( 'GREATER_EQUAL' )
                    // InternalWorkflow.g:666:4: 'GREATER_EQUAL'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getRelOpAccess().getGREATER_EQUALEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalWorkflow.g:670:2: ( ( 'EQUAL' ) )
                    {
                    // InternalWorkflow.g:670:2: ( ( 'EQUAL' ) )
                    // InternalWorkflow.g:671:3: ( 'EQUAL' )
                    {
                     before(grammarAccess.getRelOpAccess().getEQUALEnumLiteralDeclaration_5()); 
                    // InternalWorkflow.g:672:3: ( 'EQUAL' )
                    // InternalWorkflow.g:672:4: 'EQUAL'
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getRelOpAccess().getEQUALEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelOp__Alternatives"


    // $ANTLR start "rule__WorkflowStructure__Group__0"
    // InternalWorkflow.g:680:1: rule__WorkflowStructure__Group__0 : rule__WorkflowStructure__Group__0__Impl rule__WorkflowStructure__Group__1 ;
    public final void rule__WorkflowStructure__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:684:1: ( rule__WorkflowStructure__Group__0__Impl rule__WorkflowStructure__Group__1 )
            // InternalWorkflow.g:685:2: rule__WorkflowStructure__Group__0__Impl rule__WorkflowStructure__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__WorkflowStructure__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WorkflowStructure__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkflowStructure__Group__0"


    // $ANTLR start "rule__WorkflowStructure__Group__0__Impl"
    // InternalWorkflow.g:692:1: rule__WorkflowStructure__Group__0__Impl : ( 'WorkflowStructure' ) ;
    public final void rule__WorkflowStructure__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:696:1: ( ( 'WorkflowStructure' ) )
            // InternalWorkflow.g:697:1: ( 'WorkflowStructure' )
            {
            // InternalWorkflow.g:697:1: ( 'WorkflowStructure' )
            // InternalWorkflow.g:698:2: 'WorkflowStructure'
            {
             before(grammarAccess.getWorkflowStructureAccess().getWorkflowStructureKeyword_0()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getWorkflowStructureAccess().getWorkflowStructureKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkflowStructure__Group__0__Impl"


    // $ANTLR start "rule__WorkflowStructure__Group__1"
    // InternalWorkflow.g:707:1: rule__WorkflowStructure__Group__1 : rule__WorkflowStructure__Group__1__Impl rule__WorkflowStructure__Group__2 ;
    public final void rule__WorkflowStructure__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:711:1: ( rule__WorkflowStructure__Group__1__Impl rule__WorkflowStructure__Group__2 )
            // InternalWorkflow.g:712:2: rule__WorkflowStructure__Group__1__Impl rule__WorkflowStructure__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__WorkflowStructure__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WorkflowStructure__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkflowStructure__Group__1"


    // $ANTLR start "rule__WorkflowStructure__Group__1__Impl"
    // InternalWorkflow.g:719:1: rule__WorkflowStructure__Group__1__Impl : ( '{' ) ;
    public final void rule__WorkflowStructure__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:723:1: ( ( '{' ) )
            // InternalWorkflow.g:724:1: ( '{' )
            {
            // InternalWorkflow.g:724:1: ( '{' )
            // InternalWorkflow.g:725:2: '{'
            {
             before(grammarAccess.getWorkflowStructureAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getWorkflowStructureAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkflowStructure__Group__1__Impl"


    // $ANTLR start "rule__WorkflowStructure__Group__2"
    // InternalWorkflow.g:734:1: rule__WorkflowStructure__Group__2 : rule__WorkflowStructure__Group__2__Impl rule__WorkflowStructure__Group__3 ;
    public final void rule__WorkflowStructure__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:738:1: ( rule__WorkflowStructure__Group__2__Impl rule__WorkflowStructure__Group__3 )
            // InternalWorkflow.g:739:2: rule__WorkflowStructure__Group__2__Impl rule__WorkflowStructure__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__WorkflowStructure__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WorkflowStructure__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkflowStructure__Group__2"


    // $ANTLR start "rule__WorkflowStructure__Group__2__Impl"
    // InternalWorkflow.g:746:1: rule__WorkflowStructure__Group__2__Impl : ( 'workflowspec' ) ;
    public final void rule__WorkflowStructure__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:750:1: ( ( 'workflowspec' ) )
            // InternalWorkflow.g:751:1: ( 'workflowspec' )
            {
            // InternalWorkflow.g:751:1: ( 'workflowspec' )
            // InternalWorkflow.g:752:2: 'workflowspec'
            {
             before(grammarAccess.getWorkflowStructureAccess().getWorkflowspecKeyword_2()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getWorkflowStructureAccess().getWorkflowspecKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkflowStructure__Group__2__Impl"


    // $ANTLR start "rule__WorkflowStructure__Group__3"
    // InternalWorkflow.g:761:1: rule__WorkflowStructure__Group__3 : rule__WorkflowStructure__Group__3__Impl rule__WorkflowStructure__Group__4 ;
    public final void rule__WorkflowStructure__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:765:1: ( rule__WorkflowStructure__Group__3__Impl rule__WorkflowStructure__Group__4 )
            // InternalWorkflow.g:766:2: rule__WorkflowStructure__Group__3__Impl rule__WorkflowStructure__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__WorkflowStructure__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WorkflowStructure__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkflowStructure__Group__3"


    // $ANTLR start "rule__WorkflowStructure__Group__3__Impl"
    // InternalWorkflow.g:773:1: rule__WorkflowStructure__Group__3__Impl : ( ( rule__WorkflowStructure__WorkflowspecAssignment_3 ) ) ;
    public final void rule__WorkflowStructure__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:777:1: ( ( ( rule__WorkflowStructure__WorkflowspecAssignment_3 ) ) )
            // InternalWorkflow.g:778:1: ( ( rule__WorkflowStructure__WorkflowspecAssignment_3 ) )
            {
            // InternalWorkflow.g:778:1: ( ( rule__WorkflowStructure__WorkflowspecAssignment_3 ) )
            // InternalWorkflow.g:779:2: ( rule__WorkflowStructure__WorkflowspecAssignment_3 )
            {
             before(grammarAccess.getWorkflowStructureAccess().getWorkflowspecAssignment_3()); 
            // InternalWorkflow.g:780:2: ( rule__WorkflowStructure__WorkflowspecAssignment_3 )
            // InternalWorkflow.g:780:3: rule__WorkflowStructure__WorkflowspecAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__WorkflowStructure__WorkflowspecAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getWorkflowStructureAccess().getWorkflowspecAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkflowStructure__Group__3__Impl"


    // $ANTLR start "rule__WorkflowStructure__Group__4"
    // InternalWorkflow.g:788:1: rule__WorkflowStructure__Group__4 : rule__WorkflowStructure__Group__4__Impl ;
    public final void rule__WorkflowStructure__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:792:1: ( rule__WorkflowStructure__Group__4__Impl )
            // InternalWorkflow.g:793:2: rule__WorkflowStructure__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__WorkflowStructure__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkflowStructure__Group__4"


    // $ANTLR start "rule__WorkflowStructure__Group__4__Impl"
    // InternalWorkflow.g:799:1: rule__WorkflowStructure__Group__4__Impl : ( '}' ) ;
    public final void rule__WorkflowStructure__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:803:1: ( ( '}' ) )
            // InternalWorkflow.g:804:1: ( '}' )
            {
            // InternalWorkflow.g:804:1: ( '}' )
            // InternalWorkflow.g:805:2: '}'
            {
             before(grammarAccess.getWorkflowStructureAccess().getRightCurlyBracketKeyword_4()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getWorkflowStructureAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkflowStructure__Group__4__Impl"


    // $ANTLR start "rule__Sequence__Group__0"
    // InternalWorkflow.g:815:1: rule__Sequence__Group__0 : rule__Sequence__Group__0__Impl rule__Sequence__Group__1 ;
    public final void rule__Sequence__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:819:1: ( rule__Sequence__Group__0__Impl rule__Sequence__Group__1 )
            // InternalWorkflow.g:820:2: rule__Sequence__Group__0__Impl rule__Sequence__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Sequence__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sequence__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__0"


    // $ANTLR start "rule__Sequence__Group__0__Impl"
    // InternalWorkflow.g:827:1: rule__Sequence__Group__0__Impl : ( 'Sequence' ) ;
    public final void rule__Sequence__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:831:1: ( ( 'Sequence' ) )
            // InternalWorkflow.g:832:1: ( 'Sequence' )
            {
            // InternalWorkflow.g:832:1: ( 'Sequence' )
            // InternalWorkflow.g:833:2: 'Sequence'
            {
             before(grammarAccess.getSequenceAccess().getSequenceKeyword_0()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getSequenceAccess().getSequenceKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__0__Impl"


    // $ANTLR start "rule__Sequence__Group__1"
    // InternalWorkflow.g:842:1: rule__Sequence__Group__1 : rule__Sequence__Group__1__Impl rule__Sequence__Group__2 ;
    public final void rule__Sequence__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:846:1: ( rule__Sequence__Group__1__Impl rule__Sequence__Group__2 )
            // InternalWorkflow.g:847:2: rule__Sequence__Group__1__Impl rule__Sequence__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__Sequence__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sequence__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__1"


    // $ANTLR start "rule__Sequence__Group__1__Impl"
    // InternalWorkflow.g:854:1: rule__Sequence__Group__1__Impl : ( '{' ) ;
    public final void rule__Sequence__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:858:1: ( ( '{' ) )
            // InternalWorkflow.g:859:1: ( '{' )
            {
            // InternalWorkflow.g:859:1: ( '{' )
            // InternalWorkflow.g:860:2: '{'
            {
             before(grammarAccess.getSequenceAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getSequenceAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__1__Impl"


    // $ANTLR start "rule__Sequence__Group__2"
    // InternalWorkflow.g:869:1: rule__Sequence__Group__2 : rule__Sequence__Group__2__Impl rule__Sequence__Group__3 ;
    public final void rule__Sequence__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:873:1: ( rule__Sequence__Group__2__Impl rule__Sequence__Group__3 )
            // InternalWorkflow.g:874:2: rule__Sequence__Group__2__Impl rule__Sequence__Group__3
            {
            pushFollow(FOLLOW_3);
            rule__Sequence__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sequence__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__2"


    // $ANTLR start "rule__Sequence__Group__2__Impl"
    // InternalWorkflow.g:881:1: rule__Sequence__Group__2__Impl : ( 'subworkflows' ) ;
    public final void rule__Sequence__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:885:1: ( ( 'subworkflows' ) )
            // InternalWorkflow.g:886:1: ( 'subworkflows' )
            {
            // InternalWorkflow.g:886:1: ( 'subworkflows' )
            // InternalWorkflow.g:887:2: 'subworkflows'
            {
             before(grammarAccess.getSequenceAccess().getSubworkflowsKeyword_2()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getSequenceAccess().getSubworkflowsKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__2__Impl"


    // $ANTLR start "rule__Sequence__Group__3"
    // InternalWorkflow.g:896:1: rule__Sequence__Group__3 : rule__Sequence__Group__3__Impl rule__Sequence__Group__4 ;
    public final void rule__Sequence__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:900:1: ( rule__Sequence__Group__3__Impl rule__Sequence__Group__4 )
            // InternalWorkflow.g:901:2: rule__Sequence__Group__3__Impl rule__Sequence__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__Sequence__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sequence__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__3"


    // $ANTLR start "rule__Sequence__Group__3__Impl"
    // InternalWorkflow.g:908:1: rule__Sequence__Group__3__Impl : ( '{' ) ;
    public final void rule__Sequence__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:912:1: ( ( '{' ) )
            // InternalWorkflow.g:913:1: ( '{' )
            {
            // InternalWorkflow.g:913:1: ( '{' )
            // InternalWorkflow.g:914:2: '{'
            {
             before(grammarAccess.getSequenceAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getSequenceAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__3__Impl"


    // $ANTLR start "rule__Sequence__Group__4"
    // InternalWorkflow.g:923:1: rule__Sequence__Group__4 : rule__Sequence__Group__4__Impl rule__Sequence__Group__5 ;
    public final void rule__Sequence__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:927:1: ( rule__Sequence__Group__4__Impl rule__Sequence__Group__5 )
            // InternalWorkflow.g:928:2: rule__Sequence__Group__4__Impl rule__Sequence__Group__5
            {
            pushFollow(FOLLOW_8);
            rule__Sequence__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sequence__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__4"


    // $ANTLR start "rule__Sequence__Group__4__Impl"
    // InternalWorkflow.g:935:1: rule__Sequence__Group__4__Impl : ( ( rule__Sequence__SubworkflowsAssignment_4 ) ) ;
    public final void rule__Sequence__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:939:1: ( ( ( rule__Sequence__SubworkflowsAssignment_4 ) ) )
            // InternalWorkflow.g:940:1: ( ( rule__Sequence__SubworkflowsAssignment_4 ) )
            {
            // InternalWorkflow.g:940:1: ( ( rule__Sequence__SubworkflowsAssignment_4 ) )
            // InternalWorkflow.g:941:2: ( rule__Sequence__SubworkflowsAssignment_4 )
            {
             before(grammarAccess.getSequenceAccess().getSubworkflowsAssignment_4()); 
            // InternalWorkflow.g:942:2: ( rule__Sequence__SubworkflowsAssignment_4 )
            // InternalWorkflow.g:942:3: rule__Sequence__SubworkflowsAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Sequence__SubworkflowsAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getSequenceAccess().getSubworkflowsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__4__Impl"


    // $ANTLR start "rule__Sequence__Group__5"
    // InternalWorkflow.g:950:1: rule__Sequence__Group__5 : rule__Sequence__Group__5__Impl rule__Sequence__Group__6 ;
    public final void rule__Sequence__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:954:1: ( rule__Sequence__Group__5__Impl rule__Sequence__Group__6 )
            // InternalWorkflow.g:955:2: rule__Sequence__Group__5__Impl rule__Sequence__Group__6
            {
            pushFollow(FOLLOW_8);
            rule__Sequence__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sequence__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__5"


    // $ANTLR start "rule__Sequence__Group__5__Impl"
    // InternalWorkflow.g:962:1: rule__Sequence__Group__5__Impl : ( ( rule__Sequence__Group_5__0 )* ) ;
    public final void rule__Sequence__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:966:1: ( ( ( rule__Sequence__Group_5__0 )* ) )
            // InternalWorkflow.g:967:1: ( ( rule__Sequence__Group_5__0 )* )
            {
            // InternalWorkflow.g:967:1: ( ( rule__Sequence__Group_5__0 )* )
            // InternalWorkflow.g:968:2: ( rule__Sequence__Group_5__0 )*
            {
             before(grammarAccess.getSequenceAccess().getGroup_5()); 
            // InternalWorkflow.g:969:2: ( rule__Sequence__Group_5__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==25) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalWorkflow.g:969:3: rule__Sequence__Group_5__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Sequence__Group_5__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getSequenceAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__5__Impl"


    // $ANTLR start "rule__Sequence__Group__6"
    // InternalWorkflow.g:977:1: rule__Sequence__Group__6 : rule__Sequence__Group__6__Impl rule__Sequence__Group__7 ;
    public final void rule__Sequence__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:981:1: ( rule__Sequence__Group__6__Impl rule__Sequence__Group__7 )
            // InternalWorkflow.g:982:2: rule__Sequence__Group__6__Impl rule__Sequence__Group__7
            {
            pushFollow(FOLLOW_6);
            rule__Sequence__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sequence__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__6"


    // $ANTLR start "rule__Sequence__Group__6__Impl"
    // InternalWorkflow.g:989:1: rule__Sequence__Group__6__Impl : ( '}' ) ;
    public final void rule__Sequence__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:993:1: ( ( '}' ) )
            // InternalWorkflow.g:994:1: ( '}' )
            {
            // InternalWorkflow.g:994:1: ( '}' )
            // InternalWorkflow.g:995:2: '}'
            {
             before(grammarAccess.getSequenceAccess().getRightCurlyBracketKeyword_6()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getSequenceAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__6__Impl"


    // $ANTLR start "rule__Sequence__Group__7"
    // InternalWorkflow.g:1004:1: rule__Sequence__Group__7 : rule__Sequence__Group__7__Impl ;
    public final void rule__Sequence__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1008:1: ( rule__Sequence__Group__7__Impl )
            // InternalWorkflow.g:1009:2: rule__Sequence__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Sequence__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__7"


    // $ANTLR start "rule__Sequence__Group__7__Impl"
    // InternalWorkflow.g:1015:1: rule__Sequence__Group__7__Impl : ( '}' ) ;
    public final void rule__Sequence__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1019:1: ( ( '}' ) )
            // InternalWorkflow.g:1020:1: ( '}' )
            {
            // InternalWorkflow.g:1020:1: ( '}' )
            // InternalWorkflow.g:1021:2: '}'
            {
             before(grammarAccess.getSequenceAccess().getRightCurlyBracketKeyword_7()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getSequenceAccess().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__7__Impl"


    // $ANTLR start "rule__Sequence__Group_5__0"
    // InternalWorkflow.g:1031:1: rule__Sequence__Group_5__0 : rule__Sequence__Group_5__0__Impl rule__Sequence__Group_5__1 ;
    public final void rule__Sequence__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1035:1: ( rule__Sequence__Group_5__0__Impl rule__Sequence__Group_5__1 )
            // InternalWorkflow.g:1036:2: rule__Sequence__Group_5__0__Impl rule__Sequence__Group_5__1
            {
            pushFollow(FOLLOW_5);
            rule__Sequence__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sequence__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_5__0"


    // $ANTLR start "rule__Sequence__Group_5__0__Impl"
    // InternalWorkflow.g:1043:1: rule__Sequence__Group_5__0__Impl : ( ',' ) ;
    public final void rule__Sequence__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1047:1: ( ( ',' ) )
            // InternalWorkflow.g:1048:1: ( ',' )
            {
            // InternalWorkflow.g:1048:1: ( ',' )
            // InternalWorkflow.g:1049:2: ','
            {
             before(grammarAccess.getSequenceAccess().getCommaKeyword_5_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getSequenceAccess().getCommaKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_5__0__Impl"


    // $ANTLR start "rule__Sequence__Group_5__1"
    // InternalWorkflow.g:1058:1: rule__Sequence__Group_5__1 : rule__Sequence__Group_5__1__Impl ;
    public final void rule__Sequence__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1062:1: ( rule__Sequence__Group_5__1__Impl )
            // InternalWorkflow.g:1063:2: rule__Sequence__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Sequence__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_5__1"


    // $ANTLR start "rule__Sequence__Group_5__1__Impl"
    // InternalWorkflow.g:1069:1: rule__Sequence__Group_5__1__Impl : ( ( rule__Sequence__SubworkflowsAssignment_5_1 ) ) ;
    public final void rule__Sequence__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1073:1: ( ( ( rule__Sequence__SubworkflowsAssignment_5_1 ) ) )
            // InternalWorkflow.g:1074:1: ( ( rule__Sequence__SubworkflowsAssignment_5_1 ) )
            {
            // InternalWorkflow.g:1074:1: ( ( rule__Sequence__SubworkflowsAssignment_5_1 ) )
            // InternalWorkflow.g:1075:2: ( rule__Sequence__SubworkflowsAssignment_5_1 )
            {
             before(grammarAccess.getSequenceAccess().getSubworkflowsAssignment_5_1()); 
            // InternalWorkflow.g:1076:2: ( rule__Sequence__SubworkflowsAssignment_5_1 )
            // InternalWorkflow.g:1076:3: rule__Sequence__SubworkflowsAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__Sequence__SubworkflowsAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getSequenceAccess().getSubworkflowsAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_5__1__Impl"


    // $ANTLR start "rule__Task__Group__0"
    // InternalWorkflow.g:1085:1: rule__Task__Group__0 : rule__Task__Group__0__Impl rule__Task__Group__1 ;
    public final void rule__Task__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1089:1: ( rule__Task__Group__0__Impl rule__Task__Group__1 )
            // InternalWorkflow.g:1090:2: rule__Task__Group__0__Impl rule__Task__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Task__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Task__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group__0"


    // $ANTLR start "rule__Task__Group__0__Impl"
    // InternalWorkflow.g:1097:1: rule__Task__Group__0__Impl : ( 'Task' ) ;
    public final void rule__Task__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1101:1: ( ( 'Task' ) )
            // InternalWorkflow.g:1102:1: ( 'Task' )
            {
            // InternalWorkflow.g:1102:1: ( 'Task' )
            // InternalWorkflow.g:1103:2: 'Task'
            {
             before(grammarAccess.getTaskAccess().getTaskKeyword_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getTaskAccess().getTaskKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group__0__Impl"


    // $ANTLR start "rule__Task__Group__1"
    // InternalWorkflow.g:1112:1: rule__Task__Group__1 : rule__Task__Group__1__Impl rule__Task__Group__2 ;
    public final void rule__Task__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1116:1: ( rule__Task__Group__1__Impl rule__Task__Group__2 )
            // InternalWorkflow.g:1117:2: rule__Task__Group__1__Impl rule__Task__Group__2
            {
            pushFollow(FOLLOW_10);
            rule__Task__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Task__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group__1"


    // $ANTLR start "rule__Task__Group__1__Impl"
    // InternalWorkflow.g:1124:1: rule__Task__Group__1__Impl : ( '{' ) ;
    public final void rule__Task__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1128:1: ( ( '{' ) )
            // InternalWorkflow.g:1129:1: ( '{' )
            {
            // InternalWorkflow.g:1129:1: ( '{' )
            // InternalWorkflow.g:1130:2: '{'
            {
             before(grammarAccess.getTaskAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getTaskAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group__1__Impl"


    // $ANTLR start "rule__Task__Group__2"
    // InternalWorkflow.g:1139:1: rule__Task__Group__2 : rule__Task__Group__2__Impl rule__Task__Group__3 ;
    public final void rule__Task__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1143:1: ( rule__Task__Group__2__Impl rule__Task__Group__3 )
            // InternalWorkflow.g:1144:2: rule__Task__Group__2__Impl rule__Task__Group__3
            {
            pushFollow(FOLLOW_11);
            rule__Task__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Task__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group__2"


    // $ANTLR start "rule__Task__Group__2__Impl"
    // InternalWorkflow.g:1151:1: rule__Task__Group__2__Impl : ( 'ID' ) ;
    public final void rule__Task__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1155:1: ( ( 'ID' ) )
            // InternalWorkflow.g:1156:1: ( 'ID' )
            {
            // InternalWorkflow.g:1156:1: ( 'ID' )
            // InternalWorkflow.g:1157:2: 'ID'
            {
             before(grammarAccess.getTaskAccess().getIDKeyword_2()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getTaskAccess().getIDKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group__2__Impl"


    // $ANTLR start "rule__Task__Group__3"
    // InternalWorkflow.g:1166:1: rule__Task__Group__3 : rule__Task__Group__3__Impl rule__Task__Group__4 ;
    public final void rule__Task__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1170:1: ( rule__Task__Group__3__Impl rule__Task__Group__4 )
            // InternalWorkflow.g:1171:2: rule__Task__Group__3__Impl rule__Task__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__Task__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Task__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group__3"


    // $ANTLR start "rule__Task__Group__3__Impl"
    // InternalWorkflow.g:1178:1: rule__Task__Group__3__Impl : ( ( rule__Task__IDAssignment_3 ) ) ;
    public final void rule__Task__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1182:1: ( ( ( rule__Task__IDAssignment_3 ) ) )
            // InternalWorkflow.g:1183:1: ( ( rule__Task__IDAssignment_3 ) )
            {
            // InternalWorkflow.g:1183:1: ( ( rule__Task__IDAssignment_3 ) )
            // InternalWorkflow.g:1184:2: ( rule__Task__IDAssignment_3 )
            {
             before(grammarAccess.getTaskAccess().getIDAssignment_3()); 
            // InternalWorkflow.g:1185:2: ( rule__Task__IDAssignment_3 )
            // InternalWorkflow.g:1185:3: rule__Task__IDAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Task__IDAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getTaskAccess().getIDAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group__3__Impl"


    // $ANTLR start "rule__Task__Group__4"
    // InternalWorkflow.g:1193:1: rule__Task__Group__4 : rule__Task__Group__4__Impl ;
    public final void rule__Task__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1197:1: ( rule__Task__Group__4__Impl )
            // InternalWorkflow.g:1198:2: rule__Task__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Task__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group__4"


    // $ANTLR start "rule__Task__Group__4__Impl"
    // InternalWorkflow.g:1204:1: rule__Task__Group__4__Impl : ( '}' ) ;
    public final void rule__Task__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1208:1: ( ( '}' ) )
            // InternalWorkflow.g:1209:1: ( '}' )
            {
            // InternalWorkflow.g:1209:1: ( '}' )
            // InternalWorkflow.g:1210:2: '}'
            {
             before(grammarAccess.getTaskAccess().getRightCurlyBracketKeyword_4()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getTaskAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group__4__Impl"


    // $ANTLR start "rule__Loop__Group__0"
    // InternalWorkflow.g:1220:1: rule__Loop__Group__0 : rule__Loop__Group__0__Impl rule__Loop__Group__1 ;
    public final void rule__Loop__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1224:1: ( rule__Loop__Group__0__Impl rule__Loop__Group__1 )
            // InternalWorkflow.g:1225:2: rule__Loop__Group__0__Impl rule__Loop__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Loop__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__0"


    // $ANTLR start "rule__Loop__Group__0__Impl"
    // InternalWorkflow.g:1232:1: rule__Loop__Group__0__Impl : ( 'Loop' ) ;
    public final void rule__Loop__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1236:1: ( ( 'Loop' ) )
            // InternalWorkflow.g:1237:1: ( 'Loop' )
            {
            // InternalWorkflow.g:1237:1: ( 'Loop' )
            // InternalWorkflow.g:1238:2: 'Loop'
            {
             before(grammarAccess.getLoopAccess().getLoopKeyword_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getLoopAccess().getLoopKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__0__Impl"


    // $ANTLR start "rule__Loop__Group__1"
    // InternalWorkflow.g:1247:1: rule__Loop__Group__1 : rule__Loop__Group__1__Impl rule__Loop__Group__2 ;
    public final void rule__Loop__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1251:1: ( rule__Loop__Group__1__Impl rule__Loop__Group__2 )
            // InternalWorkflow.g:1252:2: rule__Loop__Group__1__Impl rule__Loop__Group__2
            {
            pushFollow(FOLLOW_12);
            rule__Loop__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__1"


    // $ANTLR start "rule__Loop__Group__1__Impl"
    // InternalWorkflow.g:1259:1: rule__Loop__Group__1__Impl : ( '{' ) ;
    public final void rule__Loop__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1263:1: ( ( '{' ) )
            // InternalWorkflow.g:1264:1: ( '{' )
            {
            // InternalWorkflow.g:1264:1: ( '{' )
            // InternalWorkflow.g:1265:2: '{'
            {
             before(grammarAccess.getLoopAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getLoopAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__1__Impl"


    // $ANTLR start "rule__Loop__Group__2"
    // InternalWorkflow.g:1274:1: rule__Loop__Group__2 : rule__Loop__Group__2__Impl rule__Loop__Group__3 ;
    public final void rule__Loop__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1278:1: ( rule__Loop__Group__2__Impl rule__Loop__Group__3 )
            // InternalWorkflow.g:1279:2: rule__Loop__Group__2__Impl rule__Loop__Group__3
            {
            pushFollow(FOLLOW_13);
            rule__Loop__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__2"


    // $ANTLR start "rule__Loop__Group__2__Impl"
    // InternalWorkflow.g:1286:1: rule__Loop__Group__2__Impl : ( 'loop' ) ;
    public final void rule__Loop__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1290:1: ( ( 'loop' ) )
            // InternalWorkflow.g:1291:1: ( 'loop' )
            {
            // InternalWorkflow.g:1291:1: ( 'loop' )
            // InternalWorkflow.g:1292:2: 'loop'
            {
             before(grammarAccess.getLoopAccess().getLoopKeyword_2()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getLoopAccess().getLoopKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__2__Impl"


    // $ANTLR start "rule__Loop__Group__3"
    // InternalWorkflow.g:1301:1: rule__Loop__Group__3 : rule__Loop__Group__3__Impl rule__Loop__Group__4 ;
    public final void rule__Loop__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1305:1: ( rule__Loop__Group__3__Impl rule__Loop__Group__4 )
            // InternalWorkflow.g:1306:2: rule__Loop__Group__3__Impl rule__Loop__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__Loop__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__3"


    // $ANTLR start "rule__Loop__Group__3__Impl"
    // InternalWorkflow.g:1313:1: rule__Loop__Group__3__Impl : ( ( rule__Loop__LoopAssignment_3 ) ) ;
    public final void rule__Loop__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1317:1: ( ( ( rule__Loop__LoopAssignment_3 ) ) )
            // InternalWorkflow.g:1318:1: ( ( rule__Loop__LoopAssignment_3 ) )
            {
            // InternalWorkflow.g:1318:1: ( ( rule__Loop__LoopAssignment_3 ) )
            // InternalWorkflow.g:1319:2: ( rule__Loop__LoopAssignment_3 )
            {
             before(grammarAccess.getLoopAccess().getLoopAssignment_3()); 
            // InternalWorkflow.g:1320:2: ( rule__Loop__LoopAssignment_3 )
            // InternalWorkflow.g:1320:3: rule__Loop__LoopAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Loop__LoopAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getLoopAccess().getLoopAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__3__Impl"


    // $ANTLR start "rule__Loop__Group__4"
    // InternalWorkflow.g:1328:1: rule__Loop__Group__4 : rule__Loop__Group__4__Impl ;
    public final void rule__Loop__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1332:1: ( rule__Loop__Group__4__Impl )
            // InternalWorkflow.g:1333:2: rule__Loop__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Loop__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__4"


    // $ANTLR start "rule__Loop__Group__4__Impl"
    // InternalWorkflow.g:1339:1: rule__Loop__Group__4__Impl : ( '}' ) ;
    public final void rule__Loop__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1343:1: ( ( '}' ) )
            // InternalWorkflow.g:1344:1: ( '}' )
            {
            // InternalWorkflow.g:1344:1: ( '}' )
            // InternalWorkflow.g:1345:2: '}'
            {
             before(grammarAccess.getLoopAccess().getRightCurlyBracketKeyword_4()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getLoopAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__4__Impl"


    // $ANTLR start "rule__Decision__Group__0"
    // InternalWorkflow.g:1355:1: rule__Decision__Group__0 : rule__Decision__Group__0__Impl rule__Decision__Group__1 ;
    public final void rule__Decision__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1359:1: ( rule__Decision__Group__0__Impl rule__Decision__Group__1 )
            // InternalWorkflow.g:1360:2: rule__Decision__Group__0__Impl rule__Decision__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Decision__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Decision__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decision__Group__0"


    // $ANTLR start "rule__Decision__Group__0__Impl"
    // InternalWorkflow.g:1367:1: rule__Decision__Group__0__Impl : ( 'Decision' ) ;
    public final void rule__Decision__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1371:1: ( ( 'Decision' ) )
            // InternalWorkflow.g:1372:1: ( 'Decision' )
            {
            // InternalWorkflow.g:1372:1: ( 'Decision' )
            // InternalWorkflow.g:1373:2: 'Decision'
            {
             before(grammarAccess.getDecisionAccess().getDecisionKeyword_0()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getDecisionAccess().getDecisionKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decision__Group__0__Impl"


    // $ANTLR start "rule__Decision__Group__1"
    // InternalWorkflow.g:1382:1: rule__Decision__Group__1 : rule__Decision__Group__1__Impl rule__Decision__Group__2 ;
    public final void rule__Decision__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1386:1: ( rule__Decision__Group__1__Impl rule__Decision__Group__2 )
            // InternalWorkflow.g:1387:2: rule__Decision__Group__1__Impl rule__Decision__Group__2
            {
            pushFollow(FOLLOW_14);
            rule__Decision__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Decision__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decision__Group__1"


    // $ANTLR start "rule__Decision__Group__1__Impl"
    // InternalWorkflow.g:1394:1: rule__Decision__Group__1__Impl : ( '{' ) ;
    public final void rule__Decision__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1398:1: ( ( '{' ) )
            // InternalWorkflow.g:1399:1: ( '{' )
            {
            // InternalWorkflow.g:1399:1: ( '{' )
            // InternalWorkflow.g:1400:2: '{'
            {
             before(grammarAccess.getDecisionAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getDecisionAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decision__Group__1__Impl"


    // $ANTLR start "rule__Decision__Group__2"
    // InternalWorkflow.g:1409:1: rule__Decision__Group__2 : rule__Decision__Group__2__Impl rule__Decision__Group__3 ;
    public final void rule__Decision__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1413:1: ( rule__Decision__Group__2__Impl rule__Decision__Group__3 )
            // InternalWorkflow.g:1414:2: rule__Decision__Group__2__Impl rule__Decision__Group__3
            {
            pushFollow(FOLLOW_3);
            rule__Decision__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Decision__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decision__Group__2"


    // $ANTLR start "rule__Decision__Group__2__Impl"
    // InternalWorkflow.g:1421:1: rule__Decision__Group__2__Impl : ( 'options' ) ;
    public final void rule__Decision__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1425:1: ( ( 'options' ) )
            // InternalWorkflow.g:1426:1: ( 'options' )
            {
            // InternalWorkflow.g:1426:1: ( 'options' )
            // InternalWorkflow.g:1427:2: 'options'
            {
             before(grammarAccess.getDecisionAccess().getOptionsKeyword_2()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getDecisionAccess().getOptionsKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decision__Group__2__Impl"


    // $ANTLR start "rule__Decision__Group__3"
    // InternalWorkflow.g:1436:1: rule__Decision__Group__3 : rule__Decision__Group__3__Impl rule__Decision__Group__4 ;
    public final void rule__Decision__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1440:1: ( rule__Decision__Group__3__Impl rule__Decision__Group__4 )
            // InternalWorkflow.g:1441:2: rule__Decision__Group__3__Impl rule__Decision__Group__4
            {
            pushFollow(FOLLOW_13);
            rule__Decision__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Decision__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decision__Group__3"


    // $ANTLR start "rule__Decision__Group__3__Impl"
    // InternalWorkflow.g:1448:1: rule__Decision__Group__3__Impl : ( '{' ) ;
    public final void rule__Decision__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1452:1: ( ( '{' ) )
            // InternalWorkflow.g:1453:1: ( '{' )
            {
            // InternalWorkflow.g:1453:1: ( '{' )
            // InternalWorkflow.g:1454:2: '{'
            {
             before(grammarAccess.getDecisionAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getDecisionAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decision__Group__3__Impl"


    // $ANTLR start "rule__Decision__Group__4"
    // InternalWorkflow.g:1463:1: rule__Decision__Group__4 : rule__Decision__Group__4__Impl rule__Decision__Group__5 ;
    public final void rule__Decision__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1467:1: ( rule__Decision__Group__4__Impl rule__Decision__Group__5 )
            // InternalWorkflow.g:1468:2: rule__Decision__Group__4__Impl rule__Decision__Group__5
            {
            pushFollow(FOLLOW_8);
            rule__Decision__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Decision__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decision__Group__4"


    // $ANTLR start "rule__Decision__Group__4__Impl"
    // InternalWorkflow.g:1475:1: rule__Decision__Group__4__Impl : ( ( rule__Decision__OptionsAssignment_4 ) ) ;
    public final void rule__Decision__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1479:1: ( ( ( rule__Decision__OptionsAssignment_4 ) ) )
            // InternalWorkflow.g:1480:1: ( ( rule__Decision__OptionsAssignment_4 ) )
            {
            // InternalWorkflow.g:1480:1: ( ( rule__Decision__OptionsAssignment_4 ) )
            // InternalWorkflow.g:1481:2: ( rule__Decision__OptionsAssignment_4 )
            {
             before(grammarAccess.getDecisionAccess().getOptionsAssignment_4()); 
            // InternalWorkflow.g:1482:2: ( rule__Decision__OptionsAssignment_4 )
            // InternalWorkflow.g:1482:3: rule__Decision__OptionsAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Decision__OptionsAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getDecisionAccess().getOptionsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decision__Group__4__Impl"


    // $ANTLR start "rule__Decision__Group__5"
    // InternalWorkflow.g:1490:1: rule__Decision__Group__5 : rule__Decision__Group__5__Impl rule__Decision__Group__6 ;
    public final void rule__Decision__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1494:1: ( rule__Decision__Group__5__Impl rule__Decision__Group__6 )
            // InternalWorkflow.g:1495:2: rule__Decision__Group__5__Impl rule__Decision__Group__6
            {
            pushFollow(FOLLOW_8);
            rule__Decision__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Decision__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decision__Group__5"


    // $ANTLR start "rule__Decision__Group__5__Impl"
    // InternalWorkflow.g:1502:1: rule__Decision__Group__5__Impl : ( ( rule__Decision__Group_5__0 )* ) ;
    public final void rule__Decision__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1506:1: ( ( ( rule__Decision__Group_5__0 )* ) )
            // InternalWorkflow.g:1507:1: ( ( rule__Decision__Group_5__0 )* )
            {
            // InternalWorkflow.g:1507:1: ( ( rule__Decision__Group_5__0 )* )
            // InternalWorkflow.g:1508:2: ( rule__Decision__Group_5__0 )*
            {
             before(grammarAccess.getDecisionAccess().getGroup_5()); 
            // InternalWorkflow.g:1509:2: ( rule__Decision__Group_5__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==25) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalWorkflow.g:1509:3: rule__Decision__Group_5__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Decision__Group_5__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getDecisionAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decision__Group__5__Impl"


    // $ANTLR start "rule__Decision__Group__6"
    // InternalWorkflow.g:1517:1: rule__Decision__Group__6 : rule__Decision__Group__6__Impl rule__Decision__Group__7 ;
    public final void rule__Decision__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1521:1: ( rule__Decision__Group__6__Impl rule__Decision__Group__7 )
            // InternalWorkflow.g:1522:2: rule__Decision__Group__6__Impl rule__Decision__Group__7
            {
            pushFollow(FOLLOW_6);
            rule__Decision__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Decision__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decision__Group__6"


    // $ANTLR start "rule__Decision__Group__6__Impl"
    // InternalWorkflow.g:1529:1: rule__Decision__Group__6__Impl : ( '}' ) ;
    public final void rule__Decision__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1533:1: ( ( '}' ) )
            // InternalWorkflow.g:1534:1: ( '}' )
            {
            // InternalWorkflow.g:1534:1: ( '}' )
            // InternalWorkflow.g:1535:2: '}'
            {
             before(grammarAccess.getDecisionAccess().getRightCurlyBracketKeyword_6()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getDecisionAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decision__Group__6__Impl"


    // $ANTLR start "rule__Decision__Group__7"
    // InternalWorkflow.g:1544:1: rule__Decision__Group__7 : rule__Decision__Group__7__Impl ;
    public final void rule__Decision__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1548:1: ( rule__Decision__Group__7__Impl )
            // InternalWorkflow.g:1549:2: rule__Decision__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Decision__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decision__Group__7"


    // $ANTLR start "rule__Decision__Group__7__Impl"
    // InternalWorkflow.g:1555:1: rule__Decision__Group__7__Impl : ( '}' ) ;
    public final void rule__Decision__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1559:1: ( ( '}' ) )
            // InternalWorkflow.g:1560:1: ( '}' )
            {
            // InternalWorkflow.g:1560:1: ( '}' )
            // InternalWorkflow.g:1561:2: '}'
            {
             before(grammarAccess.getDecisionAccess().getRightCurlyBracketKeyword_7()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getDecisionAccess().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decision__Group__7__Impl"


    // $ANTLR start "rule__Decision__Group_5__0"
    // InternalWorkflow.g:1571:1: rule__Decision__Group_5__0 : rule__Decision__Group_5__0__Impl rule__Decision__Group_5__1 ;
    public final void rule__Decision__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1575:1: ( rule__Decision__Group_5__0__Impl rule__Decision__Group_5__1 )
            // InternalWorkflow.g:1576:2: rule__Decision__Group_5__0__Impl rule__Decision__Group_5__1
            {
            pushFollow(FOLLOW_13);
            rule__Decision__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Decision__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decision__Group_5__0"


    // $ANTLR start "rule__Decision__Group_5__0__Impl"
    // InternalWorkflow.g:1583:1: rule__Decision__Group_5__0__Impl : ( ',' ) ;
    public final void rule__Decision__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1587:1: ( ( ',' ) )
            // InternalWorkflow.g:1588:1: ( ',' )
            {
            // InternalWorkflow.g:1588:1: ( ',' )
            // InternalWorkflow.g:1589:2: ','
            {
             before(grammarAccess.getDecisionAccess().getCommaKeyword_5_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getDecisionAccess().getCommaKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decision__Group_5__0__Impl"


    // $ANTLR start "rule__Decision__Group_5__1"
    // InternalWorkflow.g:1598:1: rule__Decision__Group_5__1 : rule__Decision__Group_5__1__Impl ;
    public final void rule__Decision__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1602:1: ( rule__Decision__Group_5__1__Impl )
            // InternalWorkflow.g:1603:2: rule__Decision__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Decision__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decision__Group_5__1"


    // $ANTLR start "rule__Decision__Group_5__1__Impl"
    // InternalWorkflow.g:1609:1: rule__Decision__Group_5__1__Impl : ( ( rule__Decision__OptionsAssignment_5_1 ) ) ;
    public final void rule__Decision__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1613:1: ( ( ( rule__Decision__OptionsAssignment_5_1 ) ) )
            // InternalWorkflow.g:1614:1: ( ( rule__Decision__OptionsAssignment_5_1 ) )
            {
            // InternalWorkflow.g:1614:1: ( ( rule__Decision__OptionsAssignment_5_1 ) )
            // InternalWorkflow.g:1615:2: ( rule__Decision__OptionsAssignment_5_1 )
            {
             before(grammarAccess.getDecisionAccess().getOptionsAssignment_5_1()); 
            // InternalWorkflow.g:1616:2: ( rule__Decision__OptionsAssignment_5_1 )
            // InternalWorkflow.g:1616:3: rule__Decision__OptionsAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__Decision__OptionsAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getDecisionAccess().getOptionsAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decision__Group_5__1__Impl"


    // $ANTLR start "rule__GuardedWorkflow__Group__0"
    // InternalWorkflow.g:1625:1: rule__GuardedWorkflow__Group__0 : rule__GuardedWorkflow__Group__0__Impl rule__GuardedWorkflow__Group__1 ;
    public final void rule__GuardedWorkflow__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1629:1: ( rule__GuardedWorkflow__Group__0__Impl rule__GuardedWorkflow__Group__1 )
            // InternalWorkflow.g:1630:2: rule__GuardedWorkflow__Group__0__Impl rule__GuardedWorkflow__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__GuardedWorkflow__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GuardedWorkflow__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GuardedWorkflow__Group__0"


    // $ANTLR start "rule__GuardedWorkflow__Group__0__Impl"
    // InternalWorkflow.g:1637:1: rule__GuardedWorkflow__Group__0__Impl : ( 'GuardedWorkflow' ) ;
    public final void rule__GuardedWorkflow__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1641:1: ( ( 'GuardedWorkflow' ) )
            // InternalWorkflow.g:1642:1: ( 'GuardedWorkflow' )
            {
            // InternalWorkflow.g:1642:1: ( 'GuardedWorkflow' )
            // InternalWorkflow.g:1643:2: 'GuardedWorkflow'
            {
             before(grammarAccess.getGuardedWorkflowAccess().getGuardedWorkflowKeyword_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getGuardedWorkflowAccess().getGuardedWorkflowKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GuardedWorkflow__Group__0__Impl"


    // $ANTLR start "rule__GuardedWorkflow__Group__1"
    // InternalWorkflow.g:1652:1: rule__GuardedWorkflow__Group__1 : rule__GuardedWorkflow__Group__1__Impl rule__GuardedWorkflow__Group__2 ;
    public final void rule__GuardedWorkflow__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1656:1: ( rule__GuardedWorkflow__Group__1__Impl rule__GuardedWorkflow__Group__2 )
            // InternalWorkflow.g:1657:2: rule__GuardedWorkflow__Group__1__Impl rule__GuardedWorkflow__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__GuardedWorkflow__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GuardedWorkflow__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GuardedWorkflow__Group__1"


    // $ANTLR start "rule__GuardedWorkflow__Group__1__Impl"
    // InternalWorkflow.g:1664:1: rule__GuardedWorkflow__Group__1__Impl : ( '{' ) ;
    public final void rule__GuardedWorkflow__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1668:1: ( ( '{' ) )
            // InternalWorkflow.g:1669:1: ( '{' )
            {
            // InternalWorkflow.g:1669:1: ( '{' )
            // InternalWorkflow.g:1670:2: '{'
            {
             before(grammarAccess.getGuardedWorkflowAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getGuardedWorkflowAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GuardedWorkflow__Group__1__Impl"


    // $ANTLR start "rule__GuardedWorkflow__Group__2"
    // InternalWorkflow.g:1679:1: rule__GuardedWorkflow__Group__2 : rule__GuardedWorkflow__Group__2__Impl rule__GuardedWorkflow__Group__3 ;
    public final void rule__GuardedWorkflow__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1683:1: ( rule__GuardedWorkflow__Group__2__Impl rule__GuardedWorkflow__Group__3 )
            // InternalWorkflow.g:1684:2: rule__GuardedWorkflow__Group__2__Impl rule__GuardedWorkflow__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__GuardedWorkflow__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GuardedWorkflow__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GuardedWorkflow__Group__2"


    // $ANTLR start "rule__GuardedWorkflow__Group__2__Impl"
    // InternalWorkflow.g:1691:1: rule__GuardedWorkflow__Group__2__Impl : ( 'body' ) ;
    public final void rule__GuardedWorkflow__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1695:1: ( ( 'body' ) )
            // InternalWorkflow.g:1696:1: ( 'body' )
            {
            // InternalWorkflow.g:1696:1: ( 'body' )
            // InternalWorkflow.g:1697:2: 'body'
            {
             before(grammarAccess.getGuardedWorkflowAccess().getBodyKeyword_2()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getGuardedWorkflowAccess().getBodyKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GuardedWorkflow__Group__2__Impl"


    // $ANTLR start "rule__GuardedWorkflow__Group__3"
    // InternalWorkflow.g:1706:1: rule__GuardedWorkflow__Group__3 : rule__GuardedWorkflow__Group__3__Impl rule__GuardedWorkflow__Group__4 ;
    public final void rule__GuardedWorkflow__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1710:1: ( rule__GuardedWorkflow__Group__3__Impl rule__GuardedWorkflow__Group__4 )
            // InternalWorkflow.g:1711:2: rule__GuardedWorkflow__Group__3__Impl rule__GuardedWorkflow__Group__4
            {
            pushFollow(FOLLOW_16);
            rule__GuardedWorkflow__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GuardedWorkflow__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GuardedWorkflow__Group__3"


    // $ANTLR start "rule__GuardedWorkflow__Group__3__Impl"
    // InternalWorkflow.g:1718:1: rule__GuardedWorkflow__Group__3__Impl : ( ( rule__GuardedWorkflow__BodyAssignment_3 ) ) ;
    public final void rule__GuardedWorkflow__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1722:1: ( ( ( rule__GuardedWorkflow__BodyAssignment_3 ) ) )
            // InternalWorkflow.g:1723:1: ( ( rule__GuardedWorkflow__BodyAssignment_3 ) )
            {
            // InternalWorkflow.g:1723:1: ( ( rule__GuardedWorkflow__BodyAssignment_3 ) )
            // InternalWorkflow.g:1724:2: ( rule__GuardedWorkflow__BodyAssignment_3 )
            {
             before(grammarAccess.getGuardedWorkflowAccess().getBodyAssignment_3()); 
            // InternalWorkflow.g:1725:2: ( rule__GuardedWorkflow__BodyAssignment_3 )
            // InternalWorkflow.g:1725:3: rule__GuardedWorkflow__BodyAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__GuardedWorkflow__BodyAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getGuardedWorkflowAccess().getBodyAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GuardedWorkflow__Group__3__Impl"


    // $ANTLR start "rule__GuardedWorkflow__Group__4"
    // InternalWorkflow.g:1733:1: rule__GuardedWorkflow__Group__4 : rule__GuardedWorkflow__Group__4__Impl rule__GuardedWorkflow__Group__5 ;
    public final void rule__GuardedWorkflow__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1737:1: ( rule__GuardedWorkflow__Group__4__Impl rule__GuardedWorkflow__Group__5 )
            // InternalWorkflow.g:1738:2: rule__GuardedWorkflow__Group__4__Impl rule__GuardedWorkflow__Group__5
            {
            pushFollow(FOLLOW_17);
            rule__GuardedWorkflow__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GuardedWorkflow__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GuardedWorkflow__Group__4"


    // $ANTLR start "rule__GuardedWorkflow__Group__4__Impl"
    // InternalWorkflow.g:1745:1: rule__GuardedWorkflow__Group__4__Impl : ( 'guard' ) ;
    public final void rule__GuardedWorkflow__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1749:1: ( ( 'guard' ) )
            // InternalWorkflow.g:1750:1: ( 'guard' )
            {
            // InternalWorkflow.g:1750:1: ( 'guard' )
            // InternalWorkflow.g:1751:2: 'guard'
            {
             before(grammarAccess.getGuardedWorkflowAccess().getGuardKeyword_4()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getGuardedWorkflowAccess().getGuardKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GuardedWorkflow__Group__4__Impl"


    // $ANTLR start "rule__GuardedWorkflow__Group__5"
    // InternalWorkflow.g:1760:1: rule__GuardedWorkflow__Group__5 : rule__GuardedWorkflow__Group__5__Impl rule__GuardedWorkflow__Group__6 ;
    public final void rule__GuardedWorkflow__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1764:1: ( rule__GuardedWorkflow__Group__5__Impl rule__GuardedWorkflow__Group__6 )
            // InternalWorkflow.g:1765:2: rule__GuardedWorkflow__Group__5__Impl rule__GuardedWorkflow__Group__6
            {
            pushFollow(FOLLOW_6);
            rule__GuardedWorkflow__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GuardedWorkflow__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GuardedWorkflow__Group__5"


    // $ANTLR start "rule__GuardedWorkflow__Group__5__Impl"
    // InternalWorkflow.g:1772:1: rule__GuardedWorkflow__Group__5__Impl : ( ( rule__GuardedWorkflow__GuardAssignment_5 ) ) ;
    public final void rule__GuardedWorkflow__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1776:1: ( ( ( rule__GuardedWorkflow__GuardAssignment_5 ) ) )
            // InternalWorkflow.g:1777:1: ( ( rule__GuardedWorkflow__GuardAssignment_5 ) )
            {
            // InternalWorkflow.g:1777:1: ( ( rule__GuardedWorkflow__GuardAssignment_5 ) )
            // InternalWorkflow.g:1778:2: ( rule__GuardedWorkflow__GuardAssignment_5 )
            {
             before(grammarAccess.getGuardedWorkflowAccess().getGuardAssignment_5()); 
            // InternalWorkflow.g:1779:2: ( rule__GuardedWorkflow__GuardAssignment_5 )
            // InternalWorkflow.g:1779:3: rule__GuardedWorkflow__GuardAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__GuardedWorkflow__GuardAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getGuardedWorkflowAccess().getGuardAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GuardedWorkflow__Group__5__Impl"


    // $ANTLR start "rule__GuardedWorkflow__Group__6"
    // InternalWorkflow.g:1787:1: rule__GuardedWorkflow__Group__6 : rule__GuardedWorkflow__Group__6__Impl ;
    public final void rule__GuardedWorkflow__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1791:1: ( rule__GuardedWorkflow__Group__6__Impl )
            // InternalWorkflow.g:1792:2: rule__GuardedWorkflow__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__GuardedWorkflow__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GuardedWorkflow__Group__6"


    // $ANTLR start "rule__GuardedWorkflow__Group__6__Impl"
    // InternalWorkflow.g:1798:1: rule__GuardedWorkflow__Group__6__Impl : ( '}' ) ;
    public final void rule__GuardedWorkflow__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1802:1: ( ( '}' ) )
            // InternalWorkflow.g:1803:1: ( '}' )
            {
            // InternalWorkflow.g:1803:1: ( '}' )
            // InternalWorkflow.g:1804:2: '}'
            {
             before(grammarAccess.getGuardedWorkflowAccess().getRightCurlyBracketKeyword_6()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getGuardedWorkflowAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GuardedWorkflow__Group__6__Impl"


    // $ANTLR start "rule__MBoolExpr_Impl__Group__0"
    // InternalWorkflow.g:1814:1: rule__MBoolExpr_Impl__Group__0 : rule__MBoolExpr_Impl__Group__0__Impl rule__MBoolExpr_Impl__Group__1 ;
    public final void rule__MBoolExpr_Impl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1818:1: ( rule__MBoolExpr_Impl__Group__0__Impl rule__MBoolExpr_Impl__Group__1 )
            // InternalWorkflow.g:1819:2: rule__MBoolExpr_Impl__Group__0__Impl rule__MBoolExpr_Impl__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__MBoolExpr_Impl__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MBoolExpr_Impl__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MBoolExpr_Impl__Group__0"


    // $ANTLR start "rule__MBoolExpr_Impl__Group__0__Impl"
    // InternalWorkflow.g:1826:1: rule__MBoolExpr_Impl__Group__0__Impl : ( () ) ;
    public final void rule__MBoolExpr_Impl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1830:1: ( ( () ) )
            // InternalWorkflow.g:1831:1: ( () )
            {
            // InternalWorkflow.g:1831:1: ( () )
            // InternalWorkflow.g:1832:2: ()
            {
             before(grammarAccess.getMBoolExpr_ImplAccess().getMBoolExprAction_0()); 
            // InternalWorkflow.g:1833:2: ()
            // InternalWorkflow.g:1833:3: 
            {
            }

             after(grammarAccess.getMBoolExpr_ImplAccess().getMBoolExprAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MBoolExpr_Impl__Group__0__Impl"


    // $ANTLR start "rule__MBoolExpr_Impl__Group__1"
    // InternalWorkflow.g:1841:1: rule__MBoolExpr_Impl__Group__1 : rule__MBoolExpr_Impl__Group__1__Impl ;
    public final void rule__MBoolExpr_Impl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1845:1: ( rule__MBoolExpr_Impl__Group__1__Impl )
            // InternalWorkflow.g:1846:2: rule__MBoolExpr_Impl__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MBoolExpr_Impl__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MBoolExpr_Impl__Group__1"


    // $ANTLR start "rule__MBoolExpr_Impl__Group__1__Impl"
    // InternalWorkflow.g:1852:1: rule__MBoolExpr_Impl__Group__1__Impl : ( 'MBoolExpr' ) ;
    public final void rule__MBoolExpr_Impl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1856:1: ( ( 'MBoolExpr' ) )
            // InternalWorkflow.g:1857:1: ( 'MBoolExpr' )
            {
            // InternalWorkflow.g:1857:1: ( 'MBoolExpr' )
            // InternalWorkflow.g:1858:2: 'MBoolExpr'
            {
             before(grammarAccess.getMBoolExpr_ImplAccess().getMBoolExprKeyword_1()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getMBoolExpr_ImplAccess().getMBoolExprKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MBoolExpr_Impl__Group__1__Impl"


    // $ANTLR start "rule__Value__Group__0"
    // InternalWorkflow.g:1868:1: rule__Value__Group__0 : rule__Value__Group__0__Impl rule__Value__Group__1 ;
    public final void rule__Value__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1872:1: ( rule__Value__Group__0__Impl rule__Value__Group__1 )
            // InternalWorkflow.g:1873:2: rule__Value__Group__0__Impl rule__Value__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__Value__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Value__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group__0"


    // $ANTLR start "rule__Value__Group__0__Impl"
    // InternalWorkflow.g:1880:1: rule__Value__Group__0__Impl : ( () ) ;
    public final void rule__Value__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1884:1: ( ( () ) )
            // InternalWorkflow.g:1885:1: ( () )
            {
            // InternalWorkflow.g:1885:1: ( () )
            // InternalWorkflow.g:1886:2: ()
            {
             before(grammarAccess.getValueAccess().getValueAction_0()); 
            // InternalWorkflow.g:1887:2: ()
            // InternalWorkflow.g:1887:3: 
            {
            }

             after(grammarAccess.getValueAccess().getValueAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group__0__Impl"


    // $ANTLR start "rule__Value__Group__1"
    // InternalWorkflow.g:1895:1: rule__Value__Group__1 : rule__Value__Group__1__Impl rule__Value__Group__2 ;
    public final void rule__Value__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1899:1: ( rule__Value__Group__1__Impl rule__Value__Group__2 )
            // InternalWorkflow.g:1900:2: rule__Value__Group__1__Impl rule__Value__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__Value__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Value__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group__1"


    // $ANTLR start "rule__Value__Group__1__Impl"
    // InternalWorkflow.g:1907:1: rule__Value__Group__1__Impl : ( 'Value' ) ;
    public final void rule__Value__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1911:1: ( ( 'Value' ) )
            // InternalWorkflow.g:1912:1: ( 'Value' )
            {
            // InternalWorkflow.g:1912:1: ( 'Value' )
            // InternalWorkflow.g:1913:2: 'Value'
            {
             before(grammarAccess.getValueAccess().getValueKeyword_1()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getValueAccess().getValueKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group__1__Impl"


    // $ANTLR start "rule__Value__Group__2"
    // InternalWorkflow.g:1922:1: rule__Value__Group__2 : rule__Value__Group__2__Impl rule__Value__Group__3 ;
    public final void rule__Value__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1926:1: ( rule__Value__Group__2__Impl rule__Value__Group__3 )
            // InternalWorkflow.g:1927:2: rule__Value__Group__2__Impl rule__Value__Group__3
            {
            pushFollow(FOLLOW_20);
            rule__Value__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Value__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group__2"


    // $ANTLR start "rule__Value__Group__2__Impl"
    // InternalWorkflow.g:1934:1: rule__Value__Group__2__Impl : ( '{' ) ;
    public final void rule__Value__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1938:1: ( ( '{' ) )
            // InternalWorkflow.g:1939:1: ( '{' )
            {
            // InternalWorkflow.g:1939:1: ( '{' )
            // InternalWorkflow.g:1940:2: '{'
            {
             before(grammarAccess.getValueAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getValueAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group__2__Impl"


    // $ANTLR start "rule__Value__Group__3"
    // InternalWorkflow.g:1949:1: rule__Value__Group__3 : rule__Value__Group__3__Impl rule__Value__Group__4 ;
    public final void rule__Value__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1953:1: ( rule__Value__Group__3__Impl rule__Value__Group__4 )
            // InternalWorkflow.g:1954:2: rule__Value__Group__3__Impl rule__Value__Group__4
            {
            pushFollow(FOLLOW_20);
            rule__Value__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Value__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group__3"


    // $ANTLR start "rule__Value__Group__3__Impl"
    // InternalWorkflow.g:1961:1: rule__Value__Group__3__Impl : ( ( rule__Value__Group_3__0 )? ) ;
    public final void rule__Value__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1965:1: ( ( ( rule__Value__Group_3__0 )? ) )
            // InternalWorkflow.g:1966:1: ( ( rule__Value__Group_3__0 )? )
            {
            // InternalWorkflow.g:1966:1: ( ( rule__Value__Group_3__0 )? )
            // InternalWorkflow.g:1967:2: ( rule__Value__Group_3__0 )?
            {
             before(grammarAccess.getValueAccess().getGroup_3()); 
            // InternalWorkflow.g:1968:2: ( rule__Value__Group_3__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==37) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalWorkflow.g:1968:3: rule__Value__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Value__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getValueAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group__3__Impl"


    // $ANTLR start "rule__Value__Group__4"
    // InternalWorkflow.g:1976:1: rule__Value__Group__4 : rule__Value__Group__4__Impl ;
    public final void rule__Value__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1980:1: ( rule__Value__Group__4__Impl )
            // InternalWorkflow.g:1981:2: rule__Value__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Value__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group__4"


    // $ANTLR start "rule__Value__Group__4__Impl"
    // InternalWorkflow.g:1987:1: rule__Value__Group__4__Impl : ( '}' ) ;
    public final void rule__Value__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:1991:1: ( ( '}' ) )
            // InternalWorkflow.g:1992:1: ( '}' )
            {
            // InternalWorkflow.g:1992:1: ( '}' )
            // InternalWorkflow.g:1993:2: '}'
            {
             before(grammarAccess.getValueAccess().getRightCurlyBracketKeyword_4()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getValueAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group__4__Impl"


    // $ANTLR start "rule__Value__Group_3__0"
    // InternalWorkflow.g:2003:1: rule__Value__Group_3__0 : rule__Value__Group_3__0__Impl rule__Value__Group_3__1 ;
    public final void rule__Value__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2007:1: ( rule__Value__Group_3__0__Impl rule__Value__Group_3__1 )
            // InternalWorkflow.g:2008:2: rule__Value__Group_3__0__Impl rule__Value__Group_3__1
            {
            pushFollow(FOLLOW_21);
            rule__Value__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Value__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_3__0"


    // $ANTLR start "rule__Value__Group_3__0__Impl"
    // InternalWorkflow.g:2015:1: rule__Value__Group_3__0__Impl : ( 'value' ) ;
    public final void rule__Value__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2019:1: ( ( 'value' ) )
            // InternalWorkflow.g:2020:1: ( 'value' )
            {
            // InternalWorkflow.g:2020:1: ( 'value' )
            // InternalWorkflow.g:2021:2: 'value'
            {
             before(grammarAccess.getValueAccess().getValueKeyword_3_0()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getValueAccess().getValueKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_3__0__Impl"


    // $ANTLR start "rule__Value__Group_3__1"
    // InternalWorkflow.g:2030:1: rule__Value__Group_3__1 : rule__Value__Group_3__1__Impl ;
    public final void rule__Value__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2034:1: ( rule__Value__Group_3__1__Impl )
            // InternalWorkflow.g:2035:2: rule__Value__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Value__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_3__1"


    // $ANTLR start "rule__Value__Group_3__1__Impl"
    // InternalWorkflow.g:2041:1: rule__Value__Group_3__1__Impl : ( ( rule__Value__ValueAssignment_3_1 ) ) ;
    public final void rule__Value__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2045:1: ( ( ( rule__Value__ValueAssignment_3_1 ) ) )
            // InternalWorkflow.g:2046:1: ( ( rule__Value__ValueAssignment_3_1 ) )
            {
            // InternalWorkflow.g:2046:1: ( ( rule__Value__ValueAssignment_3_1 ) )
            // InternalWorkflow.g:2047:2: ( rule__Value__ValueAssignment_3_1 )
            {
             before(grammarAccess.getValueAccess().getValueAssignment_3_1()); 
            // InternalWorkflow.g:2048:2: ( rule__Value__ValueAssignment_3_1 )
            // InternalWorkflow.g:2048:3: rule__Value__ValueAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Value__ValueAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getValueAccess().getValueAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_3__1__Impl"


    // $ANTLR start "rule__BoolValue__Group__0"
    // InternalWorkflow.g:2057:1: rule__BoolValue__Group__0 : rule__BoolValue__Group__0__Impl rule__BoolValue__Group__1 ;
    public final void rule__BoolValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2061:1: ( rule__BoolValue__Group__0__Impl rule__BoolValue__Group__1 )
            // InternalWorkflow.g:2062:2: rule__BoolValue__Group__0__Impl rule__BoolValue__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__BoolValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BoolValue__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolValue__Group__0"


    // $ANTLR start "rule__BoolValue__Group__0__Impl"
    // InternalWorkflow.g:2069:1: rule__BoolValue__Group__0__Impl : ( () ) ;
    public final void rule__BoolValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2073:1: ( ( () ) )
            // InternalWorkflow.g:2074:1: ( () )
            {
            // InternalWorkflow.g:2074:1: ( () )
            // InternalWorkflow.g:2075:2: ()
            {
             before(grammarAccess.getBoolValueAccess().getBoolValueAction_0()); 
            // InternalWorkflow.g:2076:2: ()
            // InternalWorkflow.g:2076:3: 
            {
            }

             after(grammarAccess.getBoolValueAccess().getBoolValueAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolValue__Group__0__Impl"


    // $ANTLR start "rule__BoolValue__Group__1"
    // InternalWorkflow.g:2084:1: rule__BoolValue__Group__1 : rule__BoolValue__Group__1__Impl rule__BoolValue__Group__2 ;
    public final void rule__BoolValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2088:1: ( rule__BoolValue__Group__1__Impl rule__BoolValue__Group__2 )
            // InternalWorkflow.g:2089:2: rule__BoolValue__Group__1__Impl rule__BoolValue__Group__2
            {
            pushFollow(FOLLOW_22);
            rule__BoolValue__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BoolValue__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolValue__Group__1"


    // $ANTLR start "rule__BoolValue__Group__1__Impl"
    // InternalWorkflow.g:2096:1: rule__BoolValue__Group__1__Impl : ( ( rule__BoolValue__ValueAssignment_1 )? ) ;
    public final void rule__BoolValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2100:1: ( ( ( rule__BoolValue__ValueAssignment_1 )? ) )
            // InternalWorkflow.g:2101:1: ( ( rule__BoolValue__ValueAssignment_1 )? )
            {
            // InternalWorkflow.g:2101:1: ( ( rule__BoolValue__ValueAssignment_1 )? )
            // InternalWorkflow.g:2102:2: ( rule__BoolValue__ValueAssignment_1 )?
            {
             before(grammarAccess.getBoolValueAccess().getValueAssignment_1()); 
            // InternalWorkflow.g:2103:2: ( rule__BoolValue__ValueAssignment_1 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==37) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalWorkflow.g:2103:3: rule__BoolValue__ValueAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__BoolValue__ValueAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getBoolValueAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolValue__Group__1__Impl"


    // $ANTLR start "rule__BoolValue__Group__2"
    // InternalWorkflow.g:2111:1: rule__BoolValue__Group__2 : rule__BoolValue__Group__2__Impl ;
    public final void rule__BoolValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2115:1: ( rule__BoolValue__Group__2__Impl )
            // InternalWorkflow.g:2116:2: rule__BoolValue__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BoolValue__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolValue__Group__2"


    // $ANTLR start "rule__BoolValue__Group__2__Impl"
    // InternalWorkflow.g:2122:1: rule__BoolValue__Group__2__Impl : ( 'BoolValue' ) ;
    public final void rule__BoolValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2126:1: ( ( 'BoolValue' ) )
            // InternalWorkflow.g:2127:1: ( 'BoolValue' )
            {
            // InternalWorkflow.g:2127:1: ( 'BoolValue' )
            // InternalWorkflow.g:2128:2: 'BoolValue'
            {
             before(grammarAccess.getBoolValueAccess().getBoolValueKeyword_2()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getBoolValueAccess().getBoolValueKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolValue__Group__2__Impl"


    // $ANTLR start "rule__BoolComp__Group__0"
    // InternalWorkflow.g:2138:1: rule__BoolComp__Group__0 : rule__BoolComp__Group__0__Impl rule__BoolComp__Group__1 ;
    public final void rule__BoolComp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2142:1: ( rule__BoolComp__Group__0__Impl rule__BoolComp__Group__1 )
            // InternalWorkflow.g:2143:2: rule__BoolComp__Group__0__Impl rule__BoolComp__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__BoolComp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BoolComp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolComp__Group__0"


    // $ANTLR start "rule__BoolComp__Group__0__Impl"
    // InternalWorkflow.g:2150:1: rule__BoolComp__Group__0__Impl : ( () ) ;
    public final void rule__BoolComp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2154:1: ( ( () ) )
            // InternalWorkflow.g:2155:1: ( () )
            {
            // InternalWorkflow.g:2155:1: ( () )
            // InternalWorkflow.g:2156:2: ()
            {
             before(grammarAccess.getBoolCompAccess().getBoolCompAction_0()); 
            // InternalWorkflow.g:2157:2: ()
            // InternalWorkflow.g:2157:3: 
            {
            }

             after(grammarAccess.getBoolCompAccess().getBoolCompAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolComp__Group__0__Impl"


    // $ANTLR start "rule__BoolComp__Group__1"
    // InternalWorkflow.g:2165:1: rule__BoolComp__Group__1 : rule__BoolComp__Group__1__Impl rule__BoolComp__Group__2 ;
    public final void rule__BoolComp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2169:1: ( rule__BoolComp__Group__1__Impl rule__BoolComp__Group__2 )
            // InternalWorkflow.g:2170:2: rule__BoolComp__Group__1__Impl rule__BoolComp__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__BoolComp__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BoolComp__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolComp__Group__1"


    // $ANTLR start "rule__BoolComp__Group__1__Impl"
    // InternalWorkflow.g:2177:1: rule__BoolComp__Group__1__Impl : ( 'BoolComp' ) ;
    public final void rule__BoolComp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2181:1: ( ( 'BoolComp' ) )
            // InternalWorkflow.g:2182:1: ( 'BoolComp' )
            {
            // InternalWorkflow.g:2182:1: ( 'BoolComp' )
            // InternalWorkflow.g:2183:2: 'BoolComp'
            {
             before(grammarAccess.getBoolCompAccess().getBoolCompKeyword_1()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getBoolCompAccess().getBoolCompKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolComp__Group__1__Impl"


    // $ANTLR start "rule__BoolComp__Group__2"
    // InternalWorkflow.g:2192:1: rule__BoolComp__Group__2 : rule__BoolComp__Group__2__Impl rule__BoolComp__Group__3 ;
    public final void rule__BoolComp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2196:1: ( rule__BoolComp__Group__2__Impl rule__BoolComp__Group__3 )
            // InternalWorkflow.g:2197:2: rule__BoolComp__Group__2__Impl rule__BoolComp__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__BoolComp__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BoolComp__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolComp__Group__2"


    // $ANTLR start "rule__BoolComp__Group__2__Impl"
    // InternalWorkflow.g:2204:1: rule__BoolComp__Group__2__Impl : ( '{' ) ;
    public final void rule__BoolComp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2208:1: ( ( '{' ) )
            // InternalWorkflow.g:2209:1: ( '{' )
            {
            // InternalWorkflow.g:2209:1: ( '{' )
            // InternalWorkflow.g:2210:2: '{'
            {
             before(grammarAccess.getBoolCompAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getBoolCompAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolComp__Group__2__Impl"


    // $ANTLR start "rule__BoolComp__Group__3"
    // InternalWorkflow.g:2219:1: rule__BoolComp__Group__3 : rule__BoolComp__Group__3__Impl rule__BoolComp__Group__4 ;
    public final void rule__BoolComp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2223:1: ( rule__BoolComp__Group__3__Impl rule__BoolComp__Group__4 )
            // InternalWorkflow.g:2224:2: rule__BoolComp__Group__3__Impl rule__BoolComp__Group__4
            {
            pushFollow(FOLLOW_24);
            rule__BoolComp__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BoolComp__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolComp__Group__3"


    // $ANTLR start "rule__BoolComp__Group__3__Impl"
    // InternalWorkflow.g:2231:1: rule__BoolComp__Group__3__Impl : ( ( rule__BoolComp__Group_3__0 )? ) ;
    public final void rule__BoolComp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2235:1: ( ( ( rule__BoolComp__Group_3__0 )? ) )
            // InternalWorkflow.g:2236:1: ( ( rule__BoolComp__Group_3__0 )? )
            {
            // InternalWorkflow.g:2236:1: ( ( rule__BoolComp__Group_3__0 )? )
            // InternalWorkflow.g:2237:2: ( rule__BoolComp__Group_3__0 )?
            {
             before(grammarAccess.getBoolCompAccess().getGroup_3()); 
            // InternalWorkflow.g:2238:2: ( rule__BoolComp__Group_3__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==40) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalWorkflow.g:2238:3: rule__BoolComp__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__BoolComp__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getBoolCompAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolComp__Group__3__Impl"


    // $ANTLR start "rule__BoolComp__Group__4"
    // InternalWorkflow.g:2246:1: rule__BoolComp__Group__4 : rule__BoolComp__Group__4__Impl rule__BoolComp__Group__5 ;
    public final void rule__BoolComp__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2250:1: ( rule__BoolComp__Group__4__Impl rule__BoolComp__Group__5 )
            // InternalWorkflow.g:2251:2: rule__BoolComp__Group__4__Impl rule__BoolComp__Group__5
            {
            pushFollow(FOLLOW_24);
            rule__BoolComp__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BoolComp__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolComp__Group__4"


    // $ANTLR start "rule__BoolComp__Group__4__Impl"
    // InternalWorkflow.g:2258:1: rule__BoolComp__Group__4__Impl : ( ( rule__BoolComp__Group_4__0 )? ) ;
    public final void rule__BoolComp__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2262:1: ( ( ( rule__BoolComp__Group_4__0 )? ) )
            // InternalWorkflow.g:2263:1: ( ( rule__BoolComp__Group_4__0 )? )
            {
            // InternalWorkflow.g:2263:1: ( ( rule__BoolComp__Group_4__0 )? )
            // InternalWorkflow.g:2264:2: ( rule__BoolComp__Group_4__0 )?
            {
             before(grammarAccess.getBoolCompAccess().getGroup_4()); 
            // InternalWorkflow.g:2265:2: ( rule__BoolComp__Group_4__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==41) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalWorkflow.g:2265:3: rule__BoolComp__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__BoolComp__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getBoolCompAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolComp__Group__4__Impl"


    // $ANTLR start "rule__BoolComp__Group__5"
    // InternalWorkflow.g:2273:1: rule__BoolComp__Group__5 : rule__BoolComp__Group__5__Impl rule__BoolComp__Group__6 ;
    public final void rule__BoolComp__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2277:1: ( rule__BoolComp__Group__5__Impl rule__BoolComp__Group__6 )
            // InternalWorkflow.g:2278:2: rule__BoolComp__Group__5__Impl rule__BoolComp__Group__6
            {
            pushFollow(FOLLOW_24);
            rule__BoolComp__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BoolComp__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolComp__Group__5"


    // $ANTLR start "rule__BoolComp__Group__5__Impl"
    // InternalWorkflow.g:2285:1: rule__BoolComp__Group__5__Impl : ( ( rule__BoolComp__Group_5__0 )? ) ;
    public final void rule__BoolComp__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2289:1: ( ( ( rule__BoolComp__Group_5__0 )? ) )
            // InternalWorkflow.g:2290:1: ( ( rule__BoolComp__Group_5__0 )? )
            {
            // InternalWorkflow.g:2290:1: ( ( rule__BoolComp__Group_5__0 )? )
            // InternalWorkflow.g:2291:2: ( rule__BoolComp__Group_5__0 )?
            {
             before(grammarAccess.getBoolCompAccess().getGroup_5()); 
            // InternalWorkflow.g:2292:2: ( rule__BoolComp__Group_5__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==42) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalWorkflow.g:2292:3: rule__BoolComp__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__BoolComp__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getBoolCompAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolComp__Group__5__Impl"


    // $ANTLR start "rule__BoolComp__Group__6"
    // InternalWorkflow.g:2300:1: rule__BoolComp__Group__6 : rule__BoolComp__Group__6__Impl ;
    public final void rule__BoolComp__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2304:1: ( rule__BoolComp__Group__6__Impl )
            // InternalWorkflow.g:2305:2: rule__BoolComp__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BoolComp__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolComp__Group__6"


    // $ANTLR start "rule__BoolComp__Group__6__Impl"
    // InternalWorkflow.g:2311:1: rule__BoolComp__Group__6__Impl : ( '}' ) ;
    public final void rule__BoolComp__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2315:1: ( ( '}' ) )
            // InternalWorkflow.g:2316:1: ( '}' )
            {
            // InternalWorkflow.g:2316:1: ( '}' )
            // InternalWorkflow.g:2317:2: '}'
            {
             before(grammarAccess.getBoolCompAccess().getRightCurlyBracketKeyword_6()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getBoolCompAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolComp__Group__6__Impl"


    // $ANTLR start "rule__BoolComp__Group_3__0"
    // InternalWorkflow.g:2327:1: rule__BoolComp__Group_3__0 : rule__BoolComp__Group_3__0__Impl rule__BoolComp__Group_3__1 ;
    public final void rule__BoolComp__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2331:1: ( rule__BoolComp__Group_3__0__Impl rule__BoolComp__Group_3__1 )
            // InternalWorkflow.g:2332:2: rule__BoolComp__Group_3__0__Impl rule__BoolComp__Group_3__1
            {
            pushFollow(FOLLOW_25);
            rule__BoolComp__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BoolComp__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolComp__Group_3__0"


    // $ANTLR start "rule__BoolComp__Group_3__0__Impl"
    // InternalWorkflow.g:2339:1: rule__BoolComp__Group_3__0__Impl : ( 'op' ) ;
    public final void rule__BoolComp__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2343:1: ( ( 'op' ) )
            // InternalWorkflow.g:2344:1: ( 'op' )
            {
            // InternalWorkflow.g:2344:1: ( 'op' )
            // InternalWorkflow.g:2345:2: 'op'
            {
             before(grammarAccess.getBoolCompAccess().getOpKeyword_3_0()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getBoolCompAccess().getOpKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolComp__Group_3__0__Impl"


    // $ANTLR start "rule__BoolComp__Group_3__1"
    // InternalWorkflow.g:2354:1: rule__BoolComp__Group_3__1 : rule__BoolComp__Group_3__1__Impl ;
    public final void rule__BoolComp__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2358:1: ( rule__BoolComp__Group_3__1__Impl )
            // InternalWorkflow.g:2359:2: rule__BoolComp__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BoolComp__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolComp__Group_3__1"


    // $ANTLR start "rule__BoolComp__Group_3__1__Impl"
    // InternalWorkflow.g:2365:1: rule__BoolComp__Group_3__1__Impl : ( ( rule__BoolComp__OpAssignment_3_1 ) ) ;
    public final void rule__BoolComp__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2369:1: ( ( ( rule__BoolComp__OpAssignment_3_1 ) ) )
            // InternalWorkflow.g:2370:1: ( ( rule__BoolComp__OpAssignment_3_1 ) )
            {
            // InternalWorkflow.g:2370:1: ( ( rule__BoolComp__OpAssignment_3_1 ) )
            // InternalWorkflow.g:2371:2: ( rule__BoolComp__OpAssignment_3_1 )
            {
             before(grammarAccess.getBoolCompAccess().getOpAssignment_3_1()); 
            // InternalWorkflow.g:2372:2: ( rule__BoolComp__OpAssignment_3_1 )
            // InternalWorkflow.g:2372:3: rule__BoolComp__OpAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__BoolComp__OpAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getBoolCompAccess().getOpAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolComp__Group_3__1__Impl"


    // $ANTLR start "rule__BoolComp__Group_4__0"
    // InternalWorkflow.g:2381:1: rule__BoolComp__Group_4__0 : rule__BoolComp__Group_4__0__Impl rule__BoolComp__Group_4__1 ;
    public final void rule__BoolComp__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2385:1: ( rule__BoolComp__Group_4__0__Impl rule__BoolComp__Group_4__1 )
            // InternalWorkflow.g:2386:2: rule__BoolComp__Group_4__0__Impl rule__BoolComp__Group_4__1
            {
            pushFollow(FOLLOW_17);
            rule__BoolComp__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BoolComp__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolComp__Group_4__0"


    // $ANTLR start "rule__BoolComp__Group_4__0__Impl"
    // InternalWorkflow.g:2393:1: rule__BoolComp__Group_4__0__Impl : ( 'right' ) ;
    public final void rule__BoolComp__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2397:1: ( ( 'right' ) )
            // InternalWorkflow.g:2398:1: ( 'right' )
            {
            // InternalWorkflow.g:2398:1: ( 'right' )
            // InternalWorkflow.g:2399:2: 'right'
            {
             before(grammarAccess.getBoolCompAccess().getRightKeyword_4_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getBoolCompAccess().getRightKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolComp__Group_4__0__Impl"


    // $ANTLR start "rule__BoolComp__Group_4__1"
    // InternalWorkflow.g:2408:1: rule__BoolComp__Group_4__1 : rule__BoolComp__Group_4__1__Impl ;
    public final void rule__BoolComp__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2412:1: ( rule__BoolComp__Group_4__1__Impl )
            // InternalWorkflow.g:2413:2: rule__BoolComp__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BoolComp__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolComp__Group_4__1"


    // $ANTLR start "rule__BoolComp__Group_4__1__Impl"
    // InternalWorkflow.g:2419:1: rule__BoolComp__Group_4__1__Impl : ( ( rule__BoolComp__RightAssignment_4_1 ) ) ;
    public final void rule__BoolComp__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2423:1: ( ( ( rule__BoolComp__RightAssignment_4_1 ) ) )
            // InternalWorkflow.g:2424:1: ( ( rule__BoolComp__RightAssignment_4_1 ) )
            {
            // InternalWorkflow.g:2424:1: ( ( rule__BoolComp__RightAssignment_4_1 ) )
            // InternalWorkflow.g:2425:2: ( rule__BoolComp__RightAssignment_4_1 )
            {
             before(grammarAccess.getBoolCompAccess().getRightAssignment_4_1()); 
            // InternalWorkflow.g:2426:2: ( rule__BoolComp__RightAssignment_4_1 )
            // InternalWorkflow.g:2426:3: rule__BoolComp__RightAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__BoolComp__RightAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getBoolCompAccess().getRightAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolComp__Group_4__1__Impl"


    // $ANTLR start "rule__BoolComp__Group_5__0"
    // InternalWorkflow.g:2435:1: rule__BoolComp__Group_5__0 : rule__BoolComp__Group_5__0__Impl rule__BoolComp__Group_5__1 ;
    public final void rule__BoolComp__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2439:1: ( rule__BoolComp__Group_5__0__Impl rule__BoolComp__Group_5__1 )
            // InternalWorkflow.g:2440:2: rule__BoolComp__Group_5__0__Impl rule__BoolComp__Group_5__1
            {
            pushFollow(FOLLOW_17);
            rule__BoolComp__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BoolComp__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolComp__Group_5__0"


    // $ANTLR start "rule__BoolComp__Group_5__0__Impl"
    // InternalWorkflow.g:2447:1: rule__BoolComp__Group_5__0__Impl : ( 'left' ) ;
    public final void rule__BoolComp__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2451:1: ( ( 'left' ) )
            // InternalWorkflow.g:2452:1: ( 'left' )
            {
            // InternalWorkflow.g:2452:1: ( 'left' )
            // InternalWorkflow.g:2453:2: 'left'
            {
             before(grammarAccess.getBoolCompAccess().getLeftKeyword_5_0()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getBoolCompAccess().getLeftKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolComp__Group_5__0__Impl"


    // $ANTLR start "rule__BoolComp__Group_5__1"
    // InternalWorkflow.g:2462:1: rule__BoolComp__Group_5__1 : rule__BoolComp__Group_5__1__Impl ;
    public final void rule__BoolComp__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2466:1: ( rule__BoolComp__Group_5__1__Impl )
            // InternalWorkflow.g:2467:2: rule__BoolComp__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BoolComp__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolComp__Group_5__1"


    // $ANTLR start "rule__BoolComp__Group_5__1__Impl"
    // InternalWorkflow.g:2473:1: rule__BoolComp__Group_5__1__Impl : ( ( rule__BoolComp__LeftAssignment_5_1 ) ) ;
    public final void rule__BoolComp__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2477:1: ( ( ( rule__BoolComp__LeftAssignment_5_1 ) ) )
            // InternalWorkflow.g:2478:1: ( ( rule__BoolComp__LeftAssignment_5_1 ) )
            {
            // InternalWorkflow.g:2478:1: ( ( rule__BoolComp__LeftAssignment_5_1 ) )
            // InternalWorkflow.g:2479:2: ( rule__BoolComp__LeftAssignment_5_1 )
            {
             before(grammarAccess.getBoolCompAccess().getLeftAssignment_5_1()); 
            // InternalWorkflow.g:2480:2: ( rule__BoolComp__LeftAssignment_5_1 )
            // InternalWorkflow.g:2480:3: rule__BoolComp__LeftAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__BoolComp__LeftAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getBoolCompAccess().getLeftAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolComp__Group_5__1__Impl"


    // $ANTLR start "rule__Not__Group__0"
    // InternalWorkflow.g:2489:1: rule__Not__Group__0 : rule__Not__Group__0__Impl rule__Not__Group__1 ;
    public final void rule__Not__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2493:1: ( rule__Not__Group__0__Impl rule__Not__Group__1 )
            // InternalWorkflow.g:2494:2: rule__Not__Group__0__Impl rule__Not__Group__1
            {
            pushFollow(FOLLOW_26);
            rule__Not__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Not__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__0"


    // $ANTLR start "rule__Not__Group__0__Impl"
    // InternalWorkflow.g:2501:1: rule__Not__Group__0__Impl : ( () ) ;
    public final void rule__Not__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2505:1: ( ( () ) )
            // InternalWorkflow.g:2506:1: ( () )
            {
            // InternalWorkflow.g:2506:1: ( () )
            // InternalWorkflow.g:2507:2: ()
            {
             before(grammarAccess.getNotAccess().getNotAction_0()); 
            // InternalWorkflow.g:2508:2: ()
            // InternalWorkflow.g:2508:3: 
            {
            }

             after(grammarAccess.getNotAccess().getNotAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__0__Impl"


    // $ANTLR start "rule__Not__Group__1"
    // InternalWorkflow.g:2516:1: rule__Not__Group__1 : rule__Not__Group__1__Impl rule__Not__Group__2 ;
    public final void rule__Not__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2520:1: ( rule__Not__Group__1__Impl rule__Not__Group__2 )
            // InternalWorkflow.g:2521:2: rule__Not__Group__1__Impl rule__Not__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__Not__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Not__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__1"


    // $ANTLR start "rule__Not__Group__1__Impl"
    // InternalWorkflow.g:2528:1: rule__Not__Group__1__Impl : ( 'Not' ) ;
    public final void rule__Not__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2532:1: ( ( 'Not' ) )
            // InternalWorkflow.g:2533:1: ( 'Not' )
            {
            // InternalWorkflow.g:2533:1: ( 'Not' )
            // InternalWorkflow.g:2534:2: 'Not'
            {
             before(grammarAccess.getNotAccess().getNotKeyword_1()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getNotAccess().getNotKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__1__Impl"


    // $ANTLR start "rule__Not__Group__2"
    // InternalWorkflow.g:2543:1: rule__Not__Group__2 : rule__Not__Group__2__Impl rule__Not__Group__3 ;
    public final void rule__Not__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2547:1: ( rule__Not__Group__2__Impl rule__Not__Group__3 )
            // InternalWorkflow.g:2548:2: rule__Not__Group__2__Impl rule__Not__Group__3
            {
            pushFollow(FOLLOW_27);
            rule__Not__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Not__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__2"


    // $ANTLR start "rule__Not__Group__2__Impl"
    // InternalWorkflow.g:2555:1: rule__Not__Group__2__Impl : ( '{' ) ;
    public final void rule__Not__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2559:1: ( ( '{' ) )
            // InternalWorkflow.g:2560:1: ( '{' )
            {
            // InternalWorkflow.g:2560:1: ( '{' )
            // InternalWorkflow.g:2561:2: '{'
            {
             before(grammarAccess.getNotAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getNotAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__2__Impl"


    // $ANTLR start "rule__Not__Group__3"
    // InternalWorkflow.g:2570:1: rule__Not__Group__3 : rule__Not__Group__3__Impl rule__Not__Group__4 ;
    public final void rule__Not__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2574:1: ( rule__Not__Group__3__Impl rule__Not__Group__4 )
            // InternalWorkflow.g:2575:2: rule__Not__Group__3__Impl rule__Not__Group__4
            {
            pushFollow(FOLLOW_27);
            rule__Not__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Not__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__3"


    // $ANTLR start "rule__Not__Group__3__Impl"
    // InternalWorkflow.g:2582:1: rule__Not__Group__3__Impl : ( ( rule__Not__Group_3__0 )? ) ;
    public final void rule__Not__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2586:1: ( ( ( rule__Not__Group_3__0 )? ) )
            // InternalWorkflow.g:2587:1: ( ( rule__Not__Group_3__0 )? )
            {
            // InternalWorkflow.g:2587:1: ( ( rule__Not__Group_3__0 )? )
            // InternalWorkflow.g:2588:2: ( rule__Not__Group_3__0 )?
            {
             before(grammarAccess.getNotAccess().getGroup_3()); 
            // InternalWorkflow.g:2589:2: ( rule__Not__Group_3__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==40) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalWorkflow.g:2589:3: rule__Not__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Not__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNotAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__3__Impl"


    // $ANTLR start "rule__Not__Group__4"
    // InternalWorkflow.g:2597:1: rule__Not__Group__4 : rule__Not__Group__4__Impl rule__Not__Group__5 ;
    public final void rule__Not__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2601:1: ( rule__Not__Group__4__Impl rule__Not__Group__5 )
            // InternalWorkflow.g:2602:2: rule__Not__Group__4__Impl rule__Not__Group__5
            {
            pushFollow(FOLLOW_27);
            rule__Not__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Not__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__4"


    // $ANTLR start "rule__Not__Group__4__Impl"
    // InternalWorkflow.g:2609:1: rule__Not__Group__4__Impl : ( ( rule__Not__Group_4__0 )? ) ;
    public final void rule__Not__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2613:1: ( ( ( rule__Not__Group_4__0 )? ) )
            // InternalWorkflow.g:2614:1: ( ( rule__Not__Group_4__0 )? )
            {
            // InternalWorkflow.g:2614:1: ( ( rule__Not__Group_4__0 )? )
            // InternalWorkflow.g:2615:2: ( rule__Not__Group_4__0 )?
            {
             before(grammarAccess.getNotAccess().getGroup_4()); 
            // InternalWorkflow.g:2616:2: ( rule__Not__Group_4__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==44) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalWorkflow.g:2616:3: rule__Not__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Not__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNotAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__4__Impl"


    // $ANTLR start "rule__Not__Group__5"
    // InternalWorkflow.g:2624:1: rule__Not__Group__5 : rule__Not__Group__5__Impl ;
    public final void rule__Not__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2628:1: ( rule__Not__Group__5__Impl )
            // InternalWorkflow.g:2629:2: rule__Not__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Not__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__5"


    // $ANTLR start "rule__Not__Group__5__Impl"
    // InternalWorkflow.g:2635:1: rule__Not__Group__5__Impl : ( '}' ) ;
    public final void rule__Not__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2639:1: ( ( '}' ) )
            // InternalWorkflow.g:2640:1: ( '}' )
            {
            // InternalWorkflow.g:2640:1: ( '}' )
            // InternalWorkflow.g:2641:2: '}'
            {
             before(grammarAccess.getNotAccess().getRightCurlyBracketKeyword_5()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getNotAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group__5__Impl"


    // $ANTLR start "rule__Not__Group_3__0"
    // InternalWorkflow.g:2651:1: rule__Not__Group_3__0 : rule__Not__Group_3__0__Impl rule__Not__Group_3__1 ;
    public final void rule__Not__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2655:1: ( rule__Not__Group_3__0__Impl rule__Not__Group_3__1 )
            // InternalWorkflow.g:2656:2: rule__Not__Group_3__0__Impl rule__Not__Group_3__1
            {
            pushFollow(FOLLOW_11);
            rule__Not__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Not__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group_3__0"


    // $ANTLR start "rule__Not__Group_3__0__Impl"
    // InternalWorkflow.g:2663:1: rule__Not__Group_3__0__Impl : ( 'op' ) ;
    public final void rule__Not__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2667:1: ( ( 'op' ) )
            // InternalWorkflow.g:2668:1: ( 'op' )
            {
            // InternalWorkflow.g:2668:1: ( 'op' )
            // InternalWorkflow.g:2669:2: 'op'
            {
             before(grammarAccess.getNotAccess().getOpKeyword_3_0()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getNotAccess().getOpKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group_3__0__Impl"


    // $ANTLR start "rule__Not__Group_3__1"
    // InternalWorkflow.g:2678:1: rule__Not__Group_3__1 : rule__Not__Group_3__1__Impl ;
    public final void rule__Not__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2682:1: ( rule__Not__Group_3__1__Impl )
            // InternalWorkflow.g:2683:2: rule__Not__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Not__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group_3__1"


    // $ANTLR start "rule__Not__Group_3__1__Impl"
    // InternalWorkflow.g:2689:1: rule__Not__Group_3__1__Impl : ( ( rule__Not__OpAssignment_3_1 ) ) ;
    public final void rule__Not__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2693:1: ( ( ( rule__Not__OpAssignment_3_1 ) ) )
            // InternalWorkflow.g:2694:1: ( ( rule__Not__OpAssignment_3_1 ) )
            {
            // InternalWorkflow.g:2694:1: ( ( rule__Not__OpAssignment_3_1 ) )
            // InternalWorkflow.g:2695:2: ( rule__Not__OpAssignment_3_1 )
            {
             before(grammarAccess.getNotAccess().getOpAssignment_3_1()); 
            // InternalWorkflow.g:2696:2: ( rule__Not__OpAssignment_3_1 )
            // InternalWorkflow.g:2696:3: rule__Not__OpAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Not__OpAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getNotAccess().getOpAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group_3__1__Impl"


    // $ANTLR start "rule__Not__Group_4__0"
    // InternalWorkflow.g:2705:1: rule__Not__Group_4__0 : rule__Not__Group_4__0__Impl rule__Not__Group_4__1 ;
    public final void rule__Not__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2709:1: ( rule__Not__Group_4__0__Impl rule__Not__Group_4__1 )
            // InternalWorkflow.g:2710:2: rule__Not__Group_4__0__Impl rule__Not__Group_4__1
            {
            pushFollow(FOLLOW_17);
            rule__Not__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Not__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group_4__0"


    // $ANTLR start "rule__Not__Group_4__0__Impl"
    // InternalWorkflow.g:2717:1: rule__Not__Group_4__0__Impl : ( 'expr' ) ;
    public final void rule__Not__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2721:1: ( ( 'expr' ) )
            // InternalWorkflow.g:2722:1: ( 'expr' )
            {
            // InternalWorkflow.g:2722:1: ( 'expr' )
            // InternalWorkflow.g:2723:2: 'expr'
            {
             before(grammarAccess.getNotAccess().getExprKeyword_4_0()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getNotAccess().getExprKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group_4__0__Impl"


    // $ANTLR start "rule__Not__Group_4__1"
    // InternalWorkflow.g:2732:1: rule__Not__Group_4__1 : rule__Not__Group_4__1__Impl ;
    public final void rule__Not__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2736:1: ( rule__Not__Group_4__1__Impl )
            // InternalWorkflow.g:2737:2: rule__Not__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Not__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group_4__1"


    // $ANTLR start "rule__Not__Group_4__1__Impl"
    // InternalWorkflow.g:2743:1: rule__Not__Group_4__1__Impl : ( ( rule__Not__ExprAssignment_4_1 ) ) ;
    public final void rule__Not__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2747:1: ( ( ( rule__Not__ExprAssignment_4_1 ) ) )
            // InternalWorkflow.g:2748:1: ( ( rule__Not__ExprAssignment_4_1 ) )
            {
            // InternalWorkflow.g:2748:1: ( ( rule__Not__ExprAssignment_4_1 ) )
            // InternalWorkflow.g:2749:2: ( rule__Not__ExprAssignment_4_1 )
            {
             before(grammarAccess.getNotAccess().getExprAssignment_4_1()); 
            // InternalWorkflow.g:2750:2: ( rule__Not__ExprAssignment_4_1 )
            // InternalWorkflow.g:2750:3: rule__Not__ExprAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Not__ExprAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getNotAccess().getExprAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__Group_4__1__Impl"


    // $ANTLR start "rule__RelComp__Group__0"
    // InternalWorkflow.g:2759:1: rule__RelComp__Group__0 : rule__RelComp__Group__0__Impl rule__RelComp__Group__1 ;
    public final void rule__RelComp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2763:1: ( rule__RelComp__Group__0__Impl rule__RelComp__Group__1 )
            // InternalWorkflow.g:2764:2: rule__RelComp__Group__0__Impl rule__RelComp__Group__1
            {
            pushFollow(FOLLOW_28);
            rule__RelComp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RelComp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelComp__Group__0"


    // $ANTLR start "rule__RelComp__Group__0__Impl"
    // InternalWorkflow.g:2771:1: rule__RelComp__Group__0__Impl : ( () ) ;
    public final void rule__RelComp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2775:1: ( ( () ) )
            // InternalWorkflow.g:2776:1: ( () )
            {
            // InternalWorkflow.g:2776:1: ( () )
            // InternalWorkflow.g:2777:2: ()
            {
             before(grammarAccess.getRelCompAccess().getRelCompAction_0()); 
            // InternalWorkflow.g:2778:2: ()
            // InternalWorkflow.g:2778:3: 
            {
            }

             after(grammarAccess.getRelCompAccess().getRelCompAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelComp__Group__0__Impl"


    // $ANTLR start "rule__RelComp__Group__1"
    // InternalWorkflow.g:2786:1: rule__RelComp__Group__1 : rule__RelComp__Group__1__Impl rule__RelComp__Group__2 ;
    public final void rule__RelComp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2790:1: ( rule__RelComp__Group__1__Impl rule__RelComp__Group__2 )
            // InternalWorkflow.g:2791:2: rule__RelComp__Group__1__Impl rule__RelComp__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__RelComp__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RelComp__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelComp__Group__1"


    // $ANTLR start "rule__RelComp__Group__1__Impl"
    // InternalWorkflow.g:2798:1: rule__RelComp__Group__1__Impl : ( 'RelComp' ) ;
    public final void rule__RelComp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2802:1: ( ( 'RelComp' ) )
            // InternalWorkflow.g:2803:1: ( 'RelComp' )
            {
            // InternalWorkflow.g:2803:1: ( 'RelComp' )
            // InternalWorkflow.g:2804:2: 'RelComp'
            {
             before(grammarAccess.getRelCompAccess().getRelCompKeyword_1()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getRelCompAccess().getRelCompKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelComp__Group__1__Impl"


    // $ANTLR start "rule__RelComp__Group__2"
    // InternalWorkflow.g:2813:1: rule__RelComp__Group__2 : rule__RelComp__Group__2__Impl rule__RelComp__Group__3 ;
    public final void rule__RelComp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2817:1: ( rule__RelComp__Group__2__Impl rule__RelComp__Group__3 )
            // InternalWorkflow.g:2818:2: rule__RelComp__Group__2__Impl rule__RelComp__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__RelComp__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RelComp__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelComp__Group__2"


    // $ANTLR start "rule__RelComp__Group__2__Impl"
    // InternalWorkflow.g:2825:1: rule__RelComp__Group__2__Impl : ( '{' ) ;
    public final void rule__RelComp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2829:1: ( ( '{' ) )
            // InternalWorkflow.g:2830:1: ( '{' )
            {
            // InternalWorkflow.g:2830:1: ( '{' )
            // InternalWorkflow.g:2831:2: '{'
            {
             before(grammarAccess.getRelCompAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getRelCompAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelComp__Group__2__Impl"


    // $ANTLR start "rule__RelComp__Group__3"
    // InternalWorkflow.g:2840:1: rule__RelComp__Group__3 : rule__RelComp__Group__3__Impl rule__RelComp__Group__4 ;
    public final void rule__RelComp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2844:1: ( rule__RelComp__Group__3__Impl rule__RelComp__Group__4 )
            // InternalWorkflow.g:2845:2: rule__RelComp__Group__3__Impl rule__RelComp__Group__4
            {
            pushFollow(FOLLOW_24);
            rule__RelComp__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RelComp__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelComp__Group__3"


    // $ANTLR start "rule__RelComp__Group__3__Impl"
    // InternalWorkflow.g:2852:1: rule__RelComp__Group__3__Impl : ( ( rule__RelComp__Group_3__0 )? ) ;
    public final void rule__RelComp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2856:1: ( ( ( rule__RelComp__Group_3__0 )? ) )
            // InternalWorkflow.g:2857:1: ( ( rule__RelComp__Group_3__0 )? )
            {
            // InternalWorkflow.g:2857:1: ( ( rule__RelComp__Group_3__0 )? )
            // InternalWorkflow.g:2858:2: ( rule__RelComp__Group_3__0 )?
            {
             before(grammarAccess.getRelCompAccess().getGroup_3()); 
            // InternalWorkflow.g:2859:2: ( rule__RelComp__Group_3__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==40) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalWorkflow.g:2859:3: rule__RelComp__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RelComp__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRelCompAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelComp__Group__3__Impl"


    // $ANTLR start "rule__RelComp__Group__4"
    // InternalWorkflow.g:2867:1: rule__RelComp__Group__4 : rule__RelComp__Group__4__Impl rule__RelComp__Group__5 ;
    public final void rule__RelComp__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2871:1: ( rule__RelComp__Group__4__Impl rule__RelComp__Group__5 )
            // InternalWorkflow.g:2872:2: rule__RelComp__Group__4__Impl rule__RelComp__Group__5
            {
            pushFollow(FOLLOW_24);
            rule__RelComp__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RelComp__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelComp__Group__4"


    // $ANTLR start "rule__RelComp__Group__4__Impl"
    // InternalWorkflow.g:2879:1: rule__RelComp__Group__4__Impl : ( ( rule__RelComp__Group_4__0 )? ) ;
    public final void rule__RelComp__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2883:1: ( ( ( rule__RelComp__Group_4__0 )? ) )
            // InternalWorkflow.g:2884:1: ( ( rule__RelComp__Group_4__0 )? )
            {
            // InternalWorkflow.g:2884:1: ( ( rule__RelComp__Group_4__0 )? )
            // InternalWorkflow.g:2885:2: ( rule__RelComp__Group_4__0 )?
            {
             before(grammarAccess.getRelCompAccess().getGroup_4()); 
            // InternalWorkflow.g:2886:2: ( rule__RelComp__Group_4__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==42) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalWorkflow.g:2886:3: rule__RelComp__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RelComp__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRelCompAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelComp__Group__4__Impl"


    // $ANTLR start "rule__RelComp__Group__5"
    // InternalWorkflow.g:2894:1: rule__RelComp__Group__5 : rule__RelComp__Group__5__Impl rule__RelComp__Group__6 ;
    public final void rule__RelComp__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2898:1: ( rule__RelComp__Group__5__Impl rule__RelComp__Group__6 )
            // InternalWorkflow.g:2899:2: rule__RelComp__Group__5__Impl rule__RelComp__Group__6
            {
            pushFollow(FOLLOW_24);
            rule__RelComp__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RelComp__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelComp__Group__5"


    // $ANTLR start "rule__RelComp__Group__5__Impl"
    // InternalWorkflow.g:2906:1: rule__RelComp__Group__5__Impl : ( ( rule__RelComp__Group_5__0 )? ) ;
    public final void rule__RelComp__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2910:1: ( ( ( rule__RelComp__Group_5__0 )? ) )
            // InternalWorkflow.g:2911:1: ( ( rule__RelComp__Group_5__0 )? )
            {
            // InternalWorkflow.g:2911:1: ( ( rule__RelComp__Group_5__0 )? )
            // InternalWorkflow.g:2912:2: ( rule__RelComp__Group_5__0 )?
            {
             before(grammarAccess.getRelCompAccess().getGroup_5()); 
            // InternalWorkflow.g:2913:2: ( rule__RelComp__Group_5__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==41) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalWorkflow.g:2913:3: rule__RelComp__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RelComp__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRelCompAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelComp__Group__5__Impl"


    // $ANTLR start "rule__RelComp__Group__6"
    // InternalWorkflow.g:2921:1: rule__RelComp__Group__6 : rule__RelComp__Group__6__Impl ;
    public final void rule__RelComp__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2925:1: ( rule__RelComp__Group__6__Impl )
            // InternalWorkflow.g:2926:2: rule__RelComp__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RelComp__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelComp__Group__6"


    // $ANTLR start "rule__RelComp__Group__6__Impl"
    // InternalWorkflow.g:2932:1: rule__RelComp__Group__6__Impl : ( '}' ) ;
    public final void rule__RelComp__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2936:1: ( ( '}' ) )
            // InternalWorkflow.g:2937:1: ( '}' )
            {
            // InternalWorkflow.g:2937:1: ( '}' )
            // InternalWorkflow.g:2938:2: '}'
            {
             before(grammarAccess.getRelCompAccess().getRightCurlyBracketKeyword_6()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getRelCompAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelComp__Group__6__Impl"


    // $ANTLR start "rule__RelComp__Group_3__0"
    // InternalWorkflow.g:2948:1: rule__RelComp__Group_3__0 : rule__RelComp__Group_3__0__Impl rule__RelComp__Group_3__1 ;
    public final void rule__RelComp__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2952:1: ( rule__RelComp__Group_3__0__Impl rule__RelComp__Group_3__1 )
            // InternalWorkflow.g:2953:2: rule__RelComp__Group_3__0__Impl rule__RelComp__Group_3__1
            {
            pushFollow(FOLLOW_29);
            rule__RelComp__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RelComp__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelComp__Group_3__0"


    // $ANTLR start "rule__RelComp__Group_3__0__Impl"
    // InternalWorkflow.g:2960:1: rule__RelComp__Group_3__0__Impl : ( 'op' ) ;
    public final void rule__RelComp__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2964:1: ( ( 'op' ) )
            // InternalWorkflow.g:2965:1: ( 'op' )
            {
            // InternalWorkflow.g:2965:1: ( 'op' )
            // InternalWorkflow.g:2966:2: 'op'
            {
             before(grammarAccess.getRelCompAccess().getOpKeyword_3_0()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getRelCompAccess().getOpKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelComp__Group_3__0__Impl"


    // $ANTLR start "rule__RelComp__Group_3__1"
    // InternalWorkflow.g:2975:1: rule__RelComp__Group_3__1 : rule__RelComp__Group_3__1__Impl ;
    public final void rule__RelComp__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2979:1: ( rule__RelComp__Group_3__1__Impl )
            // InternalWorkflow.g:2980:2: rule__RelComp__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RelComp__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelComp__Group_3__1"


    // $ANTLR start "rule__RelComp__Group_3__1__Impl"
    // InternalWorkflow.g:2986:1: rule__RelComp__Group_3__1__Impl : ( ( rule__RelComp__OpAssignment_3_1 ) ) ;
    public final void rule__RelComp__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:2990:1: ( ( ( rule__RelComp__OpAssignment_3_1 ) ) )
            // InternalWorkflow.g:2991:1: ( ( rule__RelComp__OpAssignment_3_1 ) )
            {
            // InternalWorkflow.g:2991:1: ( ( rule__RelComp__OpAssignment_3_1 ) )
            // InternalWorkflow.g:2992:2: ( rule__RelComp__OpAssignment_3_1 )
            {
             before(grammarAccess.getRelCompAccess().getOpAssignment_3_1()); 
            // InternalWorkflow.g:2993:2: ( rule__RelComp__OpAssignment_3_1 )
            // InternalWorkflow.g:2993:3: rule__RelComp__OpAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__RelComp__OpAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getRelCompAccess().getOpAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelComp__Group_3__1__Impl"


    // $ANTLR start "rule__RelComp__Group_4__0"
    // InternalWorkflow.g:3002:1: rule__RelComp__Group_4__0 : rule__RelComp__Group_4__0__Impl rule__RelComp__Group_4__1 ;
    public final void rule__RelComp__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3006:1: ( rule__RelComp__Group_4__0__Impl rule__RelComp__Group_4__1 )
            // InternalWorkflow.g:3007:2: rule__RelComp__Group_4__0__Impl rule__RelComp__Group_4__1
            {
            pushFollow(FOLLOW_17);
            rule__RelComp__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RelComp__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelComp__Group_4__0"


    // $ANTLR start "rule__RelComp__Group_4__0__Impl"
    // InternalWorkflow.g:3014:1: rule__RelComp__Group_4__0__Impl : ( 'left' ) ;
    public final void rule__RelComp__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3018:1: ( ( 'left' ) )
            // InternalWorkflow.g:3019:1: ( 'left' )
            {
            // InternalWorkflow.g:3019:1: ( 'left' )
            // InternalWorkflow.g:3020:2: 'left'
            {
             before(grammarAccess.getRelCompAccess().getLeftKeyword_4_0()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getRelCompAccess().getLeftKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelComp__Group_4__0__Impl"


    // $ANTLR start "rule__RelComp__Group_4__1"
    // InternalWorkflow.g:3029:1: rule__RelComp__Group_4__1 : rule__RelComp__Group_4__1__Impl ;
    public final void rule__RelComp__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3033:1: ( rule__RelComp__Group_4__1__Impl )
            // InternalWorkflow.g:3034:2: rule__RelComp__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RelComp__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelComp__Group_4__1"


    // $ANTLR start "rule__RelComp__Group_4__1__Impl"
    // InternalWorkflow.g:3040:1: rule__RelComp__Group_4__1__Impl : ( ( rule__RelComp__LeftAssignment_4_1 ) ) ;
    public final void rule__RelComp__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3044:1: ( ( ( rule__RelComp__LeftAssignment_4_1 ) ) )
            // InternalWorkflow.g:3045:1: ( ( rule__RelComp__LeftAssignment_4_1 ) )
            {
            // InternalWorkflow.g:3045:1: ( ( rule__RelComp__LeftAssignment_4_1 ) )
            // InternalWorkflow.g:3046:2: ( rule__RelComp__LeftAssignment_4_1 )
            {
             before(grammarAccess.getRelCompAccess().getLeftAssignment_4_1()); 
            // InternalWorkflow.g:3047:2: ( rule__RelComp__LeftAssignment_4_1 )
            // InternalWorkflow.g:3047:3: rule__RelComp__LeftAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__RelComp__LeftAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getRelCompAccess().getLeftAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelComp__Group_4__1__Impl"


    // $ANTLR start "rule__RelComp__Group_5__0"
    // InternalWorkflow.g:3056:1: rule__RelComp__Group_5__0 : rule__RelComp__Group_5__0__Impl rule__RelComp__Group_5__1 ;
    public final void rule__RelComp__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3060:1: ( rule__RelComp__Group_5__0__Impl rule__RelComp__Group_5__1 )
            // InternalWorkflow.g:3061:2: rule__RelComp__Group_5__0__Impl rule__RelComp__Group_5__1
            {
            pushFollow(FOLLOW_17);
            rule__RelComp__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RelComp__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelComp__Group_5__0"


    // $ANTLR start "rule__RelComp__Group_5__0__Impl"
    // InternalWorkflow.g:3068:1: rule__RelComp__Group_5__0__Impl : ( 'right' ) ;
    public final void rule__RelComp__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3072:1: ( ( 'right' ) )
            // InternalWorkflow.g:3073:1: ( 'right' )
            {
            // InternalWorkflow.g:3073:1: ( 'right' )
            // InternalWorkflow.g:3074:2: 'right'
            {
             before(grammarAccess.getRelCompAccess().getRightKeyword_5_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getRelCompAccess().getRightKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelComp__Group_5__0__Impl"


    // $ANTLR start "rule__RelComp__Group_5__1"
    // InternalWorkflow.g:3083:1: rule__RelComp__Group_5__1 : rule__RelComp__Group_5__1__Impl ;
    public final void rule__RelComp__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3087:1: ( rule__RelComp__Group_5__1__Impl )
            // InternalWorkflow.g:3088:2: rule__RelComp__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RelComp__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelComp__Group_5__1"


    // $ANTLR start "rule__RelComp__Group_5__1__Impl"
    // InternalWorkflow.g:3094:1: rule__RelComp__Group_5__1__Impl : ( ( rule__RelComp__RightAssignment_5_1 ) ) ;
    public final void rule__RelComp__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3098:1: ( ( ( rule__RelComp__RightAssignment_5_1 ) ) )
            // InternalWorkflow.g:3099:1: ( ( rule__RelComp__RightAssignment_5_1 ) )
            {
            // InternalWorkflow.g:3099:1: ( ( rule__RelComp__RightAssignment_5_1 ) )
            // InternalWorkflow.g:3100:2: ( rule__RelComp__RightAssignment_5_1 )
            {
             before(grammarAccess.getRelCompAccess().getRightAssignment_5_1()); 
            // InternalWorkflow.g:3101:2: ( rule__RelComp__RightAssignment_5_1 )
            // InternalWorkflow.g:3101:3: rule__RelComp__RightAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__RelComp__RightAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getRelCompAccess().getRightAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelComp__Group_5__1__Impl"


    // $ANTLR start "rule__Atom__Group__0"
    // InternalWorkflow.g:3110:1: rule__Atom__Group__0 : rule__Atom__Group__0__Impl rule__Atom__Group__1 ;
    public final void rule__Atom__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3114:1: ( rule__Atom__Group__0__Impl rule__Atom__Group__1 )
            // InternalWorkflow.g:3115:2: rule__Atom__Group__0__Impl rule__Atom__Group__1
            {
            pushFollow(FOLLOW_17);
            rule__Atom__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Atom__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group__0"


    // $ANTLR start "rule__Atom__Group__0__Impl"
    // InternalWorkflow.g:3122:1: rule__Atom__Group__0__Impl : ( () ) ;
    public final void rule__Atom__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3126:1: ( ( () ) )
            // InternalWorkflow.g:3127:1: ( () )
            {
            // InternalWorkflow.g:3127:1: ( () )
            // InternalWorkflow.g:3128:2: ()
            {
             before(grammarAccess.getAtomAccess().getAtomAction_0()); 
            // InternalWorkflow.g:3129:2: ()
            // InternalWorkflow.g:3129:3: 
            {
            }

             after(grammarAccess.getAtomAccess().getAtomAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group__0__Impl"


    // $ANTLR start "rule__Atom__Group__1"
    // InternalWorkflow.g:3137:1: rule__Atom__Group__1 : rule__Atom__Group__1__Impl rule__Atom__Group__2 ;
    public final void rule__Atom__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3141:1: ( rule__Atom__Group__1__Impl rule__Atom__Group__2 )
            // InternalWorkflow.g:3142:2: rule__Atom__Group__1__Impl rule__Atom__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__Atom__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Atom__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group__1"


    // $ANTLR start "rule__Atom__Group__1__Impl"
    // InternalWorkflow.g:3149:1: rule__Atom__Group__1__Impl : ( 'Atom' ) ;
    public final void rule__Atom__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3153:1: ( ( 'Atom' ) )
            // InternalWorkflow.g:3154:1: ( 'Atom' )
            {
            // InternalWorkflow.g:3154:1: ( 'Atom' )
            // InternalWorkflow.g:3155:2: 'Atom'
            {
             before(grammarAccess.getAtomAccess().getAtomKeyword_1()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getAtomAccess().getAtomKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group__1__Impl"


    // $ANTLR start "rule__Atom__Group__2"
    // InternalWorkflow.g:3164:1: rule__Atom__Group__2 : rule__Atom__Group__2__Impl rule__Atom__Group__3 ;
    public final void rule__Atom__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3168:1: ( rule__Atom__Group__2__Impl rule__Atom__Group__3 )
            // InternalWorkflow.g:3169:2: rule__Atom__Group__2__Impl rule__Atom__Group__3
            {
            pushFollow(FOLLOW_30);
            rule__Atom__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Atom__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group__2"


    // $ANTLR start "rule__Atom__Group__2__Impl"
    // InternalWorkflow.g:3176:1: rule__Atom__Group__2__Impl : ( '{' ) ;
    public final void rule__Atom__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3180:1: ( ( '{' ) )
            // InternalWorkflow.g:3181:1: ( '{' )
            {
            // InternalWorkflow.g:3181:1: ( '{' )
            // InternalWorkflow.g:3182:2: '{'
            {
             before(grammarAccess.getAtomAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getAtomAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group__2__Impl"


    // $ANTLR start "rule__Atom__Group__3"
    // InternalWorkflow.g:3191:1: rule__Atom__Group__3 : rule__Atom__Group__3__Impl rule__Atom__Group__4 ;
    public final void rule__Atom__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3195:1: ( rule__Atom__Group__3__Impl rule__Atom__Group__4 )
            // InternalWorkflow.g:3196:2: rule__Atom__Group__3__Impl rule__Atom__Group__4
            {
            pushFollow(FOLLOW_30);
            rule__Atom__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Atom__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group__3"


    // $ANTLR start "rule__Atom__Group__3__Impl"
    // InternalWorkflow.g:3203:1: rule__Atom__Group__3__Impl : ( ( rule__Atom__Group_3__0 )? ) ;
    public final void rule__Atom__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3207:1: ( ( ( rule__Atom__Group_3__0 )? ) )
            // InternalWorkflow.g:3208:1: ( ( rule__Atom__Group_3__0 )? )
            {
            // InternalWorkflow.g:3208:1: ( ( rule__Atom__Group_3__0 )? )
            // InternalWorkflow.g:3209:2: ( rule__Atom__Group_3__0 )?
            {
             before(grammarAccess.getAtomAccess().getGroup_3()); 
            // InternalWorkflow.g:3210:2: ( rule__Atom__Group_3__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==47) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalWorkflow.g:3210:3: rule__Atom__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Atom__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAtomAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group__3__Impl"


    // $ANTLR start "rule__Atom__Group__4"
    // InternalWorkflow.g:3218:1: rule__Atom__Group__4 : rule__Atom__Group__4__Impl ;
    public final void rule__Atom__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3222:1: ( rule__Atom__Group__4__Impl )
            // InternalWorkflow.g:3223:2: rule__Atom__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Atom__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group__4"


    // $ANTLR start "rule__Atom__Group__4__Impl"
    // InternalWorkflow.g:3229:1: rule__Atom__Group__4__Impl : ( '}' ) ;
    public final void rule__Atom__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3233:1: ( ( '}' ) )
            // InternalWorkflow.g:3234:1: ( '}' )
            {
            // InternalWorkflow.g:3234:1: ( '}' )
            // InternalWorkflow.g:3235:2: '}'
            {
             before(grammarAccess.getAtomAccess().getRightCurlyBracketKeyword_4()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getAtomAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group__4__Impl"


    // $ANTLR start "rule__Atom__Group_3__0"
    // InternalWorkflow.g:3245:1: rule__Atom__Group_3__0 : rule__Atom__Group_3__0__Impl rule__Atom__Group_3__1 ;
    public final void rule__Atom__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3249:1: ( rule__Atom__Group_3__0__Impl rule__Atom__Group_3__1 )
            // InternalWorkflow.g:3250:2: rule__Atom__Group_3__0__Impl rule__Atom__Group_3__1
            {
            pushFollow(FOLLOW_11);
            rule__Atom__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Atom__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_3__0"


    // $ANTLR start "rule__Atom__Group_3__0__Impl"
    // InternalWorkflow.g:3257:1: rule__Atom__Group_3__0__Impl : ( 'measureID' ) ;
    public final void rule__Atom__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3261:1: ( ( 'measureID' ) )
            // InternalWorkflow.g:3262:1: ( 'measureID' )
            {
            // InternalWorkflow.g:3262:1: ( 'measureID' )
            // InternalWorkflow.g:3263:2: 'measureID'
            {
             before(grammarAccess.getAtomAccess().getMeasureIDKeyword_3_0()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getAtomAccess().getMeasureIDKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_3__0__Impl"


    // $ANTLR start "rule__Atom__Group_3__1"
    // InternalWorkflow.g:3272:1: rule__Atom__Group_3__1 : rule__Atom__Group_3__1__Impl ;
    public final void rule__Atom__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3276:1: ( rule__Atom__Group_3__1__Impl )
            // InternalWorkflow.g:3277:2: rule__Atom__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Atom__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_3__1"


    // $ANTLR start "rule__Atom__Group_3__1__Impl"
    // InternalWorkflow.g:3283:1: rule__Atom__Group_3__1__Impl : ( ( rule__Atom__MeasureIDAssignment_3_1 ) ) ;
    public final void rule__Atom__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3287:1: ( ( ( rule__Atom__MeasureIDAssignment_3_1 ) ) )
            // InternalWorkflow.g:3288:1: ( ( rule__Atom__MeasureIDAssignment_3_1 ) )
            {
            // InternalWorkflow.g:3288:1: ( ( rule__Atom__MeasureIDAssignment_3_1 ) )
            // InternalWorkflow.g:3289:2: ( rule__Atom__MeasureIDAssignment_3_1 )
            {
             before(grammarAccess.getAtomAccess().getMeasureIDAssignment_3_1()); 
            // InternalWorkflow.g:3290:2: ( rule__Atom__MeasureIDAssignment_3_1 )
            // InternalWorkflow.g:3290:3: rule__Atom__MeasureIDAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Atom__MeasureIDAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getAtomAccess().getMeasureIDAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_3__1__Impl"


    // $ANTLR start "rule__EInt__Group__0"
    // InternalWorkflow.g:3299:1: rule__EInt__Group__0 : rule__EInt__Group__0__Impl rule__EInt__Group__1 ;
    public final void rule__EInt__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3303:1: ( rule__EInt__Group__0__Impl rule__EInt__Group__1 )
            // InternalWorkflow.g:3304:2: rule__EInt__Group__0__Impl rule__EInt__Group__1
            {
            pushFollow(FOLLOW_21);
            rule__EInt__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EInt__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__0"


    // $ANTLR start "rule__EInt__Group__0__Impl"
    // InternalWorkflow.g:3311:1: rule__EInt__Group__0__Impl : ( ( '-' )? ) ;
    public final void rule__EInt__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3315:1: ( ( ( '-' )? ) )
            // InternalWorkflow.g:3316:1: ( ( '-' )? )
            {
            // InternalWorkflow.g:3316:1: ( ( '-' )? )
            // InternalWorkflow.g:3317:2: ( '-' )?
            {
             before(grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
            // InternalWorkflow.g:3318:2: ( '-' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==48) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalWorkflow.g:3318:3: '-'
                    {
                    match(input,48,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__0__Impl"


    // $ANTLR start "rule__EInt__Group__1"
    // InternalWorkflow.g:3326:1: rule__EInt__Group__1 : rule__EInt__Group__1__Impl ;
    public final void rule__EInt__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3330:1: ( rule__EInt__Group__1__Impl )
            // InternalWorkflow.g:3331:2: rule__EInt__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EInt__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__1"


    // $ANTLR start "rule__EInt__Group__1__Impl"
    // InternalWorkflow.g:3337:1: rule__EInt__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__EInt__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3341:1: ( ( RULE_INT ) )
            // InternalWorkflow.g:3342:1: ( RULE_INT )
            {
            // InternalWorkflow.g:3342:1: ( RULE_INT )
            // InternalWorkflow.g:3343:2: RULE_INT
            {
             before(grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__1__Impl"


    // $ANTLR start "rule__WorkflowStructure__WorkflowspecAssignment_3"
    // InternalWorkflow.g:3353:1: rule__WorkflowStructure__WorkflowspecAssignment_3 : ( ruleWorkflow ) ;
    public final void rule__WorkflowStructure__WorkflowspecAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3357:1: ( ( ruleWorkflow ) )
            // InternalWorkflow.g:3358:2: ( ruleWorkflow )
            {
            // InternalWorkflow.g:3358:2: ( ruleWorkflow )
            // InternalWorkflow.g:3359:3: ruleWorkflow
            {
             before(grammarAccess.getWorkflowStructureAccess().getWorkflowspecWorkflowParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleWorkflow();

            state._fsp--;

             after(grammarAccess.getWorkflowStructureAccess().getWorkflowspecWorkflowParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WorkflowStructure__WorkflowspecAssignment_3"


    // $ANTLR start "rule__Sequence__SubworkflowsAssignment_4"
    // InternalWorkflow.g:3368:1: rule__Sequence__SubworkflowsAssignment_4 : ( ruleWorkflow ) ;
    public final void rule__Sequence__SubworkflowsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3372:1: ( ( ruleWorkflow ) )
            // InternalWorkflow.g:3373:2: ( ruleWorkflow )
            {
            // InternalWorkflow.g:3373:2: ( ruleWorkflow )
            // InternalWorkflow.g:3374:3: ruleWorkflow
            {
             before(grammarAccess.getSequenceAccess().getSubworkflowsWorkflowParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleWorkflow();

            state._fsp--;

             after(grammarAccess.getSequenceAccess().getSubworkflowsWorkflowParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__SubworkflowsAssignment_4"


    // $ANTLR start "rule__Sequence__SubworkflowsAssignment_5_1"
    // InternalWorkflow.g:3383:1: rule__Sequence__SubworkflowsAssignment_5_1 : ( ruleWorkflow ) ;
    public final void rule__Sequence__SubworkflowsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3387:1: ( ( ruleWorkflow ) )
            // InternalWorkflow.g:3388:2: ( ruleWorkflow )
            {
            // InternalWorkflow.g:3388:2: ( ruleWorkflow )
            // InternalWorkflow.g:3389:3: ruleWorkflow
            {
             before(grammarAccess.getSequenceAccess().getSubworkflowsWorkflowParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleWorkflow();

            state._fsp--;

             after(grammarAccess.getSequenceAccess().getSubworkflowsWorkflowParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__SubworkflowsAssignment_5_1"


    // $ANTLR start "rule__Task__IDAssignment_3"
    // InternalWorkflow.g:3398:1: rule__Task__IDAssignment_3 : ( ruleEString ) ;
    public final void rule__Task__IDAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3402:1: ( ( ruleEString ) )
            // InternalWorkflow.g:3403:2: ( ruleEString )
            {
            // InternalWorkflow.g:3403:2: ( ruleEString )
            // InternalWorkflow.g:3404:3: ruleEString
            {
             before(grammarAccess.getTaskAccess().getIDEStringParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTaskAccess().getIDEStringParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__IDAssignment_3"


    // $ANTLR start "rule__Loop__LoopAssignment_3"
    // InternalWorkflow.g:3413:1: rule__Loop__LoopAssignment_3 : ( ruleGuardedWorkflow ) ;
    public final void rule__Loop__LoopAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3417:1: ( ( ruleGuardedWorkflow ) )
            // InternalWorkflow.g:3418:2: ( ruleGuardedWorkflow )
            {
            // InternalWorkflow.g:3418:2: ( ruleGuardedWorkflow )
            // InternalWorkflow.g:3419:3: ruleGuardedWorkflow
            {
             before(grammarAccess.getLoopAccess().getLoopGuardedWorkflowParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleGuardedWorkflow();

            state._fsp--;

             after(grammarAccess.getLoopAccess().getLoopGuardedWorkflowParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__LoopAssignment_3"


    // $ANTLR start "rule__Decision__OptionsAssignment_4"
    // InternalWorkflow.g:3428:1: rule__Decision__OptionsAssignment_4 : ( ruleGuardedWorkflow ) ;
    public final void rule__Decision__OptionsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3432:1: ( ( ruleGuardedWorkflow ) )
            // InternalWorkflow.g:3433:2: ( ruleGuardedWorkflow )
            {
            // InternalWorkflow.g:3433:2: ( ruleGuardedWorkflow )
            // InternalWorkflow.g:3434:3: ruleGuardedWorkflow
            {
             before(grammarAccess.getDecisionAccess().getOptionsGuardedWorkflowParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleGuardedWorkflow();

            state._fsp--;

             after(grammarAccess.getDecisionAccess().getOptionsGuardedWorkflowParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decision__OptionsAssignment_4"


    // $ANTLR start "rule__Decision__OptionsAssignment_5_1"
    // InternalWorkflow.g:3443:1: rule__Decision__OptionsAssignment_5_1 : ( ruleGuardedWorkflow ) ;
    public final void rule__Decision__OptionsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3447:1: ( ( ruleGuardedWorkflow ) )
            // InternalWorkflow.g:3448:2: ( ruleGuardedWorkflow )
            {
            // InternalWorkflow.g:3448:2: ( ruleGuardedWorkflow )
            // InternalWorkflow.g:3449:3: ruleGuardedWorkflow
            {
             before(grammarAccess.getDecisionAccess().getOptionsGuardedWorkflowParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleGuardedWorkflow();

            state._fsp--;

             after(grammarAccess.getDecisionAccess().getOptionsGuardedWorkflowParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decision__OptionsAssignment_5_1"


    // $ANTLR start "rule__GuardedWorkflow__BodyAssignment_3"
    // InternalWorkflow.g:3458:1: rule__GuardedWorkflow__BodyAssignment_3 : ( ruleWorkflow ) ;
    public final void rule__GuardedWorkflow__BodyAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3462:1: ( ( ruleWorkflow ) )
            // InternalWorkflow.g:3463:2: ( ruleWorkflow )
            {
            // InternalWorkflow.g:3463:2: ( ruleWorkflow )
            // InternalWorkflow.g:3464:3: ruleWorkflow
            {
             before(grammarAccess.getGuardedWorkflowAccess().getBodyWorkflowParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleWorkflow();

            state._fsp--;

             after(grammarAccess.getGuardedWorkflowAccess().getBodyWorkflowParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GuardedWorkflow__BodyAssignment_3"


    // $ANTLR start "rule__GuardedWorkflow__GuardAssignment_5"
    // InternalWorkflow.g:3473:1: rule__GuardedWorkflow__GuardAssignment_5 : ( ruleMBoolExpr ) ;
    public final void rule__GuardedWorkflow__GuardAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3477:1: ( ( ruleMBoolExpr ) )
            // InternalWorkflow.g:3478:2: ( ruleMBoolExpr )
            {
            // InternalWorkflow.g:3478:2: ( ruleMBoolExpr )
            // InternalWorkflow.g:3479:3: ruleMBoolExpr
            {
             before(grammarAccess.getGuardedWorkflowAccess().getGuardMBoolExprParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleMBoolExpr();

            state._fsp--;

             after(grammarAccess.getGuardedWorkflowAccess().getGuardMBoolExprParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GuardedWorkflow__GuardAssignment_5"


    // $ANTLR start "rule__Value__ValueAssignment_3_1"
    // InternalWorkflow.g:3488:1: rule__Value__ValueAssignment_3_1 : ( ruleEInt ) ;
    public final void rule__Value__ValueAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3492:1: ( ( ruleEInt ) )
            // InternalWorkflow.g:3493:2: ( ruleEInt )
            {
            // InternalWorkflow.g:3493:2: ( ruleEInt )
            // InternalWorkflow.g:3494:3: ruleEInt
            {
             before(grammarAccess.getValueAccess().getValueEIntParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getValueAccess().getValueEIntParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__ValueAssignment_3_1"


    // $ANTLR start "rule__BoolValue__ValueAssignment_1"
    // InternalWorkflow.g:3503:1: rule__BoolValue__ValueAssignment_1 : ( ( 'value' ) ) ;
    public final void rule__BoolValue__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3507:1: ( ( ( 'value' ) ) )
            // InternalWorkflow.g:3508:2: ( ( 'value' ) )
            {
            // InternalWorkflow.g:3508:2: ( ( 'value' ) )
            // InternalWorkflow.g:3509:3: ( 'value' )
            {
             before(grammarAccess.getBoolValueAccess().getValueValueKeyword_1_0()); 
            // InternalWorkflow.g:3510:3: ( 'value' )
            // InternalWorkflow.g:3511:4: 'value'
            {
             before(grammarAccess.getBoolValueAccess().getValueValueKeyword_1_0()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getBoolValueAccess().getValueValueKeyword_1_0()); 

            }

             after(grammarAccess.getBoolValueAccess().getValueValueKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolValue__ValueAssignment_1"


    // $ANTLR start "rule__BoolComp__OpAssignment_3_1"
    // InternalWorkflow.g:3522:1: rule__BoolComp__OpAssignment_3_1 : ( ruleBoolOp ) ;
    public final void rule__BoolComp__OpAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3526:1: ( ( ruleBoolOp ) )
            // InternalWorkflow.g:3527:2: ( ruleBoolOp )
            {
            // InternalWorkflow.g:3527:2: ( ruleBoolOp )
            // InternalWorkflow.g:3528:3: ruleBoolOp
            {
             before(grammarAccess.getBoolCompAccess().getOpBoolOpEnumRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleBoolOp();

            state._fsp--;

             after(grammarAccess.getBoolCompAccess().getOpBoolOpEnumRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolComp__OpAssignment_3_1"


    // $ANTLR start "rule__BoolComp__RightAssignment_4_1"
    // InternalWorkflow.g:3537:1: rule__BoolComp__RightAssignment_4_1 : ( ruleMBoolExpr ) ;
    public final void rule__BoolComp__RightAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3541:1: ( ( ruleMBoolExpr ) )
            // InternalWorkflow.g:3542:2: ( ruleMBoolExpr )
            {
            // InternalWorkflow.g:3542:2: ( ruleMBoolExpr )
            // InternalWorkflow.g:3543:3: ruleMBoolExpr
            {
             before(grammarAccess.getBoolCompAccess().getRightMBoolExprParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMBoolExpr();

            state._fsp--;

             after(grammarAccess.getBoolCompAccess().getRightMBoolExprParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolComp__RightAssignment_4_1"


    // $ANTLR start "rule__BoolComp__LeftAssignment_5_1"
    // InternalWorkflow.g:3552:1: rule__BoolComp__LeftAssignment_5_1 : ( ruleMBoolExpr ) ;
    public final void rule__BoolComp__LeftAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3556:1: ( ( ruleMBoolExpr ) )
            // InternalWorkflow.g:3557:2: ( ruleMBoolExpr )
            {
            // InternalWorkflow.g:3557:2: ( ruleMBoolExpr )
            // InternalWorkflow.g:3558:3: ruleMBoolExpr
            {
             before(grammarAccess.getBoolCompAccess().getLeftMBoolExprParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMBoolExpr();

            state._fsp--;

             after(grammarAccess.getBoolCompAccess().getLeftMBoolExprParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolComp__LeftAssignment_5_1"


    // $ANTLR start "rule__Not__OpAssignment_3_1"
    // InternalWorkflow.g:3567:1: rule__Not__OpAssignment_3_1 : ( ruleEString ) ;
    public final void rule__Not__OpAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3571:1: ( ( ruleEString ) )
            // InternalWorkflow.g:3572:2: ( ruleEString )
            {
            // InternalWorkflow.g:3572:2: ( ruleEString )
            // InternalWorkflow.g:3573:3: ruleEString
            {
             before(grammarAccess.getNotAccess().getOpEStringParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getNotAccess().getOpEStringParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__OpAssignment_3_1"


    // $ANTLR start "rule__Not__ExprAssignment_4_1"
    // InternalWorkflow.g:3582:1: rule__Not__ExprAssignment_4_1 : ( ruleMBoolExpr ) ;
    public final void rule__Not__ExprAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3586:1: ( ( ruleMBoolExpr ) )
            // InternalWorkflow.g:3587:2: ( ruleMBoolExpr )
            {
            // InternalWorkflow.g:3587:2: ( ruleMBoolExpr )
            // InternalWorkflow.g:3588:3: ruleMBoolExpr
            {
             before(grammarAccess.getNotAccess().getExprMBoolExprParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMBoolExpr();

            state._fsp--;

             after(grammarAccess.getNotAccess().getExprMBoolExprParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Not__ExprAssignment_4_1"


    // $ANTLR start "rule__RelComp__OpAssignment_3_1"
    // InternalWorkflow.g:3597:1: rule__RelComp__OpAssignment_3_1 : ( ruleRelOp ) ;
    public final void rule__RelComp__OpAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3601:1: ( ( ruleRelOp ) )
            // InternalWorkflow.g:3602:2: ( ruleRelOp )
            {
            // InternalWorkflow.g:3602:2: ( ruleRelOp )
            // InternalWorkflow.g:3603:3: ruleRelOp
            {
             before(grammarAccess.getRelCompAccess().getOpRelOpEnumRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleRelOp();

            state._fsp--;

             after(grammarAccess.getRelCompAccess().getOpRelOpEnumRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelComp__OpAssignment_3_1"


    // $ANTLR start "rule__RelComp__LeftAssignment_4_1"
    // InternalWorkflow.g:3612:1: rule__RelComp__LeftAssignment_4_1 : ( ruleMBoolExpr ) ;
    public final void rule__RelComp__LeftAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3616:1: ( ( ruleMBoolExpr ) )
            // InternalWorkflow.g:3617:2: ( ruleMBoolExpr )
            {
            // InternalWorkflow.g:3617:2: ( ruleMBoolExpr )
            // InternalWorkflow.g:3618:3: ruleMBoolExpr
            {
             before(grammarAccess.getRelCompAccess().getLeftMBoolExprParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMBoolExpr();

            state._fsp--;

             after(grammarAccess.getRelCompAccess().getLeftMBoolExprParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelComp__LeftAssignment_4_1"


    // $ANTLR start "rule__RelComp__RightAssignment_5_1"
    // InternalWorkflow.g:3627:1: rule__RelComp__RightAssignment_5_1 : ( ruleMBoolExpr ) ;
    public final void rule__RelComp__RightAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3631:1: ( ( ruleMBoolExpr ) )
            // InternalWorkflow.g:3632:2: ( ruleMBoolExpr )
            {
            // InternalWorkflow.g:3632:2: ( ruleMBoolExpr )
            // InternalWorkflow.g:3633:3: ruleMBoolExpr
            {
             before(grammarAccess.getRelCompAccess().getRightMBoolExprParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMBoolExpr();

            state._fsp--;

             after(grammarAccess.getRelCompAccess().getRightMBoolExprParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelComp__RightAssignment_5_1"


    // $ANTLR start "rule__Atom__MeasureIDAssignment_3_1"
    // InternalWorkflow.g:3642:1: rule__Atom__MeasureIDAssignment_3_1 : ( ruleEString ) ;
    public final void rule__Atom__MeasureIDAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalWorkflow.g:3646:1: ( ( ruleEString ) )
            // InternalWorkflow.g:3647:2: ( ruleEString )
            {
            // InternalWorkflow.g:3647:2: ( ruleEString )
            // InternalWorkflow.g:3648:3: ruleEString
            {
             before(grammarAccess.getAtomAccess().getMeasureIDEStringParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAtomAccess().getMeasureIDEStringParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__MeasureIDAssignment_3_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000054800000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000002400000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x000068F800000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000002000400000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0001000000000040L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000006000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000070000400000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000110000400000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x000000000007E000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000800000400000L});

}