/**
 */
package workflowspec;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link workflowspec.Loop#getLoop <em>Loop</em>}</li>
 * </ul>
 *
 * @see workflowspec.WorkflowspecPackage#getLoop()
 * @model
 * @generated
 */
public interface Loop extends Workflow {
	/**
	 * Returns the value of the '<em><b>Loop</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop</em>' containment reference.
	 * @see #setLoop(GuardedWorkflow)
	 * @see workflowspec.WorkflowspecPackage#getLoop_Loop()
	 * @model containment="true" required="true"
	 * @generated
	 */
	GuardedWorkflow getLoop();

	/**
	 * Sets the value of the '{@link workflowspec.Loop#getLoop <em>Loop</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop</em>' containment reference.
	 * @see #getLoop()
	 * @generated
	 */
	void setLoop(GuardedWorkflow value);

} // Loop
