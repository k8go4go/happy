package quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import board.vo.BoardVO;

public class Quiz01 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
						
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"hr", 
					"hr"
			);
			
			String sql = "select no, title, writer, reg_date "
					+ "from tb_board "
					+ "order by no desc";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			
			// 데이터가 있을 동안 반복 
			// 날짜 정보를 
			// 2017-05-02 10:11:23 출력되도록 코드 수정
			List<BoardVO> list = new ArrayList<>();
			while (rs.next()) {
				BoardVO b = new BoardVO();
				b.setNo(rs.getInt("no"));
				b.setTitle(rs.getString("title"));
				b.setWriter(rs.getString("writer"));
				b.setRegDate(rs.getTimestamp("reg_date"));
				list.add(b);
			}
			
			// rs의 데이터를 List에 옮기기

			
			// 입력된 데이터 출력
			for (BoardVO d : list) {
				System.out.println(d.getNo() + " " + d.getTitle() + " " + d.getWriter());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
