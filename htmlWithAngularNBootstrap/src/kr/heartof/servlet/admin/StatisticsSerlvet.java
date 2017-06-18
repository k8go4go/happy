package kr.heartof.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;

import kr.heartof.admin.mapper.AdminAuctionMapper;
import kr.heartof.admin.vo.StaticsJSON;
import kr.heartof.admin.vo.StaticsVO;
import kr.heartof.util.BringSqlSession;

@WebServlet("/admin/statistics.do")
public class StatisticsSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = BringSqlSession.getSqlSessionInstance();
		AdminAuctionMapper mapper = sqlSession.getMapper(AdminAuctionMapper.class);
		
		
		List<StaticsVO> list1 = mapper.memberRegStat();
		List<StaticsVO> list2 = mapper.enterBiddingStat();		
		List<StaticsVO> list3 = mapper.bidPriceStat();		
		request.setAttribute("datas1", makeJSON(list1));
		request.setAttribute("datas2", makeJSON(list2));
		request.setAttribute("datas3", makeJSON(list3));
		
		request.getServletContext().getRequestDispatcher("/jsp/admin/mgr/statistics.jsp").forward(request, response);
	}
	
	private String makeJSON (List<StaticsVO> list1) {
		List<StaticsJSON> l = new ArrayList<StaticsJSON>() ;
		for(StaticsVO v : list1) {
			StaticsJSON sj = new StaticsJSON();
			sj.setName(v.getMEMB_ID());
			sj.setData(v.getData());
			l.add(sj);
		}
		return new Gson().toJson(l);
	}
}
