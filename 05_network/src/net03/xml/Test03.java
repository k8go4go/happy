package net03.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test03 {
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
			
			List<FamilyVO> familys = new ArrayList<>();
			
			for (int i = 0; i < len; i++) {
				// family Element
				Node node = list.item(i);
				NodeList cList = node.getChildNodes();
				// 7 : Text 포함
				int cLen = cList.getLength();
//				System.out.println("자식 수 : " + cLen);
				
				FamilyVO family = new FamilyVO();
				
				for (int j = 0; j < cLen; j++) {
					Node cNode = cList.item(j);
					String cName = cNode.getNodeName();
					if ("#text".equals(cName)) {
						continue;
					}
					switch (cName) {
					case "father": 
						family.setFather(cNode.getTextContent());
						break;
					case "mother":
						family.setMother(cNode.getTextContent());
						break;
					case "me":
						family.setMe(cNode.getTextContent());
						break;
					}
				}
				familys.add(family);
			}
			
			for (FamilyVO family : familys) {
				System.out.println(family.getFather());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}









