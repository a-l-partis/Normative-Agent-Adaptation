/**
 */
package workflowspec;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bool Comp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link workflowspec.BoolComp#getOp <em>Op</em>}</li>
 *   <li>{@link workflowspec.BoolComp#getRight <em>Right</em>}</li>
 *   <li>{@link workflowspec.BoolComp#getLeft <em>Left</em>}</li>
 * </ul>
 *
 * @see workflowspec.WorkflowspecPackage#getBoolComp()
 * @model
 * @generated
 */
public interface BoolComp extends MBoolExpr {
	/**
	 * Returns the value of the '<em><b>Op</b></em>' attribute.
	 * The literals are from the enumeration {@link workflowspec.BoolOp}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Op</em>' attribute.
	 * @see workflowspec.BoolOp
	 * @see #setOp(BoolOp)
	 * @see workflowspec.WorkflowspecPackage#getBoolComp_Op()
	 * @model
	 * @generated
	 */
	BoolOp getOp();

	/**
	 * Sets the value of the '{@link workflowspec.BoolComp#getOp <em>Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Op</em>' attribute.
	 * @see workflowspec.BoolOp
	 * @see #getOp()
	 * @generated
	 */
	void setOp(BoolOp value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(MBoolExpr)
	 * @see workflowspec.WorkflowspecPackage#getBoolComp_Right()
	 * @model containment="true"
	 * @generated
	 */
	MBoolExpr getRight();

	/**
	 * Sets the value of the '{@link workflowspec.BoolComp#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(MBoolExpr value);

	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(MBoolExpr)
	 * @see workflowspec.WorkflowspecPackage#getBoolComp_Left()
	 * @model containment="true"
	 * @generated
	 */
	MBoolExpr getLeft();

	/**
	 * Sets the value of the '{@link workflowspec.BoolComp#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(MBoolExpr value);

} // BoolComp
