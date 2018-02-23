package testDataProvider_Repository;

import org.testng.annotations.DataProvider;

import generic.DataProviderGenerator;

public class LeaseDataProvider extends DataProviderGenerator 

{
		
	// Lease Data Provider
	@DataProvider(name ="DataProvider_LeaseSetup")
	public static Object[][] Lease()
	{
		
		String excelName = "Lease_ExcelModel";
		Object[][] leaseData=objectGenerator(excelName,"LeaseParameters");
		return leaseData; 
	
	}
	

	

		
}
