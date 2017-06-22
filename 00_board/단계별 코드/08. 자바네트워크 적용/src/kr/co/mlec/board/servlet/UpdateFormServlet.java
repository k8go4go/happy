package kr.co.mlec.board.servlet;

import java.io.PrintWriter;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;
import kr.co.mlec.board.mapper.BoardMapper;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.webserver.HttpServlet;
import kr.co.mlec.webserver.HttpServletRequest;
import kr.co.mlec.webserver.HttpServletResponse;

public class UpdateFormServlet extends HttpServlet {
	
	private SqlSession session = null;
	private BoardMapper mapper = null;
	
	public UpdateFormServlet() {
		session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(BoardMapper.class);
	}
	
	public void service(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int no = Integer.parseInt(request.getParameter("no"));
		BoardVO board = mapper.selectBoardByNo(no);
		
		out.println("<html>");
		out.println("<head><title>게시판</title></head>");
		out.println("<body>");		
		out.println("<form action='update' method='post'>");
		out.println("  <input type='hidden' name='no' value='" + no + "'>");
		out.println("  <table>");
		out.println("    <tr>");
		out.println("      <td>제목</td>");
		out.println("      <td><input type='text' name='title' value='" + board.getTitle() + "' /></td>");
		out.println("    </tr>");
		out.println("    <tr>");
		out.println("      <td>글쓴이</td>");
		out.println("      <td><input type='text' name='writer' readonly value='" + board.getWriter() + "' /></td>");
		out.println("    </tr>");
		out.println("    <tr>");
		out.println("      <td>내용</td>");
		out.println("      <td><textarea name='content' rows='5' cols='70'>" + board.getContent() + "</textarea></td>");
		out.println("    </tr>");
		out.println("  </table>");
		out.println("  <input type='submit' value='수정' />");
		out.println("</form>");
		out.println("<a href='list'>목록</a>");
		out.println("</body>");
		out.println("</html>");
	}
}














