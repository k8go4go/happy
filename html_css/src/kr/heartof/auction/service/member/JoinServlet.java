package kr.heartof.auction.service.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.heartof.auction.constant.Code;
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
		
		if(request.getParameter("USR_CD").equals(Code.PRI_USR.getKey())) {
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
		user.setADDRESS(request.getParameter("ADDRESS1"));
		user.setDETA_ADDRESS(request.getParameter("ADDRESS2"));
		user.setCRE_DEG_CD("");
		user.setEMAIL(request.getParameter("EMAIL"));
		user.setTEL_NUM(request.getParameter("TEL_NUM"));
		user.setMEMB_CD(request.getParameter("MEMB_CD"));
		user.setMEMB_ID(request.getParameter("MEMB_ID"));
		user.setWITHDRAWAL_CD(Code.WITHDRAWAL_N.getKey());
		user.setZIP_NUM(request.getParameter("ZIPNO1") + "-" + request.getParameter("ZIPNO2"));
		
		user.setNM(request.getParameter("NM"));
		user.setNM(request.getParameter("SOCIAL_NO"));
		
		return user;
	}
	
	private ComUsrVO makeCompanyUserVO(HttpServletRequest request) {
		ComUsrVO user = new ComUsrVO();
		user.setADDRESS(request.getParameter("ADDRESS1"));
		user.setDETA_ADDRESS(request.getParameter("ADDRESS2"));
		user.setCRE_DEG_CD(Code.CRE_DEG_WHITE.getKey());
		user.setEMAIL(request.getParameter("EMAIL"));
		user.setTEL_NUM(request.getParameter("TEL_NUM"));
		user.setMEMB_CD(request.getParameter("MEMB_CD"));
		user.setMEMB_ID(request.getParameter("MEMB_ID"));
		user.setWITHDRAWAL_CD(Code.WITHDRAWAL_N.getKey());
		user.setZIP_NUM(request.getParameter("ZIPNO1") + "-" + request.getParameter("ZIPNO2"));
		
		user.setCORP_NM(request.getParameter("CORP_NM"));
		user.setCEO_NM(request.getParameter("CEO_NM"));
		user.setCHGR_NM(request.getParameter("CHGR_NM"));
		user.setBUS_NUM(request.getParameter("BUS_NUM"));
		
		return user;
	}
}
