package day13;

import java.util.ArrayList;
import java.util.List;

public class Test01 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
//		List<String> list = new LinkedList<>();
		
		list.add("one");
		list.add("two");
		list.add("three");
		
		System.out.println("크기 : " + list.size());
		
		list.remove(0);
		System.out.println("삭제 후 크기 : " + list.size());
		
		System.out.println(list);
		
		String ele = list.get(0);
		System.out.println(ele);

		int index = list.indexOf("three");
		System.out.println("index : " + index);
		index = list.indexOf("four");
		System.out.println("index : " + index);

		boolean empty = list.isEmpty();
		// false
		System.out.println(empty);
		
		boolean flag = list.contains("two");
		// true
		System.out.println(flag);
		
		// 모든 요소 삭제
		list.clear();
		
		// []
		System.out.println(list);
		
	}
}

















