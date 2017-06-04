package kr.heartof.servlet.auction;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.heartof.constant.Code;
import kr.heartof.service.mapper.MemberMapper;
import kr.heartof.util.BringSqlSession;
import kr.heartof.vo.member.ComUsrVO;
import kr.heartof.vo.member.PriUsrVO;
import kr.heartof.vo.member.UsrVO;

@WebServlet("/ajax/aucType.do")
public class AuctionTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static MemberMapper mapper = BringSqlSession.getMapper(MemberMapper.class);   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		int result = mapper.duplicateCardNumber(id);
		
		response.setContentType("text/plain");
		response.getWriter().write("" + result);
	}
}
