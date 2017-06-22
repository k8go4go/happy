package day02;

public class Test04 {
	public static void main(String[] args) {
		System.out.println(args[0] + args[1]);
		
		// 문자열의 내용이 숫자일 경우
		// 숫자로 변환하기
		// int a = Integer.parseInt(문자열);
		// int a = Integer.parseInt(args[0]);
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		System.out.println(a + b);
		
	}
}
