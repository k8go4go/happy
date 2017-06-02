package kr.heartof.vo.foruser;

import java.util.Date;
import java.util.List;

public class BoardVO {
	private int RN;
	private int BOARD_NUM;
	private String TITLE;
	private String CONT;
	private String WRITER_NM;
	private Date WRITE_DATE;
	private int REVIEW_CNT;
	private int HIGH_BOARD_NUM;
	private int MEMB_NUM;
	private int TOT;
	private String MEMB_ID;
	private String QUES_CD;
	private String CATE_NM;
	private AttacFileVO attacFileVO;

	private List<BoardVO> replys;
	private List<AttacFileVO> files;
	
	private String code;
	private String searchWord;
	
	public String getCATE_NM() {
		return CATE_NM;
	}

	public void setCATE_NM(String cATE_NM) {
		CATE_NM = cATE_NM;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public String getMEMB_ID() {
		return MEMB_ID;
	}

	public void setMEMB_ID(String mEMB_ID) {
		MEMB_ID = mEMB_ID;
	}

	public int getTOT() {
		return TOT;
	}

	public void setTOT(int tOT) {
		TOT = tOT;
	}

	public List<BoardVO> getReplys() {
		return replys;
	}

	public void setReplys(List<BoardVO> replys) {
		this.replys = replys;
	}

	public List<AttacFileVO> getFiles() {
		return files;
	}

	public void setFiles(List<AttacFileVO> files) {
		this.files = files;
	}

	public int getRN() {
		return RN;
	}

	public void setRN(int rN) {
		RN = rN;
	}

	public String getQUES_CD() {
		return QUES_CD;
	}

	public void setQUES_CD(String qUES_CD) {
		QUES_CD = qUES_CD;
	}

	public AttacFileVO getAttacFileVO() {
		return attacFileVO;
	}

	public void setAttacFileVO(AttacFileVO attacFileVO) {
		this.attacFileVO = attacFileVO;
	}

	public int getBOARD_NUM() {
		return BOARD_NUM;
	}

	public void setBOARD_NUM(int bOARD_NUM) {
		BOARD_NUM = bOARD_NUM;
	}
	
	public String getShortTITLE() {
		if(TITLE.length() <= 25)
			return TITLE;
		else {
			return TITLE.substring(0, 25) + "...";
		}
	}
	
	public String getTITLE() {
		return TITLE;
	}

	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}

	public String getCONT() {
		return CONT;
	}

	public void setCONT(String cONT) {
		CONT = cONT;
	}

	public String getWRITER_NM() {
		return WRITER_NM;
	}

	public void setWRITER_NM(String wRITER_NM) {
		WRITER_NM = wRITER_NM;
	}

	public Date getWRITE_DATE() {
		return WRITE_DATE;
	}

	public void setWRITE_DATE(Date wRITE_DATE) {
		WRITE_DATE = wRITE_DATE;
	}

	public int getREVIEW_CNT() {
		return REVIEW_CNT;
	}

	public void setREVIEW_CNT(int rEVIEW_CNT) {
		REVIEW_CNT = rEVIEW_CNT;
	}

	public int getHIGH_BOARD_NUM() {
		return HIGH_BOARD_NUM;
	}

	public void setHIGH_BOARD_NUM(int hIGH_BOARD_NUM) {
		HIGH_BOARD_NUM = hIGH_BOARD_NUM;
	}

	public int getMEMB_NUM() {
		return MEMB_NUM;
	}

	public void setMEMB_NUM(int mEMB_NUM) {
		MEMB_NUM = mEMB_NUM;
	}

	@Override
	public String toString() {
		return "BoardVO [RN=" + RN + ", BOARD_NUM=" + BOARD_NUM + ", TITLE=" + TITLE + ", CONT=" + CONT + ", WRITER_NM="
				+ WRITER_NM + ", WRITE_DATE=" + WRITE_DATE + ", REVIEW_CNT=" + REVIEW_CNT + ", HIGH_BOARD_NUM="
				+ HIGH_BOARD_NUM + ", MEMB_NUM=" + MEMB_NUM + ", TOT=" + TOT + ", MEMB_ID=" + MEMB_ID + ", QUES_CD="
				+ QUES_CD + ", attacFileVO=" + attacFileVO + ", replys=" + replys + ", files=" + files + ", code="
				+ code + ", searchWord=" + searchWord + "]";
	}
}
