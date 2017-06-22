package kr.co.mlec.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {
	// Connection con = ConnectionFactory.getConnection();
	public static Connection getConnection() 
			throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", 
				"hr", 
				"hr"
		);
	}
	
	public static void close(PreparedStatement pstmt) {
		close(pstmt, null);
	}
	public static void close(
			PreparedStatement pstmt, Connection con) {
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










