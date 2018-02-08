package pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class LeaseClassificationPage extends BasePage
{
	@FindBy(id="igtxtctl00_FC_PH_txtTotalEconomicLife")
	private WebElement totalEconomicLife;
	
	@FindBy(id="igtxtctl00_FC_PH_txtTotalRemainingLife")
	private WebElement totalRemainingLife;
	
	//not done
	@FindBy(id="ctl00_FC_PH_chkTransferofOwnership")
	private WebElement transferofOwnership;

	//not done
	@FindBy(id="ctl00_FC_PH_chkBargainPurchaseOption")
	private WebElement bargainPurchaseOption;

	@FindBy(id="ctl00_FC_PH_cboLeaseTypeID_cboComboBoxControl")
	private WebElement leaseAccountingTreatment;

	@FindBy(id="ctl00_FC_PH_cboGLTemplateID_cboGLTransaction")
	private WebElement leaseBookingGLTemplate;

	@FindBy(id="ctl00_FC_PH_cboLTRToARGLTemplateID_cboGLTransaction")
	private WebElement ltrToARGLTemplate;

	@FindBy(id="ctl00_FC_PH_cboClientLeaseType_cboComboBoxControl")
	private WebElement product;

	@FindBy(id="ctl00_FT_PH_cmdnintyPercent_cmdButtonControl")
	private WebElement perform90PercentTestButton;

	@FindBy( id="ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	@FindBy(id="ctl00_FC_PH_cboOverTermPaymentARGLTemplateID_cboGLTransaction")
	public WebElement OtpARGLTemplate;
	
	public LeaseClassificationPage(WebDriver driver, ExtentTest test)
	{
		super(driver,test);
		PageFactory.initElements(driver, this);
	}
	
	public void enterTotalEconomicLife(String economiclife)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(totalEconomicLife));
		totalEconomicLife.clear();
		totalEconomicLife.sendKeys(economiclife);
	}
	
	public void enterTotalRemainingLife(String remainingLife)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(totalRemainingLife));
		totalRemainingLife.sendKeys(remainingLife);
	}
	
	public void selectTransferofOwnership()
	{
		transferofOwnership.click();
	}
	
	public void selectBargainPurchaseOption()
	{
		bargainPurchaseOption.click();
	}
	
	public void selectLeaseBookingGLTemplate()
	{
		WebDriverWait wt= new WebDriverWait(driver, 30);
		wt.until(ExpectedConditions.elementToBeClickable(leaseBookingGLTemplate));
		Select se= new Select(leaseBookingGLTemplate);
		se.selectByIndex(1);
	}
	
	public void selectOTPARGLTemplate()
	{

		Select se= new Select(OtpARGLTemplate);
		se.selectByIndex(1);
	}
	
	public void selectLtrToARGLTemplate()
	{
		Select se= new Select(ltrToARGLTemplate);
		se.selectByIndex(1);
	}
	
	public void selectLeaseAccountingTreatment()
	{
		Select se= new Select(leaseAccountingTreatment);
		se.selectByIndex(1);
	}
	
	public void selectProduct()
	{
		Select se= new Select(product);
		se.selectByIndex(1);
	}
	
	public void clickOnPerform90PercentTestButton()
	{
		perform90PercentTestButton.click();
	}
	
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	
	public void handleAlert()
	{
		
			try
			{
				
				WebDriverWait wt=new WebDriverWait(driver, 3);
				wt.until(ExpectedConditions.alertIsPresent());
				Alert alert = driver.switchTo().alert();
				alert.accept();
				
			}
			catch (Exception e)
			{
				
			}
		
	}
	
}
