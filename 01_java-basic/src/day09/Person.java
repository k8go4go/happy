package day09;

public class Person {
//	private String name;
	String name;
	int age;
	public Person() {}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String toString() {
		return String.format("name=%s, age=%d", name, age);
	}
}










