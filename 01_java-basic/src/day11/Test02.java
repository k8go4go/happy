package day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("a.txt");
		// 컴파일 시점 예외(checked exception)
		// FileNotFoundException
		Scanner sc = new Scanner(f);
		
		String msg = null;
		System.out.println(msg.length());
	}
}










