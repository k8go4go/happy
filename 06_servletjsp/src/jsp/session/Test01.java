package jsp.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/jsp/session/Test01")
public class Test01 extends HttpServlet {

	@Override
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(
				"text/html; charset=utf-8");
		PrintWriter out =
				response.getWriter();
		
		// 세션 객체 얻기
		HttpSession session = request.getSession();
		// 설정된 세션 아이디 추출
		String id = session.getId();
		
		// 세션의 유효 시간 변경
		session.setMaxInactiveInterval(2);
		
		out.println("<h1>JSESSIONID : " + id + "</h1>");
		out.close();
	}
}

















