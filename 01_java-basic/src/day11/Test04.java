package day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		System.out.println(1);
		String msg = null;
		System.out.println(2);
		try {
			System.out.println(1 / 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			System.out.println(1);
			File f = new File("a.txt");
			Scanner sc = new Scanner(f);
			System.out.println(2);
		} 
		catch (FileNotFoundException e) {
			System.out.println(3);
		}
		System.out.println(4);
	}
}













