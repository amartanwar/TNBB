package pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class AssetValueAndStatusChangePage extends BasePage
{
	@FindBy(xpath="//input[@class='igtbl_checkBox']")
	private WebElement gridCheckBox;

	@FindBy(id="ctl00_F_PH_grdList_AssignmentListControl_fields")
	private WebElement assignmentDropDown;

	@FindBy(id="igtxtctl00_F_PH_grdList_txtCurrency_ALBrRrrRrrRr0rRr10")
	private WebElement costAssignmentTextbox;

	@FindBy(xpath=".//*[@id='ctl00_F_PH_grdList_AssignmentListControl_entryButtons']/button")
	private WebElement addButton;

	@FindBy(id="ctl00_F_PH_grdList_cmdAssign_cmdButtonControl")
	private WebElement assignmentButton;

	@FindBy(id="ctl00_F_PH_cboGLTemplate_cboGLTransaction")
	private WebElement glTemplate;
	
	@FindBy(id="ctl00_Fr_PH_cmdClose_cmdButtonControl")
	private WebElement closeButton;
	
	@FindBy(id="ctl00_Fr_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	public AssetValueAndStatusChangePage(WebDriver driver,ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}
	
	public void selectGridCheckBox()
	{
		WebDriverWait wt= new WebDriverWait(driver,60);
		wt.until(ExpectedConditions.visibilityOf(gridCheckBox));
		gridCheckBox.click();
	}
	
	public void selectAssignmentOperator()
	{
		if(gridCheckBox.isSelected()==true)
		{
			Select se=new Select(assignmentDropDown);
			se.selectByIndex(1);
		}
		else
		{
			gridCheckBox.click();
			Select se=new Select(assignmentDropDown);
			se.selectByIndex(1);
		}
	}
	public void enterCostOfAsset(String cost)
	{
		WebDriverWait wt= new WebDriverWait(driver,60);
		wt.until(ExpectedConditions.visibilityOf(costAssignmentTextbox));
		costAssignmentTextbox.sendKeys(cost);
	}
	
	public void clickOnAddButton()
	{
		addButton.click();
	}
	
	public void clickOnAssignmentButton()
	{
		assignmentButton.click();
	}
	
	public void selectGLTemplate()
	{
		Select se= new Select(glTemplate);
		se.selectByIndex(1);
	}
	
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	
	public void handlePopup()
	{
		WebDriverWait wt=new WebDriverWait(driver,60);
		wt.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void clickOnCloseButton()
	{
		try
		{
			WebDriverWait wt=new WebDriverWait(driver,10);
			wt.until(ExpectedConditions.titleIs("Asset Value and Status Change - En Masse"));
			closeButton.click();
		}
		catch(Exception e)
		{
			
		}
		 
	}
}
