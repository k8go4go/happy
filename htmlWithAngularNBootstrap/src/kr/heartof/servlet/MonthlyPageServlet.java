package kr.heartof.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;

import kr.heartof.service.mapper.AuctionMapper;
import kr.heartof.util.BringSqlSession;
import kr.heartof.util.MainMonthlyPageUtil;
import kr.heartof.vo.auction.AuctionPageObject;
import kr.heartof.vo.auction.RegAucVO;

@WebServlet("/ajax/monthlyPage.do")
public class MonthlyPageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addHeader("Content-Type", "text/json;charset=UTF-8");
		
		AuctionPageObject obj = makePageObject(request);
		Gson json = new Gson();
		String jsonStr = json.toJson(obj);
		
		System.out.println(jsonStr);
		PrintWriter out = response.getWriter();
		out.write(jsonStr);
		out.close();
	}
	
	private AuctionPageObject makePageObject (HttpServletRequest request) {
		SqlSession sqlSession = BringSqlSession.getSqlSessionInstance();
		AuctionMapper mapper = sqlSession.getMapper(AuctionMapper.class);
		MainMonthlyPageUtil util = new MainMonthlyPageUtil(MainMonthlyPageUtil.BLOCKPAGE_3);
		util.setMapper(mapper);
		util.setHttpServletRequest(request);
		int currentPage = util.getCurrentPageFromClinet();
		List<RegAucVO> sendList = util.getRequestlistProductThisMonthForMain((String)request.getParameter("PROD_CATE_NUM"));
		
		int totalPage = util.getTotalPage();
		int startIndicator = util.startIndicator();
		int endIndicator = util.endIndicator();
		int viewCount = util.viewCount();
		int start = util.getStart();
		int end = util.getEnd();
		
		AuctionPageObject obj = new AuctionPageObject();
		obj.setList(sendList);
		obj.setTotal(sendList.get(0).getTOT());
		obj.setTotalPage(totalPage);
		obj.setStart(start);
		obj.setEnd(end);
		obj.setStartIndicator(startIndicator);
		obj.setEndIndicator(endIndicator);
		obj.setViewCount(viewCount);
		obj.setCurrentPage(currentPage);
		obj.setHIGH_PROD_CATE_NM((String)request.getParameter("HIGH_PROD_CATE_NM"));
		obj.setGROUP_CATE_NUM((String)request.getParameter("PROD_CATE_NUM"));
		return obj;
	}
}
