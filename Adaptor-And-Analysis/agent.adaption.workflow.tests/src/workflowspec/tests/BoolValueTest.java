/**
 */
package workflowspec.tests;

import junit.textui.TestRunner;

import workflowspec.BoolValue;
import workflowspec.WorkflowspecFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Bool Value</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class BoolValueTest extends MBoolExprTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(BoolValueTest.class);
	}

	/**
	 * Constructs a new Bool Value test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoolValueTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Bool Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected BoolValue getFixture() {
		return (BoolValue)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(WorkflowspecFactory.eINSTANCE.createBoolValue());
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

} //BoolValueTest
