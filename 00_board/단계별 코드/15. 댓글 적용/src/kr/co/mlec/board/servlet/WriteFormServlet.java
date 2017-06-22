package kr.co.mlec.board.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/writeForm")
public class WriteFormServlet extends HttpServlet {
	
	public WriteFormServlet() { }
	
	public void service(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		
		// 화면 페이지 이동
		RequestDispatcher rd = 
				request.getRequestDispatcher(
					"/view/board/writeForm.jsp"
		);
		rd.forward(request, response);
		
	}
}














