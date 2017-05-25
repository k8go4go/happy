package kr.heartof.auction.service.mapper;

import java.util.List;

import kr.heartof.auction.vo.foruser.BoardVO;
import kr.heartof.auction.vo.member.ComUsrVO;
import kr.heartof.auction.vo.member.ElecWalletVO;
import kr.heartof.auction.vo.member.MembershipVO;
import kr.heartof.auction.vo.member.PriUsrVO;
import kr.heartof.auction.vo.member.UsrFileVO;
import kr.heartof.auction.vo.member.UsrVO;

/**
 * QNA 관련 보드 
 * 1. List
 * 2. insert
 * 3. update
 * 4. delete
 * 5. detail
 */
public interface QnaMapper {
	/**
	 * 회원가입시 회원 중복 확인 
	 * @param MEMB_ID
	 * @return 중복시 1 리턴 가능한 아이디 인경우 0 리턴
	 */
	public List<BoardVO> list();
	
	/**
	 * 회원가입시 공통분모에 해당하는 USER 테이블 삽입
	 * @param 공통 USR 테이블 vo 
	 * @return 성공하면 1, 실패하면 0
	 */
	public int detail(int BOARD_NUM);
	/**
	 * 회원가입시 선택된 회원구분 코드에 따른 기업 회원 부분 테이블 삽입
	 * @param 기업 테이블 vo
	 * @return 성공하면 1, 실패하면 0
	 */
	public int insert(BoardVO vo);
	
	/**
	 * 회원가입시 선택된 회원구분 코드에 따른 개인 회원 부분 테이블 삽입
	 * @param 개인 테이블 vo
	 * @return 성공하면 1, 실패하면 0
	 */
	public int delete(int BOARD_NUM);
	
	/**
	 * 회원가입시 선택된 회원구분 코드에 따른 개인 회원 부분 테이블 삽입
	 * @param 개인 테이블 vo
	 * @return 성공하면 1, 실패하면 0
	 */
	public int update(BoardVO vo);
	
	/**
	 * 회원가입시 선택된 회원구분 코드에 따른 개인 회원 부분 테이블 삽입
	 * @param 개인 테이블 vo
	 * @return 성공하면 1, 실패하면 0
	 */
	public int updateHitCount(int BOARD_NUM);
}
