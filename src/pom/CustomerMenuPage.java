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

public class CustomerMenuPage extends BasePage
{
	@FindBy(id="ctl00ctl04WebMenuControl_1")
	private WebElement customerMenu;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_1_2']/td/div")
	private WebElement contractSetup;
	
	
	public CustomerMenuPage( WebDriver driver, ExtentTest test)
	{
		super(driver,test);
		PageFactory.initElements(driver, this);
	}
	
	public void openContractSetup()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(customerMenu));
		Actions ac=new Actions(driver);
		ac.moveToElement(customerMenu).perform();
		
		WebDriverWait wt1= new WebDriverWait(driver, 60);
		wt1.until(ExpectedConditions.visibilityOf(contractSetup));
		ac.moveToElement(contractSetup).click().perform();
	}
}
