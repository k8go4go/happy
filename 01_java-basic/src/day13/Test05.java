package day13;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class Test05 {
	private static Map<String, Character> makeMap() {
		Map<String, Character> data = new HashMap<>();
		Random r = new Random();
		String alpha = "";
		for (char c = 'a'; c <= 'z'; c++)
			alpha += c;
		
		for (char c = 'A'; c <= 'Z'; c++)
			alpha += c;
		
		System.out.println(alpha);
		
		// 맵에 데이터를 랜덤하게 채우기
		for (int i = 0; i < 10; i++) {
			int key = r.nextInt(alpha.length());
			data.put(String.valueOf(key), alpha.charAt(key));
		}
		System.out.println(data);
		return data;
	}
	
	public static void main(String[] args) {
		Map<String, Character> data = makeMap();
		// 맵 안의 모든 데이터 출력
		// 객체.get(키)
		
		// 맵안의 키를 모두 가져오기
		Set<String> set = data.keySet();
		for (String key : set) {
			System.out.println(key + ", " + data.get(key));
		}
		
		Set<Entry<String, Character>> entrySet 
									= data.entrySet();
		
		for (Entry<String, Character> entry : entrySet) {
			System.out.println(
					entry.getKey() + ", " + entry.getValue());
		}
		
	}
}

























