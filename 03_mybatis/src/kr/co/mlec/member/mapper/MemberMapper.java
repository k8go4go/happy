package kr.co.mlec.member.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;
import kr.co.mlec.member.vo.MemberVO;
import kr.co.mlec.member.vo.SearchVO;

public class MemberMapper {

	private static SqlSession sqlMapper;
	private static final String NAMESPACE = 
			"kr.co.mlec.member.mapper.MemberMapper";
			
	public MemberMapper() throws Exception {
//		sqlMapper = MyAppSqlConfig.getSqlSessionInstance();
//		System.out.println(sqlMapper);
//		test01();
//		test02();
//		insertMember();
//		updateMember();
//		deleteMember();
//		selectForeach();
//		dynamicSelect();
	}
	
	/**
	 * 데이터를 조회하기 : 하나의 로우를 반환
	 * @throws Exception
	 */
	public void test01() throws Exception {
		/*
		MemberVO member = 
				sqlMapper.selectOne(
						NAMESPACE + ".getMemberInfo1", "member-2");
		System.out.println(member.getName());
		System.out.println(member.getAddr());
		*/
		
		/*
		MemberVO param = new MemberVO();
		param.setId("member-1");
		param.setName("sbc");
		
		MemberVO member = 
				sqlMapper.selectOne(
						NAMESPACE + ".getMemberInfo2", param);
		System.out.println(member.getName());
		System.out.println(member.getAddr());
		*/
		/*
		String name = sqlMapper.selectOne(
				NAMESPACE + ".getMemberInfo3", "member-1");
		System.out.println(name);
		*/
		int count = sqlMapper.selectOne(
				NAMESPACE + ".getMemberInfo4");
		System.out.println(count);
	}

	/**
	 * 여러개의 로우를 결과로 받기
	 * @throws Exception
	 */
	private void test02() throws Exception { 
		/*
		List<MemberVO> list = 
				sqlMapper.selectList(NAMESPACE + ".getMemberList1");
		for (MemberVO member : list) {
			System.out.println(member.getName());
		}
		*/
		
		/*
		List<String> list = sqlMapper.selectList(
				NAMESPACE + ".getMemberList2");
		for (String name : list) {
			System.out.println(name);
		}
		*/
		
		List<MemberVO> list = 
				sqlMapper.selectList(
						NAMESPACE + ".getMemberList3");
		for (MemberVO member : list) {
			System.out.print(member.getId() + ", ");
			System.out.println(member.getName());
		}		
		
	}

	private void insertMember() throws Exception {
		MemberVO param = new MemberVO();
		param.setId("member-5");
		param.setName("mrson");
		param.setEmail("mrson@a.com");
		param.setAddr("bitcampus");
		
		sqlMapper.insert(NAMESPACE + ".insertMember", param);
		sqlMapper.commit();
		
		System.out.println("데이터 등록 후 목록 호출");
		test02();
	}
	
	private void updateMember() throws Exception {
		MemberVO param = new MemberVO();
		param.setId("member-5");
		param.setName("홍길동");
		sqlMapper.update(NAMESPACE + ".updateMember", param);
		sqlMapper.commit();
		
		test02();
	}
	
	// id가 member-5 인 사용자를 삭제
	private void deleteMember() throws Exception {
		sqlMapper.delete(NAMESPACE + ".deleteMember", "member-5");
		sqlMapper.commit();
		
		test02();
	}
	
	private void selectForeach() throws Exception {
		MemberVO param = new MemberVO();
		param.setAddrs(new String[] {"busan", "seoul"});
		List<MemberVO> list = sqlMapper.selectList(
				NAMESPACE + ".getMemberIteratorList",
				param
		);
		for (MemberVO member : list) {
			System.out.println(member.getName());
		}
		
	}
	
	private void dynamicSelect( ) throws Exception {
		MemberVO param = new MemberVO();
		param.setId("ber-1");
		param.setName("s");
		
		List<MemberVO> list = sqlMapper.selectList(
				NAMESPACE + ".getMemberSearchList2",
				param
		);
		for (MemberVO member : list) {
			System.out.println(
					member.getId() + ", " + member.getName());
		}

		
		/*
		SearchVO param = new SearchVO();
		param.setSearchType("id");
		param.setSearchWord("mem");
		List<MemberVO> list = sqlMapper.selectList(
				NAMESPACE + ".getMemberSearchList",
				param
		);
		for (MemberVO member : list) {
			System.out.println(
					member.getId() + ", " + member.getName());
		}
		*/
		
		/*
		String param = "member-1";
		List<MemberVO> list = sqlMapper.selectList(
				NAMESPACE + ".getMemberIncludeList",
				param
		);
		for (MemberVO member : list) {
			System.out.println(
					member.getId() + ", " + member.getName());
		}
		
		int count = sqlMapper.selectOne(
				NAMESPACE + ".getMemberIncludeListCount",
				param
		);
		System.out.println("개수 : " + count);
		*/
	}

	public static void main(String[] args) {
		try {
			new MemberMapper();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}








