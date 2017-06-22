package day11;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test07 {
	public static void main(String[] args) {
		
		/*
		 *   예외와 상관없이 실행하는 블럭(무조건)
		 */
		try {
			System.out.println(1);
			FileReader fr = new FileReader("a.txt");
			System.out.println(2);
		} 
		catch (FileNotFoundException e) {
			System.out.println(3);
//			return;
			System.exit(0);
		}
		finally {
			// 파일, 데이터베이스, 네트워크
			System.out.println(4);
		}
		System.out.println(5);
	}
}










