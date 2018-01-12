package test;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test2 
{
	public  void fetchinDataFromDB (String sqlQuery,String xlName ) throws IOException, SQLException
	{
		try
		{
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://otbsqlserver;database=MAG_TotalViewQA;user=development;password=jk");
	         if (conn != null)
	         {
                System.out.println("Connected");
            }
	         Statement st = conn.createStatement();
	         ResultSet rs = st.executeQuery(sqlQuery);

	         
	        ResultSetMetaData data = rs.getMetaData();
	       
	       int columnsize = data.getColumnCount();
	      

	         @SuppressWarnings("resource")
	         XSSFWorkbook workbook1 = new XSSFWorkbook();
	         XSSFSheet sheet = workbook1.createSheet("Sheet1");
	         XSSFRow rowhead = sheet.createRow((short) 0);

	       
             
	         for(int i=1;i<=columnsize;i++)
	         {
	        	 int j=i-1;
	             rowhead.createCell((short) j).setCellValue(data.getColumnName(i));
	        	 
	         }
	        
	         int index=1;
	         while (rs.next())
	         {
	        	 XSSFRow row = sheet.createRow((short) index);
	        	 
	        	 for(int i=1;i<=columnsize;i++)
		         {
		        	 int j=i-1;
		        	 row.createCell((short) j).setCellValue(rs.getString(i));
		        	 
		         }
                
		         index++;
	         }
	         
	         String path = "./ActualResult/"+xlName+".xlsx";
		        FileOutputStream fileOut;
		  
		        try 
		        {
		        	 fileOut = new FileOutputStream(path);
		             workbook1.write(fileOut);
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
