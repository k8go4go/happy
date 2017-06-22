package day12;

public class Test06 {
	//  Object o = 100;
	//  Object o = new Integer(100);
	public static void add(Object o) {
		// instanceof : 객체 변수의 타입 확인
		if (o instanceof Integer) {
			System.out.println("Integer 타입");
		}
		else {
			System.out.println("Integer 타입 아님");
		}
		
		
	}
	
	public static void main(String[] args) {
		add(100);
		
		
		// Wrapper 클래스
		// 기본형에 대한 참조타입 클래스
		/*
		 *   byte      Byte  Object o = new Byte(10)
		 *   short     Short
		 *   int       Integer
		 *   long      Long
		 *   float     Float
		 *   double    Double
		 *   char      Character
		 *   boolean   Boolean
		 */
		// 1.4 버전 까지의 처리 방식
		int i = 100;
		// 기본형 -> 참조형으로 변환
		Integer iObj = new Integer(i);
		// 참조형 -> 기본형 값 얻기
		int k = iObj.intValue();
		
		// 1.5 버전 부터 오토박싱, 오토 언박싱
		// autoboxing : 기본형 -> 참조형으로 변환
		Integer iObj2 = i;
		// autounboxing : 참조형 -> 기본형 값 얻기
		int j = iObj2;
		
	}
}









