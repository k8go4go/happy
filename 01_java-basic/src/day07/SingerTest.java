package day07;

public class SingerTest {
	public static void main(String[] args) {
		Singer s = new Singer();
		s.setName("나훈아");
		s.setAge(47);
//		s.name = "나훈아";
		// 값의 조작은 직접 하지 말고 메서드를 통해서 처리하자
//		s.age = -47;
		
		// 설정된 가수 정보 확인하기
		System.out.println("이름 : " + s.getName());
		System.out.println("나이 : " + s.getAge());
//		System.out.println("이름 : " + s.name);
//		System.out.println("나이 : " + s.age);
	}
}











