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

public class UpdatesMenuPage extends BasePage
{
	@FindBy(id="ctl00ctl04WebMenuControl_5")
	private WebElement updateMenu;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_5_1']/td/div")
	private WebElement receivables;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_5_1_1']/td/div")
	private WebElement sundryRecurringUpdate;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_5_1_3']/td/div")
	private WebElement salesUseTax;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_5_1_3_1']/td/div/u")
	private WebElement taxAssessment;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_5_2']/td/div")
	private WebElement invoicing;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_5_2_1']/td/div")
	private WebElement invoiceGroupUpdate;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_5_2_2']/td/div")
	private WebElement invoiceDateUpdate;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_5_2_3']/td/div")
	private WebElement invoiceGeneration;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_5_4']/td/div")
	private WebElement lease;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_5_4_1']/td/div")
	private WebElement interimRent;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_5_4_3']/td/div")
	private WebElement movingLongTermToShortTerm;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_5_4_5']/td/div")
	private WebElement incomeRecognition;
	
	public UpdatesMenuPage(WebDriver driver,ExtentTest test)
	{
		super(driver,test);
		PageFactory.initElements(driver, this);
	}
	
	public void openMovingLongTermToShortTerm()
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.visibilityOf(updateMenu));
	    Actions action= new Actions(driver);
		action.moveToElement(updateMenu).perform();
		
		WebDriverWait wt2= new WebDriverWait(driver, 60);
	    wt2.until(ExpectedConditions.visibilityOf(lease));
		action.moveToElement(lease).perform();
		
		WebDriverWait wt3= new WebDriverWait(driver, 60);
	    wt3.until(ExpectedConditions.visibilityOf(interimRent));
		action.moveToElement(interimRent).perform();
		
		WebDriverWait wt4= new WebDriverWait(driver, 60);
	    wt4.until(ExpectedConditions.visibilityOf(movingLongTermToShortTerm));
		action.moveToElement(movingLongTermToShortTerm).click().perform();
	
	}
	
	public void openLeaseIncomeRecognition()
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.visibilityOf(updateMenu));
	    Actions action= new Actions(driver);
		action.moveToElement(updateMenu).perform();
		
		WebDriverWait wt2= new WebDriverWait(driver, 60);
	    wt2.until(ExpectedConditions.visibilityOf(lease));
		action.moveToElement(lease).perform();
		
		WebDriverWait wt3= new WebDriverWait(driver, 60);
	    wt3.until(ExpectedConditions.visibilityOf(interimRent));
		action.moveToElement(interimRent).perform();
		
		WebDriverWait wt4= new WebDriverWait(driver, 60);
	    wt4.until(ExpectedConditions.visibilityOf(incomeRecognition));
		action.moveToElement(incomeRecognition).click().perform();
	
	}
	
	public void openInvoiceDateUpdatePage()
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.visibilityOf(updateMenu));
	    Actions action= new Actions(driver);
		action.moveToElement(updateMenu).perform();
		
		WebDriverWait wt2= new WebDriverWait(driver, 60);
	    wt2.until(ExpectedConditions.visibilityOf(invoicing));
		action.moveToElement(invoicing).perform();
		
		WebDriverWait wt3= new WebDriverWait(driver, 60);
	    wt3.until(ExpectedConditions.visibilityOf(invoiceGroupUpdate));
		action.moveToElement(invoiceGroupUpdate).perform();
		
		WebDriverWait wt4= new WebDriverWait(driver, 60);
	    wt4.until(ExpectedConditions.visibilityOf(invoiceDateUpdate));
		action.moveToElement(invoiceDateUpdate).click().perform();
	}

	public void openInvoiceGroupUpdatePage()
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.visibilityOf(updateMenu));
	    Actions action= new Actions(driver);
		action.moveToElement(updateMenu).perform();
		
		WebDriverWait wt2= new WebDriverWait(driver, 60);
	    wt2.until(ExpectedConditions.visibilityOf(invoicing));
		action.moveToElement(invoicing).perform();
		
		WebDriverWait wt3= new WebDriverWait(driver, 60);
	    wt3.until(ExpectedConditions.visibilityOf(invoiceGroupUpdate));
		action.moveToElement(invoiceGroupUpdate).click().perform();
		
	}
	
	
	public void openSalesTaxUpdatePage()
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.visibilityOf(updateMenu));
	    Actions action= new Actions(driver);
		action.moveToElement(updateMenu).perform();
		
		WebDriverWait wt2= new WebDriverWait(driver, 60);
	    wt2.until(ExpectedConditions.visibilityOf(receivables));
		action.moveToElement(receivables).perform();
		
		WebDriverWait wt4= new WebDriverWait(driver, 60);
	    wt4.until(ExpectedConditions.visibilityOf(sundryRecurringUpdate));
		action.moveToElement(sundryRecurringUpdate).perform();
		
		WebDriverWait wt5= new WebDriverWait(driver, 60);
	    wt5.until(ExpectedConditions.visibilityOf(salesUseTax));
		action.moveToElement(salesUseTax).perform();
		
		WebDriverWait wt3= new WebDriverWait(driver, 60);
	    wt3.until(ExpectedConditions.visibilityOf(taxAssessment));
		action.moveToElement(taxAssessment).click().perform();
		
	}

	public void openInvoiceGenerationPage()
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.visibilityOf(updateMenu));
	    Actions action= new Actions(driver);
		action.moveToElement(updateMenu).perform();
		
		WebDriverWait wt2= new WebDriverWait(driver, 60);
	    wt2.until(ExpectedConditions.visibilityOf(invoicing));
		action.moveToElement(invoicing).perform();
		
		WebDriverWait wt3= new WebDriverWait(driver, 60);
	    wt3.until(ExpectedConditions.visibilityOf(invoiceGroupUpdate));
		action.moveToElement(invoiceGroupUpdate).perform();
		
		WebDriverWait wt4= new WebDriverWait(driver, 60);
	    wt4.until(ExpectedConditions.visibilityOf(invoiceGeneration));
		action.moveToElement(invoiceGeneration).click().perform();
		
	}
	
}
