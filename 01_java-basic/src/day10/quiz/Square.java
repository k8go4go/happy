package day10.quiz;

public class Square extends Rectangle {
	public Square(int side) {
		super(side, side);
	}
	public void area() {
		System.out.printf(
				"의 면적은 %d입니다.", side1 * side2);
	}
}
