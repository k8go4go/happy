package day05.quiz;

public class Quiz03 {
	public static void main(String[] args) {
		/*
		 *   출력형식>
		 *   
		 *   배열의 모든 요소가 홀수 입니다.
		 *   
		 *   배열의 모든 요소가 홀수는 아닙니다.
		 */
		int[] arr = {6, 8, 3, 9, 7, 4};
		String msg = "홀수 입니다.";
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				msg = "홀수는 아닙니다.";
				break;
			}
		}
		System.out.println("배열의 모든 요소가 " + msg);
	}
}








