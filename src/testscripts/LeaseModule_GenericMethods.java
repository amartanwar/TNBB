package testscripts;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;

import generic.excel;
import pom.AssetListPage;
import pom.LeaseCreatePage;
import pom.CustomerListPage;
import pom.LeaseAccrualPage;
import pom.LeaseClassificationPage;
import pom.LeaseEntryHomePage;
import pom.LeaseIDCSetupPage;
import pom.LeaseInventoryInLeasePage;
import pom.LeaseMilageParameterPage;
import pom.LeaseListPage;
import pom.LeaseMenuPage;
import pom.LeasePaymentSchedulePage;
import pom.LeaseProfilePage;
import pom.LeaseRebookParametersPage;
import pom.LeaseRestructurePage;
import pom.LeaseStructurePage;
import pom.RestructureDatePage;

public class LeaseModule_GenericMethods 
{
	public void LeaseBulkCreation(WebDriver driver,ExtentTest test,int numberOfLeases) throws InterruptedException, AWTException, IOException
	{
		for(int row=1;row<=numberOfLeases;row++)
		{
			//Fetching values from xl
			String un=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", row,0);
			String accountNumber=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", row,3);
			String leaseBillingType=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", row,12);
			String leaseFrequency=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", row,13);
			String leaseTerm=excel.getNumericCellValue("./TestData/Input.xlsx", "AssetProfile", row,14);
			String leaseRental=excel.getNumericCellValue("./TestData/Input.xlsx", "AssetProfile", row,15);
			
			
			//Opening the lease lease creation page
//			LeaseWaveHeader lwh=new LeaseWaveHeader(driver);
//			lwh.clickOnPortFolioManagement();
			LeaseMenuPage lm=new LeaseMenuPage(driver, test);
			lm.clickOnLeaseMenu();
			lm.clickOnNewLease();
			
			//Customer list screen
			CustomerListPage cl=new CustomerListPage(driver, test);
			cl.enterAccountNumber(accountNumber);
			cl.clickOnsearchButton();
			cl.clickOnSelectButton();
			
			//create new Lease screen
			LeaseCreatePage clp= new LeaseCreatePage(driver, test);
			clp.enterLeaseSequenceNumber(un);
			clp.clcikOnSaveButton();
			
			//LeaseInventoryInlease screen
			LeaseInventoryInLeasePage ilp=new LeaseInventoryInLeasePage(driver);
			String beforeWindow = driver.getWindowHandle();
//			System.out.println("1"+ driver.getTitle());
			ilp.clickOnImportButton();
			
		
			//AssetList page
			AssetListPage asl=new AssetListPage(driver, test);
//			System.out.println("2 "+driver.getTitle());
			asl.searchByUnitNumber(un);
//			System.out.println("3 "+driver.getTitle());
			asl.clickOnSearchButton(un);
			asl.selectCheckBox();
			asl.clickOnSelectExportButton();
			Thread.sleep(1000);
			driver.switchTo().window(beforeWindow);
			//LeaseInventoryInlease screen
			ilp.selectAsset();
			ilp.selectPrimaryAsset();
			ilp.clickOnEditButton();
			ilp.enterOdometerReading("1200");
			ilp.enterDeliverydate();
			ilp.clickOnGridSaveButton();
			ilp.clickOnPageSaveButton();
			
			//Lease Profile screen
			LeaseProfilePage lp=new LeaseProfilePage(driver);
			lp.selectOtpARGLTemplate();
			lp.selectotpIncomeGLTemplate();
			lp.selectGLCompany();
			lp.selectGLDepartment();
			lp.selectInterimRentGLTemplate();
			lp.selectreceiptCashGLTemplate();
			lp.selectProductChargeBillingType("Arrears");
			lp.selectLeaseRentalBillingType(leaseBillingType);
			lp.clickOnSaveButton();
		
			
			//leaseInvestment screen
			LeaseEntryHomePage le=new LeaseEntryHomePage(driver);
			le.clickOnInvestmentScreen();
			LeaseMilageParameterPage li=new LeaseMilageParameterPage(driver);
			li.clickOnSaveButton();
			
			//LeaseIDC setup screen
			LeaseIDCSetupPage lIDC=new LeaseIDCSetupPage(driver);
			lIDC.clickOnSaveButton();
			
			//Lease Structure screen
			le.clickOnStructureScreen();
			LeaseStructurePage ls= new LeaseStructurePage(driver);
			ls.enterNumberofPayments(leaseTerm);
			ls.enterCommencementDate("10/1/2017");
			ls.selectLeaseFrequency(leaseFrequency);
			Thread.sleep(2000);
			ls.enterRegularTotalPayment(leaseRental);
			ls.enterGLPostDate();
			ls.clickOnSaveButton();
			
			LeasePaymentSchedulePage lps=new LeasePaymentSchedulePage(driver);
			lps.clickOnCloseButton();
			//Lease Classification screen
			LeaseClassificationPage lc= new LeaseClassificationPage(driver);
			lc.selectBargainPurchaseOption();
			lc.selectLeaseAccountingTreatment();
			lc.selectLeaseBookingGLTemplate();
			lc.selectLtrToARGLTemplate();
			lc.selectProduct();
			lc.clickOnPerform90PercentTestButton();
			Thread.sleep(2000);
			lc.clickOnSaveButton();
			
			//LeaseAccrual screen
			LeaseAccrualPage la=new LeaseAccrualPage(driver);
			la.clickOnComputeYieldButton();
			la.clickOnSaveButton();
			la.handlePopup();
			
			//LeaseEntryHome screen
			le.selectLeaseBookingStatus();
			le.clickOnSaveButton();
			le.handlePopup1();
//			le.handlePopup2();
			
			//validating Result
			le.verfyTittle("Lease List", "Lease creation test pass");
			
			Reporter.log("Lease Successfully created for asset "+un);
			
		}
	}

