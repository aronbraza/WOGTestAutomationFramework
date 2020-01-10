package TestData;


import java.io.IOException;

import org.testng.annotations.DataProvider;


public class LoginTestData {
	
	private String sTestCaseName;

	private int iTestCaseRow;
	
	 @DataProvider()
	public Object[][] L_00() throws Exception
	{
		ExcelUtils.setExcelFile(System.getProperty("user.dir")+"\\Test Data\\PEMC Test Data.xlsx","CMS Login");
		sTestCaseName = "L_00";
	  	sTestCaseName = ExcelUtils.getTestCaseName(sTestCaseName.toString());
	 	iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);
	    Object[][] testObjArray = ExcelUtils.getTableArray(System.getProperty("user.dir")+"\\Test Data\\PEMC Test Data.xlsx","CMS Login",iTestCaseRow);

	    	return testObjArray;
	}
	
	 @DataProvider()
		public Object[][] E_001() throws Exception
		{
			ExcelUtils.setExcelFile(System.getProperty("user.dir")+"\\Test Data\\PEMC Test Data.xlsx","Sheet1");
			sTestCaseName = "E_001";
		  	sTestCaseName = ExcelUtils.getTestCaseName(sTestCaseName.toString());
		 	iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);
		    Object[][] testObjArray = ExcelUtils.getTableArray(System.getProperty("user.dir")+"\\Test Data\\PEMC Test Data.xlsx","Sheet1",iTestCaseRow);

		    	return testObjArray;
		}
	


	

}
