package day05.quiz;

import java.util.Arrays;
import java.util.Scanner;

public class Quiz02 {
	public static void main(String[] args) {
		/*
		 *   출력형식>
		 *   
		 *   바꿀 인덱스 : 2
		 *   바꿀 인덱스 : 4
		 *   
		 *   결과 : [6, 8, 7, 9, 3, 4]
		 */
		int[] arr = {6, 8, 3, 9, 7, 4};
		Scanner sc = new Scanner(System.in);
		
		System.out.print("바꿀 인덱스 : ");
		int index1 = Integer.parseInt(sc.nextLine());

		System.out.print("바꿀 인덱스 : ");
		int index2 = Integer.parseInt(sc.nextLine());
		
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
		
		System.out.println("결과 : " + Arrays.toString(arr));
	}
}











