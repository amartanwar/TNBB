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

public class TransactionProposalPage extends BasePage {

	public TransactionProposalPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="igtxtctl00_FC_PH_txtOpportunityAmount_txtWebCurrencyEdit")
	private WebElement opportunityAmount;

	@FindBy(id="ctl00_FC_PH_CboSpecializedAssetCategory_cboComboBoxControl")
	private WebElement specializedAssetCategory;
	
	@FindBy(id="igtxtctl00_FC_PH_TxtExhibitAmount_txtWebCurrencyEdit")
	private WebElement exhibitAmount;
	
	@FindBy(id="ctl00_FC_PH_cboTransactionType_cboComboBoxControl")
	private WebElement transactionType;

	@FindBy(id="ctl00_FC_PH_ChkIndexBased")
	private WebElement indexBased;
	
	@FindBy(id="ctl00_FC_PH_cboPaymentFrequency_cboComboBoxControl")
	private WebElement paymentFrequency;
	
	
	@FindBy(id="ctl00_FC_PH_ChkAdvance")
	private WebElement advance;

	@FindBy(id="igtxtctl00_FC_PH_txtNumberofPayments")
	private WebElement numberOfPayments;
	
	@FindBy(id="ctl00_FC_PH_CmdSaveExhibit_cmdButtonControl")
	private WebElement exhibitSaveButton;
	
	@FindBy(id="ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	public void enterOpportunityAmount(String amount)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(opportunityAmount));
		opportunityAmount.clear();
		opportunityAmount.sendKeys(amount);
	}
	
	public void selectSpecializedCategoryAsset(String asset)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(specializedAssetCategory));
		
		Select se = new Select(specializedAssetCategory);
		se.selectByVisibleText(asset);
	}
	
	public void enterexhibitAmount(String amount)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(exhibitAmount));
		exhibitAmount.clear();
		exhibitAmount.sendKeys(amount);
	}
	
	public void selectTransactionType(String transactiontype)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(transactionType));
		
		Select se = new Select(transactionType);
		se.selectByVisibleText(transactiontype);
	}
	
	
	public void checkIndexBased()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(indexBased));
		indexBased.click();
	}
	
	public void selectPaymentFrequency(String Frequency)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(paymentFrequency));
		
		Select se = new Select(paymentFrequency);
		se.selectByVisibleText(Frequency);
	}
	
	public void checkAdvance()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(advance));
		advance.click();
	}
	
	public void enterNumberOfPayments(String payments)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(numberOfPayments));
		numberOfPayments.clear();
		numberOfPayments.sendKeys(payments);
	}
	
	
	public void clickExhibitSaveButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(exhibitSaveButton));
		exhibitSaveButton.click();
	}
	
	public void clickSaveButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(exhibitSaveButton));
		saveButton.click();
	}
	
	
	
	
	
	
}
