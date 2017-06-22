package net04.json;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;

public class Test03 {
	public static void main(String[] args) {
		try {
			
			String path = 
					"https://apis.daum.net/search/knowledge";
			String param = "?apikey=b9efb78f28d322ba768a8889224e6e17&q=java&result=5&output=json";
			URL url = new URL(path + param);
			// 다음 API 서버에 접근
			StringBuffer result = new StringBuffer();
			InputStream in = url.openStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			while (true) {
				String line = br.readLine();
				if (line == null) break;
				
				result.append(line);
			}
			BlogVO blog = new Gson().fromJson(
						result.toString(), BlogVO.class);
			BlogChannel channel = blog.getChannel();
			List<BlogItem> items = channel.getItem();
			for (BlogItem item : items) {
				System.out.println(item.getTitle());
				System.out.println(item.getLink());
				System.out.println("=======================");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}














