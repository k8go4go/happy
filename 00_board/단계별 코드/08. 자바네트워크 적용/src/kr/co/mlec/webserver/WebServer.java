package kr.co.mlec.webserver;

import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
	private int port;
	public WebServer() {
		this(8000);
	}
	public WebServer(int port) {
		this.port = port;
	}
	public void start() {
		try {
			ServerSocket ss = new ServerSocket(port);
			while (true) {
				Socket s = ss.accept();
				WebClient wc = new WebClient(s);
				wc.service();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}










