package day14;

import java.io.File;
import java.util.Date;

public class Test04 {
	public static void main(String[] args) {
		File f = new File("iodata/day14/a.txt");
		// byte 단위
		long len = f.length();
		System.out.println("파일 크기 : " + len);
		
		// 파일의 마지막 수정된 시간
		long time = f.lastModified();
		Date d = new Date(time);
		System.out.println(d);
		
		// 파일명
		String name = f.getName();
		// 부모 디렉토리명
		String pName = f.getParent();
		// 전체 경로
		String path = f.getPath();
		System.out.println("name : " + name);
		System.out.println("parent name : " + pName);
		System.out.println("path : " + path);
	}
}









