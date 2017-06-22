package day03;

public class Test07 {
	public static void main(String[] args) {
		/*
		 	if (조건식)
		 		조건식의 결과가 참일 경우 실행할 문장
		 		
		 	주의사항
		 	if 문의 조건식이 참일 경우 2문장 이상을 실행하려면
		 	if 문에 블럭({})을 사용해서 묶어야 한다.	
		 */
		int a = 2;
		/*
		if (a > 3)
			System.out.println("a는 3보다 크다");
		*/
		
		/*
		if (a > 3) {
			System.out.println("a는 3보다 크다");
			System.out.println("a = " + a);
		}
		*/
		
		/*
		a = 2;
		if (a > 3) {
			System.out.println("a는 3보다 크다");
			System.out.println("a = " + a);
		}
		else {
			System.out.println("a는 3보다 크지 않다.");
		}
		*/
		
		// a는 3보다 크다
		// a는 3이다
		// a는 3보다 작다
		/*
		a = 2;
		if (a > 3) {
			System.out.println("a는 3보다 크다");
			System.out.println("a = " + a);
		}
		else {
			if (a == 3) {
				System.out.println("a는 3이다");
			}
			else {
				System.out.println("a는 3보다 작다.");
			}
		}
		*/
		
		// a는 3보다 크다
		// a는 3이다
		// a는 3보다 작다
		/*
		a = 2;
		if (a > 3) {
			System.out.println("a는 3보다 크다");
			System.out.println("a = " + a);
		}
		if (a == 3) {
			System.out.println("a는 3이다");
		}
		if (a < 3) {
			System.out.println("a는 3보다 작다.");
		}
		*/
		// a는 3보다 크다
		// a는 3이다
		// a는 3보다 작다
		a = 2;
		if (a > 3) {
			System.out.println("a는 3보다 크다");
			System.out.println("a = " + a);
		}
		else if (a == 3) {
			System.out.println("a는 3이다");
		}
		else {
			System.out.println("a는 3보다 작다.");
		}
		System.out.println("프로그램 종료...");
	}
}







