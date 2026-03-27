/**
 */
package workflowspec.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import workflowspec.GuardedWorkflow;
import workflowspec.WorkflowspecFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Guarded Workflow</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class GuardedWorkflowTest extends TestCase {

	/**
	 * The fixture for this Guarded Workflow test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GuardedWorkflow fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(GuardedWorkflowTest.class);
	}

	/**
	 * Constructs a new Guarded Workflow test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GuardedWorkflowTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Guarded Workflow test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(GuardedWorkflow fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Guarded Workflow test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GuardedWorkflow getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(WorkflowspecFactory.eINSTANCE.createGuardedWorkflow());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //GuardedWorkflowTest
