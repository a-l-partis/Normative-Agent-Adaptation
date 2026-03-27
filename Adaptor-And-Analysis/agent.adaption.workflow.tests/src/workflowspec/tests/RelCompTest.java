/**
 */
package workflowspec.tests;

import junit.textui.TestRunner;

import workflowspec.RelComp;
import workflowspec.WorkflowspecFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Rel Comp</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RelCompTest extends MBoolExprTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RelCompTest.class);
	}

	/**
	 * Constructs a new Rel Comp test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelCompTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Rel Comp test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected RelComp getFixture() {
		return (RelComp)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(WorkflowspecFactory.eINSTANCE.createRelComp());
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

} //RelCompTest
