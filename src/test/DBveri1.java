package test;

import org.testng.annotations.Test;

import generic.DataBaseVerification;
import generic.ExcelComparator;

public class DBveri1 
{
	@Test
	public void scenario1() throws Exception
	{
		System.out.println("main");
//		Assert.fail();
	}

	@Test(dependsOnMethods= {"scenario1"})
	public void scenario1_DBVerification() throws Exception
	{
		String sqlQuery ="select top 1 * from customer_profile order by 1 desc ";
		DataBaseVerification db = new DataBaseVerification();
		db.fetchinDataFromDB(sqlQuery, "scenario1_DBVerification","sheet1");
		
		
		
		ExcelComparator ex= new ExcelComparator();
		ex.compareTwoExcel("Scenario1", "scenario1_DBVerification");
	}
	
}
