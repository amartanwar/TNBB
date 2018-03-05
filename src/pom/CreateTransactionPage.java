package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class CreateTransactionPage extends BasePage{

 

	@FindBy(id="ctl00_FC_PH_WorkflowBeginStep_cboWF_cboComboBoxControl")
    private WebElement workFlow;


    @FindBy(id="ctl00_FC_PH_WorkflowBeginStep_cboStep_cboComboBoxControl")
    private WebElement beginStep;


    @FindBy(id="ctl00_FC_PH_txtTransactionAlias")
    private WebElement transactionNumber;


    @FindBy(id="ctl00_FC_PH_WorkflowBeginStep_chkIsOverRideException")
    private WebElement overRideException;
	
    @FindBy(id="ctl00_FT_PH_cmdSelect_cmdButtonControl")
    private WebElement selectButton;
    
    @FindBy(id="ctl00_FT_PH_cmdClose_cmdButtonControl")
    private WebElement closeButton;
    
    public CreateTransactionPage(WebDriver driver, ExtentTest test) {
 		super(driver, test);
 		PageFactory.initElements(driver, this);
 	}
    
    public void enterTransactionNumber(String TransactionNumber)
    {
    	WebDriverWait wait = new WebDriverWait(driver, 5);
    	wait.until(ExpectedConditions.visibilityOf(transactionNumber));
    	transactionNumber.sendKeys(TransactionNumber);
    }
	
    public void clickSelectButton()
    {
    	WebDriverWait wait = new WebDriverWait(driver, 5);
    	wait.until(ExpectedConditions.visibilityOf(selectButton));
    	selectButton.click();
    }
     public void clickCloseButton()
     {
    	 WebDriverWait wait = new WebDriverWait(driver, 5);
     	wait.until(ExpectedConditions.visibilityOf(closeButton));
     	closeButton.click();
     }
    
     public void checkOverrideException()
     {
    	 WebDriverWait wait = new WebDriverWait(driver, 5);
     	wait.until(ExpectedConditions.visibilityOf(overRideException));
     	overRideException.click();
     }
    
    
}
