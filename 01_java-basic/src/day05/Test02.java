package day05;

public class Test02 {
	public static void main(String[] args) {
		/*
		 *   배열에 데이터를 초기화
		 */
		int[] iArr = new int[3];
		// 1, 10, 100
		iArr[0] = 1;
		iArr[1] = 10;
		iArr[2] = 100;
		for (int i = 0; i < iArr.length; i++) {
			System.out.println(iArr[i]);
		}
		
		// 배열의 선언과 함께만 사용 가능
		int[] iArr2 = {1, 10, 100};
//		iArr2 = {2, 20, 200};  // 에러
		
		int[] iArr3 = new int[]{1, 10, 100};
		iArr3 = new int[]{2, 20, 200};
	}
}









