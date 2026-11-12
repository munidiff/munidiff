package es.unican.munidiff.reporting.graphical;

import java.net.URL;

import org.eclipse.epsilon.egl.EglModule;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.execute.context.Variable;

import es.unican.munidiff.Munidiff;
import es.unican.munidiff.MunidiffPackage;
import es.unican.munidiff.reporting.LabelProvider;
import es.unican.munidiff.reporting.MunidiffFormatter;

public class PlantumlFormatter extends MunidiffFormatter {
	
	protected boolean hideUnchangedRefsInChangedElems = true;

	public PlantumlFormatter(Munidiff munidiff, LabelProvider labelProvider) {
		super(munidiff, labelProvider);
	}
	
	protected URL getTemplate() {
		return getClass().getResource("/reporting/graphical/munidiff2plantuml.egl");
	}

	protected EglModule getModule() {
		EglModule module = new EglModule();
		module.getContext().getFrameStack().put(Variable.createReadOnlyVariable("munidiff", munidiff));
		module.getContext().getFrameStack().put(Variable.createReadOnlyVariable("labelProvider", labelProvider));

		module.getContext().getFrameStack().put(Variable.createReadOnlyVariable(
				"hideUnchangedRefsInChangedElems", hideUnchangedRefsInChangedElems));

		InMemoryEmfModel model = new InMemoryEmfModel(MunidiffPackage.eINSTANCE.eResource());
		model.setName("munidiffMM");
		module.getContext().getModelRepository().addModel(model);

		return module;
	}

	public String format() {

		String result = null;
		EglModule module = getModule();
		try {
			module.parse(getTemplate());
			result = (String) module.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public PlantumlFormatter hideUnchangedRefsInChangedElems(boolean hide) {
		hideUnchangedRefsInChangedElems = hide;
		return this;
	}
}
