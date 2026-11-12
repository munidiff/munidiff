/**
 */
package es.unican.munidiff;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Changed Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.unican.munidiff.ChangedElement#getFromElement <em>From Element</em>}</li>
 *   <li>{@link es.unican.munidiff.ChangedElement#getToElement <em>To Element</em>}</li>
 *   <li>{@link es.unican.munidiff.ChangedElement#getChangedFeatures <em>Changed Features</em>}</li>
 * </ul>
 *
 * @see es.unican.munidiff.MunidiffPackage#getChangedElement()
 * @model
 * @generated
 */
public interface ChangedElement extends Difference {
	/**
	 * Returns the value of the '<em><b>From Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Element</em>' reference.
	 * @see #setFromElement(EObject)
	 * @see es.unican.munidiff.MunidiffPackage#getChangedElement_FromElement()
	 * @model required="true"
	 * @generated
	 */
	EObject getFromElement();

	/**
	 * Sets the value of the '{@link es.unican.munidiff.ChangedElement#getFromElement <em>From Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Element</em>' reference.
	 * @see #getFromElement()
	 * @generated
	 */
	void setFromElement(EObject value);

	/**
	 * Returns the value of the '<em><b>To Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Element</em>' reference.
	 * @see #setToElement(EObject)
	 * @see es.unican.munidiff.MunidiffPackage#getChangedElement_ToElement()
	 * @model required="true"
	 * @generated
	 */
	EObject getToElement();

	/**
	 * Sets the value of the '{@link es.unican.munidiff.ChangedElement#getToElement <em>To Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Element</em>' reference.
	 * @see #getToElement()
	 * @generated
	 */
	void setToElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Changed Features</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EStructuralFeature}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Changed Features</em>' reference list.
	 * @see es.unican.munidiff.MunidiffPackage#getChangedElement_ChangedFeatures()
	 * @model
	 * @generated
	 */
	EList<EStructuralFeature> getChangedFeatures();

} // ChangedElement
