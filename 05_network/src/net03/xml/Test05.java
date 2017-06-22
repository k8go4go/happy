package net03.xml;

import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class Test05 {
	public static void main(String[] args) {
		try {
			
			String path = 
					"https://apis.daum.net/search/knowledge";
			String param = "?apikey=b9efb78f28d322ba768a8889224e6e17&q=java&result=5&output=xml";
			URL url = new URL(path + param);
			// 다음 API 서버에 접근
			InputStream in = url.openStream();
			DocumentBuilderFactory factory = 
					DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = 
					factory.newDocumentBuilder();
			Document doc = parser.parse(in);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}














