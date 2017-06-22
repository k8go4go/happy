package kr.co.mlec.main.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.Controller;

public class MainController implements Controller {
	public void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		RequestDispatcher rd = 
				request.getRequestDispatcher(
					"/view/main/main.jsp"
				);
		rd.forward(request, response);
	}
}












