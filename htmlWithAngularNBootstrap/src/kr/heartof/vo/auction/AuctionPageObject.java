package kr.heartof.vo.auction;

import java.util.List;

public class AuctionPageObject {
	private List<RegAucVO> list;
	
	private int total;
	
	private int currentPage;
	
	private int totalPage;
	
	private int startIndicator;
	
	private int endIndicator;
	
	private int start;
	
	private int end;
	
	private int viewCount;

	private String GROUP_CATE_NUM;
	
	private String HIGH_PROD_CATE_NM;

	public String getHIGH_PROD_CATE_NM() {
		return HIGH_PROD_CATE_NM;
	}

	public void setHIGH_PROD_CATE_NM(String hIGH_PROD_CATE_NM) {
		HIGH_PROD_CATE_NM = hIGH_PROD_CATE_NM;
	}

	public String getGROUP_CATE_NUM() {
		return GROUP_CATE_NUM;
	}

	public void setGROUP_CATE_NUM(String gROUP_CATE_NUM) {
		GROUP_CATE_NUM = gROUP_CATE_NUM;
	}

	public List<RegAucVO> getList() {
		return list;
	}

	public void setList(List<RegAucVO> list) {
		this.list = list;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartIndicator() {
		return startIndicator;
	}

	public void setStartIndicator(int startIndicator) {
		this.startIndicator = startIndicator;
	}

	public int getEndIndicator() {
		return endIndicator;
	}

	public void setEndIndicator(int endIndicator) {
		this.endIndicator = endIndicator;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
}
