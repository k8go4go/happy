package network.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/json/Test02")
public class Test02 extends HttpServlet {
	public void service(
			HttpServletRequest request, HttpServletResponse response)
					throws IOException, ServletException {
		System.out.println("호출됨");
		
		// 클라이언트에게 데이터 전송
		List<MessageVO> list = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			list.add( new MessageVO(i, "test" + i) );
		}
		String data = new Gson().toJson(list);
		
		response.setContentType(
				"application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(data);
		out.close();
	}
}





















