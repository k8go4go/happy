package day03;

public class Test08 {
	public static void main(String[] args) {
		/*
		 	switch 블럭은 같다(==) 비교만 가능
		 	
		 	주의 : 
		 	switch 블럭을 조건을 만족했을때 빠져나가기 
		 	위해서 break를 함께 사용함
		 	
		 	수식 자리에 대입가능한 타입
		 	- 1.4버전 까지 : byte, short, char, int
		 	- 1.5버전 : enum 타입 추가
		 	- 1.7버전 : String 타입 가능
		 	
		 	switch (수식) {
		 		case 값1:
		 			수식과 값1이 같을때 수행할 문장
		 		case 값2:
		 			수식과 값2가 같을때 수행할 문장
		 		case ...
		 		....
		 		default :
		 			위의 조건이 모두 만족하지 않은 경우 
		 			수행할 문장
		 	}
		 */
		
		int a = 4;
		switch (a) {
		case 1:
			System.out.println(a + 10);
			break;
		case 2:
			System.out.println(a + 100);
		case 3:
			System.out.println(a + 1000);
			break;
		default:
			System.out.println("디폴트 수행...");
		}
		
		String season = "가을";
		if (season.equals("봄")) {
		}
		else if (season.equals("여름")) {
		}
		else if (season.equals("가을")) {
		}
		else if (season.equals("겨울")) {
		}

		switch (season) {
		case "봄":
		case "여름":
		case "가을":
		case "겨울":
		}
		
	}
}















