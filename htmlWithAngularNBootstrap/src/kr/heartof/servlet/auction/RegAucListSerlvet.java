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
import kr.heartof.vo.member.UsrVO;

@WebServlet("/regAucList.do")
public class RegAucListSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsrVO loginUser = (UsrVO)request.getSession().getAttribute("user");
		SqlSession sqlSession = BringSqlSession.getSqlSessionInstance();
		AuctionMapper mapper = sqlSession.getMapper(AuctionMapper.class);
		
		List<RegAucVO> list = mapper.aucListForMember(loginUser.getMEMB_NUM());
		
		request.setAttribute("list", list);
		request.getServletContext().getRequestDispatcher("/jsp/auction/myAuctionList.jsp").forward(request, response);
	}
}
