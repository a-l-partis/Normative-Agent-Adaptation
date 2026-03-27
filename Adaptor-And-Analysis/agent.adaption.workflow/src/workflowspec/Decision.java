/**
 */
package workflowspec;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Decision</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link workflowspec.Decision#getOptions <em>Options</em>}</li>
 * </ul>
 *
 * @see workflowspec.WorkflowspecPackage#getDecision()
 * @model
 * @generated
 */
public interface Decision extends Workflow {
	/**
	 * Returns the value of the '<em><b>Options</b></em>' containment reference list.
	 * The list contents are of type {@link workflowspec.GuardedWorkflow}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Options</em>' containment reference list.
	 * @see workflowspec.WorkflowspecPackage#getDecision_Options()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<GuardedWorkflow> getOptions();

} // Decision
