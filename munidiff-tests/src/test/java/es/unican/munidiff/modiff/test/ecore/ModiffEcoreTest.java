package es.unican.munidiff.modiff.test.ecore;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import es.unican.munidiff.modiff.Modiff;
import es.unican.munidiff.modiff.matcher.EcoreMatcher;
import es.unican.munidiff.modiff.matcher.Matcher;
import es.unican.munidiff.AddedElement;
import es.unican.munidiff.ChangedElement;
import es.unican.munidiff.Difference;
import es.unican.munidiff.RemovedElement;
import es.unican.munidiff.modiff.reporting.MatcherBasedLabelProvider;
import es.unican.munidiff.reporting.graphical.PlantumlEcoreFormatter;
import es.unican.munidiff.reporting.textual.UnifiedDiffFormatter;
import es.unican.munidiff.modiff.test.emfcompare.req.data.ReqInputData;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class ModiffEcoreTest {

	protected boolean debug = true;

	protected Modiff modiff;
	protected Matcher matcher;

	protected ReqInputData input = new ReqInputData();

	@SuppressWarnings("unchecked")
	protected List<EObject> getList(Object list) {
		if (!(list instanceof List)) {
			throw new IllegalStateException("Object is not a list");
		}
		return (List<EObject>) list;
	}

	protected EObject getElement(Object list, int index) {
		return getList(list).get(index);
	}

	protected Modiff compare(String fromModel, String toModel) throws IOException {
		modiff = new Modiff("ecore", readModel(fromModel), readModel(toModel));
		matcher = new EcoreMatcher();
		modiff.setMatcher(matcher);
		modiff.compare();
		return modiff;
	}

	protected Difference getDifferenceForId(List<Difference> differences, String id) {
		for (Difference d : differences) {
			if (id.equals(d.getIdentifier())) {
				return d;
			}
		}
		return null;
	}

	@BeforeClass
	public static void fillEMFRegistries() throws IOException {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"*", new XMIResourceFactoryImpl());
	}

	@After
	public void reportDifferences() {
		if (debug) {
			System.out.println(getReport());
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println(getGraphicalReport());
		}
	}

	public String getReport() {
		return new UnifiedDiffFormatter(modiff.getMunidiff(),
				new MatcherBasedLabelProvider(modiff.getMatcher())).format();
	}

	public String getGraphicalReport() {
		return new PlantumlEcoreFormatter(modiff.getMunidiff(),
				new MatcherBasedLabelProvider(modiff.getMatcher())).format();
	}

	protected String readModel(String model) throws IOException {
		String path = "/models/ecore/" + model + ".ecore";
		try (InputStream in = getClass().getResourceAsStream(path)) {
			if (in == null) {
				throw new IOException("Resource not found on classpath: " + path);
			}
			return new String(in.readAllBytes(), StandardCharsets.UTF_8);
		}
	}

	@Test
	public void test01() throws IOException {
		modiff = compare("00-from", "00-from");

		List<Difference> differences = modiff.getDifferences();
		assert (differences.size() == 0);
		assert (getReport().length() == 0);
	}

	@Test
	public void test11() throws IOException {
		modiff = compare("00-from", "11-class2abstract");

		List<Difference> differences = modiff.getDifferences();
		assert (differences.size() == 1);

		Difference diff = getDifferenceForId(differences, "repairtests.Skill");
		assert (diff != null && diff instanceof ChangedElement);
		assert (((ChangedElement) diff).getChangedFeatures().size() == 1);
		assert (((ChangedElement) diff).getChangedFeatures().get(0).getName().equals("abstract"));
	}

	@Test
	public void test12() throws IOException {
		modiff = compare("00-from", "12-className");

		List<Difference> differences = modiff.getDifferences();
		assert (differences.size() == 3);

		Difference diff = getDifferenceForId(differences, "repairtests.RepairShop.workers");
		assert (diff != null && diff instanceof ChangedElement);
		assert (((ChangedElement) diff).getChangedFeatures().size() == 1);
		assert (((ChangedElement) diff).getChangedFeatures().get(0).getName().equals("eType"));

		diff = getDifferenceForId(differences, "repairtests.Worker");
		assert (diff != null && diff instanceof RemovedElement);

		diff = getDifferenceForId(differences, "repairtests.Employee");
		assert (diff != null && diff instanceof AddedElement);
	}

	@Test
	public void test12modelContents() throws IOException {

		String fromModelContents = readModel("00-from");
		String toModelContents = readModel("12-className");

		modiff = new Modiff("repairShop.ecore", fromModelContents, toModelContents);
		modiff.setMatcher(new EcoreMatcher());
		modiff.compare();

		List<Difference> differences = modiff.getDifferences();
		assert (differences.size() == 3);

		Difference diff = getDifferenceForId(differences, "repairtests.RepairShop.workers");
		assert (diff != null && diff instanceof ChangedElement);
		assert (((ChangedElement) diff).getChangedFeatures().size() == 1);
		assert (((ChangedElement) diff).getChangedFeatures().get(0).getName().equals("eType"));

		diff = getDifferenceForId(differences, "repairtests.Worker");
		assert (diff != null && diff instanceof RemovedElement);

		diff = getDifferenceForId(differences, "repairtests.Employee");
		assert (diff != null && diff instanceof AddedElement);
	}

	@Test
	public void test12emptyFromContents() throws IOException {

		String fromModelContents = "";
		String toModelContents = readModel("12-className");

		modiff = new Modiff("repairShop.ecore", fromModelContents, toModelContents);
		modiff.setMatcher(new EcoreMatcher());
		modiff.compare();

		List<Difference> differences = modiff.getDifferences();
		assert (differences.size() == 39);

		for (Difference d : differences) {
			assert (d instanceof AddedElement);
		}
	}

	@Test
	public void test22() throws IOException {

		modiff = compare("01-from-unmodifiedRepairshop", "31-deleteSkill");

		List<Difference> differences = modiff.getDifferences();
		assert (differences.size() == 5);
		
		Difference diff = getDifferenceForId(differences, "repairshop.Skill");
		assert (diff != null && diff instanceof RemovedElement);
	}
}

