package day10.quiz;

public class Rectangle extends Shape {
	protected int side1;
	protected int side2;
	
	public Rectangle(int side1, int side2) {
		this.side1 = side1;
		this.side2 = side2;
	}
	
	@Override
	public void area() {
		System.out.printf(
				"직사각형의 면적은 %d입니다.", side1 * side2);
	}
}