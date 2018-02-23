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

public class AssetMenuPage extends BasePage
{

	@FindBy(id="ctl00ctl04WebMenuControl_4")
	private WebElement assetLink;
	
	@FindBy(xpath="//*[@id=\'ctl00ctl04WebMenuControl_4_1\']/td/div")
	private WebElement assetProfile;
	
	@FindBy(xpath="//*[@id=\'ctl00ctl04WebMenuControl_4_8\']/td/div")
	private WebElement valueAndStatusChange;
	
	//modified the Xpath
	@FindBy(xpath=".//*[@id=\'ctl00ctl04WebMenuControl_4_8_1\']/td/div")
	private WebElement Zero;
	
	//modified the Xpath
	@FindBy(xpath=".//*[@id=\'ctl00ctl04WebMenuControl_4_8_2\']/td/div")
	private WebElement nonZero;
	
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_3_1']/td/div")
	private WebElement locationSetup;
	

	public AssetMenuPage(WebDriver driver,ExtentTest test) 
	{
		super(driver,test);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAssetMenu()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(assetLink));
		assetLink.click();
	}
	
	public void clickOnAssetProfile() throws InterruptedException
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(assetProfile));
		assetProfile.click();
		
	}
	public void clickOnvalueAndStatusChanges()
	{
		valueAndStatusChange.click();
	}
	
//	public void openAssetProfileListpage() throws InterruptedException 
//	{
//		WebDriverWait wt= new WebDriverWait(driver, 60);
//		wt.until(ExpectedConditions.visibilityOf(assetLink));
//		assetLink.click();
//		Actions ac= new Actions(driver);
//		Thread.sleep(2000);
//		ac.moveToElement(assetProfile).perform();
//		ac.click().perform();
//	}
	
	//newly added
	public void clickOnZero()
	{
		WebDriverWait wt2= new WebDriverWait(driver, 60);
	    wt2.until(ExpectedConditions.visibilityOf(Zero));
	    Actions action=new Actions(driver);
		action.moveToElement(Zero).perform();
		Zero.click();
	}
	
	public void clickOnNonZero()
	{
		WebDriverWait wt2= new WebDriverWait(driver, 100);
	    wt2.until(ExpectedConditions.visibilityOf(nonZero));
	    Actions action=new Actions(driver);
		action.moveToElement(nonZero).perform();
		nonZero.click();
	}
	
	
	
	public void openAssetCostAssignmentPage() throws InterruptedException
	{
		    WebDriverWait wt= new WebDriverWait(driver, 60);
		    wt.until(ExpectedConditions.visibilityOf(assetLink));
			Actions action=new Actions(driver);
			action.moveToElement(assetLink).perform();
			
			WebDriverWait wt1= new WebDriverWait(driver, 60);
		    wt1.until(ExpectedConditions.visibilityOf(valueAndStatusChange));
			action.moveToElement(valueAndStatusChange).perform();
			
			WebDriverWait wt2= new WebDriverWait(driver, 60);
		    wt2.until(ExpectedConditions.visibilityOf(Zero));
			action.moveToElement(Zero).perform();
			
			WebDriverWait wt3= new WebDriverWait(driver, 60);
		    wt3.until(ExpectedConditions.visibilityOf(nonZero));
			action.moveToElement(nonZero).click().perform();
	}
}
