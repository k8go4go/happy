package kr.heartof.auction.service.foruser;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.heartof.auction.service.mapper.QnaMapper;
import kr.heartof.auction.service.util.PageUtil;
import kr.heartof.auction.vo.foruser.BoardVO;

public class QnaServlet extends HttpServlet {
	private static QnaMapper mapper = null; 
	static {
		String resource = "common/config/sqlMapConfig.xml";
		SqlSessionFactory sqlSessionFactory;
		try {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
			SqlSession session = sqlSessionFactory.openSession();
			mapper = session.getMapper(QnaMapper.class);
		} catch (IOException e) {
		}
	}
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
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/foruser/qna.jsp");
		request.setAttribute("list", sendList);
		request.setAttribute("total", sendList.get(0).getTOT());
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("startIndicator", startIndicator);
		request.setAttribute("endIndicator", endIndicator);
		request.setAttribute("start", start);
		request.setAttribute("end", end);
		request.setAttribute("viewCount", viewCount);
		dispatcher.forward(request, response);
	}
}
