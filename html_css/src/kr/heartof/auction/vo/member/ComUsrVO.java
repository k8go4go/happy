package kr.heartof.auction.vo.member;

public class ComUsrVO extends UsrVO {
	private int MEMB_NUM;
	private String CORP_NM;
	private String BUS_NUM;
	private String CEO_NM;
	private String CHGR_NM;

	public String getBUS_NUM() {
		return BUS_NUM;
	}

	public void setBUS_NUM(String bUS_NUM) {
		BUS_NUM = bUS_NUM;
	}

	public int getMEMB_NUM() {
		return MEMB_NUM;
	}

	public void setMEMB_NUM(int mEMB_NUM) {
		MEMB_NUM = mEMB_NUM;
	}

	public String getCORP_NM() {
		return CORP_NM;
	}

	public void setCORP_NM(String cORP_NM) {
		CORP_NM = cORP_NM;
	}

	public String getCEO_NM() {
		return CEO_NM;
	}

	public void setCEO_NM(String cEO_NM) {
		CEO_NM = cEO_NM;
	}

	public String getCHGR_NM() {
		return CHGR_NM;
	}

	public void setCHGR_NM(String cHGR_NM) {
		CHGR_NM = cHGR_NM;
	}
}
