package kr.heartof.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MenuFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;

		if (excludeUrl(req)) { 
			chain.doFilter(request, response);
		} else {  // menu.do 호출로 인한 값을 변경한다.
			String requestURI = req.getRequestURI().toString().trim();
			String uri[] = requestURI.split("/");
			request.setAttribute("first", uri[2]);
			request.setAttribute("second", uri[3]);
			
			req.getServletContext().getRequestDispatcher("/" + uri[4]).forward(req, (HttpServletResponse)response);
		}
	}

	private boolean excludeUrl(HttpServletRequest request) {
		String uri = request.getRequestURI().toString().trim();
		if (uri.endsWith("/menu.do") || uri.endsWith("/ingmenu.do") ) {
			return false;
		} else {
			return true;
		}
	}
}
