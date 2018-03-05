package scenarios;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import generic.BaseTest;
import testDataProvider_Repository.LeaseDataProvider;
import testScripts.BackendLeaseDataSetupScript;
import testScripts.FrontEndLeaseDataSetupScript;

public class LeaseDataSetup_Test  extends BaseTest

{
	
	//Back end Lease creation Script
	@Test(dataProvider = "DataProvider_BackendLeaseSetup",dataProviderClass = LeaseDataProvider.class,priority = 0)
	public void BackendLeaseDataSetup(Map<String, String> map) throws AWTException, InterruptedException, IOException
	{
		test=reports.createTest("BackendLeaseDataSetup"+map.get("SlNo"),"Lease Booking");
		BackendLeaseDataSetupScript lcs = new BackendLeaseDataSetupScript();
		lcs.leaseDataSetupScript(driver, test, map);
	}
	
	
	//Front end Lease creation Script
	@Test(dataProvider = "DataProvider_FrontendLeaseSetup",dataProviderClass = LeaseDataProvider.class,priority=1)
	public void FrontendLeaseDataSetup(Map<String, String> map) throws AWTException, InterruptedException, IOException
	{
		test=reports.createTest("FrontendLeaseDataSetup"+map.get("SlNo"),"Lease Booking");
		FrontEndLeaseDataSetupScript flds = new FrontEndLeaseDataSetupScript();
		flds.frontendScript(driver, test, map);
	}
}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
