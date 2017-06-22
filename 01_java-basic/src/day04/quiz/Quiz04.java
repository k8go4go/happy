/*
1부터 1000사이의 숫자를 맞추는 게임입니다.(총 10회)
1회. 숫자를 입력하세요(1 - 1000) : 3
3보다 큰 값 입니다.
2회. 숫자를 입력하세요(1 - 1000) : 500
500보다 작은 값 입니다.
3회. 숫자를 입력하세요(1 - 1000) : 250
정답입니다.

1부터 1000사이의 숫자를 맞추는 게임입니다.(총 10회)
1회. 숫자를 입력하세요(1 - 1000) : 3
3보다 큰 값 입니다.
생략......
10회. 숫자를 입력하세요(1 - 1000) : 3
3보다 큰 값 입니다.
10회안에 맞추기 게임에 실패하였습니다.
정답은 85입니다.
 */
package day04.quiz;

import java.util.Random;
import java.util.Scanner;

public class Quiz04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int answer = r.nextInt(1000) + 1;
		
		boolean flag = false;
		System.out.println("1부터 1000사이의 숫자를 맞추는 게임입니다.(총 10회)");
		for (int i = 1; i <= 10; i++) {
			System.out.print(i + "회. 숫자를 입력하세요(1 - 1000) : ");
			int input = Integer.parseInt(sc.nextLine());

			if (answer == input) {
				flag = true;
				System.out.println("정답입니다.");
				break;
			}
			System.out.printf(
					"%d보다 %s 값 입니다.\n", input, (answer > input) ? "큰" : "작은");
		}
		if (flag == false) {
			System.out.println("10회안에 맞추기 게임에 실패하였습니다.");
			System.out.printf("정답은 %d입니다.", answer);
		}
	}
}
