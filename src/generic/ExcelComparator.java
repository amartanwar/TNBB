package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class ExcelComparator
{
	public XSSFWorkbook workbook1;
	public XSSFWorkbook workbook2;
	public static CellStyle style;
	public  void compareTwoExcel(String expectedResultExcelName,String actualResultExcelName) throws IOException 
	{
		 // get input excel files
        FileInputStream expectedResult = new FileInputStream(new File( "./ExpectedResult/"+expectedResultExcelName+".xlsx"));
        FileInputStream actualResult = new FileInputStream(new File(  "./ActualResult/"+actualResultExcelName+".xlsx"));

        // Create Workbook instance holding reference to .xlsx file
         workbook1 = new XSSFWorkbook(expectedResult);
         workbook2 = new XSSFWorkbook(actualResult);
        
        //color
        
	    style = workbook2.createCellStyle();
	    style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	    Font font = workbook2.createFont();
        font.setColor(IndexedColors.RED.getIndex());
        style.setFont(font);

        // Get first/desired sheet from the workbook
        XSSFSheet sheet1 = workbook1.getSheetAt(0);
        XSSFSheet sheet2 = workbook2.getSheetAt(0);

        // Compare sheets
        if(compareTwoSheets(sheet1, sheet2)==true) 
        {
            System.out.println("\n\nThe two excel sheets are Equal");
        } 
        else 
        {
            System.out.println("\n\nThe two excel sheets are Not Equal");
            Assert.fail();
        }
        
        //close files
        workbook1.close();
        workbook2.close();
        expectedResult.close();
        actualResult.close();

    
	}

	public  boolean compareTwoSheets(XSSFSheet sheet1, XSSFSheet sheet2) 
	{
		boolean status=true;
		int numberofRows_Sheet1 = sheet1.getPhysicalNumberOfRows();
		int numberofRows_Sheet2 = sheet2.getPhysicalNumberOfRows();
		
		
		if (numberofRows_Sheet1==numberofRows_Sheet2)
		{
			int firstRow = sheet1.getFirstRowNum();
			int lastRow = sheet1.getLastRowNum();
			
			
			for (int i=firstRow+1;i<=lastRow;i++)
			{
				XSSFRow sheet1_row = sheet1.getRow(i);
				XSSFRow sheet2_row = sheet2.getRow(i);
				
				if(compareTwoRows(sheet1_row,sheet2_row)==false)
				{
					System.out.println("       Row "+i+" - is not Equal in both the sheets");
					status=false;
					break;
				}
				
				else
				{
					System.out.println("        Row "+i+" - is  Equal in both the sheets");
					
				}
			}
		}
		else
		{
			System.out.println("Number of rows mismatching in both the sheets");
			System.out.println("Expected number of rows "+numberofRows_Sheet1);
			System.out.println("Actual number of rows "+numberofRows_Sheet2);
			status=false;
		}
		return status;

	}

	private boolean compareTwoRows(XSSFRow sheet1_row, XSSFRow sheet2_row)
	{
		boolean status=true;
		int numberOfCells_Sheet1 = sheet1_row.getPhysicalNumberOfCells();
		int numberOfCells_Sheet2 = sheet2_row.getPhysicalNumberOfCells();
//		
//		if(numberOfCells_Sheet1 != numberOfCells_Sheet2)
//		{
//			System.out.println("Number of cells mismatching in both the sheets");
//			System.out.println("Expected number of cells "+numberOfCells_Sheet1);
//			System.out.println("Actual number of cells "+numberOfCells_Sheet2);
//			
//			status=false;
//		}
		
		
		if(numberOfCells_Sheet1 == numberOfCells_Sheet2) 
		{
			int  firstcell = sheet1_row.getFirstCellNum();
			int lastcell = sheet2_row.getLastCellNum();
			
			
			
			for (int i=firstcell;i<lastcell;i++)
			{
				 XSSFCell sheet1_cell = sheet1_row.getCell(i);
				 XSSFCell sheet2_cell = sheet2_row.getCell(i);
				
				if(compareTwoCells(sheet1_cell,sheet2_cell)==false)
				{
				
					sheet2_cell.setCellStyle(style);
					System.out.println("cell "+i+" - is not Equal in both the sheets");
					status=false;
					break;
					
				}
				
				else
				{
//					System.out.println("cell "+i+" - is  Equal in both the sheets");
				}
			}
			
			
		}
		return status;
	}

	private boolean compareTwoCells(XSSFCell sheet1_cell, XSSFCell sheet2_cell)
	{
		boolean status=true;
		 String sheet1_value=getCellvalue(sheet1_cell);
		 String sheet2_value=getCellvalue(sheet2_cell);
		 
		 if (sheet1_value.equals(sheet2_value)==false) 
		 {
			 System.out.println("Expected value= "+sheet1_value);
			 System.out.println("Actual value= "+sheet2_value);
			 status= false;
		 }
		 
		 else 
		 {
			 
		 }
		return status;
	}

	private String getCellvalue(XSSFCell sheet1_cell)
	{
		String value=null;
		try
		{
			value =sheet1_cell.getStringCellValue();
			
		}
		catch(Exception e)
		{
			try
			{
				value = String.valueOf((int)sheet1_cell.getNumericCellValue());
			}
			

			catch(Exception e1)
			{
				System.out.println("No record found at given cell");
			}
		}
		
		return value;
	}
	
}


