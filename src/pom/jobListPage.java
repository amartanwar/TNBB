package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import generic.BasePage;
import generic.ScreenShot;
import generic.SwitchControlToNextWindow;

public class jobListPage extends BasePage
{

	@FindBy(xpath="//tr[@id='ctl00xFxPHxgrdListxgrdList_r_0']/td[4]/nobr")
	private WebElement jobStatus;
	
	@FindBy( id="ctl00_F_PH_schSearchControl_cmdSearch_cmdButtonControl")
	private WebElement searchButton;
	
	@FindBy(xpath="//a[.='Log Details']")
	private WebElement logDetails;
	
	@FindBy(id="ctl00_F_PH_cmdView_cmdButtonControl")
	private WebElement viewButton;
	
	public jobListPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	
	public void validateJobStatus() throws InterruptedException 
	{
		
		WebDriverWait wt= new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOf(searchButton));
		 
		for(int i=1;i<=9000;i++)
			{
				searchButton.click();	
			
				WebDriverWait wt1= new WebDriverWait(driver, 100);
				wt1.until(ExpectedConditions.visibilityOf(jobStatus));
				Thread.sleep(3000);
				
				String jobResult = jobStatus.getText();
				if(jobResult.equals("Completed Successfully")==true)
					{
						break;
					}
		
				else if (jobResult.equals("Failed")==true) 
					{
						Assert.fail();
						break;
					}
					else if(jobResult.equals("Completed With Errors"))
					{
						Assert.fail();
						break;
					}
			}

	}

	public String clickOnLogDetails() throws InterruptedException
	{
		String currentWindow = driver.getWindowHandle();
		logDetails.click();
		SwitchControlToNextWindow sw= new SwitchControlToNextWindow();
		sw.waitForWndows(driver, currentWindow);
		WebDriverWait wt= new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOf(viewButton));
		
		String screenshotpath = ScreenShot.takeScreenshot(driver, SNAP_PATH+"test");
		return screenshotpath;
	}
}
