package pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class ContractBillingMethodPage extends BasePage
{
	@FindBy(id="ctl00_F_PH_cmdAddGridProfile_cmdButtonControl")
	private WebElement addButton;
	
	@FindBy(id="ctl00_F_PH_cboParameterType_cboComboBoxControl")
	private WebElement parameterType;
	
	@FindBy(id="ctl00_F_PH_chkDefault")
	private WebElement defaultcheckBox;
	
	@FindBy(id="ctl00_F_PH_cboFrequency_cboComboBoxControl")
	private WebElement frequency;
	
	@FindBy(id="ctl00_F_PH_cboDayOfMonth_cboComboBoxControl")
	private WebElement dayOfMonth;
	
	@FindBy( id="ctl00_F_PH_chkIsDaysAfterIG")
	private WebElement daysAfterInvoiceGenerationCheckbox;
	
	@FindBy(id="igtxtctl00_F_PH_txtDaysAfterIG")
	private WebElement daysAfterInvoiceGenerationTextbox;
	
	@FindBy(id="ctl00_F_PH_cmdSaveGridProfile_cmdButtonControl")
	private WebElement billingsaveButton;
	
	@FindBy(id="ctl00_Fr_PH_cmdSave_cmdButtonControl")
	private WebElement pageSaveButton;
	
	public ContractBillingMethodPage(WebDriver driver,ExtentTest test) 
	{
		super(driver,test);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAddButton() throws AWTException
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
		wt1.until(ExpectedConditions.titleContains("Billing Method"));
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(addButton));
//		addButton.click();
		
		Robot rt=new Robot();
		rt.keyPress(KeyEvent.VK_ENTER);
		rt.keyRelease(KeyEvent.VK_ENTER);
		
				
	}
	
	public void selectparameterType()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(parameterType));
		Select sc=new Select(parameterType);
		sc.selectByIndex(2);
	}
	
	public void selectDefaultcheckBox()
	{
		defaultcheckBox.click();
	}
	
	public void selectFrequency()
	{
		Select sc= new Select(frequency);
		sc.selectByIndex(5);
	}
	
	public void selectDayOfMoth()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(dayOfMonth));
		Select sc=new Select(dayOfMonth);
		sc.selectByIndex(30);
	}

	public void enterDaysAfterInvoiceGeneration()
	{
		daysAfterInvoiceGenerationCheckbox.click();
		daysAfterInvoiceGenerationTextbox.sendKeys("30");
	}
	
	public void clickOnlocalsaveBillingDetails()
	{
		billingsaveButton.click();
	}
	
	public void clickOnglobalsaveBillingDetails()
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(pageSaveButton));
		pageSaveButton.click();
	}
}
