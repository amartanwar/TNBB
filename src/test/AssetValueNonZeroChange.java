package test;

import org.testng.annotations.Test;

import generic.BaseTest;
import pom.AssetListPage;
import pom.AssetMenuPage;
import pom.AssetValueAndStatusChangePage;


public class AssetValueNonZeroChange extends BaseTest {
	
	@Test
	public void assetValueChange() throws InterruptedException
	{
		test=reports.createTest("assetValueChange","Creating Asset Value change entry");
		AssetMenuPage avc = new AssetMenuPage(driver, test);
		
		avc.clickOnAssetMenu();
		avc.clickOnvalueAndStatusChanges();
		
		avc.clickOnNonZero();
		
		AssetListPage alp = new AssetListPage(driver, test);
		
		alp.searchByAlias("alias-1");
		
		alp.clickOnSearchButton();
		
	    alp.selectGridCheckBox();
		
		alp.clickONSelectButton();
		
		AssetValueAndStatusChangePage avsc = new AssetValueAndStatusChangePage(driver, test);
		
		avsc.selectGLTemplate();
		
		avsc.selectGridCheckBox();
		
		avsc.selectAssignmentOperator();
		
		avsc.enterCostOfAsset("2000");
		
		avsc.clickOnAddButton();
		
		avsc.clickOnAssignmentButton();
		
		avsc.clickOnSaveButton();
		
		avsc.handlePopup();
		
		
		
	}

}
