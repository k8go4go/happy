package day02;

public class Test06 {
	public static void main(String[] args) {
		System.out.printf(
				"나의 이름은 %s 이고, 나이는 %d세 입니다.\n", "홍길동", 22);
		System.out.printf("|%5d|\n", 22);
		System.out.printf("|%-5d|\n", 22);
		System.out.printf("|%05d|\n", 22);
		System.out.printf("|%f|\n", 22.1);
		System.out.printf("|%.2f|\n", 22.1);
		System.out.printf("|%6.2f|\n", 22.1);
	}
}
