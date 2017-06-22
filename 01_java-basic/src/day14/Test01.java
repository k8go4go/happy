package day14;

import java.io.File;

public class Test01 {
	public static void main(String[] args) {
		// 디렉토리, 파일
		File f = new File("iodata/day14/lec01/1");
		boolean bool = f.exists();
		if (bool) {
			System.out.println("존재하는 경로");
		}
		else {
			System.out.println("존재하지 않는 경로");
			// f 가 가리키는 경로가 존재하지 않는 경우 생성
			if (f.mkdirs()) {
				System.out.println("경로 생성");
			}
			else {
				System.out.println("경로 생성 실패함");
			}
		}
	}
}















