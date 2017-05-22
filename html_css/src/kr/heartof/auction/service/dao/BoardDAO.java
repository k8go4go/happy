package kr.heartof.auction.service.dao;

import java.util.List;

import kr.heartof.auction.vo.foruser.BoardVO;

public interface BoardDAO {
	public List<BoardVO> getBoardList(int currentPage, int viewCount);
	
	public boolean insertBoard(BoardVO vo);
	
	public boolean deleteBoard(int no);
	
	public boolean updateBoard(BoardVO vo);
	
	public int getBoardTotal();
}
