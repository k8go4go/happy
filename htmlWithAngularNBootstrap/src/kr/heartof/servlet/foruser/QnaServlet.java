package kr.heartof.servlet.foruser;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.heartof.service.mapper.QnaMapper;
import kr.heartof.util.BringSqlSession;
import kr.heartof.util.PageUtil;
import kr.heartof.vo.foruser.BoardVO;

@WebServlet("/qna.do")
public class QnaServlet extends HttpServlet {
	private static final long serialVersionUID = -6604503467292740840L;
	private static QnaMapper mapper = BringSqlSession.getMapper(QnaMapper.class); 

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addHeader("Content-Type", "text/html;charset=UTF-8");
		PageUtil util = new PageUtil(PageUtil.BLOCKPAGE_5);
		util.setMapper(mapper);
		util.setHttpServletRequest(request);
		int currentPage = util.getCurrentPageFromClinet();
		List<BoardVO> sendList = util.getRequestBoardList();
		
		int totalPage = util.getTotalPage();
		int startIndicator = util.startIndicator();
		int endIndicator = util.endIndicator();
		int viewCount = util.viewCount();
		int start = util.getStart();
		int end = util.getEnd();
		
		request.setAttribute("list", sendList);
		request.setAttribute("total", sendList.get(0).getTOT());
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("startIndicator", startIndicator);
		request.setAttribute("endIndicator", endIndicator);
		request.setAttribute("start", start);
		request.setAttribute("end", end);
		request.setAttribute("viewCount", viewCount);
		
		request.getServletContext().getRequestDispatcher("/jsp/foruser/qnaList.jsp").forward(request, response);
	}
}
