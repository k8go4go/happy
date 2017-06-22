package net07.webserver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

// 요청 정보 확인하기 : 시작라인 + 헤더 + 바디(POST 방식일 경우)
public class Test02 {
	public static void main(String[] args) {
		try {
			
			ServerSocket ss = new ServerSocket(10001);
			SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss"	
			);
			while (true) {
				Socket s = ss.accept();
				InputStream in = s.getInputStream();
				InputStreamReader isr = new InputStreamReader(in);
				BufferedReader br = new BufferedReader(isr);
				// 요청 시작라인
				String reqStartLine = br.readLine();
				// 요청 헤더
				String reqHeaders = "";
				while (true) {
					String line = br.readLine();
					if (line.equals("")) break;
					
					reqHeaders += line +"<br>";
				}
				
				
				String time = "<html>"
						    + "  <head>"
						    + "    <title>요청정보</title>"
						    + "    <style>"
						    + "      div {"
						    + "        font-size: 15px; "
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
						    + "      시작라인 : " + reqStartLine + "<br>" 
						    + "      헤더정보 : " + reqHeaders 
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










