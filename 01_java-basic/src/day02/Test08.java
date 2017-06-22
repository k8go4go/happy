package day02;

public class Test08 {
	public static void main(String[] args) {
		byte b = 100;
		short s = 100;
		int i = 100;
		long l = 100;
		l = 100l;
		
		// float 은 반드시 값 뒤에 f를 붙인다.
		float f = 1.1f;
		f = 1.1F;
		double d = 1.1;
		d = 1d;
		
		// 문자는 ''으로 값을 묶어서 표현
		char c = 'a';
		char c1 = 97;
		// 유니코드 사용 : 16진수로 표현
		char c2 = '\u0061';
		System.out.println(c);
		System.out.println(c1);
		System.out.println(c2);
		
		int i2 = 'a';
		System.out.println(i2);
		
		// 두가지 값만 받을 수 있음 : true, false
		boolean bool = true;
		bool = false;
		
	}
}











