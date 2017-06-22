package net06.appserver;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest01 {
	public static void main(String[] args) {
		try {
			// tcp 소켓 활용 : 서버역활 API(ServerSocket)
			ServerSocket ss = new ServerSocket(10001);
			// 클라이언트가 요청했을때 응답을 해줘야 한다.
			// 클라이언트 요청 대기
			// accept는 요청이 들어올때 까지 블락된다.
			System.out.println("서버 구동 후 클라이언트 요청 대기중");
			while (true) {
				Socket s = ss.accept();
				InetAddress inet = s.getInetAddress();
				System.out.println("요청 : " + inet);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}










