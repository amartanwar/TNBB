package generic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataBaseVerification
{
	public  void fetchinDataFromDB (String sqlQuery,String xlName,String sheetName ) throws IOException, SQLException
	{
		try
		{
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://otbperftest;database=BBnT_FASB_Test;user=development;password=jk");
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
	         XSSFSheet sheet = workbook1.createSheet(sheetName);
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
	         
	         
	         CellStyle style = workbook1.createCellStyle();
	         style.setFillForegroundColor(IndexedColors.ROYAL_BLUE.getIndex());
	 	    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	 	    XSSFFont font = workbook1.createFont();
	         font.setColor(IndexedColors.WHITE.getIndex());
	         font.setBold(true);
	         style.setFont(font);
	         

	         
	         Row row = sheet.getRow(0);
	         Iterator<Cell> cellIterator = row.cellIterator();
	          while (cellIterator.hasNext()) 
	          {
	                Cell cell = cellIterator.next();
	                cell.setCellStyle(style);
	                int columnIndex = cell.getColumnIndex();
	                sheet.autoSizeColumn(columnIndex);
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
