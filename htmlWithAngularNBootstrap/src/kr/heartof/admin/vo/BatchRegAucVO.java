package kr.heartof.admin.vo;

public class BatchRegAucVO {
	private int AUC_REG_NUM;
	private String AUC_ING_CD;
	private String BID_PRICE_REG_NUM;
	private int BID_PRICE;
	
	public int getAUC_REG_NUM() {
		return AUC_REG_NUM;
	}
	public void setAUC_REG_NUM(int aUC_REG_NUM) {
		AUC_REG_NUM = aUC_REG_NUM;
	}
	public String getAUC_ING_CD() {
		return AUC_ING_CD;
	}
	public void setAUC_ING_CD(String aUC_ING_CD) {
		AUC_ING_CD = aUC_ING_CD;
	}
	public String getBID_PRICE_REG_NUM() {
		return BID_PRICE_REG_NUM;
	}
	public void setBID_PRICE_REG_NUM(String bID_PRICE_REG_NUM) {
		BID_PRICE_REG_NUM = bID_PRICE_REG_NUM;
	}
	public int getBID_PRICE() {
		return BID_PRICE;
	}
	public void setBID_PRICE(int bID_PRICE) {
		BID_PRICE = bID_PRICE;
	}

}
