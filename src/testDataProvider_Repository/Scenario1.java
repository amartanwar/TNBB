package testDataProvider_Repository;

import org.testng.annotations.DataProvider;

import generic.DataProviderGenerator;

public class Scenario1 extends DataProviderGenerator
{
	@DataProvider(name="scenario1_Testdata")
	public static Object[][] scenario1_Testdata()
	{
		String xlName="Input";
		Object[][] assetProfile=objectGenerator(xlName,"AssetTest");
		Object[][] assetValue=objectGenerator(xlName,"AssetValue");
		Object[][] leaseProfile=objectGenerator(xlName,"LeaseProfile");
		Object[][] lttoSTupdate1=objectGenerator(xlName,"LTtoSTUpdate");
		Object[][] leaseIncomeupdate=objectGenerator(xlName,"Incomeupdate");
		Object[][] invoicedateUpdate=objectGenerator(xlName,"InvoiceDateUpdate");
		Object[][] salesTaxUpdate=objectGenerator(xlName,"Salesupdate");
		Object[][] invoiceGeneration=objectGenerator(xlName,"InvoiceGeneration");
		Object[][] receipt=objectGenerator(xlName,"Receipt");
		
		
		Object[][] scenario1_Testdata = objectMerger(assetProfile, assetValue,leaseProfile,lttoSTupdate1,leaseIncomeupdate,invoicedateUpdate,salesTaxUpdate,invoiceGeneration,receipt);
		
		return scenario1_Testdata;
		
	}
}
