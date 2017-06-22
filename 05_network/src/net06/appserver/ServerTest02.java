package net06.appserver;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest02 {
	public static void main(String[] args) {
		try {
			// port : 0 ~ 65535, 0 ~ 1024(시스템), 권장 : 5000번 이후
			ServerSocket ss = new ServerSocket(10001);
			System.out.println("클라이언트 요청 대기");
			while (true) {
				Socket s = ss.accept();
				// 클라이언트로 데이터 전송하기
				OutputStream out = s.getOutputStream();
				out.write("안녕하세요~".getBytes("utf-8"));
				out.close();
				System.out.println("데이터 전송 완료");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}




