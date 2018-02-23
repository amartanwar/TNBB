package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import generic.BasePage;
import generic.SystemDate;

public class AssetProfilePage extends BasePage
{
	@FindBy(id="ctl00_FC_PH_txtUnitNumber")
	private WebElement alias;
	
	@FindBy(id="ctl00_FC_PH_txtAcquisitionDate_input")
	private WebElement acquiredDate;
	
	@FindBy(id="ctl00_FC_PH_cboInventoryTypeID_cboComboBoxControl")
	private WebElement type;
	
	@FindBy(id="ctl00_FC_PH_cboUpfitMakeID_cboComboBoxControl")
	private WebElement assetcategory;
	
	@FindBy(id="ctl00_FC_PH_txtCustomerID")
	private WebElement accountNumber;
	
	@FindBy(id="ctl00_FC_PH_txtFactorCategoryID")
	private WebElement factorCategory;
	
	@FindBy(id="ctl00_FC_PH_cboIndustryTypeID_cboComboBoxControl")
	private WebElement industryType;
	
	@FindBy(id="ctl00_FC_PH_cboTaxResponsibilityId_cboComboBoxControl")
	private WebElement propertyTaxResposibility;
	
	@FindBy(id="ctl00_FC_PH_txtLocationCode")
	private WebElement locationCode;
	
	@FindBy(id="ctl00_F_PH_txtLocationEffectiveFromDate_input")
	private WebElement effectiveDate;
	
	@FindBy(id="ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;

	public AssetProfilePage(WebDriver driver,ExtentTest test) 
	{
		super(driver,test);
		PageFactory.initElements(driver, this);
	}
	
	public void enterAlias(String un)
	{
		alias.clear();
		alias.sendKeys(un);
	}
	
	public void enterAcquiredDate()
	{
		acquiredDate.sendKeys(SystemDate.currentDate());
	}
	
	public void enterAcquiredDate(String date)
	{
		acquiredDate.sendKeys(date);
	}
	
	public void selectAssetType(String assetType)
	{
		Select se =new Select(type);
		se.selectByIndex(1);
//		se.selectByVisibleText(assetType);
		
	}
	
	public void selectAssetcategory(String ascategory)
	{
		Select se= new Select(assetcategory);
//		se.selectByVisibleText(ascategory);
		se.selectByIndex(2);
		test.log(Status.PASS,"setting asset category");
	}
	
	public void selectpropertyTaxResposibility(String propeTaxResposibility)
	{
		Select se= new Select(propertyTaxResposibility);
//		se.selectByVisibleText(propeTaxResposibility);
		se.selectByIndex(1);
	}
	
	public void enterAccountNumber(String acNumber)
	{
		accountNumber.sendKeys(acNumber);
	}
	
	public void selectFactorCategory(String fcCategory)
	{
		factorCategory.sendKeys(fcCategory);
	}
	
	public void enterLocationCode(String locCode)
	{
		locationCode.sendKeys(locCode);
	}
	
	public void enterEffectiveDate()
	{
		effectiveDate.sendKeys(SystemDate.currentDate());
	}
	
	public void selectIndustryType()
	{
		Select se =new Select(industryType);
//		se.selectByVisibleText(indusType);
		se.selectByIndex(1);
		
	}
	
	
	public void clickOnSave()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(saveButton));
		saveButton.click();
	}
	
	
}
