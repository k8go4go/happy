package day08.quiz;

public class Quiz01 {
	
	/*
	 *  replace 사용 금지
	 */
	private String remove(String data, char delCh) {
		String result = "";		
		for (int i = 0, len = data.length(); i < len; i++) {
			char ch = data.charAt(i);
			if (ch == delCh) continue;
			
			result += ch;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Quiz01 quiz = new Quiz01();
		String result = quiz.remove("hello world", 'o');
		// hell wrld
		System.out.println(result);
	}
}
