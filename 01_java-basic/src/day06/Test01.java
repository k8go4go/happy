package day06;

public class Test01 {
	public static void main(String[] args) {
		TestSub01 sub01 = 
				new TestSub01();
		TestSub01 sub02 = 
				new TestSub01();
		
		TestSub01 sub03 = sub02;
		sub01.val = 300;
		sub02.val = 500;
		sub03.val = 700;
		
		System.out.println(sub01.val);
		System.out.println(sub02.val);
		System.out.println(sub03.val);
	}
}












