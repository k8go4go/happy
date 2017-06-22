package day10.quiz;

public class Duck extends Animal implements Flyable {

	private String name;

	public Duck(String name) {
		this.name = name;
	}

	public void eat() {
		System.out.println(name + ": 먹습니다.");
	}

	public void cry() {
		System.out.println(name + ": 꽥꽥웁니다.");
	}

	public void fly() {
		System.out.println(name + ": 날개를 퍼덕거리지만 날지 못합니다.");
	}
}
