package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test09 {
	public static void main(String[] args) {
		// insert 문을 동적으로 처리
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

			String sql = "insert into tb_board( "
					   + "    no, title, writer, content "
					   + ") values ( "
					   + "    s_board_no.nextval, ?, ?, ? "
					   + ")"; 
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, "동적인 값 입력");
			pstmt.setString(2, "홍길동");
			pstmt.setString(3, "동적으로 입력하기 테스트");
			
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개의 행이 처리됨");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
