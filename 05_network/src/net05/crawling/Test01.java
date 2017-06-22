package net05.crawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test01 {
	public static void main(String[] args) {
		String html = "<html>"
				    + "  <head>"
				    + "    <title>JSOUP 연습</title>"
				    + "  </head>"
				    + "  <body>"
				    + "    <p>Parse HTML</p>"
				    + "    <p id='a'>"
				    + "       연습..."
				    + "    </p>"
				    + "    <div class='b'>클래스 접근</div>"
				    + "  </body>"
				    + "</html>";
		Document doc = Jsoup.parse(html);
		Elements elements = doc.select("p");  // p 엘리먼트 접근
		System.out.println(elements.size());
		
		for (Element e : elements) {
			System.out.println(e.html());
		}
		
		System.out.println("----------------");
		// 클래스 접근 출력
		elements = doc.select("div.b");
		for (Element e : elements) {
			System.out.println(e.html());
		}
	}
}










