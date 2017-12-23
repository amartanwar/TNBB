package testscripts.Asset;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.AutoConst;
import pom.LoginPage;

public class ApplicationLoginAndLogoutMethod implements AutoConst
{
	public static  WebDriver driver;
	public void openApplication() throws InterruptedException
	{
		//Open the browser
				System.setProperty(IE_KEY,IE_VALUE);
				driver=new InternetExplorerDriver();
				driver.manage().window().maximize();
				Thread.sleep(2000);
				
				//Fetching the data from xlsx
//				String url=excel.getCellValue("./TestData/Input.xlsx", "credentials", 1, 0);
//				String companyName=excel.getCellValue("./TestData/Input.xlsx", "credentials", 1, 1);
//				String userName=excel.getCellValue("./TestData/Input.xlsx", "credentials", 1, 2);
//				String password=excel.getCellValue("./TestData/Input.xlsx", "credentials", 1, 3);
			
				//Opening the application
				driver.get("http://otbapsrv:206");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				LoginPage lp=new LoginPage(driver);
//				lp.setCompanyName("Merchants-tvqa");
				lp.rideTheLeaseWave();
				
				Thread.sleep(2000);
				for(String winHandle: driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle);
				}
				
				WebDriverWait wait= new WebDriverWait(driver, 56);
				wait.until(ExpectedConditions.visibilityOf(lp.userName));
//				lp.setuserName("aishwarya.v");
//				lp.setPassword("Samsung-1234");
				lp.clickOnLogin();
	}
	
	public void closeApplication()
	{
		driver.quit();
	}
}
