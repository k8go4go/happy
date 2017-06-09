package kr.heartof.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.heartof.admin.mapper.AdminAuctionMapper;
import kr.heartof.util.BringSqlSession;
import kr.heartof.vo.auction.RegAucFileVO;
import kr.heartof.vo.auction.RegAucVO;

@WebServlet("/admin/apprCDDetail.do")
public class ApprCDDetailSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminAuctionMapper mapper = BringSqlSession.getMapper(AdminAuctionMapper.class);
		
		int id = Integer.parseInt(request.getParameter("AUC_REG_NUM"));
		RegAucVO aucVO = mapper.detail(id);
		List<RegAucFileVO> fileList = mapper.listRegAucFile(id);
		request.setAttribute("aucVO", aucVO);
		request.setAttribute("fileListVO", fileList);
		
		request.getServletContext().getRequestDispatcher("/jsp/admin/apprCDDetail.jsp").forward(request, response);
	}
}
