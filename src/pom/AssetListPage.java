package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.BasePage;

public  class AssetListPage extends BasePage
{

	@FindBy(id="ctl00_Fr_PH_cmdAdd_cmdButtonControl")
	private WebElement adddButton;
	
	@FindBy(id="ctl00_ctl04_lnkSignOut")
	public WebElement pageTitle;
	
	@FindBy(id="ctl00_F_PH_schSearchControl_bshBasicSearch_OneStringctl00_F_PH_schSearchControlrRrrRrrRr0rRr0mUnitNumber")
	private WebElement unitnumber;

	@FindBy(id="ctl00_F_PH_schSearchControl_cmdSearch_cmdButtonControl")
	private WebElement searchButton;


	@FindBy(xpath="//input[@class='igtbl_checkBox']")
	private WebElement chkBox;
	
	@FindBy(id="ctl00_Fr_PH_cmdSelect_cmdButtonControl")
	private WebElement selectButton;
	
	@FindBy(id="ctl00_Fr_PH_cmdSelectClient_cmdExportButton")
	private WebElement selectExportButton;
	
	
	public AssetListPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnaddButton()
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(adddButton));
		adddButton.click();
		
	}
	
	public void searchByUnitNumber(String unNumber) throws InterruptedException
	{
		WebDriverWait wt1=new WebDriverWait(driver, 60);
		wt1.until(ExpectedConditions.visibilityOf(unitnumber));
		unitnumber.clear();
		unitnumber.sendKeys(unNumber);
	}
	
	public void clickOnSearchButton(String unNumber) throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(searchButton));
		searchButton.click();
	}
	
	public void selectCheckBox()
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(chkBox));
		chkBox.click();
		
	}
	
	public void clickONSelectButton()
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(selectButton));
		selectButton.click();
		
	}
	
	public void clickOnSelectExportButton() 
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeSelected(chkBox));
		selectExportButton.click();
		
	}
	
	
	
}
