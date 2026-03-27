/**
 */
package workflowspec;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rel Comp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link workflowspec.RelComp#getOp <em>Op</em>}</li>
 *   <li>{@link workflowspec.RelComp#getLeft <em>Left</em>}</li>
 *   <li>{@link workflowspec.RelComp#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see workflowspec.WorkflowspecPackage#getRelComp()
 * @model
 * @generated
 */
public interface RelComp extends MBoolExpr {
	/**
	 * Returns the value of the '<em><b>Op</b></em>' attribute.
	 * The literals are from the enumeration {@link workflowspec.RelOp}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Op</em>' attribute.
	 * @see workflowspec.RelOp
	 * @see #setOp(RelOp)
	 * @see workflowspec.WorkflowspecPackage#getRelComp_Op()
	 * @model
	 * @generated
	 */
	RelOp getOp();

	/**
	 * Sets the value of the '{@link workflowspec.RelComp#getOp <em>Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Op</em>' attribute.
	 * @see workflowspec.RelOp
	 * @see #getOp()
	 * @generated
	 */
	void setOp(RelOp value);

	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(MBoolExpr)
	 * @see workflowspec.WorkflowspecPackage#getRelComp_Left()
	 * @model containment="true"
	 * @generated
	 */
	MBoolExpr getLeft();

	/**
	 * Sets the value of the '{@link workflowspec.RelComp#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(MBoolExpr value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(MBoolExpr)
	 * @see workflowspec.WorkflowspecPackage#getRelComp_Right()
	 * @model containment="true"
	 * @generated
	 */
	MBoolExpr getRight();

	/**
	 * Sets the value of the '{@link workflowspec.RelComp#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(MBoolExpr value);

} // RelComp
