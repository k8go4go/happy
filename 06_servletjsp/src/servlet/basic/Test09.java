package servlet.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/basic/Test09")
public class Test09 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse arg1) throws ServletException, IOException {
		// 같은 이름으로 여러개의 파라미터 값이 넘어올 경우
		// 예> checkbox 형태
		// /servlet/basic/Test09?fruit=2&fruit=3
		String[] fruits = request.getParameterValues("fruit");
		// checkbox, radio 경우에는 사용자가 선택하지 않은 경우에
		// null 값이 반환되므로 널체크를 해야 할 필요가 있음
		if (fruits != null) {
			for (String fruit : fruits) {
				System.out.println(fruit);
			}
		}
		else {
			System.out.println("선택한 과일이 없음");
		}
	}
	
}











