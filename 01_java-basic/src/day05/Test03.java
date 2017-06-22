package day05;

public class Test03 {
	public static void main(String[] args) {
		// 다차원 배열
		int[][] iArr = new int[3][];
		System.out.println(iArr[0]);
		iArr[0] = new int[2];
		iArr[1] = new int[3];
		iArr[2] = new int[1];
		
		int num = 1;
		for (int i = 0; i < iArr.length; i++) {
			for (int j = 0; j < iArr[i].length; j++) {
				iArr[i][j] = num++;
				System.out.printf("%d - %d : %d\n", i, j, iArr[i][j]);
			}
		}
		
		
		
		
		
		
		
		/*
		System.out.println(iArr[0][0]);
		iArr[0][0] = 10;
		System.out.println(iArr[0][0]);
		*/
	}
}











