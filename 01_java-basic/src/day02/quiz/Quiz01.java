package day02.quiz;

import java.util.Random;

/*
 * 클, 메, 변, 상 -> 개수??
 * 단, 동일한 이름은 하나로..
 */
public class Quiz01 {
	public static void main(String[] args) {
		int 나이 = 10;
		
		int i = Integer.parseInt("100");
		int j = Integer.parseInt("100");
		System.out.println(i + j);
		System.out.println(Integer.MAX_VALUE);
		Random r = new Random();
		int num = r.nextInt(100);
		System.out.println("num = " + num);
	}
}
