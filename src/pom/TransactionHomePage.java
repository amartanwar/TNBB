package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;
import generic.SwitchControlToNextWindow;

public class TransactionHomePage extends BasePage{

	public TransactionHomePage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="aGeneralMenus")
	private WebElement genericTab;
	
	@FindBy(id="aLeaseMenus")
	private WebElement leaseTab;
	
	@FindBy(id="ctl00_NB_PH_LeasTranNavLink_cmdAdmin")
	private WebElement adminLink;
	
	@FindBy(id="ctl00_NB_PH_LeasTranNavLink_cmdProposal")
	private WebElement proposalLink;
	
	@FindBy(id="aServicingMenus")
	private WebElement servicingTab;
	
	
	@FindBy(id="ctl00_NB_PH_LeasTranNavLink_cmdEmployeeAssignment")
	private WebElement employeeAssignmentLink;
	
	@FindBy(id="ctl00_NB_PH_LeasTranNavLink_cmdTransactionThirdPartyAssignment")
	private WebElement thirdPartyAssignmentLink;
	
	@FindBy(id="ctl00_NB_PH_LeasTranNavLink_cmdSecurityDeposit")
	private WebElement securityDepositLink;
	
	@FindBy(id="ctl00_NB_PH_LeasTranNavLink_cmdAsset")
	private WebElement leasedAssetlink;
	
	@FindBy(id="ctl00_FC_PH_lwmWorkFlow_lnkFlowManagement")
	private WebElement flowManagementLink;
	
	@FindBy(id="ctl00_NB_PH_LeasTranNavLink_cmdSave_cmdButtonControl")
	private WebElement globalSave;
	
	@FindBy(id="ctl00_FC_PH_lwmWorkFlow_chkOverRide")
	private WebElement overRideExceptions;
	
	@FindBy(id="ctl00_NB_PH_LeasTranNavLink_cmdClose_cmdButtonControl")
	private WebElement closeButton;
	
	@FindBy(id="ctl00_PT_PH_JarkContextControl_txtStepName")
	private WebElement stepName;
	
	@FindBy(id="ctl00_PT_PH_LeaseTransactionContextUC_txtTransactionNumber")
	private WebElement transactionNumber;
	
	
	
	
	
	@FindBy(id="ctl00_NB_PH_LeasTranNavLink_cmdCreditDecision")
	private WebElement creditDecisionLink;
	
	
	
	@FindBy(id="ctl00_FC_PH_lwmWorkFlow_lnkAutoProcedure")
	private WebElement autoProcedureLink;
	
	@FindBy(id="ctl00_NB_PH_LeasTranNavLink_cmdInterimFunding_ProgressPayments")
	private WebElement fundingDetails;
	
	@FindBy(id="ctl00_NB_PH_LeasTranNavLink_cmdPaymentCalculator")
	private WebElement paymentCalculatorLink;
	
	@FindBy(id="ctl00_NB_PH_LeasTranNavLink_cmdLeaseClassification")
	private WebElement classificationTestLink;
	

	
	
	
	public void clickOnGenericTab()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(genericTab));
		genericTab.click();
	}
	
	public void clickOnLeaseTab()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(leaseTab));
		leaseTab.click();
	}
	
	
	
	public void clickOnServicingTab()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(servicingTab));
		servicingTab.click();
	}
	
	
	public void clickOnAdminLink()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(adminLink));
		adminLink.click();
	}
	
	public void clickOnProposalLink()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(proposalLink));
		proposalLink.click();
	}
	
	public void clickOnEmployeeAssignmentLink()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(employeeAssignmentLink));
		employeeAssignmentLink.click();
	}
	
	
	public void clickOnThirdPartyAssignmentLink()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(thirdPartyAssignmentLink));
		thirdPartyAssignmentLink.click();
	}
	
	
	public void clickOnSecurityDepositLink()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(securityDepositLink));
		securityDepositLink.click();
	}
	
	public String clickOnFlowManagementtLink()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(flowManagementLink));
		String currentWindowhandle = driver.getWindowHandle();
		flowManagementLink.click();
		SwitchControlToNextWindow sc = new SwitchControlToNextWindow();
		sc.waitForWndows(driver, currentWindowhandle);
		return currentWindowhandle;
		
	}
	
	
	public void clickOnGlobalSave()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(globalSave));
		globalSave.click();
	}
	
	
	public void clickOnOverrideException()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(overRideExceptions));
		overRideExceptions.click();
	}

	
	public void opportunityVerification()
	{
		String var = stepName.getAttribute("value");
		if(var.equals(" S5A-CIP Completed"))
		{
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(closeButton));
			closeButton.click();
			
		}
	}

	
	public void locVerification()
	{
		String var1 = stepName.getAttribute("value");
		if(var1.equals(" S7-Final Approval"))
		{
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(closeButton));
			closeButton.click();
			
		}
	}
	
	public void takedownVerification()
	{
		String var1 = stepName.getAttribute("value");
		if(var1.equals(" S19-Commenced/Syndicated"))
		{
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(closeButton));
			closeButton.click();
			
		}
	}



	public String fetchTransactionNumber()
	{
		
		String TransactionNumber = transactionNumber.getAttribute("value");
		return TransactionNumber;
	}
	

	
	
	public void clickOnCreditDecisionLink()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(creditDecisionLink));
		creditDecisionLink.click();
	}

	public void clickOnLeasedAssetLink()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(leasedAssetlink));
		leasedAssetlink.click();
	}

	public void clickOnPaymentCalculatorLink()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(paymentCalculatorLink));
		paymentCalculatorLink.click();
	}
	
	public void clickOnClassificationTestLink()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(classificationTestLink));
		classificationTestLink.click();
	}
	
	
	
	
	public String clickOnAutoProceduretLink()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(autoProcedureLink));
		String currentWindowhandle = driver.getWindowHandle();
		autoProcedureLink.click();
		SwitchControlToNextWindow sc = new SwitchControlToNextWindow();
		sc.waitForWndows(driver, currentWindowhandle);
		return currentWindowhandle;
		
	}
	
	
	public void clickOnFundingDetailsLink()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(fundingDetails));
		fundingDetails.click();
	}
	
	
}
