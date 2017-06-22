package jsp.cookie;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp/cookie/Test01")
public class Test01 extends HttpServlet {

	@Override
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// 쿠키를 생성하기 위해서 사용자가 전송한 파라미터 추출
		String name = request.getParameter("name");
		String value = 
				URLEncoder.encode(
					request.getParameter("value"), 
					"utf-8"
				);
		
		// 쿠키 생성
		Cookie c = new Cookie(name, value);
		
		// 유효시간 설정하기(초)
		c.setMaxAge(60 * 60);
		
		// 전송되는 패스 설정 변경
		c.setPath("/");
		
		// 응답 객체에 생성된 쿠키 정보 설정하기
		response.addCookie(c);
		
		response.sendRedirect("test01.jsp");
	}
}









