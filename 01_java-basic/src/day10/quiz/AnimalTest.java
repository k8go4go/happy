package day10.quiz;

public class AnimalTest {
   public static void main(String[] args) {
      Dog dog = new Dog("멍멍이");
      Duck duck = new Duck("꽥꽥이");
      
      dog.eat();
      
      crying(dog);
      
      duck.eat();
      crying(duck);      
      flying(duck);
   }
   
   private static void crying(Animal a){
      a.cry();
   }
   
   private static void flying(Flyable f){
      f.fly();
	}
}