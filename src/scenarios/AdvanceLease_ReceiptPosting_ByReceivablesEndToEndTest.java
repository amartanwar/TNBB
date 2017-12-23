package scenarios;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import TestDataProvider.Scenario1;
import generic.BaseTest;
import testscripts.Asset.AssetCreationMethod;
import testscripts.AssetCostAndValueAssignment.AssetStatusAndValueChangeMethod;
import testscripts.InvoiceDateUpdate.InvoiceDateUpdateMethod;
import testscripts.InvoiceGeneration.InvoiceGenerationMethod;
import testscripts.LTtoSTUpdate.LeaseLTtoSTUpdateMethod;
import testscripts.Lease.LeaseCreationMethod;
import testscripts.LeaseIncomeUpdate.LeaseIncomeUpdateMethod;
import testscripts.ReceiptPosting.ReceiptPostingByReceivablesMethod;
import testscripts.SalesTaxUpdate.SalesTaxUpdateMethod;

public class AdvanceLease_ReceiptPosting_ByReceivablesEndToEndTest extends BaseTest
{
	@Test(dataProvider="scenario1_Testdata",dataProviderClass=Scenario1.class)
	public void testingAdvanceLeaseEndToEnd(String un, String type, String usageCondition,String accountNumber,String factorcategory,String contractNumber,String divNumber,
			String subDivNumber, String locationCode, String company, String department, String cost,
			String lease_un, String lease_accountNumber, String leaseBillingType, String leaseFrequency, String leaseTerm, String leaseRental,
			String LT_leaseSequenceNumber, String IncomeUpdate_leaseSequenceNumber, String InvoiceDate_leaseSequenceNumber, String sales_leaseSequenceNumber,
			String invoiceGeneration_leaseSequenceNumber, String receiptbyreceivable_leaseSeqNumber) throws IOException, InterruptedException, AWTException
	{
		
		test=reports.createTest("testingAdvanceLeaseEndToEnd","This test will demonstrate the E2E scenario right form asset creation till receipt posting by receivables");
		AssetCreationMethod as = new AssetCreationMethod();
		as.createAsset(driver, un, type, usageCondition, accountNumber, factorcategory, contractNumber, divNumber, subDivNumber, locationCode, company, department);
		test.log(Status.PASS, "Asset Creation method ran successfully");
		
		
		AssetStatusAndValueChangeMethod av= new AssetStatusAndValueChangeMethod();
		av.assetValueAssignement(driver, cost);
		test.log(Status.PASS, "Asset value method ran successfully");
		
		LeaseCreationMethod lc= new LeaseCreationMethod();
		lc.createLease(driver, lease_accountNumber,lease_un, leaseBillingType, leaseFrequency, leaseTerm, leaseRental);
		test.log(Status.PASS, "Lease Creation method ran successfully");
		
		LeaseLTtoSTUpdateMethod ls= new LeaseLTtoSTUpdateMethod();
		ls.runLeaseLTtoSTUpdate(driver, LT_leaseSequenceNumber);
		test.log(Status.PASS, "LTtoSt update method ran successfully");
		
		LeaseIncomeUpdateMethod li= new LeaseIncomeUpdateMethod();
		li.runLeaseIncomeUpdate(driver, IncomeUpdate_leaseSequenceNumber);
		test.log(Status.PASS, "Lease Income method ran successfully");
		
		InvoiceDateUpdateMethod id= new InvoiceDateUpdateMethod();
		id.runInvoiceDateUpdate(driver, InvoiceDate_leaseSequenceNumber);
		test.log(Status.PASS, "Invoice Date method ran successfully");
		
		SalesTaxUpdateMethod su= new SalesTaxUpdateMethod();
		su.runSalesTaxUpdate(driver, sales_leaseSequenceNumber);
		test.log(Status.PASS, "Sales tax update method ran successfully");
		
		InvoiceGenerationMethod ig= new InvoiceGenerationMethod();
		ig.runInvoiceGeneration(driver, invoiceGeneration_leaseSequenceNumber);
		test.log(Status.PASS, "Invoice generation method ran successfully");
		
		ReceiptPostingByReceivablesMethod rp=new ReceiptPostingByReceivablesMethod();
		rp.ReceiptPostingByReceivables(driver, receiptbyreceivable_leaseSeqNumber);
		test.log(Status.PASS, "Receipt Posting method ran successfully");
		
	}
}
