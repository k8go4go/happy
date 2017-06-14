package kr.heartof.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.heartof.admin.mapper.AdminAuctionMapper;
import kr.heartof.constant.Code;
import kr.heartof.util.BringSqlSession;
import kr.heartof.vo.auction.RegAucVO;

@WebServlet("/admin/apprCDProcess.do")
public class ApprCDProcessSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = BringSqlSession.getSqlSessionInstance();
		AdminAuctionMapper mapper = sqlSession.getMapper(AdminAuctionMapper.class);
		int result = 0;
		RegAucVO vo = new RegAucVO();
		vo.setAPPR_CD(Code.REG_AUC_APPROVAL_Y_CD.getKey());
		vo.setAUC_REG_NUM(Integer.parseInt(request.getParameter("AUC_REG_NUM")));
		
		try {
			result = mapper.updateApprCD(vo);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			result = 0;
			e.printStackTrace();
		}
		
		String msg = "";
		if(result > 0) {
			msg = "승인처리가 완료되었습니다.";
		} else {
			msg = "승인처리가 실패하였습니다.";
		}
		
		request.setAttribute("result", result);
		request.setAttribute("msg", msg);
		
		request.getServletContext().getRequestDispatcher("/admin/adminMain.do").forward(request, response);
	}
}
