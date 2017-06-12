package kr.heartof.vo.auction;

import java.util.Date;

public class RegBiddingVO {
	private int BID_NUM;
	private int MEMB_NUM;
	private int AUC_REG_NUM;
	private int BID_QTY;
	private Date REG_DTIME;
	private String MEMB_ID;
	private String EMAIL;
	private String CATE_NM;

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getCATE_NM() {
		return CATE_NM;
	}

	public void setCATE_NM(String cATE_NM) {
		CATE_NM = cATE_NM;
	}

	public String getMEMB_ID() {
		return MEMB_ID;
	}

	public void setMEMB_ID(String mEMB_ID) {
		MEMB_ID = mEMB_ID;
	}

	public int getBID_NUM() {
		return BID_NUM;
	}

	public void setBID_NUM(int bID_NUM) {
		BID_NUM = bID_NUM;
	}

	public int getMEMB_NUM() {
		return MEMB_NUM;
	}

	public void setMEMB_NUM(int mEMB_NUM) {
		MEMB_NUM = mEMB_NUM;
	}

	public int getAUC_REG_NUM() {
		return AUC_REG_NUM;
	}

	public void setAUC_REG_NUM(int aUC_REG_NUM) {
		AUC_REG_NUM = aUC_REG_NUM;
	}

	public int getBID_QTY() {
		return BID_QTY;
	}

	public void setBID_QTY(int bID_QTY) {
		BID_QTY = bID_QTY;
	}

	public Date getREG_DTIME() {
		return REG_DTIME;
	}

	public void setREG_DTIME(Date rEG_DTIME) {
		REG_DTIME = rEG_DTIME;
	}

	@Override
	public String toString() {
		return "RegBiddingVO [BID_NUM=" + BID_NUM + ", MEMB_NUM=" + MEMB_NUM + ", AUC_REG_NUM=" + AUC_REG_NUM
				+ ", BID_QTY=" + BID_QTY + ", REG_DTIME=" + REG_DTIME + ", MEMB_ID=" + MEMB_ID + "]";
	}
}
