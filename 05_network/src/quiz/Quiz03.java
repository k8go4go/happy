package quiz;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Quiz03 {
    public static void main(String[] args) {
        try {
            // POST
        	Document doc = Jsoup.connect("http://www.daum.net").get();
            Element element = doc.select("div#minitoday").get(0);
            Element wEle = element.select(".link_weather").get(0);
            System.out.println(wEle.html());
            Element rEle = wEle.select(".txt_part.todayWeatherRegion").get(0);
            System.out.println(rEle.html());	
            Element iconEle = wEle.select(".img_weather").get(0);
            System.out.println(iconEle.html());	
            Element descEle = wEle.select(".screen_out.todayWeatherDesc").get(0);
            System.out.println(descEle.html());	
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
