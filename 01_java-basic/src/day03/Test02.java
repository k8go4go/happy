package day03;

public class Test02 {
	public static void main(String[] args) {
		final String IP = "192.168.0.111";
//		The final local variable IP cannot be assigned. It must be blank and not using a compound assignment
//		IP = "192.168.0.112";  // final 상수이기 때문에 값 변경 불가
		
		// 문자열 상수
		System.out.println("오늘은 \"좋은날\" 이란 책을 읽자");
		System.out.println("수업 소스 위치");
		System.out.println("c:\test");
		System.out.println("c:\\test");
		// Invalid escape sequence (valid ones are  \b  \t  \n  \f  \r  \"  \'  \\ 
//		System.out.println("c:\java94");
		
	}
}
