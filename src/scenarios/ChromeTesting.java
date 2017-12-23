package scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import generic.AutoConst;

public class ChromeTesting implements AutoConst
{

	public static void main(String[] args) 
	{
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.resizeTo(50, 50)");
		driver.get("http://www.google.com");
	}

}
