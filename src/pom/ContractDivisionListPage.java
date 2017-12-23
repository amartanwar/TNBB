package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.BasePage;

public class ContractDivisionListPage extends BasePage
{
	@FindBy(id="ctl00_Fr_PH_cmdClose_cmdButtonControl")
	private WebElement closeButton;

	public ContractDivisionListPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCloseButton()
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.titleContains("Contract Division List"));
		closeButton.click();
	}

}
