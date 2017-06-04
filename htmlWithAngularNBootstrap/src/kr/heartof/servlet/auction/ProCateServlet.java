package kr.heartof.servlet.auction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.heartof.service.mapper.ProductMapper;
import kr.heartof.util.BringSqlSession;

@WebServlet("/ajax/procate.do")
public class ProCateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static ProductMapper mapper = BringSqlSession.getMapper(ProductMapper.class);   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cate = request.getParameter("cate");
		
		// ProductCate cate가 널일 경우 최상위
		
		response.setContentType("text/plain");
		response.getWriter().write("");
	}
}
