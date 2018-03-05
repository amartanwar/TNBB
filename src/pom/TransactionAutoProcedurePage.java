package pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class TransactionAutoProcedurePage extends BasePage {

	public TransactionAutoProcedurePage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="ctl00_FT_PH_cmdRun_cmdButtonControl")
	private WebElement runButton;
	
	@FindBy(id="ctl00_FT_PH_cmdClose_cmdButtonControl")
	private WebElement closeButton;
	
	public void clickRunButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(runButton));
		runButton.click();
	}
	
	public void clickCloseButton(String beforewindow1 )
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(closeButton));
		closeButton.click();
		driver.switchTo().window(beforewindow1);
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
				alert.accept();
				
			}
			catch (Exception e)
			{
				
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
