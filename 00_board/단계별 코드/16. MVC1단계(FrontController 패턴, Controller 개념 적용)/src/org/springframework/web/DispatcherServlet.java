// ~~.jar
package org.springframework.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.controller.CommentDeleteController;
import kr.co.mlec.board.controller.CommentRegistController;
import kr.co.mlec.board.controller.CommentUpdateController;
import kr.co.mlec.board.controller.DeleteController;
import kr.co.mlec.board.controller.DetailController;
import kr.co.mlec.board.controller.ListController;
import kr.co.mlec.board.controller.UpdateController;
import kr.co.mlec.board.controller.UpdateFormController;
import kr.co.mlec.board.controller.WriteController;
import kr.co.mlec.board.controller.WriteFormController;
import kr.co.mlec.login.controller.LoginController;
import kr.co.mlec.login.controller.LoginFormController;
import kr.co.mlec.login.controller.LogoutController;
import kr.co.mlec.main.controller.MainController;

public class DispatcherServlet extends HttpServlet {
	@Override
	public void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		// 사용자 요청과 연관된 작업 컨트롤러를 찾는다.
		// 1. 사용자 요청 URI 가져오기
		String uri = request.getRequestURI();
		System.out.println("uri : " + uri);
		
//		uri = uri.substring("/09_mvc".length());
//		/09_mvc/board/list.do
		
		// 웹 어플리케이션명(웹프로젝트명) 동적 가져오기
		String contextPath = request.getContextPath();
		System.out.println("project name : " + contextPath);
		
		uri = uri.substring(contextPath.length());
		System.out.println("uri : " + uri);
		try {

			// uri 와 연관된 컨트롤러 클래스 호출
			// 컨트롤러 클래스 : 서블릿 (X)
			Controller control = null;
			switch (uri) {
			case "/board/list.do":
				control = new ListController();
				break;
			case "/board/detail.do":
				control = new DetailController();
				break;
			case "/board/update.do":
				control = new UpdateController();
				break;
			case "/board/updateForm.do":
				control = new UpdateFormController();
				break;
			case "/board/delete.do":
				control = new DeleteController();
				break;
			case "/board/writeForm.do":
				control = new WriteFormController();
				break;
			case "/board/write.do":
				control = new WriteController();
				break;
			case "/board/commentDelete.do":
				control = new CommentDeleteController();
				break;
			case "/board/commentUpdate.do":
				control = new CommentUpdateController();
				break;
			case "/board/commentRegist.do":
				control = new CommentRegistController();
				break;

			case "/main/Main.do":
				control = new MainController();
				break;
				
			case "/login/LoginForm.do":
				control = new LoginFormController();
				break;
			case "/login/Login.do":
				control = new LoginController();
				break;
			case "/login/Logout.do":
				control = new LogoutController();
				break;
			}

			// uri 잘못된 경우 
			if (control == null) {
				throw new ServletException(
					"요청하신 URL이 존재하지 않습니다."
				);
			}
			
			control.service(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}









