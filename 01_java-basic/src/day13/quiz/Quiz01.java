package day13.quiz;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Quiz01 {
	public static void main(String[] args) {
		// 중복되지 않은 1-45 사이의 
		// 6개의 숫자를 출력
		Random r = new Random();
		Set<Integer> set = new HashSet<>();
		while (set.size() < 6) {
			set.add(r.nextInt(45) + 1);
		}
		System.out.println(set);
	}
}












