package day14;

import java.io.File;

public class Test02 {
	public static void main(String[] args) {
		File f = new File("iodata/day14");
		if (f.exists()) {
			if (f.isDirectory()) {
				System.out.println("디렉토리임..");
				String[] arr = f.list();
				for (String name : arr) {
					System.out.println("name : " + name);
				}
			}
			else if (f.isFile()) {
				System.out.println("파일..");
			}
		}
	}
}








