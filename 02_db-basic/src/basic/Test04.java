package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test04 {
	public static void main(String[] args) {
		// 임의의 게시물의 내용과 제목을 변경하는 프로그램 작성
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"hr", 
					"hr"
			);
			String sql = "update tb_board "
					   + "   set title = '변경된 제목', "
					   + "       content = '수정된 내용' "
					   + " where no = 21 "; 
			PreparedStatement pstmt = con.prepareStatement(sql);
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개의 행이 처리됨");
					
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
