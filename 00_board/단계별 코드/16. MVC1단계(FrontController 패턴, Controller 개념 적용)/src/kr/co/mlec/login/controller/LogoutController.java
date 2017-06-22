package kr.co.mlec.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.Controller;

public class LogoutController implements Controller {

	public void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		HttpSession session = 
				request.getSession();
		// 세션 삭제
		session.invalidate();
		
		response.sendRedirect(request.getContextPath() + "/main/Main.do");
	}
}














