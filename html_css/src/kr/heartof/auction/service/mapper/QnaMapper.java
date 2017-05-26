package kr.heartof.auction.service.mapper;

import java.util.List;

import kr.heartof.auction.vo.foruser.BoardVO;
import kr.heartof.auction.vo.foruser.PageVO;

/**
 * QNA 관련 보드 
 * 1. List
 * 2. insert
 * 3. update
 * 4. delete
 * 5. detail
 */
public interface QnaMapper {

	public List<BoardVO> list(PageVO vo);
	
	public List<BoardVO> searchList(PageVO vo);
	
	public BoardVO detail(int BOARD_NUM);

	public int insert(BoardVO vo);

	public int delete(int BOARD_NUM);

	public int update(BoardVO vo);

	public int updateHitCount(int BOARD_NUM);

	public int deleteRelatedFile(int BOARD_NUM);
	
	public int updateQuesCD(BoardVO vo);
	
	public int searchListTot(PageVO vo);
}
