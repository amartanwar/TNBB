package generic;

import java.io.File;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excel
{

	public static String getCellValue (String path,String sheetName,int rowNum, int cellNum) 
	{
		Workbook wb = null;
		Sheet s=null;
		String value = null;
		try
		{
			File f = new File(path);
			 wb=WorkbookFactory.create(f);
			
		}
		catch (Exception e)
		{
			System.out.println("Excel sheet file not found at given path");
		}
		try
		{
			 s= wb.getSheet(sheetName);
		}
		catch(Exception e)
		{
			System.out.println("Given sheet not found or sheet name is incorrect");
		}
		
		
			Row r= s.getRow(rowNum);
			Cell c=r.getCell(cellNum);
			 
		try
		{
			value =c.getStringCellValue();
			
			
		}
		catch(Exception e)
		{
			try
			{
				value = String.valueOf((int)c.getNumericCellValue());
			}
			

			catch(Exception e1)
			{
				System.out.println("No record found at given cell");
			}
		}
		
		
	
		return value;
	}
	

	public static String getNumericCellValue (String path,String sheetName,int rowNum, int cellNum) 
	{
		Workbook wb = null;
		Sheet s=null;
		String value=null;
		try
		{
			File f = new File(path);
			 wb=WorkbookFactory.create(f);
			
		}
		catch (Exception e)
		{
			System.out.println("Xl file not found at given path");
		}
		try
		{
			 s= wb.getSheet(sheetName);
		}
		catch(Exception e)
		{
			System.out.println("Given sheet not found or sheet name is incorrect");
		}
		
		
			Row r= s.getRow(rowNum);
			 Cell c = r.getCell(cellNum);
			 
		try
		{
			value=String.valueOf((int)c.getNumericCellValue());
			
		}
		catch(Exception e)
		{
			System.out.println("No record found at given cell");
		}
		
		
	
		return value;
		
	
	}
	
	public static int getRowCount (String path,String sheetName) 
	{
		Workbook wb = null;
		Sheet s=null;
		try
		{
			File f = new File(path);
			 wb=WorkbookFactory.create(f);
			
		}
		catch (Exception e)
		{
			System.out.println("Xl file not found at given path");
		}
		try
		{
			 s= wb.getSheet(sheetName);
		}
		catch(Exception e)
		{
			System.out.println("Given sheet not found or sheet name is incorrect");
		}
		
		
		int value1=s.getPhysicalNumberOfRows();
			
		return value1;
	}
	
	public static int getCellCount (String path,String sheetName) 
	{
		Workbook wb = null;
		Sheet s=null;
		try
		{
			File f = new File(path);
			 wb=WorkbookFactory.create(f);
			
		}
		catch (Exception e)
		{
			System.out.println("Xl file not found at given path");
		}
		try
		{
			 s= wb.getSheet(sheetName);
		}
		catch(Exception e)
		{
			System.out.println("Given sheet not found or sheet name is incorrect");
		}
		
		
		Row row = s.getRow(0);
		int cellCount = row.getPhysicalNumberOfCells();
		
			
		return cellCount;
	}
}
	

	