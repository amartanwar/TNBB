package testscripts.SalesTaxUpdate;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import pom.SalesTaxUpdatePage;
import pom.UpdatesMenuPage;
import pom.jobListPage;

public class SalesTaxUpdateMethod 
{
	public void runSalesTaxUpdate(WebDriver driver,String sales_leaseSequenceNumber) throws AWTException, InterruptedException
	{
		
		//opening Lease Income recoginition screen
//		LeaseWaveHeader lw =new LeaseWaveHeader(driver);
//		lw.clickOnPortFolioManagement();
		UpdatesMenuPage um=new UpdatesMenuPage(driver);
		um.openSalesTaxUpdatePage();
		
		//Selecting lease filter
		SalesTaxUpdatePage le= new SalesTaxUpdatePage(driver);
		le.clickOnLeaseFilter();
		
		//selecting lease Sequence Number radio button
		le.selectleaseSequenceNumber();
		
		//Entering Lease Sequence Number
		le.enterleaseSequenceNumber(sales_leaseSequenceNumber);
		
		//Entering update Through Date
		le.enterupdateThroughDate("7/15/2018");
		
		//Selecting run immediately
		le.clickOnrunImmediatelyr();
		
		//Clicking on Run Update
		le.clickOnrunUpdate();
		
		//Clicking on JobId
		le.clickOnJobId();
		
		//Validation job status
		jobListPage jl= new jobListPage(driver);
		jl.validateJobStatus();
		
		Reporter.log("SalesTaxUpdate method ran successfully", true);
	}
}