	public void createLease(WebDriver driver,String lease_un, String lease_accountNumber, String leaseBillingType, String leaseFrequency, String leaseTerm, String leaseRental) throws AWTException, InterruptedException, IOException
	{
		//Fetching values from xl
	
				//Opening the lease lease creation page
//				LeaseWaveHeader lwh=new LeaseWaveHeader(driver);
//				lwh.clickOnPortFolioManagement();
				LeaseMenuPage lm=new LeaseMenuPage(driver);
				lm.clickOnLeaseMenu();
				lm.clickOnNewLease();
				
				//Customer list screen
				CustomerListPage cl=new CustomerListPage(driver);
				cl.enterAccountNumber(lease_accountNumber);
				cl.clickOnsearchButton();
				cl.clickOnSelectButton();
				
				//create new Lease screen
				LeaseCreatePage clp= new LeaseCreatePage(driver);
				clp.enterLeaseSequenceNumber(lease_un);
				clp.clcikOnSaveButton();
				
				//LeaseInventoryInlease screen
				LeaseInventoryInLeasePage ilp=new LeaseInventoryInLeasePage(driver);
				String beforeWindow = driver.getWindowHandle();
				ilp.clickOnImportButton();
				//AssetList page
				AssetListPage asl=new AssetListPage(driver);
				asl.searchByUnitNumber(lease_un);
				asl.clickOnSearchButton(lease_un);
				asl.selectCheckBox();
				Thread.sleep(2000);
				asl.clickOnSelectExportButton();
				driver.switchTo().window(beforeWindow);
				//LeaseInventoryInlease screen
				Thread.sleep(1000);
				ilp.selectAsset();
				ilp.selectPrimaryAsset();
				ilp.clickOnEditButton();
				ilp.enterOdometerReading("1200");
				ilp.enterDeliverydate();
				ilp.clickOnGridSaveButton();
				ilp.clickOnPageSaveButton();
				
				//Lease Profile screen
				LeaseProfilePage lp=new LeaseProfilePage(driver);
				lp.selectOtpARGLTemplate();
				lp.selectotpIncomeGLTemplate();
				lp.selectGLCompany();
				lp.selectGLDepartment();
				lp.selectInterimRentGLTemplate();
				lp.selectreceiptCashGLTemplate();
				lp.selectProductChargeBillingType("Arrears");
				lp.selectLeaseRentalBillingType(leaseBillingType);
				lp.clickOnSaveButton();
			
				
				//leaseInvestment screen
				LeaseEntryHomePage le=new LeaseEntryHomePage(driver);
				le.clickOnInvestmentScreen();
				LeaseMilageParameterPage li=new LeaseMilageParameterPage(driver);
				li.clickOnSaveButton();
				
				//LeaseIDC setup screen
				LeaseIDCSetupPage lIDC=new LeaseIDCSetupPage(driver);
				lIDC.clickOnSaveButton();
				
				//Lease Structure screen
				le.clickOnStructureScreen();
				LeaseStructurePage ls= new LeaseStructurePage(driver);
				ls.enterNumberofPayments(leaseTerm);
				ls.enterCommencementDate("10/1/2017");
				ls.selectLeaseFrequency(leaseFrequency);
				Thread.sleep(2000);
				ls.enterRegularTotalPayment(leaseRental);
				ls.enterGLPostDate();
				ls.clickOnSaveButton();
				
				LeasePaymentSchedulePage lps=new LeasePaymentSchedulePage(driver);
				lps.clickOnCloseButton();
				//Lease Classification screen
				LeaseClassificationPage lc= new LeaseClassificationPage(driver);
				lc.selectBargainPurchaseOption();
				lc.selectLeaseAccountingTreatment();
				lc.selectLeaseBookingGLTemplate();
				lc.selectLtrToARGLTemplate();
				lc.selectProduct();
				lc.clickOnPerform90PercentTestButton();
				Thread.sleep(1000);
				lc.clickOnSaveButton();
				lc.handleAlert();
				
				//LeaseAccrual screen
				LeaseAccrualPage la=new LeaseAccrualPage(driver);
				la.clickOnComputeYieldButton();
				la.clickOnSaveButton();
				la.handlePopup();
				
				//LeaseEntryHome screen
				le.selectLeaseBookingStatus();
				le.clickOnSaveButton();
				le.handlePopup1();

				//validating Result
				le.verfyTittle("Lease List", "Lease creation test pass");
				
				Reporter.log("LeaseCreattion method ran successfully", true);
	}

