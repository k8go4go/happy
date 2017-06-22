package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test08 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

			String sql = "delete "
					   + "  from tb_board "
					   + " where no = ? ";

			pstmt = con.prepareStatement(sql);

			// 실행하려는 SQL의 ? 자리에 값 설정
			// ? 자리의 index는 1부터 시작
			pstmt.setInt(1, 4);
			
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
