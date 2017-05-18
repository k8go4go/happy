package kr.heartof.auction.vo.member;

public class PrivateUser extends UsrVO {
	private String NM          ;
	private String SOCIAL_NO   ;
	/**
	 * @return the nM
	 */
	public String getNM() {
		return NM;
	}
	/**
	 * @param nM the nM to set
	 */
	public void setNM(String nM) {
		NM = nM;
	}
	/**
	 * @return the sOCIAL_NO
	 */
	public String getSOCIAL_NO() {
		return SOCIAL_NO;
	}
	/**
	 * @param sOCIAL_NO the sOCIAL_NO to set
	 */
	public void setSOCIAL_NO(String sOCIAL_NO) {
		SOCIAL_NO = sOCIAL_NO;
	}
}
