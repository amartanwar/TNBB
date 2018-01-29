package pom;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;
import generic.ScrollOptions;

public class LeaseProfilePage extends BasePage
{
	@FindBy(id="ctl00_FC_PH_txtAlias")
	private WebElement alias;
	
	@FindBy(id="ctl00_FC_PH_cboOriginationChannel_cboComboBoxControl")
	private WebElement originationChannel;
	
	@FindBy(id="ctl00_FC_PH_cboTransactionTypeID_cboComboBoxControl")
	private WebElement transactionType;
	
	@FindBy(id="ctl00_FC_PH_txtDefaultInvoiceGroupName")
	private WebElement invoiceGroup;
	
	@FindBy(id="ctl00_FC_PH_chkOTPLease")
	private WebElement otpLease;
	
	@FindBy(id="ctl00_FC_PH_cboOverTermPaymentAccountingTreatmentID_cboAccountingTreatment")
	private WebElement  otpAccountingTreatmentID;

	@FindBy(id="ctl00_FC_PH_cboOverTermPaymentIncomeGLTemplateID_cboGLTransaction")
	private WebElement otpIncomeGLTemplate;

	@FindBy(id="ctl00_FC_PH_GLSegmentAssignment_grdGLSegmentAssignment_ci_0_2_0_cboSegmentValue")
	private WebElement glCompany;

	@FindBy(id="ctl00_FC_PH_GLSegmentAssignment_grdGLSegmentAssignment_ci_0_2_1_cboSegmentValue")
	private WebElement glCash;
	
	@FindBy(id="ctl00_FC_PH_GLSegmentAssignment_grdGLSegmentAssignment_ci_0_2_2_cboSegmentValue")
	private WebElement glCenter;

	@FindBy(id="ctl00_FC_PH_cboReceiptCashGLTemplateID_cboGLTransaction")
	private WebElement receiptCashGLTemplate;
	
	@FindBy(id="ctl00_FC_PH_cboRemarketingAgent_cboComboBoxControl")
	private WebElement remarketingResponsibility;

	@FindBy(id="ctl00_F_PH_cboInterimRentalGLTemplate_cboGLTransaction")
	private WebElement interimRentGLTemplate;


	@FindBy(id="ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	@FindBy( id="ctl00_F_PH_Label1")
	private WebElement randomclick;

	public LeaseProfilePage(WebDriver driver, ExtentTest test) 
	{
		super(driver,test);
		PageFactory.initElements(driver, this);
	}
	
	public void setAlias(String setAlias)
	{
		WebDriverWait wt= new WebDriverWait(driver, 300);
		wt.until(ExpectedConditions.visibilityOf(alias));
		alias.sendKeys(setAlias);
	}
	
	public void selectOriginationChannel()
	{
		WebDriverWait wt= new WebDriverWait(driver, 300);
		wt.until(ExpectedConditions.visibilityOf(originationChannel));
		Select se= new Select(originationChannel);
		se.selectByIndex(1);
	}
	
	public void selectTransactiontype()
	{
		WebDriverWait wt= new WebDriverWait(driver, 300);
		wt.until(ExpectedConditions.visibilityOf(transactionType));
		Select se= new Select(transactionType);
		se.selectByIndex(1);
	}
	
	public void enterInvoiceGroup(String invGroup)
	{
		WebDriverWait wt= new WebDriverWait(driver, 300);
		wt.until(ExpectedConditions.visibilityOf(invoiceGroup));
		invoiceGroup.sendKeys(invGroup);
	}
	
	public void selectOTPLease()
	{
		WebDriverWait wt= new WebDriverWait(driver, 300);
		wt.until(ExpectedConditions.visibilityOf(otpLease));
		otpLease.click();
	}
	
	public void selectOtpAccountingTreatmentID()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(otpAccountingTreatmentID));
		Select se= new Select(otpAccountingTreatmentID);
		se.selectByIndex(1);
	}
	
	public void selectotpIncomeGLTemplate()
	{
		Select se= new Select(otpIncomeGLTemplate);
		se.selectByIndex(1);
		
		
	}
	
	public void selectGLCompany() throws AWTException, InterruptedException
	{
		ScrollOptions.scrollingEndofAPage();
		WebDriverWait et= new WebDriverWait(driver, 60);
		et.until(ExpectedConditions.visibilityOf(glCompany));
		Select se= new Select(glCompany);
		se.selectByIndex(1);
	}
	
	public void selectGLCash()
	{
		WebDriverWait et= new WebDriverWait(driver, 60);
		et.until(ExpectedConditions.visibilityOf(glCash));
		Select se= new Select(glCash);
		se.selectByIndex(1);
	}
	
	public void selectGLCenter()
	{
		WebDriverWait et= new WebDriverWait(driver, 60);
		et.until(ExpectedConditions.visibilityOf(glCenter));
		Select se= new Select(glCenter);
		se.selectByIndex(1);
	}
	
	public void selectreceiptCashGLTemplate()
	{
		Select se= new Select(receiptCashGLTemplate);
		se.selectByIndex(2);
	}
	
	public void selectRemarketingResponsibility()
	{
		WebDriverWait et= new WebDriverWait(driver, 60);
		et.until(ExpectedConditions.visibilityOf(remarketingResponsibility));
		Select se= new Select(remarketingResponsibility);
		se.selectByIndex(2);
	}
	
	public void selectInterimRentGLTemplate()
	{
		Select se= new Select(interimRentGLTemplate);
		se.selectByIndex(1);
	}
	
	public void clickOnSaveButton()
	{
		saveButton.click();
	}

}
