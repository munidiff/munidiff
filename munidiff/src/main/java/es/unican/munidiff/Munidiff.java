/**
 */
package es.unican.munidiff;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Munidiff</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.unican.munidiff.Munidiff#getFromModelFile <em>From Model File</em>}</li>
 *   <li>{@link es.unican.munidiff.Munidiff#getToModelFile <em>To Model File</em>}</li>
 *   <li>{@link es.unican.munidiff.Munidiff#getDifferences <em>Differences</em>}</li>
 * </ul>
 *
 * @see es.unican.munidiff.MunidiffPackage#getMunidiff()
 * @model
 * @generated
 */
public interface Munidiff extends EObject {
	/**
	 * Returns the value of the '<em><b>From Model File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Model File</em>' attribute.
	 * @see #setFromModelFile(String)
	 * @see es.unican.munidiff.MunidiffPackage#getMunidiff_FromModelFile()
	 * @model required="true"
	 * @generated
	 */
	String getFromModelFile();

	/**
	 * Sets the value of the '{@link es.unican.munidiff.Munidiff#getFromModelFile <em>From Model File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Model File</em>' attribute.
	 * @see #getFromModelFile()
	 * @generated
	 */
	void setFromModelFile(String value);

	/**
	 * Returns the value of the '<em><b>To Model File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Model File</em>' attribute.
	 * @see #setToModelFile(String)
	 * @see es.unican.munidiff.MunidiffPackage#getMunidiff_ToModelFile()
	 * @model required="true"
	 * @generated
	 */
	String getToModelFile();

	/**
	 * Sets the value of the '{@link es.unican.munidiff.Munidiff#getToModelFile <em>To Model File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Model File</em>' attribute.
	 * @see #getToModelFile()
	 * @generated
	 */
	void setToModelFile(String value);

	/**
	 * Returns the value of the '<em><b>Differences</b></em>' containment reference list.
	 * The list contents are of type {@link es.unican.munidiff.Difference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Differences</em>' containment reference list.
	 * @see es.unican.munidiff.MunidiffPackage#getMunidiff_Differences()
	 * @model containment="true"
	 * @generated
	 */
	EList<Difference> getDifferences();

} // Munidiff
