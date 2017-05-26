
package kr.heartof.auction.vo.foruser;

import kr.heartof.auction.constant.Code;

public class PageVO {
	private int START;
	private int END;
	
	private String CD;
	private String searchWord;
	
	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public String getCD() {
		return CD;
	}

	public void setCD(String cD) {
		CD = cD;
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
