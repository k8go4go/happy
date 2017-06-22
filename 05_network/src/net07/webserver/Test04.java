package net07.webserver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test04 {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(10001);
			while (true) {
				Socket s = ss.accept();
				InputStream in = s.getInputStream();
				// http://localhost:10001/05_network/Test03?id=a&pass=b
				/*
				 *   화면에 아래와 같이 출력되도록 
				 *   HttpServletRequest 클래스 작성
				 *   
				 *   요청메서드 : GET
				 *   요청URI : /05_network/Test03
				 *   요청 파라미터
				 *   id : a
				 *   pass : b
				 */
				// reqStartLine
				// GET /05_network_web/Test03?id=aaa&pass=1111 HTTP/1.1
				HttpServletRequest request = new HttpServletRequest(in); 
				// method : GET	
				String method = request.getMethod();
				// URI  : /05_network_web/Test03
				String uri = request.getRequestUri();
				// QueryString : id=aaa&pass=1111
				String queryString = request.getQueryString();
				// id : aaa
				String id = request.getParameter("id");
				// pass : 1111
				String pass = request.getParameter("pass");
				
				System.out.println("method : " + method);
				System.out.println("uri : " + uri);
				System.out.println("queryString : " + queryString);
				System.out.println("id : " + id);
				System.out.println("pass : " + pass);
				
				String result = "성공";
				
				String startLine = "HTTP/1.1 200 OK\r\n";
				String headers = "Cache-Control: no-cache\r\n"
						       + "Content-Type: text/html; charset=utf-8\r\n"
						       + "Content-Length: " + result.getBytes().length + "\r\n\r\n";
				String body = result.toString();
				String data = startLine + headers + body;
				OutputStream out = s.getOutputStream();
				out.write(data.getBytes());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
