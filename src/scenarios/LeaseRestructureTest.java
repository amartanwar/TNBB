package scenarios;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import generic.BaseTest;
import testscripts.Asset.AssetCreationMethod;
import testscripts.AssetCostAndValueAssignment.AssetStatusAndValueChangeMethod;
import testscripts.LTtoSTUpdate.LeaseLTtoSTUpdateMethod;
import testscripts.Lease.LeaseCreationMethod;
import testscripts.Lease.LeaseRestructureMethod;
import testscripts.LeaseIncomeUpdate.LeaseIncomeUpdateMethod;

public class LeaseRestructureTest extends BaseTest
{
	@Test(groups="Smoke Test")
	public void LeaseRestructureSmokeTest() throws IOException, InterruptedException, AWTException
	{
		test=reports.createTest("LeaseRestructureSmokeTest","This test will demonstrate the LeaseRestructure regression test");
		AssetCreationMethod as = new AssetCreationMethod();
		as.createAsset(driver, 4);
		
		AssetStatusAndValueChangeMethod av= new AssetStatusAndValueChangeMethod();
		av.assetValueAssignement(driver, 4);
		
		LeaseCreationMethod lc= new LeaseCreationMethod();
		lc.createLease(driver, 4);
		
		LeaseLTtoSTUpdateMethod ltr= new LeaseLTtoSTUpdateMethod();
		ltr.runLeaseLTtoSTUpdate(driver, 4);
		
		LeaseIncomeUpdateMethod li=new LeaseIncomeUpdateMethod();
		li.runLeaseIncomeUpdate(driver, 4);
		
		LeaseRestructureMethod lr= new LeaseRestructureMethod();
		lr.LeaseRestructure(driver, 4);
	}
}
