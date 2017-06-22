package day02;

public class Test01 {
	public static void main(String[] args) {
		// 매개변수 공간의 크기를 확인
		// 배열의 이름.length
		System.out.println(args.length);

		// 공간이 2개가 있을 경우에만 화면에 내용을 출력
		// 조건문 : if
		// if (조건식) { 조건식이 참일 경우 수행하는 블럭 }
		// 조건식 : args.length == 2
		if (args.length == 2) {
			System.out.println(args[0]);
			// World 출력
			System.out.println(args[1]);
		}
		
		
		
	}
}
