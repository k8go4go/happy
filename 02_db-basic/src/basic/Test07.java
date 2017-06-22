package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test07 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			// 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"hr", 
					"hr"
			);
			System.out.println("연결 형성");
			
			// 3단계 : 쿼리 작성
			String sql = "delete from tb_board where no = 17";
			
			// 4단계 
			// : 작성된 SQL 실행하기 위한 객체 얻기
			// : Statement  
			// : PreparedStatement - 수행하려는 SQL 문법 체크가 된
			pstmt = con.prepareStatement(sql);
			
			// 5단계 - SQL 실행하기
			// : select 절 수행시 - ResultSet executeQuery()
			// : select 절이 아닌 문장을 수행시 - int executeUpdate() 
			int cnt = pstmt.executeUpdate();
			
			// 6단계 - 결과처리
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













