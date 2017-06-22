package net07.webserver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

// 요청 정보 확인하기 : 시작라인 + 헤더 + 바디(POST 방식일 경우)
public class Test03 {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(10001);
			while (true) {
				Socket s = ss.accept();
				InputStream in = s.getInputStream();
				InputStreamReader isr = new InputStreamReader(in);
				BufferedReader br = new BufferedReader(isr);
				// 요청 시작라인
				String reqStartLine = br.readLine();
				
				// 출력할 데이터 저장
				StringBuffer result = new StringBuffer();
				
				// http://localhost:10001/05_network/Test03?id=a&pass=b
				/*
				 *   출력 데이터가 아래와 같이 출력되도록 코딩 작성
				 *   요청메서드 : GET
				 *   요청URI : /05_network/Test03
				 *   요청 파라미터
				 *   id : a
				 *   pass : b
				 */
				// reqStartLine
				// GET /05_network_web/Test03?id=aaa&pass=1111 HTTP/1.1
				String[] arr = reqStartLine.split(" ");
				// arr[0] =>  GET
				// arr[1] =>  /05_network_web/Test03?id=aaa&pass=1111
				// arr[2] =>  HTTP/1.1
				result.append("요청방식 : " + arr[0] + "<br>");
				
				String[] uArr = arr[1].split("\\?");
				// uArr[0] => /05_network_web/Test03
				// uArr[1] => id=aaa&pass=1111
				result.append("요청URI : " + uArr[0] + "<br>");
				
				String[] pArr = uArr[1].split("&");
				// pArr[0] => id=aaa
				// pArr[1] => pass=1111
				result.append("요청 파라미터<br>");
				for (String param : pArr) {
					String[] info = param.split("=");
					String name = info[0];
					String value = info[1];
					result.append(name + ":" + value + "<br>");
				}
				
				String time = "<html>"
						    + "  <head>"
						    + "    <title>요청정보</title>"
						    + "    <style>"
						    + "      div {"
						    + "        font-size: 25px; "
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
						    + "    </div>"
						    + "  </body>"
						    + "</html>";
				
				String startLine = "HTTP/1.1 200 OK\r\n";
				String headers = "Cache-Control: no-cache\r\n"
						       + "Content-Type: text/html; charset=utf-8\r\n"
						       + "Content-Length: " + result.toString().getBytes().length + "\r\n\r\n";
				String body = result.toString();
				
				String data = startLine + headers + body;
				OutputStream out = s.getOutputStream();
				out.write(data.getBytes());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}










