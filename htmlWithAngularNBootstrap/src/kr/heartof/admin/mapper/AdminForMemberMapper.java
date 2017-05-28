package kr.heartof.admin.mapper;

import kr.heartof.vo.auction.RegAucVO;
import kr.heartof.vo.auction.RegRejVO;

/**
 * 사용자 관련 MAPPER
 * 1. 로그인
 * 2. 회원가입
 * 3. 회원정보 보기
 * 4. 회원수정
 * 5. 탈퇴
 * @author LEESANGOUK
 * html_css
 */
public interface AdminForMemberMapper {
	public int updateApprCD(RegAucVO vo);
	
	public int regRej(RegRejVO vo);	
}
