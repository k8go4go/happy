package net02.url;

import java.net.URL;

public class Test01 {
	public static void main(String[] args) {
		try {
			// URL 과 연관된 기능 살펴보기
			URL url = new URL(
				"http://www.naver.com:8080/test.do?msg=hello" 
			);
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			System.out.println(url.getPort());
			System.out.println(url.getFile());
			System.out.println(url.getPath());
			System.out.println(url.getQuery());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}







