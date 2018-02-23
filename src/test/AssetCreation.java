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
		pa.enterAlias("alias-1");
		
		pa.enterAcquiredDate("1/1/2018");

		pa.selectAssetcategory("ed");
		pa.selectAssetType("sd");
		
		pa.enterAccountNumber("1");
		
		pa.selectpropertyTaxResposibility("sfsd");
		pa.selectFactorCategory("hard");
		
		pa.enterLocationCode("1");
		
		pa.selectIndustryType();
		
		pa.clickOnSave();
		
		pa.verfyTittle("Asset List", "Title is matching");
		test.log(Status.PASS, "asset create successfully");
	}

	
	
}
