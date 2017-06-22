package net03.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test02 {
	public static void main(String[] args) {
		try {
			DocumentBuilderFactory factory = 
					DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = 
					factory.newDocumentBuilder();
			Document doc = parser.parse("src/net03/xml/data2.xml");
			NodeList list = doc.getElementsByTagName("family");
			int len = list.getLength();
//			System.out.println("family 개수 : " + len);
			
			for (int i = 0; i < len; i++) {
				// family Element
				Node node = list.item(i);
				NodeList cList = node.getChildNodes();
				// 7 : Text 포함
				int cLen = cList.getLength();
//				System.out.println("자식 수 : " + cLen);
				for (int j = 0; j < cLen; j++) {
					Node cNode = cList.item(j);
					String cName = cNode.getNodeName();
					if ("#text".equals(cName)) {
						continue;
					}
					String cValue = cNode.getTextContent();
					System.out.println(cName + " : " + cValue);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}









