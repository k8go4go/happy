package day07;

import java.util.Random;

public class Sub03 {
	public int add(int num1, int num2) {
		return num1 + num2;
	}
	
	// sub 메서드 구현 : 2개의 정수의 차를 반환
	public int sub(int num1, int num2) {
		return num1 - num2;
	}
	
	public int mul(int num1, int num2) {
		return num1 * num2;
	}
	
	public int div(int num1, int num2) {
		return num1 / num2;
	}
	
	// cal 메서드 정의 :  
	// 두수를 받아서 덧셈, 뺄셈, 곱셈, 나눗셈을 하고 결과 반환
	/*
	 *   comm : 1(덧), 2(뺄), 3(곱), 4(나)
	 */
	public int cal(int comm, int num1, int num2) {
		switch (comm) {
		case 1: return num1 + num2;
		case 2: return num1 - num2;
		case 3: return num1 * num2;
		case 4: return num1 / num2;
		default: return 0;
		}
	}
	
	/*
	 *   makeNumbers 메서드 구현하기
	 *   
	 *   구현내용
	 *   
	 *   - 1부터 10 사이의 정수를 랜덤하게 5개를 생성해서
	 *     배열에 담은 다음 배열을 메서드를 호출한 곳으로 
	 *     반환한다.
	 */
	/*
	public int[] makeNumbers() {
		int[] arr = new int[5];
		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			arr[i] = r.nextInt(10) + 1;
		}
		return arr;
	}

	// 사용자가 생성되는 배열의 크기를 지정
	public int[] makeNumbers(int size) {
		int[] arr = new int[size];
		Random r = new Random();
		for (int i = 0; i < size; i++) {
			arr[i] = r.nextInt(10) + 1;
		}
		return arr;
	}
	
	// 사용자가 생성되는 배열의 크기를 지정, 생성되는 값의 최대값 지정
	public int[] makeNumbers(int size, int max) {
		int[] arr = new int[size];
		Random r = new Random();
		for (int i = 0; i < size; i++) {
			arr[i] = r.nextInt(max) + 1;
		}
		return arr;
	}
	*/
	
	public int[] makeNumbers() {
		return makeNumbers(5, 10);
	}
	
	// 사용자가 생성되는 배열의 크기를 지정
	public int[] makeNumbers(int size) {
		return makeNumbers(size, 10);
	}
	
	// 사용자가 생성되는 배열의 크기를 지정, 생성되는 값의 최대값 지정
	public int[] makeNumbers(int size, int max) {
		int[] arr = new int[size];
		Random r = new Random();
		for (int i = 0; i < size; i++) {
			arr[i] = r.nextInt(max) + 1;
		}
		return arr;
	}
	
	
	
}














