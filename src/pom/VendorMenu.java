package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class VendorMenu extends BasePage{

	public VendorMenu(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="ctl00ctl04WebMenuControl_3")
	private WebElement vendorMenu;
	
	@FindBy(xpath="id(\"ctl00ctl04WebMenuControl_3_4\")/td[1]/div[1]")
	private WebElement invoiceManagement;
	
	public void clickVendorMenu()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(vendorMenu));
		vendorMenu.click();
	}
	
	
	public void clickInvoiceManagementLink()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(invoiceManagement));
		invoiceManagement.click();
	}
	
	
	
	
	@FindBy(xpath="id(\"lnkMenuWF\")")
	private WebElement originationInstallation;
	
	public void clickoriginationinstallation()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(originationInstallation));
		originationInstallation.click();
	}
	
	
	
	
	
}
