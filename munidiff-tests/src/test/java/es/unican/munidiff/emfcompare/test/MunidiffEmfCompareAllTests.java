package es.unican.munidiff.emfcompare.test;

import es.unican.munidiff.emfcompare.test.req.MunidiffEmfCompareReqTest;
import es.unican.munidiff.emfcompare.test.repairshop.MunidiffEmfCompareRepairShopTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
		MunidiffEmfCompareReqTest.class,
		MunidiffEmfCompareRepairShopTest.class
})
public class MunidiffEmfCompareAllTests {

}
