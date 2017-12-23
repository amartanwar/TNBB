package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BasePage;

public class LoginPage extends BasePage
{
	@FindBy(id="ctl00_FT_PH_txtCompanyName")
	private WebElement companyName;
	
	@FindBy(id="ctl00_FT_PH_lnkCompany")
	private WebElement rideTheLeaseWave;
	
	@FindBy(id="ctl00_FT_PH_loginControl_txtUserName")
	public WebElement userName;
	
	@FindBy(id="ctl00_FT_PH_loginControl_txtPassword")
	private WebElement password;
	
	@FindBy(id="ctl00_FT_PH_loginControl_cmdLogin1_cmdButtonControl")
	private WebElement loginButton;
	
	@FindBy(id="ctl00_ctl04_lnkSignOut")
	private WebElement logoutButton;
	
	public LoginPage(WebDriver driver)
	{
	super(driver);
	PageFactory.initElements(driver, this);;
	}
	
	public void setCompanyName(String comName)
	{
		companyName.clear();
		companyName.sendKeys(comName);
	}
	
	public void rideTheLeaseWave()
	{
		rideTheLeaseWave.click();
	}
	
	public void setuserName(String un)
	{
		userName.clear();
		userName.sendKeys(un);
	}
	
	public void setPassword(String pwd)
	{
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickOnLogin()
	{
		loginButton.click();
	}
	
	public void clickOnLogOut()
	{
		logoutButton.click();
	}
	
	
}
