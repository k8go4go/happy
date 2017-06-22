package day09.quiz;

public class ExDate {
	private int year;
	private int month;
	private int date;
	ExDate() {
		this(2013, 4, 1);
	}
	ExDate(int year, int month, int date) {
		this.year = year;
		this.month = month;
		this.date = date;
	}
	void showDate() {
		System.out.printf(
			"%d년 %d월 %02d일\n", year, month, date);
	}
}