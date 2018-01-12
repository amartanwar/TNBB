package scenarios;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import testDataProvider_Repository.Scenario3;
import testscripts.AssetModule_GenericMethods;
import testscripts.AssetValueAndCostAssignement_GenericMethods;
import testscripts.LeaseModule_GenericMethods;
import testscripts.ReceiptPostingModule_GenericMethods;
import testscripts.UpdateModules_GenericMethod;

public class ArrearsLease__ReceiptPosting_ByInvoiceEndToEndTest extends BaseTest
{
	@Test(dataProvider="scenario3_Testdata",dataProviderClass=Scenario3.class)
	public void testingArrearsLeaseEndToEnd(String un, String type, String usageCondition,String accountNumber,String factorcategory,String contractNumber,String divNumber,
            String subDivNumber, String locationCode, String company, String department, String cost,
			String lease_un,String lease_accountNumber, String leaseBillingType, String leaseFrequency, String leaseTerm, String leaseRental,
			String LT_leaseSequenceNumber, String IncomeUpdate_leaseSequenceNumber, String InvoiceDate_leaseSequenceNumber, String sales_leaseSequenceNumber,
			String invoiceGeneration_leaseSequenceNumber, String receiptbyinvoice_leaseSeqNumber) throws IOException, InterruptedException, AWTException
	{
		test=reports.createTest("testingArrearsLeaseEndToEnd","This test will demonstrate the E2E scenario right form asset creation till receipt posting by invoice");
		AssetModule_GenericMethods as= new AssetModule_GenericMethods();
		as.createAsset(driver, un, type, usageCondition, accountNumber, factorcategory, contractNumber, divNumber, subDivNumber, locationCode, company, department);
		test.log(Status.PASS, "Asset Creation method ran successfully");
		
		AssetValueAndCostAssignement_GenericMethods av= new AssetValueAndCostAssignement_GenericMethods();
		av.assetValueAssignement(driver, cost);
		test.log(Status.PASS, "Asset value method ran successfully");
		
		LeaseModule_GenericMethods lc= new LeaseModule_GenericMethods();
		lc.createLease(driver, lease_un, lease_accountNumber, leaseBillingType, leaseFrequency, leaseTerm, leaseRental);
		test.log(Status.PASS, "Lease Creation method ran successfully");
		
		UpdateModules_GenericMethod ls= new UpdateModules_GenericMethod();
		ls.runLeaseLTtoSTUpdate(driver, LT_leaseSequenceNumber);
		test.log(Status.PASS, "LTtoSt update method ran successfully");
		
		ls.runLeaseIncomeUpdate(driver, IncomeUpdate_leaseSequenceNumber);
		test.log(Status.PASS, "Lease Income method ran successfully");

		ls.runInvoiceDateUpdate(driver, InvoiceDate_leaseSequenceNumber);
		test.log(Status.PASS, "Invoice Date method ran successfully");
		

		ls.runSalesTaxUpdate(driver, sales_leaseSequenceNumber);
		test.log(Status.PASS, "Sales tax update method ran successfully");
		
		ls.runInvoiceGeneration(driver, invoiceGeneration_leaseSequenceNumber);
		test.log(Status.PASS, "Invoice generation method ran successfully");
		
		ReceiptPostingModule_GenericMethods rp= new ReceiptPostingModule_GenericMethods();
		rp.ReceiptPostingByInvoice(driver, receiptbyinvoice_leaseSeqNumber);
		test.log(Status.PASS, "Receipt Posting by invoice method ran successfully");
		
	}
}
