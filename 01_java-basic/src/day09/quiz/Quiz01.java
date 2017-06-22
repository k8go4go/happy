package day09.quiz;

public class Quiz01 {
	/*
	 *   위의 제공된 코드는 변경하지 않는다.
	 *   코드를 추가하여 QuizTest01 클래스에서 객체 변수를 얻을 수 있게 작성한다.
	 *   단, 코드를 추가하되.. 생성자 추가는 안된다.
	 *   실행시 화면에 "성공"이 출력된다.
	 */
	// Singleton Pattern
	private static Quiz01 instance;
	
	public static Quiz01 getInstance() {
		if (instance == null) {
			instance = new Quiz01();
		}
		return instance;
	}
	
	private Quiz01() {}
	public void msg() {
		System.out.println("성공");
	}
}










