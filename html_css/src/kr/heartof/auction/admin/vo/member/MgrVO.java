package kr.heartof.auction.admin.vo.member;

import java.sql.Timestamp;

public class MgrVO {
	private int MGR_NUM;
	private String MGR_NM;
	private String MEMB_ID;
	private String SEC_NUM;
	private String EMAIL;
	private String TEL_NUM;
	private String MOBIL_NUM;
	private Timestamp REG_DTIME;
	private int HIGH_MGR_NUM;

	public int getMGR_NUM() {
		return MGR_NUM;
	}

	public void setMGR_NUM(int mGR_NUM) {
		MGR_NUM = mGR_NUM;
	}

	public String getMGR_NM() {
		return MGR_NM;
	}

	public void setMGR_NM(String mGR_NM) {
		MGR_NM = mGR_NM;
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

	public Timestamp getREG_DTIME() {
		return REG_DTIME;
	}

	public void setREG_DTIME(Timestamp rEG_DTIME) {
		REG_DTIME = rEG_DTIME;
	}

	public int getHIGH_MGR_NUM() {
		return HIGH_MGR_NUM;
	}

	public void setHIGH_MGR_NUM(int hIGH_MGR_NUM) {
		HIGH_MGR_NUM = hIGH_MGR_NUM;
	}

}
