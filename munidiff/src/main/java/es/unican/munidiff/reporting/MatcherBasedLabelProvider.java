package es.unican.munidiff.reporting;

import org.eclipse.emf.ecore.EObject;

import es.unican.munidiff.matcher.Matcher;

/**
 * Uses the matcher identifier as label in difference reports
 */
public class MatcherBasedLabelProvider implements LabelProvider {

	protected Matcher matcher;

	public MatcherBasedLabelProvider(Matcher matcher) {
		this.matcher = matcher;
	}

	@Override
	public String getLabel(EObject obj) {
		return matcher.getIdentifier(obj);
	}

}
