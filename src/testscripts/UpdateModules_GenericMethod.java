package testscripts;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import pom.InvoiceDateUpdatePage;
import pom.InvoiceGenerationPage;
import pom.LeaseWaveHeader;
import pom.MovingLongTermtoShorTermUpdatePage;
import pom.SalesTaxUpdatePage;
import pom.UpdatesMenuPage;
import pom.jobListPage;
import pom.leaseIncomeRecognitionPage;

public class UpdateModules_GenericMethod
{
	public void runInvoiceDateUpdate(WebDriver driver, String InvoiceDate_leaseSequenceNumber) throws InterruptedException
	{
		
		//opening Lease Income recognition screen
//		LeaseWaveHeader lw =new LeaseWaveHeader(driver);
//		lw.clickOnPortFolioManagement();
		UpdatesMenuPage um=new UpdatesMenuPage(driver);
		um.openInvoiceDateUpdatePage();
		
		
		//Selecting lease filter
		InvoiceDateUpdatePage le= new InvoiceDateUpdatePage(driver);
		le.clickOnLeaseFilter();
		
		//selecting lease Sequence Number radio button
		le.selectleaseSequenceNumber();
		
		//Entering Lease Sequence Number
		le.enterleaseSequenceNumber(InvoiceDate_leaseSequenceNumber);
		
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
		
		Reporter.log("InvoiceDateUpdate method ran successfully", true);
	}
	
	public void runInvoiceGeneration(WebDriver driver, String invoiceGeneration_leaseSequenceNumber) throws AWTException, InterruptedException
	{
       
		//opening Lease Income recoginition screen
		LeaseWaveHeader lw =new LeaseWaveHeader(driver);
		lw.clickOnPortFolioManagement();
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
	
	public void runLeaseIncomeUpdate(WebDriver driver,String IncomeUpdate_leaseSequenceNumber) throws InterruptedException
	{
		
		//opening Lease Income recoginition screen
//		LeaseWaveHeader lw =new LeaseWaveHeader(driver);
//		lw.clickOnPortFolioManagement();
		UpdatesMenuPage um=new UpdatesMenuPage(driver);
		um.openLeaseIncomeRecognition();
		
		//Selecting lease filter
		leaseIncomeRecognitionPage le=new leaseIncomeRecognitionPage(driver);
		le.clickOnLeaseFilter();
		
		//selecting lease Sequence Number radio button
		le.selectleaseSequenceNumber();
		
		//Entering Lease Sequence Number
		le.enterleaseSequenceNumber(IncomeUpdate_leaseSequenceNumber);
		
		//Entering update Through Date
		le.enterupdateThroughDate("11/30/2020");
		
		//Selecting run immediately
		le.clickOnrunImmediatelyr();
		
		//Clicking on Run Update
		le.clickOnrunUpdate();
		
		//Clicking on JobId
		le.clickOnJobId();
		
		//Validation job status
		jobListPage jl= new jobListPage(driver);
		jl.validateJobStatus();
		
		Reporter.log("LeaseIncomeUpdate method ran successfully", true);
	}

	public void runLeaseLTtoSTUpdate(WebDriver driver,String LT_leaseSequenceNumber) throws InterruptedException
	{
		
		UpdatesMenuPage up=new UpdatesMenuPage(driver);
		up.openMovingLongTermToShortTerm();
		
		//selecting lease filter
		MovingLongTermtoShorTermUpdatePage ltr= new MovingLongTermtoShorTermUpdatePage(driver);
		ltr.clickOnLeaseFilter();
		
		//selecting Lease Sequence Number radio button
		ltr.selectleaseSequenceNumber();
	
		//Entering Lease Sequence Number
		ltr.enterleaseSequenceNumber(LT_leaseSequenceNumber);
		
		//Entering update Through Date
		ltr.enterupdateThroughDate("7/15/2018");
		
		//Selecting Immediate run
		ltr.clickOnrunImmediatelyr();
		
		//Clicking on run update button
		ltr.clickOnrunUpdate();
		
		//selecting jobId
		ltr.clickOnJobId();
		
		//Validating job status
		jobListPage jl=new jobListPage(driver);
			jl.validateJobStatus();
		
//		Reporter.log("LeaseLTtoSTUpdate method ran successfully", true);
	}
	
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
