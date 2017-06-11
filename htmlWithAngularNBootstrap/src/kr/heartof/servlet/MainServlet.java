package kr.heartof.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.heartof.admin.mapper.PathVO;
import kr.heartof.constant.Path;
import kr.heartof.service.mapper.AuctionMapper;
import kr.heartof.util.BringSqlSession;
import kr.heartof.util.MainMonthlyPageUtil;
import kr.heartof.util.PathUtil;
import kr.heartof.vo.auction.AuctionPageObject;
import kr.heartof.vo.auction.RegAucVO;
import kr.heartof.vo.foruser.PageVO;
import kr.heartof.vo.product.ProdCateVO;

@WebServlet("/main.do")
public class MainServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public MainServlet() {
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		Map<String, PathVO> path = (Map<String, PathVO>)request.getServletContext().getAttribute("path");
		PathUtil.setPath(path);
		setMainPage(request, response);
		
		request.getServletContext().getRequestDispatcher(
				PathUtil.getPath(Path.MAIN_JSP) + 
				PathUtil.getPathNM(Path.MAIN_JSP)).forward(request, response);
	}
	
	private void setMainPage(HttpServletRequest request, HttpServletResponse response) {
		@SuppressWarnings("unchecked")
		List<ProdCateVO> height = (List<ProdCateVO>)request.getServletContext().getAttribute("menu");
		AuctionMapper mapper = BringSqlSession.getMapper(AuctionMapper.class);
		MainMonthlyPageUtil util = new MainMonthlyPageUtil(MainMonthlyPageUtil.BLOCKPAGE_3);
		util.setMapper(mapper);
		util.setHttpServletRequest(request);
		// 진행중인 경매 가져오기
		Map<String, AuctionPageObject> ingMap = new HashMap<>();
		for(ProdCateVO ho : height) {
			for(ProdCateVO lo : ho.getLowerCateVO()) {
				List<RegAucVO> listAuc = util.getRequestlistProductingForMain(lo.getPROD_CATE_NUM());
				if(listAuc != null && listAuc.size() > 0) {
					AuctionPageObject obj = new AuctionPageObject();
					obj.setGROUP_CATE_NUM(lo.getPROD_CATE_NUM());
					obj.setList(listAuc);
					obj.setTotal(listAuc.get(0).getTOT());
					obj.setTotalPage(util.getTotalPage());
					obj.setStart(util.getStart());
					obj.setEnd(util.getEnd());
					obj.setStartIndicator(util.startIndicator());
					obj.setEndIndicator(util.endIndicator());
					obj.setViewCount(util.viewCount());
					obj.setCurrentPage(util.getCurrentPageFromClinet());
					
					ingMap.put(lo.getPROD_CATE_NUM(), obj);
				}
			}
		}
		
		// 이달의 경매 
		Map<String, AuctionPageObject> monthlyMap = new HashMap<>();
		for(ProdCateVO ho : height) {
			for(ProdCateVO lo : ho.getLowerCateVO()) {
				List<RegAucVO> listAuc = util.getRequestlistProductThisMonthForMain(lo.getPROD_CATE_NUM());
				if(listAuc != null && listAuc.size() > 0) {
					AuctionPageObject obj = new AuctionPageObject();
					obj.setGROUP_CATE_NUM(lo.getPROD_CATE_NUM());
					obj.setList(listAuc);
					obj.setTotal(listAuc.get(0).getTOT());
					obj.setTotalPage(util.getTotalPage());
					obj.setStart(util.getStart());
					obj.setEnd(util.getEnd());
					obj.setStartIndicator(util.startIndicator());
					obj.setEndIndicator(util.endIndicator());
					obj.setViewCount(util.viewCount());
					obj.setCurrentPage(util.getCurrentPageFromClinet());
					monthlyMap.put(lo.getPROD_CATE_NUM(), obj);
				}
			}
		}
		request.setAttribute("mainAuction", monthlyMap); 
		request.setAttribute("mainIngAuction", ingMap);
	}
}
