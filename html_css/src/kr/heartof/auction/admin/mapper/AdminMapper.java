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
public interface AdminMapper {
	/**
	 * 회원가입시 회원 중복 확인 
	 * @param MEMB_ID
	 * @return 중복시 1 리턴 가능한 아이디 인경우 0 리턴
	 */
	public int duplicateID(String MEMB_ID) ;
	
	/**
	 * 회원가입시 공통분모에 해당하는 USER 테이블 삽입
	 * @param 공통 USR 테이블 vo 
	 * @return 성공하면 1, 실패하면 0
	 */
	public int newMember(UsrVO vo);
	/**
	 * 회원가입시 선택된 회원구분 코드에 따른 기업 회원 부분 테이블 삽입
	 * @param 기업 테이블 vo
	 * @return 성공하면 1, 실패하면 0
	 */
	public int newComMember(ComUsrVO vo);
	
	/**
	 * 회원가입시 선택된 회원구분 코드에 따른 개인 회원 부분 테이블 삽입
	 * @param 개인 테이블 vo
	 * @return 성공하면 1, 실패하면 0
	 */
	public int newPriMember(PriUsrVO vo);

	/**
	 * 회원가입시 선택된 회원구분 코드에 따른 개인 회원 부분 테이블 삽입
	 * @param 개인 테이블 vo
	 * @return 성공하면 1, 실패하면 0
	 */
	public int newProfile(UsrFileVO vo);
	
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
