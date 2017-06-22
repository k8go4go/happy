package day08;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Test03 {
	private static void call() {
		System.out.println("테스트 중...");
	}
	
	
	public static void main(String[] args) {
//		Test03.call();

		String s = 1 + "";
		String s2 = 11.1 + "";
		
		// 문자열 변환하기
		String s3 = String.valueOf(1);
		String s4 = String.valueOf(1.1);
		
		
		/*
		String s = "Hello Java";
		int age = 33;
		String name = "홍길동";
				
		String msg = "나이 : " + age + ", 이름 : " + name;
		String msg1 = 
				String.format("나이 : %d, 이름 : %s", age, name);
		
		System.out.println(msg1);
		System.out.println(msg1);
		*/
		
		/*
		s = "     abc def     ";
		System.out.println("|" + s + "|");
		s = s.trim();
		System.out.println("|" + s + "|");
		s = s.replace(" ", "");
		System.out.println("|" + s + "|");
		*/
		
		/*
		s = "33:홍길동:서울특별시:hong@a.com";
		String[] arr = s.split(":");

		System.out.println("나이 : " + arr[0]);
		System.out.println("이름 : " + arr[1]);
		System.out.println("주소 : " + arr[2]);
		System.out.println("이메일 : " + arr[3]);
		*/
		
		/*
		// 문자열의 추출
		String s2 = s.substring(2);
		System.out.println(s2);
		
		String s3 = s.substring(1, 4);
		System.out.println(s3);
		*/
		
		/*
		// 문자열의 내용 변환
		String s2 = s.toLowerCase();
		System.out.println(s2);
		
		String s3 = s.toUpperCase();
		System.out.println(s3);
		
		String s4 = s.replace("ello", "i");
		System.out.println(s4);
		
		String s5 = s.replaceAll("ello", "i");
		System.out.println(s5);
		
		s = "1a2b3c123d4e5f6";
		// 숫자를 별로 표시 : *a*b*c***d*e*f*
		for (int i = 0; i < 10; i++) {
			s = s.replace(i + "", "*");
		}
		System.out.println(s);
		
		s = "1akKKK2b3TTTc1TEST23d4e5f6";
		for (char c = 'a'; c <= 'z'; c++) {
			s = s.replace(c + "", "*");
		}
		for (char c = 'A'; c <= 'Z'; c++) {
			s = s.replace(c + "", "*");
		}
		System.out.println(s);
		
		s = "1akKKK2b3TTTc1TEST23d4e5f6";
//		s = s.replaceAll("[0-9]", "*");
		s = s.replaceAll("[a-zA-Z]", "*");
		System.out.println(s);
		*/
		
		/*
		// 문자열의 내용을 배열로 변환
		char[] arr = s.toCharArray();
		System.out.println(Arrays.toString(arr));
		
		try {
			byte[] bArr = s.getBytes("utf-8");
			System.out.println(Arrays.toString(bArr));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		*/
		
		/*
		boolean flag = s.startsWith("Hello");
		System.out.println(flag);
		
		flag = s.endsWith("Java");
		System.out.println(flag);
		*/
		
		/*
		// 문자열안에 특정 문자열이 있는지 확인
		boolean flag = s.contains("Java");
		System.out.println(flag);

		int index = s.indexOf("l");
		System.out.println(index);
		
		// 3번째 인덱스부터 "l"을 찾아라..
		index = s.indexOf("l", 3);
		System.out.println(index);
		
		index = s.lastIndexOf("a");
		System.out.println(index);
		
		index = s.lastIndexOf("a", 8);
		System.out.println(index);
		
		
		
		// 찾지 못할 경우 -1 반환
		index = s.indexOf("tv");
		System.out.println(index);
		 */
		
		
		
		/*
		boolean flag = s.equals("hello java");
		System.out.println(flag);
		
		// 대소문자 무시 내용 비교
		flag = s.equalsIgnoreCase("hello java");
		System.out.println(flag);
		*/
		
		/*
		// int length()
		int len = s.length();
		System.out.println(len);
		
		System.out.println(s.length());
		
		// char	charAt(int index)
		char ch = s.charAt(0);
		System.out.println(ch);
		System.out.println(s.charAt(1));
		
		// J를 출력
		System.out.println(s.charAt(6));
		
		System.out.println(s.charAt(10));
		*/
	}
}
