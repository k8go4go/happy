package kr.heartof.servlet;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.heartof.admin.mapper.PathVO;
import kr.heartof.service.mapper.AuctionMapper;
import kr.heartof.util.BringSqlSession;

@WebServlet("/main.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static AuctionMapper mapper = BringSqlSession.getMapper(AuctionMapper.class);
	
    public MainServlet() {
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		Map<Integer, PathVO> path = (Map<Integer, PathVO>)request.getServletContext().getAttribute("path");
		
		String pathStr = path.get(kr.heartof.constant.Path.MAIN_JSP).getPATH();
		String pathNmStr = path.get(kr.heartof.constant.Path.MAIN_JSP).getPATH_NM();
		
		request.getServletContext().getRequestDispatcher(pathStr + pathNmStr).forward(request, response);
	}
}
