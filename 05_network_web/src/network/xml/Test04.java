package network.xml;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/xml/Test04")
public class Test04 extends HttpServlet {
	private int no = 0;
	public void service(HttpServletRequest request, 
			HttpServletResponse response) 
			throws IOException, ServletException {
		response.setContentType("text/xml; charset=utf-8");

		request.setCharacterEncoding("utf-8");
		
		// 192.168.0.20
		// parameter :  name(본인 이름)
		String name = request.getParameter("name");
		System.out.println("name : " + name);
		if (name == null) name = "입력안됨";
		
		PrintWriter out = response.getWriter();
		out.write("<result>");
		for (int i = 0; i < name.length(); i++) {
			out.write("<name>" + name.charAt(i) + "</name>");
		}
		out.write("</result>");
		out.close();
	}
}












