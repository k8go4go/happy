package day02;

public class Test11 {
	public static void main(String[] args) {
		int i = 1;
		for (; i < 10; i++) {
			System.out.println(i);
		}
		// i = 10인 상태로 넘어온다.
		
		for (i = 1; i < 10; i++) {
			System.out.println(i);
		}
	}
}
