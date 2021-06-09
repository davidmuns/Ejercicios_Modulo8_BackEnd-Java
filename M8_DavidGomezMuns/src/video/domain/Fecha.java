package video.domain;

import java.util.Calendar;

public class Fecha {
	
	public static String fechaActualStringFormat() {
		
		Calendar c = Calendar.getInstance();
	
		int dia = c.get(Calendar.DATE);
		int mes = c.get(Calendar.MONTH) + 1;
		int year = c.get(Calendar.YEAR);
		int hora = c.get(Calendar.HOUR_OF_DAY);
		int min = c.get(Calendar.MINUTE);
		int seg = c.get(Calendar.SECOND);
		
		return dia + "/" + mes  + "/" + year + ", hora=" + hora + ":" + min + ":" + seg;
		
	}
}
