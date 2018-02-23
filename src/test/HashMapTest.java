package test;

import java.util.HashMap;
import java.util.Map;

import generic.excel;

public class HashMapTest {

	public static  Object[][] objectGenerator(String xlName,String sheetName)
    {
                    Object[][] data=null;
                    int row=excel.getRowCount("./TestData/"+xlName+".xlsx",sheetName);
                    int numberofSheets= excel.getNumberOfSheets("./TestData/"+xlName+".xlsx");
                    Map<Object, Object> datamap = new HashMap<>();
                    
                    
                    data= new Object[row-2][1];
                                                                                                                    
                                                                                                                    
                 
                    for(int i=2;i<=row-2;i++)
                    {
                           for(int j=0;j<numberofSheets;j++)
                                {
                                     sheetName=excel.getSheetName("./TestData/"+xlName+".xlsx", j);
                                     int cell =excel.getCellCount("./TestData/"+xlName+".xlsx", sheetName, j);
                                  
                                     for(int k=0;k<cell;k++)
                                     {
                                     datamap.put(excel.getCellValue("./TestData/"+xlName+".xlsx", sheetName, 1, k), excel.getCellValue("./TestData/"+xlName+".xlsx", sheetName, i, k));
                                     }
                                }
                                                                                                                                                    
                          data[i][0] = datamap;
                    }
                    
                    return data;
    }


}
