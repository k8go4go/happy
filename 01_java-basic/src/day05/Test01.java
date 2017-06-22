package day05;

public class Test01 {
	public static void main(String[] args) {
		// 정수형 배열 선언
		int[] iArr;
		// 배열의 공간 생성(3개)
		iArr = new int[3]; 
		// 배열의 자동 초기화 값 확인
		for (int i = 0; i < iArr.length; i++) {
			System.out.println(iArr[i]);
		}
		
		for (int i = 0, len = iArr.length; i < len; i++) {
			System.out.println(iArr[i]);
		}
		
		// 문자열을 담을 수 있는 배열을 생성(3개)
		// 배열의 이름은 sArr로 정하고
		// 생성된 배열의 초기값을 화면에 출력
		String[] sArr = new String[3];
		for (int i = 0; i < sArr.length; i++) {
			System.out.println(sArr[i]);
		}
	}
}













