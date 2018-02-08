package testDataProvider_Repository;

import org.testng.annotations.DataProvider;

import generic.DataProviderGenerator;

public class LeaseDataProvider extends DataProviderGenerator {
	
	@DataProvider(name ="OperatingLease_A2_BI1_IDC1_Ar")
	public static Object[][] OperatingLease_A2_BI1_IDC1_Ar()
	{
		
		String excelName = "OperatingLease_A2_BI1_IDC1_Ar";
		Object[][] leaseData_Ar=objectGenerator(excelName,"LeaseParameters");
		return leaseData_Ar; 
	
	}
	
	
	@DataProvider(name = "OperatingLease_A2_BI1_IDC1_Ad")
	public static Object[][] OperatingLease_A2_BI1_IDC1_Ad()
	{
		
		String excelName = "OperatingLease_A2_BI1_IDC1_Ad";
		Object[][] leaseData_Ad=objectGenerator(excelName,"LeaseParameters");
		return leaseData_Ad;
		
	}

}
