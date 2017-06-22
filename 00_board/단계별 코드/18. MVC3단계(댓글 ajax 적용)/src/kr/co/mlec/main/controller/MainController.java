package kr.co.mlec.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.Controller;
import org.springframework.web.ModelAndView;

public class MainController implements Controller {
	public ModelAndView service(
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		return new ModelAndView("/view/main/main.jsp");
	}
}












