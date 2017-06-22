package day10.a;

public class PackOne extends Test {
	public PackOne() {
		System.out.println(name);
		System.out.println(pass);
		System.out.println(addr);
		// private는 자신의 클래스에서만 
		// 접근 허용됨
//		System.out.println(money);
	}
}
