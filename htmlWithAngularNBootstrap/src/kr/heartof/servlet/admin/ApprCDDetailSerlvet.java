package kr.heartof.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.heartof.admin.mapper.AdminAuctionMapper;
import kr.heartof.util.BringSqlSession;
import kr.heartof.vo.auction.RegAucFileVO;
import kr.heartof.vo.auction.RegAucVO;
import kr.heartof.vo.auction.RegRejVO;

@WebServlet("/admin/apprCDDetail.do")
public class ApprCDDetailSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = BringSqlSession.getSqlSessionInstance();
		AdminAuctionMapper mapper = sqlSession.getMapper(AdminAuctionMapper.class);
		
		int id = Integer.parseInt(request.getParameter("AUC_REG_NUM"));
		RegAucVO aucVO = mapper.detail(id);
		List<RegAucFileVO> fileList = mapper.listRegAucFile(id);
		RegRejVO regRejVO = mapper.getRecRej(id);
		
		request.setAttribute("aucVO", aucVO);
		request.setAttribute("fileListVO", fileList);
		request.setAttribute("regRejVO", regRejVO);
		
		request.getServletContext().getRequestDispatcher("/jsp/admin/mgr/apprCDDetail.jsp").forward(request, response);
	}
}
