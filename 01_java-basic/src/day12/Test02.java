package day12;

import java.util.Date;

public class Test02 {
	public static void main(String[] args) {
		Date d = new Date();
		
		// 1970년을 기준으로 시간 정보를 long으로 변환
		long time = d.getTime();
		
		System.out.println(time);
		
		// deprecated : 사용하지 않아야 함..
		int year = d.getYear();
	}
}
