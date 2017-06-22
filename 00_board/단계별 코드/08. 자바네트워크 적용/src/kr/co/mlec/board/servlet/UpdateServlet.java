package kr.co.mlec.board.servlet;

import java.io.PrintWriter;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;
import kr.co.mlec.board.mapper.BoardMapper;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.webserver.HttpServlet;
import kr.co.mlec.webserver.HttpServletRequest;
import kr.co.mlec.webserver.HttpServletResponse;

public class UpdateServlet extends HttpServlet {
	
	private SqlSession session = null;
	private BoardMapper mapper = null;
	
	public UpdateServlet() {
		session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(BoardMapper.class);
	}
	
	public void service(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		
		BoardVO boardVO = new BoardVO();
		boardVO.setNo(Integer.parseInt(request.getParameter("no")));
		boardVO.setTitle(request.getParameter("title"));
		boardVO.setContent(request.getParameter("content"));
		mapper.updateBoard(boardVO);
		session.commit();
		
		out.println("<html>");
		out.println("<body>");
		out.println("게시물 수정이 완료되었습니다.");
		out.println("<a href='list'>목록</a>");
		out.println("</body>");
		out.println("</html>");
	}
}







