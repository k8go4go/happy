package day04;

import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
		/*
		 	while (조건식) {
		 		실행문장
		 	}
		 */
		// 지정된 범위일 경우
		for (int i = 1; i < 11; i++) {
			System.out.println(i);
		}
		for (int i = 1; i < 11; i++) {
			System.out.println(i);
		}
		
		
		int i = 1;
		while (i < 11) {
			System.out.println(i);
			i++;
		}
		i = 1;
		while (i < 11) {
			System.out.println(i);
			i++;
		}
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("수 입력 : ");
			int num = Integer.parseInt(sc.nextLine());
			if (num == -1) {
				break;
			}
		}
		
		int num = -1;
		do {
			System.out.print("수 입력 : ");
			num = Integer.parseInt(sc.nextLine());
		} while(num != -1);
	}
}










