/*
 * 출력형식 > 
 * 도메인 주소를 입력하세요 : http://www.naver.com
 * 도메인 주소는 www로 시작해야 합니다.
 * 
 * 도메인 주소를 입력하세요 : www.naver.com
 * www.naver.com 에서 사용하는 주소정보
 * ---------------------------------------
 * 220.189.20.111 
 * 220.189.20.64 
 * ---------------------------------------
 * 
 * 도메인 주소를 입력하세요 : www.aidfjeijf.com
 * 존재하지 않는 도메인 주소 입니다.
 * 
 * 도메인 주소를 입력하세요 : quit
 * 프로그램을 종료합니다.
 * 
 */
package quiz;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Quiz01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println();
			System.out.print("도메인 주소를 입력하세요 : ");
			String input = sc.nextLine();
			if (input.equals("quit")) {
				break;
			}
			if (input.startsWith("www.") == false) {
				System.out.print("도메인 주소는 www로 시작해야 합니다.");
				continue;
			}
			try {
				InetAddress[] inets = InetAddress.getAllByName(input);
				
				System.out.println(input + "에서 사용하는 주소 정보");
				System.out.println("-----------------------------------");
				for (InetAddress inet : inets) {
					System.out.println(inet.getHostAddress());
				}
				System.out.println("-----------------------------------");
				
			} catch (UnknownHostException e) {
				System.out.println("존재하지 않는 도메인 주소 입니다.");
			}
			
		}
		System.out.println("프로그램을 종료합니다.");		
	}
}
