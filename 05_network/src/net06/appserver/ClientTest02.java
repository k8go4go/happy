package net06.appserver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientTest02 {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 10001);
			// 서버에서 전송된 데이터 읽기
			InputStream in = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(in, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			System.out.println(line);
			/*
			byte[] buffer = new byte[1024];
			int count = in.read(buffer);
			String msg = new String(buffer, 0, count);
			System.out.println("서버에서 전송된 데이터 : " + msg);
			*/
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}







