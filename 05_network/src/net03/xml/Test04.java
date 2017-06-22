package net03.xml;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test04 {
	public static void test01() {
		try {
			URL url = new URL(
				"http://192.168.0.20:8000/05_network_web/xml/Test04?name=강사"
			);
			InputStream in = url.openStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			while (true) {
				String line = br.readLine();
				if (line == null) break;
				
				System.out.println(line);
			}
			System.out.println("종료...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void test02() {
		try {
			URL url = new URL(
				"http://192.168.0.20:8000/05_network_web/xml/Test04"
			);
			HttpURLConnection conn = 
					(HttpURLConnection)url.openConnection();
			conn.setDoOutput(true);
			
			OutputStream out = conn.getOutputStream();
			out.write("name=강사".getBytes("utf-8"));
			out.close();
			
			InputStream in = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			while (true) {
				String line = br.readLine();
				if (line == null) break;
				
				System.out.println(line);
			}
			System.out.println("종료...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void test03() {
		try {
			URL url = new URL(
				"http://192.168.0.20:8000/05_network_web/xml/Test04"
			);
			HttpURLConnection conn = 
					(HttpURLConnection)url.openConnection();
			conn.setDoOutput(true);
			
			OutputStream out = conn.getOutputStream();
			out.write("name=강사".getBytes("utf-8"));
			out.close();
			
			InputStream in = conn.getInputStream();

			DocumentBuilderFactory factory = 
					DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = 
					factory.newDocumentBuilder();
			Document doc = parser.parse(in);
			NodeList list = doc.getElementsByTagName("name");
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println(node.getTextContent());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		test01();
//		test02();
		test03();
	}
}

















