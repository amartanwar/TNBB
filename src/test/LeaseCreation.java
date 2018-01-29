package test;

import java.awt.AWTException;

import org.testng.annotations.Test;

import generic.BaseTest;
import pom.AssetListPage;
import pom.CustomerListPage;
import pom.LeaseClassificationPage;
import pom.LeaseCreatePage;
import pom.LeaseIDCSetupPage;
import pom.LeaseInventoryInLeasePage;
import pom.LeaseInvestmentPage;
import pom.LeaseMenuPage;
import pom.LeaseMilageParameterPage;
import pom.LeaseProfilePage;
import pom.LeaseStructurePage;

public class LeaseCreation extends BaseTest
{
	@Test
	public void createLease () throws InterruptedException, AWTException 
	{
//		test=reports.createTest("createLease","Creating lease for test data");
		LeaseMenuPage lm= new LeaseMenuPage(driver, test);
		lm.clickOnLeaseMenu();
		lm.clickOnNewLease();
		
		CustomerListPage cl= new CustomerListPage(driver, test);
		cl.enterAccountNumber("1");
		cl.clickOnsearchButton();
		cl.clickOnSelectButton();
		
		LeaseCreatePage lc= new LeaseCreatePage(driver, test);
		lc.enterLeaseSequenceNumber("auto-5");
		lc.clcikOnSaveButton();
				
		LeaseProfilePage lp= new LeaseProfilePage(driver, test);
		lp.setAlias("auto-5");
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
		al.searchByAlias("auto-6");
		al.clickOnSearchButton();
		al.clickOnCurrentAll();
		al.clickOnSelectExportButton(beforeWindow);
		
		li.selectPrimaryAsset();
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
		ls.enterCommencementDate("1/26/2018");
		ls.enterRegularTotalPayment("2000");
		ls.clickOnSaveButton();
		
		LeaseClassificationPage lcp= new LeaseClassificationPage(driver, test);
		lcp.enterTotalEconomicLife("2");
		lcp.selectLeaseBookingGLTemplate();
		lcp.selectLtrToARGLTemplate();
		lcp.selectProduct();
		
		
		
				
	}
}
