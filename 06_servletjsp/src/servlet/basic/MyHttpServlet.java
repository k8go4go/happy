package servlet.basic;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class MyHttpServlet extends GenericServlet {

	@Override
	public void service(
			ServletRequest request, 
			ServletResponse response) 
					throws ServletException, IOException {
		service(
				(HttpServletRequest)request, 
				(HttpServletResponse)response
		);
	}
	
	public void service(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		String method = request.getMethod();
		if ("GET".equals(method)) {
			doGet(request, response);
		}
		else if("POST".equals(method)) {
			doPost(request, response);
		}
	}
	
	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		response.sendError(405, "GET 메서드를 지원하지 않습니다");
	}

	protected void doPost(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		response.sendError(405, "POST 메서드를 지원하지 않습니다");
	}
}











