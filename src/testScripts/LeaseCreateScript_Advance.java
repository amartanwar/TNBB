package testScripts;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pom.AssetListPage;
import pom.CustomerListPage;
import pom.LeaseAccrualPage;
import pom.LeaseBlendedIncome;
import pom.LeaseCasualityPage;
import pom.LeaseClassificationPage;
import pom.LeaseContractOptionPage;
import pom.LeaseCreatePage;
import pom.LeaseEntryHomePage;
import pom.LeaseIDCSetupPage;
import pom.LeaseInventoryInLeasePage;
import pom.LeaseInvestmentPage;
import pom.LeaseMenuPage;
import pom.LeaseMilageParameterPage;
import pom.LeasePaymentSchedulePage;
import pom.LeaseProfilePage;
import pom.LeaseServicingPage;
import pom.LeaseStructurePage;
import pom.LeaseTaxFlowsPage;

public class LeaseCreateScript_Advance
{
	public void operatingLease_A2_BI1_IDC1_Ad(WebDriver driver, ExtentTest test, String lease_accountNumber,String lease_sequenceNumber, 
			String leaseAlias, String leaseInvoiceGroup, String leaseInventoryAlias1,String leaseInventoryAlias2,String leaseNumberOfPayments,String paymentsDueOnInception,
			String leaseCommencementDate, String leaseRental,String totalPaymentOnCommencement,String leaseEconomicLife, String leaseBlendedName, String leaseBlendedAmount) throws AWTException, InterruptedException, IOException 
					
	{
		
		
		LeaseMenuPage lm= new LeaseMenuPage(driver, test);
		lm.clickOnLeaseMenu();
		lm.clickOnNewLease();
		
		
		
		CustomerListPage cl= new CustomerListPage(driver, test);
		cl.enterAccountNumber(lease_accountNumber);
		cl.clickOnsearchButton();
		cl.clickOnSelectButton();
		
		
		
		LeaseCreatePage lc= new LeaseCreatePage(driver, test);
		lc.enterLeaseSequenceNumber(lease_sequenceNumber);
		lc.clcikOnSaveButton();
		
		
		
		LeaseProfilePage lp= new LeaseProfilePage(driver, test);
		lp.setAlias(leaseAlias);
		lp.selectOriginationChannel();
		lp.selectTransactiontype();
		lp.selectOTPLease();
		lp.selectOtpAccountingTreatmentID();
		lp.selectotpIncomeGLTemplate();
		lp.enterInvoiceGroup(leaseInvoiceGroup);
		lp.selectreceiptCashGLTemplate();
		lp.selectRemarketingResponsibility();
		lp.selectGLCompany();
		lp.selectGLCash();
		lp.selectGLCenter();
		lp.clickOnSaveButton();
		
		
		
		LeaseInventoryInLeasePage li= new LeaseInventoryInLeasePage(driver, test);
		String beforeWindow = li.clickOnImportButton();
		AssetListPage al= new AssetListPage(driver, test);
		al.searchByAlias(leaseInventoryAlias1);
		al.clickOnSearchButton();
		al.clickOnCurrentAll();
		al.clickOnSelectExportButton(beforeWindow);
		li.selectPrimaryAsset();
		li.clickSaveAndContinue();
		
		String beforeWindow1 = li.clickOnImportButton();
		al.searchByAlias(leaseInventoryAlias2);
		al.clickOnSearchButton();
		al.clickOnCurrentAll();
		al.clickOnSelectExportButton(beforeWindow1);
	
		//String inventoryID = li.getAssetID();
		li.clickOnPageSaveButton();
		
		
		
		LeaseMilageParameterPage lmi= new LeaseMilageParameterPage(driver, test);
		lmi.clickOnSaveButton();
		
		
		
		LeaseInvestmentPage lin= new LeaseInvestmentPage(driver, test);
		lin.clickOnSaveButton();
		
		
		
		LeaseIDCSetupPage lidc= new LeaseIDCSetupPage(driver, test);
		lidc.selectIDCTemplate();
		lidc.clickOnSaveButton();
		
		
		
		LeaseStructurePage ls= new LeaseStructurePage(driver, test);
		ls.enterNumberofPayments(leaseNumberOfPayments);
		ls.enterNumberOfPaymentsDueOnCommencement(paymentsDueOnInception);
		ls.enterCommencementDate(leaseCommencementDate);
		Thread.sleep(500);
		ls.enterRegularTotalPayment(leaseRental);
		ls.enterCommencementTotalPayment(totalPaymentOnCommencement);
		ls.clickOnSaveButton();
		
		
		
		LeasePaymentSchedulePage lps = new LeasePaymentSchedulePage(driver, test);
		lps.clickOnCloseButton();
		
		
		
		LeaseClassificationPage lcp= new LeaseClassificationPage(driver, test);
		lcp.enterTotalEconomicLife(leaseEconomicLife);
		lcp.clickOnPerform90PercentTestButton();
		lcp.selectLeaseBookingGLTemplate();
		lcp.selectLtrToARGLTemplate();
		lcp.selectOTPARGLTemplate();
		lcp.selectProduct();
		lcp.clickOnSaveButton();
		
		
		
		LeaseBlendedIncome lbi = new LeaseBlendedIncome(driver, test);
		lbi.addBlendedIncome(leaseBlendedName, leaseBlendedAmount);
		lbi.saveBlendedItem();
	//	lbi.addBlendedIncomeWithAsset("B-2", "400", inventoryID);
	//	lbi.saveBlendedItem();
	//	lbi.addBlendedIncomeChargeBack("B-3", "300", "3/1/2018");
	//	lbi.saveBlendedItem();
		lbi.clickOnCloseButton();
		
		
		
		LeaseEntryHomePage len = new LeaseEntryHomePage(driver, test);
		len.clickOnLeaseAccrualScreen();
		
		
		
		LeaseAccrualPage lap= new LeaseAccrualPage(driver, test);
		lap.clickOnComputeYieldButton();
		lap.clickOnSaveButton();
		
		
		
		LeaseContractOptionPage lco = new LeaseContractOptionPage(driver, test);
		lco.clickOnSaveButton();
		
		
		
		LeaseCasualityPage lcsp = new LeaseCasualityPage(driver, test);
		lcsp.clickOnSaveButton();
		
		
		
		LeaseTaxFlowsPage ltf = new LeaseTaxFlowsPage(driver, test);
		ltf.clickOnSaveButton();
		
		
		
		LeaseServicingPage lsp = new LeaseServicingPage(driver, test);
		lsp.clickOnSaveButton();
		
		
		
		LeaseEntryHomePage le = new LeaseEntryHomePage(driver, test);
		le.selectLeaseBookingStatus();
		le.clickOnSaveButton();
		le.handlePopup1();
		
		le.verfyTittle("Lease List", "Title is matching");
		test.log(Status.PASS, "Lease commenced successfully");
		
	}
}
