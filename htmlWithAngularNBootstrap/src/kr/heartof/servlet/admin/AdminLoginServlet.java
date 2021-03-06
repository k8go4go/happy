package kr.heartof.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.heartof.admin.mapper.AdminAuctionMapper;
import kr.heartof.admin.mapper.AdminMemberMapper;
import kr.heartof.admin.vo.MgrVO;
import kr.heartof.constant.Path;
import kr.heartof.util.BringSqlSession;
import kr.heartof.util.PathUtil;
import kr.heartof.vo.auction.RegAucVO;

@WebServlet("/admin/adminLogin.do")
public class AdminLoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public AdminLoginServlet() {
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		SqlSession sqlSession = BringSqlSession.getSqlSessionInstance();
		AdminMemberMapper mapper = sqlSession.getMapper(AdminMemberMapper.class);
		MgrVO vo = new MgrVO();
		vo.setMEMB_ID(request.getParameter("MEMB_ID"));
		vo.setSEC_NUM(request.getParameter("SEC_NUM"));
		
		MgrVO user = mapper.adminLogin(vo);
		if(user != null)
			request.getSession().setAttribute("mgr", user);
		else{
			makeProcessList(request, user);
			request.getServletContext().getRequestDispatcher("/jsp/admin/adminIndex.jsp").forward(request, response);
		}
		
		if(PathUtil.getPath(Path.ADMIN_MAIN_SERVLET) == null) {
			request.getServletContext().getRequestDispatcher("/jsp/admin/adminIndex.jsp").forward(request, response);
		} else {
			makeProcessList(request, user);
			request.getServletContext().getRequestDispatcher(
					PathUtil.getPath(Path.ADMIN_MAIN_SERVLET) + 
					PathUtil.getPathNM(Path.ADMIN_MAIN_SERVLET)).forward(request, response);
		}
	}
	
	private void makeProcessList(HttpServletRequest request, MgrVO user) {
		request.removeAttribute("needApprCD");
		request.removeAttribute("doneApprCD");
		if(user != null) {
			SqlSession sqlSession = BringSqlSession.getSqlSessionInstance();
			AdminAuctionMapper mapper = sqlSession.getMapper(AdminAuctionMapper.class);
			List<RegAucVO> list = mapper.needApprCD();
			request.setAttribute("needApprCD", list);
			
			List<RegAucVO> donelist = mapper.doneApprCD();
			request.setAttribute("doneApprCD", donelist);
		}
	}
}
