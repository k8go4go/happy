/**
 *  /view/jsp/session/loginForm.jsp 호출
 */
package kr.co.mlec.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.Controller;

public class LoginFormController implements Controller {

	public void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		RequestDispatcher rd =
				request.getRequestDispatcher(
					"/view/login/loginForm.jsp"
				);
		rd.forward(request, response);
		
	}
	
}














