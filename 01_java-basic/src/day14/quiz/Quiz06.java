package day14.quiz;

import java.io.*;

class Quiz06 {
	public static void main(String args[]) {
		File f = new File("iodata");
		viewDir(f, 0);
  		/*
  		아래와 같이 출력되도록 viewDir 메서드 기능 구현 
  		iodata 폴더 하위의 구조
  		------------------------------
		a.txt
		day08
		      test04.txt
		day09
		      quiz02.txt
		      stream.txt
		day13
		      quiz02.txt
		      quiz06.txt
		day14
		      a.txt
		      a1.txt
		      b.txt
		      Kalimba.mp3
		      Kalimba1.mp3
		      Kalimba2.mp3
		      lec01
		            1
		      Test.java  	
  		------------------------------
  		 */
  	}
 	private static void viewDir(File dirFile, int depth){
 		String lists[] = dirFile.list();
 		for(String name : lists) {
 			for (int spaces = 0; spaces < depth; spaces++)
 				System.out.print("   ");
 			System.out.println(name);
 			
 			File child = new File(dirFile, name);
 			if(child.isDirectory()) {
 				viewDir(child, depth+1);
 			}
 		}
	}
}