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
	
	@FindBy(id="ctl00_FC_PH_chkIsTaxLease")
	private WebElement taxLeaseCheckBox;
	
	@FindBy(id="ctl00_FC_PH_chkIsTRACLease")
	private WebElement tracLeaseCheckBox;
	
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
		totalRemainingLife.clear();
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
	
	public void selectLeaseBookingGLTemplate(String index)
	{
		WebDriverWait wt= new WebDriverWait(driver, 30);
		wt.until(ExpectedConditions.elementToBeClickable(leaseBookingGLTemplate));
		Select se= new Select(leaseBookingGLTemplate);
		se.selectByVisibleText(index);
	}
	
	public void selectOTPARGLTemplate(String index)
	{

		Select se= new Select(OtpARGLTemplate);
		se.selectByVisibleText(index);
	}
	
	public void selectLtrToARGLTemplate(String index)
	{
		Select se= new Select(ltrToARGLTemplate);
		System.out.println(index);
		se.selectByVisibleText(index);
	}
	
	public void selectLeaseAccountingTreatment(String index) throws InterruptedException
	{
		Select se= new Select(leaseAccountingTreatment);
		se.selectByVisibleText(index); 
	}
	
	public void selectProduct(String index)
	{
		Select se= new Select(product);
		se.selectByVisibleText(index);
	}
	
	public void clickOnPerform90PercentTestButton()
	{
		perform90PercentTestButton.click();
	}
	
	public void clickOnSaveButton()
	{
		WebDriverWait wt = new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.titleContains("Lease Classification Test"));
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
	
	public void deselectTaxLease()
	{
		taxLeaseCheckBox.click();
	}
	
	public void deselectTracLease()
	{
		tracLeaseCheckBox.click();
	}
}
