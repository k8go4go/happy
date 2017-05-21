package kr.heartof.auction.vo;

import java.util.Date;

public class BoardVO {
	private int BOARD_NUM;
	private String TITLE;
	private String CONT;
	private String WRITER_NM;
	private Date WRITE_DATE;
	private int REVIEW_CNT;
	private int HIGH_BOARD_NUM;
	private int MEMB_NUM;

	public int getBOARD_NUM() {
		return BOARD_NUM;
	}

	public void setBOARD_NUM(int bOARD_NUM) {
		BOARD_NUM = bOARD_NUM;
	}

	public String getTITLE() {
		return TITLE;
	}

	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}

	public String getCONT() {
		return CONT;
	}

	public void setCONT(String cONT) {
		CONT = cONT;
	}

	public String getWRITER_NM() {
		return WRITER_NM;
	}

	public void setWRITER_NM(String wRITER_NM) {
		WRITER_NM = wRITER_NM;
	}

	public Date getWRITE_DATE() {
		return WRITE_DATE;
	}

	public void setWRITE_DATE(Date wRITE_DATE) {
		WRITE_DATE = wRITE_DATE;
	}

	public int getREVIEW_CNT() {
		return REVIEW_CNT;
	}

	public void setREVIEW_CNT(int rEVIEW_CNT) {
		REVIEW_CNT = rEVIEW_CNT;
	}

	public int getHIGH_BOARD_NUM() {
		return HIGH_BOARD_NUM;
	}

	public void setHIGH_BOARD_NUM(int hIGH_BOARD_NUM) {
		HIGH_BOARD_NUM = hIGH_BOARD_NUM;
	}

	public int getMEMB_NUM() {
		return MEMB_NUM;
	}

	public void setMEMB_NUM(int mEMB_NUM) {
		MEMB_NUM = mEMB_NUM;
	}

}
