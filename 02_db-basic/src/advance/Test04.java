package advance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.ConnectionFactory;
import util.ConnectionPool;

public class Test04 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt1 = null, pstmt2 = null;

		try {
			con = ConnectionPool.getConnection();
			// 자동 커밋 상태 변경하기
			con.setAutoCommit(false);
			
			String sql1 = "update tb_account "
					    + "   set money = money - 5000 "
					    + " where id = 'a' ",
				   sql2 = "update tb_account "
					    + "   set mney = money + 5000 "
					    + " where id = 'b' ";

			pstmt1 = con.prepareStatement(sql1);
			pstmt1.executeUpdate();
			
			pstmt2 = con.prepareStatement(sql2);
			pstmt2.executeUpdate();
			
			// 커밋하기
			con.commit();
			System.out.println("정상 처리됨..");
		} catch (Exception e) {
			System.out.println("데이터 롤백됨..");
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(pstmt1);
			ConnectionFactory.close(pstmt2);
			ConnectionPool.releaseConnection(con);
		}
	}
}










