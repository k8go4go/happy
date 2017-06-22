package servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/basic/Test06")
public class Test06 extends HttpServlet {

	@Override
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// 사용자에게 데이터 전송
		response.setContentType("text/html; charset=utf-8"); 
//		response.setContentType("text/html"); 
//		response.setContentType("text/plain"); 
		
		// 바이트 단위 출력을 위한 메서드
//		OutputStream os = response.getOutputStream();
		
		// 출력객체 얻기
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("  <body>");
		out.println("    <h1>success 성공</h1>");
		out.println("  </body>");
		out.println("</html>");
		out.close();
	}
	
}










