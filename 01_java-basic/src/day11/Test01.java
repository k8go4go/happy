package day11;

import java.util.Random;

// 상속 불가능
/* final */ class Parent {
	// 오버라이딩 불가능
	public /* final */ void call() {}
}

class Child extends Parent {
	public void call() {
		System.out.println("오버라이딩");
	}
}

/* String : final 선언된 클래스 */
class MyString /* extends String */ {
}

class MyRandom extends Random {
	public int nextInt(int bound) {
		return super.nextInt(bound) + 1;
	}
}

public class Test01 {
	public static void main(String[] args) {
		Random r = new MyRandom();
		int num = r.nextInt(10);
		System.out.println(num);
	}
}
















