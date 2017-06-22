package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import board.vo.BoardVO;

public class Test06 {
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
			
			// rs의 데이터를 List에 옮기기
			List<BoardVO> list = new ArrayList<>();
			while (rs.next()) {
				
				BoardVO board = new BoardVO();
				board.setNo( rs.getInt("no") );
				board.setTitle( rs.getString("title") );
				board.setWriter( rs.getString("writer") );
				board.setRegDate( rs.getTimestamp("reg_date") );
				
				list.add(board);
			}
			
			for (BoardVO board : list) {
				System.out.println(
						board.getNo() + ", " +
						board.getWriter() + ", " + 			
						board.getTitle() + ", " +
						sdf.format(board.getRegDate())
				);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}






