package board.vo;

import java.util.Date;

// TB_BOARD 테이블을 표현하는 클래스
public class BoardVO {
	private int no;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof BoardVO == false) {
			return false;
		}
		BoardVO data = (BoardVO)obj;
		if (this.no != data.no) {
			return false;
		}
		return true;
	}
}
