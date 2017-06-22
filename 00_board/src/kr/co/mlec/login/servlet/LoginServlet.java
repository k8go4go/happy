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
package kr.co.mlec.login.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;
import kr.co.mlec.login.mapper.LoginMapper;
import kr.co.mlec.login.vo.LoginVO;

@WebServlet("/login/Login")
public class LoginServlet extends HttpServlet {

	private SqlSession session = null;
	private LoginMapper mapper = null;
	
	public LoginServlet() {
		session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(LoginMapper.class);
	}
	
	@Override
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		LoginVO param = new LoginVO();
		param.setId(id);
		param.setPass(pass);
		
		try {
			LoginVO user = mapper.selectLogin(param);
			
			// id가 a 이고 pass가 1 일 경우 로그인 성공으로 처리
			if (user != null) {
				HttpSession session = request.getSession();
				// 세션에 사용자 정보를 저장
				session.setAttribute("user", user);
				response.sendRedirect(request.getContextPath() + "/main/Main");
			}
			// 로그인 실패
			else {
				request.setAttribute(
						"error", 
						"입력하신 정보가 올바르지 않습니다."
				);
				RequestDispatcher rd = 
						request.getRequestDispatcher("LoginForm");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}




















