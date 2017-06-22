package servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class MyFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(
			ServletRequest request, 
			ServletResponse response, 
			FilterChain chain)
			throws IOException, ServletException {
		/*
		 *   사용자의 아이피와 호출한 페이지 정보를 출력한다.
		 */
		HttpServletRequest hRequest = (HttpServletRequest)request;
		String clientIp = hRequest.getRemoteAddr();
		String uri = hRequest.getRequestURI();
		long s = System.currentTimeMillis();
		chain.doFilter(request, response);
		double time = (System.currentTimeMillis() - s) / 1000d;
		System.out.println(
				clientIp + "에서 " + uri + 
				" 페이지 실행 시간 : " + time
		);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		String appName = config.getInitParameter("app-name");
		String serverIp = config.getInitParameter("server-ip");
		System.out.println("appName : " + appName);
		System.out.println("serverIp : " + serverIp);
	}

}















