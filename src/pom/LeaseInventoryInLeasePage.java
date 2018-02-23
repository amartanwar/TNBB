package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;
import generic.SwitchControlToNextWindow;

public class LeaseInventoryInLeasePage extends BasePage  
{
	@FindBy(id="ctl00_FC_PH_cmdImport_cmdImportButton")
	private WebElement importButton;

	@FindBy(xpath="//*[@id=\'ctl00xFCxPHxgrdProfilexgrdList_rc_0_0\']/nobr/input")
	private WebElement selectCheckBox;

	@FindBy(xpath="//*[@id=\'ctl00xFCxPHxgrdProfilexgrdList_rc_0_2\']/nobr/input")
	private WebElement primaryAsset;
	
	@FindBy(id="ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement PageSaveButton;
	
	@FindBy(css = "#ctl00xFCxPHxgrdProfilexgrdList_rc_0_1 > nobr")
	private WebElement assetID;
	
	@FindBy(id="ctl00_FT_PH_cmdSaveContinue_cmdButtonControl")
	private WebElement saveAndContinue;

	public LeaseInventoryInLeasePage(WebDriver driver, ExtentTest test) 
	{
		super(driver,test);
		PageFactory.initElements(driver, this);
	}
	
	public String clickOnImportButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 300);
		wt.until(ExpectedConditions.visibilityOf(importButton));
		String currentWindow = driver.getWindowHandle();
		importButton.click();
		SwitchControlToNextWindow sc= new SwitchControlToNextWindow();
		sc.waitForWndows(driver, currentWindow); //Control is being changed to new window
		return currentWindow;
	}
	
	public void clickOnPageSaveButton() throws InterruptedException
	{
		WebDriverWait wt= new WebDriverWait(driver, 300);
		wt.until(ExpectedConditions.titleIs("Assets In Lease"));
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
	
	public String getAssetID()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(assetID));
		String InventoryID = assetID.getText();
		return InventoryID;
			
	}
	
	public void clickSaveAndContinue()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(saveAndContinue));
		saveAndContinue.click();
	}

}
