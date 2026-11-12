/**
 */
package es.unican.munidiff.impl;

import es.unican.munidiff.ChangedElement;
import es.unican.munidiff.MunidiffPackage;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Changed Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link es.unican.munidiff.impl.ChangedElementImpl#getFromElement <em>From Element</em>}</li>
 *   <li>{@link es.unican.munidiff.impl.ChangedElementImpl#getToElement <em>To Element</em>}</li>
 *   <li>{@link es.unican.munidiff.impl.ChangedElementImpl#getChangedFeatures <em>Changed Features</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ChangedElementImpl extends DifferenceImpl implements ChangedElement {
	/**
	 * The cached value of the '{@link #getFromElement() <em>From Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromElement()
	 * @generated
	 * @ordered
	 */
	protected EObject fromElement;

	/**
	 * The cached value of the '{@link #getToElement() <em>To Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToElement()
	 * @generated
	 * @ordered
	 */
	protected EObject toElement;

	/**
	 * The cached value of the '{@link #getChangedFeatures() <em>Changed Features</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChangedFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<EStructuralFeature> changedFeatures;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChangedElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MunidiffPackage.Literals.CHANGED_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject getFromElement() {
		if (fromElement != null && fromElement.eIsProxy()) {
			InternalEObject oldFromElement = (InternalEObject)fromElement;
			fromElement = eResolveProxy(oldFromElement);
			if (fromElement != oldFromElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MunidiffPackage.CHANGED_ELEMENT__FROM_ELEMENT, oldFromElement, fromElement));
			}
		}
		return fromElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetFromElement() {
		return fromElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFromElement(EObject newFromElement) {
		EObject oldFromElement = fromElement;
		fromElement = newFromElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MunidiffPackage.CHANGED_ELEMENT__FROM_ELEMENT, oldFromElement, fromElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject getToElement() {
		if (toElement != null && toElement.eIsProxy()) {
			InternalEObject oldToElement = (InternalEObject)toElement;
			toElement = eResolveProxy(oldToElement);
			if (toElement != oldToElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MunidiffPackage.CHANGED_ELEMENT__TO_ELEMENT, oldToElement, toElement));
			}
		}
		return toElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetToElement() {
		return toElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setToElement(EObject newToElement) {
		EObject oldToElement = toElement;
		toElement = newToElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MunidiffPackage.CHANGED_ELEMENT__TO_ELEMENT, oldToElement, toElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EStructuralFeature> getChangedFeatures() {
		if (changedFeatures == null) {
			changedFeatures = new EObjectResolvingEList<EStructuralFeature>(EStructuralFeature.class, this, MunidiffPackage.CHANGED_ELEMENT__CHANGED_FEATURES);
		}
		return changedFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean hasDifferences() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MunidiffPackage.CHANGED_ELEMENT__FROM_ELEMENT:
				if (resolve) return getFromElement();
				return basicGetFromElement();
			case MunidiffPackage.CHANGED_ELEMENT__TO_ELEMENT:
				if (resolve) return getToElement();
				return basicGetToElement();
			case MunidiffPackage.CHANGED_ELEMENT__CHANGED_FEATURES:
				return getChangedFeatures();
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
			case MunidiffPackage.CHANGED_ELEMENT__FROM_ELEMENT:
				setFromElement((EObject)newValue);
				return;
			case MunidiffPackage.CHANGED_ELEMENT__TO_ELEMENT:
				setToElement((EObject)newValue);
				return;
			case MunidiffPackage.CHANGED_ELEMENT__CHANGED_FEATURES:
				getChangedFeatures().clear();
				getChangedFeatures().addAll((Collection<? extends EStructuralFeature>)newValue);
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
			case MunidiffPackage.CHANGED_ELEMENT__FROM_ELEMENT:
				setFromElement((EObject)null);
				return;
			case MunidiffPackage.CHANGED_ELEMENT__TO_ELEMENT:
				setToElement((EObject)null);
				return;
			case MunidiffPackage.CHANGED_ELEMENT__CHANGED_FEATURES:
				getChangedFeatures().clear();
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
			case MunidiffPackage.CHANGED_ELEMENT__FROM_ELEMENT:
				return fromElement != null;
			case MunidiffPackage.CHANGED_ELEMENT__TO_ELEMENT:
				return toElement != null;
			case MunidiffPackage.CHANGED_ELEMENT__CHANGED_FEATURES:
				return changedFeatures != null && !changedFeatures.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MunidiffPackage.CHANGED_ELEMENT___HAS_DIFFERENCES:
				return hasDifferences();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ChangedElementImpl
