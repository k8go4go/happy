/**
 *  /view/jsp/session/loginForm.jsp 호출
 */
package kr.co.mlec.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.Controller;
import org.springframework.web.ModelAndView;

public class LoginFormController implements Controller {
	public ModelAndView service(
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		return new ModelAndView("/view/login/loginForm.jsp");
	}
}














