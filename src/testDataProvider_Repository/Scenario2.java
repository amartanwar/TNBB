package testDataProvider_Repository;

import org.testng.annotations.DataProvider;

import generic.DataProviderGenerator;

public class Scenario2 extends DataProviderGenerator
{
	@DataProvider(name="scenario2_Testdata")
	public static Object[][] scenario1_Testdata()
	{
		Object[][] productProfile=objectGenerator("./TestData/Input.xlsx","ProductProfile");
		
		
		
		
		return productProfile;
		
	}
}
