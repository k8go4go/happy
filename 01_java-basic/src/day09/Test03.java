package day09;

/*
 *   static 
 *   1. 클래스이름.변수, 클래스이름.메서드명
 *   2. static 영역에서는 인스턴스 영역에 접근이 불가
 *      인스턴스 영역에서는 static 영역에 접근이 가능
 */
public class Test03 {
	int i = 100;
	static int k = 100;
	
	public void call() {
		// static 접근 가능
		System.out.println(k);
	}
	
	public static void main(String[] args) {
		// instance 접근 불가능
//		System.out.println(i);
		Test03 t03 = new Test03();
		System.out.println(t03.i);
		
		System.out.println(k);
	}
}











