package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.BasePage;

public class CustomerListPage extends BasePage
{
	@FindBy(id="ctl00_F_PH_schSearchControl_bshBasicSearch_OneStringctl00_F_PH_schSearchControlrRrrRrrRr0rRr0mAccountNumber")
	private WebElement accountNumber;

	@FindBy(id="ctl00_F_PH_schSearchControl_cmdSearch_cmdButtonControl")
	private WebElement searchButton;

	@FindBy(id="ctl00_Fr_PH_cmdSelect_cmdButtonControl")
	private WebElement selectButton;
	
	public CustomerListPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void enterAccountNumber(String accountNum)
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.titleContains("Customer List"));
		accountNumber.sendKeys(accountNum);
	}
	
	public void clickOnsearchButton()
	{
		searchButton.click();
	}
	
	public void clickOnSelectButton()
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(selectButton));
		selectButton.click();
	}
}
