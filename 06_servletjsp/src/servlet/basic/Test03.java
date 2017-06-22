package servlet.basic;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Test03 extends GenericServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("재정의 init");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("Generic 상속 서비스");
	}

	
}






