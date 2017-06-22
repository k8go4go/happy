package day02.quiz;

public class Quiz02 {
	public static void main(String[] args) {
		// i에 100으로 값을 설정하는 부분은 try 블럭에
		// 있어야 한다.
		// 오류가 발생하지 않도록 코드를 변경..
		int i = 0;
		try {
			i = 100;
		} 
		catch (Exception e) {
			i = -1;
		}
		finally {
			System.out.println(i);
		}
	}
}
