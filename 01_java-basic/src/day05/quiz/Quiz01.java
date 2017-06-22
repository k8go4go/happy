package day05.quiz;

public class Quiz01 {
	public static void main(String[] args) {
		int[] arr = {6, 8, 3, 9, 7, 4};
		
		/*
		 *   출력형식>
		 *   최댓값 : 9
		 *   최솟값 : 3
		 */
		
		int max = arr[0], min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i]) max = arr[i];
			if (min > arr[i]) min = arr[i];
		}
		System.out.println("최댓값 : " + max);
		System.out.println("최솟값 : " + min);
	}
}









