package kr.heartof.vo.auction;

import java.util.Date;

public class SuccBiddingVO {
	private int SBID_NUM;
	private Date SBID_DATE;
	private int SBID_PRICE;

	public int getSBID_NUM() {
		return SBID_NUM;
	}

	public void setSBID_NUM(int sBID_NUM) {
		SBID_NUM = sBID_NUM;
	}

	public Date getSBID_DATE() {
		return SBID_DATE;
	}

	public void setSBID_DATE(Date sBID_STAT) {
		SBID_DATE = sBID_STAT;
	}

	public int getSBID_PRICE() {
		return SBID_PRICE;
	}

	public void setSBID_PRICE(int sBID_PRICE) {
		SBID_PRICE = sBID_PRICE;
	}

}
