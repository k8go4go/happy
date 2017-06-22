package kr.co.mlec.board.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;
import kr.co.mlec.board.mapper.BoardMapper;
import kr.co.mlec.board.vo.BoardVO;

@WebServlet("/board/write")
public class WriteServlet extends HttpServlet {
	
	private SqlSession session = null;
	private BoardMapper mapper = null;
	
	public WriteServlet() {
		session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(BoardMapper.class);
	}
	
	public void service(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle(request.getParameter("title"));
		boardVO.setWriter(request.getParameter("writer"));
		boardVO.setContent(request.getParameter("content"));
		try {
			mapper.insertBoard(boardVO);
			session.commit();
		} catch (Exception e) {
			new ServletException(e);
		}
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>게시물 등록이 완료되었습니다.</h2>");
		out.println("<a href='list'>목록</a>");
		out.println("</body>");
		out.println("</html>");
	}
}














