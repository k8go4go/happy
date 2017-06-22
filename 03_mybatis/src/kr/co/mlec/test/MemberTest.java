package kr.co.mlec.test;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;
import kr.co.mlec.member.mapper.MemberMapper2;
import kr.co.mlec.member.vo.MemberVO;

public class MemberTest {
	
	
	
	public MemberTest() {
		System.out.println("생성자 호출");
		
		// myBatis 로 부터 MemberMapper2 객체 얻기
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		
		// getMapper(인터페이스의 클래스)
		MemberMapper2 mapper = 
				session.getMapper(MemberMapper2.class);
		
		try {
			MemberVO member = mapper.getMemberInfo1("member-1");
			System.out.println(member.getName());
			System.out.println(member.getAddr());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new MemberTest();
	}
}










