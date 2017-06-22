package kr.co.mlec.board.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/writeForm")
public class WriteFormServlet extends HttpServlet {
	
	public WriteFormServlet() { }
	
	public void service(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
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














