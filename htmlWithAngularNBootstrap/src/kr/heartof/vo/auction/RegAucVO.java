package kr.heartof.vo.auction;

import java.util.Date;
import java.util.List;

import kr.heartof.test.mybatis.RegAuctionTest;

public class RegAucVO {
	private int AUC_REG_NUM;           // AUC_REG_NUM
	private String AUC_PROD_NM;        // AUC_PROD_NM
	private String SHORT_CONT;         // SHORT_CONT
	private Date REG_DTIME;            // REG_DTIME
	private Date START_DTIME;          // START_DTIME
	private Date END_DTIME;            // END_DTIME
	private int START_PRICE;           // START_PRICE
	private int QTY;                   // QTY
	
	private int MEMB_NUM;              // MEMB_NUM
	private String APPR_CD;            // APPR_CD
	private String APPR_NM;            // APPR_CD
	private String PROD_CATE_NM;      // PROD_CATE_NUM
	private String PROD_CATE_NUM;      // PROD_CATE_NUM
	private String AUC_TYPE_NUM;       // AUC_TYPE_NUM
	private String AUC_TYPE_NM;       // AUC_TYPE_NUM
	
	private List<RegAucFileVO> files;
	private List<RegRejVO> rejs;

	public String getAPPR_NM() {
		return APPR_NM;
	}

	public void setAPPR_NM(String aPPR_NM) {
		APPR_NM = aPPR_NM;
	}

	public String getPROD_CATE_NM() {
		return PROD_CATE_NM;
	}

	public void setPROD_CATE_NM(String pROD_CATE_NM) {
		PROD_CATE_NM = pROD_CATE_NM;
	}

	public String getAUC_TYPE_NM() {
		return AUC_TYPE_NM;
	}

	public void setAUC_TYPE_NM(String aUC_TYPE_NM) {
		AUC_TYPE_NM = aUC_TYPE_NM;
	}

	public String getPROD_CATE_NUM() {
		return PROD_CATE_NUM;
	}

	public void setPROD_CATE_NUM(String pROD_CATE_NUM) {
		PROD_CATE_NUM = pROD_CATE_NUM;
	}
	
	public List<RegRejVO> getRejs() {
		return rejs;
	}

	public void setRejs(List<RegRejVO> rejs) {
		this.rejs = rejs;
	}

	public List<RegAucFileVO> getFiles() {
		return files;
	}

	public void setFiles(List<RegAucFileVO> files) {
		this.files = files;
	}

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

	public Date getREG_DTIME() {
		return REG_DTIME;
	}

	public void setREG_DTIME(Date rEG_DTIME) {
		REG_DTIME = rEG_DTIME;
	}

	public Date getSTART_DTIME() {
		return START_DTIME;
	}

	public void setSTART_DTIME(Date sTART_DTIME) {
		START_DTIME = sTART_DTIME;
	}

	public Date getEND_DTIME() {
		return END_DTIME;
	}

	public void setEND_DTIME(Date eND_DTIME) {
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

	public String getAUC_TYPE_NUM() {
		return AUC_TYPE_NUM;
	}

	public void setAUC_TYPE_NUM(String aUC_TYPE_NUM) {
		AUC_TYPE_NUM = aUC_TYPE_NUM;
	}

	@Override
	public String toString() {
		return "RegAucVO [AUC_REG_NUM=" + AUC_REG_NUM + ", AUC_PROD_NM=" + AUC_PROD_NM + ", SHORT_CONT=" + SHORT_CONT
				+ ", REG_DTIME=" + REG_DTIME + ", START_DTIME=" + START_DTIME + ", END_DTIME=" + END_DTIME
				+ ", START_PRICE=" + START_PRICE + ", QTY=" + QTY + ", MEMB_NUM=" + MEMB_NUM + ", APPR_CD=" + APPR_CD
				+ ", APPR_NM=" + APPR_NM + ", PROD_CATE_NM=" + PROD_CATE_NM + ", PROD_CATE_NUM=" + PROD_CATE_NUM
				+ ", AUC_TYPE_NUM=" + AUC_TYPE_NUM + ", AUC_TYPE_NM=" + AUC_TYPE_NM + ", files=" + files + ", rejs="
				+ rejs + "]";
	}
}
