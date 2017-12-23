package scenarios;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import generic.BaseTest;
import testscripts.Asset.AssetCreationMethod;
import testscripts.AssetCostAndValueAssignment.AssetStatusAndValueChangeMethod;
import testscripts.Lease.LeaseYieldVerificationMethod;

public class LeaseYieldVerificationTest extends BaseTest
{
	@Test()
	public void testingLeaseYield() throws IOException, InterruptedException, AWTException
	{
		test=reports.createTest("testingLeaseYield","This test will demonstrate the LeaseYieldVerification regression test");
		AssetCreationMethod as = new AssetCreationMethod();
		as.createAsset(driver, 5);
		
		AssetStatusAndValueChangeMethod av= new AssetStatusAndValueChangeMethod();
		av.assetValueAssignement(driver, 5);
		
		LeaseYieldVerificationMethod lv= new LeaseYieldVerificationMethod();
		lv.LeaseYieldVerification(driver, 5);
		
	}
}
