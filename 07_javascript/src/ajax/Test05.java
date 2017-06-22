package ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/08_ajax/test05")
public class Test05 extends HttpServlet {
	@Override
	public void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(
				"text/xml; charset=utf-8");
		PrintWriter out = response.getWriter();
		String xml = "";
		xml += "<members>";
		xml += "  <member>";
		xml += "    <name>윤균상</name>";
		xml += "    <age>33</age>";
		xml += "  </member>";
		xml += "  <member>";
		xml += "    <name>김삼중</name>";
		xml += "    <age>44</age>";
		xml += "  </member>";
		xml += "</members>";
		
		out.println(xml);
		out.close();
	}
}











