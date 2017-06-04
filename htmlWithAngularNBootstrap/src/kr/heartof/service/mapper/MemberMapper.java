package kr.heartof.service.mapper;

import kr.heartof.vo.member.ComUsrVO;
import kr.heartof.vo.member.ElecWalletVO;
import kr.heartof.vo.member.MembershipVO;
import kr.heartof.vo.member.PriUsrVO;
import kr.heartof.vo.member.UsrFileVO;
import kr.heartof.vo.member.UsrVO;

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
public interface MemberMapper{
	/**
	 * 회원가입시 회원 중복 확인 
	 * @param MEMB_ID
	 * @return 중복시 1 리턴 가능한 아이디 인경우 0 리턴
	 */
	public int duplicateID(String MEMB_ID);
	
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
	public UsrVO memberInfo(UsrVO vo); 
	
	public UsrVO login(UsrVO vo);
	
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
	
	/**
	 * 회원 번호에 해당하는 전자지갑을 발행함
	 * @param vo
	 * @return
	 */
	public int newElecWallet(ElecWalletVO vo) ;
	
	/**
	 * 회원 번호에 해당하는 멤버쉽 발행
	 * @param vo
	 * @return
	 */
	public int newMemberShip(MembershipVO vo);
	
	/**
	 * 멤버쉽 카드번호 중복 확인
	 * @param cardNum 확인할 번호
	 * @return
	 */
	public int duplicateCardNumber(String cardNum);
	
	/**
	 * 회원 아이디 찾기 
	 * 회원 아이디는 사용자에 따라 개인은 이름과 주민번호
	 * 기업 회원은 회사이름, 법인번호, 대표이름 으로 ID를 찾을수 있다. 
	 * @param vo
	 * @return
	 */
	public UsrVO findID(UsrVO vo);
	
	/**
	 * 비밀번호 업데이트 비밀번호 분실한 사용자에게 새로운 비밀번호를 
	 * 보내주고 갱신하도록 유도한다.
	 * @param vo
	 * @return
	 */
	public int changePasswd(UsrVO newPasswd);
}
