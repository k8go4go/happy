package kr.heartof.constant;

public enum Path {
	MAIN_JSP("1"),
	QNA_LIST_JSP("2"),
	QNA_UDDATE_JSP("3"),
	QNA_DELETE_JSP("4"),
	QNA_INSERT_JSP("5"),
	QNA_HITCOUNT_JSP("6"),
	FAQ_JSP("7");

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
