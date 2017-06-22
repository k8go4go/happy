package day03;

import java.util.Random;

public class Test05 {
	public static void main(String[] args) {
		byte b1 = 1;
		byte b2 = 2;
		// int 보다 작은 타입들의 산술연산의 결과는
		// int로 형변환된다.
		byte b3 = (byte)(b1 + b2);
		System.out.println('a' + 'A');
		
		int i1 = 5;
		int i2 = 2;
		int i3 = i1 / i2;
		System.out.println(i3);
		
		double d1 = i1 / i2;
		System.out.println(d1);
		
		// 2.5 가 될수 있도록 코딩 작성
		double d2 = i1 / (double)i2;
		System.out.println(d2);	
		
		System.out.println(1 % 2);
		System.out.println(2 % 2);
		System.out.println(3 % 2);
		System.out.println(4 % 2);
		System.out.println(5 % 2);
		System.out.println(6 % 2);
		
		// 1 - 100 사이의 숫자를 랜덤하게 생성한 후 
	    // 아래와 같이 출력될 수 있도록 프로그램을 작성
		// 예> 생성된 5는 홀수입니다.
		/*
		Random r = new Random();
		int num = r.nextInt(100) + 1;
		String result = (num % 2 == 0) ? "짝수" : "홀수";
		System.out.printf(
				"생성된 %d는 %s입니다.", num, result);
		*/
		int num = new Random().nextInt(100) + 1;
		System.out.printf(
				"생성된 %d는 %s입니다.", 
				num, 
				(num % 2 == 0) ? "짝수" : "홀수");
		
	}
}













