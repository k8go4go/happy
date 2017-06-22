package day03.quiz;

import java.util.Random;

public class Quiz02 {
	public static void main(String[] args) {
		/*
			랜덤한 숫자 하나를 생성한다.(1 - 12)
			랜덤한 숫자가 3, 4, 5 중에 하나이면 "봄입니다."
			랜덤한 숫자가 6, 7, 8 중에 하나이면 "여름입니다."
			랜덤한 숫자가 9, 10, 11 중에 하나이면 "가을입니다."
			랜덤한 숫자가 12, 1, 2 중에 하나이면 "겨울입니다."
		 */
		Random r = new Random();
		int month = r.nextInt(12) + 1;
		String season = "";
		switch (month) {
		case 3:
		case 4:
		case 5:
			season = "봄";
			break;
		case 6:
		case 7:
		case 8:
			season = "여름";
			break;
		}
		System.out.println(season + "입니다.");
	}
}











