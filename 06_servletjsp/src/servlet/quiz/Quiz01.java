package servlet.quiz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/quiz/quiz01")
public class Quiz01 extends HttpServlet {
	@Override
	public void service(
			HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		// 사용자가 화면에서 보내준 파라미터를 읽기
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		
		String ope = req.getParameter("ope");
		String msg = "";
		switch (ope) {
		case "1":
			msg = String.format(
				"%d %s %d = %d<br />", num1, "+", num2, num1 + num2); break;
		case "2":
			msg = String.format(
				"%d %s %d = %d<br />", num1, "-", num2, num1 - num2); break;
		case "3":
			msg = String.format(
				"%d %s %d = %d<br />", num1, "*", num2, num1 * num2); break;
		case "4":
			msg = String.format(
				"%d %s %d = %d<br />", num1, "/", num2, num1 / num2); break;
		}
		
		out.printf(msg);
		out.printf(
			"<a href='quiz01.html'>다시계산</a>"); 
		out.close();
	}
}


