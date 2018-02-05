package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;
import generic.SystemDate;

public class LeaseRebookParametersPage extends BasePage
{
	@FindBy(id="ctl00_F_PH_txtRebookDate_input")
	private WebElement rebookDate;

	@FindBy(id="ctl00_Fr_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	@FindBy(id="ctl00_F_PH_chkReverseCash")
	private WebElement reverseCash;
	
	public LeaseRebookParametersPage(WebDriver driver, ExtentTest test)
	{
		super(driver, test);
		PageFactory.initElements(driver, this);
	}
	
	public void enterRebookDate()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(rebookDate));
		rebookDate.sendKeys(SystemDate.currentDate());	
	}
	
	public void clickOnSaveButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(saveButton));
		saveButton.click();
	}

}
