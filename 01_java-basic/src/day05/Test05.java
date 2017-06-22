package day05;

import java.util.Arrays;

public class Test05 {
	public static void main(String[] args) {
		int[] source = {1, 2, 3, 4, 5};
		int[] dest = new int[source.length];
		
		// source 배열의 일부를 dest 배열로 복사
		// 결과
		// dest   1  2  0   0  0    
		/*
		dest[2] = source[2];
		dest[3] = source[3];
		
		for (int i = 0; i < 2; i++) {
			dest[i + 2] = source[i + 2];
		}
		*/
		
		// API를 활용한 배열 복사
		// dest   1  2  0   0  0    
//		System.arraycopy(source, 0, dest, 2, 2);
		
		// source 배열의 내용을 모두 dest 배열로 복사
		System.arraycopy(source, 0, dest, 0, source.length);
		
		
		System.out.println(Arrays.toString(dest));
	}
}
























