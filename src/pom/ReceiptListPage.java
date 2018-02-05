package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class ReceiptListPage extends BasePage
{
	@FindBy(id="ctl00_Fr_PH_cmdAdd_cmdButtonControl")
	private WebElement addButton;
	
	public ReceiptListPage(WebDriver driver, ExtentTest test) 
	{
		super(driver, test);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAddButton()
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
		wt1.until(ExpectedConditions.titleContains("Receipt List - Cash"));
		
		WebDriverWait wt2= new WebDriverWait(driver, 60);
		wt2.until(ExpectedConditions.visibilityOf(addButton));
		addButton.click();
		
	}
	
}
