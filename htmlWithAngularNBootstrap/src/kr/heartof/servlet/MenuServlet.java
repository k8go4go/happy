package kr.heartof.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/menu.do")
public class MenuServlet extends HttpServlet {
    public MenuServlet() {
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getAttribute("first");
		request.getAttribute("second");
		
		// second로 경매 상품을 조회 한다.
		// 경매 상품 조회에 대한 결과를 detail.do로 넘긴다
		
		request.getServletContext().getRequestDispatcher("/detail.do").forward(request, response);
	}
}
