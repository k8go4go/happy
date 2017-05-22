package kr.heartof.auction.service.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.heartof.auction.constant.UserCD;
import kr.heartof.auction.vo.member.ComUsrVO;
import kr.heartof.auction.vo.member.PriUsrVO;
import kr.heartof.auction.vo.member.UsrVO;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		UsrVO user = null;
		
		if(request.getParameter("USR_CD").equals(UserCD.PRIVATE_USR)) {
			user = new PriUsrVO();
			user.setMEMB_CD(UserCD.PRIVATE_USR);
		} else {
			user = new ComUsrVO();
			user.setMEMB_CD(UserCD.COMPANY_USR);
		}
		user.setMEMB_NUM(1);
		user.setEMAIL(request.getParameter("EMAIL"));
		
		request.getSession().setAttribute("user", user);
		response.sendRedirect(request.getContextPath() + "/jsp/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
