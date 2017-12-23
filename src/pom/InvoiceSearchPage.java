package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.BasePage;

public class InvoiceSearchPage extends BasePage
{
	@FindBy(xpath="//input[@id='ctl00_F_PH_InvoiceSearchCriteriaUserControl_rdnLeaseSequenceNo']")
	private WebElement leaseSequenceNumberRadioButton;
	
	@FindBy(xpath=".//*[@id='ctl00_F_PH_InvoiceSearchCriteriaUserControl_txtLeaseSequenceNo']")
	private WebElement leaseSequenceNumber;

	@FindBy(id="ctl00_Fr_PH_cmdSearchApply_cmdButtonControl")
	private WebElement saveAndApplyButton;
	
	public InvoiceSearchPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void selectLeaseSequenceNumberRadioButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(leaseSequenceNumberRadioButton));
		leaseSequenceNumberRadioButton.click();
	}
	
	public void enterLeaseSequenceNumber(String leaseSeqNumber)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeSelected(leaseSequenceNumberRadioButton));
		leaseSequenceNumber.sendKeys(leaseSeqNumber);
	}
	
	public void clickOnSaveAndApplyButton()
	{
		saveAndApplyButton.click();
	}
}
