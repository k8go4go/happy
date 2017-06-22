package day14;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Test09 {
	public static void main(String[] args) {
		FileInputStream fr = null;
		FileOutputStream fw = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		PrintStream ps = null;
		
		try {
			fr = new FileInputStream("iodata/day14/Kalimba.mp3");
			fw = new FileOutputStream("iodata/day14/Kalimba2.mp3");
			bis = new BufferedInputStream(fr);
			bos = new BufferedOutputStream(fw);
			
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
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}			
	}
}
