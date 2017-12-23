package generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pom.LoginPage;

public abstract class BaseTest implements AutoConst 
{
	public WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	@BeforeSuite
	public void settingUpReport()
	{
		htmlReporter= new ExtentHtmlReporter("D:\\reports\\first15.html");
		reports= new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		reports.setSystemInfo("Opereating System", "Windows7");
		reports.setSystemInfo("Environment", "QA");
		reports.setSystemInfo("Host Name", "Amar");
		reports.setSystemInfo("User", "Amar Singh Tanwar");
		
		htmlReporter.config().setDocumentTitle("LeaseWaveAutomationReport");
		htmlReporter.config().setReportName("ARI-M46_Release Regression Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	
	@BeforeMethod
	public void openApplication() throws InterruptedException
	{
		//Open the browser
		System.setProperty(IE_KEY,IE_VALUE);
		driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		
		//Fetching the data from xlsx
//		String url=excel.getCellValue("./TestData/Input.xlsx", "credentials", 1, 0);
//		String companyName=excel.getCellValue("./TestData/Input.xlsx", "credentials", 1, 1);
//		String userName=excel.getCellValue("./TestData/Input.xlsx", "credentials", 1, 2);
//		String password=excel.getCellValue("./TestData/Input.xlsx", "credentials", 1, 3);
	
		//Opening the application
		driver.get("http://otbapsrv:206");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage lp=new LoginPage(driver);
//		lp.setCompanyName("Merchants-tvqa");
		lp.rideTheLeaseWave();
		
		Thread.sleep(2000);
		for(String winHandle: driver.getWindowHandles())
		{
			driver.switchTo().window(winHandle);
		}
		
		WebDriverWait wait= new WebDriverWait(driver, 56);
		wait.until(ExpectedConditions.visibilityOf(lp.userName));
		lp.setuserName("aishwarya.v");
		lp.setPassword("Samsung-1234");
		lp.clickOnLogin();
	}
	
	
	
	@AfterMethod
	public void closeApplication(ITestResult result) throws IOException, InterruptedException
	{
//		//Taking the screenshot if testcase fails
//		String testName=result.getName();
//		int status=result.getStatus();
//		System.out.println(testName);
//		if(status==ITestResult.FAILURE)
//		{
//			ScreenShot.takeScreenshot(driver,SNAP_PATH+testName);
//			
//		}
//		//closing the browser
//		driver.quit();
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String name= result.getName();
			String screenshotpath = ScreenShot.takeScreenshot(driver, SNAP_PATH+name);
			System.out.println(screenshotpath);
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" failed becuase of below issue", ExtentColor.RED));
			test.fail(result.getThrowable());
			test.fail("SnapShot Below:").addScreenCaptureFromPath(screenshotpath);
			driver.close();
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" is pass ", ExtentColor.GREEN));
			driver.close();
		}
		
		else
		{
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" is skipped because of below issue ", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
			driver.close();
		}
		
		
	}
	@AfterSuite
	public void tearDown()
	{
		reports.flush();
		System.out.println("After suite running");
	}
	

}
