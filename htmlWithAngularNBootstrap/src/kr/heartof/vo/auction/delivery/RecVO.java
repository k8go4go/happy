package kr.heartof.vo.auction.delivery;

import java.util.Date;

public class RecVO {
	private int DELI_NUM;
	private Date TAKE_DTIME;
	private String TAKE_CONFIRM;

	public int getDELI_NUM() {
		return DELI_NUM;
	}

	public void setDELI_NUM(int dELI_NUM) {
		DELI_NUM = dELI_NUM;
	}

	public Date getTAKE_DTIME() {
		return TAKE_DTIME;
	}

	public void setTAKE_DTIME(Date tAKE_DTIME) {
		TAKE_DTIME = tAKE_DTIME;
	}

	public String getTAKE_CONFIRM() {
		return TAKE_CONFIRM;
	}

	public void setTAKE_CONFIRM(String tAKE_CONFIRM) {
		TAKE_CONFIRM = tAKE_CONFIRM;
	}

}
