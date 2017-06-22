package day09;

import java.util.Date;
import java.util.Random;

class Bread {
	private int price;
	private int cal;
	private String name;
	public Bread() {
	}
	public Bread(int price, int cal, String name) {
		this.price = price;
		this.cal = cal;
		this.name = name;
	}
	public String toString() {
		return String.format(
				"Bread[name=%s, price=%d, cal=%d]", 
				name, price, cal);
	}
}

public class Test06 {
	public static void main(String[] args) {
		Bread b = new Bread(2000, 375, "피자빵");
		System.out.println(b);
		
		System.out.println(b.toString());
		// 객체.변수 또는 객체.메서드 호출이 아닌
		// 객체 자체를 출력할 경우 객체.toString()이 호출된다.
		System.out.println(b);
		
		int[][] a = {{1, 2, 3}};
		System.out.println(a);
		
		Random r = new Random();
		System.out.println(r);
		
		String s = new String("a");
		System.out.println(s);
		
		Integer iObj = new Integer(100);
		System.out.println(iObj);
		
		Date d = new Date();
		System.out.println(d);
	}
}













