package day07;

import java.util.Arrays;

public class Test03 {
	public static void main(String[] args) {
		Sub03 sub = new Sub03();
		int result = sub.add(100, 200);
		System.out.println("합 : " + result);
		
		result = sub.cal(1, 100, 200);
		System.out.println("합 : " + result);
		System.out.println("합 : " + sub.cal(1, 100, 200));
		int[] arr = sub.makeNumbers();
		System.out.println(Arrays.toString( arr ));
		System.out.println(Arrays.toString( sub.makeNumbers() ));
		
		System.out.println(Arrays.toString( sub.makeNumbers(10) ));

		System.out.println(Arrays.toString( sub.makeNumbers(6, 45) ));
		
	}
}














