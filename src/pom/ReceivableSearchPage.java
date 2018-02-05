package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class ReceivableSearchPage extends BasePage
{
	@FindBy(id="ctl00_F_PH_ReceivableSearchCriteriaUserControl_txtLeaseSequenceNo")
	private WebElement leaseSequenceNumber;
	
	@FindBy(id="ctl00_Fr_PH_cmdPostReceipts_cmdButtonControl")
	private WebElement applyReceiptButton;
	
	public ReceivableSearchPage(WebDriver driver, ExtentTest test)
	{
		super(driver, test);
		PageFactory.initElements(driver, this);
	}
	
	public void enterLeaseSequenceNumber(String leaseSeqNumber)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(leaseSequenceNumber));
		leaseSequenceNumber.sendKeys(leaseSeqNumber);
	}
	
	public void clickOnApplyReceiptButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(applyReceiptButton));
		applyReceiptButton.click();
	}

}
