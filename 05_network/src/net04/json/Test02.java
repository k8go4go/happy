package net04.json;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Test02 {
	public static void main(String[] args) {
		try {
			URL url = new URL(
				"http://localhost:8000/05_network_web/json/Test02"
			);
			// 서버에서 전송한 json 데이터 추출하기
			InputStream in = url.openStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			StringBuffer sb = new StringBuffer();
			while (true) {
				String line = br.readLine();
				if (line == null) break;
				
				sb.append(line);
//				System.out.println(line);
			}
			
			Type type = 
				new TypeToken<List<MessageVO>>(){}.getType();
			
			Gson gson = new Gson();
			List<MessageVO> list = 
					gson.fromJson(sb.toString(), type);
			
			for (MessageVO m : list) {
				System.out.println(
						m.getNo() + " - " + m.getMsg());
			}
			System.out.println("클라이언트 종료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}








