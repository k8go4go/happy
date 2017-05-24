package kr.heartof.auction.vo.member;

import java.util.Date;

public class UsrVO {
	private int MEMB_NUM;
	private String MEMB_ID;
	private String SEC_NUM;
	private String EMAIL;
	private String TEL_NUM;
	private String MOBIL_NUM;
	private String ZIP_NUM;
	private String ADDRESS;
	private String DETA_ADDRESS;
	private String CRE_DEG_CD;
	private Date REG_DTIME;
	private String MEMB_CD;
	private String WITHDRAWAL_CD;
	
	private UsrFileVO usrFile;
	
	public UsrFileVO getUsrFile() {
		return usrFile;
	}

	public void setUsrFile(UsrFileVO usrFile) {
		this.usrFile = usrFile;
	}

	public String getWITHDRAWAL_CD() {
		return WITHDRAWAL_CD;
	}

	public void setWITHDRAWAL_CD(String wITHDRAWAL_CD) {
		WITHDRAWAL_CD = wITHDRAWAL_CD;
	}

	public int getMEMB_NUM() {
		return MEMB_NUM;
	}

	public void setMEMB_NUM(int mEMB_NUM) {
		MEMB_NUM = mEMB_NUM;
	}

	public String getMEMB_ID() {
		return MEMB_ID;
	}

	public void setMEMB_ID(String mEMB_ID) {
		MEMB_ID = mEMB_ID;
	}

	public String getSEC_NUM() {
		return SEC_NUM;
	}

	public void setSEC_NUM(String sEC_NUM) {
		SEC_NUM = sEC_NUM;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getTEL_NUM() {
		return TEL_NUM;
	}

	public void setTEL_NUM(String tEL_NUM) {
		TEL_NUM = tEL_NUM;
	}

	public String getMOBIL_NUM() {
		return MOBIL_NUM;
	}

	public void setMOBIL_NUM(String mOBIL_NUM) {
		MOBIL_NUM = mOBIL_NUM;
	}

	public String getZIP_NUM() {
		return ZIP_NUM;
	}

	public void setZIP_NUM(String zIP_NUM) {
		ZIP_NUM = zIP_NUM;
	}

	public String getADDRESS() {
		return ADDRESS;
	}

	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	public String getDETA_ADDRESS() {
		return DETA_ADDRESS;
	}

	public void setDETA_ADDRESS(String dETA_ADDRESS) {
		DETA_ADDRESS = dETA_ADDRESS;
	}

	public String getCRE_DEG_CD() {
		return CRE_DEG_CD;
	}

	public void setCRE_DEG_CD(String cRE_DEG_CD) {
		CRE_DEG_CD = cRE_DEG_CD;
	}

	public Date getREG_DTIME() {
		return REG_DTIME;
	}

	public void setREG_DTIME(Date rEG_DTIME) {
		REG_DTIME = rEG_DTIME;
	}

	public String getMEMB_CD() {
		return MEMB_CD;
	}

	public void setMEMB_CD(String mEMB_CD) {
		MEMB_CD = mEMB_CD;
	}

}
