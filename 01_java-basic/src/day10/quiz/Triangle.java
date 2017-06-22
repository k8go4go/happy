package day10.quiz;

public class Triangle extends Shape {
	private int width;
	private int height;
	
	public Triangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public void area() {
		System.out.printf(
				"3각형의 면적은 %d입니다.", height * width * 1 / 2);
	}
}









