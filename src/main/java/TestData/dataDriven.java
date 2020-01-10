package TestData;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {
	
	//Identify  test cases column by scanning the entire 1st row
	//once column is identified then scan entire test case column to identify purchase test case row
	//after you grab the  purchase test cases row = pull all the data of that row and feed into test.
	
	public ArrayList<String> getData(String testcaseName, String Sheetname) throws IOException
	{
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//Test Data//PEMC Test Data.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		
		int sheets = workBook.getNumberOfSheets();
		for(int i=0; i<sheets; i++)
		{
			if(workBook.getSheetName(i).equalsIgnoreCase(Sheetname))
			{
				XSSFSheet sheet = workBook.getSheetAt(i); 
				//Identify  test cases column by scanning the entire 1st row
				Iterator<Row> rows = sheet.iterator(); //sheet is collection of rows
				Row firstRow = rows.next();
				Iterator<Cell> cell = firstRow.cellIterator(); //row is collection if cells
				int k=0;
				int column=0;
				while(cell.hasNext())
				{
					Cell value = cell.next();
					if (value.getStringCellValue().equalsIgnoreCase("Test Cases"))
					{
						column = k;
					}
					k++;
				}
				
				//System.out.println(column);
				
				//once column is identified then scan entire test case column to identify purchase test case row
				
				while(rows.hasNext())
				{
					Row r= rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))
					{
						//after you grab the  purchase test cases row = pull all the data of that row and feed into test.
						Iterator<Cell> cellValue = r.iterator();
						while(cellValue.hasNext())
						{
							Cell c = cellValue.next();
							if(c.getCellType() ==CellType.STRING)
							{
								a.add(c.getStringCellValue());
							}
							else
							{
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
								
							}
							
						}
						
					}
					
				}
				
			}	
		}
		
			return a;
	}
	

}
