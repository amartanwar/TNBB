package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class LeaseBlendedIncome extends BasePage
{
	@FindBy(id="ctl00_FT_PH_cmdLeaseClose_cmdButtonControl")
	private WebElement saveButton;
	

	public LeaseBlendedIncome(WebDriver driver, ExtentTest test)
	{
		super(driver, test);
		PageFactory.initElements(driver, this);
	}
	
	public void enterIDCAMount()
	{
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.titleContains("Blended"));
		saveButton.click();
	}
	
}
