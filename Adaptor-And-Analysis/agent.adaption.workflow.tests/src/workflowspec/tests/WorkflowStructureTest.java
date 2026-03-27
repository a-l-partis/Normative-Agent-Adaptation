/**
 */
package workflowspec.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import workflowspec.WorkflowStructure;
import workflowspec.WorkflowspecFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Workflow Structure</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class WorkflowStructureTest extends TestCase {

	/**
	 * The fixture for this Workflow Structure test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkflowStructure fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(WorkflowStructureTest.class);
	}

	/**
	 * Constructs a new Workflow Structure test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkflowStructureTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Workflow Structure test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(WorkflowStructure fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Workflow Structure test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkflowStructure getFixture() {
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
		setFixture(WorkflowspecFactory.eINSTANCE.createWorkflowStructure());
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

} //WorkflowStructureTest
