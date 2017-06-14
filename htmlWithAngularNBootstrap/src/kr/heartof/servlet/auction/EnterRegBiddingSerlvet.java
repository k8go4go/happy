package kr.heartof.servlet.auction;

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
import kr.heartof.util.DateUtil;
import kr.heartof.vo.ResultJSon;
import kr.heartof.vo.auction.RegAucVO;
import kr.heartof.vo.auction.RegBiddingVO;
import kr.heartof.vo.member.UsrVO;

@WebServlet("/enterRegBidding.do")
public class EnterRegBiddingSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsrVO loginUser = (UsrVO)request.getSession().getAttribute("user");
		SqlSession sqlSession = BringSqlSession.getSqlSessionInstance();
		AuctionMapper mapper = sqlSession.getMapper(AuctionMapper.class);
		
		int result = 0;
		try {
			RegBiddingVO rvo = new RegBiddingVO();
			rvo.setMEMB_NUM(loginUser.getMEMB_NUM());
			rvo.setAUC_REG_NUM(Integer.parseInt(request.getParameter("AUC_REG_NUM")));
			rvo.setBID_QTY(Integer.parseInt(request.getParameter("BID_QTY")));
			
			List<RegAucVO> vo = mapper.detail(Integer.parseInt(request.getParameter("AUC_REG_NUM")));
			if(vo.size() > 0) {
				if(DateUtil.before(vo.get(0).getSTART_DTIME())) { // 오늘 보다 이전이기 때문에 시작
					result = mapper.newBiddingReg(rvo);
					sqlSession.commit();
				} else {
					result = -1;
				}
			} else {
				result = -1;
			}
		} catch(Exception e) {
			result = 0;
			sqlSession.rollback();
			e.printStackTrace();
		}
		
		String msg = result == 1 ? "입찰자 입장이 완료되었습니다" : "입찰자 입장이 실패되었습니다";
		if(result == -1)
			msg = "입찰자가 입장할 경매 정보 오류 입니다."; 
		
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
