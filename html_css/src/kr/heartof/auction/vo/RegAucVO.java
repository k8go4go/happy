package kr.heartof.auction.vo;

import java.sql.Timestamp;

public class RegAucVO {
	private int AUC_REG_NUM;
	private String AUC_PROD_NM;
	private String SHORT_CONT;
	private Timestamp REG_DTIME;
	private Timestamp START_DTIME;
	private Timestamp END_DTIME;
	private int START_PRICE;
	private int QTY;
	private String APPR_CD;
	private int MEMB_NUM;
	private int PROD_NUM;
	private String AUC_TYPE_NUM;

	public int getAUC_REG_NUM() {
		return AUC_REG_NUM;
	}

	public void setAUC_REG_NUM(int aUC_REG_NUM) {
		AUC_REG_NUM = aUC_REG_NUM;
	}

	public String getAUC_PROD_NM() {
		return AUC_PROD_NM;
	}

	public void setAUC_PROD_NM(String aUC_PROD_NM) {
		AUC_PROD_NM = aUC_PROD_NM;
	}

	public String getSHORT_CONT() {
		return SHORT_CONT;
	}

	public void setSHORT_CONT(String sHORT_CONT) {
		SHORT_CONT = sHORT_CONT;
	}

	public Timestamp getREG_DTIME() {
		return REG_DTIME;
	}

	public void setREG_DTIME(Timestamp rEG_DTIME) {
		REG_DTIME = rEG_DTIME;
	}

	public Timestamp getSTART_DTIME() {
		return START_DTIME;
	}

	public void setSTART_DTIME(Timestamp sTART_DTIME) {
		START_DTIME = sTART_DTIME;
	}

	public Timestamp getEND_DTIME() {
		return END_DTIME;
	}

	public void setEND_DTIME(Timestamp eND_DTIME) {
		END_DTIME = eND_DTIME;
	}

	public int getSTART_PRICE() {
		return START_PRICE;
	}

	public void setSTART_PRICE(int sTART_PRICE) {
		START_PRICE = sTART_PRICE;
	}

	public int getQTY() {
		return QTY;
	}

	public void setQTY(int qTY) {
		QTY = qTY;
	}

	public String getAPPR_CD() {
		return APPR_CD;
	}

	public void setAPPR_CD(String aPPR_CD) {
		APPR_CD = aPPR_CD;
	}

	public int getMEMB_NUM() {
		return MEMB_NUM;
	}

	public void setMEMB_NUM(int mEMB_NUM) {
		MEMB_NUM = mEMB_NUM;
	}

	public int getPROD_NUM() {
		return PROD_NUM;
	}

	public void setPROD_NUM(int pROD_NUM) {
		PROD_NUM = pROD_NUM;
	}

	public String getAUC_TYPE_NUM() {
		return AUC_TYPE_NUM;
	}

	public void setAUC_TYPE_NUM(String aUC_TYPE_NUM) {
		AUC_TYPE_NUM = aUC_TYPE_NUM;
	}

}
