package day13.quiz;

import java.io.FileNotFoundException;

public class Quiz02 {
	public static void main(String[] args) {
		/*
		 *   화면에 아래와 같이 출력되도록 프로그램을 작성하시오
		 *   단, 각 데이터를 VO에 담고 처리한다.
		 *   VO에 처리가 완성되면 Map에 담고 출력하도록 처리
		 *   
		 *   
		 *   가수정보
		 *   ----------------------------------
		 *   아이유    25세    발라드     여성
		 *   빅뱅      11세    힙합, 댄스 남성
		 *   신화      15세    댄스       남성
		 *   ----------------------------------
		 */
		try {
			new Quiz02UI().service();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
