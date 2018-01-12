package scenarios;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.Test;
import generic.BaseTest;
import testscripts.AssetCreationMethod;
import testscripts.AssetModule_GenericMethods;
import testscripts.LTtoSTUpdate.LeaseLTtoSTUpdateMethod;
import testscripts.Lease.LeaseCreationMethod;
import testscriptsCostAndValueAssignment.AssetStatusAndValueChangeMethod;

public class LeaseLTtoSTUpdateTest extends BaseTest
{	
	@Test(priority=1)
	public void lTtoSTUpdateTest_TestDataCreation() throws IOException, InterruptedException, AWTException
	{
	 AssetModule_GenericMethods	as = new AssetModule_GenericMethods();
		as.createAsset(driver, un, type, usageCondition, accountNumber, factorcategory, contractNumber, divNumber, subDivNumber, locationCode, company, department);
		
		AssetStatusAndValueChangeMethod av= new AssetStatusAndValueChangeMethod();
		av.assetValueAssignement(driver, 1);
		
		LeaseCreationMethod lc= new LeaseCreationMethod();
		lc.createLease(driver, 1);
	}
	@Test(priority=2, dependsOnMethods={"lTtoSTUpdateTest_TestDataCreation"})
	public void lTtoSTUpdateTest() throws InterruptedException
	{
		LeaseLTtoSTUpdateMethod ls= new LeaseLTtoSTUpdateMethod();
		ls.runLeaseLTtoSTUpdate(driver, 1);
		
	}
}
