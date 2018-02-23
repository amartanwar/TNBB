package generic;

import java.util.HashMap;
import java.util.Map;

public class DataProviderGenerator
{

	
	public static  Object[][] objectGenerator(String xlName,String sheetName)
	{
		
		Object[][] data = null;
		int row=excel.getRowCount("./TestData/"+xlName+".xlsx",sheetName);
		int cell =excel.getCellCount("./TestData/"+xlName+".xlsx", sheetName,1);
		
		
		 data= new Object[row-2][1];
		
		for(int i=2;i<row;i++)
		{
			Map<String, String> datamap1  = new HashMap<>();
			
			for(int j=0;j<cell;j++)
			{
	
					datamap1.put(excel.getCellValue("./TestData/"+xlName+".xlsx", sheetName, 1, j).toString(),excel.getCellValue("./TestData/"+xlName+".xlsx", sheetName,i, j).toString());	
			}
			data [i-2][0]= datamap1 ;
		}
		
		return data;
	}

}

