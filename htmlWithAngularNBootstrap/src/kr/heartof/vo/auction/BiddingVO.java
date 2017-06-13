package kr.heartof.vo.auction;

import java.util.Date;

public class BiddingVO {
	private int BID_PRICE_REG_NUM;
	private int BID_PRICE;
	private Date BID_DTIME;
	private int BID_NUM;
	private String MEMB_ID;
	private int MEMB_NUM;
	private String AUC_PROD_NM;
	private Date REG_DTIME;
	private Date START_DTIME;
	private Date END_DTIME;
	
	public String getAUC_PROD_NM() {
		return AUC_PROD_NM;
	}

	public void setAUC_PROD_NM(String aUC_PROD_NM) {
		AUC_PROD_NM = aUC_PROD_NM;
	}

	public Date getREG_DTIME() {
		return REG_DTIME;
	}

	public void setREG_DTIME(Date rEG_DTIME) {
		REG_DTIME = rEG_DTIME;
	}

	public Date getSTART_DTIME() {
		return START_DTIME;
	}

	public void setSTART_DTIME(Date sTART_DTIME) {
		START_DTIME = sTART_DTIME;
	}

	public Date getEND_DTIME() {
		return END_DTIME;
	}

	public void setEND_DTIME(Date eND_DTIME) {
		END_DTIME = eND_DTIME;
	}

	public int getMEMB_NUM() {
		return MEMB_NUM;
	}

	public void setMEMB_NUM(int mEMB_NUM) {
		MEMB_NUM = mEMB_NUM;
	}

	public String getMEMB_ID() {
		return MEMB_ID;
	}

	public void setMEMB_ID(String mEMB_ID) {
		MEMB_ID = mEMB_ID;
	}

	public int getBID_PRICE_REG_NUM() {
		return BID_PRICE_REG_NUM;
	}

	public void setBID_PRICE_REG_NUM(int bID_PRICE_REG_NUM) {
		BID_PRICE_REG_NUM = bID_PRICE_REG_NUM;
	}

	public int getBID_PRICE() {
		return BID_PRICE;
	}

	public void setBID_PRICE(int bID_PRICE) {
		BID_PRICE = bID_PRICE;
	}

	public Date getBID_DTIME() {
		return BID_DTIME;
	}

	public void setBID_DTIME(Date bID_DTIME) {
		BID_DTIME = bID_DTIME;
	}

	public int getBID_NUM() {
		return BID_NUM;
	}

	public void setBID_NUM(int bID_NUM) {
		BID_NUM = bID_NUM;
	}

	@Override
	public String toString() {
		return "BiddingVO [BID_PRICE_REG_NUM=" + BID_PRICE_REG_NUM + ", BID_PRICE=" + BID_PRICE + ", BID_DTIME="
				+ BID_DTIME + ", BID_NUM=" + BID_NUM + "]";
	}
}
