package day08.quiz;

public class Quiz03 {
	/*
	 *  endsWith 사용 금지
	 */
	private boolean endsWith(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		if (len2 > len1) return false;
		
		for (int i = len2 - 1, j = len1 - 1; i >= 0; i--, j--) {
			if (str1.charAt(j) != str2.charAt(i)) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Quiz03 quiz = new Quiz03();
		boolean result = quiz.endsWith("hello world", "rld");
		System.out.println(result);
	}
}
