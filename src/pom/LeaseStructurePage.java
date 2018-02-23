package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;
import generic.SystemDate;

public class LeaseStructurePage extends BasePage
{
	@FindBy(id="igtxtctl00_FC_PH_txtTotalPaymentNumber")
	private WebElement numberOfPayments;

	@FindBy(id="igtxtctl00_FC_PH_txtTotalInceptionNumber")
	private WebElement numberOfPaymentsDueOnInception;

	@FindBy(id="ctl00_FC_PH_txtInceptionDate_input")
	private WebElement commencementDate;
	
	@FindBy(id="ctl00_FC_PH_cboRentalFrequency_cboComboBoxControl")
	private WebElement leaseFrequency;
	
	@FindBy(id="ctl00_FC_PH_cboPaymentStructure_cboComboBoxControl")
	private WebElement paymentStructure;

	@FindBy(id="igtxtctl00_FC_PH_txtInceptionRentalExecutoryFeesAmount_txtWebCurrencyEdit")
	private WebElement commencementRentalExecutoryFee;

	@FindBy(id="igtxtctl00_FC_PH_txtInceptionNonRentalExecutoryFeesAmount_txtWebCurrencyEdit")
	private WebElement commencementNonRentalExecutoryFee; 

	@FindBy(id="igtxtctl00_FC_PH_txtInceptionPaymentAmount_txtWebCurrencyEdit")
	private WebElement commencementTotalPayment; 

	@FindBy(id="igtxtctl00_FC_PH_txtRegularRentalExecutoryFee_txtWebCurrencyEdit")
	private WebElement regularRentalExecutoryFee;

	@FindBy(id="igtxtctl00_FC_PH_txtRegularNonRentalExecutoryFee_txtWebCurrencyEdit")
	private WebElement regularNonRentalExecutoryFee; 

	@FindBy(id="igtxtctl00_FC_PH_txtRegularPaymentAmount_txtWebCurrencyEdit")
	private WebElement regularTotalPayment; 

	@FindBy(id="ctl00_FC_PH_txtPostDate_input")
	private WebElement glPostDate;

	@FindBy(id="ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	@FindBy(id="igtxtctl00_FC_PH_txtDueDay")
	private WebElement dueDay;
	
	@FindBy(id="ctl00_FC_PH_txtMaturityDate_input")
	private WebElement maturityDate;

	public LeaseStructurePage(WebDriver driver, ExtentTest test) 
	{
		super(driver,test);
		PageFactory.initElements(driver, this);
	}
	
	public void enterNumberofPayments(String payments) throws InterruptedException
	{
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(numberOfPayments));
		numberOfPayments.sendKeys(payments);
		Thread.sleep(500);
	}
	
	public void enterNumberOfPaymentsDueOnCommencement(String paymentsDueOnInception)
	{
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(numberOfPaymentsDueOnInception));
		numberOfPaymentsDueOnInception.clear();
		numberOfPaymentsDueOnInception.sendKeys(paymentsDueOnInception);
	}
	
	public void enterCommencementDate(String date)
	{
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(commencementDate));
		commencementDate.sendKeys(date);
	}
	
	public void enterCommencementDate() throws InterruptedException
	{
		Thread.sleep(500);
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(commencementDate));
		commencementDate.sendKeys(SystemDate.currentDate());
	}
	
	public void enterRegularRentalExecutoryFee(String fee)
	
	{
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(regularRentalExecutoryFee));
		regularRentalExecutoryFee.sendKeys(fee);
	}
	
	public void enterRegularNonRentalExecutoryFee(String fee)
	{
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(regularNonRentalExecutoryFee));
		regularNonRentalExecutoryFee.sendKeys(fee);
	}
	
	public void enterRegularTotalPayment(String fee)
	{
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(regularTotalPayment));
		regularTotalPayment.clear();
		regularTotalPayment.sendKeys(fee);
	}
	
	public void enterCommencementRentalExecutoryFee(String fee)
	{
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(commencementRentalExecutoryFee));
		commencementRentalExecutoryFee.sendKeys(fee);
	}
	
	public void enterCommencementNonRentalExecutoryFee(String fee)
	{
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(commencementNonRentalExecutoryFee));
		commencementNonRentalExecutoryFee.sendKeys(fee);
	}
	
	
	public void enterCommencementTotalPayment(String totalPaymentOnCommencement)
	{
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(commencementTotalPayment));
		commencementTotalPayment.sendKeys(totalPaymentOnCommencement);
	}
	
	public void enterGLPostDate()
	{
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(glPostDate));
		glPostDate.sendKeys(SystemDate.currentDate());
	}
	
	public void clickOnSaveButton() 
	{
		WebDriverWait wt = new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.titleContains("Lease Structure"));
 		saveButton.click();
	}
	
	public void selectPaymentStructure(String paymentStructureType)
	{
		Select se= new Select(paymentStructure);
		se.selectByVisibleText(paymentStructureType);
		se.selectByIndex(1);
	}
	
	public void selectLeaseFrequency(String leaseFrequencyType)
	{
		Select se= new Select(leaseFrequency);
		se.selectByVisibleText(leaseFrequencyType);
		se.selectByIndex(1);
	}

	public void enterDueDate(String dueDate)
	{
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(dueDay));
		dueDay.clear();
		dueDay.sendKeys(dueDate);
	}
	
	public void clickOnMaturityDate()
	{
		WebDriverWait wt = new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(maturityDate));
		maturityDate.click();
	}
}


