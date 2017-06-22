package net06.appserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientTest04 {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 10001);
			// 서버에서 전송된 데이터 읽기
			InputStream in = s.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			OutputStream out = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);
			
			Scanner sc = new Scanner(System.in);
			
			while (true) {
				System.out.print("보낼 메세지 : ");
				String sendMsg = sc.nextLine();
				dos.writeUTF(sendMsg);
				
				if (sendMsg.equals("quit")) break;
				
				String recvMsg = dis.readUTF();
				System.out.println("에코 메세지 : " + recvMsg);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}




