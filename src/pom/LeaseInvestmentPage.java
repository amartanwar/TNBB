package pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import generic.BasePage;

public class LeaseInvestmentPage extends BasePage
{
	@FindBy(id="ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	@FindBy(id = "igtxtctl00_FC_PH_txtResidualBookedAmount_txtWebCurrencyEdit")
	private WebElement residualBooked;
	
	@FindBy(id ="igtxtctl00_FC_PH_txtResidualExpectedAmount_txtWebCurrencyEdit")
	private WebElement residualExpected;
	
	@FindBy(id="igtxtctl00_FC_PH_txtCustomerRisk_txtWebCurrencyEdit")
	private WebElement customerResidualGuarantee;
	
	
	public LeaseInvestmentPage(WebDriver driver, ExtentTest test)
	{
		super(driver, test);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSaveButton()
	{
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.titleIs("Lease Investment"));
		saveButton.click();
	}
	
	public void enterResidualBooked(String residualBookedAmount)
	{
		WebDriverWait wt = new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(residualBooked));
		residualBooked.click();
		residualBooked.clear();
		residualBooked.sendKeys(residualBookedAmount);
		
	}
	public void enterResidualExpected(String residualExpectedAmount)
	{
		WebDriverWait wt = new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(residualExpected));
		residualExpected.click();
		residualExpected.clear();
		residualExpected.sendKeys(residualExpectedAmount);
		
	}
	public void entercustomerResidualGuarantee(String customerResidualGuaranteeAmount)
	{
		WebDriverWait wt = new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(customerResidualGuarantee));
		customerResidualGuarantee.click();
		customerResidualGuarantee.clear();
		customerResidualGuarantee.sendKeys(customerResidualGuaranteeAmount);
		
	}
	
	public void handlePopup1()
	{
		for (int i=1;i<=1;i++)
		{
			try
			{
				
				WebDriverWait wt=new WebDriverWait(driver, 10);
				wt.until(ExpectedConditions.alertIsPresent());
				Alert alert = driver.switchTo().alert();
				test.log(Status.PASS, alert.getText());
				alert.accept();
				
			}
			catch (Exception e)
			{
				
			}
		}
		
	}
	
}
