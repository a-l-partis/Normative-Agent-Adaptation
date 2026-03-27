/**
 */
package workflowspec;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link workflowspec.Sequence#getSubworkflows <em>Subworkflows</em>}</li>
 * </ul>
 *
 * @see workflowspec.WorkflowspecPackage#getSequence()
 * @model
 * @generated
 */
public interface Sequence extends Workflow {
	/**
	 * Returns the value of the '<em><b>Subworkflows</b></em>' containment reference list.
	 * The list contents are of type {@link workflowspec.Workflow}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subworkflows</em>' containment reference list.
	 * @see workflowspec.WorkflowspecPackage#getSequence_Subworkflows()
	 * @model containment="true" lower="2"
	 * @generated
	 */
	EList<Workflow> getSubworkflows();

} // Sequence
