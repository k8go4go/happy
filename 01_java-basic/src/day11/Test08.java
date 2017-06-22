package day11;

import java.io.FileNotFoundException;
import java.io.FileReader;

class Alba {
	public void work() throws FileNotFoundException {
		try {
			FileReader fr = new FileReader("a.txt");
		} catch (FileNotFoundException e) {
			System.out.println("직접 예외 정리...");	
			throw e;
//			throw new FileNotFoundException("a.txt 파일 없음");
		}
	}
}
public class Test08 {
	public static void main(String[] args) {
		Alba alba = new Alba();
		try {
			alba.work();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
