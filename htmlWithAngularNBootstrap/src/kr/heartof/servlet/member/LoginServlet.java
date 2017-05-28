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

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberMapper mapper = BringSqlSession.getMapper(MemberMapper.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		UsrVO user = null;
		
		if(request.getParameter("USR_CD").equals(Code.MEMBER_PRI_CD.getKey())) {
			user = new PriUsrVO();
			user.setMEMB_CD(Code.MEMBER_PRI_CD.getKey());
		} else {
			user = new ComUsrVO();
			user.setMEMB_CD(Code.MEMBER_COM_CD.getKey());
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
