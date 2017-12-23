package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.BasePage;

public class ProductProfilePage extends BasePage
{
	

	@FindBy(id="ctl00_F_PH_txtProductCode")
	private WebElement prdCode;
	
	@FindBy(id="ctl00_F_PH_txtProductName")
	private WebElement prodName;
	
	@FindBy(id="ctl00_F_PH_cboCategory_cboCategory_cboComboBoxControl")
	private WebElement productCategory;
	
	@FindBy(id="ctl00_F_PH_cboFrequency_cboComboBoxControl")
	private WebElement frequency;
	
	@FindBy(id="ctl00_F_PH_cboGLTemplate_cboGLTransaction")
	private WebElement glTemplate;
	
	@FindBy(id="ctl00_F_PH_cboSundryCode_cboComboBoxControl")
	private WebElement sundryCode;
	
	@FindBy(id="ctl00_Fr_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;

	public ProductProfilePage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterProductCode(String productCode)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.titleContains("Product Profile"));
		prdCode.sendKeys(productCode);
	}
	
	public void enterProductName(String programName)
	{
		prodName.sendKeys(programName);
	}
	
	public void selectProductCategory(int index)
	{
		Select sc=new Select(productCategory);
		sc.selectByIndex(index);
	}
	
	public void selectProductFrequency(int index)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(frequency));
		Select sc=new Select(frequency);
		sc.selectByIndex(index);
	}
	
	public void selectGLTemplate(int index)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(glTemplate));
		Select sc=new Select(glTemplate);
		sc.selectByIndex(index);
	}
	
	public void selectSundryCode(int index)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(sundryCode));
		Select sc=new Select(sundryCode);
		sc.selectByIndex(index);
	}
	
	public void clickOnSaveButton()
	{
		saveButton.click();
	}

}
