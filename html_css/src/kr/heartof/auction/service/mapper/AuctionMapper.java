package kr.heartof.auction.service.mapper;

import java.util.List;

import kr.heartof.auction.vo.auction.RegAucVO;

/**
 * 옥션 관련 MAPPER
 * html_css
 */
public interface AuctionMapper {
	public List<RegAucVO> allProgressing();
	
	public List<RegAucVO> cateProgressing(String PROD_CATE_NUM);
	
	public int regAuction(RegAucVO vo);
	
	public int regAuctionFile(RegAucVO vo);
	
	public int updateAuction(RegAucVO vo);
	
	public int updateAuctionFile(RegAucVO vo);
	
	public RegAucVO detail(int AUC_REG_NUM);
	
	public int deteteAuction(int AUC_REG_NUM);
	
	public int deteteAucFile(int AUC_REG_NUM);
}
