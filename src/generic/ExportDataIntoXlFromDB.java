package generic;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class ExportDataIntoXlFromDB
{
	public static void main (String[] args)
	{
		try
		{
			
	         Connection conn = DriverManager.getConnection("jdbc:sqlserver://otbsqlserver;database=MAG_TotalViewQA;user=development;password=jk");
	         if (conn != null) {
                 System.out.println("Connected");
             }
	         Statement st = conn.createStatement();
	         ResultSet rs = st.executeQuery("Select * from lease_incomeschedule where leaseid=13310");

	        
	         @SuppressWarnings("resource")
			HSSFWorkbook  workbook = new HSSFWorkbook ();
	         HSSFSheet sheet = workbook.createSheet("LeaseProfile");
	         
	         //Creating Header into the xl
	         HSSFRow rowhead = sheet.createRow((short) 0);
             rowhead.createCell((short) 0).setCellValue("LeaseID");
             rowhead.createCell((short) 1).setCellValue("IncomeTerm");
             rowhead.createCell((short) 2).setCellValue("LeasePaymentAmount");
             rowhead.createCell((short) 3).setCellValue("LessorOperatingBeginNetBookValue");
             rowhead.createCell((short) 4).setCellValue("LessorOperatingEndNetBookValue");
             rowhead.createCell((short) 5).setCellValue("CustomerOperatingBeginNetBookValue");
             rowhead.createCell((short) 6).setCellValue("CustomerOperatingEndNetBookValue");
             rowhead.createCell((short) 7).setCellValue("LessorCapitalBeginNetBookValue");
             rowhead.createCell((short) 8).setCellValue("LessorCapitalEndNetBookValue");
             rowhead.createCell((short) 9).setCellValue("CustomerCapitalBeginNetBookValue");
             rowhead.createCell((short) 10).setCellValue("CustomerCapitalEndNetBookValue");
             rowhead.createCell((short) 11).setCellValue("PrimaryIncome");
             rowhead.createCell((short) 12).setCellValue("PrimaryIncomeBalance");
             
	         
             
	         //Fetching and storing data into xl row by row
	         int index=1;
	         while (rs.next())
	         {
	        	 HSSFRow row = sheet.createRow((short) index);
	        	 int LeaseID=  rs.getInt(2);
	        	 int IncomeTerm=rs.getInt(3);
	        	 double LeasePaymentAmount=  rs.getDouble(6);
		         double LessorOperatingBeginNetBookValue=  rs.getDouble(7);
		         double LessorOperatingEndNetBookValue=  rs.getDouble(8);
		         double CustomerOperatingBeginNetBookValue=  rs.getDouble(9);
		         double CustomerOperatingEndNetBookValue=  rs.getDouble(10);
		         double LessorCapitalBeginNetBookValue=  rs.getDouble(11);
		         double LessorCapitalEndNetBookValue=  rs.getDouble(12);
		         double CustomerCapitalBeginNetBookValue=  rs.getDouble(13);
		         double CustomerCapitalEndNetBookValue=  rs.getDouble(14);
		         double PrimaryIncome=  rs.getDouble(15);
		         double PrimaryIncomeBalance=  rs.getDouble(16);
		         
		        
		    
		         row.createCell((short)0).setCellValue(LeaseID);
		         row.createCell((short)1).setCellValue(IncomeTerm);
		         row.createCell((short)2).setCellValue(LeasePaymentAmount);
		         row.createCell((short)3).setCellValue(LessorOperatingBeginNetBookValue);
		         row.createCell((short)4).setCellValue(LessorOperatingEndNetBookValue);
		         row.createCell((short)5).setCellValue(CustomerOperatingBeginNetBookValue);
		         row.createCell((short)6).setCellValue(CustomerOperatingEndNetBookValue);
		         row.createCell((short)7).setCellValue(LessorCapitalBeginNetBookValue);
		         row.createCell((short)8).setCellValue(LessorCapitalEndNetBookValue);
		         row.createCell((short)9).setCellValue(CustomerCapitalBeginNetBookValue);
		         row.createCell((short)10).setCellValue(CustomerCapitalEndNetBookValue);
		         row.createCell((short)11).setCellValue(PrimaryIncome);
		         row.createCell((short)12).setCellValue(PrimaryIncomeBalance);
		         
		         index++;
	         }
	         
	         String path = "D:\\test\\LeaseProfileTest.xls";
	        FileOutputStream fileOut;
	  
	        try 
	        {
	        	 fileOut = new FileOutputStream(path);
	             workbook.write(fileOut);
	             fileOut.close();
	             System.out.println("File created successfully");
	        }
	        
	        catch(Exception e)
			{
	        	 System.out.println("Failed to create the file");
			}
	        
		}
		
		catch(Exception e)
		{
			 System.out.println("Failed to create the file");
		}
	        
	}
}


     
        