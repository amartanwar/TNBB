package test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pom.AssetListPage;
import pom.AssetMenuPage;
import pom.AssetProfilePage;

public class AssetCreation extends BaseTest
{
	@Test
	public void assetCreation() throws Exception
	{
		test=reports.createTest("assetCreation","This test will create the asset for test data");
		AssetMenuPage asm= new AssetMenuPage(driver,test);
		asm.clickOnAssetMenu();
		asm.clickOnAssetProfile();
		
		AssetListPage al= new AssetListPage(driver, test);
		al.clickOnaddButton();
		
		AssetProfilePage pa= new AssetProfilePage(driver, test);
		pa.setUnitNumber("tst36");
		
		pa.setAcquiredDate("1/19/2018");

		pa.setAssetcategory("ed");
		pa.setAssetType("sd");
		
		pa.setAccountNumber("1000");
		
		pa.setpropertyTaxResposibility("sfsd");
		pa.setFactorCategory("hard");
		
		pa.setLocationCode("LC-01");
		
		pa.setIndustryType();
		
		pa.clickOnSave();
		
		pa.verfyTittle("Asset List", "Title is matching");
		test.log(Status.PASS, "asset create successfully");
	}

	
	
}
