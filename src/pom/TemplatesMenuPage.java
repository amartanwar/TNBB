package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.BasePage;

public class TemplatesMenuPage extends BasePage
{
	@FindBy(id="ctl00ctl04WebMenuControl_3")
	private WebElement templates;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_3_1']/td/div")
	private WebElement products;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_3_2']/td/div")
	private WebElement programSetup;
	
	public TemplatesMenuPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void openProductProfile()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(templates));
		Actions ac= new Actions(driver);
		ac.moveToElement(templates).perform();
		
		WebDriverWait wt1= new WebDriverWait(driver, 60);
		wt1.until(ExpectedConditions.visibilityOf(products));
		ac.moveToElement(products).click().perform();
	}
	
	public void openProgramSetup()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(templates));
		Actions ac= new Actions(driver);
		ac.moveToElement(templates).perform();
		
		WebDriverWait wt1= new WebDriverWait(driver, 60);
		wt1.until(ExpectedConditions.visibilityOf(programSetup));
		ac.moveToElement(programSetup).click().perform();
	}
	
	

}
