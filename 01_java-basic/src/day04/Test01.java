package day04;

public class Test01 {
	public static void main(String[] args) {
		/*
			for ( ; ; )
			
			for (1. 초기값; 2. 조건식; 3. 값의증감) {
				4. 실행문장(조건식이 참이면)
			}
			5. for문을 벗어난 문장
			
			실행순서
			1   -   2(참)    -   4   -   3   
			    -   2(참)    -   4   -   3
			    ....
			    ....
			    -   2(거짓)  -   5
			      
			참고.
			1, 2, 3번 항목을 안써두 상관없음      
			for (1. 초기값; ; 3. 값의증가)      
			for (1. 초기값; ; )      
			for ( ; 조건식; )      
			// 무한반복
			for ( ; ; )      
			
		 */
		for (int i = 1; i < 10; i++) {
			System.out.println(i);
		}
		
		System.out.println(10);
		System.out.println(20);
		System.out.println(30);
		System.out.println(40);
		System.out.println(50);
		
		for (int i = 10; i <= 50; i += 10) {
			System.out.println(i);
		}

		for (int i = 1; i <= 5; i++) {
			System.out.println(i * 10);
		}
	}
}








