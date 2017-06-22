package kr.co.mlec.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.util.ConnectionFactory;
import kr.co.mlec.util.ConnectionPool;

/**
 * 게시물에 대한 데이터를 처리하는 DAO 클래스
 * @author Administrator
 */
public class BoardDAO {
	
	public List<BoardVO> selectBoard() {
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnectionPool.getConnection();

			String sql = "select no, title, writer, reg_date "
					   + "  from tb_board "
					   + " order by no desc ";

			pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			
			List<BoardVO> list = new ArrayList<>();
			while (rs.next()) {
				BoardVO board  = new BoardVO();
				board.setNo(rs.getInt("no"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setRegDate(rs.getDate("reg_date"));
				list.add(board);
			}
			
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		
		return null;
	}
	
	public BoardVO selectOneBoard(int no) {
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnectionPool.getConnection();
			String sql = "select no, title, writer, "
					   + "       content, reg_date  "
					   + "  from tb_board "
					   + " where no = ? ";

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, no);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				BoardVO board  = new BoardVO();
				board.setNo(rs.getInt("no"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getTimestamp("reg_date"));
				return board;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		return null;
	}

	public void insertBoard(BoardVO board) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnectionPool.getConnection();
			String sql = "insert into tb_board( "
					   + "    no, title, writer, content "
					   + ") values ( "
					   + "    s_board_no.nextval, ?, ?, ? "
					   + ")";

			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	public boolean updateBoard(BoardVO board) {
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnectionPool.getConnection();
			String sql = "update tb_board "
					   + "   set title = ?, "
					   + "       content = ? "
					   + " where no = ? ";

			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getNo());
			
			int cnt = pstmt.executeUpdate();
			if (cnt == 1) return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		
		return false;
	}
	public boolean deleteBoard(int no) {
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnectionPool.getConnection();
			String sql = "delete "
					   + "  from tb_board "
					   + " where no = ? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			int cnt = pstmt.executeUpdate();
			if (cnt == 1) return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		
		return false;
	}
	
}









