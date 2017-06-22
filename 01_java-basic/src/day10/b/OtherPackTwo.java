package day10.b;

import day10.a.Test;

public class OtherPackTwo extends Test {
	public OtherPackTwo() {
		System.out.println(name);
		// 다른 패키지의 클래스와 상속관계가 형성되어 있다면
		// protected 접근제한자도 접근 가능
		System.out.println(pass);
		/*
		System.out.println(addr);
		System.out.println(money);
		*/
	}
}
