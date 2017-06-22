package day03;

public class Test01 {
	public static void main(String[] args) {
		byte b = 100;
		// 묵시적 형변환 : 범위가 넓은 타입 = 좁은 타입
		// 묵시적, 암묵적, 업캐스팅
		int i = b;
		System.out.println(i);
		
		int i2 = 100;
		// Type mismatch: cannot convert from int to byte
		// 컴파일 에러 발생 : 형변환 
//		byte b2 = i2;
		
		// 명시적 형변환, 다운캐스팅
		byte b2 = (byte)i2;
		System.out.println(b2);
		
		// 소문자 a, 대문자 A의 아스키 코드를 화면에 출력
		/*
		char c1 = 'a';
		char c2 = 'A';
		
		int i3 = c1;
		int i4 = c2;
		
		System.out.println("a = " + i3);
		System.out.println("A = " + i4);
		 */
		
		System.out.println("a = " + (int)'a');
		System.out.println("A = " + (int)'A');
	}
}
















