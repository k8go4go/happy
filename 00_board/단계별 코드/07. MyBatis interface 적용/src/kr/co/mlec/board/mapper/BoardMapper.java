package kr.co.mlec.board.mapper;

import java.util.List;

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
	public BoardVO selectBoardByNo(int findNo) throws Exception;
}









