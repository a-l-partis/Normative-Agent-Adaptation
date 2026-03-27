/**
 */
package workflowspec;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Workflow Structure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link workflowspec.WorkflowStructure#getWorkflowspec <em>Workflowspec</em>}</li>
 * </ul>
 *
 * @see workflowspec.WorkflowspecPackage#getWorkflowStructure()
 * @model
 * @generated
 */
public interface WorkflowStructure extends EObject {
	/**
	 * Returns the value of the '<em><b>Workflowspec</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workflowspec</em>' containment reference.
	 * @see #setWorkflowspec(Workflow)
	 * @see workflowspec.WorkflowspecPackage#getWorkflowStructure_Workflowspec()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Workflow getWorkflowspec();

	/**
	 * Sets the value of the '{@link workflowspec.WorkflowStructure#getWorkflowspec <em>Workflowspec</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Workflowspec</em>' containment reference.
	 * @see #getWorkflowspec()
	 * @generated
	 */
	void setWorkflowspec(Workflow value);

} // WorkflowStructure
