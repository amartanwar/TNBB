package testscripts.InvoiceGeneration;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import pom.InvoiceGenerationPage;
import pom.UpdatesMenuPage;
import pom.jobListPage;

public class InvoiceGenerationMethod 
{
	public void runInvoiceGeneration(WebDriver driver, String invoiceGeneration_leaseSequenceNumber) throws AWTException, InterruptedException
	{
       
		//opening Lease Income recoginition screen
//		LeaseWaveHeader lw =new LeaseWaveHeader(driver);
//		lw.clickOnPortFolioManagement();
		UpdatesMenuPage um=new UpdatesMenuPage(driver);
		um.openInvoiceGenerationPage();
		
		//Selecting lease filter
		InvoiceGenerationPage le= new InvoiceGenerationPage(driver);
		le.clickOnLeaseFilter();
		
		//selecting lease Sequence Number radio button
		le.selectleaseSequenceNumber();
		
		//Entering Lease Sequence Number
		le.enterleaseSequenceNumber(invoiceGeneration_leaseSequenceNumber);
		
		//Entering update Through Date
		le.enterupdateThroughDate("7/15/2018");
		
		//Select receivable type
		le.selectReveivableRollupType();
		//Selecting run immediately
		le.clickOnrunImmediatelyr();
		
		//Clicking on Run Update
		le.clickOnrunUpdate();
		
		//Clicking on JobId
		le.clickOnJobId();
		
		//Validation job status
		jobListPage jl= new jobListPage(driver);
		jl.validateJobStatus();
		
		Reporter.log("InvoiceGeneration method ran successfully", true);
	}
}
