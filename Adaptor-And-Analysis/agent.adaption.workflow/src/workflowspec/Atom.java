/**
 */
package workflowspec;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Atom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link workflowspec.Atom#getMeasureID <em>Measure ID</em>}</li>
 * </ul>
 *
 * @see workflowspec.WorkflowspecPackage#getAtom()
 * @model
 * @generated
 */
public interface Atom extends MBoolExpr {
	/**
	 * Returns the value of the '<em><b>Measure ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measure ID</em>' attribute.
	 * @see #setMeasureID(String)
	 * @see workflowspec.WorkflowspecPackage#getAtom_MeasureID()
	 * @model
	 * @generated
	 */
	String getMeasureID();

	/**
	 * Sets the value of the '{@link workflowspec.Atom#getMeasureID <em>Measure ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Measure ID</em>' attribute.
	 * @see #getMeasureID()
	 * @generated
	 */
	void setMeasureID(String value);

} // Atom
