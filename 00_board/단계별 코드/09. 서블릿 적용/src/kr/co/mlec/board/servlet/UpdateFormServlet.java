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

@WebServlet("/board/updateForm")
public class UpdateFormServlet extends HttpServlet {
	
	private SqlSession session = null;
	private BoardMapper mapper = null;
	
	public UpdateFormServlet() {
		session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(BoardMapper.class);
	}
	
	public void service(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int no = Integer.parseInt(request.getParameter("no"));
		BoardVO board = null;
		try {
			board = mapper.selectBoardByNo(no);
		} catch (Exception e) {
			new ServletException(e);
		}
		
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














