package kr.heartof.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.heartof.admin.mapper.PathVO;

@WebServlet("/main.do")
public class MainServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public MainServlet() {
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		Map<String, PathVO> path = (Map<String, PathVO>)request.getServletContext().getAttribute("path");
		
		String pathStr = path.get(kr.heartof.constant.Path.MAIN_JSP.getPath()).getPATH();
		String pathNmStr = path.get(kr.heartof.constant.Path.MAIN_JSP.getPath()).getPATH_NM();

		request.getServletContext().getRequestDispatcher(pathStr + pathNmStr).forward(request, response);
	}
}
