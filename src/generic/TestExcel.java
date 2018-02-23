
package generic;

import org.testng.annotations.Test;

import generic.excel;

public class TestExcel
	{
        @Test	
		public static  Object[][] objectGenerator(String xlName,String sheetName)
		{
			Object[][] data=null;
			int row=excel.getRowCount("./TestData/"+xlName+".xlsx",sheetName);
			int cell =excel.getCellCount("./TestData/"+xlName+".xlsx", sheetName,5);

			
			data= new Object[row-1][cell];
			
			for(int i=1;i<row;i++)
			{
				for(int j=0;j<cell;j++)
				{
					data[i-1][j]=excel.getCellValue("./TestData/"+xlName+".xlsx", sheetName, i, j);
				}
			}
			
			return data;
		}
}
