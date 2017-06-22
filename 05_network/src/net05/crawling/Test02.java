package net05.crawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test02 {
	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("http://www.naver.com").get();
			Elements elements = doc.select(
					"ul.ah_l > li.ah_item > a[href=#]");
			for (Element e : elements) {
//				System.out.println(e.html());
				String rank = e.select(".ah_r").html();
				String keyword = e.select(".ah_k").html();
				System.out.println(rank + "-" + keyword);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}











