package servlet.forward;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/forward/Test01")
public class Test01 extends HttpServlet {

	@Override
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// jsp 페이지로 이동하기
		// forward 방식 이용
		// forward 메서드를 사용하기 위해서 
		// RequestDispatcher 클래스를 얻어야 한다.
		// 페이지 이동 주소 설정시 주의점
		// 주소 중에서 프로젝트는 생략한다.
		// 데이터 공유하기 : Request 객체 활용
		String msg = "공유 테스트";
		Date d = new Date();
		request.setAttribute("msg", msg);
		request.setAttribute("d", d);

		// 페이지 이동
		RequestDispatcher rd = 
				request.getRequestDispatcher(
//					"/servlet/forward/test01.jsp"
					"test01.jsp"
				);
		rd.forward(request, response);
	}
}









