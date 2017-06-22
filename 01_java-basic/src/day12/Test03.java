package day12;

import java.util.Calendar;

public class Test03 {
	public static void main(String[] args) {
		// 추상 클래스 이므로 객체 생성 안됨..
//		Calendar c = new Calendar();
		// 객체 얻기
		Calendar c = Calendar.getInstance();
		System.out.println(c);
		
		// 값 추출하기
		// 년도, 월, 일, 시간, 분, 초...
//		int year = c.get(1); // 년도
//		int month = c.get(2) + 1; // 월 : 1월(0) ~ 12월(11)
		int year = c.get(Calendar.YEAR); // 년도
		int month = c.get(Calendar.MONTH) + 1; // 월 : 1월(0) ~ 12월(11)
		System.out.println("년도 : " + year);
		System.out.println("월 : " + month);
		int date = c.get(Calendar.DATE);
		int hour = c.get(Calendar.HOUR);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		
		// 일(1) ~ 토(7)
		int dayWeek = c.get(Calendar.DAY_OF_WEEK);
		
		String[] dayWord = {
				"일", "월", "화", "수", "목", "금", "토"
		};
		
		// 오늘은 ..요일 입니다.
		System.out.printf(
			"오늘은 %s요일 입니다.", dayWord[dayWeek -1]);
	}
}







