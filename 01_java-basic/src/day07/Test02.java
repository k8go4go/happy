package day07;

import java.util.Random;

/*
 *   반환타입 연습
 *   
 *   void일 경우 돌려줄 값이 없다.
 *   
 *   void가 아닐 경우에는 반드시 메서드에 return 문이 나와야 한다.
 *   
 *   return 문 다음에는 반환타입에 들어갈 수 있는 값이 설정되어야 함
 *   
 *   반환타입이 있는 경우 호출하는 쪽에서는
 *   선택적으로 값을 받을 수 있다.
 *   
 *   return 문은 현재 수행중인 메서드를 종료시키고
 *   메서드를 호출한 쪽으로 return의 값을 넘긴다.
 */
public class Test02 {
	public static void main(String[] args) {
		Sub02 sub = new Sub02();
		sub.method02();
		int val = sub.method02();  // 97
		
		char ch = sub.method03();
		
		//  "aaa"
		String s = sub.method04();
		
		Random r = sub.method05();
		
		HaHa ha = sub.test(new KiKi());
		ha.test();
		
	}
}






















