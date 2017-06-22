package day13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test02 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		List<String> sub = new ArrayList<>();
		sub.add("d");
		sub.add("e");
		sub.add("f");
		
		// list에 sub의 내용 전체가 복사
		list.addAll(sub);
		
		System.out.println("------------------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("------------------------");
		// 1.5 버전 부터
		for (String data : list) {
			System.out.println(data);
		}
		
		System.out.println("------------------------");
		// 1.4 까지 활용하던 방식
		Iterator<String> ite = list.iterator();
		while (ite.hasNext()) {
//			String data = ite.next();
//			System.out.println(data);
			System.out.println(ite.next());
		}
	}
}















