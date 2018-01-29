package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class LeaseCreatePage extends BasePage
{
	@FindBy(id="ctl00_FC_PH_chkInstallLease")
	private WebElement installLease;

	@FindBy(id="ctl00_FC_PH_txtSequenceNumber")
	private WebElement sequenceNumber;

	@FindBy(id="ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	public LeaseCreatePage(WebDriver driver, ExtentTest test)
	{
		super(driver, test);
		PageFactory.initElements(driver, this);
	}
	
	public void enterLeaseSequenceNumber(String leaseSequenceNumber)
	{
		sequenceNumber.clear();
		sequenceNumber.sendKeys(leaseSequenceNumber);
	}
	
	public void clcikOnSaveButton()
	{
		saveButton.click();
	}

}
