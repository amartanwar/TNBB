package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BasePage;

public class ContractListPage extends BasePage
{
	@FindBy(id="ctl00_Fr_PH_cmdAdd_cmdButtonControl")
	private WebElement addButton;

	public ContractListPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAddButton()
	{
		addButton.click();
	}

}
