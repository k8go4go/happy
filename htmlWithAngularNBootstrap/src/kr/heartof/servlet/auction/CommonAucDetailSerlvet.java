package kr.heartof.servlet.auction;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.heartof.service.mapper.AuctionMapper;
import kr.heartof.util.BringSqlSession;
import kr.heartof.vo.auction.RegAucFileVO;
import kr.heartof.vo.auction.RegAucVO;
import kr.heartof.vo.member.UsrVO;

@WebServlet("/commonAucDetail.do")
public class CommonAucDetailSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AuctionMapper mapper = BringSqlSession.getMapper(AuctionMapper.class);
		
		int id = Integer.parseInt(request.getParameter("no"));
		RegAucVO aucVO = mapper.detail(id);
		List<RegAucFileVO> fileList = mapper.listRegAucFile(id);
		request.setAttribute("aucVO", aucVO);
		request.setAttribute("fileListVO", fileList);
		
		request.getServletContext().getRequestDispatcher("/jsp/auction/commonAuctionDetail.jsp").forward(request, response);
	}
}
