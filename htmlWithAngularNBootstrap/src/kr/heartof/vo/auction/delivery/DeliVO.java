package kr.heartof.vo.auction.delivery;

import java.util.Date;

public class DeliVO {
	private int DELI_NUM;
	private Date DELI_DTIME;
	private int SBID_NUM;
	private String SHORT_CONT;

	public int getDELI_NUM() {
		return DELI_NUM;
	}

	public void setDELI_NUM(int dELI_NUM) {
		DELI_NUM = dELI_NUM;
	}

	public Date getDELI_DTIME() {
		return DELI_DTIME;
	}

	public void setDELI_DTIME(Date dELI_DTIME) {
		DELI_DTIME = dELI_DTIME;
	}

	public int getSBID_NUM() {
		return SBID_NUM;
	}

	public void setSBID_NUM(int sBID_NUM) {
		SBID_NUM = sBID_NUM;
	}

	public String getSHORT_CONT() {
		return SHORT_CONT;
	}

	public void setSHORT_CONT(String sHORT_CONT) {
		SHORT_CONT = sHORT_CONT;
	}

}
