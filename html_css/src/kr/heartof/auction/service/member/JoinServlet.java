package kr.heartof.auction.service.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.heartof.auction.constant.CreDegCD;
import kr.heartof.auction.constant.UserCD;
import kr.heartof.auction.constant.WITHDRAWAL;
import kr.heartof.auction.vo.member.ComUsrVO;
import kr.heartof.auction.vo.member.PriUsrVO;
import kr.heartof.auction.vo.member.UsrVO;

public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		UsrVO user = null;
		
		if(request.getParameter("USR_CD").equals(UserCD.PRIVATE_USR)) {
			user = makePrivateUser(request);
			request.setAttribute("NM", request.getParameter("NM"));
		} else {
			user = makeCompanyUserVO(request);
			request.setAttribute("CHG_NM", request.getParameter("CHG_NM"));
		}
		
		request.setAttribute("USR_CD", request.getParameter("USR_CD"));
		response.sendRedirect(request.getContextPath() + "/jsp/member/memberOk.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private PriUsrVO makePrivateUser(HttpServletRequest request) {
		PriUsrVO user = new PriUsrVO();
		user.setADDRESS(request.getParameter("ADDRESS1") + " " + request.getParameter("ADDRESS2"));
		user.setCRE_DEG_CD("");
		user.setEMAIL(request.getParameter("EMAIL"));
		user.setTELNO(request.getParameter("TELNO"));
		user.setUSR_CD(request.getParameter("TELNO"));
		user.setUSRID(request.getParameter("EMAIL"));
		user.setWITHDRAWAL("");
		user.setZIPNO(request.getParameter("ZIPNO1") + "-" + request.getParameter("ZIPNO2"));
		
		user.setNM(request.getParameter("NM"));
		user.setNM(request.getParameter("SOCIAL_NO"));
		
		return user;
	}
	
	private ComUsrVO makeCompanyUserVO(HttpServletRequest request) {
		ComUsrVO user = new ComUsrVO();
		user.setADDRESS(request.getParameter("ADDRESS1") + " " + request.getParameter("ADDRESS2"));
		user.setCRE_DEG_CD(CreDegCD.REGULAR);
		user.setEMAIL(request.getParameter("EMAIL"));
		user.setTELNO(request.getParameter("TELNO"));
		user.setUSR_CD(request.getParameter("TELNO"));
		user.setUSRID(request.getParameter("EMAIL"));
		user.setWITHDRAWAL(WITHDRAWAL.WITHDRAWAL_N);
		user.setZIPNO(request.getParameter("ZIPNO1") + "-" + request.getParameter("ZIPNO2"));
		
		user.setCOM_NM(request.getParameter("COM_NM"));
		user.setCEO_NM(request.getParameter("CEO_NM"));
		user.setCHG_NM(request.getParameter("CHG_NM"));
		user.setBUS_NO(request.getParameter("BUS_NO"));
		
		return user;
	}
}
