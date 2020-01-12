package TestData;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	
	
	@Test(dataProvider="testData")
	public void test_1(String Username, String Password, String Result)
	{
		System.out.println(Username);
		System.out.println(Password);
		System.out.println(Result);
		
	}
	
	@DataProvider(name="testData")
	public Object[][]getData() throws IOException
	{
		 Object[][] data = testData(System.getProperty("user.dir")+"/Test Data/PEMC Test Data.xlsx", "test");
		 return data;
	}
	
	
	public static Object[][] testData(String excelPath, String sheetName) throws IOException
	{
		ExcelUtil excelUtil = new ExcelUtil(excelPath, sheetName);
		
		int rowCount = excelUtil.getRowCount();
		int colCount = excelUtil.getColumnCount();
		
		Object[][] data = new Object[rowCount-1][colCount];
		
		for(int i=1; i<rowCount; i++)
		{
			for(int j=0; j<colCount; j++)
			{
				String cellData = excelUtil.getCellDataString(i, j);
				System.out.print(cellData+"  |  ");
				data[i-1][j] = cellData;
			} 
		}
		System.out.println();
		return data;
		
	}

}
