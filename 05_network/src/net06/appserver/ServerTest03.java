package net06.appserver;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest03 {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(10001);
			System.out.println("클라이언트 요청 대기");
			while (true) {
				Socket s = ss.accept();
				OutputStream out = s.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				dos.writeUTF("안녕하세요~");
				
				out.close();
				System.out.println("데이터 전송 완료");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}




