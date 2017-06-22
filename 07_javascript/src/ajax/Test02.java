package ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/08_ajax/test02")
public class Test02 extends HttpServlet {

	@Override
	public void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(
				"text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>Ajax Success</h1>");
		out.close();
	}
}











