package TestData;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfig {
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
	public ExcelConfig(String excelPath)
	{
		try
		{
			File src = new File(excelPath);
			FileInputStream fis = new FileInputStream(src);
			workbook = new XSSFWorkbook(fis);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String getData(String sheetName, int row, int column)
	{
		sheet = workbook.getSheet(sheetName);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public int getRowCount(int sheetIndex)
	{
		int rows = workbook.getSheetAt(sheetIndex).getLastRowNum();
		rows=rows+1;
		return rows;
	}

}
