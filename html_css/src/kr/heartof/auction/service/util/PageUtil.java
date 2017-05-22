package kr.heartof.auction.service.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.heartof.auction.service.dao.BoardDAO;
import kr.heartof.auction.service.foruser.dao.QnaDAO;
import kr.heartof.auction.vo.foruser.BoardVO;

public class PageUtil {
	// 한 화면에 보여질 게시물 갯수 정보
	public static final int PAGE_10 = 10;
	public static final int PAGE_20 = 20;
	public static final int PAGE_30 = 30;

	public static final int BLOCKPAGE_5 = 5;
	public static final int BLOCKPAGE_10 = 10;
	public static final int BLOCKPAGE_15 = 15;

	private int viewCount;  // 한 화면에 보여질 갯수
	private int showBlockPageCount; // 페이지 넘버를 보여질 갯수
	private BoardDAO dao;
	private int currentPage;  // 현재 페이지 번호

	public PageUtil(int showBlockPageCount) {
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
		int total = getTotalFromBoardData();
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

	public int getTotalFromBoardData() {
		return dao.getBoardTotal();
	}

	public List<BoardVO> getRequestBoardList(int currentPage) {
		return dao.getBoardList(currentPage, viewCount);
	}

	public void setDAO(QnaDAO dao) {
		this.dao = dao;
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
		return (getTotalBlcok() - 1) * showBlockPageCount >= currentPage ? 1 : 0;
	}

	public final void setHttpServletRequest(HttpServletRequest request) {
		this.currentPage = 1;
		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		if (request.getParameter("viewCount") != null) {
			viewCount = Integer.parseInt(request.getParameter("viewCount"));
		} else {
			viewCount = PAGE_10;
		}
	}

	public int viewCount() {
		return viewCount;
	}
}
