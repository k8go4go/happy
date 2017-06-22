package day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Test07 {
	public static void main(String[] args) {
		/*
		Box01 box01 = new Box01();
		box01.setData("귤");
		// 컴파일 에러
		box01.setData(100);
		String data = box01.getData();
		System.out.println(data);
		*/
		
		/*
		Box02 box02 = new Box02();
		box02.setData("귤");
		String data = (String)box02.getData();
		System.out.println(data);
		
		box02.setData(210);
		
		// 실행시 오류발생
//		data = (String)box02.getData();
		int data2 = (Integer)box02.getData();
		System.out.println(data2);
		*/
		
		/*
		Box03<String> box03 = new Box03<>();
		box03.setData("블루베리");
//		box03.setData(111);
		String data = box03.getData();
		System.out.println(data);
		
		Box03<Integer> box04 = new Box03<>();
		*/
		Box04<String, String> box = 
				new Box04<>("apple", "사과");
		String key = box.getKey();
		String val = box.getValue();
		System.out.println(key + ", " + val);
	}
}
























