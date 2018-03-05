package generic;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pom.LoginPage;
import pom.jobListPage;

public abstract class BaseTest implements AutoConst 
{
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports reports;
	public static ExtentTest test;
	public static String snap;
	
	
	// Runs before the suites runs and sets up the Reporting Functionality
	@BeforeSuite
	public void settingUpReport()
	{
		htmlReporter= new ExtentHtmlReporter("./Reports/RegressionTestReport_1"+".html");
		reports= new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		reports.setSystemInfo("Opereating System", "Windows7");
		reports.setSystemInfo("Environment", "QA");
		reports.setSystemInfo("Host Name", "Nirush");
		reports.setSystemInfo("User", "Nirush S");
		
		htmlReporter.config().setDocumentTitle("LeaseWaveAutomationReport");
		htmlReporter.config().setReportName("BBNT FASB");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	
	// Runs before every method
	// Logins to the application
	@BeforeMethod
	public void openApplication() throws InterruptedException
	{
		//Open the browser
		System.setProperty(IE_KEY,IE_VALUE);
		driver=new InternetExplorerDriver();
	
		//Opening the application
		driver.get("http://otbperftest:155/");
        driver.manage().window().maximize(); 
        
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage lp=new LoginPage(driver,test);
		String currentWindow= driver.getWindowHandle();
		lp.rideTheLeaseWave();
		driver.close();
		
		SwitchControlToNextWindow sw= new SwitchControlToNextWindow();
		sw.waitForWndows(driver, currentWindow);
		
		WebDriverWait wait= new WebDriverWait(driver, 56);
		wait.until(ExpectedConditions.visibilityOf(lp.userName));
		lp.setuserName("amar.t");
		lp.setPassword("Samsung-1234");
		lp.clickOnLogin();
		lp.handleAlert();
		
	}
	
	
	//Runs after every method
	//Closes the LeaseWave application
	@AfterMethod
	public void closeApplication(ITestResult result) throws IOException, InterruptedException
	{
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String name= result.getName();
			String screenshotpath = ScreenShot.takeScreenshot(driver, SNAP_PATH+name);
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" failed becuase of below issue", ExtentColor.RED));
			test.fail(result.getThrowable());
//			test.fail("SnapShot Below:").addScreenCaptureFromPath(screenshotpath);
			test.fail("SnapShot Below:", MediaEntityBuilder.createScreenCaptureFromPath(Paths.get("").toAbsolutePath().toString() + screenshotpath).build());
			driver.quit();
			
			try
			{
				jobListPage jl= new jobListPage(driver,test);
				snap=jl.clickOnLogDetails();
				test.fail("LogDetails Below").addScreenCaptureFromPath(snap);
				driver.quit();
				
			}
			catch (Exception e) 
			{
				
			}
				
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" is pass ", ExtentColor.GREEN));
			driver.quit();
		}
		
		else
		{
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" is skipped because of below issue ", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
			driver.quit();
		}
		
		
	}
	
	
	//Runs after the suite
	@AfterSuite
	public void tearDown()
	{
		reports.flush();
	}
	

}
