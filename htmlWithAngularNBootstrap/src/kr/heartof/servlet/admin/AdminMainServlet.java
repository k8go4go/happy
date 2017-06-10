package kr.heartof.servlet.admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.heartof.admin.mapper.AdminAuctionMapper;
import kr.heartof.admin.mapper.PathVO;
import kr.heartof.admin.vo.MgrVO;
import kr.heartof.constant.Path;
import kr.heartof.util.BringSqlSession;
import kr.heartof.util.PathUtil;
import kr.heartof.vo.auction.RegAucVO;

@WebServlet("/admin/adminMain.do")
public class AdminMainServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public AdminMainServlet() {
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		MgrVO user = (MgrVO)request.getSession().getAttribute("mgr");
		
		@SuppressWarnings("unchecked")
		Map<String, PathVO> path = (Map<String, PathVO>)request.getServletContext().getAttribute("path");
		PathUtil.setPath(path);
		
		makeProcessList(request, user);
		
		request.getServletContext().getRequestDispatcher(
				PathUtil.getPath(Path.ADMIN_MAIN_JSP) + 
				PathUtil.getPathNM(Path.ADMIN_MAIN_JSP)).forward(request, response);
	}
	
	private void makeProcessList(HttpServletRequest request, MgrVO user) {
		request.removeAttribute("needApprCD");
		request.removeAttribute("doneApprCD");
		if(user != null) {
			AdminAuctionMapper mapper = BringSqlSession.getMapper(AdminAuctionMapper.class);
			List<RegAucVO> list = mapper.needApprCD();
			request.setAttribute("needApprCD", list);
			
			List<RegAucVO> donelist = mapper.doneApprCD();
			request.setAttribute("doneApprCD", donelist);
		}
	}
}
