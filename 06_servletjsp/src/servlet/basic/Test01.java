package servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Test01 이 서블릿 클래스로 동작되기 위해서는
// Servlet 인터페이스 타입이어야 한다.
public class Test01 extends HttpServlet {
	
	public void service(
			HttpServletRequest request, 
			HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("  <head><title>서블릿 호출</title></head>");
		out.println("  <body>");
		out.println("    <h1>서블릿 호출 성공</h1>");
		out.println("  </body>");
		out.println("</html>");
		out.close();
	}
}











