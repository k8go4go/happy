package kr.heartof.auction.vo.member;

public class UsrFileVO {
	private int MEMB_NUM;
	private String FILE_NM;
	private String FILE_PATH;
	private String REAL_NM;
	private int FILE_SIZE;
	
	public int getMEMB_NUM() {
		return MEMB_NUM;
	}
	public void setMEMB_NUM(int mEMB_NUM) {
		MEMB_NUM = mEMB_NUM;
	}
	public String getFILE_NM() {
		return FILE_NM;
	}
	public void setFILE_NM(String fILE_NM) {
		FILE_NM = fILE_NM;
	}
	public String getFILE_PATH() {
		return FILE_PATH;
	}
	public void setFILE_PATH(String fILE_PATH) {
		FILE_PATH = fILE_PATH;
	}
	public String getREAL_NM() {
		return REAL_NM;
	}
	public void setREAL_NM(String rEAL_NM) {
		REAL_NM = rEAL_NM;
	}
	public int getFILE_SIZE() {
		return FILE_SIZE;
	}
	public void setFILE_SIZE(int fILE_SIZE) {
		FILE_SIZE = fILE_SIZE;
	}
	@Override
	public String toString() {
		return "UsrFileVO [MEMB_NUM=" + MEMB_NUM + ", FILE_NM=" + FILE_NM + ", FILE_PATH=" + FILE_PATH + ", REAL_NM="
				+ REAL_NM + ", FILE_SIZE=" + FILE_SIZE + "]";
	}
}
