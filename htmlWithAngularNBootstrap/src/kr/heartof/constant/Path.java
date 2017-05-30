package kr.heartof.constant;

public enum Path {
	MAIN_JSP(1);

	private int path;

	private Path(int path) {
		this.path = path;
	}

	public int getPath() {
		return path;
	}

	public void setPath(int path) {
		this.path = path;
	}
}
