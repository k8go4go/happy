package net01.ip;

import java.net.InetAddress;

public class Test01 {
	public static void main(String[] args) {
		try {
		
			// 아이피 주소
			InetAddress local = InetAddress.getLocalHost();
			System.out.println(local);
			
			System.out.println(local.getHostName());
			System.out.println(local.getHostAddress());
			
			InetAddress bit = 
					InetAddress.getByName("www.bitjobedu.co.kr");
			
			System.out.println(bit.getHostName());
			System.out.println(bit.getHostAddress());
			
			System.out.println("============================");
			InetAddress[] navers = 
					InetAddress.getAllByName("www.naver.com");
			for (InetAddress inet : navers) {
				System.out.println(inet.getHostAddress());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}








