package kr.heartof.auction.admin.mapper;

import kr.heartof.auction.vo.auction.RegAucVO;
import kr.heartof.auction.vo.auction.RegRejVO;

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
