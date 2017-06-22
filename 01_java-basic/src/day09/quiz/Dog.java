package day09.quiz;

public class Dog {
	private String name;
	private int age;
	public Dog() {
		this("이름모름", 0);
	}
	public Dog(String name) {
		this(name, 0);
	}
	public Dog(int age) {
		this("이름모름", age);
	}
	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void info() {
		System.out.printf(
			"강아지의 이름은 %s이고 나이는 %d입니다.\n", name, age);
	}
}
