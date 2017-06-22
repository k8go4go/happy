package day08;

public class Test01 {
	public static void main(String[] args) {
		System.out.println("문자열 성능 테스트");
		String s = new String("a");
		// 시간..
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			s += i;
		}
		// 시간..
		long end = System.currentTimeMillis();
		System.out.println("걸린시간 : " + (end - start) / 1000d);
		
		start = System.currentTimeMillis();
		StringBuffer s2 = new StringBuffer("a");
		for (int i = 0; i < 100000; i++) {
			s2.append(i);
		}
		// 시간..
		end = System.currentTimeMillis();
		
		System.out.println("걸린시간 : " + (end - start) / 1000d);
		
		
	}
}
