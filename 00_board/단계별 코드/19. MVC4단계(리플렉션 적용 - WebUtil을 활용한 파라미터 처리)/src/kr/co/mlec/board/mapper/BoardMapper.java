package kr.co.mlec.board.mapper;

import java.util.List;

import kr.co.mlec.board.vo.BoardCommentVO;
import kr.co.mlec.board.vo.BoardFileVO;
import kr.co.mlec.board.vo.BoardVO;

/**
 * 게시물에 대한 데이터를 처리하는 DAO 클래스
 * @author Administrator
 */
public interface BoardMapper {
	
	public void insertBoard(BoardVO board) throws Exception;
	public int updateBoard(BoardVO board) throws Exception;
	public int deleteBoard(int no) throws Exception;
	public List<BoardVO> selectBoard() throws Exception;
	public BoardVO selectBoardByNo(int no) throws Exception;

	// 파일 작업
	public void insertBoardFile(BoardFileVO fileVO) throws Exception;
	public BoardFileVO selectBoardFileByNo(int fileNo) throws Exception;
	
	// 댓글 작업
	public List<BoardCommentVO> selectBoardCommentByNo(int no) throws Exception;
	public void insertBoardComment(BoardCommentVO comment) throws Exception;
	public void deleteBoardComment(int commentNo) throws Exception;
	public void updateBoardComment(BoardCommentVO comment) throws Exception;
}









