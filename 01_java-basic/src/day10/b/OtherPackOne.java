package day10.b;

import day10.a.Test;

public class OtherPackOne {
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println(t.name);
		// 다른 패키지에서 접근하려면
		// public 접근제한자로 선언되어야 한다.
		/*
		System.out.println(t.pass);
		System.out.println(t.addr);
		System.out.println(t.money);
		*/
	}
}
