package TestData;


import java.io.IOException;

import org.testng.annotations.DataProvider;


public class DataProviderTestData {
	
	private String sTestCaseName;

	private int iTestCaseRow;
	
	 
	 @DataProvider(name="CMSLoginTestData")
	 public Object[][] cmsLoginTestData() throws IOException
	 {
		 ExcelUtil excelUtil = new ExcelUtil(System.getProperty("user.dir")+"/Test Data/PEMC Test Data.xlsx", "CMS Login");
		 int rowCount = excelUtil.getRowCount();
		 int colCount = excelUtil.getColumnCount();
		 Object [][] data = new Object[rowCount-1][colCount];
		 for(int i=1; i<rowCount; i++)
		 {
			 for(int j=0; j<colCount; j++)
			 {
				 data[i-1][j] = excelUtil.getCellDataString(i, j);
			 }
		 }
		 return data;
		 
	 }
	 
	 @DataProvider(name = "CMSLoginTestData1", indices = {0})
	 public Object[][] cmsLoginTestData1() throws IOException {
	     return cmsLoginTestData();
	 }
	 
	 @DataProvider(name="CreateEventTestData")
	 public Object[][] createEventTestData() throws IOException
	 {
		 ExcelUtil excelUtil = new ExcelUtil(System.getProperty("user.dir")+"/Test Data/PEMC Test Data.xlsx", "CMS Events");
		 int rowCount = excelUtil.getRowCount();
		 int colCount = excelUtil.getColumnCount();
		 Object [][] data = new Object[rowCount-1][colCount];
		 for(int i=1; i<rowCount; i++)
		 {
			 for(int j=0; j<colCount; j++)
			 {
				 data[i-1][j] = excelUtil.getCellDataString(i, j);
			 }
		 }
		 return data;
		 
	 }
	 
	 @DataProvider(name = "CreateEventTestData1", indices = {0})
	 public Object[][] createEventTestData1() throws IOException {
	     return createEventTestData();
	 }

	

}
