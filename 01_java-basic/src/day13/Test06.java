package day13;

import java.util.HashMap;
import java.util.Map;

class Member {
	private String id;
	private String password;
	private String name;
	public Member() {
	}
	public Member(String id, String password, String name) {
		this.id = id;
		this.password = password;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

public class Test06 {
	public static void main(String[] args) {
		Member m = new Member();
		m.setId("hong");
		m.setPassword("1234");
		m.setName("홍길동");
		
		// 맵으로 표현
		Map<String, String> member = new HashMap<>();
		member.put("id", "hong");
		member.put("password", "1234");
		member.put("name", "홍길동");
	}
}






















