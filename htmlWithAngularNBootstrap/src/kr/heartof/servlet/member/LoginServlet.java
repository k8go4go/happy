package kr.heartof.servlet.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.heartof.constant.Code;
import kr.heartof.service.mapper.MemberMapper;
import kr.heartof.util.BringSqlSession;
import kr.heartof.vo.member.ComUsrVO;
import kr.heartof.vo.member.PriUsrVO;
import kr.heartof.vo.member.UsrVO;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SqlSession sqlSession = BringSqlSession.getSqlSessionInstance();
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);

		UsrVO vo = new UsrVO();
		vo.setMEMB_ID(request.getParameter("MEMB_ID"));
		vo.setMEMB_CD(request.getParameter("MEMB_CD"));
		vo.setSEC_NUM(request.getParameter("SEC_NUM"));

		UsrVO user = mapper.login(vo);

		if (user != null) {
			user.setUSR_FILE(mapper.memberInfoFile(user.getMEMB_NUM()));
			if (user.getMEMB_CD().equals(Code.MEMBER_PRI_CD.getKey())) {
				System.out.println("PriUsrVO : " + ((PriUsrVO) user).toString());
				request.getSession().setAttribute("user", ((PriUsrVO) user));
			} else {
				System.out.println("PriUsrVO : " + ((ComUsrVO) user).toString());
				request.getSession().setAttribute("user", ((ComUsrVO) user));
			}
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("result", "0");
			request.setAttribute("msg", "아이뒤 또는 패스워드를 확인하세요");
			request.getServletContext().getRequestDispatcher("/main.do").forward(request, response);
		}
	}
}
