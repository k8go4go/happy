package day09;

/*
 *   생성자 메서드에서 가장 먼저 하는 일
 *   
 *   1. this 생성자 호출 또는 super 생성자 호출 코드를 찾는다.
 *   2. 만약, 코드를 찾지 못했다면 super() 생성자 호출 코드를 자동으로
 *      추가한다.
 *   
 */

class Parent extends java.lang.Object {
	Parent() {
		super();
	}
	Parent(int i) {
		
	}
}

class Child extends Parent {
	Child() {
		super();
	}
}


public class Test05 {
	public static void main(String[] args) {
		
	}
}







