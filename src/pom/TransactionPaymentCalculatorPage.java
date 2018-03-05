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

public class TransactionPaymentCalculatorPage extends BasePage {

	public TransactionPaymentCalculatorPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}


	@FindBy(id="igtxtctl00_FC_PH_txtNoOfPayment")
	private WebElement numberOfPayments;
	
	@FindBy(id="ctl00_FC_PH_txtInceptionDate_input")
	private WebElement commencementDate;
	
	@FindBy(id="ctl00_FC_PH_cboPaymentFrequency_cboComboBoxControl")
	private WebElement paymentFrequency;
	
	@FindBy(id="igtxtctl00_FC_PH_txtNoOfInceptionPayment")
	private WebElement numberOfPaymentsOnCommencement;
	
	@FindBy(id="igtxtctl00_FC_PH_txtDueDay")
	private WebElement dueDay;
	
	@FindBy(id="ctl00_FC_PH_cboPaymentStructure_cboComboBoxControl")
	private WebElement paymentStructure;
	
	@FindBy(id="igtxtctl00_FC_PH_txtRegularPayment_txtWebCurrencyEdit")
	private WebElement regularPayment;
	
	@FindBy(id="igtxtctl00_FC_PH_txtInceptionPayment_txtWebCurrencyEdit")
	private WebElement commencementPayment;
	
	
	
	@FindBy(id="igtxtctl00_FC_PH_txtCustomerGuaranteeCustomerRisk_txtWebCurrencyEdit")
	private WebElement customerRisk;
	
	@FindBy(id="igtxtctl00_FC_PH_txtLessorRisk_txtWebCurrencyEdit")
	private WebElement lessorRisk;
	
	@FindBy(id="igtxtctl00_FC_PH_txtThirdPartyGuaranteeThirdPartyRisk_txtWebCurrencyEdit")
	private WebElement thirdPartyRisk;
	
	@FindBy(id="igtxtctl00_FC_PH_txtCustomerResidualInsurancePremium_txtWebCurrencyEdit")
	private WebElement residualValueInsurance;
	
	
	@FindBy(id="ctl00_FT_PH_cmdGeneratePayments_cmdButtonControl")
	private WebElement generatePaymentButton;
	
	@FindBy(id="ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	@FindBy(id="ctl00_FT_PH_cmdClose_cmdButtonControl")
	private WebElement closeButton;
	
	
	
	
	
	
	
	public void enterNumberOfPayments(String noOfPayments)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(numberOfPayments));
		numberOfPayments.clear();
		numberOfPayments.sendKeys(noOfPayments);
	}
	
	public void enterCommencementDate(String date)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(commencementDate));
		commencementDate.clear();
		commencementDate.sendKeys(date);
	}
	
	
	public void selectPaymentStructure(String structure)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(paymentStructure));
		Select se = new Select(paymentStructure);
		se.selectByVisibleText(structure);
	}
	
	
	
	public void selectPaymentFrequency(String frequency)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(paymentFrequency));
		Select se = new Select(paymentFrequency);
		se.selectByVisibleText(frequency);
	}
	 	
	public void enterNumberCommencementPayments(String noOfCommencementPayment)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(numberOfPaymentsOnCommencement));
		numberOfPaymentsOnCommencement.clear();
		numberOfPaymentsOnCommencement.sendKeys(noOfCommencementPayment);
	}
	
	
	public void enterDueDay(String day)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(dueDay));
		dueDay.clear();
		dueDay.sendKeys(day);
	}
	
	
	public void enterCommencementPayment(String CommencementPayment)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(commencementPayment));
		commencementPayment.clear();
		commencementPayment.sendKeys(CommencementPayment);
	}
	
	public void enterRegularPayment(String payment)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(regularPayment));
		regularPayment.clear();
		regularPayment.sendKeys(payment);
	}
	
	
	public void enterCustomerRisk(String customerrisk)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(customerRisk));
		customerRisk.clear();
		customerRisk.sendKeys(customerrisk);
	}
	
	
	public void enterLessorRisk(String lessorrisk)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(lessorRisk));
		lessorRisk.clear();
		lessorRisk.sendKeys(lessorrisk);
	}
	
	public void enterThirdPartyRisk(String thirdpartyrisk)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(thirdPartyRisk));
		thirdPartyRisk.clear();
		thirdPartyRisk.sendKeys(thirdpartyrisk);
	}
	
	
	public void enterResidualValueInsurance(String residualvalueinsurance)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(residualValueInsurance));
		residualValueInsurance.clear();
		residualValueInsurance.sendKeys(residualvalueinsurance);
	}
	
	
	public void clickCloseButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(closeButton));
		closeButton.click();
	}
	
	public void clickSaveButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
	}
	
	public void clickGeneratePaymentsButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(generatePaymentButton));
		generatePaymentButton.click();
	}
	
	
	
	
	
}
