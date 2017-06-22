package day13;

import java.util.HashMap;
import java.util.Map;

public class Test04 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		
		map.put("id", "hong");
		map.put("name", "홍길동");
		
		String id = map.get("id");
		System.out.println(id);

		String email = map.get("email");
		System.out.println(email);
		String prevId = map.put("id", "kang");
		System.out.println(prevId);
		id = map.get("id");
		System.out.println(id);
		
	}
}












