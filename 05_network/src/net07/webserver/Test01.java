package net07.webserver;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

// TimeServer : 사용자가 접속하면 시간 정보 보내기
public class Test01 {
	public static void main(String[] args) {
		try {
			
			ServerSocket ss = new ServerSocket(10001);
			SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss"	
			);
			while (true) {
				Socket s = ss.accept();
				System.out.println("접속 : " + s);
				String time = "<html>"
						    + "  <head>"
						    + "    <title>시간 표시</title>"
						    + "    <style>"
						    + "      div {"
						    + "        font-size: 50px; "
						    + "        background: tomato; "
						    + "        color: white; "
						    + "        text-align: center; "
						    + "        margin: 100px; "
						    + "        padding: 50px; "
						    + "        border: 10px solid black; "
						    + "        transition: 1s; "
						    + "      } "
						    + "      div:hover { "
						    + "        background: black; "
						    + "        border-radius: 50px 50px 50px 50px; "
						    + "      } "
						    + "    </style>"
						    + "  </head>"
						    + "  <body>"
						    + "    <div>"
						    + "      현재시간 : " + sdf.format(new Date()) 
						    + "    </div>"
						    + "  </body>"
						    + "</html>";
				
				String startLine = "HTTP/1.1 200 OK\r\n";
				String headers = "Cache-Control: no-cache\r\n"
						       + "Content-Type: text/html; charset=utf-8\r\n"
						       + "Content-Length: " + time.getBytes().length + "\r\n\r\n";
				String body = time;
				
				String data = startLine + headers + body;
				System.out.println(data);
				
				OutputStream out = s.getOutputStream();
				out.write(data.getBytes());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}










