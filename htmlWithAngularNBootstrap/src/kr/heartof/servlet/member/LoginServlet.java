package kr.heartof.servlet.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.heartof.constant.Code;
import kr.heartof.service.mapper.MemberMapper;
import kr.heartof.util.BringSqlSession;
import kr.heartof.vo.member.ComUsrVO;
import kr.heartof.vo.member.PriUsrVO;
import kr.heartof.vo.member.UsrVO;
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberMapper mapper = BringSqlSession.getMapper(MemberMapper.class);
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsrVO vo = new UsrVO();
		vo.setMEMB_ID(request.getParameter("MEMB_ID"));
		vo.setMEMB_CD(request.getParameter("MEMB_CD"));
		vo.setSEC_NUM(request.getParameter("SEC_NUM"));
		
		UsrVO user = mapper.login(vo);
		user.setUSR_FILE(mapper.memberInfoFile(user.getMEMB_NUM()));
		if(user.getMEMB_CD().equals(Code.MEMBER_PRI_CD.getKey())) {
			System.out.println("PriUsrVO : " + ((PriUsrVO)user).toString());
			request.getSession().setAttribute("user", ((PriUsrVO)user));
		} else {
			System.out.println("PriUsrVO : " + ((ComUsrVO)user).toString());
			request.getSession().setAttribute("user", ((ComUsrVO)user));
		}
		
		response.sendRedirect(request.getContextPath());
	}
}
