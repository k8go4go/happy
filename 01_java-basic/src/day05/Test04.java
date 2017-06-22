package day05;

import java.util.Arrays;

public class Test04 {
	public static void main(String[] args) {
		// 배열의 내용을 확인
		int[] iArr = {1, 2, 3};
		// 1.4버전까지 사용법
		for (int i = 0; i < iArr.length; i++) {
			System.out.println(iArr[i]);
		}
		
		// 1.5 향상된 for
		int index = 0;
		for (int val : iArr) {
			System.out.println(index++ + " : " + val);
		}
		
		boolean[] bArr = {true, false, true};
		for (boolean val : bArr) {
			System.out.println(val);
		}
		
		// API 클래스를 활용한 배열 요소 확인
		String data = Arrays.toString(iArr);
		System.out.println(data);

		System.out.println(Arrays.toString(iArr));
	}
}














