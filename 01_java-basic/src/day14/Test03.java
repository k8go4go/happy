package day14;

import java.io.File;
import java.io.IOException;

public class Test03 {
	public static void main(String[] args) {
		File f = new File("iodata/day14/test.txt");
		if (f.exists()) {
			System.out.println("존재함");
			
			if (f.delete()) {
				System.out.println("파일 삭제됨");
			}
			else {
				System.out.println("파일 삭제 실패");
			}
		}
		else {
			System.out.println("존재하지 않음");
			try {
				if (f.createNewFile()) {
					System.out.println("생성 성공");
				}
				else {
					System.out.println("생성 실패");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}









