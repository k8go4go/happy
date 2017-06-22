package kr.co.mlec.webserver;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

public class HttpServletResponse {
	private OutputStream out;
	private String contentType;  // 문서타입 설정
	
	private StringWriter sw = new StringWriter();
	private PrintWriter pw = new PrintWriter(sw);
	
	public HttpServletResponse(OutputStream out) {
		this.out = out;
	}
	
	public PrintWriter getWriter() {
		return pw;
	}
	
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void send() throws Exception {
		String result = sw.toString();
		String startLine = "HTTP/1.1 200 OK\r\n";
		String headers = "Cache-Control: no-cache\r\n"
				       + "Content-Type: " + contentType + "\r\n"
				       + "Content-Length: " + result.getBytes().length + "\r\n\r\n";
		String body = result.toString();
		String data = startLine + headers + body;
		out.write(data.getBytes());
		out.close();
	}
}







