package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class LeaseListPage extends BasePage 
{
	@FindBy(id="ctl00_F_PH_schSearchControl_bshBasicSearch_OneStringctl00_F_PH_schSearchControlrRrrRrrRr0rRr3mUnitNumber")
	private WebElement unitNumber;
	
	@FindBy(id="ctl00_F_PH_schSearchControl_cmdSearch_cmdButtonControl")
	private WebElement searchButton;
	
	@FindBy(id="ctl00_Fr_PH_cmdSelect_cmdButtonControl")
	private WebElement selectButton;
	
	

	public LeaseListPage(WebDriver driver, ExtentTest test) 
	{
		super(driver, test);
		PageFactory.initElements(driver, this);
	}
	
	public void searchByUnitNumber(String unNumber) throws InterruptedException
	{
		WebDriverWait wt1=new WebDriverWait(driver, 60);
		wt1.until(ExpectedConditions.visibilityOf(unitNumber));
		unitNumber.clear();
		unitNumber.sendKeys(unNumber);
	}
	
	public void searchByUnitNumber2(String unNumber) throws InterruptedException
	{
		WebDriverWait wt1=new WebDriverWait(driver, 60);
		wt1.until(ExpectedConditions.visibilityOf(unitNumber));
		unitNumber.sendKeys(unNumber);
	}
	
	public void clickOnSearchButton() throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(searchButton));
		searchButton.click();
	}
	
	public void clickONSelectButton()
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(selectButton));
		selectButton.click();
	}

}
