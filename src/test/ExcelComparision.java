package test;

import java.io.IOException;

import generic.ExcelComparator;

public class ExcelComparision {

	public static void main(String[] args) throws IOException
	{
		ExcelComparator ex= new ExcelComparator();
		ex.compareTwoExcel( "Scenario1","Scenario1_DBVerification1");
		

	}

}
