package kr.heartof.util.test;

public class FileExtensionTest {
	public static void main(String[] args) {
		System.out.println(getExtionFileName("1.jpg"));
	}
	
	private static String getExtionFileName(String fileName) {
		int lastIndex = fileName.lastIndexOf(".");
		
		return fileName.substring(lastIndex+1);
	}
}
