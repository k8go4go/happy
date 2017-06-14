package kr.heartof.servlet.auction;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.heartof.service.mapper.AuctionMapper;
import kr.heartof.util.BringSqlSession;
import kr.heartof.vo.auction.RegAucVO;

@WebServlet("/commonAucDetail.do")
public class CommonAucDetailSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = BringSqlSession.getSqlSessionInstance();
		AuctionMapper mapper = sqlSession.getMapper(AuctionMapper.class);
		
		int id = Integer.parseInt(request.getParameter("no"));
		List<RegAucVO> aucVO = mapper.detail(id);
		
		if(aucVO != null && aucVO.size() > 0)
			request.setAttribute("aucVO", aucVO.get(0));
		
		request.getServletContext().getRequestDispatcher("/jsp/auction/commonAuctionDetail.jsp").forward(request, response);
	}
}
