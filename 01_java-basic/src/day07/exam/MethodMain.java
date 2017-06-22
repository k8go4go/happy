package day07.exam;

public class MethodMain {
	public static void main(String[] args) {
		MethodUtil mu = new MethodUtil();
		boolean result = mu.isLowerChar('a');
		System.out.println(result);     //  true 출력
		result = mu.isLowerChar('A');
		System.out.println(result);     //  false 출력
		result = mu.isUpperChar('a');
		System.out.println(result);     //  false 출력
		result = mu.isUpperChar('A');
		System.out.println(result);     //  true  출력
		int val = mu.max(100, 10);
		System.out.println(val);        //  100 출력 
		val = mu.min(100, 10);
		System.out.println(val);        //  10 출력 
		String revStr = mu.reverse("Hello World");
		System.out.println(revStr);                 // dlroW olleH 출력
		revStr = mu.toUpperString("Hello World");
		System.out.println(revStr);                 // HELLO WORLD 출력
		revStr = mu.toLowerString("Hello World");
		System.out.println(revStr);                 // hello world 출력
	}
}
