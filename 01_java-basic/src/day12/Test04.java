package day12;

import java.util.Calendar;
import java.util.Date;

public class Test04 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		
		int date = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(date);
		
		// 1달 뒤의 날짜로 변경
		c.add(Calendar.MONTH, 1);
		date = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(date);
		
		
		/*
		// Date 객체의 시간 정보를 Calendar 객체에 설정 방법
		Date d = new Date();
		// Calendar 객체의 시간 정보를 Date 객체의 시간정보로 설정
		c.setTime(d);
		
		long time = d.getTime();
		c.setTimeInMillis(time);
		
		// 2014년 12월 25일
		c.set(2014, 11, 25);  // 월은 설정할 월에서 -1 한 값을 입력
		
		System.out.println("년 : " + c.get(Calendar.YEAR));
		System.out.println("월 : " + (c.get(Calendar.MONTH) + 1));
		System.out.println("일 : " + c.get(Calendar.DATE));
		
		// 년도를 2015년 으로 변경
		c.set(Calendar.YEAR, 2015);

		// 상대적인 날짜 정보를 처리해야 하는 경우
		c.add(Calendar.MONTH, 1);
		c.add(Calendar.MONTH, -1);
		*/	
	}
}









