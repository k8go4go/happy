package kr.co.mlec.board.servlet;

import java.io.PrintWriter;

import kr.co.mlec.webserver.HttpServlet;
import kr.co.mlec.webserver.HttpServletRequest;
import kr.co.mlec.webserver.HttpServletResponse;

public class WriteFormServlet extends HttpServlet {
	
	public WriteFormServlet() { }
	
	public void service(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head><title>게시판</title></head>");
		out.println("<body>");		
		out.println("<form action='write' method='post'>");
		out.println("  제목 : <input type='text' name='title' /><br>");
		out.println("  글쓴이 : <input type='text' name='writer' /><br>");
		out.println("  내용 : <br>");
		out.println("  <textarea name='content' rows='5' cols='70'></textarea><br>");
		out.println("  <input type='submit' value='등록' />");
		out.println("</form>");
		out.println("<a href='list'>목록</a>");
		out.println("</body>");
		out.println("</html>");
	}
}














