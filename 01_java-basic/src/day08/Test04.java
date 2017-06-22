package day08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) throws FileNotFoundException {
		// 스캐너 클래스를 활용, 파일의 내용 읽기
		// 이클립스에서 절대경로가 아닌 상대경로 방식으로 읽으면
		// 경로의 기준이 프로젝트가 된다.
		File f = new File("iodata/day08/test04.txt");
		Scanner sc = new Scanner(f);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			System.out.println(line);
		}
	}
}










