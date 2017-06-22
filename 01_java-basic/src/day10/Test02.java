package day10;
class Food {
	
}
class Cake extends Food {
	
}
class Fruit extends Food {
	
}
public class Test02 {
	public static void main(String[] args) {
		Cake c = new Cake();
		Fruit f = new Fruit();
		
//		Fruit f2 = c;  // 상속 관계가 없음...
		
		Food food = c;
//		Fruit f2 = food;  // 명시적 형변환 
//		Fruit f2 = (Fruit)food; // 실행시 오류발생
		food = new Fruit();
		
		Fruit f2 = (Fruit)food;
		
		Fruit f3 = new Fruit();
	}
}









