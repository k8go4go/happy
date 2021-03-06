package kr.co.mlec.board.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;
import kr.co.mlec.board.mapper.BoardMapper;
import kr.co.mlec.board.vo.BoardCommentVO;

@WebServlet("/board/commentRegist")
public class CommentRegistServlet extends HttpServlet {

	private SqlSession session = null;
	private BoardMapper mapper = null;
	
	public CommentRegistServlet() {
		session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(BoardMapper.class);
	}
	
	@Override
	public void service(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		try {
			int no = Integer.parseInt(request.getParameter("no"));
			
			// 게시판과 파일 테이블에 저장할 글번호를 조회
			BoardCommentVO comment = new BoardCommentVO();
			comment.setNo(no);
			comment.setContent(request.getParameter("content"));
			comment.setUserId(request.getParameter("userId"));
			
			// 게시물 저장 처리 부탁..
			mapper.insertBoardComment(comment);
			session.commit();
			
			response.sendRedirect("detail?no=" + no);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}











