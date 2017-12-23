package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.BasePage;
import generic.SwitchControlToNextWindow;
import generic.SystemDate;

public class LeaseInventoryInLeasePage extends BasePage  
{
	@FindBy(id="ctl00_F_PH_cmdImportAdd_cmdImportButton")
	private WebElement addButton;

	@FindBy(xpath=".//*[@id='ctl00xFxPHxgrdProfilexgrdList_rc_0_0']/nobr/input")
	private WebElement selectCheckBox;

	@FindBy(xpath=".//*[@id='ctl00xFxPHxgrdProfilexgrdList_rc_0_5']/nobr/input")
	private WebElement primaryAsset;

	@FindBy(id="ctl00_F_PH_cmdEdit_cmdButtonControl")
	private WebElement editButton;

	@FindBy(id="igtxtctl00_F_PH_txtOdometerReading")
	private WebElement deliveryOdometerReading;

	@FindBy(id="ctl00_F_PH_txtDeliveryDate_input")
	private WebElement deliveryDate;

	@FindBy( id="ctl00_F_PH_cmdGridSave_cmdButtonControl")
	private WebElement gridSaveButton;
	
	@FindBy(id="ctl00_Fr_PH_cmdSave1_cmdButtonControl")
	private WebElement PageSaveButton;

	public LeaseInventoryInLeasePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAddButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 300);
		wt.until(ExpectedConditions.visibilityOf(addButton));
		String currentWindow = driver.getWindowHandle();
		
		addButton.click();
		SwitchControlToNextWindow sc= new SwitchControlToNextWindow();
		sc.waitForWndows(driver, currentWindow);
	}
	
	public void clickOnEditButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(editButton));
		editButton.click();
	}
	
	public void enterOdometerReading(String odoMeterReading)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(deliveryOdometerReading));
		deliveryOdometerReading.sendKeys(odoMeterReading);
	}
	
	public void enterDeliverydate()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(deliveryDate));
		deliveryDate.sendKeys(SystemDate.currentDate());
	}
	
	public void enterDeliverydate(String date)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(deliveryDate));
		deliveryDate.sendKeys(date);
	}
	
	public void clickOnGridSaveButton()
	{
		gridSaveButton.click();
	}
	
	public void clickOnPageSaveButton() throws InterruptedException
	{
		Thread.sleep(2000);
		PageSaveButton.click();
	}
	public void selectAsset()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(selectCheckBox));
		selectCheckBox.click();
	}
	
	public void selectPrimaryAsset()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(primaryAsset));
		primaryAsset.click();
	}

}
