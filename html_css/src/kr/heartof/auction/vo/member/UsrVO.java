package kr.heartof.auction.vo.member;

import java.util.Date;

public class UsrVO {
	protected int USR_NO               ;
	protected String USRID                ;
	protected String EMAIL                ;
	protected String TELNO                ;
	protected String ZIPNO                ;
	protected String ADDRESS              ;
	protected Date REG_DATE             ;
	protected String USR_CD               ;
	protected String CRE_DEG_CD           ;
	protected String WITHDRAWAL			 ;
	
	/**
	 * @return the uSR_NO
	 */
	public int getUSR_NO() {
		return USR_NO;
	}

	/**
	 * @param uSR_NO the uSR_NO to set
	 */
	public void setUSR_NO(int uSR_NO) {
		USR_NO = uSR_NO;
	}

	/**
	 * @return the uSRID
	 */
	public String getUSRID() {
		return USRID;
	}

	/**
	 * @param uSRID the uSRID to set
	 */
	public void setUSRID(String uSRID) {
		USRID = uSRID;
	}

	/**
	 * @return the tELNO
	 */
	public String getTELNO() {
		return TELNO;
	}

	/**
	 * @param tELNO the tELNO to set
	 */
	public void setTELNO(String tELNO) {
		TELNO = tELNO;
	}

	/**
	 * @return the zIPNO
	 */
	public String getZIPNO() {
		return ZIPNO;
	}

	/**
	 * @param zIPNO the zIPNO to set
	 */
	public void setZIPNO(String zIPNO) {
		ZIPNO = zIPNO;
	}

	/**
	 * @return the aDDRESS
	 */
	public String getADDRESS() {
		return ADDRESS;
	}

	/**
	 * @param aDDRESS the aDDRESS to set
	 */
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	/**
	 * @return the rEG_DATE
	 */
	public Date getREG_DATE() {
		return REG_DATE;
	}

	/**
	 * @param rEG_DATE the rEG_DATE to set
	 */
	public void setREG_DATE(Date rEG_DATE) {
		REG_DATE = rEG_DATE;
	}

	/**
	 * @return the uSR_CD
	 */
	public String getUSR_CD() {
		return USR_CD;
	}

	/**
	 * @param uSR_CD the uSR_CD to set
	 */
	public void setUSR_CD(String uSR_CD) {
		USR_CD = uSR_CD;
	}

	/**
	 * @return the cRE_DEG_CD
	 */
	public String getCRE_DEG_CD() {
		return CRE_DEG_CD;
	}

	/**
	 * @param cRE_DEG_CD the cRE_DEG_CD to set
	 */
	public void setCRE_DEG_CD(String cRE_DEG_CD) {
		CRE_DEG_CD = cRE_DEG_CD;
	}

	/**
	 * @return the wITHDRAWAL
	 */
	public String getWITHDRAWAL() {
		return WITHDRAWAL;
	}

	/**
	 * @param wITHDRAWAL the wITHDRAWAL to set
	 */
	public void setWITHDRAWAL(String wITHDRAWAL) {
		WITHDRAWAL = wITHDRAWAL;
	}

	/**
	 * @return the eMAIL
	 */
	public String getEMAIL() {
		return EMAIL;
	}

	/**
	 * @param eMAIL the eMAIL to set
	 */
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}	
}
