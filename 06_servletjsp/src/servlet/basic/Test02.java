package servlet.basic;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Test02 implements Servlet {
	@Override
	public void destroy() {
		
	}
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("Test02 서블릿의 init 호출");
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("Test02 서블릿의 service 호출");
	}
	
}








