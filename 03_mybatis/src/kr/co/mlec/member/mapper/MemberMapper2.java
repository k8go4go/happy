package kr.co.mlec.member.mapper;

import java.util.List;

import kr.co.mlec.member.vo.MemberVO;

public interface MemberMapper2 {
	MemberVO getMemberInfo1(String id) throws Exception;
	MemberVO getMemberInfo2(MemberVO param) throws Exception;
	String getMemberInfo3(String id) throws Exception;
	int getMemberInfo4() throws Exception;

	List<MemberVO> getMemberList1() throws Exception;
	List<String> getMemberList2() throws Exception;
	List<MemberVO> getMemberList3() throws Exception;
	
	void insertMember(MemberVO param) throws Exception;
	void updateMember(MemberVO param) throws Exception;
	void deleteMember(String id) throws Exception;
	
}






















