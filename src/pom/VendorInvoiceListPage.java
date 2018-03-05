package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class VendorInvoiceListPage extends BasePage {

	public VendorInvoiceListPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="ctl00_FC_PH_schSearchControl_bshBasicSearch_OneStringctl00_FC_PH_schSearchControlrRrrRrrRr0rRr3")
	private WebElement vendorInvoiceNumber;
	
	@FindBy(id="ctl00_FC_PH_schSearchControl_cmdSearch_cmdButtonControl")
	private WebElement searchButton;
	
	@FindBy(id="ctl00_FT_PH_cmdSelectClient_cmdExportButton")
	private WebElement selectButton;
	
	@FindBy(id="ctl00_FC_PH_grdList_lnkAllCP")
	private WebElement selectALLButton;
	
	@FindBy(id="ctl00_FT_PH_cmdAdd_cmdButtonControl")
	private WebElement addButton;
	
	
	
	
	public void addVendorInvoiceNumber(String vinumber)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(vendorInvoiceNumber));
		vendorInvoiceNumber.sendKeys(vinumber);
	}
	
	public void clickOnSearchButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();
	}
	
	public void clickOnSelectButton(String beforewindow1)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(selectButton));
		selectButton.click();
		driver.switchTo().window(beforewindow1);
	}
	
	public void clickOnSelectALLButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(selectALLButton));
		selectALLButton.click();
	}
	
	public void clickAddButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		addButton.click();
	}
	
}
