package day14;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test05 {
	public static void main(String[] args) {
		InputStream in = System.in;
		try {
			InputStreamReader isr = new InputStreamReader(in); 
			System.out.println((int)'\r');
			System.out.println((int)'\n');
			System.out.println("입력 연습");
			while (true) {
				int ch = isr.read();
				System.out.print((char)ch);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
