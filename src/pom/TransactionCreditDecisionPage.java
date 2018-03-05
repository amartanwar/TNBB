package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class TransactionCreditDecisionPage extends BasePage {

	public TransactionCreditDecisionPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="igtxtctl00_FC_PH_txtRequestedAmount_txtWebCurrencyEdit")
	public WebElement requestedAmount;
	
	@FindBy(id="ctl00_FC_PH_cmdAddDecision_cmdButtonControl")
	public WebElement addButton;
	
	@FindBy(id="ctl00_FC_PH_txtCreditDecisionName")
	public WebElement creditDecisionName;
	
	@FindBy(id="ctl00_FC_PH_txtDecisionDate_input")
	public WebElement decisionDate;
	
	@FindBy(id="ctl00_FC_PH_txtCommitmentExpiryDate_input")
	public WebElement commitmentExpiryDate;
	
	@FindBy(id="igtxtctl00_FC_PH_txtChangeInApprovedAmt_txtWebCurrencyEdit")
	public WebElement changeInApprovedAmount;
	
	@FindBy(id="ctl00_FC_PH_cmdSaveCreditTerm_cmdButtonControl")
	public WebElement saveButton;
	
	@FindBy(id="ctl00_FT_PH_cmdSave_cmdButtonControl")
	public WebElement pageSaveButton;
	
	public void enterRequestedAmount(String amount)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(requestedAmount));
		requestedAmount.clear();
		requestedAmount.sendKeys(amount);
	}
	
	public void clickOnAddButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(addButton));
		addButton.click();
	}
	
	public void enterCreditDecisionName(String name)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(creditDecisionName));
		creditDecisionName.sendKeys(name);
	}
	
	public void enterDecisionDate(String date)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(decisionDate));
		decisionDate.sendKeys(date);
	}
	
	public void enterCommitmentExpiryDate(String expiryDate)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(commitmentExpiryDate));
		commitmentExpiryDate.sendKeys(expiryDate);
	}
	
	public void enterChangeInApprovedAmout(String approvedAmount)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(changeInApprovedAmount));
		changeInApprovedAmount.clear();
		changeInApprovedAmount.sendKeys(approvedAmount);
	}
	
	public void clickOnSaveButton() 
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(saveButton));
		saveButton.click();
	}
	
	public void clickOnPageSaveButton() 
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(pageSaveButton));
		pageSaveButton.click();
	}
	
	
	
	
	
	
}
