package net06.appserver;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientTest03 {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 10001);
			// 서버에서 전송된 데이터 읽기
			InputStream in = s.getInputStream();
			DataInputStream dis = new DataInputStream(in);	
			String data = dis.readUTF();
			System.out.println("서버 데이터 : " + data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}







