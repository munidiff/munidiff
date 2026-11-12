package es.unican.munidiff.modiff.reporting;

import org.eclipse.emf.ecore.EObject;

import es.unican.munidiff.modiff.matcher.Matcher;
import es.unican.munidiff.reporting.LabelProvider;

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
