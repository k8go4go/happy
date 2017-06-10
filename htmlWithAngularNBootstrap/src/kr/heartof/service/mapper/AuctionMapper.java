package kr.heartof.service.mapper;

import java.util.List;

import kr.heartof.vo.CodeVO;
import kr.heartof.vo.auction.RegAucFileVO;
import kr.heartof.vo.auction.RegAucVO;
import kr.heartof.vo.auction.RegRejVO;
import kr.heartof.vo.foruser.PageVO;

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
	
	public int updateAuctionFile(RegAucFileVO vo);
	
	public int deteteAuction(int AUC_REG_NUM);
	
	public int deteteAucFile(int AUC_REG_NUM);
	
	public List<RegRejVO> getRecRej(int AUC_REG_NUM);
	
	public List<CodeVO> getAucType(String HIGH_CD);
	
	// 회원 등록 옥션 목록
	public List<RegAucVO> aucListForMember(int memb_num);
	
	public RegAucFileVO getRegAucFile(int value);
	
	// 메인 - 진행중인 경매	
	public List<RegAucVO> listProductingForMain(PageVO vo);
	
	// 메인 - 이달의 경매
	public List<RegAucVO> listProductThisMonthForMain(PageVO vo);
	
	// 서브 - 진행중인 경매 모든 목록
	public List<RegAucVO> listProducting(String HIGH_PROD_CATE_NUM);
	
	// 서브 - 이달의 경매 모든 목록
	public List<RegAucVO> listProduct(String HIGH_PROD_CATE_NUM);
}
