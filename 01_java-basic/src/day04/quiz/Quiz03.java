package day04.quiz;

import java.util.Scanner;

public class Quiz03 {
	public static void main(String[] args) {
		/*
			하나의 수를 입력받은 다음 입력받은 수까지의
			짝수와 홀수, 전체 합을 구한다.
			
			출력 형식>
			
			수 입력 : _10
			홀수 합 : 25
			짝수 합 : 30
			전체 합 : 55
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("수 입력 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		int evenSum = 0, oddSum = 0;
		for (int i = 1; i <= num; i++) {
			if (i % 2 == 0) {
				evenSum += i;
				continue;
			}
			oddSum += i;
			/*
			if (i % 2 == 0) {
				evenSum += i;
			}
			else {
				oddSum += i;
			}
			*/
		}
		System.out.println("홀수 합 : " + oddSum);
		System.out.println("짝수 합 : " + evenSum);
		System.out.println("전체 합 : " + (oddSum + evenSum));
		
	}
}










