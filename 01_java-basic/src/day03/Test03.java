package day03;

import java.util.Random;

public class Test03 {
	// 메서드 선언
	public static void main(String[] args) {
		TestSub03 sub = new TestSub03();
		System.out.println(sub.msg);
		// 메서드 호출
		sub.call();
		
		Random r = new Random();
		// 메서드 호출
		// 0 부터 지정된 숫자(10) 까지
		// 단, 지정된 숫자는 제외
		// 0 ~ 9
		int num = r.nextInt(10);
		System.out.println(num);
		
		// 1 ~ 10
		int num2 = r.nextInt(10) + 1;
		
		// 2 ~ 9
		int num3 = r.nextInt(8) + 2;
		
		// 11 ~ 20
		int num4 = r.nextInt(10) + 11;
		
	}
}











