package day12;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test05 {
	public static void main(String[] args) {
		// 2017/04/25 10:31
		// 날짜 정보에서 원하는 형태의 문자열로 변환
		// 날짜 형태의 문자열을 날짜 객체로 변환
		/*
		 *   패턴문자
		 *   y : 년도
		 *   M : 월
		 *   d : 일
		 *   H : 시
		 *   h : 시
		 *   m : 분
		 *   s : 초
		 */
		SimpleDateFormat sdf = 
//				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				new SimpleDateFormat("yyyy-MM-dd");
		// format : 날짜정보에서 문자열 추출
		String str = sdf.format(new Date());
		System.out.println(str);
		
		// parse : 문자열에서 날짜 객체를 추출
		try {
			Date d = sdf.parse("2015-10-09");
			System.out.println(d);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}








