package kr.heartof.auction.vo.member;

public class PriUsrVO extends UsrVO {
	private int MEMB_NUM;
	private String NM;
	private String SOC_REG_NUM;

	public int getMEMB_NUM() {
		return MEMB_NUM;
	}

	public void setMEMB_NUM(int mEMB_NUM) {
		MEMB_NUM = mEMB_NUM;
	}

	public String getNM() {
		return NM;
	}

	public void setNM(String nM) {
		NM = nM;
	}

	public String getSOC_REG_NUM() {
		return SOC_REG_NUM;
	}

	public void setSOC_REG_NUM(String sOC_REG_NUM) {
		SOC_REG_NUM = sOC_REG_NUM;
	}

}
