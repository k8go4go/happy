package kr.heartof.auction.vo;

import java.io.Serializable;
import java.util.Date;

public class BoardVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int BOARD_SEQ;
	private int BOARD_NO;
	private int INDENT;
	private int HIGH_BOARD_NO;
	private String CONT;
	private String USERID;
	private int REVIEW_CNT;
	private String TITLE;

	private String FILE_NM;
	private String FILE_PATH;
	private Date REG_DATE;

	public int getINDENT() {
		return INDENT;
	}

	public void setINDENT(int iNTEND) {
		INDENT = iNTEND;
	}

	public int getBOARD_SEQ() {
		return BOARD_SEQ;
	}

	public void setBOARD_SEQ(int bOARD_SEQ) {
		BOARD_SEQ = bOARD_SEQ;
	}

	/**
	 * @return the rEG_DATE
	 */
	public Date getREG_DATE() {
		return REG_DATE;
	}

	/**
	 * @param rEG_DATE
	 *            the rEG_DATE to set
	 */
	public void setREG_DATE(Date rEG_DATE) {
		REG_DATE = rEG_DATE;
	}

	/**
	 * @return the bOARD_NO
	 */
	public int getBOARD_NO() {
		return BOARD_NO;
	}

	/**
	 * @param bOARD_NO
	 *            the bOARD_NO to set
	 */
	public void setBOARD_NO(int bOARD_NO) {
		BOARD_NO = bOARD_NO;
	}

	/**
	 * @return the hIGH_BOARD_NO
	 */
	public int getHIGH_BOARD_NO() {
		return HIGH_BOARD_NO;
	}

	/**
	 * @param hIGH_BOARD_NO
	 *            the hIGH_BOARD_NO to set
	 */
	public void setHIGH_BOARD_NO(int hIGH_BOARD_NO) {
		HIGH_BOARD_NO = hIGH_BOARD_NO;
	}

	/**
	 * @return the cONT
	 */
	public String getCONT() {
		return CONT;
	}

	/**
	 * @param cONT
	 *            the cONT to set
	 */
	public void setCONT(String cONT) {
		CONT = cONT;
	}

	/**
	 * @return the uSERID
	 */
	public String getUSERID() {
		return USERID;
	}

	/**
	 * @param uSERID
	 *            the uSERID to set
	 */
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}

	/**
	 * @return the rEVIEW_CNT
	 */
	public int getREVIEW_CNT() {
		return REVIEW_CNT;
	}

	/**
	 * @param rEVIEW_CNT
	 *            the rEVIEW_CNT to set
	 */
	public void setREVIEW_CNT(int rEVIEW_CNT) {
		REVIEW_CNT = rEVIEW_CNT;
	}

	/**
	 * @return the tITLE
	 */
	public String getTITLE() {
		return TITLE;
	}

	/**
	 * @param tITLE
	 *            the tITLE to set
	 */
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}

	/**
	 * @return the fILE_NM
	 */
	public String getFILE_NM() {
		return FILE_NM;
	}

	/**
	 * @param fILE_NM
	 *            the fILE_NM to set
	 */
	public void setFILE_NM(String fILE_NM) {
		FILE_NM = fILE_NM;
	}

	/**
	 * @return the fILE_PATH
	 */
	public String getFILE_PATH() {
		return FILE_PATH;
	}

	/**
	 * @param fILE_PATH
	 *            the fILE_PATH to set
	 */
	public void setFILE_PATH(String fILE_PATH) {
		FILE_PATH = fILE_PATH;
	}
}