	public void leaseRebook(WebDriver driver,String rebook_leaseSequenceNumber) throws InterruptedException, IOException
	{
		
        //Open Lease Rebook
		LeaseMenuPage lm1= new LeaseMenuPage(driver);
		lm1.openLeaseRebookPage();
		
		//select a lease
		Thread.sleep(2000);
		LeaseListPage ll1= new LeaseListPage(driver);
		
		//enter unitNumber
		ll1.searchByUnitNumber2(rebook_leaseSequenceNumber);
		
		//Click on search
		ll1.clickOnSearchButton();
		
		//select the lease
		ll1.clickONSelectButton();
		
		//enter rebook date
		LeaseRebookParametersPage lp=new LeaseRebookParametersPage(driver);
		lp.enterRebookDate();
		
		//click on save
		lp.clickOnSaveButton();
		
		//select the lease booking status
		LeaseEntryHomePage le=new LeaseEntryHomePage(driver);
		le.selectLeaseBookingStatus();
		
		Reporter.log("LeaseRebook method ran successfully", true);
		
		//click on save Button
		le.clickOnSaveButton();
		
		//Handle popup
		le.handlePopup1();
		
		//Validate lease rebook
		le.verfyTittle("Lease List", "Lease rebook failed");
		       
	}

	public void LeaseRestructure(WebDriver driver,String restructure_un) throws InterruptedException, IOException, AWTException
	{
		
		//open lease structure screen
		LeaseMenuPage lm= new LeaseMenuPage(driver);
		lm.openLeaseStructurePage();
		
		//select a lease
		Thread.sleep(2000);
		LeaseListPage lp=new LeaseListPage(driver);
		lp.searchByUnitNumber2(restructure_un);
		lp.clickOnSearchButton();
		lp.clickONSelectButton();
		
		//enter lease restructure date
		RestructureDatePage rp= new RestructureDatePage(driver);
		rp.enterRebookDate("10/31/2017");
		rp.clickOnSaveButton();
		
		//Open Lease Restructure screen
		LeaseEntryHomePage le=new LeaseEntryHomePage(driver);
		le.clickOnRestructureScreen();
		
		//select restructure gl template
		LeaseRestructurePage lr=new LeaseRestructurePage(driver);
		lr.selectGLTemplate();
		lr.clickOnSaveButton();
		
		//90 percent test
		le.clickOnLeaseClassificationScreen();
		LeaseClassificationPage lc= new LeaseClassificationPage(driver);
		lc.clickOnPerform90PercentTestButton();
		lc.clickOnSaveButton();
		
		//compute yield
		le.clickOnLeaseAccrualScreen();
		LeaseAccrualPage la= new LeaseAccrualPage(driver);
		la.clickOnComputeYieldButton();
		la.clickOnSaveButton();
		la.handlePopup();
		
		//select Lease Status
		le.selectLeaseBookingStatus();
		le.clickOnSaveButton();
		
		//Handle alert
		le.handlePopup1();
		
		//Validate lease restructure 
		le.verfyTittle("Lease List", "Lease Restructure failed");
		
		Reporter.log("LeaseRestructure method ran successfully", true);
		
	}
	
