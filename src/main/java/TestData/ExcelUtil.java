package TestData;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	
	public ExcelUtil(String excelPath, String sheetName) throws IOException
	{
		 workbook = new XSSFWorkbook(excelPath);
		 sheet = workbook.getSheet(sheetName);
	}
	
	
	public int getRowCount() throws IOException
	{
		
		int rowCount= sheet.getPhysicalNumberOfRows();
		//System.out.println("Number of rows: "+rowCount);
		return rowCount;
		
	}
	
	public int getColumnCount() throws IOException
	{
		
		int colCount= sheet.getRow(0).getPhysicalNumberOfCells();
		//System.out.println("Number of column: "+colCount);
		return colCount;
		
	}
	
	public String getCellDataString(int rowNum, int colNum) throws IOException
	{
		String cellData =null;
		Cell cell = sheet.getRow(rowNum).getCell(colNum);
		if(cell.getCellType() == CellType.STRING)
		{
			 cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		}
		else
		{
			 cellData = NumberToTextConverter.toText(sheet.getRow(rowNum).getCell(colNum).getNumericCellValue());
		}
		
		return cellData;
	}
	
	public double getCellDataNumeric(int rowNum, int colNum) throws IOException
	{
		double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		return cellData;
	}

}
