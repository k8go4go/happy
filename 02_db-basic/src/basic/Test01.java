package basic;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test01 {
	public static void main(String[] args) {
		
		try {
			// 1단계 : 드라이버 로딩
			// ojdbc6.jar 안에 있는 클래스명 입력
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
			
			// 2단계 : 연결 객체(Connection) 얻기
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"hr", 
					"hr"
			);
			System.out.println("연결 형성");
			System.out.println("con : " + con);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}






