package kr.co.mlec.webserver;

import java.net.Socket;

import kr.co.mlec.board.servlet.DeleteServlet;
import kr.co.mlec.board.servlet.DetailServlet;
import kr.co.mlec.board.servlet.ListServlet;
import kr.co.mlec.board.servlet.UpdateFormServlet;
import kr.co.mlec.board.servlet.UpdateServlet;
import kr.co.mlec.board.servlet.WriteFormServlet;
import kr.co.mlec.board.servlet.WriteServlet;

public class WebClient {
	private Socket s;
	public WebClient(Socket s) {
		this.s = s;
	}
	
	public void service() throws Exception {
		// 요청에 대한 처리 파싱
		HttpServletRequest request = 
				new HttpServletRequest(s.getInputStream());
		
		// 응답에 대한 처리 진행
		HttpServletResponse response = 
				new HttpServletResponse(s.getOutputStream());

		String uri = request.getRequestUri();
		System.out.println("uri : " + uri);
		if (uri == null) return;
		
		HttpServlet servlet = null;
		switch (uri) {
		case "/board/list":
			servlet = new ListServlet();
			break;
		case "/board/detail":
			servlet = new DetailServlet();
			break;
		case "/board/delete":
			servlet = new DeleteServlet();
			break;
		case "/board/writeForm":
			servlet = new WriteFormServlet();
			break;
		case "/board/write":
			servlet = new WriteServlet();
			break;
		case "/board/updateForm":
			servlet = new UpdateFormServlet();
			break;
		case "/board/update":
			servlet = new UpdateServlet();
			break;
		}
		if (servlet != null) {
			// 각 작업 처리 클래스에게 작업 지시
			servlet.service(request, response);
			// 사용자에게 데이터 응답
			response.send();
		}
	}
}









