package es.unican.munidiff.reporting.graphical;

import java.net.URL;

import es.unican.munidiff.Munidiff;
import es.unican.munidiff.reporting.LabelProvider;

public class PlantumlEcoreFormatter extends PlantumlFormatter {

	public PlantumlEcoreFormatter(Munidiff munidiff, LabelProvider labelProvider) {
		super(munidiff, labelProvider);
	}

	@Override
	protected URL getTemplate() {
		return getClass().getResource("/reporting/graphical/munidiffEcore2plantuml.egl");
	}
}
