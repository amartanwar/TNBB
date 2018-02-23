package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class LeaseIDCSetupPage extends BasePage
{
	@FindBy(id="ctl00_FC_PH_cboIDCTemplateName_cboComboBoxControl")
	private WebElement idcTemplate;
	
	@FindBy(id="ctl00_FC_PH_cmdAdd_cmdButtonControl")
	private WebElement addButton;
	
	//@FindBy(xpath="//*[@id=\'ctl00xFCxPHxgrdLeaseIDCxgrdList_rc_0_3\']")
	@FindBy(id = "ctl00xFCxPHxgrdLeaseIDCxgrdList_rc_0_3")
	private WebElement Amount;
	
	@FindBy(id = "igtxtctl00_FC_PH_grdLeaseIDC_grdLeaseIDCLWGridEditor_Controls2")
	private WebElement enterAmount;
	
	@FindBy(id="ctl00_FT_PH_cmdRecalculate_cmdButtonControl")
	private WebElement recalculateIDC;

	@FindBy(id="ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	@FindBy(className= "igtbl_checkBox")
	private WebElement checkBox;

	public LeaseIDCSetupPage(WebDriver driver, ExtentTest test)
	{
		super(driver,test);
		PageFactory.initElements(driver, this);
	}
	
	public void selectIDCTemplate(String index)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(idcTemplate));
		Select se = new Select(idcTemplate);
		///String in = index;
		//int index1 = Integer.parseInt(in);
		se.selectByVisibleText(index);
	}
	
	public void clickOnAddButton()
	{ 
		addButton.click();
	}
	
	public void clickIDCAmount() throws InterruptedException
	{
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(Amount));
		Amount.click();
	}
	
	
	public void enterIDCAmount(String amount) throws InterruptedException
	{
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(enterAmount));
		enterAmount.clear();
		enterAmount.sendKeys(amount);
	}
	public void clickOnSaveButton()
	{
		String title = driver.getTitle();
		System.out.println(title);
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
	}
	
	public void clickOnRecalculateIDCButton()
	{
		recalculateIDC.click();
	}
	
	public void selectCheckBox()
	{
		checkBox.click();
	}

}
