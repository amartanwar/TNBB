package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BasePage;

public class CreateNewLeasePage extends BasePage
{
	@FindBy(id="ctl00_F_PH_chkInstallLease")
	private WebElement installLease;

	@FindBy(id="ctl00_F_PH_txtSequenceNumber")
	private WebElement sequenceNumber;

	@FindBy(id="ctl00_Fr_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	public CreateNewLeasePage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void enterLeaseSequenceNumber(String leaseSequenceNumber)
	{
		sequenceNumber.sendKeys(leaseSequenceNumber);
	}
	
	public void clcikOnSaveButton()
	{
		saveButton.click();
	}

}
