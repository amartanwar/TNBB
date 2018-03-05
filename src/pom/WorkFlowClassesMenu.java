package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class WorkFlowClassesMenu extends BasePage {


	@FindBy(id="ctl00ctl04WebMenuControl_1")
	public WebElement WorkFlowClassesMenu;
	
	@FindBy(xpath="id(\"ctl00ctl04WebMenuControl_1_1\")/td[1]/div[1]")  
	public WebElement TransactionMenu;
	
	@FindBy(xpath="id(\"ctl00ctl04WebMenuControl_1_2\")/td[1]/div[1]")    
	public WebElement DisbursementRequestMenu;
	
	@FindBy(css="#ctl00ctl04WebMenuControl_1_1_1 > td > div") 
	public WebElement NewTransaction;
	
	@FindBy(css="#ctl00ctl04WebMenuControl_1_1_2 > td > div")
	public WebElement OpenTransaction;
	
	
	public  WorkFlowClassesMenu(WebDriver driver, ExtentTest test)
	{
		super(driver, test);	
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnWokFlowClassesMenu()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(WorkFlowClassesMenu));
		WorkFlowClassesMenu.click();
	}
	
	public void clickOnNewTransaction()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(TransactionMenu));
		
		Actions action = new Actions(driver);
		action.moveToElement(TransactionMenu).perform();
		wait.until(ExpectedConditions.visibilityOf(NewTransaction));
		action.moveToElement(NewTransaction).click().perform();
		
	}
	
	public void clickOnOpenTransaction()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(TransactionMenu));
		
		Actions action = new Actions(driver);
		action.moveToElement(TransactionMenu).perform();
		wait.until(ExpectedConditions.visibilityOf(OpenTransaction));
		action.moveToElement(OpenTransaction).click().perform();
	}
	
	
}
