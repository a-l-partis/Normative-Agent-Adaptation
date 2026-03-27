/**
 */
package workflowspec.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import workflowspec.Workflow;
import workflowspec.WorkflowStructure;
import workflowspec.WorkflowspecPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Workflow Structure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link workflowspec.impl.WorkflowStructureImpl#getWorkflowspec <em>Workflowspec</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WorkflowStructureImpl extends MinimalEObjectImpl.Container implements WorkflowStructure {
	/**
	 * The cached value of the '{@link #getWorkflowspec() <em>Workflowspec</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkflowspec()
	 * @generated
	 * @ordered
	 */
	protected Workflow workflowspec;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkflowStructureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowspecPackage.Literals.WORKFLOW_STRUCTURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Workflow getWorkflowspec() {
		return workflowspec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWorkflowspec(Workflow newWorkflowspec, NotificationChain msgs) {
		Workflow oldWorkflowspec = workflowspec;
		workflowspec = newWorkflowspec;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowspecPackage.WORKFLOW_STRUCTURE__WORKFLOWSPEC, oldWorkflowspec, newWorkflowspec);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWorkflowspec(Workflow newWorkflowspec) {
		if (newWorkflowspec != workflowspec) {
			NotificationChain msgs = null;
			if (workflowspec != null)
				msgs = ((InternalEObject)workflowspec).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowspecPackage.WORKFLOW_STRUCTURE__WORKFLOWSPEC, null, msgs);
			if (newWorkflowspec != null)
				msgs = ((InternalEObject)newWorkflowspec).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowspecPackage.WORKFLOW_STRUCTURE__WORKFLOWSPEC, null, msgs);
			msgs = basicSetWorkflowspec(newWorkflowspec, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowspecPackage.WORKFLOW_STRUCTURE__WORKFLOWSPEC, newWorkflowspec, newWorkflowspec));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkflowspecPackage.WORKFLOW_STRUCTURE__WORKFLOWSPEC:
				return basicSetWorkflowspec(null, msgs);
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
			case WorkflowspecPackage.WORKFLOW_STRUCTURE__WORKFLOWSPEC:
				return getWorkflowspec();
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
			case WorkflowspecPackage.WORKFLOW_STRUCTURE__WORKFLOWSPEC:
				setWorkflowspec((Workflow)newValue);
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
			case WorkflowspecPackage.WORKFLOW_STRUCTURE__WORKFLOWSPEC:
				setWorkflowspec((Workflow)null);
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
			case WorkflowspecPackage.WORKFLOW_STRUCTURE__WORKFLOWSPEC:
				return workflowspec != null;
		}
		return super.eIsSet(featureID);
	}

} //WorkflowStructureImpl
