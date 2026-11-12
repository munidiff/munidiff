package es.unican.munidiff.reporting;

import es.unican.munidiff.Munidiff;

public abstract class MunidiffFormatter {

	protected Munidiff munidiff;
	protected LabelProvider labelProvider;

	public MunidiffFormatter(Munidiff munidiff, LabelProvider labelProvider) {
		this.munidiff = munidiff;
		this.labelProvider = labelProvider;
	}

	abstract public String format();
}
