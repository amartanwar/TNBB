package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class LeaseIDCSetupPage extends BasePage
{
	@FindBy(id="ctl00_FC_PH_cboIDCTemplateName_cboComboBoxControl")
	private WebElement idcTemplate;
	
	@FindBy(id="ctl00_FC_PH_cmdAdd_cmdButtonControl")
	private WebElement addButton;
	
	@FindBy(xpath="//*[@id=\'ctl00xFCxPHxgrdLeaseIDCxgrdList_rc_0_3\']")
	private WebElement idcAmount;
	
	@FindBy(id="ctl00_FT_PH_cmdRecalculate_cmdButtonControl")
	private WebElement recalculateIDC;

	@FindBy(id="ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;

	public LeaseIDCSetupPage(WebDriver driver, ExtentTest test)
	{
		super(driver,test);
		PageFactory.initElements(driver, this);
	}
	
	public void selectIDCTemplate()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(idcTemplate));
		Select se = new Select(idcTemplate);
		se.selectByIndex(1);
	}
	
	public void clickOnAddButton()
	{ 
		addButton.click();
	}
	
	public void enterIDCAMount(String amount) throws InterruptedException
	{
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(idcAmount));
		idcAmount.click();
		idcAmount.sendKeys(amount);
	}
	
	public void clickOnSaveButton()
	{
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
	}
	
	public void clickOnRecalculateIDCButton()
	{
		recalculateIDC.click();
	}

}
