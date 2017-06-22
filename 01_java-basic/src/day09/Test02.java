package day09;

public class Test02 {
	public static void main(String[] args) {
		// 클래스 정보의 로딩은 클래스가 사용되는 시점에 동적으로
		// 실행된다.
		Sub02 s = null;
		System.out.println(1);
		Sub02.k = 800;
		// 객체 생성(클래스 정보 찾는다)
		// 클래스 정보가 없다면 클래스 정보를 로딩한다.
		// 클래스 정보 로딩시에 static 블럭이 실행된다.
		System.out.println(Sub02.k);

		s = new Sub02();
		s.i = 200;
		
		
		
		
		
		
		
		
		
		
		
		
		/*
//		s.k = 200;
		
		Sub02 s2 = new Sub02();
		s2.i = 400;
//		s2.k = 400;
		
		System.out.println(2);
		
		System.out.println(s.i + "-" + s.k);
		System.out.println(s2.i + "-" + s2.k);
		*/
	}
}








