package org.springframework.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public ModelAndView service(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws Exception;
}
