package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.BasePage;
import generic.SystemDate;

public class LeaseStructurePage extends BasePage
{
	@FindBy(id="igtxtctl00_F_PH_txtTotalPaymentNumber")
	private WebElement numberOfPayments;

	@FindBy(id="igtxtctl00_F_PH_txtTotalInceptionNumber")
	private WebElement numberOfPaymentsDueOnCommencement;

	@FindBy(id="ctl00_F_PH_txtInceptionDate_input")
	private WebElement commencementDate;
	
	@FindBy(id="ctl00_F_PH_cboRentalFrequency_cboComboBoxControl")
	private WebElement leaseFrequency;
	
	@FindBy(id="ctl00_F_PH_cboPaymentStructure_cboComboBoxControl")
	private WebElement paymentStructure;

	@FindBy(id="igtxtctl00_F_PH_txtInceptionRentalExecutoryFeesAmount_txtWebCurrencyEdit")
	private WebElement commencementRentalExecutoryFee;

	@FindBy(id="igtxtctl00_F_PH_txtInceptionNonRentalExecutoryFeesAmount_txtWebCurrencyEdit")
	private WebElement commencementNonRentalExecutoryFee; 

	@FindBy(id="igtxtctl00_F_PH_txtInceptionAdminFeeAmount_txtWebCurrencyEdit")
	private WebElement commencementAdminFee;

	@FindBy(id="igtxtctl00_F_PH_txtInceptionPaymentAmount_txtWebCurrencyEdit")
	private WebElement commencementTotalPayment; 

	@FindBy(id="igtxtctl00_F_PH_txtRegularRentalExecutoryFee_txtWebCurrencyEdit")
	private WebElement regularRentalExecutoryFee;

	@FindBy(id="igtxtctl00_F_PH_txtRegularNonRentalExecutoryFee_txtWebCurrencyEdit")
	private WebElement regularNonRentalExecutoryFee; 

	@FindBy(id="igtxtctl00_F_PH_txtRegularAdminFeeAmount_txtWebCurrencyEdit")
	private WebElement regularAdminFee;

	@FindBy(id="igtxtctl00_F_PH_txtRegularPaymentAmount_txtWebCurrencyEdit")
	private WebElement regularTotalPayment; 

	@FindBy(id="ctl00_F_PH_txtPostDate_input")
	private WebElement glPostDate;

	@FindBy(id="ctl00_Fr_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;

	public LeaseStructurePage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void enterNumberofPayments(String payments)
	{
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(numberOfPayments));
		numberOfPayments.sendKeys(payments);
	}
	
	public void enterNumberOfPaymentsDueOnCommencement(String paymentsDue)
	{
		numberOfPaymentsDueOnCommencement.sendKeys(paymentsDue);
	}
	
	public void enterCommencementDate(String date)
	{
		commencementDate.sendKeys(date);
	}
	
	public void enterCommencementDate()
	{
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(commencementDate));
		commencementDate.sendKeys(SystemDate.currentDate());
	}
	
	public void enterRegularRentalExecutoryFee(String fee)
	{
		regularRentalExecutoryFee.sendKeys(fee);
	}
	
	public void enterRegularNonRentalExecutoryFee(String fee)
	{
		regularNonRentalExecutoryFee.sendKeys(fee);
	}
	
	public void enterRegularAdminFee(String fee)
	{
		regularAdminFee.clear();
		regularAdminFee.sendKeys(fee);
	}
	
	public void enterRegularTotalPayment(String fee)
	{
		regularTotalPayment.clear();
		regularTotalPayment.sendKeys(fee);
	}
	
	public void enterCommencementRentalExecutoryFee(String fee)
	{
		commencementRentalExecutoryFee.sendKeys(fee);
	}
	
	public void enterCommencementNonRentalExecutoryFee(String fee)
	{
		commencementNonRentalExecutoryFee.sendKeys(fee);
	}
	
	public void enterCommencementAdminFee(String fee)
	{
		commencementAdminFee.sendKeys(fee);
	}
	
	public void enterCommencementTotalPayment(String fee)
	{
		commencementTotalPayment.sendKeys(fee);
	}
	
	public void enterGLPostDate()
	{
		glPostDate.sendKeys(SystemDate.currentDate());
	}
	
	public void clickOnSaveButton() throws InterruptedException
	{
		Thread.sleep(1000);
		saveButton.click();
	}
	
	public void selectPaymentStructure(String paymentStructureType)
	{
		Select se= new Select(paymentStructure);
		se.selectByVisibleText(paymentStructureType);
	}
	
	public void selectLeaseFrequency(String leaseFrequencyType)
	{
		Select se= new Select(leaseFrequency);
		se.selectByVisibleText(leaseFrequencyType);
//		se.selectByIndex(2);
	}

	
}


