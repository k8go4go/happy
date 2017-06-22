package day09;

public class Sub02 {
	int i = 100;
	
	static int k = 100;
	
	// static 블럭 :  클래스 정보가 로딩될 때 같이 실행됨
	static {
		System.out.println("static 블럭 실행됨");
	}
	
	Sub02() {
		System.out.println("생성자 호출됨..");
	}
}
