package day13.quiz;

import java.util.Arrays;

public class Quiz04 {
	public static void main(String[] args) {
		Data d1 = new Data(3);
		Data d2 = new Data(9);
		Data d3 = new Data(5);
		
		Data[] arr = {d1, d2, d3};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		/*
		int[] iArr = {3, 9, 5};
		Arrays.sort(iArr);
		System.out.println(Arrays.toString(iArr));
		
		String[] sArr = {"korea", "apple", "student"};
		Arrays.sort(sArr);
		System.out.println(Arrays.toString(sArr));
		*/
	}
}











