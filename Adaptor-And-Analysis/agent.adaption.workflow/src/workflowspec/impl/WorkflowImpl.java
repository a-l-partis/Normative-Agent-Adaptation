/**
 */
package workflowspec.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import workflowspec.Workflow;
import workflowspec.WorkflowspecPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Workflow</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class WorkflowImpl extends MinimalEObjectImpl.Container implements Workflow {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkflowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowspecPackage.Literals.WORKFLOW;
	}

} //WorkflowImpl
