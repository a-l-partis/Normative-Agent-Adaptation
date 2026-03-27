/**
 */
package workflowspec.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import workflowspec.Atom;
import workflowspec.WorkflowspecPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Atom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link workflowspec.impl.AtomImpl#getMeasureID <em>Measure ID</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AtomImpl extends MBoolExprImpl implements Atom {
	/**
	 * The default value of the '{@link #getMeasureID() <em>Measure ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasureID()
	 * @generated
	 * @ordered
	 */
	protected static final String MEASURE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMeasureID() <em>Measure ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasureID()
	 * @generated
	 * @ordered
	 */
	protected String measureID = MEASURE_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AtomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowspecPackage.Literals.ATOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMeasureID() {
		return measureID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMeasureID(String newMeasureID) {
		String oldMeasureID = measureID;
		measureID = newMeasureID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowspecPackage.ATOM__MEASURE_ID, oldMeasureID, measureID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkflowspecPackage.ATOM__MEASURE_ID:
				return getMeasureID();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WorkflowspecPackage.ATOM__MEASURE_ID:
				setMeasureID((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case WorkflowspecPackage.ATOM__MEASURE_ID:
				setMeasureID(MEASURE_ID_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case WorkflowspecPackage.ATOM__MEASURE_ID:
				return MEASURE_ID_EDEFAULT == null ? measureID != null : !MEASURE_ID_EDEFAULT.equals(measureID);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (measureID: ");
		result.append(measureID);
		result.append(')');
		return result.toString();
	}

} //AtomImpl
