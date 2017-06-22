package servlet.quiz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/quiz/quiz02")
public class Quiz02 extends HttpServlet {
	private int answerNum;
	private int count;
	private List<String> list = new ArrayList<>();
	
	public void init(ServletConfig config) {
		Random r = new Random();
		answerNum = r.nextInt(100) + 1;
	}
	
	@Override
	public void service(
			HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String msg = " 정답입니다.";
		int num = Integer.parseInt(request.getParameter("num"));
		if (num > answerNum) {
			msg = "보다 작은 수를 입력하세요";
		}
		else if (num < answerNum) {
			msg = "보다 큰 수를 입력하세요";
		}
		count++;
		
		list.add(num + msg);
		
		out.println("<html><body>");
		out.println("  <h1>" + count + "회 시도</h1>");
		out.println("  <hr>");
		for (String val : list) {
			out.println("  <h1>" + val + "</h1>");
		}
		out.println("  <hr>");
		if (num != answerNum) {
			out.println("  <h1><a href='quiz02.html'>다시입력</a></h1>");
		} else {
			out.println("<h1>축하합니다.</h1>");
		}
		out.println("</body></html>");
		out.close();
	}
}


