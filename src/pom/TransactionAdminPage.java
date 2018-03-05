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

public class TransactionAdminPage extends BasePage{

	public TransactionAdminPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="ctl00_FC_PH_cboCashReceiptGLTemplateLease_cboGLTransaction")
	private WebElement receiptCashGLTemplate;
	
	@FindBy(id="ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	@FindBy(id="ctl00_FC_PH_cboBankProductCode_cboComboBoxControl")
	private WebElement bankProductCode;
	
	@FindBy(id="ctl00_FC_PH_cboCollateralCode_cboComboBoxControl")
	private WebElement collateralCode;
	
	@FindBy(id="ctl00_FC_PH_CboLoanPurposeCode_cboComboBoxControl")
	private WebElement loanPurposeCode;
	
	@FindBy(id="ctl00_FC_PH_CboResidualResponsibility_cboComboBoxControl")
	private WebElement remarketingResposibility;
	
	
	
	public void selectReceiptCashGLTemplate(String template)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(receiptCashGLTemplate));
		Select se = new Select(receiptCashGLTemplate);
		se.selectByVisibleText(template);
	}
	
	public void clickSaveButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
	}
	
	public void selectBankProductCode(String template1)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(bankProductCode));
		Select se = new Select(bankProductCode);
		se.selectByVisibleText(template1);
	}
	
	public void selectCollateralCode(String template2)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(collateralCode));
		Select se = new Select(collateralCode);
		se.selectByVisibleText(template2);
	}
	
	public void selectLoanPurposeCode(String template3)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(loanPurposeCode));
		Select se = new Select(loanPurposeCode);
		se.selectByVisibleText(template3);
	}
	
	public void selectRemarketingResponsibility(String remarketing)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(remarketingResposibility));
		Select se = new Select(remarketingResposibility);
		se.selectByVisibleText(remarketing);
	}
	
}
