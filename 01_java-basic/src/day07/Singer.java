package day07;

public class Singer {
	// 접근제한자 
	// : private(선언된 클래스만 직접 접근 가능)
	// : public(모든 위치에서 접근 가능)
	private String name;
	private int age;
	private String genre;
	
	
	
	// 세터 메서드 : 멤버변수의 값을 설정하는 메서드
	// 게터 메서드 : 멤버변수의 값을 추출하는 메서드

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	// 인스턴스 메서드들은 매개변수의 첫번째 자리에 this 히든 변수가
	// 설정됨
	public void setName(/* Singer this, */String name) {
		// this : 실행중인 인스턴스 객체를 가리키는 변수
		this.name = name;
	}
	
	public String getName() {
		return this.name; 
	}
	
	public void setAge(int age) {
		if (age < 0) {
			System.out.println("잘못된 나이입니다.");
			return ;
		}
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
}






