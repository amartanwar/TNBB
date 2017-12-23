package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.BasePage;

public class LeaseInvestementPage extends BasePage
{
	@FindBy(id="ctl00_Fr_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	public LeaseInvestementPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSaveButton()
	{
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
	}

}
