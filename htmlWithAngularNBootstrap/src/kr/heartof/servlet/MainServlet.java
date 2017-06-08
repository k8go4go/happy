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
import kr.heartof.util.PathUtil;
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
		Map<String, List<RegAucVO>> mainMap = new HashMap<>();
		for(ProdCateVO ho : height) {
			for(ProdCateVO lo : ho.getLowerCateVO()) {
				PageVO vo = new PageVO();
				vo.setSTART(1);
				vo.setEND(3);
				vo.setSearchWord(lo.getPROD_CATE_NUM());
				List<RegAucVO> listAuc = mapper.listProductThisMonthForMain(vo);
				
				if(listAuc != null && listAuc.size() > 0)
					mainMap.put(lo.getPROD_CATE_NUM(), listAuc);
			}
		}
		
		request.setAttribute("mainAuction", mainMap);
	}
}