	public void LeaseYieldVerification(WebDriver driver,String yeild_un, String yeild_accountNumber, String leaseBillingType, String leaseFrequency, String leaseTerm, String leaseRental) throws InterruptedException, AWTException, IOException
	{				
						//Opening the lease lease creation page
//						LeaseWaveHeader lwh=new LeaseWaveHeader(driver);
//						lwh.clickOnPortFolioManagement();
						LeaseMenuPage lm=new LeaseMenuPage(driver);
						lm.clickOnLeaseMenu();
						lm.clickOnNewLease();
						
						//Customer list screen
						CustomerListPage cl=new CustomerListPage(driver);
						cl.enterAccountNumber(yeild_accountNumber);
						cl.clickOnsearchButton();
						cl.clickOnSelectButton();
						
						//create new Lease screen
						LeaseCreatePage clp= new LeaseCreatePage(driver);
						clp.enterLeaseSequenceNumber(yeild_un);
						clp.clcikOnSaveButton();
						
						//LeaseInventoryInlease screen
						LeaseInventoryInLeasePage ilp=new LeaseInventoryInLeasePage(driver);
						String beforeWindow = driver.getWindowHandle();
						ilp.clickOnImportButton();
						//AssetList page
						AssetListPage asl=new AssetListPage(driver);
						asl.searchByUnitNumber(yeild_un);
						asl.clickOnSearchButton(yeild_un);
						asl.selectCheckBox();
						Thread.sleep(2000);
						asl.clickOnSelectExportButton();
						driver.switchTo().window(beforeWindow);
						//LeaseInventoryInlease screen
						Thread.sleep(2000);
						ilp.selectAsset();
						ilp.selectPrimaryAsset();
						ilp.clickOnEditButton();
						ilp.enterOdometerReading("1200");
						ilp.enterDeliverydate();
						ilp.clickOnGridSaveButton();
						ilp.clickOnPageSaveButton();
						
						//Lease Profile screen
						LeaseProfilePage lp=new LeaseProfilePage(driver);
						lp.selectOtpARGLTemplate();
						lp.selectotpIncomeGLTemplate();
						lp.selectGLCompany();
						lp.selectGLDepartment();
						lp.selectInterimRentGLTemplate();
						lp.selectreceiptCashGLTemplate();
						lp.selectProductChargeBillingType("Arrears");
						lp.selectLeaseRentalBillingType(leaseBillingType);
						lp.clickOnSaveButton();
					
						
						//leaseInvestment screen
						LeaseEntryHomePage le=new LeaseEntryHomePage(driver);
						le.clickOnInvestmentScreen();
						LeaseMilageParameterPage li=new LeaseMilageParameterPage(driver);
						li.clickOnSaveButton();
						
						//LeaseIDC setup screen
						LeaseIDCSetupPage lIDC=new LeaseIDCSetupPage(driver);
						lIDC.clickOnSaveButton();
						
						//Lease Structure screen
						le.clickOnStructureScreen();
						LeaseStructurePage ls= new LeaseStructurePage(driver);
						ls.enterNumberofPayments(leaseTerm);
						ls.enterCommencementDate("10/1/2017");
						ls.selectLeaseFrequency(leaseFrequency);
						Thread.sleep(2000);
						ls.enterRegularTotalPayment(leaseRental);
						ls.enterGLPostDate();
						ls.clickOnSaveButton();
						
						LeasePaymentSchedulePage lps=new LeasePaymentSchedulePage(driver);
						lps.clickOnCloseButton();
						//Lease Classification screen
						LeaseClassificationPage lc= new LeaseClassificationPage(driver);
						lc.selectBargainPurchaseOption();
						lc.selectLeaseAccountingTreatment();
						lc.selectLeaseBookingGLTemplate();
						lc.selectLtrToARGLTemplate();
						lc.selectProduct();
						lc.clickOnPerform90PercentTestButton();
						Thread.sleep(2000);
						lc.clickOnSaveButton();
						
						//LeaseAccrual screen
						LeaseAccrualPage la=new LeaseAccrualPage(driver);
						la.clickOnComputeYieldButton();
						//Verifying the Yeild
						la.verifyYeild("28.559905", "28.559905","28.559905");
						la.clickOnSaveButton();
						la.handlePopup();
						
						//LeaseEntryHome screen
						le.selectLeaseBookingStatus();
						le.clickOnSaveButton();
						le.handlePopup1();
//						le.handlePopup2();
						
						//validating Result
						le.verfyTittle("Lease List", "Lease creation test pass");
						
						Reporter.log("LeaseYieldVerification method ran successfully", true);
			
	}

}
