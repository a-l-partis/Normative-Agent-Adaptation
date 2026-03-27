/**
 */
package workflowspec.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import workflowspec.MBoolExpr;
import workflowspec.WorkflowspecFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>MBool Expr</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class MBoolExprTest extends TestCase {

	/**
	 * The fixture for this MBool Expr test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MBoolExpr fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(MBoolExprTest.class);
	}

	/**
	 * Constructs a new MBool Expr test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MBoolExprTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this MBool Expr test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(MBoolExpr fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this MBool Expr test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MBoolExpr getFixture() {
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
		setFixture(WorkflowspecFactory.eINSTANCE.createMBoolExpr());
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

} //MBoolExprTest
