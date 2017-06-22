package day10.quiz;

import java.util.Random;

public class Quiz01 {
	public static void main(String[] args) {
		Random r = new Random();
		// 1-정사각형, 2-직사각형, 3-삼각형, 4-원
		int type = r.nextInt(4) + 1;
		type = 1;
		Shape s = null;
		switch(type) {
		case 1:
			s = new Square(r.nextInt(10) + 1);
			break;
		case 2:
			s = new Rectangle(
					r.nextInt(10) + 1, r.nextInt(10) + 1);
			break;
		case 3:
			s = new Triangle(
					r.nextInt(10) + 1, r.nextInt(10) + 1);
			break;
		case 4:
			s = new Circle(r.nextInt(10) + 1);
			break;
		}
		s.area();
	}
}







