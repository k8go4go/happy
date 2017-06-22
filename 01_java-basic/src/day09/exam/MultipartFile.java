package day09.exam;

public class MultipartFile {

	private String name;
	private String content;
	public String getName() {
		return name;
	}
	public MultipartFile setName(String name) {
		this.name = name;
		return this;
	}
	public String getContent() {
		return content;
	}
	public MultipartFile setContent(String content) {
		this.content = content;
		return this;
	}
}
