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

public class LeaseClassificationPage extends BasePage
{
	@FindBy(id="ctl00_F_PH_chkTransferofOwnership")
	private WebElement transferofOwnership;

	@FindBy(id="ctl00_F_PH_chkBargainPurchaseOption")
	private WebElement bargainPurchaseOption;

	@FindBy(id="ctl00_F_PH_cboLeaseTypeID_cboComboBoxControl")
	private WebElement leaseAccountingTreatment;

	@FindBy(id="ctl00_F_PH_cboGLTemplateID_cboGLTransaction")
	private WebElement leaseBookingGLTemplate;

	@FindBy(id="ctl00_F_PH_cboLTRToARGLTemplateID_cboGLTransaction")
	private WebElement ltrToARGLTemplate;

	@FindBy(id="ctl00_F_PH_cboClientLeaseType_cboComboBoxControl")
	private WebElement clientLeaseType;

	@FindBy(id="ctl00_Fr_PH_cmdnintyPercent_cmdButtonControl")
	private WebElement perform90PercentTestButton;

	@FindBy( id="ctl00_Fr_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	public LeaseClassificationPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
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
		Select se= new Select(leaseBookingGLTemplate);
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
	
	public void selectClientLeaseType()
	{
		Select se= new Select(clientLeaseType);
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
				
				WebDriverWait wt=new WebDriverWait(driver, 10);
				wt.until(ExpectedConditions.alertIsPresent());
				Alert alert = driver.switchTo().alert();
				alert.accept();
				
			}
			catch (Exception e)
			{
				
			}
		
	}
	
}
