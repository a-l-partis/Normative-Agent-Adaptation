/**
 */
package workflowspec;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Not</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link workflowspec.Not#getOp <em>Op</em>}</li>
 *   <li>{@link workflowspec.Not#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @see workflowspec.WorkflowspecPackage#getNot()
 * @model
 * @generated
 */
public interface Not extends MBoolExpr {
	/**
	 * Returns the value of the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Op</em>' attribute.
	 * @see #setOp(String)
	 * @see workflowspec.WorkflowspecPackage#getNot_Op()
	 * @model
	 * @generated
	 */
	String getOp();

	/**
	 * Sets the value of the '{@link workflowspec.Not#getOp <em>Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Op</em>' attribute.
	 * @see #getOp()
	 * @generated
	 */
	void setOp(String value);

	/**
	 * Returns the value of the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expr</em>' containment reference.
	 * @see #setExpr(MBoolExpr)
	 * @see workflowspec.WorkflowspecPackage#getNot_Expr()
	 * @model containment="true"
	 * @generated
	 */
	MBoolExpr getExpr();

	/**
	 * Sets the value of the '{@link workflowspec.Not#getExpr <em>Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expr</em>' containment reference.
	 * @see #getExpr()
	 * @generated
	 */
	void setExpr(MBoolExpr value);

} // Not
