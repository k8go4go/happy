package net04.json;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Test01 {
	public static void test01() {
		/*
		    {
			     "이름": "테스트",
			     "나이": 25,
			     "성별": "여",
			     "주소": "서울특별시 양천구 목동",
			     "특기": ["농구", "도술"],
			     "가족관계": {"#": 2, "아버지": "홍판서", "어머니": "춘섬"},
			     "회사": "경기 수원시 팔달구 우만동"
		    }
		 */
		MemberVO m = new MemberVO();
		m.setName("홍길동");
		m.setAge(22);
		
		// json 문자열로 만들기
		String result = "{ "
				      + "    \"name\": \"" + m.getName() + "\", "
				      + "    \"age\": " + m.getAge() 
				      + "}";
		System.out.println(result);
	}
	public static void test02() {
		MemberVO m = new MemberVO();
		m.setName("홍길동");
		m.setAge(22);
		
		// json 문자열로 만들기
//		Gson gson = new Gson();
//		String result = gson.toJson(m);
//		System.out.println(result);

		System.out.println(new Gson().toJson(m));
	}
	
	public static void test03() {
		MemberVO m = new MemberVO();
		m.setName("홍길동");
		m.setAge(22);
		
		List<String> hobbys = new ArrayList<>();
		hobbys.add("독서");
		hobbys.add("영화감상");
		hobbys.add("음악감상");
		
		m.setHobbys(hobbys);
		
		System.out.println(new Gson().toJson(m));
	}

	public static void test04() {
		MemberVO m = new MemberVO();
		m.setName("홍길동");
		m.setAge(22);
		
		List<String> hobbys = new ArrayList<>();
		hobbys.add("독서");
		hobbys.add("영화감상");
		hobbys.add("음악감상");
		
		m.setHobbys(hobbys);
		
		Address addr = new Address();
		addr.setPostNo("12345");
		addr.setBasic("서울 서초구 비트캠프");
		addr.setDetail("119-2번지");
		
		m.setAddr(addr);
		
		System.out.println(new Gson().toJson(m));
	}

	public static void test05() {
		String json = "{'name':'홍길동', 'age':20}";
		Gson gson = new Gson();
		MemberVO m = gson.fromJson(json, MemberVO.class);
		System.out.println(m.getName());
		System.out.println(m.getAge());
	}
	public static void test06() {
		String json = 
			"{'name':'홍길동', 'age':20, 'addr':{'postNo':'12345', 'basic':'서울 강남'}}";
		Gson gson = new Gson();
		MemberVO m = gson.fromJson(json, MemberVO.class);
		Address addr = m.getAddr();
		System.out.println(addr.getPostNo());
		System.out.println(addr.getBasic());
		
	}
	public static void main(String[] args) {
		// 객체의 내용을 JSON 형태의 문자열로 변환
//		test01();
//		test02();
//		test03();
//		test04();
		
		// JSON 형태의 문자열을 객체로 변환
//		test05();
		test06();
	}

}













