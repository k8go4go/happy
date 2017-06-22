package net06.appserver;

import java.net.Socket;

public class ClientTest01 {
	public static void main(String[] args) {
		try {
			// tcp 소켓을 활용 : Socket
			Socket s = new Socket("localhost", 10001);
			System.out.println("서버 접속 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
