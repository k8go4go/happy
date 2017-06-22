/**
 *  1. 사용자가 입력한 파라미터 정보를 꺼낸다.
 *  2. 저장된 회원정보와 비교한다.
 *  3. 로그인 처리
 *     1) 입력한 정보와 동일한 정보가 입력되면 
 *        세션에 관리하려는 정보를 저장한다.
 *        메인 페이지로 이동한다.
 *     2) 입력한 정보가 올바르지 않은 경우
 *        다시 로그인 할 수 있도록 폼으로 이동한다.   
 */
package jsp.session;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/jsp/session/Login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		String page = "main.jsp";
		
		// id가 a 이고 pass가 1 일 경우 로그인 성공으로 처리
		if ("a".equals(id) && "1".equals(pass)) {
			LoginVO login = new LoginVO();
			login.setId(id);
			login.setName("홍길동");
			SimpleDateFormat sdf = 
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			login.setLoginTime(sdf.format(new Date()));
			
			HttpSession session = 
					request.getSession();
			// 세션에 사용자 정보를 저장
			session.setAttribute("user", login);
		}
		// 로그인 실패
		else {
			request.setAttribute(
					"error", 
					"입력하신 정보가 올바르지 않습니다."
			);
			page = "loginForm.jsp";
		}
		RequestDispatcher rd = 
				request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
	
}




















