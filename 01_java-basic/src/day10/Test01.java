package day10;
class Animal {
	String name = "Animal";
	int age = 0;
	public void eat() {
		System.out.println("먹다...");
	}
}
class Dog extends Animal {
	String name = "Dog";
	public void tell() {
		System.out.println("멍멍");
	}
	public void eat() {
		System.out.println("후루룩 후루룩~");
	}
}
public class Test01 {
	public static void main(String[] args) {
		Animal a = new Dog();
		System.out.println(a.name);
		System.out.println(a.age);
		a.eat();
//		a.tell();
	}
}
