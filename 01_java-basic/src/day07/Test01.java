package day07;

import java.util.Random;

public class Test01 {
	public static void main(String[] args) {
		Sub01 sub = new Sub01();
		sub.method01();
		sub.method02(10);
		int i = 100;
		sub.method02(i);
		sub.method03(1, 2);
		sub.method04('a');
		sub.method05("a");
		int[] arr = 
				new int[3];
		sub.method06(arr);
		
		sub.method06(new int[3]);
		
		Random r = new Random();
		sub.method07(r);
		
		sub.method07(new Random());
	}
}












