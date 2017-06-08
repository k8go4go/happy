package kr.heartof.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.heartof.service.mapper.AuctionMapper;
import kr.heartof.util.BringSqlSession;
import kr.heartof.vo.auction.RegAucVO;

@WebServlet("/menu.do")
public class MenuServlet extends HttpServlet {
    public MenuServlet() {
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getAttribute("first"));
		System.out.println(request.getAttribute("second"));
		
		AuctionMapper mapper = BringSqlSession.getMapper(AuctionMapper.class);
		List<RegAucVO> list = mapper.listProductingForMain((String)request.getAttribute("second"));
		request.setAttribute("list", list);
		// second로 경매 상품을 조회 한다.
		// 경매 상품 조회에 대한 결과를 detail.do로 넘긴다
		
		request.getServletContext().getRequestDispatcher("/jsp/auction/catemonthly.jsp").forward(request, response);
	}
}
