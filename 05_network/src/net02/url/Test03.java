package net02.url;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/*
 *  부가 정보 넘겨주기 : Query, Parameter
 *  URL ? 뒤에 값 넘기기
 */
public class Test03 {
	
	
	public static void test01() {
		try {
			// 서버에 접근하기 위해서 URL 활용
			String path = 
				"http://localhost:8000/05_network_web/url/Test03?id=kim11&pass=1234";
			URL url = new URL(path);
			// 서버에 접근
			InputStream in = url.openStream();
			InputStreamReader isr = new InputStreamReader(in, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			while (true) {
				String line = br.readLine();
				if (line == null) break;
				
				System.out.println(line);
			}
			System.out.println("클라이언트 종료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void test02() {
		try {
			// 서버에 접근하기 위해서 URL 활용
//			String path = 
//				"http://localhost:8000/05_network_web/url/Test03?id=kim11&pass=1234";
			String path = 
					"http://localhost:8000/05_network_web/url/Test03";
			URL url = new URL(path);
			// POST 방식의 사용과 부가적인 기능을 제공하는 
			// HttpURLConnection 을 활용
			HttpURLConnection conn = 
					(HttpURLConnection)url.openConnection(); 
			
//			conn.setConnectTimeout(1000);
//			conn.setReadTimeout(1000);
			
			// 파라미터를 보내기 위해서 출력이 가능하도록 설정
			// 만약, true로 설정하지 않을 경우 출력시 에러발생
			conn.setDoOutput(true);
//			conn.setDoInput(true); // 서버에서 전송된 데이터를 읽기
			
			OutputStream out = conn.getOutputStream();
			out.write("id=kim&pass=1234".getBytes("utf-8"));
			out.close();
			
			InputStream in = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(in, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			while (true) {
				String line = br.readLine();
				if (line == null) break;
				
				System.out.println(line);
			}
			System.out.println("클라이언트 종료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) {
//		test01();   // GET 방식으로 호출
		test02();   // POST 방식으로 호출
	}
	
}









