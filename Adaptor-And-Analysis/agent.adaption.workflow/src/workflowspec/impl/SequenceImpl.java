/**
 */
package workflowspec.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import workflowspec.Sequence;
import workflowspec.Workflow;
import workflowspec.WorkflowspecPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link workflowspec.impl.SequenceImpl#getSubworkflows <em>Subworkflows</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SequenceImpl extends WorkflowImpl implements Sequence {
	/**
	 * The cached value of the '{@link #getSubworkflows() <em>Subworkflows</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubworkflows()
	 * @generated
	 * @ordered
	 */
	protected EList<Workflow> subworkflows;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SequenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowspecPackage.Literals.SEQUENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Workflow> getSubworkflows() {
		if (subworkflows == null) {
			subworkflows = new EObjectContainmentEList<Workflow>(Workflow.class, this, WorkflowspecPackage.SEQUENCE__SUBWORKFLOWS);
		}
		return subworkflows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkflowspecPackage.SEQUENCE__SUBWORKFLOWS:
				return ((InternalEList<?>)getSubworkflows()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkflowspecPackage.SEQUENCE__SUBWORKFLOWS:
				return getSubworkflows();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WorkflowspecPackage.SEQUENCE__SUBWORKFLOWS:
				getSubworkflows().clear();
				getSubworkflows().addAll((Collection<? extends Workflow>)newValue);
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
			case WorkflowspecPackage.SEQUENCE__SUBWORKFLOWS:
				getSubworkflows().clear();
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
			case WorkflowspecPackage.SEQUENCE__SUBWORKFLOWS:
				return subworkflows != null && !subworkflows.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SequenceImpl
