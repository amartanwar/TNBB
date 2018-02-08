package generic;

public class DataProviderGenerator
{
	public static  Object[][] objectGenerator(String xlName,String sheetName)
	{
		Object[][] data=null;
		int row=excel.getRowCount("./TestData/"+xlName+".xlsx",sheetName);
		int cell =excel.getCellCount("./TestData/"+xlName+".xlsx", sheetName);
		
		
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
	
	
	public static Object[][] objectMerger(Object[][] data1, Object[][] data2)
	{
		int length=0;		
		Object[][] data5 = new Object[1][data2[0].length+data1[0].length];
		
			for(int j=0;j<data1[0].length;j++)
			{
				data5[0][length]=data1[0][j];
				length++;
			}
			
			for(int j=0;j<data2[0].length;j++)
			{
				data5[0][length]=data2[0][j];
				length++;
			}
		return data5;
		
	}
	
	public static Object[][] objectMerger(Object[][] data1, Object[][] data2, Object[][] data3)
	{
		int length=0;		
		Object[][] mergedData = new Object[1][data2[0].length+data1[0].length+data3[0].length];
		
			for(int j=0;j<data1[0].length;j++)
			{
				mergedData[0][length]=data1[0][j];
				length++;
			}
			
			for(int j=0;j<data2[0].length;j++)
			{
				mergedData[0][length]=data2[0][j];
				length++;
			}
			
			for(int j=0;j<data3[0].length;j++)
			{
				mergedData[0][length]=data3[0][j];
				length++;
			}
		return mergedData;
		
	}
	
	public static Object[][] objectMerger(Object[][] data1, Object[][] data2, Object[][] data3, Object[][] data4)
	{
		int length=0;		
		Object[][] mergedData = new Object[1][data2[0].length+data1[0].length+data3[0].length+data4[0].length];
		
			for(int j=0;j<data1[0].length;j++)
			{
				mergedData[0][length]=data1[0][j];
				length++;
			}
			
			for(int j=0;j<data2[0].length;j++)
			{
				mergedData[0][length]=data2[0][j];
				length++;
			}
			
			for(int j=0;j<data3[0].length;j++)
			{
				mergedData[0][length]=data3[0][j];
				length++;
			}
			
			for(int j=0;j<data4[0].length;j++)
			{
				mergedData[0][length]=data4[0][j];
				length++;
			}
		return mergedData;
		
	}
	
	public static Object[][] objectMerger(Object[][] data1, Object[][] data2, Object[][] data3, Object[][] data4, Object[][] data5)
	{
		int length=0;		
		Object[][] mergedData = new Object[1][data2[0].length+data1[0].length+data3[0].length+data4[0].length+ data5[0].length];
		
			for(int j=0;j<data1[0].length;j++)
			{
				mergedData[0][length]=data1[0][j];
				length++;
			}
			
			for(int j=0;j<data2[0].length;j++)
			{
				mergedData[0][length]=data2[0][j];
				length++;
			}
			
			for(int j=0;j<data3[0].length;j++)
			{
				mergedData[0][length]=data3[0][j];
				length++;
			}
			
			for(int j=0;j<data4[0].length;j++)
			{
				mergedData[0][length]=data4[0][j];
				length++;
			}
			
			for(int j=0;j<data5[0].length;j++)
			{
				mergedData[0][length]=data5[0][j];
				length++;
			}
		return mergedData;
		
	}
	
	public static Object[][] objectMerger(Object[][] data1, Object[][] data2, Object[][] data3, Object[][] data4, Object[][] data5,Object[][] data6,Object[][] data7,Object[][] data8,Object[][] data9)
	{
		int length=0;		
		Object[][] mergedData = new Object[1][data2[0].length+data1[0].length+data3[0].length+data4[0].length+ data5[0].length+data6[0].length+data7[0].length+data8[0].length+data9[0].length];
		
			for(int j=0;j<data1[0].length;j++)
			{
				mergedData[0][length]=data1[0][j];
				length++;
			}
			
			for(int j=0;j<data2[0].length;j++)
			{
				mergedData[0][length]=data2[0][j];
				length++;
			}
			
			for(int j=0;j<data3[0].length;j++)
			{
				mergedData[0][length]=data3[0][j];
				length++;
			}
			
			for(int j=0;j<data4[0].length;j++)
			{
				mergedData[0][length]=data4[0][j];
				length++;
			}
			
			for(int j=0;j<data5[0].length;j++)
			{
				mergedData[0][length]=data5[0][j];
				length++;
			}
			
			for(int j=0;j<data6[0].length;j++)
			{
				mergedData[0][length]=data6[0][j];
				length++;
			}
			
			for(int j=0;j<data7[0].length;j++)
			{
				mergedData[0][length]=data7[0][j];
				length++;
			}
			
			for(int j=0;j<data8[0].length;j++)
			{
				mergedData[0][length]=data8[0][j];
				length++;
			}
			
			for(int j=0;j<data9[0].length;j++)
			{
				mergedData[0][length]=data9[0][j];
				length++;
			}
		return mergedData;
		
	}
	
	public static Object[][] objectMerger(Object[][] data1, Object[][] data2, Object[][] data3, Object[][] data4, Object[][] data5,Object[][] data6)
	{
		int length=0;		
		Object[][] mergedData = new Object[1][data2[0].length+data1[0].length+data3[0].length+data4[0].length+ data5[0].length+data6[0].length];
		
			for(int j=0;j<data1[0].length;j++)
			{
				mergedData[0][length]=data1[0][j];
				length++;
			}
			
			for(int j=0;j<data2[0].length;j++)
			{
				mergedData[0][length]=data2[0][j];
				length++;
			}
			
			for(int j=0;j<data3[0].length;j++)
			{
				mergedData[0][length]=data3[0][j];
				length++;
			}
			
			for(int j=0;j<data4[0].length;j++)
			{
				mergedData[0][length]=data4[0][j];
				length++;
			}
			
			for(int j=0;j<data5[0].length;j++)
			{
				mergedData[0][length]=data5[0][j];
				length++;
			}
			
			for(int j=0;j<data6[0].length;j++)
			{
				mergedData[0][length]=data6[0][j];
				length++;
			}
		return mergedData;
		
	}
}

