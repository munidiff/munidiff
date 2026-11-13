package es.unican.munidiff.matcher;

import org.eclipse.emf.ecore.EObject;

import es.unican.munidiff.Difference;

/**
 * Allows obtaining an identifier (e.g. ID or signature-based) of EObjects
 * 
 * <br/>
 * 
 * Used to set the identifiers of {@link Difference} elements. Placed here
 * because it is used in several places downstream.
 */
public interface Matcher {

	public boolean matches(EObject element1, EObject element2);

	public String getIdentifier(EObject element);
}
