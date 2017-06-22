package kr.co.mlec.login.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login/Logout")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = 
				request.getSession();
		// 세션 삭제
		session.invalidate();
		
		response.sendRedirect(request.getContextPath() + "/main/Main");
	}
}














