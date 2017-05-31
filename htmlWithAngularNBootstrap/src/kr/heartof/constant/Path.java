package kr.heartof.constant;

public enum Path {
	MAIN_JSP("1"),
	QNA_JSP("2"),
	FAQ_JSP("3");

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
