/**
 */
package es.unican.munidiff.impl;

import es.unican.munidiff.Difference;
import es.unican.munidiff.Munidiff;
import es.unican.munidiff.MunidiffPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Munidiff</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link es.unican.munidiff.impl.MunidiffImpl#getFromModelFile <em>From Model File</em>}</li>
 *   <li>{@link es.unican.munidiff.impl.MunidiffImpl#getToModelFile <em>To Model File</em>}</li>
 *   <li>{@link es.unican.munidiff.impl.MunidiffImpl#getDifferences <em>Differences</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MunidiffImpl extends MinimalEObjectImpl.Container implements Munidiff {
	/**
	 * The default value of the '{@link #getFromModelFile() <em>From Model File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromModelFile()
	 * @generated
	 * @ordered
	 */
	protected static final String FROM_MODEL_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFromModelFile() <em>From Model File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromModelFile()
	 * @generated
	 * @ordered
	 */
	protected String fromModelFile = FROM_MODEL_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getToModelFile() <em>To Model File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToModelFile()
	 * @generated
	 * @ordered
	 */
	protected static final String TO_MODEL_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getToModelFile() <em>To Model File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToModelFile()
	 * @generated
	 * @ordered
	 */
	protected String toModelFile = TO_MODEL_FILE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDifferences() <em>Differences</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDifferences()
	 * @generated
	 * @ordered
	 */
	protected EList<Difference> differences;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MunidiffImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MunidiffPackage.Literals.MUNIDIFF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFromModelFile() {
		return fromModelFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFromModelFile(String newFromModelFile) {
		String oldFromModelFile = fromModelFile;
		fromModelFile = newFromModelFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MunidiffPackage.MUNIDIFF__FROM_MODEL_FILE, oldFromModelFile, fromModelFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getToModelFile() {
		return toModelFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setToModelFile(String newToModelFile) {
		String oldToModelFile = toModelFile;
		toModelFile = newToModelFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MunidiffPackage.MUNIDIFF__TO_MODEL_FILE, oldToModelFile, toModelFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Difference> getDifferences() {
		if (differences == null) {
			differences = new EObjectContainmentEList<Difference>(Difference.class, this, MunidiffPackage.MUNIDIFF__DIFFERENCES);
		}
		return differences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MunidiffPackage.MUNIDIFF__DIFFERENCES:
				return ((InternalEList<?>)getDifferences()).basicRemove(otherEnd, msgs);
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
			case MunidiffPackage.MUNIDIFF__FROM_MODEL_FILE:
				return getFromModelFile();
			case MunidiffPackage.MUNIDIFF__TO_MODEL_FILE:
				return getToModelFile();
			case MunidiffPackage.MUNIDIFF__DIFFERENCES:
				return getDifferences();
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
			case MunidiffPackage.MUNIDIFF__FROM_MODEL_FILE:
				setFromModelFile((String)newValue);
				return;
			case MunidiffPackage.MUNIDIFF__TO_MODEL_FILE:
				setToModelFile((String)newValue);
				return;
			case MunidiffPackage.MUNIDIFF__DIFFERENCES:
				getDifferences().clear();
				getDifferences().addAll((Collection<? extends Difference>)newValue);
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
			case MunidiffPackage.MUNIDIFF__FROM_MODEL_FILE:
				setFromModelFile(FROM_MODEL_FILE_EDEFAULT);
				return;
			case MunidiffPackage.MUNIDIFF__TO_MODEL_FILE:
				setToModelFile(TO_MODEL_FILE_EDEFAULT);
				return;
			case MunidiffPackage.MUNIDIFF__DIFFERENCES:
				getDifferences().clear();
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
			case MunidiffPackage.MUNIDIFF__FROM_MODEL_FILE:
				return FROM_MODEL_FILE_EDEFAULT == null ? fromModelFile != null : !FROM_MODEL_FILE_EDEFAULT.equals(fromModelFile);
			case MunidiffPackage.MUNIDIFF__TO_MODEL_FILE:
				return TO_MODEL_FILE_EDEFAULT == null ? toModelFile != null : !TO_MODEL_FILE_EDEFAULT.equals(toModelFile);
			case MunidiffPackage.MUNIDIFF__DIFFERENCES:
				return differences != null && !differences.isEmpty();
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
		result.append(" (fromModelFile: ");
		result.append(fromModelFile);
		result.append(", toModelFile: ");
		result.append(toModelFile);
		result.append(')');
		return result.toString();
	}

} //MunidiffImpl
