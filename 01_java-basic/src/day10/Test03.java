package day10;
class TypeParent {
	public void call() {}
}
class TypeA extends TypeParent {
	public void call() {
		System.out.println("A 클래스 타입");
	}
}
class TypeB extends TypeParent {
	public void call() {
		System.out.println("B 클래스 타입");
	}
}
class TypeC extends TypeParent {
	public void call() {
		System.out.println("C 클래스 타입");
	}
}
public class Test03 {
	private static void call(TypeParent type) {
		type.call();
	}
	public static void main(String[] args) {
		TypeA a = new TypeA();
		call(a);  //  TypeParent type = a;
		TypeB b = new TypeB();
		call(b);  //  TypeParent type = b;
		TypeC c = new TypeC();
		call(c);  //  TypeParent type = c;
	}
}












