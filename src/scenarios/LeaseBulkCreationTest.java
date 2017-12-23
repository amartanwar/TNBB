package scenarios;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;
import generic.BaseTest;
import testscripts.Asset.AssetBulkCreationMethod;
import testscripts.AssetCostAndValueAssignment.AssetBulkCostAssignmentMethod;
import testscripts.Lease.LeaseBulkCreationMethod;


public class LeaseBulkCreationTest extends BaseTest
{
	@Test(priority=0)
	public void runAssetBulkCreation() throws InterruptedException, IOException
	{
		AssetBulkCreationMethod ab= new AssetBulkCreationMethod();
		ab.assetCreationWithSameDataSet(driver, 2);
		System.out.println("Test Case One with Thread Id:- "
				+ Thread.currentThread().getId());

	}
	
	@Test(priority=1)
	public void runAssetBulkValueAssignment() throws InterruptedException, IOException
	{
		AssetBulkCostAssignmentMethod ac= new AssetBulkCostAssignmentMethod();
		ac.AssetBulkCostAssignmentWithDiffValue(driver, 2);
	}
	
	@Test(priority=2)
	public void runLeaseBulkCreation() throws InterruptedException, AWTException, IOException
	{
		LeaseBulkCreationMethod lbc= new LeaseBulkCreationMethod();
		lbc.LeaseBulkCreation(driver, 2);
	}
}
