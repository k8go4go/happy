package day04.quiz;

import java.util.Scanner;

public class Quiz02 {
	public static void main(String[] args) {
		/*
		      화면에서 숫자를 입력받아서 입력받은 숫자와 연관된
		      별을 출력
		      
		      출력형식 >
		      수 입력 : _5
		      
		      *
		      **
		      ***
		      ****
		      *****
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("수 입력 : ");
		int count = Integer.parseInt(sc.nextLine());
		for (int i = 1; i <= count; i++) {
			for (int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		String star = "*";
		for (int i = 1; i <= count; i++) {
			System.out.println(star);
			star += "*";
		}
		
		star = "*";
		for (int i = 1; i <= count; i++, star += "*") {
			System.out.println(star);
		}
		
		star = "";
		for (int i = 1; i <= count; i++) {
			System.out.println(star += "*");
		}
	}
}








