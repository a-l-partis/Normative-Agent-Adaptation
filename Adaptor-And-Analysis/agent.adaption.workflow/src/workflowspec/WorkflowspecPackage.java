/**
 */
package workflowspec;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see workflowspec.WorkflowspecFactory
 * @model kind="package"
 * @generated
 */
public interface WorkflowspecPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "workflowspec";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/workflowspec";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "agent.adaption.xtext.workflow.workflowspec";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WorkflowspecPackage eINSTANCE = workflowspec.impl.WorkflowspecPackageImpl.init();

	/**
	 * The meta object id for the '{@link workflowspec.impl.WorkflowStructureImpl <em>Workflow Structure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflowspec.impl.WorkflowStructureImpl
	 * @see workflowspec.impl.WorkflowspecPackageImpl#getWorkflowStructure()
	 * @generated
	 */
	int WORKFLOW_STRUCTURE = 0;

	/**
	 * The feature id for the '<em><b>Workflowspec</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW_STRUCTURE__WORKFLOWSPEC = 0;

	/**
	 * The number of structural features of the '<em>Workflow Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW_STRUCTURE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Workflow Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW_STRUCTURE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link workflowspec.impl.WorkflowImpl <em>Workflow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflowspec.impl.WorkflowImpl
	 * @see workflowspec.impl.WorkflowspecPackageImpl#getWorkflow()
	 * @generated
	 */
	int WORKFLOW = 1;

	/**
	 * The number of structural features of the '<em>Workflow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Workflow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link workflowspec.impl.SequenceImpl <em>Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflowspec.impl.SequenceImpl
	 * @see workflowspec.impl.WorkflowspecPackageImpl#getSequence()
	 * @generated
	 */
	int SEQUENCE = 2;

	/**
	 * The feature id for the '<em><b>Subworkflows</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__SUBWORKFLOWS = WORKFLOW_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FEATURE_COUNT = WORKFLOW_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_OPERATION_COUNT = WORKFLOW_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link workflowspec.impl.TaskImpl <em>Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflowspec.impl.TaskImpl
	 * @see workflowspec.impl.WorkflowspecPackageImpl#getTask()
	 * @generated
	 */
	int TASK = 3;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__ID = WORKFLOW_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_FEATURE_COUNT = WORKFLOW_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_OPERATION_COUNT = WORKFLOW_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link workflowspec.impl.LoopImpl <em>Loop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflowspec.impl.LoopImpl
	 * @see workflowspec.impl.WorkflowspecPackageImpl#getLoop()
	 * @generated
	 */
	int LOOP = 4;

	/**
	 * The feature id for the '<em><b>Loop</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__LOOP = WORKFLOW_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_FEATURE_COUNT = WORKFLOW_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_OPERATION_COUNT = WORKFLOW_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link workflowspec.impl.DecisionImpl <em>Decision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflowspec.impl.DecisionImpl
	 * @see workflowspec.impl.WorkflowspecPackageImpl#getDecision()
	 * @generated
	 */
	int DECISION = 5;

	/**
	 * The feature id for the '<em><b>Options</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION__OPTIONS = WORKFLOW_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Decision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_FEATURE_COUNT = WORKFLOW_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Decision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_OPERATION_COUNT = WORKFLOW_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link workflowspec.impl.GuardedWorkflowImpl <em>Guarded Workflow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflowspec.impl.GuardedWorkflowImpl
	 * @see workflowspec.impl.WorkflowspecPackageImpl#getGuardedWorkflow()
	 * @generated
	 */
	int GUARDED_WORKFLOW = 6;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARDED_WORKFLOW__BODY = 0;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARDED_WORKFLOW__GUARD = 1;

	/**
	 * The number of structural features of the '<em>Guarded Workflow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARDED_WORKFLOW_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Guarded Workflow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARDED_WORKFLOW_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link workflowspec.impl.MBoolExprImpl <em>MBool Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflowspec.impl.MBoolExprImpl
	 * @see workflowspec.impl.WorkflowspecPackageImpl#getMBoolExpr()
	 * @generated
	 */
	int MBOOL_EXPR = 7;

	/**
	 * The number of structural features of the '<em>MBool Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MBOOL_EXPR_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>MBool Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MBOOL_EXPR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link workflowspec.impl.ValueImpl <em>Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflowspec.impl.ValueImpl
	 * @see workflowspec.impl.WorkflowspecPackageImpl#getValue()
	 * @generated
	 */
	int VALUE = 8;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__VALUE = MBOOL_EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FEATURE_COUNT = MBOOL_EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_OPERATION_COUNT = MBOOL_EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link workflowspec.impl.BoolValueImpl <em>Bool Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflowspec.impl.BoolValueImpl
	 * @see workflowspec.impl.WorkflowspecPackageImpl#getBoolValue()
	 * @generated
	 */
	int BOOL_VALUE = 9;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_VALUE__VALUE = MBOOL_EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Bool Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_VALUE_FEATURE_COUNT = MBOOL_EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Bool Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_VALUE_OPERATION_COUNT = MBOOL_EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link workflowspec.impl.BoolCompImpl <em>Bool Comp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflowspec.impl.BoolCompImpl
	 * @see workflowspec.impl.WorkflowspecPackageImpl#getBoolComp()
	 * @generated
	 */
	int BOOL_COMP = 10;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_COMP__OP = MBOOL_EXPR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_COMP__RIGHT = MBOOL_EXPR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_COMP__LEFT = MBOOL_EXPR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Bool Comp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_COMP_FEATURE_COUNT = MBOOL_EXPR_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Bool Comp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_COMP_OPERATION_COUNT = MBOOL_EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link workflowspec.impl.NotImpl <em>Not</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflowspec.impl.NotImpl
	 * @see workflowspec.impl.WorkflowspecPackageImpl#getNot()
	 * @generated
	 */
	int NOT = 11;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__OP = MBOOL_EXPR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__EXPR = MBOOL_EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Not</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_FEATURE_COUNT = MBOOL_EXPR_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Not</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_OPERATION_COUNT = MBOOL_EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link workflowspec.impl.RelCompImpl <em>Rel Comp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflowspec.impl.RelCompImpl
	 * @see workflowspec.impl.WorkflowspecPackageImpl#getRelComp()
	 * @generated
	 */
	int REL_COMP = 12;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_COMP__OP = MBOOL_EXPR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_COMP__LEFT = MBOOL_EXPR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_COMP__RIGHT = MBOOL_EXPR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Rel Comp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_COMP_FEATURE_COUNT = MBOOL_EXPR_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Rel Comp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_COMP_OPERATION_COUNT = MBOOL_EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link workflowspec.impl.AtomImpl <em>Atom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflowspec.impl.AtomImpl
	 * @see workflowspec.impl.WorkflowspecPackageImpl#getAtom()
	 * @generated
	 */
	int ATOM = 13;

	/**
	 * The feature id for the '<em><b>Measure ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOM__MEASURE_ID = MBOOL_EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Atom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOM_FEATURE_COUNT = MBOOL_EXPR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Atom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOM_OPERATION_COUNT = MBOOL_EXPR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link workflowspec.BoolOp <em>Bool Op</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflowspec.BoolOp
	 * @see workflowspec.impl.WorkflowspecPackageImpl#getBoolOp()
	 * @generated
	 */
	int BOOL_OP = 14;

	/**
	 * The meta object id for the '{@link workflowspec.RelOp <em>Rel Op</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflowspec.RelOp
	 * @see workflowspec.impl.WorkflowspecPackageImpl#getRelOp()
	 * @generated
	 */
	int REL_OP = 15;

	/**
	 * The meta object id for the '{@link workflowspec.TimeUnit <em>Time Unit</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see workflowspec.TimeUnit
	 * @see workflowspec.impl.WorkflowspecPackageImpl#getTimeUnit()
	 * @generated
	 */
	int TIME_UNIT = 16;


	/**
	 * Returns the meta object for class '{@link workflowspec.WorkflowStructure <em>Workflow Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Workflow Structure</em>'.
	 * @see workflowspec.WorkflowStructure
	 * @generated
	 */
	EClass getWorkflowStructure();

	/**
	 * Returns the meta object for the containment reference '{@link workflowspec.WorkflowStructure#getWorkflowspec <em>Workflowspec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Workflowspec</em>'.
	 * @see workflowspec.WorkflowStructure#getWorkflowspec()
	 * @see #getWorkflowStructure()
	 * @generated
	 */
	EReference getWorkflowStructure_Workflowspec();

	/**
	 * Returns the meta object for class '{@link workflowspec.Workflow <em>Workflow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Workflow</em>'.
	 * @see workflowspec.Workflow
	 * @generated
	 */
	EClass getWorkflow();

	/**
	 * Returns the meta object for class '{@link workflowspec.Sequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence</em>'.
	 * @see workflowspec.Sequence
	 * @generated
	 */
	EClass getSequence();

	/**
	 * Returns the meta object for the containment reference list '{@link workflowspec.Sequence#getSubworkflows <em>Subworkflows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subworkflows</em>'.
	 * @see workflowspec.Sequence#getSubworkflows()
	 * @see #getSequence()
	 * @generated
	 */
	EReference getSequence_Subworkflows();

	/**
	 * Returns the meta object for class '{@link workflowspec.Task <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task</em>'.
	 * @see workflowspec.Task
	 * @generated
	 */
	EClass getTask();

	/**
	 * Returns the meta object for the attribute '{@link workflowspec.Task#getID <em>ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ID</em>'.
	 * @see workflowspec.Task#getID()
	 * @see #getTask()
	 * @generated
	 */
	EAttribute getTask_ID();

	/**
	 * Returns the meta object for class '{@link workflowspec.Loop <em>Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop</em>'.
	 * @see workflowspec.Loop
	 * @generated
	 */
	EClass getLoop();

	/**
	 * Returns the meta object for the containment reference '{@link workflowspec.Loop#getLoop <em>Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Loop</em>'.
	 * @see workflowspec.Loop#getLoop()
	 * @see #getLoop()
	 * @generated
	 */
	EReference getLoop_Loop();

	/**
	 * Returns the meta object for class '{@link workflowspec.Decision <em>Decision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Decision</em>'.
	 * @see workflowspec.Decision
	 * @generated
	 */
	EClass getDecision();

	/**
	 * Returns the meta object for the containment reference list '{@link workflowspec.Decision#getOptions <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Options</em>'.
	 * @see workflowspec.Decision#getOptions()
	 * @see #getDecision()
	 * @generated
	 */
	EReference getDecision_Options();

	/**
	 * Returns the meta object for class '{@link workflowspec.GuardedWorkflow <em>Guarded Workflow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guarded Workflow</em>'.
	 * @see workflowspec.GuardedWorkflow
	 * @generated
	 */
	EClass getGuardedWorkflow();

	/**
	 * Returns the meta object for the containment reference '{@link workflowspec.GuardedWorkflow#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see workflowspec.GuardedWorkflow#getBody()
	 * @see #getGuardedWorkflow()
	 * @generated
	 */
	EReference getGuardedWorkflow_Body();

	/**
	 * Returns the meta object for the containment reference '{@link workflowspec.GuardedWorkflow#getGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Guard</em>'.
	 * @see workflowspec.GuardedWorkflow#getGuard()
	 * @see #getGuardedWorkflow()
	 * @generated
	 */
	EReference getGuardedWorkflow_Guard();

	/**
	 * Returns the meta object for class '{@link workflowspec.MBoolExpr <em>MBool Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MBool Expr</em>'.
	 * @see workflowspec.MBoolExpr
	 * @generated
	 */
	EClass getMBoolExpr();

	/**
	 * Returns the meta object for class '{@link workflowspec.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value</em>'.
	 * @see workflowspec.Value
	 * @generated
	 */
	EClass getValue();

	/**
	 * Returns the meta object for the attribute '{@link workflowspec.Value#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see workflowspec.Value#getValue()
	 * @see #getValue()
	 * @generated
	 */
	EAttribute getValue_Value();

	/**
	 * Returns the meta object for class '{@link workflowspec.BoolValue <em>Bool Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bool Value</em>'.
	 * @see workflowspec.BoolValue
	 * @generated
	 */
	EClass getBoolValue();

	/**
	 * Returns the meta object for the attribute '{@link workflowspec.BoolValue#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see workflowspec.BoolValue#isValue()
	 * @see #getBoolValue()
	 * @generated
	 */
	EAttribute getBoolValue_Value();

	/**
	 * Returns the meta object for class '{@link workflowspec.BoolComp <em>Bool Comp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bool Comp</em>'.
	 * @see workflowspec.BoolComp
	 * @generated
	 */
	EClass getBoolComp();

	/**
	 * Returns the meta object for the attribute '{@link workflowspec.BoolComp#getOp <em>Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Op</em>'.
	 * @see workflowspec.BoolComp#getOp()
	 * @see #getBoolComp()
	 * @generated
	 */
	EAttribute getBoolComp_Op();

	/**
	 * Returns the meta object for the containment reference '{@link workflowspec.BoolComp#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see workflowspec.BoolComp#getRight()
	 * @see #getBoolComp()
	 * @generated
	 */
	EReference getBoolComp_Right();

	/**
	 * Returns the meta object for the containment reference '{@link workflowspec.BoolComp#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see workflowspec.BoolComp#getLeft()
	 * @see #getBoolComp()
	 * @generated
	 */
	EReference getBoolComp_Left();

	/**
	 * Returns the meta object for class '{@link workflowspec.Not <em>Not</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not</em>'.
	 * @see workflowspec.Not
	 * @generated
	 */
	EClass getNot();

	/**
	 * Returns the meta object for the attribute '{@link workflowspec.Not#getOp <em>Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Op</em>'.
	 * @see workflowspec.Not#getOp()
	 * @see #getNot()
	 * @generated
	 */
	EAttribute getNot_Op();

	/**
	 * Returns the meta object for the containment reference '{@link workflowspec.Not#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expr</em>'.
	 * @see workflowspec.Not#getExpr()
	 * @see #getNot()
	 * @generated
	 */
	EReference getNot_Expr();

	/**
	 * Returns the meta object for class '{@link workflowspec.RelComp <em>Rel Comp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rel Comp</em>'.
	 * @see workflowspec.RelComp
	 * @generated
	 */
	EClass getRelComp();

	/**
	 * Returns the meta object for the attribute '{@link workflowspec.RelComp#getOp <em>Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Op</em>'.
	 * @see workflowspec.RelComp#getOp()
	 * @see #getRelComp()
	 * @generated
	 */
	EAttribute getRelComp_Op();

	/**
	 * Returns the meta object for the containment reference '{@link workflowspec.RelComp#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see workflowspec.RelComp#getLeft()
	 * @see #getRelComp()
	 * @generated
	 */
	EReference getRelComp_Left();

	/**
	 * Returns the meta object for the containment reference '{@link workflowspec.RelComp#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see workflowspec.RelComp#getRight()
	 * @see #getRelComp()
	 * @generated
	 */
	EReference getRelComp_Right();

	/**
	 * Returns the meta object for class '{@link workflowspec.Atom <em>Atom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Atom</em>'.
	 * @see workflowspec.Atom
	 * @generated
	 */
	EClass getAtom();

	/**
	 * Returns the meta object for the attribute '{@link workflowspec.Atom#getMeasureID <em>Measure ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Measure ID</em>'.
	 * @see workflowspec.Atom#getMeasureID()
	 * @see #getAtom()
	 * @generated
	 */
	EAttribute getAtom_MeasureID();

	/**
	 * Returns the meta object for enum '{@link workflowspec.BoolOp <em>Bool Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Bool Op</em>'.
	 * @see workflowspec.BoolOp
	 * @generated
	 */
	EEnum getBoolOp();

	/**
	 * Returns the meta object for enum '{@link workflowspec.RelOp <em>Rel Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Rel Op</em>'.
	 * @see workflowspec.RelOp
	 * @generated
	 */
	EEnum getRelOp();

	/**
	 * Returns the meta object for enum '{@link workflowspec.TimeUnit <em>Time Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Time Unit</em>'.
	 * @see workflowspec.TimeUnit
	 * @generated
	 */
	EEnum getTimeUnit();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WorkflowspecFactory getWorkflowspecFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link workflowspec.impl.WorkflowStructureImpl <em>Workflow Structure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflowspec.impl.WorkflowStructureImpl
		 * @see workflowspec.impl.WorkflowspecPackageImpl#getWorkflowStructure()
		 * @generated
		 */
		EClass WORKFLOW_STRUCTURE = eINSTANCE.getWorkflowStructure();

		/**
		 * The meta object literal for the '<em><b>Workflowspec</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKFLOW_STRUCTURE__WORKFLOWSPEC = eINSTANCE.getWorkflowStructure_Workflowspec();

		/**
		 * The meta object literal for the '{@link workflowspec.impl.WorkflowImpl <em>Workflow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflowspec.impl.WorkflowImpl
		 * @see workflowspec.impl.WorkflowspecPackageImpl#getWorkflow()
		 * @generated
		 */
		EClass WORKFLOW = eINSTANCE.getWorkflow();

		/**
		 * The meta object literal for the '{@link workflowspec.impl.SequenceImpl <em>Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflowspec.impl.SequenceImpl
		 * @see workflowspec.impl.WorkflowspecPackageImpl#getSequence()
		 * @generated
		 */
		EClass SEQUENCE = eINSTANCE.getSequence();

		/**
		 * The meta object literal for the '<em><b>Subworkflows</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE__SUBWORKFLOWS = eINSTANCE.getSequence_Subworkflows();

		/**
		 * The meta object literal for the '{@link workflowspec.impl.TaskImpl <em>Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflowspec.impl.TaskImpl
		 * @see workflowspec.impl.WorkflowspecPackageImpl#getTask()
		 * @generated
		 */
		EClass TASK = eINSTANCE.getTask();

		/**
		 * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK__ID = eINSTANCE.getTask_ID();

		/**
		 * The meta object literal for the '{@link workflowspec.impl.LoopImpl <em>Loop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflowspec.impl.LoopImpl
		 * @see workflowspec.impl.WorkflowspecPackageImpl#getLoop()
		 * @generated
		 */
		EClass LOOP = eINSTANCE.getLoop();

		/**
		 * The meta object literal for the '<em><b>Loop</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP__LOOP = eINSTANCE.getLoop_Loop();

		/**
		 * The meta object literal for the '{@link workflowspec.impl.DecisionImpl <em>Decision</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflowspec.impl.DecisionImpl
		 * @see workflowspec.impl.WorkflowspecPackageImpl#getDecision()
		 * @generated
		 */
		EClass DECISION = eINSTANCE.getDecision();

		/**
		 * The meta object literal for the '<em><b>Options</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECISION__OPTIONS = eINSTANCE.getDecision_Options();

		/**
		 * The meta object literal for the '{@link workflowspec.impl.GuardedWorkflowImpl <em>Guarded Workflow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflowspec.impl.GuardedWorkflowImpl
		 * @see workflowspec.impl.WorkflowspecPackageImpl#getGuardedWorkflow()
		 * @generated
		 */
		EClass GUARDED_WORKFLOW = eINSTANCE.getGuardedWorkflow();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUARDED_WORKFLOW__BODY = eINSTANCE.getGuardedWorkflow_Body();

		/**
		 * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUARDED_WORKFLOW__GUARD = eINSTANCE.getGuardedWorkflow_Guard();

		/**
		 * The meta object literal for the '{@link workflowspec.impl.MBoolExprImpl <em>MBool Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflowspec.impl.MBoolExprImpl
		 * @see workflowspec.impl.WorkflowspecPackageImpl#getMBoolExpr()
		 * @generated
		 */
		EClass MBOOL_EXPR = eINSTANCE.getMBoolExpr();

		/**
		 * The meta object literal for the '{@link workflowspec.impl.ValueImpl <em>Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflowspec.impl.ValueImpl
		 * @see workflowspec.impl.WorkflowspecPackageImpl#getValue()
		 * @generated
		 */
		EClass VALUE = eINSTANCE.getValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE__VALUE = eINSTANCE.getValue_Value();

		/**
		 * The meta object literal for the '{@link workflowspec.impl.BoolValueImpl <em>Bool Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflowspec.impl.BoolValueImpl
		 * @see workflowspec.impl.WorkflowspecPackageImpl#getBoolValue()
		 * @generated
		 */
		EClass BOOL_VALUE = eINSTANCE.getBoolValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOL_VALUE__VALUE = eINSTANCE.getBoolValue_Value();

		/**
		 * The meta object literal for the '{@link workflowspec.impl.BoolCompImpl <em>Bool Comp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflowspec.impl.BoolCompImpl
		 * @see workflowspec.impl.WorkflowspecPackageImpl#getBoolComp()
		 * @generated
		 */
		EClass BOOL_COMP = eINSTANCE.getBoolComp();

		/**
		 * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOL_COMP__OP = eINSTANCE.getBoolComp_Op();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOL_COMP__RIGHT = eINSTANCE.getBoolComp_Right();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOL_COMP__LEFT = eINSTANCE.getBoolComp_Left();

		/**
		 * The meta object literal for the '{@link workflowspec.impl.NotImpl <em>Not</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflowspec.impl.NotImpl
		 * @see workflowspec.impl.WorkflowspecPackageImpl#getNot()
		 * @generated
		 */
		EClass NOT = eINSTANCE.getNot();

		/**
		 * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOT__OP = eINSTANCE.getNot_Op();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOT__EXPR = eINSTANCE.getNot_Expr();

		/**
		 * The meta object literal for the '{@link workflowspec.impl.RelCompImpl <em>Rel Comp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflowspec.impl.RelCompImpl
		 * @see workflowspec.impl.WorkflowspecPackageImpl#getRelComp()
		 * @generated
		 */
		EClass REL_COMP = eINSTANCE.getRelComp();

		/**
		 * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REL_COMP__OP = eINSTANCE.getRelComp_Op();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_COMP__LEFT = eINSTANCE.getRelComp_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_COMP__RIGHT = eINSTANCE.getRelComp_Right();

		/**
		 * The meta object literal for the '{@link workflowspec.impl.AtomImpl <em>Atom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflowspec.impl.AtomImpl
		 * @see workflowspec.impl.WorkflowspecPackageImpl#getAtom()
		 * @generated
		 */
		EClass ATOM = eINSTANCE.getAtom();

		/**
		 * The meta object literal for the '<em><b>Measure ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATOM__MEASURE_ID = eINSTANCE.getAtom_MeasureID();

		/**
		 * The meta object literal for the '{@link workflowspec.BoolOp <em>Bool Op</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflowspec.BoolOp
		 * @see workflowspec.impl.WorkflowspecPackageImpl#getBoolOp()
		 * @generated
		 */
		EEnum BOOL_OP = eINSTANCE.getBoolOp();

		/**
		 * The meta object literal for the '{@link workflowspec.RelOp <em>Rel Op</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflowspec.RelOp
		 * @see workflowspec.impl.WorkflowspecPackageImpl#getRelOp()
		 * @generated
		 */
		EEnum REL_OP = eINSTANCE.getRelOp();

		/**
		 * The meta object literal for the '{@link workflowspec.TimeUnit <em>Time Unit</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see workflowspec.TimeUnit
		 * @see workflowspec.impl.WorkflowspecPackageImpl#getTimeUnit()
		 * @generated
		 */
		EEnum TIME_UNIT = eINSTANCE.getTimeUnit();

	}

} //WorkflowspecPackage
