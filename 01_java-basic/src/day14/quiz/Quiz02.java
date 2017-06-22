package day14.quiz;

import java.io.File;

public class Quiz02 {
	public static void main(String[] args) {
		/*
			file : a.txt
			file : b.txt
			directory : lec01
			file : Test.java	
		 */
		File f = new File("iodata/day14");
		if (f.exists()) {
			if (f.isDirectory()) {
				File[] arr = f.listFiles();
				for (File sub : arr) {
					String type = "directory";
					if (sub.isFile()) type = "file";
					
					System.out.println(type + " : " + sub.getName());
				}
				
				/*
				String[] arr = f.list();
				for (String name : arr) {
					File sub = new File("iodata/day14/" + name);
					String type = "directory";
					if (sub.isFile()) type = "file";
					
					System.out.println(type + " : " + name);
				}
				*/
			}
			else if (f.isFile()) {
				System.out.println("파일..");
			}
		}
	}
}








