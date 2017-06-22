package day13.quiz;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Quiz06 {
	public static void main(String[] args) {
		/*
		성적 발표
		========================
		1. 이름 : 배영만, 총점 : 264
		2. 이름 : 배수민, 총점 : 257
		3. 이름 : 배근영, 총점 : 227
		========================
		 */
		try {
			List<Quiz06VO> list = new ArrayList<>();
			Scanner sc = new Scanner(new File("iodata/day13/quiz06.txt"));
			while (sc.hasNextLine()) {
				String[] arr = sc.nextLine().split(":");
				list.add(new Quiz06VO(
						arr[0], 
						Integer.parseInt(arr[1]), 
						Integer.parseInt(arr[2]), 
						Integer.parseInt(arr[3]) 
				));
			}
			Collections.sort(list);
			System.out.println("성적 발표");
			System.out.println("========================");
			int num = 1;
			for (Quiz06VO student : list) {
				System.out.printf(
					"%d. 이름 : %s, 총점 : %d\n", num++, student.getName(), student.getSum());
				if (num == 4) break;
			}
			System.out.println("========================");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
