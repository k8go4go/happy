package kr.heartof.auction.vo.member;

import java.util.Date;

public class MembershipVO {
	private int MEMB_NUM;
	private String MSHIP_CARD_NUM;
	private String NM;
	private int POINT;
	private Date ISSUE_DATE;
	private int ISSUE_CNT;
	private String DEG;
	
	public int getMEMB_NUM() {
		return MEMB_NUM;
	}

	public void setMEMB_NUM(int mEMB_NUM) {
		MEMB_NUM = mEMB_NUM;
	}

	public String getMSHIP_CARD_NUM() {
		return MSHIP_CARD_NUM;
	}

	public void setMSHIP_CARD_NUM(String mSHIP_CARD_NUM) {
		MSHIP_CARD_NUM = mSHIP_CARD_NUM;
	}

	public String getNM() {
		return NM;
	}

	public void setNM(String nM) {
		NM = nM;
	}

	public int getPOINT() {
		return POINT;
	}

	public void setPOINT(int pOINT) {
		POINT = pOINT;
	}

	public Date getISSUE_DATE() {
		return ISSUE_DATE;
	}

	public void setISSUE_DATE(Date iSSUE_DATE) {
		ISSUE_DATE = iSSUE_DATE;
	}

	public int getISSUE_CNT() {
		return ISSUE_CNT;
	}

	public void setISSUE_CNT(int iSSUE_CNT) {
		ISSUE_CNT = iSSUE_CNT;
	}

	public String getDEG() {
		return DEG;
	}

	public void setDEG(String dEG) {
		DEG = dEG;
	}
}
