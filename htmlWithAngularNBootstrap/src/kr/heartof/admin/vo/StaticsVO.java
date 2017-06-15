package kr.heartof.admin.vo;

public class StaticsVO {
	private String MEMB_ID;
	private int MEMB_NUM ;
	private int BID_NUM  ;
	private int BID_PRICE;
    private String YYYY  ;
    private int SUM_1    ;
    private int SUM_2    ;
    private int SUM_3    ;
    private int SUM_4    ;
    private int SUM_5    ;
    private int SUM_6    ;
    private int SUM_7    ;
    private int SUM_8    ;
    private int SUM_9    ;
    private int SUM_10   ;
    private int SUM_11   ;
    private int SUM_12   ;
    private int TOT      ;
    
	public String getMEMB_ID() {
		return MEMB_ID;
	}
	public void setMEMB_ID(String mEMB_ID) {
		MEMB_ID = mEMB_ID;
	}
	public int getBID_PRICE() {
		return BID_PRICE;
	}
	public void setBID_PRICE(int bID_PRICE) {
		BID_PRICE = bID_PRICE;
	}
	public int getBID_NUM() {
		return BID_NUM;
	}
	public void setBID_NUM(int bID_NUM) {
		BID_NUM = bID_NUM;
	}
	public int getMEMB_NUM() {
		return MEMB_NUM;
	}
	public void setMEMB_NUM(int mEMB_NUM) {
		MEMB_NUM = mEMB_NUM;
	}
	public String getYYYY() {
		return YYYY;
	}
	public void setYYYY(String yYYY) {
		YYYY = yYYY;
	}
	public int getSUM_1() {
		return SUM_1;
	}
	public void setSUM_1(int sUM_1) {
		SUM_1 = sUM_1;
	}
	public int getSUM_2() {
		return SUM_2;
	}
	public void setSUM_2(int sUM_2) {
		SUM_2 = sUM_2;
	}
	public int getSUM_3() {
		return SUM_3;
	}
	public void setSUM_3(int sUM_3) {
		SUM_3 = sUM_3;
	}
	public int getSUM_4() {
		return SUM_4;
	}
	public void setSUM_4(int sUM_4) {
		SUM_4 = sUM_4;
	}
	public int getSUM_5() {
		return SUM_5;
	}
	public void setSUM_5(int sUM_5) {
		SUM_5 = sUM_5;
	}
	public int getSUM_6() {
		return SUM_6;
	}
	public void setSUM_6(int sUM_6) {
		SUM_6 = sUM_6;
	}
	public int getSUM_7() {
		return SUM_7;
	}
	public void setSUM_7(int sUM_7) {
		SUM_7 = sUM_7;
	}
	public int getSUM_8() {
		return SUM_8;
	}
	public void setSUM_8(int sUM_8) {
		SUM_8 = sUM_8;
	}
	public int getSUM_9() {
		return SUM_9;
	}
	public void setSUM_9(int sUM_9) {
		SUM_9 = sUM_9;
	}
	public int getSUM_10() {
		return SUM_10;
	}
	public void setSUM_10(int sUM_10) {
		SUM_10 = sUM_10;
	}
	public int getSUM_11() {
		return SUM_11;
	}
	public void setSUM_11(int sUM_11) {
		SUM_11 = sUM_11;
	}
	public int getSUM_12() {
		return SUM_12;
	}
	public void setSUM_12(int sUM_12) {
		SUM_12 = sUM_12;
	}
	public int getTOT() {
		return TOT;
	}
	public void setTOT(int tOT) {
		TOT = tOT;
	}
	
	public String makeName() {
		StringBuffer sb = new StringBuffer();
		
		return MEMB_ID;
	}
	
	public String makeData () {
		StringBuffer sb = new StringBuffer();
	    sb.append(SUM_1 + ",")   ;
	    sb.append(SUM_2 + ",")   ;
	    sb.append(SUM_3 + ",")   ;
	    sb.append(SUM_4 + ",")   ;
	    sb.append(SUM_5 + ",")   ;
	    sb.append(SUM_6 + ",")   ;
	    sb.append(SUM_7 + ",")   ;
	    sb.append(SUM_8 + ",")   ;
	    sb.append(SUM_9 + ",")   ;
	    sb.append(SUM_10+ ",")   ;
	    sb.append(SUM_11+ ",")   ;
	    sb.append(SUM_12)   ;
		
		return sb.toString();
	}
	
	
	@Override
	public String toString() {
		return "StaticsVO [MEMB_NUM=" + MEMB_NUM + ", BID_NUM=" + BID_NUM + ", BID_PRICE=" + BID_PRICE + ", YYYY="
				+ YYYY + ", SUM_1=" + SUM_1 + ", SUM_2=" + SUM_2 + ", SUM_3=" + SUM_3 + ", SUM_4=" + SUM_4 + ", SUM_5="
				+ SUM_5 + ", SUM_6=" + SUM_6 + ", SUM_7=" + SUM_7 + ", SUM_8=" + SUM_8 + ", SUM_9=" + SUM_9
				+ ", SUM_10=" + SUM_10 + ", SUM_11=" + SUM_11 + ", SUM_12=" + SUM_12 + ", TOT=" + TOT + "]";
	}
	public int[] getData() {
		return new int[]{SUM_1, SUM_2, SUM_3, SUM_4, SUM_5, SUM_6, SUM_7, SUM_8, SUM_9, SUM_10, SUM_11, SUM_12};
	}
}
