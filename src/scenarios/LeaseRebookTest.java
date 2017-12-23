package scenarios;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.Test;
import generic.BaseTest;
import testscripts.Asset.AssetCreationMethod;
import testscripts.AssetCostAndValueAssignment.AssetStatusAndValueChangeMethod;
import testscripts.Lease.LeaseCreationMethod;
import testscripts.Lease.LeaseRebookMethod;

public class LeaseRebookTest extends BaseTest
{
		@Test(groups="Smoke Test")
		public void LeaseRebookSmokeTest() throws IOException, InterruptedException, AWTException
		{
			
			test=reports.createTest("LeaseRebookSmokeTest","This test will demonstrate the LeaseRebook regression test");
			AssetCreationMethod as = new AssetCreationMethod();
			as.createAsset(driver, 3);
			
			AssetStatusAndValueChangeMethod av= new AssetStatusAndValueChangeMethod();
			av.assetValueAssignement(driver, 3);
			
			LeaseCreationMethod lm= new LeaseCreationMethod();
			lm.createLease(driver, 3);
					
			LeaseRebookMethod lr= new LeaseRebookMethod();
			lr.leaseRebook(driver, 3);
			
		}
}
