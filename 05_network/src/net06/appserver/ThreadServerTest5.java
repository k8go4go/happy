package net06.appserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class EchoThread extends Thread {
	
	private Socket client;
	
	public EchoThread(Socket client) {
		this.client = client;
	}
	
	// 스레드가 해야할 일을 run 메서드에 정의해야 한다.
	public void run() {
		try {

			// 접속한 클라이언트가 보내준 메세지 읽기
			InputStream in = client.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			// 접속한 클라이언트에게 메세지 전송하기
			OutputStream out = client.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);
			System.out.println("요청 : " + client);
			while  (true) {
				String msg = dis.readUTF();
				if (msg.equals("quit")) break;
				
				dos.writeUTF(msg);
			}
		} catch (Exception e) {
		}
	}
}
public class ThreadServerTest5 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(10001);
			while (true) {
				System.out.println("클라이언트 요청 대기");
				Socket client = server.accept();
				EchoThread echo = new EchoThread(client);
				echo.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}









