package scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;

public class TestExtent2 extends BaseTest
{
	@Test
	public void reporttestPass()
	{
		test=reports.createTest("reporttestPass1","This test will demonstrate the pass test case");
		System.out.println("running reporttestPass");
		Assert.assertTrue(1>0);
		System.out.println("Test Case One with Thread Id:- "
				+ Thread.currentThread().getId());
	}
	
//	@Test
//	public void reporttestFail()
//	{
//		test=reports.createTest("reporttestFail1","This test will demonstrate the fail test case");
//		System.out.println("running reporttestFail");
//		Assert.assertTrue(1>2);
//	}
//	
//	@Test
//	public void reporttestSkip()
//	{
//		test=reports.createTest("reporttestFail1","This test will demonstrate the skip test case");
//		System.out.println("running reporttestSkip");
//		throw new SkipException("This test is not ready to run");
//	
//		
//	}
}
