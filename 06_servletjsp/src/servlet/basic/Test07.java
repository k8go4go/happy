package servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/basic/Test07")
public class Test07 extends HttpServlet {

	@Override
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		// post 방식일 경우 한글 파라미터 처리하기
		String method = request.getMethod();
		if ("POST".equals(method)) {
			request.setCharacterEncoding("utf-8");
		}
		
		String msg = request.getParameter("msg");
		
		out.println("<html>");
		out.println("  <body>");
		out.println("    <h1>");
		out.println(msg);
		out.println("    </h1>");
		out.println("  </body>");
		out.println("</html>");
	}
}












