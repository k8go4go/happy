// ~~.jar
package org.springframework.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	
	private static final String REDIRECT_PRIFIX = "redirect:";
	private static final String AJAX_PRIFIX = "ajax:";
	
	private URLHandlerMapping mappings;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		mappings = new URLHandlerMapping();
	}

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
			Controller control = mappings.getController(uri); 

			// uri 잘못된 경우 
			if (control == null) {
				throw new ServletException(
					"요청하신 URL이 존재하지 않습니다."
				);
			}
			
			// "redirect:detail.do?no=" + no;
			ModelAndView mav = control.service(request, response);
			// 화면 페이지 주소
			String view = mav.getView();
			
			// 화면 페이지 이동 - forward, sendRedirect, ajax
			// view 가 redirect: 으로 시작하면 sendRedirect
			//         ajax: 으로 시작하면 ajax 처리
			// 위의 두 경우가 아니라면 forward
			if (view.startsWith(REDIRECT_PRIFIX)) {
				response.sendRedirect(
					view.substring(REDIRECT_PRIFIX.length())
				);
			} 
			else if (view.startsWith(AJAX_PRIFIX)) {
				response.setContentType("text/json; charset=utf-8");
				PrintWriter out = response.getWriter();
				// view : "ajax:{a: 'aaa'}"
				// substring 작업 후 view : "{a: 'aaa'}"
				out.println(view.substring(AJAX_PRIFIX.length()));
			}
			else {
				// ModelAndView 클래스에 들어있는
				// model 맵을 꺼낸다음 맵에 있는 모든 데이터를 
				// request에 공유시킨다.
				Map<String, Object> model 
								= mav.getModel();
				Set<String> keys = model.keySet();
				for (String key : keys) {
					request.setAttribute(
							key, model.get(key)
					);
				}
				
				RequestDispatcher rd = 
						request.getRequestDispatcher(view);
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}









