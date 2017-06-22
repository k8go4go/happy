package jsp.cookie;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class Test02 {
	public static void main(String[] args) 
			throws Exception {
		// 인코딩
		String msg = "자바";
		String enMsg = URLEncoder.encode(msg, "utf-8");
		System.out.println(enMsg);
		
		msg = URLDecoder.decode(enMsg, "utf-8");
		System.out.println(msg);
	}
}












