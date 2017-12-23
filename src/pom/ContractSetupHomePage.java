package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.BasePage;

public class ContractSetupHomePage extends BasePage
{
	@FindBy(id="ctl00_NB_PH_UCContractNavigationLink_cmdBilling")
	private WebElement billingSetup;
	
	@FindBy(id="ctl00_NB_PH_UCContractNavigationLink_cmdContractProfileClose_cmdButtonControl")
	private WebElement closeButton;
	
	public ContractSetupHomePage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnBillingMethod()
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(billingSetup));
		billingSetup.click();
	}
	
	public void clickOnCloseButton()
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.titleContains("Contract Setup Home"));
		closeButton.click();
	}
}
