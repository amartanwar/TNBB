package scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import TestDataProvider.Scenario1;
import generic.BaseTest;
import testscripts.Asset.AssetTest;
import testscripts.AssetCostAndValueAssignment.AssetvalueTest;

public class TestExtent extends BaseTest
{
	@Test(dataProvider="scenario1_Testdata",dataProviderClass=Scenario1.class)
	public void createAsset(String un, String type, String usageCondition,String accountNumber,String factorcategory,String contractNumber,String divNumber, String subDivNumber, String locationCode, String company, String department, String cost) throws IOException, InterruptedException
	{
		test=reports.createTest("createAsset","This test will demonstrate the LeaseRebook regression test");
		AssetTest as= new AssetTest();
		as.createAsset(driver, un, type, usageCondition, accountNumber, factorcategory, contractNumber, divNumber, subDivNumber, locationCode, company, department);
		
		AssetvalueTest av= new AssetvalueTest();
		av.assetValueAssignement(driver, cost);
	}
	
	
//	@Test(dataProvider="scenario1_Testdata",dataProviderClass=Scenario1.class)
//	public void createAsset(String un, String type, String usageCondition,String accountNumber,String factorcategory,
//			String contractNumber,String divNumber, String subDivNumber, String locationCode, String company, String department,
//			String cost, String billingType, String leaseFrequency, String leaseTerm, String leaseRental,String receiptAmount) throws IOException, InterruptedException
//	{
//		System.out.println(un);
//		System.out.println(type);
//		System.out.println(usageCondition);
//		System.out.println(accountNumber);
//		System.out.println(factorcategory);
//		System.out.println(contractNumber);
//		System.out.println(divNumber);
//		System.out.println(subDivNumber);
//		System.out.println(locationCode);
//		System.out.println(company);
//		System.out.println(department);
//		System.out.println(cost);
//		System.out.println(billingType);
//		System.out.println(leaseFrequency);
//		System.out.println(leaseTerm);
//		System.out.println(leaseRental);
//		System.out.println(receiptAmount);
//		
//	}
//	
}
