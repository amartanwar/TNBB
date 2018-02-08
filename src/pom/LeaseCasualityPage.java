package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class LeaseCasualityPage extends BasePage{

		@FindBy(id="ctl00_FT_PH_cmdSave_cmdButtonControl")
		private WebElement saveButton;
		
		public void clickOnSaveButton()
		{
			saveButton.click();
		}
		
		public LeaseCasualityPage(WebDriver driver, ExtentTest test)
		{
			super(driver,test);
			PageFactory.initElements(driver, this);
		}
	
}
