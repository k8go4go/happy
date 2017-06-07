package kr.heartof.service.mapper;

import java.util.List;

import kr.heartof.vo.CodeVO;
import kr.heartof.vo.auction.RegAucFileVO;
import kr.heartof.vo.auction.RegAucVO;
import kr.heartof.vo.auction.RegRejVO;

/**
 * 옥션 관련 MAPPER
 * html_css
 */
public interface AuctionMapper{
	public List<RegAucVO> allProgressing();
	
	public List<RegAucVO> cateProgressing(String PROD_CATE_NUM);
	
	public List<RegAucFileVO> listRegAucFile(int AUC_REG_NUM);
	
	public RegAucVO detail(int AUC_REG_NUM);
	
	public int regAuction(RegAucVO vo);
	
	public int regAuctionFile(RegAucFileVO vo);
	
	public int updateAuction(RegAucVO vo);
	
	public int updateAuctionFile(RegAucVO vo);
	
	public int deteteAuction(int AUC_REG_NUM);
	
	public int deteteAucFile(int AUC_REG_NUM);
	
	public List<RegRejVO> getRecRej(int AUC_REG_NUM);
	
	public List<CodeVO> getAucType(String HIGH_CD);
	
	// 회원 등록 옥션 목록
	public List<RegAucVO> aucListForMember(int memb_num);
}
