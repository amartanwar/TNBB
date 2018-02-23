package testScripts;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

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

public class LeaseDataSetupScript
{
	
	
	
	public void leaseDataSetupScript(WebDriver driver, ExtentTest test, Map<String,String> map)
					throws AWTException, InterruptedException, IOException 				
	{
		
		int i;
		
		//Navigate to create new lease
		LeaseMenuPage lm= new LeaseMenuPage(driver, test);
		lm.clickOnLeaseMenu();
		lm.clickOnNewLease();
		
		
		//Searching for particular customer
		CustomerListPage cl= new CustomerListPage(driver, test);
		cl.enterAccountNumber(map.get("AccountNumber"));
		cl.clickOnsearchButton();
		cl.clickOnSelectButton();
		
		
		//Create new lease
		LeaseCreatePage lc= new LeaseCreatePage(driver, test);
		lc.enterLeaseSequenceNumber(map.get("Lease_sequenceNumber"));
		lc.clcikOnSaveButton();
		
		
		//Enter all mandatory details in LeaseProfile page
		LeaseProfilePage lp= new LeaseProfilePage(driver, test);
		lp.setAlias((map.get("LeaseAlias")));
		lp.selectOriginationChannel();
		lp.selectTransactiontype();
		String OTP = map.get("OTPLease?");
		if(OTP.equalsIgnoreCase("Yes"))
		{
		lp.selectOTPLease();
		lp.selectOtpAccountingTreatmentID();
		lp.selectotpIncomeGLTemplate();
		}
		else
		{}		
		lp.enterInvoiceGroup((map.get("LeaseInvoiceGroup")));
		lp.selectreceiptCashGLTemplate();
		lp.selectRemarketingResponsibility();
		lp.selectGLCompany();
		lp.selectGLCash();
		lp.selectGLCenter();
		lp.clickOnSaveButton();
		
		
		//Import inventories in to the lease
		LeaseInventoryInLeasePage li= new LeaseInventoryInLeasePage(driver, test);
		String assetCount = map.get("AssetCount");
		int numberOfAssets = Integer.parseInt(assetCount);
		String beforeWindow1 = li.clickOnImportButton();
		AssetListPage alp= new AssetListPage(driver, test);
		alp.searchByAlias((map.get("LeasePrimaryInventoryAlias1")));
		alp.clickOnSearchButton();
		alp.clickOnCurrentAll();
		alp.clickOnSelectExportButton(beforeWindow1);
		li.selectPrimaryAsset();
		li.clickSaveAndContinue();	
		for(i=2;i<=numberOfAssets;i++)
		{
		String beforeWindow = li.clickOnImportButton();
		AssetListPage al= new AssetListPage(driver, test);
		al.searchByAlias((map.get("LeaseInventoryAlias"+i)));
		al.clickOnSearchButton();
		al.clickOnCurrentAll();
		al.clickOnSelectExportButton(beforeWindow);
		li.clickSaveAndContinue();
		}	
		String inventoryID = li.getAssetID();
		li.clickOnPageSaveButton();
		
		
		//Provide LeaseParameter details
		LeaseMilageParameterPage lmi= new LeaseMilageParameterPage(driver, test);
		lmi.clickOnSaveButton();
		
		
		//Provide Lease Investment details
		LeaseInvestmentPage lin= new LeaseInvestmentPage(driver, test);
		lin.enterResidualBooked((map.get("ResidualBookedAmount")));
		lin.enterResidualExpected((map.get("ResidualExpectedAmount")));
		lin.entercustomerResidualGuarantee((map.get("CustomerResidualGuaranteeAmount")));
		lin.clickOnSaveButton();
		lin.handlePopup1();
		
		
		//Provide Lease IDC details
		LeaseIDCSetupPage lidc= new LeaseIDCSetupPage(driver, test);
		lidc.selectIDCTemplate(map.get("IDCTemplate"));
		lidc.clickIDCAmount();
		lidc.enterIDCAmount((map.get("IDCAmount")));
		lidc.clickOnSaveButton();
		
		
		//Provide all mandatory Structural details
		LeaseStructurePage ls= new LeaseStructurePage(driver, test);
		String structure = map.get("Structure");
		if(structure.equalsIgnoreCase("advance"))
		{
			ls.enterNumberofPayments(map.get("LeaseNumberOfPayments"));
			ls.clickOnMaturityDate();
			Thread.sleep(1000);
			ls.enterNumberOfPaymentsDueOnCommencement(map.get("PaymentsDueOnInception"));
			ls.enterCommencementDate(map.get("LeaseCommencementDate"));
			ls.clickOnMaturityDate();
			Thread.sleep(1000);
			ls.enterDueDate(map.get("DueDay"));
			ls.clickOnMaturityDate();
			Thread.sleep(1000);
			ls.enterRegularTotalPayment(map.get("LeaseRental"));
			ls.enterCommencementTotalPayment(map.get("TotalPaymentOnCommencement"));
		}
		else
		{
			ls.enterNumberofPayments((map.get("LeaseNumberOfPayments")));
			ls.clickOnMaturityDate();
			Thread.sleep(1000);
			ls.enterCommencementDate((map.get("LeaseCommencementDate")));
			ls.clickOnMaturityDate();
			Thread.sleep(1000);
			ls.enterDueDate((map.get("DueDay")));
			ls.clickOnMaturityDate();
			Thread.sleep(1000);
			ls.enterRegularTotalPayment((map.get("LeaseRental")));
		}
		ls.clickOnSaveButton();
		
		
		//Lease Payment schedule details
		LeasePaymentSchedulePage lps = new LeasePaymentSchedulePage(driver, test);
		lps.clickOnCloseButton();
		
		
		//Perform classification test
		LeaseClassificationPage lcp= new LeaseClassificationPage(driver, test);
		lcp.enterTotalEconomicLife((map.get("LeaseEconomicLife")));
		lcp.enterTotalRemainingLife((map.get("RemainingLife")));
		lcp.clickOnPerform90PercentTestButton();
		lcp.selectLeaseAccountingTreatment((map.get("LeaseAccountingTreatment")));
		lcp.deselectTaxLease();
		lcp.deselectTracLease();
		lcp.selectLeaseBookingGLTemplate(map.get("LeaseBookingGLTemplate"));
		lcp.selectLtrToARGLTemplate(map.get("LtrToARGLTemplate"));
		lcp.selectOTPARGLTemplate(map.get("OTPARGLTemplate"));
		lcp.selectProduct(map.get("ProductType"));
		lcp.clickOnSaveButton();
		
		
		//Lease Blended income details
		LeaseBlendedIncome lbi = new LeaseBlendedIncome(driver, test);
		
		String blendedCount = map.get("NumberOfBItypes");
		String bridgevariable = blendedCount;
		int numberOfBItypes = Integer.parseInt(bridgevariable);
		for(int j=1;j<=numberOfBItypes;j++)
		{
			 String BlendType = map.get("BIType"+j);
			if(BlendType.equalsIgnoreCase("AssetBased-FAS91") || BlendType.equalsIgnoreCase("AssetBased-NonFAS91") )
			{
				String numberofBItypes = map.get("NumberofBItype"+j);
				int numberofBItype1 = Integer.parseInt(numberofBItypes);
				
				for(int k=1;k<=numberofBItype1;k++)
				{
					
					lbi.addBlendedIncomeChargeBackWithAsset((map.get("Type"+j+"BlendedName"+k)),(map.get("Type"+j+"BlendedAmount"+k)),(inventoryID),map.get("Type"+j+"DueDate"+k),(map.get("BIType"+j+"Code")));
					lbi.saveBlendedItem();
				}
			}
			else if(BlendType.equalsIgnoreCase("LeaseBased-FAS91") ||BlendType.equalsIgnoreCase("LeaseBased-NonFAS91"))
			{
				String numberofBItypes = map.get("numberofBItype"+j);
				int numberofBItype2 = Integer.parseInt(numberofBItypes);
				
				for(int k=1;k<=numberofBItype2;k++)
				{
				lbi.addBlendedIncomeChargeBack((map.get("Type"+j+"BlendedName"+k)),(map.get("Type"+j+"BlendedAmount"+k)),map.get("Type"+j+"DueDate"+k),map.get("BIType"+j+"Code"));
				lbi.saveBlendedItem();
				}
			}
	
		}
		
		lbi.clickOnCloseButton();
		
		
		//Enter Accrual Screen
		LeaseEntryHomePage len = new LeaseEntryHomePage(driver, test);
		len.clickOnLeaseAccrualScreen();
		
		
		//Compute yield
		LeaseAccrualPage lap= new LeaseAccrualPage(driver, test);
		lap.clickOnComputeYieldButton();
		lap.clickOnSaveButton();
		
		
		//Save Contract option page
		LeaseContractOptionPage lco = new LeaseContractOptionPage(driver, test);
		lco.clickOnSaveButton();
		
		
		//Save Casuality page
		LeaseCasualityPage lcsp = new LeaseCasualityPage(driver, test);
		lcsp.clickOnSaveButton();
		
		
		//Save LeaseTaxFlows page
		LeaseTaxFlowsPage ltf = new LeaseTaxFlowsPage(driver, test);
		ltf.clickOnSaveButton();
		
		
		//Save LeaseServicing page
		LeaseServicingPage lsp = new LeaseServicingPage(driver, test);
		lsp.clickOnSaveButton();
		
		
		//Changing booking Status to Commenced
		LeaseEntryHomePage le = new LeaseEntryHomePage(driver, test);
	//	le.selectLeaseBookingStatus();
		le.clickOnSaveButton();
	//	le.handlePopup1();
		
		
		//Verifying presence of Lease List title 
		le.verfyTittle("Lease List", "Title is matching");
		test.log(Status.PASS, "Lease commenced successfully");
		
	}
}

