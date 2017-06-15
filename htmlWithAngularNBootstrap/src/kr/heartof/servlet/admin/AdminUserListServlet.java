package kr.heartof.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.heartof.admin.mapper.AdminMemberMapper;
import kr.heartof.util.BringSqlSession;
import kr.heartof.vo.member.UsrVO;

@WebServlet("/admin/usrList.do")
public class AdminUserListServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public AdminUserListServlet() {
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		SqlSession sqlSession = BringSqlSession.getSqlSessionInstance();
		AdminMemberMapper mapper = sqlSession.getMapper(AdminMemberMapper.class);
		List<UsrVO> list = mapper.allUsrList();
		
		request.setAttribute("list", list);
		request.getServletContext().getRequestDispatcher("/jsp/admin/mgr/memberList.jsp").forward(request, response);
	}
}
