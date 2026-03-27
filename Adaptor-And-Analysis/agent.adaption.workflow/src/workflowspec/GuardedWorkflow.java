/**
 */
package workflowspec;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Guarded Workflow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link workflowspec.GuardedWorkflow#getBody <em>Body</em>}</li>
 *   <li>{@link workflowspec.GuardedWorkflow#getGuard <em>Guard</em>}</li>
 * </ul>
 *
 * @see workflowspec.WorkflowspecPackage#getGuardedWorkflow()
 * @model
 * @generated
 */
public interface GuardedWorkflow extends EObject {
	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(Workflow)
	 * @see workflowspec.WorkflowspecPackage#getGuardedWorkflow_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Workflow getBody();

	/**
	 * Sets the value of the '{@link workflowspec.GuardedWorkflow#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Workflow value);

	/**
	 * Returns the value of the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guard</em>' containment reference.
	 * @see #setGuard(MBoolExpr)
	 * @see workflowspec.WorkflowspecPackage#getGuardedWorkflow_Guard()
	 * @model containment="true" required="true"
	 * @generated
	 */
	MBoolExpr getGuard();

	/**
	 * Sets the value of the '{@link workflowspec.GuardedWorkflow#getGuard <em>Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guard</em>' containment reference.
	 * @see #getGuard()
	 * @generated
	 */
	void setGuard(MBoolExpr value);

} // GuardedWorkflow
