package net04.json;

public class MessageVO {
	private int no;
	private String msg;

	public MessageVO() {}
	public MessageVO(int no, String msg) {
		this.no = no;
		this.msg = msg;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
