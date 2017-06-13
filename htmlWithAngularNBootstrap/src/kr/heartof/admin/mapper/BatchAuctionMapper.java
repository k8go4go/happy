package kr.heartof.admin.mapper;

import java.util.List;

import kr.heartof.admin.vo.BatchRegAucVO;

public interface BatchAuctionMapper {
	public int updateBatch2301();
	
	public int updateBatch2304();
	
	public int updateBatch2302();
	
	public int updateBatch2303();
	
	public int updateBatch2305();
	
	public List<BatchRegAucVO> resultBidding();
	
	public int updateBatch2306(int AUC_REG_NUM);
	
	public int newSbidding(BatchRegAucVO vo);
}
