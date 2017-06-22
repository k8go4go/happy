/**
 *  /view/jsp/session/loginForm.jsp 호출
 */
package kr.co.mlec.login.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login/LoginForm")
public class LoginFormServlet extends HttpServlet {

	@Override
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd =
				request.getRequestDispatcher(
					"/view/login/loginForm.jsp"
				);
		rd.forward(request, response);
		
	}
	
}














