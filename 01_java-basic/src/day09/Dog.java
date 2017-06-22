package day09;

public class Dog {
	private String name;
	private int age;
	
	Dog() {
		this("이름없음", -1);
//		this.name = "이름없음";
//		this.age = -1;
	}
	Dog(int age) {
		this("이름없음", age);
//		this.name = "이름없음";
//		this.age = age;
	}
	Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
//	Dog(String name) {
//		System.out.println("Dog(String name)");
//	}
}
