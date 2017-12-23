package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.BasePage;

public class ReceiptApplicationPage extends BasePage
{
	@FindBy(id="ctl00_F_PH_grdInvoice_lnkAllCP")
	private WebElement invoiceAllCurrentPageButton;
	
	@FindBy(xpath=".//*[@id='ctl00xFxPHxgrdInvoicexgrdList_rc_0_0']/nobr/input")
	private WebElement selectInvoiceCheckBox;
	
	@FindBy(id="ctl00_F_PH_grdPayment_lnkAllCP")
	private WebElement receivableAllCurrentPageButton;
	
	@FindBy(id="ctl00xFxPHxgrdInvoicexgrdList_rc_0_18")
	private WebElement amountToBeApplied;
	
	@FindBy(id="ctl00_F_PH_cmdApplyChanges_cmdButtonControl")
	private WebElement applyButton;
	
	@FindBy(id="ctl00_F_PH_cmdDistribute_cmdButtonControl")
	private WebElement distributeButton;
	
	
	@FindBy(id="ctl00_Fr_PH_cmdPost_cmdButtonControl")
	private WebElement postButton;
	
	public ReceiptApplicationPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void selectInvoices()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(invoiceAllCurrentPageButton));
		invoiceAllCurrentPageButton.click();
	}
	
	public void selectOneInvoices()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(selectInvoiceCheckBox));
		selectInvoiceCheckBox.click();
	}
	public void enterpatialAmount(String partialAmount) throws InterruptedException
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(amountToBeApplied));
//		RemoteWebDriver jse= (RemoteWebDriver)driver;
//		jse.executeScript("document.getElementById(ctl00xFxPHxgrdInvoicexgrdList_rc_0_18).value='20'");
		
		amountToBeApplied.click();
		Thread.sleep(1000);
		System.out.println("clickpass");
		amountToBeApplied.clear();
		System.out.println("clear pass");
//		Thread.sleep(1000);
		amountToBeApplied.sendKeys(partialAmount);
		System.out.println("partialAmount pass");
	}
	
	public void clickOnApplyButton() throws InterruptedException
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(applyButton));
		Thread.sleep(1000);
		applyButton.click();
	}
	
	public void selectReceivables()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(receivableAllCurrentPageButton));
		receivableAllCurrentPageButton.click();
	}

	public void clickOnDistribute()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(distributeButton));
		distributeButton.click();
	}
	
	public void clickOnPostButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(postButton));
		postButton.click();
		
	}
}
