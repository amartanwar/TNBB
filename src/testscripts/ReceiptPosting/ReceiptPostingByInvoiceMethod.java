package testscripts.ReceiptPosting;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import pom.InvoiceSearchPage;
import pom.ReceiptApplicationPage;
import pom.ReceiptListPage;
import pom.ReceiptSetupPage;
import pom.ReceivablesAndReceiptsMenuPage;

public class ReceiptPostingByInvoiceMethod 
{
	public void ReceiptPostingByInvoice(WebDriver driver,String receiptbyinvoice_leaseSeqNumber) throws InterruptedException, IOException
	{
		//Fetching data from xl
				
						
				//Opening the Receipt Setup page
				ReceivablesAndReceiptsMenuPage rr= new ReceivablesAndReceiptsMenuPage(driver);
				rr.openReceiptApplicationByInvoicePage();
				Thread.sleep(2000);
				
				//Adding the receipt
				ReceiptListPage rl= new ReceiptListPage(driver);
				rl.clickOnAddButton();
				
				//Receipt details entry
				ReceiptSetupPage rs= new ReceiptSetupPage(driver);
				
				//Enter accountNumber
				rs.enterAccountNumber("005162");
				
				//Enter receipt amount
				rs.enterReceiptAmount("5000");
				
				//Select Gl template
				rs.selectReceiptGLTemplate();
				
				//Enter check number
				rs.enterCheckNumber("check- "+receiptbyinvoice_leaseSeqNumber);
			
				//Save the receipt
				rs.clickOnSaveAndSelect();
				
				//Validate the receipt setup test
				rs.verfyTittle("Invoice Search", "Failed to create Receipt");
				
				//select lease sequenceNumber
				InvoiceSearchPage is= new InvoiceSearchPage(driver);
				
				//enter lease Sequence Number
				is.selectLeaseSequenceNumberRadioButton();
				is.enterLeaseSequenceNumber(receiptbyinvoice_leaseSeqNumber);
				
				//click on ApplyReceipt
				is.clickOnSaveAndApplyButton();
				
				//Validate the receipt posting ByInvoice
				rs.verfyTittle("RECEIPT APPLICATION - CASH", "Failed to open Receipt Application");
				
				//Select the invoice
				ReceiptApplicationPage ra= new ReceiptApplicationPage(driver);
				ra.selectInvoices();
				
				//click on distribute
				ra.clickOnDistribute();
				
				//post the receipt
				ra.clickOnPostButton();
				
				//validate receipt posting
				ra.verfyTittle("Receipt List - Cash", "Failed to apply the recipt");
				

				Reporter.log("ReceiptPostingbyInvoice method ran successfully", true);
	}
}
