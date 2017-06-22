package day02;

public class Test10 {
	public static void main(String[] args) {
		int outer = 1;
		{
			int inner = 2;
			System.out.println("inner = " + inner);
			System.out.println("outer = " + outer);
//			int outer = 5;
		}
//		System.out.println("inner = " + inner);
		int inner = 3;
		System.out.println("inner = " + inner);
		System.out.println("outer = " + outer);
	}
}
