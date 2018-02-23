package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class LeaseCasualityPage extends BasePage{

		@FindBy(id="ctl00_FT_PH_cmdSave_cmdButtonControl")
		private WebElement saveButton;
		
		public void clickOnSaveButton()
		{
			WebDriverWait wt = new WebDriverWait(driver, 60);
			wt.until(ExpectedConditions.titleIs("SLV Schedule"));
			saveButton.click();
		}
		
		public LeaseCasualityPage(WebDriver driver, ExtentTest test)
		{
			super(driver,test);
			PageFactory.initElements(driver, this);
		}
	
}
