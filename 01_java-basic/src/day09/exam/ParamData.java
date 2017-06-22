package day09.exam;

public class ParamData {
	private String name;
	private String value;
	public ParamData() {
	}
	public ParamData(String name, String value) {
		this.name = name;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public ParamData setName(String name) {
		this.name = name;
		return this;
	}
	public String getValue() {
		return value;
	}
	public ParamData setValue(String value) {
		this.value = value;
		return this;
	}
}
