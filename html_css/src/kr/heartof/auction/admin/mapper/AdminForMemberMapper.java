package kr.heartof.auction.admin.mapper;

import java.util.Map;

import kr.heartof.auction.vo.member.ComUsrVO;
import kr.heartof.auction.vo.member.PriUsrVO;
import kr.heartof.auction.vo.member.UsrFileVO;
import kr.heartof.auction.vo.member.UsrVO;

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
	/**
	 * 회원 정보 조회
	 * @param 공통 USR 테이블 vo 
	 * @return 회원 정보 VO
	 */
	public Map<String, String> memberInfo(int MEMB_NUM); 
	
	/**
	 * 회원 프로필 파일 조회
	 * @param 공통 USR 테이블 vo 
	 * @return 회원 정보 VO
	 */
	public UsrFileVO memberInfoFile(int MEMB_NUM);
	
	/**
	 * 회원정보 수정
	 * @param vo
	 * @return
	 */
	public int updateBasicMemberInfo(UsrVO vo);
	
	/**
	 * 개인회원상세 수정
	 * @param vo
	 * @return
	 */
	public int updatePriMemberInfo(PriUsrVO vo);
	
	/**
	 * 기업회원상세 수정
	 * @param vo
	 * @return
	 */
	public int updateComMemberInfo(ComUsrVO vo);
	/**
	 * 프로필 사진 수정
	 * @param vo
	 * @return
	 */
	public int updateUsrProfile(UsrFileVO vo);
	
	/**
	 * 회원 탈퇴 WITHDRAWAL_CD
	 * @param vo
	 * @return
	 */
	public int updateWithdrawal(UsrVO vo);
}
