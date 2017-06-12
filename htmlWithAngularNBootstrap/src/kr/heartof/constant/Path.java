package kr.heartof.constant;

public enum Path {
	MAIN_JSP("1"),
	QNA_LIST_JSP("2"),
	QNA_UDDATE_JSP("3"),
	QNA_DELETE_JSP("4"),
	QNA_INSERT_JSP("5"),
	QNA_HITCOUNT_JSP("6"),
	FAQ_JSP("7"),
	LOGIN_JSP("8"),
	JOIN_JSP("9"),
	DUPLICATE_AJAX("10"),
	AUC_TYPE_AJAX("11"),
	PRO_DCATE_AJX("12"),
	REG_AUC_JSP("13"),
	LOGOUT_JSP("14"),	
	UPDATE_USER_JSP("15"),
	REG_AUC_LIST_JSP("16"),
	REG_AUC_DETAIL_JSP("17"),
	UPDATE_REG_AUC_JSP("18"),
	COMMON_AUC_DETAIL_JSP("19"),
	ADMIN_LOGIN_JSP("20"),
	ADMIN_MAIN_SERVLET("21"),
	AMDIN_APPR_CD_DETAIL_JSP("22"),
	AMDIN_APPR_CD_PROCESS("23"),
	AMDIN_APPR_REJECT_JSP("24"),
	ADMIN_LOGOUT_JSP("25"),
	ADMIN_MAIN_JSP("26"),
	AJAX_MONTHLY_PAGE_JSP("27"),
	MONTHLY_PAGE_JSP("28"),
	NEW_BIDDING_SERLVET("29");

	private String path;

	private Path(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
