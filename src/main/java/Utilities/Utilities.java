package Utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {
	
	
	//Convert MM/dd/yyyy HH:mm to dd MMMM yyyy HH:mm
	public String ConvertDate(String Date) throws ParseException
	{
		SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		SimpleDateFormat format2 = new SimpleDateFormat("dd MMMM yyyy HH:mm");
		
		Date date = format1.parse(Date);
		String ConvertStartDate = format2.format(date);
		return ConvertStartDate;
	}

}
