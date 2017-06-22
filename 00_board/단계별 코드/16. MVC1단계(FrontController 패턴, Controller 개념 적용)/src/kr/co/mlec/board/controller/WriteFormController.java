package kr.co.mlec.board.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.Controller;

public class WriteFormController implements Controller {
	
	public WriteFormController() { }
	
	public void service(
			HttpServletRequest request, HttpServletResponse response) 
					throws Exception {
		
		// 화면 페이지 이동
		RequestDispatcher rd = 
				request.getRequestDispatcher(
					"/view/board/writeForm.jsp"
		);
		rd.forward(request, response);
	}
}














