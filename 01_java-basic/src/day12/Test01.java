package day12;

import java.io.File;
import java.util.Date;

public class Test01 {
	public static void main(String[] args) {
		// 현재 시간 정보
		Date d1 = new Date();
		
		// 1970년 기준으로 시간이 설정
		Date d2 = new Date(1000);
		
		System.out.println(d1);
		System.out.println(d2);
		
		File f = new File("iodata/a.txt");
		// a.txt 파일의 마지막 수정시간
		long time = f.lastModified();
		Date d3 = new Date(time);
		System.out.println(
				"a.txt 파일의 마지막 수정시간 : " + time);
		System.out.println(
				"a.txt 파일의 마지막 수정시간 : " + d3);
	}
}














