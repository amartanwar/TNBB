package testscripts.LeaseIncomeUpdate;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import pom.UpdatesMenuPage;
import pom.jobListPage;
import pom.leaseIncomeRecognitionPage;

public class LeaseIncomeUpdateMethod 
{
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
}
