package pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.BasePage;

public class ReceiptSetupPage extends BasePage
{
	@FindBy(id="ctl00_F_PH_txtAccountNumber")
	private WebElement accountNumber;
	
	@FindBy(id="ctl00_F_PH_cboGLTemplate_cboGLTransaction")
	private WebElement glTemplate;
	
	@FindBy(id="igtxtctl00_F_PH_txtCheckNumber")
	private WebElement checkNumber;
	
	@FindBy(id="igtxtctl00_F_PH_txtReceiptAmount_txtWebCurrencyEdit")
	private WebElement receiptAmount;
	
	@FindBy(id="igtxtctl00_F_PH_txtNameOnCheck")
	private WebElement nameOnCheck;
	
	@FindBy(id="ctl00_Fr_PH_cmdSaveAndApply_cmdButtonControl")
	private WebElement saveAndSelectButton;
	
	@FindBy(id="ctl00_Fr_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	public ReceiptSetupPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void enterAccountNumber(String accNumber)
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
		wt1.until(ExpectedConditions.titleContains("Receipt Setup - Cash"));
		
		WebDriverWait wt2= new WebDriverWait(driver, 60);
		wt2.until(ExpectedConditions.visibilityOf(accountNumber));
		accountNumber.sendKeys(accNumber);
		
	}
	
	public void enterReceiptAmount(String amount)
	{
		WebDriverWait wt2= new WebDriverWait(driver, 60);
		wt2.until(ExpectedConditions.visibilityOf(receiptAmount));
		receiptAmount.clear();
		receiptAmount.sendKeys(amount);
	}
	
	public void selectReceiptGLTemplate()
	{
		Select sc= new Select(glTemplate);
		sc.selectByIndex(1);
	}
	
	public void enterCheckNumber(String chkNumber)
	{
		checkNumber.sendKeys(chkNumber);
		
	}
	
	public void enterNameOnCheck(String nameOnChk)
	{
		nameOnCheck.sendKeys(nameOnChk);
		
	}
	
	
	public void clickOnSaveAndSelect()
	{
		saveAndSelectButton.click();
		for (int i=1;i<=1;i++)
		{
			try
			{
				WebDriverWait wt=new WebDriverWait(driver, 60);
				wt.until(ExpectedConditions.alertIsPresent());
				Alert alert = driver.switchTo().alert();
				alert.accept();
			}
			catch (Exception e)
			{
				
			}
		}
	}
	
}
