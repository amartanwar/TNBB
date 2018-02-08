package scenarios;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import generic.BaseTest;
import testDataProvider_Repository.LeaseDataProvider;
import testScripts.LeaseCreateScripts;
import testScripts.LeaseCreateScript_Advance;

public class LeaseTest  extends BaseTest
{

	@Test(dataProvider = "OperatingLease_A2_BI1_IDC1_Ar",dataProviderClass = LeaseDataProvider.class)
	public void OperatingLease_A2_BI1_IDC1_Test(String lease_accountNumber,String lease_sequenceNumber, 
			String leaseAlias, String leaseInvoiceGroup, String leaseInventoryAlias1,String leaseInventoryAlias2,String leaseNumberOfPayments,
			String leaseCommencementDate, String leaseRental,String leaseEconomicLife, String leaseBlendedName, String leaseBlendedAmount) throws AWTException, InterruptedException, IOException
	{
		test=reports.createTest("Arrear Lease","Arrear Lease Booking");
		LeaseCreateScripts lcs = new LeaseCreateScripts();
		lcs.operatingLease_A2_BI1_IDC1_Ar(driver, test, lease_accountNumber, lease_sequenceNumber, leaseAlias, leaseInvoiceGroup, leaseInventoryAlias1, leaseInventoryAlias2, leaseNumberOfPayments, leaseCommencementDate, leaseRental, leaseEconomicLife, leaseBlendedName, leaseBlendedAmount);
	}

	
	@Test(dataProvider = "OperatingLease_A2_BI1_IDC1_Ad", dataProviderClass = LeaseDataProvider.class)
	public void OperatingLease_A2_BI1_IDC1_Test(String lease_accountNumber,String lease_sequenceNumber, 
			String leaseAlias, String leaseInvoiceGroup, String leaseInventoryAlias1,String leaseInventoryAlias2,String leaseNumberOfPayments,String paymentsDueOnInception,
			String leaseCommencementDate, String leaseRental,String totalPaymentOnCommencement,String leaseEconomicLife, String leaseBlendedName, String leaseBlendedAmount) throws AWTException, InterruptedException, IOException
	{
		test=reports.createTest("Advance Lease","Advance Lease Booking");
		LeaseCreateScript_Advance lcs1 = new LeaseCreateScript_Advance();
		lcs1.operatingLease_A2_BI1_IDC1_Ad(driver, test, lease_accountNumber, lease_sequenceNumber, leaseAlias, leaseInvoiceGroup, leaseInventoryAlias1, leaseInventoryAlias2, leaseNumberOfPayments,paymentsDueOnInception, leaseCommencementDate, leaseRental,totalPaymentOnCommencement, leaseEconomicLife, leaseBlendedName, leaseBlendedAmount);

	}
	
	
}