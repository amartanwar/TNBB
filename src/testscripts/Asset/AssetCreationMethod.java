package testscripts.Asset;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import pom.AssetListPage;
import pom.AssetMenuPage;
import pom.AssetProfilePage;

public  class AssetCreationMethod
{
	
	public void createAsset(WebDriver driver,String un, String type, String usageCondition,String accountNumber,String factorcategory,String contractNumber,String divNumber, String subDivNumber, String locationCode, String company, String department) throws IOException, InterruptedException
	{
			//Opening Asset Profile screen
//				LeaseWaveHeader lwh= new LeaseWaveHeader(driver);
//				lwh.clickOnPortFolioManagement();
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
