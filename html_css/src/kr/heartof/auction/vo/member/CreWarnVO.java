package kr.heartof.auction.vo.member;

public class CreWarnVO {
	private int WARN_NUM;
	private String WARN_NM;
	private String WARN_CONT;
	private int MEMB_NUM;

	public int getWARN_NUM() {
		return WARN_NUM;
	}

	public void setWARN_NUM(int wARN_NUM) {
		WARN_NUM = wARN_NUM;
	}

	public String getWARN_NM() {
		return WARN_NM;
	}

	public void setWARN_NM(String wARN_NM) {
		WARN_NM = wARN_NM;
	}

	public String getWARN_CONT() {
		return WARN_CONT;
	}

	public void setWARN_CONT(String wARN_CONT) {
		WARN_CONT = wARN_CONT;
	}

	public int getMEMB_NUM() {
		return MEMB_NUM;
	}

	public void setMEMB_NUM(int mEMB_NUM) {
		MEMB_NUM = mEMB_NUM;
	}
}
