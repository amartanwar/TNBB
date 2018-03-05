package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class VendorInvoiceAssets extends BasePage {

	public VendorInvoiceAssets(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="ctl00_FC_PH_grdProfile_lnkAllCP")
	private WebElement selectAllButton;

	@FindBy(id="ctl00_FC_PH_grdProfile_AssignmentListControl_fields")
	private WebElement assignmentSelect;

	@FindBy(id="igtxtctl00_FC_PH_grdProfile_txtCurrency_ALBrRrrRrrRr0rRr0")
	private WebElement entervalue;
	
	@FindBy(id="ctl00_FC_PH_grdProfile_AssignmentListControl_entryButtons")
	private WebElement addButton;
	
	@FindBy(id="ctl00_FC_PH_grdProfile_cmdAssign_cmdButtonControl")
	private WebElement assignButton;
	
	@FindBy(id="ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	
	public void clickOnSelectAllButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 300);
		wt.until(ExpectedConditions.elementToBeClickable(selectAllButton));
		selectAllButton.click();
	}
	
	public void selectAssignmentSelect()
	{
		WebDriverWait wt= new WebDriverWait(driver, 300);
		wt.until(ExpectedConditions.elementToBeClickable(assignmentSelect));
		Select se = new Select(assignmentSelect);
		se.selectByIndex(1);
	}
	
	public void enterAmount(String amount)
	{
		WebDriverWait wt= new WebDriverWait(driver, 300);
		wt.until(ExpectedConditions.elementToBeClickable(entervalue));
		entervalue.sendKeys(amount);
	}
	
	public void clickAssignmentAddButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 300);
		wt.until(ExpectedConditions.elementToBeClickable(addButton));
		addButton.click();
	}
	
	public void clickAssignmentButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 300);
		wt.until(ExpectedConditions.elementToBeClickable(assignButton));
		assignButton.click();
	}
	
	
	public void clickSaveButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 300);
		wt.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
	}
	
	
	
	
	
	
}
