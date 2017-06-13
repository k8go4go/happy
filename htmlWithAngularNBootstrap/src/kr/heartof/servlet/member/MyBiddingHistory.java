package kr.heartof.servlet.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.heartof.service.mapper.MemberMapper;
import kr.heartof.util.BringSqlSession;
import kr.heartof.vo.auction.BiddingVO;
import kr.heartof.vo.member.UsrVO;

@WebServlet("/myBiddingHistory.do")
public class MyBiddingHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsrVO user = (UsrVO)request.getSession().getAttribute("user");
		
		MemberMapper mapper = BringSqlSession.getMapper(MemberMapper.class);
		
		List<BiddingVO> list = mapper.myBiddingHistory(user.getMEMB_ID());
		
		String result = null;
		if(list != null && list.size() > 0) {
			Gson gson = new Gson();
			result = gson.toJson(list);
		} else {
			result = "{\"result\":\"0\"}";
		}
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(result);
		out.close();
	}
}
