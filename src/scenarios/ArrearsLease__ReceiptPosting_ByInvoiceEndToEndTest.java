package scenarios;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import generic.BaseTest;
import testscripts.Asset.AssetCreationMethod;
import testscripts.AssetCostAndValueAssignment.AssetStatusAndValueChangeMethod;
import testscripts.InvoiceDateUpdate.InvoiceDateUpdateMethod;
import testscripts.InvoiceGeneration.InvoiceGenerationMethod;
import testscripts.LTtoSTUpdate.LeaseLTtoSTUpdateMethod;
import testscripts.Lease.LeaseCreationMethod;
import testscripts.LeaseIncomeUpdate.LeaseIncomeUpdateMethod;
import testscripts.ReceiptPosting.ReceiptPostingByInvoiceMethod;
import testscripts.SalesTaxUpdate.SalesTaxUpdateMethod;

public class ArrearsLease__ReceiptPosting_ByInvoiceEndToEndTest extends BaseTest
{
	@Test(groups="E2E Test")
	public void testingArrearsLeaseEndToEnd() throws IOException, InterruptedException, AWTException
	{
		test=reports.createTest("testingArrearsLeaseEndToEnd","This test will demonstrate the E2E scenario right form asset creation till receipt posting by invoice");
		AssetCreationMethod as = new AssetCreationMethod();
		as.createAsset(driver, 2);
		System.out.println("Test Case One with Thread Id:- "
				+ Thread.currentThread().getId());

		
		AssetStatusAndValueChangeMethod av= new AssetStatusAndValueChangeMethod();
		av.assetValueAssignement(driver, 2);
		
		LeaseCreationMethod lc= new LeaseCreationMethod();
		lc.createLease(driver, 2);
		
		LeaseLTtoSTUpdateMethod ls= new LeaseLTtoSTUpdateMethod();
		ls.runLeaseLTtoSTUpdate(driver, 2);
		
		LeaseIncomeUpdateMethod li= new LeaseIncomeUpdateMethod();
		li.runLeaseIncomeUpdate(driver, 2);
		
		InvoiceDateUpdateMethod id= new InvoiceDateUpdateMethod();
		id.runInvoiceDateUpdate(driver, 2);
		
		SalesTaxUpdateMethod su= new SalesTaxUpdateMethod();
		su.runSalesTaxUpdate(driver, 2);
		
		InvoiceGenerationMethod ig= new InvoiceGenerationMethod();
		ig.runInvoiceGeneration(driver, 2);
		
		ReceiptPostingByInvoiceMethod rp= new ReceiptPostingByInvoiceMethod();
		rp.ReceiptPostingByInvoice(driver, 2);
		
	}
}
