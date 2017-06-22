package day14.quiz;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Quiz03 {
	public static void main(String[] args) {
		/*
		 *   파일 복사하는 프로그램 작성
		 *   a.txt 파일의 내용을 읽어서
		 *   acopy.txt 파일로 복사합니다.
		 */
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("iodata/day14/a.txt");
			fw = new FileWriter("iodata/day14/acopy.txt");
			while (true) {
				int ch = fr.read();
				if (ch == -1)
					break;
				fw.write(ch);
			}
			System.out.println("복사 완료");

		} catch (Exception e) {
			e.getStackTrace();
		} finally {
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
