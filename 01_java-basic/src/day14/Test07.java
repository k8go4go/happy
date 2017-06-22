package day14;

import java.io.FileWriter;
import java.io.IOException;

public class Test07 {
	public static void main(String[] args) {
		FileWriter fos = null;
		try {
			// 파일이 존재하지 않으면 생성
			// 만약 파일이 있다면 자동 덮어쓰기 됨..
			// 내용을 추가하고 싶다면
			// 생성할 때 append 옵션값을 추가
			fos = new FileWriter("iodata/day14/a1.txt", true);
			fos.write('a');
			fos.write('b');
			fos.write('c');
			System.out.println("파일 출력 완성");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}













