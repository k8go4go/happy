package annotation.exam04;

import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) {
		Class<?> clz = AnnoApply.class;
		ClassAnno cAnno = 
				clz.getAnnotation(ClassAnno.class);
		RunAnno1 rAnno = 
				clz.getAnnotation(RunAnno1.class);
		System.out.println(cAnno);
		System.out.println(rAnno);
		
		// AnnoApply 클래스에 선언된 모든 메서드 
		Method[] mArr = clz.getDeclaredMethods();
		// 메서드 중에서 RunAnno2가 선언된 메서드를 찾는다.
		for (Method m : mArr) {
			RunAnno2 anno = 
					m.getAnnotation(RunAnno2.class);
			if (anno == null) continue;
			
			// RunAnno2 가 선언된 메서드일 경우
			System.out.println(
					"메서드명 : " + m.getName());
			System.out.println(anno.id());
			System.out.println(anno.msg());
		}
	}
}





















