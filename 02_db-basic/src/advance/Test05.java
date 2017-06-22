package advance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import util.ConnectionFactory;
import util.ConnectionPool;

public class Test05 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String tbName = "tb_board";
			String sql = "select * from " + tbName;
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			// result의 결과 컬럼 수를 반환
			int count = rsmd.getColumnCount();
			System.out.println("컬럼 수 : " + count);
			for (int i = 1; i <= count; i++) {
				String cName = rsmd.getColumnName(i);
				String tName = rsmd.getColumnTypeName(i);
				System.out.println(cName + "\t" + tName);
			}
			
			while (rs.next()) {
				rs.getString("no");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
	}
}















