package testScripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import pom.AssetListPage;
import pom.CreateTransactionPage;
import pom.CustomerListPage;
import pom.JarkFlowPage;
import pom.LeaseClassificationPage;
import pom.LeaseInventoryInLeasePage;
import pom.OriginationMenu;
import pom.TransactionAdminPage;
import pom.TransactionAutoProcedurePage;
import pom.TransactionBriefPage;
import pom.TransactionCreditDecisionPage;
import pom.TransactionFundingDetailsPage;
import pom.TransactionHomePage;
import pom.TransactionLeaseAssetPage;
import pom.TransactionListPage;
import pom.TransactionPaymentCalculatorPage;
import pom.TransactionProposalPage;
import pom.VendorInvoiceAssets;
import pom.VendorInvoiceEntryHome;
import pom.VendorInvoiceListPage;
import pom.VendorInvoiceOtherCostPage;
import pom.VendorInvoiceProfilePage;
import pom.VendorMenu;
import pom.WorkFlowClassesMenu;

public class FrontEndLeaseDataSetupScript 

{
	
	public void frontendScript(WebDriver driver, ExtentTest test, Map<String,String> map) throws InterruptedException
	{
		
		
		OriginationMenu om = new OriginationMenu(driver, test);
		om.clickoriginationinstallation();
		
		
		//VendorInvoice
		
		VendorMenu vm = new VendorMenu(driver, test);
		vm.clickVendorMenu();
		vm.clickInvoiceManagementLink();
		
		VendorInvoiceListPage vil = new VendorInvoiceListPage(driver, test);
		vil.clickAddButton();
		
		VendorInvoiceProfilePage vipp = new VendorInvoiceProfilePage(driver, test);
		vipp.enterCustomerNumber(map.get("Account Number"));
		vipp.selectGLTemplate(map.get("GL Template"));
		vipp.enterVendorNumber(map.get("Vendor"));
		vipp.entervendorInvoiceNumber(map.get("Vendor Invoice Number"));
		vipp.enterInvoiceTotal(map.get("Invoice Total"));
		vipp.enterNumberOfAssets(map.get("Total Number Of Assets"));
		vipp.enterTotalAquisitionCost(map.get("Total Acquisition Cost"));
		vipp.clickOnSaveButton();
		
		
		LeaseInventoryInLeasePage linp = new LeaseInventoryInLeasePage(driver, test);
		
		
		String noOfAssets = map.get("Total Number Of Assets");
		int totalnumberofassets = Integer.parseInt(noOfAssets);
		
		for(int i=1;i<=totalnumberofassets;i++)
		{
		String beforewindow4 = linp.clickOnImportButton();
		
		AssetListPage alp= new AssetListPage(driver, test);
		alp.searchByAlias(map.get("InventoryAlias"+i));
		alp.clickOnSearchButton();
		alp.clickOnCurrentAll();
		alp.clickOnSelectExportButton(beforewindow4);
		linp.clickSaveAndContinue();
		}
		
		VendorInvoiceAssets via = new VendorInvoiceAssets(driver, test);
		via.clickOnSelectAllButton();
		via.selectAssignmentSelect();
		via.enterAmount(map.get("Amount"));
		via.clickAssignmentAddButton();
		via.clickAssignmentButton();
		via.clickSaveButton();
		
		
		VendorInvoiceOtherCostPage vic = new VendorInvoiceOtherCostPage(driver, test);
		vic.clickCloseButton();
		
		VendorInvoiceEntryHome vih = new VendorInvoiceEntryHome(driver, test);
		vih.changeBookingStatus();
		String VINumber = vih.clickSaveButton();
		
		//Opportunity
		
		WorkFlowClassesMenu wfc = new WorkFlowClassesMenu(driver, test);
		wfc.clickOnWokFlowClassesMenu();
		wfc.clickOnNewTransaction();
		
		CustomerListPage clp = new CustomerListPage(driver, test);
		clp.enterAccountNumber(map.get("Account Number"));
		clp.clickOnsearchButton();
		clp.clickOnSelectButton();
		
		CreateTransactionPage ctp = new CreateTransactionPage(driver, test);
		ctp.clickSelectButton();
		
		TransactionBriefPage tbp = new TransactionBriefPage(driver, test);
		tbp.selectOriginationChannel(map.get("Origination Channel"));
		tbp.clickOnSaveButton();
		
		TransactionHomePage thp = new TransactionHomePage(driver, test);
		thp.clickOnGenericTab();
		thp.clickOnAdminLink();
		
		TransactionAdminPage tap = new TransactionAdminPage(driver, test);
		tap.selectReceiptCashGLTemplate(map.get("Receipt Cash GL Template"));
		tap.selectBankProductCode(map.get("Bank Product Code"));
		tap.selectCollateralCode(map.get("Collateral Code"));
		tap.selectLoanPurposeCode(map.get("Loan Purpose Code"));
		tap.selectRemarketingResponsibility(map.get("Remarketing Responsibilty"));
		tap.clickSaveButton();
		
		thp.clickOnProposalLink();
		
		TransactionProposalPage tpp = new TransactionProposalPage(driver, test);
		tpp.enterOpportunityAmount(map.get("Opportunity Amount"));
		tpp.selectSpecializedCategoryAsset(map.get("Specialized Asset Category"));
		tpp.enterexhibitAmount(map.get("Exhibit Amount"));
		tpp.selectTransactionType(map.get("Transaction Type"));
		tpp.checkIndexBased();
		tpp.enterNumberOfPayments(map.get("Number Of Payments"));
		//tpp.clickExhibitSaveButton();
		tpp.clickSaveButton();
		
		thp.clickOnGlobalSave();
		//thp.clickOnServicingTab();
		//thp.clickOnEmployeeAssignmentLink();
		
		
		for(int i=1;i<=5;i++)
		{
		thp.clickOnOverrideException();
		String beforewindow1 = thp.clickOnFlowManagementtLink();
		
		JarkFlowPage jfp = new JarkFlowPage(driver, test);
		jfp.clickOnFlowChange();
		jfp.clickOnDefaultNextPath();
		jfp.clickOnContinue(beforewindow1);
		}
		
		
		String OpportunitytransactionNumber = thp.fetchTransactionNumber();
		thp.opportunityVerification();
		
		
		
		
		
		
		
		
		//LOC

		wfc.clickOnWokFlowClassesMenu();
		wfc.clickOnOpenTransaction();
		
	
		TransactionListPage tlp = new TransactionListPage(driver, test);
		tlp.enterTransactionNumber(OpportunitytransactionNumber.trim()+"-01");
		tlp.clickSearchButton();
		tlp.clickSelectButton();
		
		thp.clickOnGenericTab();
		thp.clickOnCreditDecisionLink();
	
		TransactionCreditDecisionPage tcd = new TransactionCreditDecisionPage(driver, test);
		tcd.clickOnAddButton();
		tcd.enterRequestedAmount(map.get("Requested Amount"));
		tcd.enterCreditDecisionName(map.get("Credit Decision Name"));
		tcd.enterDecisionDate(map.get("Credit Decision Date"));
		tcd.enterCommitmentExpiryDate(map.get("Commitment Expiry Date"));
		tcd.enterChangeInApprovedAmout(map.get("Change in Approved Amount"));
		tcd.clickOnSaveButton();
		tcd.clickOnPageSaveButton();
		
		
		//thp.clickOnAdminLink();
	
		//tap.clickSaveButton();
		
		thp.clickOnGlobalSave();
		
		for(int j=1;j<=4;j++)
		{
		thp.clickOnOverrideException();
		String beforewindow1 = thp.clickOnFlowManagementtLink();
		
		JarkFlowPage jfp = new JarkFlowPage(driver, test);
		jfp.clickOnFlowChange();
		jfp.clickOnDefaultNextPath();
		jfp.clickOnContinue(beforewindow1);
		}
		
		String beforewindow2 = thp.clickOnAutoProceduretLink();
		
		TransactionAutoProcedurePage taup = new TransactionAutoProcedurePage(driver, test);
		taup.clickRunButton();
		taup.handlePopup1();
		taup.clickCloseButton(beforewindow2);
		
		String LOCtransactionNumber = thp.fetchTransactionNumber();
		thp.locVerification();
		
	
		
		
		
		//TakeDown
		
		tlp.enterTransactionNumber(LOCtransactionNumber.trim()+"-01");
		tlp.clickSearchButton();
		tlp.clickSelectButton();
		
		thp.clickOnGenericTab();
		thp.clickOnFundingDetailsLink();
		
		TransactionFundingDetailsPage tfd = new TransactionFundingDetailsPage(driver, test);
		String beforewindow3 = tfd.clickAddButton();
		
		
		
		vil.addVendorInvoiceNumber(VINumber);
		vil.clickOnSearchButton();
		vil.clickOnSelectALLButton();
		vil.clickOnSelectButton(beforewindow3);
		
		tfd.clickSaveButton();

		
		thp.clickOnLeaseTab();
		thp.clickOnLeasedAssetLink();
		
		TransactionLeaseAssetPage tla = new TransactionLeaseAssetPage(driver, test);
		tla.clickSaveButton();
		
		thp.clickOnPaymentCalculatorLink();
		
		TransactionPaymentCalculatorPage tpcp = new TransactionPaymentCalculatorPage(driver, test);
		tpcp.enterNumberOfPayments(map.get("Number Of Payments"));
		tpcp.enterCommencementDate(map.get("Commencement Date"));
		tpcp.selectPaymentFrequency(map.get("Payment Frequency"));
		tpcp.selectPaymentStructure(map.get("Payment Structure"));
		tpcp.enterNumberCommencementPayments(map.get("Number Of Commencement Payments"));
		tpcp.enterRegularPayment(map.get("Regular Payment Amount"));
		tpcp.clickGeneratePaymentsButton();
		tpcp.clickSaveButton();
		
		thp.clickOnClassificationTestLink();
		
		LeaseClassificationPage lcp= new LeaseClassificationPage(driver, test);
		lcp.enterTotalEconomicLife(map.get("Total Economic Life"));
		lcp.enterTotalRemainingLife(map.get("Total Remaining Life"));
		lcp.clickOnPerform90PercentTestButton();
		lcp.selectLeaseAccountingTreatment(map.get("Lease Accounting Treatment Type"));
		lcp.deselectTaxLease();
	//	lcp.deselectTracLease();
		lcp.selectLeaseBookingGLTemplate(map.get("Lease Booking GL Template"));
		lcp.selectLtrToARGLTemplate(map.get("LTR-AR GL Template"));
	//	lcp.selectOTPARGLTemplate(map.get("OTPARGLTemplate"));
		lcp.selectProduct(map.get("Product Code"));
		lcp.clickOnSaveButton();
		
		thp.clickOnGlobalSave();
		
		for(int k=1;k<=6;k++)
		{
		thp.clickOnOverrideException();
		String beforewindow1 = thp.clickOnFlowManagementtLink();
		
		JarkFlowPage jfp = new JarkFlowPage(driver, test);
		jfp.clickOnFlowChange();
		jfp.clickOnDefaultNextPath();
		jfp.clickOnContinue(beforewindow1);
		}
		
		thp.takedownVerification();
		
	}
	
}
