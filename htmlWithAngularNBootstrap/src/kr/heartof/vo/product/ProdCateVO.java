package kr.heartof.vo.product;

import java.util.List;

public class ProdCateVO {
	private String PROD_CATE_NUM;
	private String PROD_CATE_NM;
	private String SHORT_CONT;
	private String HIGH_PROD_CATE_NUM;
	private String USE_CD;
	private String PARENT_PROD_CATE_NM;
	private String PARENT_PROD_CATE_NUM;
	private String PARENT_SHORT_CONT;
	private String PARENT_HIGH_PROD_CATE_NUM;
	
	private List<ProdCateVO> lowerCateVO;
	
	public List<ProdCateVO> getLowerCateVO() {
		return lowerCateVO;
	}

	public void setLowerCateVO(List<ProdCateVO> lowerCateVO) {
		this.lowerCateVO = lowerCateVO;
	}

	public String getUSE_CD() {
		return USE_CD;
	}

	public void setUSE_CD(String uSE_CD) {
		USE_CD = uSE_CD;
	}

	public String getPARENT_PROD_CATE_NM() {
		return PARENT_PROD_CATE_NM;
	}

	public void setPARENT_PROD_CATE_NM(String pARENT_PROD_CATE_NM) {
		PARENT_PROD_CATE_NM = pARENT_PROD_CATE_NM;
	}

	public String getPARENT_PROD_CATE_NUM() {
		return PARENT_PROD_CATE_NUM;
	}

	public void setPARENT_PROD_CATE_NUM(String pARENT_PROD_CATE_NUM) {
		PARENT_PROD_CATE_NUM = pARENT_PROD_CATE_NUM;
	}

	public String getPARENT_SHORT_CONT() {
		return PARENT_SHORT_CONT;
	}

	public void setPARENT_SHORT_CONT(String pARENT_SHORT_CONT) {
		PARENT_SHORT_CONT = pARENT_SHORT_CONT;
	}

	public String getPARENT_HIGH_PROD_CATE_NUM() {
		return PARENT_HIGH_PROD_CATE_NUM;
	}

	public void setPARENT_HIGH_PROD_CATE_NUM(String pARENT_HIGH_PROD_CATE_NUM) {
		PARENT_HIGH_PROD_CATE_NUM = pARENT_HIGH_PROD_CATE_NUM;
	}

	public String getPROD_CATE_NUM() {
		return PROD_CATE_NUM;
	}

	public void setPROD_CATE_NUM(String pROD_CATE_NUM) {
		PROD_CATE_NUM = pROD_CATE_NUM;
	}

	public String getPROD_CATE_NM() {
		return PROD_CATE_NM;
	}

	public void setPROD_CATE_NM(String pROD_CATE_NM) {
		PROD_CATE_NM = pROD_CATE_NM;
	}

	public String getSHORT_CONT() {
		return SHORT_CONT;
	}

	public void setSHORT_CONT(String sHORT_CONT) {
		SHORT_CONT = sHORT_CONT;
	}

	public String getHIGH_PROD_CATE_NUM() {
		return HIGH_PROD_CATE_NUM;
	}

	public void setHIGH_PROD_CATE_NUM(String hIGH_PROD_CATE_NUM) {
		HIGH_PROD_CATE_NUM = hIGH_PROD_CATE_NUM;
	}

	@Override
	public String toString() {
		return "ProdCateVO [PROD_CATE_NUM=" + PROD_CATE_NUM + ", PROD_CATE_NM=" + PROD_CATE_NM + ", SHORT_CONT="
				+ SHORT_CONT + ", HIGH_PROD_CATE_NUM=" + HIGH_PROD_CATE_NUM + ", USE_CD=" + USE_CD
				+ ", PARENT_PROD_CATE_NM=" + PARENT_PROD_CATE_NM + ", PARENT_PROD_CATE_NUM=" + PARENT_PROD_CATE_NUM
				+ ", PARENT_SHORT_CONT=" + PARENT_SHORT_CONT + ", PARENT_HIGH_PROD_CATE_NUM="
				+ PARENT_HIGH_PROD_CATE_NUM + ", lowerCateVO=" + lowerCateVO + "]";
	}
}
