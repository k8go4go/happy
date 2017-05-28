package kr.heartof.servlet.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.heartof.constant.Code;
import kr.heartof.service.mapper.MemberMapper;
import kr.heartof.util.BringSqlSession;
import kr.heartof.vo.member.ComUsrVO;
import kr.heartof.vo.member.PriUsrVO;
import kr.heartof.vo.member.UsrVO;

public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static MemberMapper mapper = BringSqlSession.getMapper(MemberMapper.class);   
    public JoinServlet() {
        super();
    }

	protected void serice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		UsrVO user = null;
		
		if(request.getParameter("USR_CD").equals(Code.MEMBER_PRI_CD.getKey())) {
			user = makePrivateUser(request);
			request.setAttribute("NM", request.getParameter("NM"));
		} else {
			user = makeCompanyUserVO(request);
			request.setAttribute("CHG_NM", request.getParameter("CHG_NM"));
		}
		
		request.setAttribute("USR_CD", request.getParameter("USR_CD"));
		response.sendRedirect(request.getContextPath() + "/jsp/member/memberOk.jsp");
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
		user.setWITHDRAWAL_CD(Code.WITHDRAWAL_N_CD.getKey());
		user.setZIP_NUM(request.getParameter("ZIPNO1") + "-" + request.getParameter("ZIPNO2"));
		
		user.setNM(request.getParameter("NM"));
		user.setNM(request.getParameter("SOCIAL_NO"));
		
		return user;
	}
	
	private ComUsrVO makeCompanyUserVO(HttpServletRequest request) {
		ComUsrVO user = new ComUsrVO();
		user.setADDRESS(request.getParameter("ADDRESS1"));
		user.setDETA_ADDRESS(request.getParameter("ADDRESS2"));
		user.setCRE_DEG_CD(Code.MEMBER_CRED_DEG_OK_CD.getKey());
		user.setEMAIL(request.getParameter("EMAIL"));
		user.setTEL_NUM(request.getParameter("TEL_NUM"));
		user.setMEMB_CD(request.getParameter("MEMB_CD"));
		user.setMEMB_ID(request.getParameter("MEMB_ID"));
		user.setWITHDRAWAL_CD(Code.WITHDRAWAL_N_CD.getKey());
		user.setZIP_NUM(request.getParameter("ZIPNO1") + "-" + request.getParameter("ZIPNO2"));
		
		user.setCORP_NM(request.getParameter("CORP_NM"));
		user.setCEO_NM(request.getParameter("CEO_NM"));
		user.setCHGR_NM(request.getParameter("CHGR_NM"));
		user.setBUS_NUM(request.getParameter("BUS_NUM"));
		
		return user;
	}
}
