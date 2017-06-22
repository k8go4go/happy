package day14;

import java.io.FileReader;
import java.io.IOException;

public class Test06 {
	public static void main(String[] args) {
		
		FileReader fis = null;
		try {
			fis = new FileReader("iodata/day14/a.txt");
			while (true) {
				// -1이라면 파일이 끝났어요..
				int ch = fis.read();
				if (ch == -1) break;
				System.out.print((char)ch);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// 자원 정리
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}








