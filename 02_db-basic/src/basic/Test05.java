package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test05 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"hr", 
					"hr"
			);
			String sql = "select no, title, writer, reg_date "
					   + "  from tb_board "
					   + " order by no desc ";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			// 데이터가 있을 동안 반복
			// 날짜 정보를 
			// 2017-05-02 10:11:23 출력되도록 코드 수정
			SimpleDateFormat sdf = 
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			while (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
//				Date regDate = rs.getDate("reg_date");
				Date regDate = rs.getTimestamp("reg_date");
				System.out.println(
					no + ", " +
				    title + ", " +
				    writer + ", " +
				    sdf.format(regDate)
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}





