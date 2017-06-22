package quiz;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import net07.webserver.HttpServletRequest;
import net07.webserver.HttpServletResponse;

public class Quiz04 {
	public static void main(String[] args) {
		// http://localhost:10002/test?msg=test&count=10
		
		/*
		 * HttpServletRequest, HttpServletResponse
		 * 
		 * 화면 결과
		 * 
		 * test
		 * test
		 * test
		 * test
		 * test
		 * test
		 * test
		 * test
		 * test
		 * test
		 */
		
		try {
			ServerSocket server = new ServerSocket(10002);
			while (true) {
				Socket client = server.accept();
				
				HttpServletRequest request   = new HttpServletRequest(client.getInputStream()); 
				HttpServletResponse response = new HttpServletResponse(client.getOutputStream());
				
				int count = Integer.parseInt(
									request.getParameter("count"));
				String msg = request.getParameter("msg");
				
				PrintWriter pw = response.getWriter();
				for (int i = 0; i < count; i++) {
					pw.println(msg);
				}
				response.send();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
