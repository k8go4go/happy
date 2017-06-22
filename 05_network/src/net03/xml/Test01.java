package net03.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test01 {
	public static void main(String[] args) {
		// xml 파싱 처리 api : DOM(메모리), SAX(이벤트)
		// data1.xml 파일에 있는 내용을 파싱하자
		// DomParser 처리 API 클래스 : DocumentBuilder
		try {
			// DomParser 객체를 얻기위한 factory 얻기
			DocumentBuilderFactory factory = 
					DocumentBuilderFactory.newInstance();
			// DomParser 객체 얻기
			DocumentBuilder parser = 
					factory.newDocumentBuilder();
			
			// 파서에게 대상 xml 을 알려준다.
			// 파싱된 결과를 Document 받는다.
			Document doc = parser.parse("src/net03/xml/data1.xml");
			NodeList list = doc.getElementsByTagName("family");
			int len = list.getLength();
			System.out.println("family의 개수 : " + len);
			for (int i = 0; i < len; i++) {
				Node node = list.item(i);
				System.out.println(node.getTextContent());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}















