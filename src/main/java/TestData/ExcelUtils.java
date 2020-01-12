package TestData;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	public static void setExcelFile(String Path,String SheetName) throws Exception {

		try {

			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e){

			throw (e);

		}
		
		

	}
	
	public static int getColumnCount() throws IOException
	{
		 
		int columnCount = 0;
		columnCount = ExcelWSheet.getRow(0).getPhysicalNumberOfCells();
		//System.out.println("Number of columns: "+columnCount);
		return columnCount;
	}

	public static Object[][] getTableArray(String FilePath, String SheetName, int iTestCaseRow)    throws Exception

	{   

		String[][] tabArray = null;

		try{

			FileInputStream ExcelFile = new FileInputStream(FilePath);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			int startCol = 1;

			int ci=0,cj=0;

			int totalRows = 1;

			
			int Cols = ExcelUtils.getColumnCount();
			int totalCols = Cols -1;
			tabArray=new String[totalRows][totalCols];

			for (int j=startCol;j<=totalCols;j++, cj++)

			{

				tabArray[ci][cj]=getCellData(iTestCaseRow,j);

				System.out.println(tabArray[ci][cj]);

			}

		}

		catch (FileNotFoundException e)

		{

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		catch (IOException e)

		{

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		return(tabArray);

	}

	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

	public static String getCellData(int RowNum, int ColNum) throws Exception{

		try{

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			String CellData = Cell.getStringCellValue();

			return CellData;

		}catch (Exception e){

			return"";

		}

	}

	public static String getTestCaseName(String sTestCase)throws Exception{

		String value = sTestCase;
		return value;

		

	}

	public static int getRowContains(String sTestCaseName, int colNum) throws Exception{

		int i;

		try {

			int rowCount = ExcelUtils.getRowUsed();

			for ( i=0 ; i<rowCount; i++){

				if  (ExcelUtils.getCellData(i,colNum).equalsIgnoreCase(sTestCaseName)){

					break;

				}

			}

			return i;

		}catch (Exception e){

			throw(e);

		}

	}

	public static int getRowUsed() throws Exception {

		try{

			int RowCount = ExcelWSheet.getLastRowNum();

			return RowCount;

		}catch (Exception e){

			System.out.println(e.getMessage());

			throw (e);

		}


	}
}
