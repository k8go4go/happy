package day08;

public class Test02 {
	public static void main(String[] args) {
		String s1 = "a";
		String s2 = "a";
		String s3 = new String("a");
		
		s2 = "b";
		
		System.out.println(s1 == s2);
		System.out.println(s2 == s3);
		System.out.println(s1 == "a");
		// 문자열의 내용 비교
		System.out.println(s1.equals(s3));
	}
}
