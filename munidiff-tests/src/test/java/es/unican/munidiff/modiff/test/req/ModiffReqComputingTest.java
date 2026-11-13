/*******************************************************************************
 * Copyright (c) 2012, 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package es.unican.munidiff.modiff.test.req;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import es.unican.munidiff.modiff.Modiff;
import es.unican.munidiff.AddedElement;
import es.unican.munidiff.ChangedElement;
import es.unican.munidiff.Difference;
import es.unican.munidiff.RemovedElement;
import es.unican.munidiff.matcher.IdMatcher;
import es.unican.munidiff.matcher.Matcher;
import es.unican.munidiff.reporting.MatcherBasedLabelProvider;
import es.unican.munidiff.reporting.textual.UnifiedDiffFormatter;
import es.unican.munidiff.emfcompare.test.req.data.ReqInputData;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class ModiffReqComputingTest {

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
		String fromContent = Files.readString(Paths.get(fromModel), StandardCharsets.UTF_8);
		String toContent = Files.readString(Paths.get(toModel), StandardCharsets.UTF_8);

		modiff = new Modiff("nodes", fromContent, toContent);
		matcher = new IdMatcher();
		modiff.setMatcher(matcher);
		modiff.compare();
		return modiff;
	}

	@BeforeClass
	public static void fillEMFRegistries() throws IOException {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"*", new XMIResourceFactoryImpl());
		ResourceSet ecoreResourceSet = new ResourceSetImpl();

		String ecorePath = "/models/nodes/nodes.ecore";
		Resource ecoreResource = ecoreResourceSet.createResource(URI.createURI(ecorePath));

		try (InputStream in = ModiffReqComputingTest.class.getResourceAsStream(ecorePath)) {
			if (in == null) {
				throw new IOException("Resource not found on classpath: " + ecorePath);
			}
			ecoreResource.load(in, null);
		}

		for (EObject o : ecoreResource.getContents()) {
			EPackage ePackage = (EPackage) o;
			EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);
		}
	}

	@After
	public void reportDifferences() {
		if (debug) {
			System.out.println(getReport());
		}
	}

	public String getReport() {
		return new UnifiedDiffFormatter(modiff.getMunidiff(),
				new MatcherBasedLabelProvider(modiff.getMatcher())).format();
	}

	@Test
	public void testA1() throws IOException {
		modiff = compare(input.getA1From(), input.getA1To());

		List<Difference> differences = modiff.getDifferences();
		assert (differences.size() == 4);
		assert (differences.get(2) instanceof RemovedElement);
		assert (differences.get(2).getIdentifier().equals("A"));
		assert (differences.get(3) instanceof RemovedElement);
		assert (differences.get(3).getIdentifier().equals("B"));
	}

	@Test
	public void testA2() throws IOException {
		modiff = compare(input.getA2From(), input.getA2To());

		List<Difference> differences = modiff.getDifferences();
		assert (differences.size() == 4);
		assert (differences.get(2) instanceof RemovedElement);
		assert (differences.get(2).getIdentifier().equals("A"));
		assert (differences.get(3) instanceof RemovedElement);
		assert (differences.get(3).getIdentifier().equals("B"));
	}

	@Test
	public void testA3() throws IOException {
		modiff = compare(input.getA3From(), input.getA3To());

		List<Difference> differences = modiff.getDifferences();
		assert (differences.size() == 3);
		assert (differences.get(0) instanceof ChangedElement);
		assert (differences.get(0).getIdentifier().equals("A"));
		assert (differences.get(2) instanceof RemovedElement);
		assert (differences.get(2).getIdentifier().equals("B"));
	}

	@Test
	public void testA4() throws IOException {
		modiff = compare(input.getA4From(), input.getA4To());

		List<Difference> differences = modiff.getDifferences();
		assert (differences.size() == 3);
		assert (differences.get(0) instanceof ChangedElement);
		assert (differences.get(0).getIdentifier().equals("A"));
		
		ChangedElement change = (ChangedElement) differences.get(0);
		EStructuralFeature feature = 
				change.getToElement().eClass().getEStructuralFeature("multiValuedReference");
		
		EObject newA = change.getToElement();
		EObject oldA = change.getFromElement();

		assert (matcher.getIdentifier(getElement(newA.eGet(feature), 0)).equals("C"));
		assert (matcher.getIdentifier(getElement(oldA.eGet(feature), 0)).equals("B"));

		assert (differences.get(2) instanceof RemovedElement);
		assert (differences.get(2).getIdentifier().equals("B"));
	}

	@Test
	public void testA5() throws IOException {
		modiff = compare(input.getA5From(), input.getA5To());

		List<Difference> differences = modiff.getDifferences();
		assert (differences.size() == 5);

		assert (differences.get(0) instanceof ChangedElement);
		assert (differences.get(0).getIdentifier().equals("_6oMn8JXsEeG8KoYbFpzr2g"));

		ChangedElement change = (ChangedElement) differences.get(0);

		assert (change.getChangedFeatures().size() == 1);
		assert (change.getChangedFeatures().get(0).getName().equals("multiValuedReference"));

		EStructuralFeature feature =
				change.getToElement().eClass().getEStructuralFeature("multiValuedReference");

		EObject newA = change.getToElement();
		EObject oldA = change.getFromElement();

		assert (getList(newA.eGet(feature)).size() == 2);
		assert (getList(oldA.eGet(feature)).size() == 3);

		assert (differences.get(2) instanceof AddedElement);
		assert (differences.get(2).getIdentifier().equals("_coQIwJX0EeG8KoYbFpzr2g"));

		assert (differences.get(3) instanceof RemovedElement);
		assert (differences.get(3).getIdentifier().equals("_IclIYJXuEeG8KoYbFpzr2g"));

		assert (differences.get(4) instanceof RemovedElement);
		assert (differences.get(4).getIdentifier().equals("_PkwdQJX0EeG8KoYbFpzr2g"));
	}

	@Test
	public void testA6() throws IOException {
		modiff = compare(input.getA6From(), input.getA6To());

		List<Difference> differences = modiff.getDifferences();
		assert (differences.size() == 6);

		for (Difference d : differences) {
			if (d.getIdentifier().equals("_yWc_0JUeEeGiestbncRZoQ")) {
				assert (d instanceof ChangedElement);
			}
			else {
				assert (d instanceof RemovedElement);
			}
		}
	}
}
