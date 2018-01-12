package scenarios;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.Test;
import generic.BaseTest;
import testscripts.AssetModule_GenericMethods;
import testscripts.AssetValueAndCostAssignement_GenericMethods;
import testscripts.LeaseModule_GenericMethods;


public class LeaseBulkCreationTest extends BaseTest
{
	@Test(priority=0)
	public void runAssetBulkCreation() throws InterruptedException, IOException
	{
		AssetModule_GenericMethods ab =new AssetModule_GenericMethods();
		ab.assetCreationWithSameDataSet(driver, 2);
		
	}
	
	@Test(priority=1)
	public void runAssetBulkValueAssignment() throws InterruptedException, IOException
	{
		AssetValueAndCostAssignement_GenericMethods ac= new AssetValueAndCostAssignement_GenericMethods();
		ac.AssetBulkCostAssignmentWithDiffValue(driver, 2);
	}
	
	@Test(priority=2)
	public void runLeaseBulkCreation() throws InterruptedException, AWTException, IOException
	{
		LeaseModule_GenericMethods lbc= new LeaseModule_GenericMethods();
		lbc.LeaseBulkCreation(driver, 2);
	}
}
