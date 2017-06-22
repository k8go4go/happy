package day11;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test05 {
	public static void main(String[] args) {
		
		System.out.println(1);
		int errorType = 0;
		try {
			FileReader fr = new FileReader("a.txt");
			fr.read();
		
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		/*
		catch (FileNotFoundException e) {
			e.printStackTrace();
			errorType = 1;
		} 
		catch (IOException e) {
			e.printStackTrace();
			errorType = 2;
		}
		*/
		System.out.println(errorType);
		
	}
}










