package day13;

import java.util.Arrays;

public class Test07 {
	public static void main(String[] args) {
		/*
		 *   실행시의 화면출력이 다음과 같도록 코딩 작성
		 *   [9, 5, 3]
		 */		
		int[] arr = {3, 9, 5};
		
		// 셀렉션 소트를 이용해서 정렬
		// 코드작성
		for (int i = 0; i < arr.length -1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
