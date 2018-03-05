package testDataProvider_Repository;

import org.testng.annotations.DataProvider;

import generic.DataProviderGenerator;

public class LeaseDataProvider extends DataProviderGenerator 

{
		
	// Back end Lease Data Provider
	@DataProvider(name ="DataProvider_BackendLeaseSetup")
	public static Object[][] BackendLease()
	{
		
		String excelName = "BackendLease_ExcelModel";
		Object[][] leaseData=objectGeneratorWithMultiSheet(excelName);
		return leaseData; 
	
	}
	

	// Front end Lease Data Provider
	@DataProvider(name ="DataProvider_FrontendLeaseSetup")
	public static Object[][] FrontendLease()
	{
		
		String excelName = "FrontendLease_ExcelModel";
		//Object[][] leaseData=objectGenerator(excelName,"LeaseParameters");
		Object[][] leaseData=objectGeneratorWithMultiSheet(excelName);
		return leaseData; 
	
	}
	
	

		
}
