package TestDataProvider;

import org.testng.annotations.DataProvider;

import generic.DataProviderGenerator;

public class Scenario1 extends DataProviderGenerator
{
	@DataProvider(name="scenario1_Testdata")
	public static Object[][] scenario1_Testdata()
	{
		Object[][] assetProfile=objectGenerator("./TestData/Input.xlsx","AssetTest");
		Object[][] assetValue=objectGenerator("./TestData/Input.xlsx","AssetValue");
		Object[][] leaseProfile=objectGenerator("./TestData/Input.xlsx","LeaseProfile");
		Object[][] lttoSTupdate1=objectGenerator("./TestData/Input.xlsx","LTtoSTUpdate");
		Object[][] leaseIncomeupdate=objectGenerator("./TestData/Input.xlsx","Incomeupdate");
		Object[][] invoicedateUpdate=objectGenerator("./TestData/Input.xlsx","InvoiceDateUpdate");
		Object[][] salesTaxUpdate=objectGenerator("./TestData/Input.xlsx","Salesupdate");
		Object[][] invoiceGeneration=objectGenerator("./TestData/Input.xlsx","InvoiceGeneration");
		Object[][] receipt=objectGenerator("./TestData/Input.xlsx","Receipt");
		
		
		Object[][] scenario1_Testdata = objectMerger(assetProfile, assetValue,leaseProfile,lttoSTupdate1,leaseIncomeupdate,invoicedateUpdate,salesTaxUpdate,invoiceGeneration,receipt);
		
		return scenario1_Testdata;
		
	}
}
