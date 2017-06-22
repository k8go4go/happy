package kr.co.mlec.board.servlet;

import java.io.PrintWriter;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;
import kr.co.mlec.board.mapper.BoardMapper;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.webserver.HttpServlet;
import kr.co.mlec.webserver.HttpServletRequest;
import kr.co.mlec.webserver.HttpServletResponse;

public class WriteServlet extends HttpServlet {
	
	private SqlSession session = null;
	private BoardMapper mapper = null;
	
	public WriteServlet() {
		session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(BoardMapper.class);
	}
	
	public void service(
			javax.servlet.http.HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("utf-8");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle(request.getParameter("title"));
		boardVO.setWriter(request.getParameter("writer"));
		boardVO.setContent(request.getParameter("content"));
		mapper.insertBoard(boardVO);
		session.commit();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>게시물 등록이 완료되었습니다.</h2>");
		out.println("<a href='list'>목록</a>");
		out.println("</body>");
		out.println("</html>");
	}
}














