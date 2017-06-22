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

@WebServlet("/board/commentDelete")
public class CommentDeleteServlet extends HttpServlet {

	private SqlSession session = null;
	private BoardMapper mapper = null;
	
	public CommentDeleteServlet() {
		session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(BoardMapper.class);
	}
	
	@Override
	public void service(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			int no = Integer.parseInt(request.getParameter("no"));
			int commentNo = Integer.parseInt(request.getParameter("commentNo"));
			
			mapper.deleteBoardComment(commentNo);
			session.commit();
			
			response.sendRedirect("detail?no=" + no);
		
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}











