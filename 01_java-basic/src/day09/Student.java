package day09;

public class Student extends Person {
	String no;  // 학번
	public Student() {
	}
	public Student(String name, int age, String no) {
		super(name, age);
		this.no = no;
	}
	public String toString() {
		return String.format("%s, no=%s", super.toString(), no);
	}	
}











