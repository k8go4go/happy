package day02;

import java.util.Random;

import day01.Second;

public class Test09 {
	public static void main(String[] args) {
		String str = "aaa";
		String str2 = new String("aaa");
		
		Test01 t01 = new Test01();
		Test04 t04 = new Test04();
		// Second클래스는 같은 위치(패키지)가 아니기 때문에
		// 사용하기 위해서는 위치(패키지)를 import를 이용해서
		// 알려줘야 한다.
		// import 패키지이름.클래스명
		// import는 클래스 선언 위에 명시함..
		
		Second s = new Second();
		Random r = new Random();
		
	}
}








