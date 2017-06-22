package day09.quiz;
/*
 *   iodata/quiz02.txt 파일의 내용을 읽어 아래와 같이 
 *   출력하는 프로그램 작성
 *   출력형식 >
 *   
 *   txt 파일
 *   ---------------------
 *   c.txt
 *   ---------------------
 *   java 파일
 *   ---------------------
 *   a.java
 *   b.java
 *   ---------------------
 *   xls 파일
 *   ---------------------
 *   존재하지 않습니다.
 *   ---------------------
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Quiz02 {
	public static void main(String[] args) throws FileNotFoundException {
		showFileByExt("txt");
		showFileByExt("java");
		showFileByExt("xls");
	}

	private static void showFileByExt(String ext) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File("iodata/day09/quiz02.txt"));
		boolean flag = false;
		StringBuffer sb = new StringBuffer();
		sb.append(ext + "파일\n");
		sb.append("-----------------------\n");
		while (sc.hasNextLine()) {
			String name = sc.nextLine();
			if (!name.endsWith(ext)) continue;
			
			sb.append(name + "\n");
			flag = true;
		}
		if (!flag) {
			sb.append("존재하지 않는 파일입니다.\n");
		}
		sb.append("-----------------------\n");
		System.out.println(sb);
		sc.close();
	}
}














