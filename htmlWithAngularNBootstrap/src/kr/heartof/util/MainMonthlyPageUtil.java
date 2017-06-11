package kr.heartof.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.heartof.constant.Code;
import kr.heartof.service.mapper.AuctionMapper;
import kr.heartof.vo.auction.RegAucVO;
import kr.heartof.vo.foruser.PageVO;

public class MainMonthlyPageUtil {
	// 한 화면에 보여질 게시물 갯수 정보
	public static final int PAGE_3 = 3;
	public static final int PAGE_10 = 10;
	public static final int PAGE_20 = 20;
	public static final int PAGE_30 = 30;

	public static final int BLOCKPAGE_3 = 3;
	public static final int BLOCKPAGE_5 = 5;
	public static final int BLOCKPAGE_10 = 10;
	public static final int BLOCKPAGE_15 = 15;

	private int viewCount;  // 한 화면에 보여질 갯수
	private int showBlockPageCount; // 페이지 넘버를 보여질 갯수
	private int currentPage;  // 현재 페이지 번호
	private int total;
	
	private AuctionMapper mapper;
	private PageVO pageVO = new PageVO();
	public MainMonthlyPageUtil(int showBlockPageCount) {
		this.showBlockPageCount = showBlockPageCount;
	}

	public int getShowBlockPageCount() {
		return showBlockPageCount;
	}

	public int getTotalBlcok() {
		int totalPage = getTotalPage();
		if (totalPage > showBlockPageCount) {
			return totalPage / showBlockPageCount + (totalPage % showBlockPageCount > 0 ? 1 : 0);
		} else {
			return 1;
		}
	}

	public int getCurrentPageFromClinet() { 
		return currentPage;
	}

	public int getTotalPage() {
		if (total > viewCount) {
			int totalPage = total / viewCount + (total % viewCount > 0 ? 1 : 0);
			return totalPage;
		} else {
			return 1;
		}
	}

	public int getViewCount() {
		return viewCount;
	}

	public List<RegAucVO> getRequestlistProductingForMain(String search) {
		pageVO.setSearchWord(search);
		List<RegAucVO> listAuc = mapper.listProductingForMain(pageVO);
		if(listAuc.size() > 0) 
			total = listAuc.get(0).getTOT();
		return listAuc;
	}
	
	public List<RegAucVO> getRequestlistProductThisMonthForMain(String search) {
		pageVO.setSearchWord(search);
		List<RegAucVO> listAuc = mapper.listProductThisMonthForMain(pageVO);
		if(listAuc.size() > 0) 
			total = listAuc.get(0).getTOT();
		return listAuc;
	}

	public int getStart() {
		if(currentPage == 0)
			return 0;
		
		int currentBlockNum = currentPage / showBlockPageCount + (currentPage % showBlockPageCount > 0 ? 1 : 0);
		return showBlockPageCount * (currentBlockNum - 1) + 1;
	}

	public int getEnd() {
		if(currentPage == 0)
			return 0;
		
		int currentBlockNum = currentPage / showBlockPageCount + (currentPage % showBlockPageCount > 0 ? 1 : 0);
		// 전체 페이지 사이즈를 벗어나면 마지막 페이지로 세팅해준다.
		if(getTotalPage() < currentBlockNum * showBlockPageCount)
			return getTotalPage();
		
		return currentBlockNum * showBlockPageCount;
	}
	
	public int startIndicator() {
		return showBlockPageCount < currentPage ? 1 : 0;
	}

	public int endIndicator() {
		System.out.println("(getTotalBlcok() " + getTotalBlcok());
		System.out.println("(getTotalBlcok() - 1) * showBlockPageCount : " + ((getTotalBlcok() - 1) * showBlockPageCount));
		return (getTotalBlcok() - 1) * showBlockPageCount >= currentPage ? 1 : 0;
	}
	
	public void setViewCount(int v) {
		viewCount = v;
	}
	
	public final void setHttpServletRequest(HttpServletRequest request) {
		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		} else {
			this.currentPage = 1;
		}
		
		if (request.getParameter("viewCount") != null) {
			viewCount = Integer.parseInt(request.getParameter("viewCount"));
		} else {
			viewCount = PAGE_3;
		}
		
		if (request.getParameter("total") != null) {
			total = Integer.parseInt(request.getParameter("total"));
		} 
		
		if (request.getParameter("start") != null) {
			pageVO.setSTART(Integer.parseInt(request.getParameter("start")));
		} else {
			pageVO.setSTART(1);
		}
		
		if (request.getParameter("end") != null) {
			pageVO.setEND(Integer.parseInt(request.getParameter("end")));
		} else {
			pageVO.setEND(3);
		}
		
		if (request.getParameter("search") != null) {
			pageVO.setSearchWord(request.getParameter("search"));
		} 
		
		if (request.getParameter("option") != null) {
			if(Code.SEARCH_WRITER_CD.getKey().equals(request.getParameter("option"))) {
				pageVO.setCD(Code.SEARCH_WRITER_CD.getKey());
			} else if(Code.SEARCH_TITLE_CD.getKey().equals(request.getParameter("option"))){
				pageVO.setCD(Code.SEARCH_TITLE_CD.getKey());
			} 
		} 
	}

	public int viewCount() {
		return viewCount;
	}

	public void setMapper(AuctionMapper mapper) {
		this.mapper = mapper;
	}
}
