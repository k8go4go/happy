package kr.heartof.auction.vo;

import java.util.Date;

public class PayVO {
	private int PAY_NUM;
	private int PAY_PRICE;
	private Date PAY_DATE;
	private String PAY_METH;
	private int SBID_NUM;

	public int getPAY_NUM() {
		return PAY_NUM;
	}

	public void setPAY_NUM(int pAY_NUM) {
		PAY_NUM = pAY_NUM;
	}

	public int getPAY_PRICE() {
		return PAY_PRICE;
	}

	public void setPAY_PRICE(int pAY_PRICE) {
		PAY_PRICE = pAY_PRICE;
	}

	public Date getPAY_DATE() {
		return PAY_DATE;
	}

	public void setPAY_DATE(Date pAY_DATE) {
		PAY_DATE = pAY_DATE;
	}

	public String getPAY_METH() {
		return PAY_METH;
	}

	public void setPAY_METH(String pAY_METH) {
		PAY_METH = pAY_METH;
	}

	public int getSBID_NUM() {
		return SBID_NUM;
	}

	public void setSBID_NUM(int sBID_NUM) {
		SBID_NUM = sBID_NUM;
	}

}
