package kr.heartof.auction.service.foruser;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.heartof.auction.service.foruser.dao.QnaDAOImpl;
import kr.heartof.auction.service.util.PageUtil;
import kr.heartof.auction.vo.foruser.BoardVO;

public class QnaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public QnaServlet() {
        super();
    }
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addHeader("Content-Type", "text/html;charset=UTF-8");
		PageUtil util = new PageUtil(PageUtil.BLOCKPAGE_5);
		util.setDAO(new QnaDAOImpl());
		util.setHttpServletRequest(request);
		int currentPage = util.getCurrentPageFromClinet();
		int total = util.getTotalFromBoardData();
		int totalPage = util.getTotalPage();
		int startIndicator = util.startIndicator();
		int endIndicator = util.endIndicator();
		int viewCount = util.viewCount();
		int start = util.getStart();
		int end = util.getEnd();
		List<BoardVO> sendList = util.getRequestBoardList(currentPage);;
			
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/foruser/qna.jsp");
		request.setAttribute("list", sendList);
		request.setAttribute("total", total);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("startIndicator", startIndicator);
		request.setAttribute("endIndicator", endIndicator);
		request.setAttribute("start", start);
		request.setAttribute("end", end);
		request.setAttribute("viewCount", viewCount);
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
