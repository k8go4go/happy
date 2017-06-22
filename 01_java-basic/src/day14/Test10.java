package day14;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Test10 {
	public static void main(String[] args) {
		try (
			FileInputStream fr = new FileInputStream("iodata/day14/Kalimba.mp3");
			FileOutputStream fw = new FileOutputStream("iodata/day14/Kalimba2.mp3");
			BufferedInputStream bis = new BufferedInputStream(fr);
			BufferedOutputStream bos = new BufferedOutputStream(fw);
		) {
			
			System.out.println("복사 시작");
			
			long s = System.currentTimeMillis();
			
			while (true) {
				int ch = bis.read();
				if (ch == -1)
					break;
				bos.write(ch);
			}
			long e = System.currentTimeMillis();
			System.out.println("복사 완료");
			System.out.println((e - s) / 1000d);	
			
			
		} catch (Exception e) {
			e.getStackTrace();
		} 
	}
}







