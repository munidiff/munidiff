package es.unican.munidiff.modiff.test;

import es.unican.munidiff.modiff.test.ecore.ModiffEcoreTest;
import es.unican.munidiff.modiff.test.req.ModiffReqComputingTest;
import es.unican.munidiff.modiff.test.repairshop.ModiffRepairShopTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
		ModiffReqComputingTest.class,
		ModiffRepairShopTest.class,
		ModiffEcoreTest.class
})
public class ModiffAllTests {
}
