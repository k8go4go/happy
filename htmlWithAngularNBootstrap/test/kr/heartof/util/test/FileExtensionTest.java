package kr.heartof.util.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExtensionTest {
	public static void main(String[] args) throws ParseException {
		System.out.println(converToDate());
	}
	
	private static String getExtionFileName(String fileName) {
		int lastIndex = fileName.lastIndexOf(".");
		
		return fileName.substring(lastIndex+1);
	}
	
	public static Date converToDate() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		return format.parse("2017-06-07 21:45");
	}
}
