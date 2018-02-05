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

public class ReceivablesAndReceiptsMenuPage extends BasePage
{
	@FindBy(id="ctl00ctl04WebMenuControl_4")
	private WebElement receivablesAndReceiptsMenu;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_4_8']/td/div")
	private WebElement postReceipts;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_4_8_1']/td/div")
	private WebElement receiptSetup;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_4_8_3']/td/div")
	private WebElement receiptApplication;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_4_8_3_1']/td/div")
	private WebElement byInvoice;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_4_8_3_2']/td/div")
	private WebElement byReceivable;
	
	
	public ReceivablesAndReceiptsMenuPage(WebDriver driver, ExtentTest test) 
	{
		super(driver, test);
		PageFactory.initElements(driver, this);
	}
	
	public void openReceiptSetupPage()
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.visibilityOf(receivablesAndReceiptsMenu));
	    Actions action= new Actions(driver);
		action.moveToElement(receivablesAndReceiptsMenu).perform();
		
		WebDriverWait wt2= new WebDriverWait(driver, 60);
	    wt2.until(ExpectedConditions.visibilityOf(postReceipts));
		action.moveToElement(postReceipts).perform();
		
		WebDriverWait wt3= new WebDriverWait(driver, 60);
	    wt3.until(ExpectedConditions.visibilityOf(receiptSetup));
		action.moveToElement(receiptSetup).click().perform();
	
	}

	public void openReceiptApplicationByInvoicePage()
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.visibilityOf(receivablesAndReceiptsMenu));
	    Actions action= new Actions(driver);
		action.moveToElement(receivablesAndReceiptsMenu).perform();
		
		WebDriverWait wt2= new WebDriverWait(driver, 60);
	    wt2.until(ExpectedConditions.visibilityOf(postReceipts));
		action.moveToElement(postReceipts).perform();
		
		WebDriverWait wt3= new WebDriverWait(driver, 60);
	    wt3.until(ExpectedConditions.visibilityOf(receiptSetup));
		action.moveToElement(receiptSetup).perform();
		
		WebDriverWait wt4= new WebDriverWait(driver, 60);
	    wt4.until(ExpectedConditions.visibilityOf(receiptApplication));
		action.moveToElement(receiptApplication).perform();
	
		WebDriverWait wt5= new WebDriverWait(driver, 60);
	    wt5.until(ExpectedConditions.visibilityOf(byInvoice));
		action.moveToElement(byInvoice).click().perform();
	}
	
	public void openReceiptApplicationByReceivablePage()
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.visibilityOf(receivablesAndReceiptsMenu));
	    Actions action= new Actions(driver);
		action.moveToElement(receivablesAndReceiptsMenu).perform();
		
		WebDriverWait wt2= new WebDriverWait(driver, 60);
	    wt2.until(ExpectedConditions.visibilityOf(postReceipts));
		action.moveToElement(postReceipts).perform();
		
		WebDriverWait wt3= new WebDriverWait(driver, 60);
	    wt3.until(ExpectedConditions.visibilityOf(receiptSetup));
		action.moveToElement(receiptSetup).perform();
		
		WebDriverWait wt4= new WebDriverWait(driver, 60);
	    wt4.until(ExpectedConditions.visibilityOf(receiptApplication));
		action.moveToElement(receiptApplication).perform();
	
		WebDriverWait wt5= new WebDriverWait(driver, 60);
	    wt5.until(ExpectedConditions.visibilityOf(byInvoice));
		action.moveToElement(byInvoice).perform();
		
		WebDriverWait wt6= new WebDriverWait(driver, 60);
	    wt6.until(ExpectedConditions.visibilityOf(byReceivable));
		action.moveToElement(byReceivable).click().perform();
	}
	
	

}
