package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.BasePage;

public class LeaseMenuPage extends BasePage
{
	@FindBy(id="ctl00ctl04WebMenuControl_2")
	private WebElement leaseMenu;

	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_2_1']/td/div")
	private WebElement newLease;

	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_2_6']/td/div")
	private WebElement rebook;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_2_7']/td/div")
	private WebElement restructure;
	
	public LeaseMenuPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnLeaseMenu()
	{
		leaseMenu.click();
	}
	
	public void clickOnNewLease()
	{
		newLease.click();
	}
	
	public void openLeaseRebookPage() throws InterruptedException
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.visibilityOf(leaseMenu));
	    
	    Actions action= new Actions(driver);
		action.moveToElement(leaseMenu).perform();
		Thread.sleep(2000);
		WebDriverWait wt2= new WebDriverWait(driver, 60);
	    wt2.until(ExpectedConditions.visibilityOf(rebook));
		action.moveToElement(rebook).click().perform();
	}
	
	public void openLeaseStructurePage()
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.visibilityOf(leaseMenu));
	    Actions action= new Actions(driver);
		action.moveToElement(leaseMenu).perform();
		
		WebDriverWait wt2= new WebDriverWait(driver, 60);
	    wt2.until(ExpectedConditions.elementToBeClickable(restructure));
		action.moveToElement(restructure).click().perform();
	}
}
