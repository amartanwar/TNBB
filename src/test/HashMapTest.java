package test;

import java.util.HashMap;
import java.util.Map;

import generic.Excel;

public class HashMapTest {

	public static  Object[][] objectGenerator(String xlName,String sheetName)
    {
                    Object[][] data=null;
                    int row=Excel.getRowCount("./TestData/"+xlName+".xlsx",sheetName);
                    int numberofSheets= Excel.getNumberOfSheets("./TestData/"+xlName+".xlsx");
                    Map<Object, Object> datamap = new HashMap<>();
                    
                    
                    data= new Object[row-2][1];
                                                                                                                    
                                                                                                                    
                 
                    for(int i=2;i<=row-2;i++)
                    {
                           for(int j=0;j<numberofSheets;j++)
                                {
                                     sheetName=Excel.getSheetName("./TestData/"+xlName+".xlsx", j);
                                     int cell =Excel.getCellCount("./TestData/"+xlName+".xlsx", sheetName, j);
                                  
                                     for(int k=0;k<cell;k++)
                                     {
                                     datamap.put(Excel.getCellValue("./TestData/"+xlName+".xlsx", sheetName, 1, k), Excel.getCellValue("./TestData/"+xlName+".xlsx", sheetName, i, k));
                                     }
                                }
                                                                                                                                                    
                          data[i][0] = datamap;
                    }
                    
                    return data;
    }


}
