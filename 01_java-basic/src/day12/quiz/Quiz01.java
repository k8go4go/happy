package day12.quiz;

import java.util.Calendar;

public class Quiz01 {
	public static void main(String[] args) {
		final int MAX = 42;
		
		Calendar c = Calendar.getInstance();
		System.out.printf("%d년 %2d월\n", c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		int lastDate = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		int nlCnt = 0;
		
		c.set(Calendar.DAY_OF_MONTH, 1);
		int dayWeek = c.get(Calendar.DAY_OF_WEEK);
		
		c.add(Calendar.MONTH, -1);
		int prevLastDate = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		int viewDay = prevLastDate - dayWeek + 2;
		
		for (int i = 1; i < dayWeek; i++) {
			System.out.print(viewDay++ + "\t");
			nlCnt++;
		}
		for (int i = 1; i <= lastDate; i++) {
			System.out.print(i + ((++nlCnt % 7 == 0) ? "\n" : "\t"));
		}
		for (int i = 1; ++nlCnt <= MAX; i++) {
			System.out.print(i + ((nlCnt % 7 == 0) ? "\n" : "\t"));
		}
	}
}
