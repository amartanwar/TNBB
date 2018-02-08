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

public class LeaseBlendedIncome extends BasePage
{
	@FindBy(id="ctl00_FT_PH_cmdLeaseClose_cmdButtonControl")
	private WebElement closeButton;
	
	@FindBy(id="ctl00_FC_PH_cmdAdd_cmdButtonControl")
	private WebElement addButton;
	
	@FindBy(id="ctl00_FC_PH_cboCode_cboComboBoxControl")
	private WebElement blendedCode;
	
	@FindBy(id="ctl00_FC_PH_txtBlendedName")
	private WebElement blendedName;
	
	@FindBy(id="igtxtctl00_FC_PH_txtBlendedAmount_txtWebCurrencyEdit")
	private WebElement blendedAmount;
	
	@FindBy(id="igtxtctl00_FC_PH_txtInventoryID")
	private WebElement inventoryID;
	
	@FindBy(id="ctl00_FC_PH_cboInvoiceGroupingOptionID_cboInvoiceOption")
	private WebElement invoiceOption;
	
	@FindBy(id="ctl00_FC_PH_txtDueDate_input")
	private WebElement dueDate;
	
	@FindBy(id="ctl00_FC_PH_chkIsAssetBased")
	private WebElement assetBasedCheckBox;
	
	@FindBy(id="ctl00_FC_PH_chkIsChargeBack")
	private WebElement chargeBack;
	
	@FindBy(id="ctl00_FC_PH_cmdSave_cmdButtonControl")
	public WebElement saveButton;

	public LeaseBlendedIncome(WebDriver driver, ExtentTest test)
	{
		super(driver, test);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCloseButton()
	{
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(closeButton));
		closeButton.click();
	}
	
	public void addBlendedIncome(String name,String amount)
	{
		
		addButton.click();
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(blendedCode));
		Select se = new Select(blendedCode);
		se.selectByIndex(1);
		wt.until(ExpectedConditions.visibilityOf(blendedName));
		blendedName.sendKeys(name);
		wt.until(ExpectedConditions.visibilityOf(blendedAmount));
		blendedAmount.clear();
		blendedAmount.sendKeys(amount);
		
	}
	
	
	public void addBlendedIncomeWithAsset(String name,String amount, String InventoryID)
	{
	
		addButton.click();
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(blendedCode));
		Select se = new Select(blendedCode);
		se.selectByIndex(12);
		wt.until(ExpectedConditions.visibilityOf(blendedName));
		blendedAmount.clear();
		blendedName.sendKeys(name);
		wt.until(ExpectedConditions.visibilityOf(blendedAmount));
		blendedAmount.sendKeys(amount);
		wt.until(ExpectedConditions.visibilityOf(inventoryID));
		inventoryID.sendKeys(InventoryID);
	}	
		
		
	public void addBlendedIncomeChargeBack(String name,String amount,String date)
	{
		
		addButton.click();
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(blendedCode));
		Select se = new Select(blendedCode);
		se.selectByIndex(13);
		blendedName.sendKeys(name);
		wt.until(ExpectedConditions.visibilityOf(blendedAmount));
		blendedAmount.clear();
		blendedAmount.sendKeys(amount);
		wt.until(ExpectedConditions.visibilityOf(invoiceOption));
		Select se1 = new Select(invoiceOption);
		se1.selectByIndex(1);
		wt.until(ExpectedConditions.visibilityOf(dueDate));
		dueDate.sendKeys(date);
		
	}
	
	public void addBlendedIncomeChargeBackWithAsset(String name,String amount,String InventoryID,String date)
	{
		
		addButton.click();
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(blendedCode));
		Select se = new Select(blendedCode);
		se.selectByIndex(7);
		wt.until(ExpectedConditions.visibilityOf(blendedName));
		blendedName.sendKeys(name);
		wt.until(ExpectedConditions.visibilityOf(blendedAmount));
		blendedAmount.clear();
		blendedAmount.sendKeys(amount);
		wt.until(ExpectedConditions.visibilityOf(inventoryID));
		inventoryID.sendKeys(InventoryID);
		Select se1 = new Select(invoiceOption);
		se1.selectByIndex(1);
		dueDate.sendKeys(date);
		
	}
	
	
	
	public void saveBlendedItem()
	{
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(saveButton));
		saveButton.click();
	}
}
