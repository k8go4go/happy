package day13.quiz;

import java.util.Arrays;

public class Quiz03 {
	public static void main(String[] args) {
		Data d1 = new Data(3);
		Data d2 = new Data(9);
		Data d3 = new Data(5);
		
		Data[] arr = {d1, d2, d3};
		
		// [9, 5, 3]
		// 실행시 [9, 5, 3] 이 출력되도록  
		// 코딩추가
		for (int i = 0; i < arr.length -1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].getNum() < arr[j].getNum()) {
					Data temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
