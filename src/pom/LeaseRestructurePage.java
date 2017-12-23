package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.BasePage;

public class LeaseRestructurePage extends BasePage
{
	@FindBy(id="ctl00_F_PH_cboGLTemplateID_cboGLTransaction")
	private WebElement glTempalte;
	
	@FindBy(id="ctl00_Fr_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;

	public LeaseRestructurePage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void selectGLTemplate()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(glTempalte));
		
		Select sc= new Select(glTempalte);
		sc.selectByIndex(1);
	}
	
	public void clickOnSaveButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(saveButton));
		saveButton.click();
	}

}
