package testscripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import generic.excel;
import pom.AssetListPage;
import pom.AssetMenuPage;
import pom.AssetProfilePage;
import pom.LeaseWaveHeader;

public class AssetModule_GenericMethods 
{
//	public void assetBulkCreationWithDiffDataSet(WebDriver driver,int numberofAssets) throws InterruptedException, IOException 
//	{
//		AssetMenuPage asm= new AssetMenuPage(driver);
//		asm.clickOnAssetMenu();
//		asm.clickOnAssetProfile();
//		AssetListPage  aslp= new AssetListPage(driver);
//		int count=numberofAssets;
//		
//		for(int j=1;j<=count;j++)
//			{
//				//Fetching data from xl
//				String un=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", j,0);
//				String type=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", j,1);
//				String usageCondition=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", j,2);
//				String accountNumber=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", j,3);
//				String factorcategory=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", j,4);
//				String contractNumber=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", j,5);
//				String divNumber=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", j,6);
//				String subDivNumber=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", j,7);
//				String locationCode=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", j,8);
//				String company=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", j,9);
//				String department=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", j,10);
//
//				aslp.clickOnaddButton();	
//				
//				//Entering UnitNumber
//				AssetProfilePage app= new AssetProfilePage(driver);
//				app.setUnitNumber(un);
//				
//				//Selecting Asset Type
//				app.setAssetType(type);
//				
//				//Entering Acquired Date
//				app.setAcquiredDate();
//				
//				//Selecting UsageCondition
//				app.setUsageCondition(usageCondition);
//				
//				//Selecting Account Number
//				app.setAccountNumber(accountNumber);	
//				
//				//Selecting Factor Category
//				app.setFactorCategory(factorcategory);
//				
//				//Selecting Contract Number
//				app.setContractNumber(contractNumber);
//				
//				//Selecting Location
//				app.setLocationCode(locationCode);
//				
//				//Selecting DivisionNumber
//				app.setDivision(divNumber);
//				
//				//Entering Location effective date
//				app.setEffectiveDate();
//				
//				//Selecting SubDivision
//				app.setSubdivision(subDivNumber);
//				
//				//Selection GLComapny
//				app.setCompany(company);
//				
//				//Selecting GLDepartment
//				app.setDepartment(department);
//				
//				//Click On save Button
//				app.clickOnSave();
//				
//				//Validating vehicle details page
//				app.verfyTittle("Vehicle Details","Vehicle Details page is not visible");
//				
//				//clicking on saveButton(Vehicle details)
//				app.clickOnVehicleDetailsSaveButton();
//				
//				//Clicking on global save
//				app.clickOnAssetProfileGlobalClose();
//				
//				
//				//Validating Asset creation test
//				app.verfyTittle("Asset List","Asset List page is not visible");
//				Reporter.log(un+" Created successfully");
//			
//			}
//	}
//	
//	public void assetCreationWithSameDataSet(WebDriver driver,int numberOfAssets) throws InterruptedException, IOException
	{
		AssetMenuPage asm= new AssetMenuPage(driver);
		asm.clickOnAssetMenu();
		asm.clickOnAssetProfile();
		AssetListPage  aslp= new AssetListPage(driver);
		int count=numberOfAssets;
		
		for(int j=1;j<=count;j++)
			{
				//Fetching data from xl
				String un=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", j,0);
				String type=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,1);
				String usageCondition=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,2);
				String accountNumber=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,3);
				String factorcategory=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,4);
				String contractNumber=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,5);
				String divNumber=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,6);
				String subDivNumber=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,7);
				String locationCode=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,8);
				String company=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,9);
				String department=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile",1,10);

				aslp.clickOnaddButton();	
				
				//Entering UnitNumber
				AssetProfilePage app= new AssetProfilePage(driver);
				app.setUnitNumber(un);
				
				//Selecting Asset Type
				app.setAssetType(type);
				
				//Entering Acquired Date
				app.setAcquiredDate();
				
				//Selecting UsageCondition
				app.setUsageCondition(usageCondition);
				
				//Selecting Account Number
				app.setAccountNumber(accountNumber);	
				
				//Selecting Factor Category
				app.setFactorCategory(factorcategory);
				
				//Selecting Contract Number
				app.setContractNumber(contractNumber);
				
				//Selecting Location
				app.setLocationCode(locationCode);
				
				//Selecting DivisionNumber
				app.setDivision(divNumber);
				
				//Entering Location effective date
				app.setEffectiveDate();
				
				//Selecting SubDivision
				app.setSubdivision(subDivNumber);
				
				//Selection GLComapny
				app.setCompany(company);
				
				//Selecting GLDepartment
				app.setDepartment(department);
				
				//Click On save Button
				app.clickOnSave();
				
				//Validating vehicle details page
				app.verfyTittle("Vehicle Details","Vehicle Details page is not visible");
				
				//clicking on saveButton(Vehicle details)
				app.clickOnVehicleDetailsSaveButton();
				
				//Clicking on global save
				app.clickOnAssetProfileGlobalClose();
				
				
				//Validating Asset creation test
				app.verfyTittle("Asset List","Asset List page is not visible");
				Reporter.log(un+" Created successfully");
			
			}
	}
	
	public void createAsset(WebDriver driver,String un, String type, String usageCondition,String accountNumber,String factorcategory,String contractNumber,String divNumber, String subDivNumber, String locationCode, String company, String department) throws IOException, InterruptedException
	{
			//Opening Asset Profile screen
				LeaseWaveHeader lwh= new LeaseWaveHeader(driver);
				lwh.clickOnPortFolioManagement();
				AssetMenuPage asm= new AssetMenuPage(driver);
				asm.clickOnAssetMenu();
				asm.clickOnAssetProfile();
				AssetListPage  aslp= new AssetListPage(driver);
				aslp.clickOnaddButton();	
				
				//Entering UnitNumber
				AssetProfilePage app= new AssetProfilePage(driver);
				app.setUnitNumber(un);
				
				//Selecting Asset Type
				app.setAssetType(type);
				
				//Entering Acquired Date
				app.setAcquiredDate();
				
				//Selecting UsageCondition
				app.setUsageCondition(usageCondition);
				
				//Selecting Account Number
				app.setAccountNumber(accountNumber);	
				
				//Selecting Factor Category
				app.setFactorCategory(factorcategory);
				
				//Selecting Contract Number
				app.setContractNumber(contractNumber);
				
				//Selecting Location
				app.setLocationCode(locationCode);
				
				//Selecting DivisionNumber
				app.setDivision(divNumber);
				
				//Entering Location effective date
				app.setEffectiveDate();
				
				//Selecting SubDivision
				app.setSubdivision(subDivNumber);
				
				//Selection GLComapny
				app.setCompany(company);
				
				//Selecting GLDepartment
				app.setDepartment(department);
				
				//Click On save Button
				app.clickOnSave();
				
				//Validating vehicle details page
				app.verfyTittle("Vehicle Details","Asset Creation failed because of incorrect values entered");
				
				//clicking on saveButton(Vehicle details)
				app.clickOnVehicleDetailsSaveButton();
				
				//Clicking on global save
				app.clickOnAssetProfileGlobalClose();
				
				
				//Validating Asset creation test
				app.verfyTittle("Asset List","Asset Creation failed because of incorrect values entered");
				
				Reporter.log("AssetCreation method ran successfully", true);
			
	}
}
                