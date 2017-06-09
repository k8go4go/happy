package kr.heartof.servlet.admin;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.heartof.admin.mapper.PathVO;
import kr.heartof.constant.Path;
import kr.heartof.util.PathUtil;

@WebServlet("/admin/adminMain.do")
public class AdminMainServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public AdminMainServlet() {
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		Map<String, PathVO> path = (Map<String, PathVO>)request.getServletContext().getAttribute("path");
		PathUtil.setPath(path);
		
		request.getServletContext().getRequestDispatcher(
				PathUtil.getPath(Path.ADMIN_MAIN_JSP) + 
				PathUtil.getPathNM(Path.ADMIN_MAIN_JSP)).forward(request, response);
	}
}
