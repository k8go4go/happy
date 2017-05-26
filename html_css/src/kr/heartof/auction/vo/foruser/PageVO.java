package kr.heartof.auction.vo.foruser;

public class PageVO {
	private int START;
	private int END;

	private int viewCount; // 한 화면에 보여질 갯수
	private int showBlockPageCount; // 페이지 넘버를 보여질 갯수
	private int currentPage; // 현재 페이지 번호

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getShowBlockPageCount() {
		return showBlockPageCount;
	}

	public void setShowBlockPageCount(int showBlockPageCount) {
		this.showBlockPageCount = showBlockPageCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getSTART() {
		return START;
	}

	public void setSTART(int sTART) {
		START = sTART;
	}

	public int getEND() {
		return END;
	}

	public void setEND(int eND) {
		END = eND;
	}
}
