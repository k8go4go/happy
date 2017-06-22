package day10.quiz;

public class Dog extends Animal {
	private String name;

	public Dog(String name) {
		this.name = name;
	}

	public void eat() {
		System.out.println(name + ": 먹습니다.");
	}

	public void cry() {
		System.out.println(name + ": 멍멍 짖습니다.");
	}
}