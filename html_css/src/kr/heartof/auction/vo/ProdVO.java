package kr.heartof.auction.vo;

import java.sql.Timestamp;
import java.util.Date;

public class ProdVO {
	private int PROD_NUM;
	private String PROD_NM;
	private Timestamp WRITE_DTIME;
	private String FEATURE;
	private Date ISSUE_DAY;
	private String PROD_CATE_NUM;

	public int getPROD_NUM() {
		return PROD_NUM;
	}

	public void setPROD_NUM(int pROD_NUM) {
		PROD_NUM = pROD_NUM;
	}

	public String getPROD_NM() {
		return PROD_NM;
	}

	public void setPROD_NM(String pROD_NM) {
		PROD_NM = pROD_NM;
	}

	public Timestamp getWRITE_DTIME() {
		return WRITE_DTIME;
	}

	public void setWRITE_DTIME(Timestamp wRITE_DTIME) {
		WRITE_DTIME = wRITE_DTIME;
	}

	public String getFEATURE() {
		return FEATURE;
	}

	public void setFEATURE(String fEATURE) {
		FEATURE = fEATURE;
	}

	public Date getISSUE_DAY() {
		return ISSUE_DAY;
	}

	public void setISSUE_DAY(Date iSSUE_DAY) {
		ISSUE_DAY = iSSUE_DAY;
	}

	public String getPROD_CATE_NUM() {
		return PROD_CATE_NUM;
	}

	public void setPROD_CATE_NUM(String pROD_CATE_NUM) {
		PROD_CATE_NUM = pROD_CATE_NUM;
	}

}
