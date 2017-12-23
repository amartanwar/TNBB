package pom;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.BasePage;
import generic.ScrollOptions;

public class LeaseProfilePage extends BasePage
{
	@FindBy(id="ctl00_F_PH_cboOverTermPaymentARGLTemplateID_cboGLTransaction")
	private WebElement  otpARGLTemplate;

	@FindBy(id="ctl00_F_PH_cboOverTermPaymentIncomeGLTemplateID_cboGLTransaction")
	private WebElement otpIncomeGLTemplate;

	@FindBy(id="ctl00_F_PH_GLSegmentAssignment_grdGLSegmentAssignment_ci_0_3_0_cboSegmentValue")
	private WebElement glCompany;

	@FindBy(id="ctl00_F_PH_GLSegmentAssignment_grdGLSegmentAssignment_ci_0_3_1_cboSegmentValue")
	private WebElement glDepartment;

	@FindBy(id="ctl00_F_PH_cboReceiptCashGLTemplateID_cboGLTransaction")
	private WebElement receiptCashGLTemplate;

	@FindBy(id="ctl00_F_PH_cboInterimRentalGLTemplate_cboGLTransaction")
	private WebElement interimRentGLTemplate;

	@FindBy(id="ctl00_F_PH_cboProductChargeBillingType_cboComboBoxControl")
	private WebElement productChargeBillingType;

	@FindBy(id="ctl00_F_PH_cboLeaseRentalBillingType_cboComboBoxControl")
	private WebElement leaseRentalBillingType;

	@FindBy(id="ctl00_Fr_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	@FindBy( id="ctl00_F_PH_Label1")
	private WebElement randomclick;

	public LeaseProfilePage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void selectOtpARGLTemplate()
	{
		WebDriverWait wt= new WebDriverWait(driver, 300);
		wt.until(ExpectedConditions.titleContains("Lease Profile"));
		Select se= new Select(otpARGLTemplate);
		se.selectByIndex(1);
	}
	
	public void selectotpIncomeGLTemplate()
	{
		Select se= new Select(otpIncomeGLTemplate);
		se.selectByIndex(1);
		
		
	}
	
	public void selectGLCompany() throws AWTException, InterruptedException
	{
		randomclick.click();
		ScrollOptions.scrollingEndofAPage();
		WebDriverWait et= new WebDriverWait(driver, 60);
		et.until(ExpectedConditions.visibilityOf(glCompany));
		Select se= new Select(glCompany);
		se.selectByIndex(1);
	}
	
	public void selectGLDepartment()
	{
		WebDriverWait et= new WebDriverWait(driver, 60);
		et.until(ExpectedConditions.visibilityOf(glDepartment));
		Select se= new Select(glDepartment);
		se.selectByIndex(1);
	}
	
	public void selectreceiptCashGLTemplate()
	{
		Select se= new Select(receiptCashGLTemplate);
		se.selectByIndex(1);
	}
	
	public void selectInterimRentGLTemplate()
	{
		Select se= new Select(interimRentGLTemplate);
		se.selectByIndex(1);
	}
	
	public void selectProductChargeBillingType(String ProductChargeBillingTypeID )
	{
		WebDriverWait et= new WebDriverWait(driver, 60);
		et.until(ExpectedConditions.visibilityOf(productChargeBillingType));
		Select se= new Select(productChargeBillingType);
		se.selectByVisibleText(ProductChargeBillingTypeID);
	}
	
	public void selectLeaseRentalBillingType(String LeaseRentalBillingTypeID)
	{
		WebDriverWait et= new WebDriverWait(driver, 60);
		et.until(ExpectedConditions.visibilityOf(leaseRentalBillingType));
		Select se= new Select(leaseRentalBillingType);
		se.selectByVisibleText(LeaseRentalBillingTypeID);
	}
	
	public void clickOnSaveButton()
	{
		saveButton.click();
	}

}
