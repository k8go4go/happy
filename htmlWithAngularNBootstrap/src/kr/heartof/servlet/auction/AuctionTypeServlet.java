package kr.heartof.servlet.auction;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;

import kr.heartof.constant.Code;
import kr.heartof.service.mapper.AuctionMapper;
import kr.heartof.util.BringSqlSession;
import kr.heartof.vo.CodeVO;

@WebServlet("/ajax/aucType.do")
public class AuctionTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = BringSqlSession.getSqlSessionInstance();
		AuctionMapper mapper = sqlSession.getMapper(AuctionMapper.class);
		
		response.setCharacterEncoding("UTF-8");
		
		List<CodeVO> list = mapper.getAucType(Code.AUCTION_CD.getKey());
		CodeVO root = new CodeVO();
		root.setLIST(list);
		
		Gson gson = new Gson();
		String strGson = gson.toJson(root);
		
		System.out.println(strGson);
		
		response.setContentType("application/json");
		response.getWriter().write(strGson);
	}
}
