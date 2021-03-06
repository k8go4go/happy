package kr.heartof.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static Date converToDate(String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		return format.parse(date);
	}
	
	public static String converToString(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		return format.format(date);
	}
	
	public static boolean before(Date target) {
		Date now = new Date();
		return now.before(target);
	}
	
	public static boolean after(Date target) {
		Date now = new Date();
		return now.after(target);
	}
}
