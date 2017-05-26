package kr.heartof.auction.service.dao;

import java.util.List;

import kr.heartof.auction.vo.foruser.BoardVO;
import kr.heartof.auction.vo.foruser.PageVO;

public interface BoardDAO {
	public List<BoardVO> list(PageVO vo);
	
	public boolean insert(BoardVO vo);
	
	public boolean delete(int no);
	
	public boolean update(BoardVO vo);
	
	public int updateHitCount(int no);
	
	public int deleteRelatedFile(int no);
	
	public int updateQuesCD(int parentNo);
}
