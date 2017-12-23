package generic;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public abstract class BasePage implements AutoConst {
	public WebDriver driver;
	
	public BasePage(WebDriver driver)
	{	
		
		this.driver=driver;
	}
	public void verfyTittle(String eTitle,String msg) throws IOException, InterruptedException
	{
		WebDriverWait wait= new WebDriverWait(driver,60);
		
		try
		{
			wait.until(ExpectedConditions.titleIs(eTitle));
//			Reporter.log("Pass:Title is Matching",true);
		}
		catch(Exception e)
		{
			Reporter.log(msg,true);
			org.testng.Assert.fail();
		}
	}
}
