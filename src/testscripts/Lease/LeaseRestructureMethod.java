package testscripts.Lease;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import pom.LeaseAccrualPage;
import pom.LeaseClassificationPage;
import pom.LeaseEntryHomePage;
import pom.LeaseListPage;
import pom.LeaseMenuPage;
import pom.LeaseRestructurePage;
import pom.RestructureDatePage;

public class LeaseRestructureMethod 
{
	public void LeaseRestructure(WebDriver driver,String restructure_un) throws InterruptedException, IOException, AWTException
	{
		
		//open lease structure screen
		LeaseMenuPage lm= new LeaseMenuPage(driver);
		lm.openLeaseStructurePage();
		
		//select a lease
		Thread.sleep(2000);
		LeaseListPage lp=new LeaseListPage(driver);
		lp.searchByUnitNumber2(restructure_un);
		lp.clickOnSearchButton();
		lp.clickONSelectButton();
		
		//enter lease restructure date
		RestructureDatePage rp= new RestructureDatePage(driver);
		rp.enterRebookDate("10/31/2017");
		rp.clickOnSaveButton();
		
		//Open Lease Restructure screen
		LeaseEntryHomePage le=new LeaseEntryHomePage(driver);
		le.clickOnRestructureScreen();
		
		//select restructure gl template
		LeaseRestructurePage lr=new LeaseRestructurePage(driver);
		lr.selectGLTemplate();
		lr.clickOnSaveButton();
		
		//90 percent test
		le.clickOnLeaseClassificationScreen();
		LeaseClassificationPage lc= new LeaseClassificationPage(driver);
		lc.clickOnPerform90PercentTestButton();
		lc.clickOnSaveButton();
		
		//compute yield
		le.clickOnLeaseAccrualScreen();
		LeaseAccrualPage la= new LeaseAccrualPage(driver);
		la.clickOnComputeYieldButton();
		la.clickOnSaveButton();
		la.handlePopup();
		
		//select Lease Status
		le.selectLeaseBookingStatus();
		le.clickOnSaveButton();
		
		//Handle alert
		le.handlePopup1();
		
		//Validate lease restructure 
		le.verfyTittle("Lease List", "Lease Restructure failed");
		
		Reporter.log("LeaseRestructure method ran successfully", true);
		
	}
}
