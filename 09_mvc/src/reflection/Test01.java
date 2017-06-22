package reflection;

import java.util.ArrayList;
import java.util.Random;

public class Test01 {
	public static void main(String[] args) {
		try {
//			exam01();
			exam02();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 클래스 정보 접근하는 3가지 방법
	 * @throws Exception
	 */
	private static void exam01() throws Exception {
		// 1번 방식 : 클래스이름.class
		Class<?> clz = Dog.class;
		
		// 2번 방식 : Class.forName("패키지 포함 클래스명")
		Class<?> clz2 = Class.forName("reflection.Dog");
		
		// 3번 방식 : 객체.getClass()
		Dog d = new Dog();
		Class<?> clz3 = d.getClass();
		
		System.out.println(clz == clz2);
		System.out.println(clz2 == clz3);
		
		String name = clz3.getName();
		String sName = clz3.getSimpleName();
		
		System.out.println(name);
		System.out.println(sName);
	}


	private static void exam02() throws Exception {
		Object obj = getObject();
		Class<?> clz = obj.getClass();
		System.out.println("obj : " + clz.getName());
	}
	
	private static Object getObject() throws Exception {
		Object[] arr = {
				new String("a"),
				new Dog(),
				new ArrayList<String>()
		};
		Random r = new Random();
		return arr[r.nextInt(arr.length)];
	}

}




















