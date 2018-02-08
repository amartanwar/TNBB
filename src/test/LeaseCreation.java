package test;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
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

public class LeaseCreation extends BaseTest
{
	@Test
	public void createLease () throws InterruptedException, AWTException, IOException 
	{
		
		
		test=reports.createTest("createLease","Creating lease for test data");
		LeaseMenuPage lm= new LeaseMenuPage(driver, test);
		lm.clickOnLeaseMenu();
		lm.clickOnNewLease();
		
		
		
		CustomerListPage cl= new CustomerListPage(driver, test);
		cl.enterAccountNumber("1");
		cl.clickOnsearchButton();
		cl.clickOnSelectButton();
		
		
		
		LeaseCreatePage lc= new LeaseCreatePage(driver, test);
		lc.enterLeaseSequenceNumber("Lease-5");
		lc.clcikOnSaveButton();
		
		
		
		LeaseProfilePage lp= new LeaseProfilePage(driver, test);
		lp.setAlias("Lease-5");
		lp.selectOriginationChannel();
		lp.selectTransactiontype();
		lp.selectOTPLease();
		lp.selectOtpAccountingTreatmentID();
		lp.selectotpIncomeGLTemplate();
		lp.enterInvoiceGroup("jj invoice group");
		lp.selectreceiptCashGLTemplate();
		lp.selectRemarketingResponsibility();
		lp.selectGLCompany();
		lp.selectGLCash();
		lp.selectGLCenter();
		lp.clickOnSaveButton();
		
		
		
		LeaseInventoryInLeasePage li= new LeaseInventoryInLeasePage(driver, test);
		String beforeWindow = li.clickOnImportButton();
		AssetListPage al= new AssetListPage(driver, test);
		al.searchByAlias("Asset-6");
		al.clickOnSearchButton();
		al.clickOnCurrentAll();
		al.clickOnSelectExportButton(beforeWindow);
		li.selectPrimaryAsset();
		li.clickSaveAndContinue();
		
		String beforeWindow1 = li.clickOnImportButton();
		al.searchByAlias("Asset-7");
		al.clickOnSearchButton();
		al.clickOnCurrentAll();
		al.clickOnSelectExportButton(beforeWindow1);
	
		String inventoryID = li.getAssetID();
		li.clickOnPageSaveButton();
		
		
		
		LeaseMilageParameterPage lmi= new LeaseMilageParameterPage(driver, test);
		lmi.clickOnSaveButton();
		
		
		
		LeaseInvestmentPage lin= new LeaseInvestmentPage(driver, test);
		lin.clickOnSaveButton();
		
		
		
		LeaseIDCSetupPage lidc= new LeaseIDCSetupPage(driver, test);
		lidc.selectIDCTemplate();
		lidc.clickOnSaveButton();
		
		
		
		LeaseStructurePage ls= new LeaseStructurePage(driver, test);
		ls.enterNumberofPayments("12");
		ls.enterCommencementDate("3/1/2018");
		Thread.sleep(500);
		ls.enterRegularTotalPayment("200");
		ls.clickOnSaveButton();
		
		
		
		LeasePaymentSchedulePage lps = new LeasePaymentSchedulePage(driver, test);
		lps.clickOnCloseButton();
		
		
		
		LeaseClassificationPage lcp= new LeaseClassificationPage(driver, test);
		lcp.enterTotalEconomicLife("2");
		lcp.clickOnPerform90PercentTestButton();
		lcp.selectLeaseBookingGLTemplate();
		lcp.selectLtrToARGLTemplate();
		lcp.selectOTPARGLTemplate();
		lcp.selectProduct();
		lcp.clickOnSaveButton();
		
		
		
		LeaseBlendedIncome lbi = new LeaseBlendedIncome(driver, test);
		lbi.addBlendedIncome("B-1", "500");
		lbi.saveBlendedItem();
		lbi.addBlendedIncomeWithAsset("B-2", "400", inventoryID);
		lbi.saveBlendedItem();
		lbi.addBlendedIncomeChargeBack("B-3", "300", "3/1/2018");
		lbi.saveBlendedItem();
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
