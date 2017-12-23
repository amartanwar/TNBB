package testscripts.Lease;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import pom.AssetListPage;
import pom.CreateNewLeasePage;
import pom.CustomerListPage;
import pom.LeaseAccrualPage;
import pom.LeaseClassificationPage;
import pom.LeaseEntryHomePage;
import pom.LeaseIDCSetupPage;
import pom.LeaseInventoryInLeasePage;
import pom.LeaseInvestementPage;
import pom.LeaseMenuPage;
import pom.LeasePaymentSchedulePage;
import pom.LeaseProfilePage;
import pom.LeaseStructurePage;

public class LeaseCreationMethod 
{
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
				CreateNewLeasePage clp= new CreateNewLeasePage(driver);
				clp.enterLeaseSequenceNumber(lease_un);
				clp.clcikOnSaveButton();
				
				//LeaseInventoryInlease screen
				LeaseInventoryInLeasePage ilp=new LeaseInventoryInLeasePage(driver);
				String beforeWindow = driver.getWindowHandle();
				ilp.clickOnAddButton();
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
				LeaseInvestementPage li=new LeaseInvestementPage(driver);
				li.clickOnSaveButton();
				
				//LeaseIDC setup screen
				LeaseIDCSetupPage lIDC=new LeaseIDCSetupPage(driver);
				lIDC.clickOnCloseButton();
				
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
				lc.selectClientLeaseType();
				lc.clickOnPerform90PercentTestButton();
				Thread.sleep(2000);
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
}
