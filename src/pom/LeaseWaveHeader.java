package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.BasePage;

public  class LeaseWaveHeader extends BasePage
{
	@FindBy(xpath="//*[@id=\'lnkMenuLA\']/a")
	private WebElement portFoliomanagement;
	
	@FindBy(xpath="//*[@id=\'lnkMenuWF\']/a")
	private WebElement originationAndInstallation;
	
	@FindBy(xpath="//*[@id=\'lnkMenuGL\']/a")
	private WebElement generalLedger;
	
	@FindBy(xpath="//*[@id=\'lnkMenuCS\']/a")
	private WebElement setup;
	
	
	public LeaseWaveHeader(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnPortFolioManagement()
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(portFoliomanagement));
		portFoliomanagement.click();
	}
	
	public void clickOnoriginationAndInstallation()
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(originationAndInstallation));
		originationAndInstallation.click();
	}
	
	public void clickOngeneralLedger()
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(generalLedger));
		generalLedger.click();
	}
	
	public void clickOnsetup()
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(setup));
		setup.click();
	}
	

}
