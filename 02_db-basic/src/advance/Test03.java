package advance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.ConnectionFactory;
import util.ConnectionPool;

public class Test03 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt1 = null, pstmt2 = null;

		try {
			con = ConnectionPool.getConnection();
			
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(pstmt1);
			ConnectionPool.releaseConnection(con);
		}
	}
}









