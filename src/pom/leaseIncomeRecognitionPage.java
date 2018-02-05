package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class leaseIncomeRecognitionPage extends BasePage
{
	
	@FindBy(id="ctl00_F_PH_LeaseBasedControlUC1_liLeaseFilter")
	private WebElement leaseFilter;
	
	@FindBy(id="ctl00_F_PH_LeaseBasedControlUC1_rdoLease")
	private WebElement leaseSequenceNumberRadioButton;
	
	@FindBy(id="ctl00_F_PH_LeaseBasedControlUC1_txtFromSequenceNumber")
	private WebElement leaseSequenceNumberTextBox;
	
	@FindBy(id="ctl00_F_PH_LeaseBasedControlUC1_txtUpdateThroughDate_input")
	private WebElement updateThrDate;
	
	@FindBy(id="ctl00_F_PH_LeaseBasedControlUC1_txtPostDate_input")
	private WebElement postdate;
	
	@FindBy( id="ctl00_F_PH_SchedulerUC1_rdoRunImmediately")
	private WebElement runImmediately;
	
	@FindBy( id="ctl00_Fr_PH_cmdRunUpdate_cmdButtonControl")
	private WebElement runUpdate;
	
	@FindBy(xpath="//*[@id='ctl00_GI_Box_Dis_Ara']/font/a")
	private WebElement jobId;
	
	public leaseIncomeRecognitionPage(WebDriver driver,ExtentTest test)
	{
		super(driver, test);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLeaseFilter()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(leaseFilter));
		leaseFilter.click();
	}
	
	public void selectleaseSequenceNumber()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(leaseSequenceNumberRadioButton));
		leaseSequenceNumberRadioButton.click();
	}
	
	public void enterleaseSequenceNumber(String leaseSequenceNumber)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(leaseSequenceNumberTextBox));
		leaseSequenceNumberTextBox.sendKeys(leaseSequenceNumber);
	}
	
	public void enterupdateThroughDate(String updateThroughDate)
	{
		
		updateThrDate.sendKeys(updateThroughDate);
	}
	
	public void enterPostDate(String postDte)
	{
		postdate.click();
		postdate.sendKeys(postDte);
	}
	
	public void clickOnrunImmediatelyr()
	{
		runImmediately.click();
	}
	
	public void clickOnrunUpdate()
	{
		runUpdate.click();
	}
	
	public void clickOnJobId() throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(jobId));
		jobId.click();
	}
	
}
