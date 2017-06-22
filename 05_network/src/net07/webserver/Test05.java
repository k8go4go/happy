package net07.webserver;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Test05 {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(10001);
			while (true) {
				Socket s = ss.accept();
				
				HttpServletResponse response = 
						new HttpServletResponse(s.getOutputStream());
				response.setContentType("text/html; charset=utf-8");
				
				// 사용자 화면에 출력하려는 데이터 처리
				PrintWriter out = response.getWriter();
				out.println("응답 객체 활용<br>");
				for (int i = 1; i <= 10; i++) {
					out.println(i + "<br>");
				}
				
				response.send();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}








