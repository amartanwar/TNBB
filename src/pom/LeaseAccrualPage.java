package pom;

import java.awt.AWTException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;
import generic.ScrollOptions;

public class LeaseAccrualPage extends BasePage
{
	@FindBy(id="ctl00_FC_PH_ComputeYield_cmdButtonControl")
	private WebElement computeYieldButton;

	@FindBy(id="ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	@FindBy(id="ctl00xFxPHxgrdListxgrdList_rc_0_1")
	private WebElement customerYeild;
	
	@FindBy(id="ctl00xFxPHxgrdListxgrdList_rc_0_2")
	private WebElement yeildWithoutIDC;
	
	@FindBy(id="ctl00xFxPHxgrdListxgrdList_rc_0_3")
	private WebElement yeildWithIDC;
	
	public LeaseAccrualPage(WebDriver driver, ExtentTest test)
	{
		super(driver, test);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnComputeYieldButton()
	{
		WebDriverWait wt=new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOf(computeYieldButton));
		computeYieldButton.click();
	}
	
	
	public void verifyYeild(String expectedCustomerYield,String expectedyeildWithoutIDC,String expectedyeildWithIDC) throws AWTException, InterruptedException 
	{
		WebDriverWait wt=new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOf(customerYeild));
		customerYeild.click();
		ScrollOptions.scrollingEndofAPage2();
		org.testng.Assert.assertEquals(customerYeild.getAttribute("uv"), expectedCustomerYield,"customerYeild is not matching");
		org.testng.Assert.assertEquals(yeildWithoutIDC.getAttribute("uv"), expectedyeildWithoutIDC,"yeildWithoutIDC is not matching");
		org.testng.Assert.assertEquals(yeildWithIDC.getAttribute("uv"), expectedyeildWithIDC,"yeildWithIDC is not matching");
		
	}
	
	
	public void clickOnSaveButton() throws InterruptedException
	{
		WebDriverWait wt=new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.elementToBeClickable(computeYieldButton));
		saveButton.click();
	}
	
	public void handlePopup()
	{
		WebDriverWait wt=new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

}
