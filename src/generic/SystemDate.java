package generic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemDate {


	public static String currentDate()
	{
		SimpleDateFormat sd= new SimpleDateFormat("M-dd-yyyy:mm:ss aa");
		String date=sd.format(new Date());
		return date;
		
		
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             

}
