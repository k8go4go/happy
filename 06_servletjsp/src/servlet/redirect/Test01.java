package servlet.redirect;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/redirect/Test01")
public class Test01 extends HttpServlet {
	@Override
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// sendRedirect 방식은 데이터 공유가 안된다.
		// 요청이 두번 발생하기 때문에 Request 공유가 불가능
		// 데이터 공유
		String msg = "공유 테스트";
		Date d = new Date();
		request.setAttribute("msg", msg);
		request.setAttribute("d", d);
		
		// 페이지 이동
		// /06_servletjsp/servlet/redirect/Test01
		response.sendRedirect(
			"/06_servletjsp/servlet/redirect/test01.jsp"
//			"test01.jsp"
		);
	}
}










