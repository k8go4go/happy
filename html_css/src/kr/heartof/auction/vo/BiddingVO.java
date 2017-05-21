package kr.heartof.auction.vo;

import java.sql.Timestamp;

public class BiddingVO {
	private int BID_PRICE_REG_NUM;
	private int BID_PRICE;
	private Timestamp BID_DTIME;
	private int BID_NUM;

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

	public Timestamp getBID_DTIME() {
		return BID_DTIME;
	}

	public void setBID_DTIME(Timestamp bID_DTIME) {
		BID_DTIME = bID_DTIME;
	}

	public int getBID_NUM() {
		return BID_NUM;
	}

	public void setBID_NUM(int bID_NUM) {
		BID_NUM = bID_NUM;
	}

}
