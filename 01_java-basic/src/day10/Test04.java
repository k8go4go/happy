package day10;

// 추상클래스
abstract class AbsSuper {
	public void test() {
		System.out.println("구현된 메서드");
	}
	
	// 추상메서드
	public abstract void call();
}
// 추상클래스를 상속받은 하위클래스는 추상메서드를 반드시
// 재정의(오버라이딩) 해야 한다.
class AbsSub extends AbsSuper {
	public void call() {
		System.out.println("재정의된 메서드");
	}
}
public class Test04 {
	public static void main(String[] args) {
		// 추상클래스는 객체 생성 불가
//		AbsSuper aSuper = new AbsSuper();
		// 자식 클래스를 이용(묵시적 형변환)
		AbsSuper aSuper = new AbsSub();
		aSuper.call();
		aSuper.test();
	}
}









