package day04;

public class Test02 {
	public static void main(String[] args) {
		// 구구단
		/*
		  2 * 1 = 2   
		  2 * 2 = 4   
		  2 * 3 = 6 
		  ...  
		  2 * 9 = 18

		  3 * 1 = 3   
		  3 * 2 = 6   
		  3 * 3 = 9 
		  ...  
		  3 * 9 = 27

		 */
		for (int i = 1; i < 10; i++) {
			System.out.printf("2 * %d = %d\n", i, 2 * i);
		}
		
		for (int i = 1; i < 10; i++) {
			System.out.printf("3 * %d = %d\n", i, 3 * i);
		}
		
		for (int i = 1; i < 10; i++) {
			System.out.printf("9 * %d = %d\n", i, 9 * i);
		}
		
		for (int dan = 2; dan < 10; dan++) {
			for (int i = 1; i < 10; i++) {
				System.out.printf(
						"%d * %d = %d\n", dan, i, dan * i);
			}
		}
	}
}












