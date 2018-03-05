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

public class VendorInvoiceProfilePage extends BasePage{

	public VendorInvoiceProfilePage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="ctl00_FC_PH_txtCustomerNumber")
	public WebElement customerNumber;
	
	@FindBy(id="ctl00_FC_PH_cboGLTemplateID_cboGLTransaction")
	public WebElement glTemplate;
	
	@FindBy(id="ctl00_FC_PH_txtVendor")
	public WebElement vendorNumber;
	
	@FindBy(id="igtxtctl00_FC_PH_txtInvoiceTotal_txtWebCurrencyEdit")
	public WebElement invoiceTotal;
	
	@FindBy(id="ctl00_FC_PH_txtVendInv")
	public WebElement vendorInvoiceNumber;
	
	@FindBy(id="igtxtctl00_FC_PH_txTotalNoOfAssets")
	public WebElement totalNumberOfAssets;
	
	@FindBy(id="igtxtctl00_FC_PH_txtTotalOriginalAssetCost_txtWebCurrencyEdit")
	public WebElement totalAquisitionCost;
	
	@FindBy(id="ctl00_FT_PH_cmdSave_cmdButtonControl")
	public WebElement saveButton;
	
	
	public void enterCustomerNumber(String customernumber)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(customerNumber));
		customerNumber.clear();
		customerNumber.sendKeys(customernumber);
	}
	
	public void selectGLTemplate(String gltemplate)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(glTemplate));
		Select se = new Select(glTemplate);
		se.selectByVisibleText(gltemplate);
		
	}
	
	public void enterVendorNumber(String vendornumber)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(vendorNumber));
		vendorNumber.clear();
		vendorNumber.sendKeys(vendornumber);
	}
	
	
	public void enterInvoiceTotal(String invoicetotal)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(invoiceTotal));
		invoiceTotal.clear();
		invoiceTotal.sendKeys(invoicetotal);
	}
	
	public void entervendorInvoiceNumber(String vendorinvoicenumber)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(invoiceTotal));
		vendorInvoiceNumber.clear();
		vendorInvoiceNumber.sendKeys(vendorinvoicenumber);
	}
	
	public void enterNumberOfAssets(String numberofassets)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(invoiceTotal));
		totalNumberOfAssets.clear();
		totalNumberOfAssets.sendKeys(numberofassets);
	}
	
	public void enterTotalAquisitionCost(String aquisitioncost)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(totalAquisitionCost));
		totalAquisitionCost.clear();
		totalAquisitionCost.sendKeys(aquisitioncost);
	}
	
	
	public void clickOnSaveButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
