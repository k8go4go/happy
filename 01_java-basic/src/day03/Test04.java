package day03;

import java.util.Random;

public class Test04 {
	public static void main(String[] args) {
		// 랜덤한 값을 사용하기 위해 Random 클래스 사용
		Random r = new Random();
		
		// 랜덤한 수 2개를 구한다.(1 - 10)
		int num1 = r.nextInt(10) + 1;
		int num2 = r.nextInt(10) + 1;
		
		// 화면에 생성된 두 수를 출력한다.
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		
		// 생성된 두 수 중에서 큰수를 max란 이름의 변수에
		// 저장하시오
		// hint> 3항 연산자 이용
		int max = (num1 > num2) ? num1 : num2;
		System.out.println("큰수 : " + max);
		
		// 두수중에 작은수를 min 이란 변수에 저장하고
		// 화면에 출력하시오
		int min = (num1 < num2) ? num1 : num2;
		System.out.println("작은수 : " + min);
	}
}
















