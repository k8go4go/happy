package day10.quiz;

public class Circle extends Shape {
	private int radius;
	
	public Circle(int radius) {
		this.radius = radius;
	}

	@Override
	public void area() {
		System.out.printf(
			"Circle의 면적은 %.2f입니다.", Math.PI * radius * radius);
	}
}
