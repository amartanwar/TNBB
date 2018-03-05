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

public class VendorInvoiceEntryHome extends BasePage {

	public VendorInvoiceEntryHome(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="ctl00_NB_PH_UCVendorInvoiceLink_ddlBookingStatus")
	private WebElement bookingStatus;
	
	@FindBy(id="ctl00_NB_PH_UCVendorInvoiceLink_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	@FindBy(id="ctl00_PT_PH_UCVendorInvoiceContext_txtVendorInvoiceNumber")
	private WebElement viNumber;
	
	
	public void changeBookingStatus()
	{
		WebDriverWait wt= new WebDriverWait(driver, 300);
		wt.until(ExpectedConditions.elementToBeClickable(bookingStatus));
		Select se = new Select(bookingStatus);
		se.selectByIndex(1);
	}
	
	public String clickSaveButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 300);
		wt.until(ExpectedConditions.elementToBeClickable(saveButton));
		
		String VInumber = viNumber.getAttribute("value");

		saveButton.click();
		return VInumber;
	}
}

