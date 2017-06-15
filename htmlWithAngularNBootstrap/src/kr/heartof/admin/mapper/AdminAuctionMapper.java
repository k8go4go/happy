package kr.heartof.admin.mapper;

import java.util.List;

import kr.heartof.admin.vo.StaticsVO;
import kr.heartof.vo.auction.RegAucFileVO;
import kr.heartof.vo.auction.RegAucVO;
import kr.heartof.vo.auction.RegRejVO;

public interface AdminAuctionMapper {
	public List<RegAucVO> needApprCD();
	
	public List<RegAucVO> doneApprCD();
	
	public RegAucVO detail(int AUC_REG_NUM);
	
	public List<RegAucFileVO> listRegAucFile(int AUC_REG_NUM);
	
	public RegRejVO getRecRej(int AUC_REG_NUM);
	
	public int updateApprCD(RegAucVO vo);
	
	public int insertRegRej(RegRejVO vo);
	
	public List<StaticsVO> memberRegStat();
	
	public List<StaticsVO> enterBiddingStat();

	public List<StaticsVO> bidPriceStat();
}
