package kr.heartof.servlet.auction;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;

import kr.heartof.service.mapper.AuctionMapper;
import kr.heartof.service.mapper.MemberMapper;
import kr.heartof.util.BringSqlSession;
import kr.heartof.vo.ResultJSon;
import kr.heartof.vo.auction.BiddingVO;
import kr.heartof.vo.auction.RegAucVO;
import kr.heartof.vo.member.UsrVO;

@WebServlet("/newBidding.do")
public class NewBiddingSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsrVO loginUser = (UsrVO)request.getSession().getAttribute("user");
		SqlSession sqlSession = BringSqlSession.getSqlSessionInstance();
		AuctionMapper mapper = sqlSession.getMapper(AuctionMapper.class);
		
		int result = 0;
		try {
			RegAucVO rvo = new RegAucVO();
			rvo.setMEMB_NUM(loginUser.getMEMB_NUM());
			rvo.setAUC_REG_NUM(Integer.parseInt(request.getParameter("AUC_REG_NUM")));
			
			int maxPrice = mapper.maxBiddingPrice(Integer.parseInt(request.getParameter("AUC_REG_NUM")));
			int bidNum = mapper.getBidNum(rvo);
			
			if(bidNum == 0) {
				response.setContentType("text/plain;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.write(makeJson("입찰입장하지 않아 입찰에 참여할수 없습니다.", String.valueOf(-1)));
				out.close();
				return;
			}
			
			BiddingVO vo = new BiddingVO();
			vo.setBID_PRICE(Integer.parseInt(request.getParameter("BID_PRICE")));
			vo.setBID_NUM(bidNum);
			
			if(maxPrice < Integer.parseInt(request.getParameter("BID_PRICE"))) {
				result = mapper.newbiddingHistory(vo);
				sqlSession.commit(); 
			} else {
				result = -1;
			}
		} catch(Exception e) {
			result = 0;
			e.printStackTrace();
			sqlSession.rollback();
		}
		
		String msg = result == 1 ? "입찰 등록이 완료되었습니다" : "입찰 등록이 실패되었습니다";
		if(result == -1)
			msg = "최고금액보다 낮은 금액은 입찰할수 없습니다."; 
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(makeJson(msg, String.valueOf(result)));
		out.close();
	}
	
	private String makeJson(String msg, String rs) {
		ResultJSon result = new ResultJSon();
		result.setMsg(msg);
		result.setResult(rs);
		Gson gson = new Gson();
		String gsonStr = gson.toJson(result);
		
		return gsonStr;
	}
}
