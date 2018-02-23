package scenarios;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import generic.BaseTest;
import testDataProvider_Repository.LeaseDataProvider;
import testScripts.LeaseDataSetupScript;

public class LeaseDataSetup_Test  extends BaseTest

{
	
	//Lease creation Script
	@Test(dataProvider = "DataProvider_LeaseSetup",dataProviderClass = LeaseDataProvider.class)
	public void LeaseDataSetup(Map<String, String> map) throws AWTException, InterruptedException, IOException
	{
		test=reports.createTest("LeaseDataSetup"+map.get("SlNo"),"Lease Booking");
		LeaseDataSetupScript lcs = new LeaseDataSetupScript();
		lcs.leaseDataSetupScript(driver, test, map);
	}
	
}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
