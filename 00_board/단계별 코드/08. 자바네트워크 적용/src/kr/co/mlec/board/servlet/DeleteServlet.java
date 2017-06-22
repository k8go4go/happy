package kr.co.mlec.board.servlet;

import java.io.PrintWriter;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;
import kr.co.mlec.board.mapper.BoardMapper;
import kr.co.mlec.webserver.HttpServlet;
import kr.co.mlec.webserver.HttpServletRequest;
import kr.co.mlec.webserver.HttpServletResponse;

public class DeleteServlet extends HttpServlet {
	
	private SqlSession session = null;
	private BoardMapper mapper = null;
	
	public DeleteServlet() {
		session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(BoardMapper.class);
	}
	
	public void service(
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int no = Integer.parseInt(request.getParameter("no"));
		mapper.deleteBoard(no);
		session.commit();
		
		out.println("<html>");
		out.println("<body>");
		out.println("게시물 삭제가 완료되었습니다.");
		out.println("<a href='list'>목록</a>");
		out.println("</body>");
		out.println("</html>");
	}
}
