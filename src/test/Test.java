package test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import generic.AutoConst;

public class Test implements AutoConst
{
	public static void main (String [] args) throws InterruptedException, AWTException
	{
		System.setProperty(IE_KEY, IE_VALUE);
		WebDriver driver= new InternetExplorerDriver();
//		Robot rb= new Robot();
//		rb.keyPress(KeyEvent.VK_F11);
//		rb.keyRelease(KeyEvent.VK_F11);
		driver.get("https://www.carwale.com/");
	
		System.out.println(driver.getTitle());
		
		driver.close();
		
        
	}
}
