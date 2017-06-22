// break(반복문 벗어나기)
// continue(현재 실행중인 반복을 벗어나기)
package day04;

import java.util.Random;

public class Test03 {
	public static void main(String[] args) {
		Random r = new Random();
		int num = r.nextInt(10) + 1;
		System.out.println("수 : " + num);
		
		for (int i = 1; i < 11; i++) {
			if (i == num) {
//				break;
				continue;
			}
			System.out.println(i);
//			if (i == num) {
//				i = 10;
//			}
		}
	}
}









