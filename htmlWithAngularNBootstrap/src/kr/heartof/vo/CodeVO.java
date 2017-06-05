package kr.heartof.vo;

import java.util.List;

public class CodeVO {
	private String CD        ;
	private String CATE_NM   ;
	private String CATE_CONT ;
	private String HIGH_CD   ;
	private List<CodeVO> LIST;
	
	public List<CodeVO> getLIST() {
		return LIST;
	}
	public void setLIST(List<CodeVO> lIST) {
		LIST = lIST;
	}
	public String getCD() {
		return CD;
	}
	public void setCD(String cD) {
		CD = cD;
	}
	public String getCATE_NM() {
		return CATE_NM;
	}
	public void setCATE_NM(String cATE_NM) {
		CATE_NM = cATE_NM;
	}
	public String getCATE_CONT() {
		return CATE_CONT;
	}
	public void setCATE_CONT(String cATE_CONT) {
		CATE_CONT = cATE_CONT;
	}
	public String getHIGH_CD() {
		return HIGH_CD;
	}
	public void setHIGH_CD(String hIGH_CD) {
		HIGH_CD = hIGH_CD;
	}
}
