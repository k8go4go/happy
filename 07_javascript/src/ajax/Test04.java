package ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/08_ajax/test04")
public class Test04 extends HttpServlet {

	@Override
	public void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(
				"text/html; charset=utf-8");
		
		// 파라미터 추출
		String msg = request.getParameter("msg");
		
		PrintWriter out = response.getWriter();
		out.println("<h1>파라미터 : " + msg + "</h1>");
		out.close();
	}
	
	@Override
	public void doPost(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(
				"text/html; charset=utf-8");
		
		// 파라미터 추출
		String msg = request.getParameter("msg");
		
		PrintWriter out = response.getWriter();
		out.println("<h1>파라미터 : " + msg + "</h1>");
		out.close();
	}
}











