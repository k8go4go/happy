package annotation.exam03;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

//@Target(value=ElementType.PARAMETER)
// 여러 위치에서 사용하게 할때
@Target({
		ElementType.TYPE, 
		ElementType.FIELD, 
		ElementType.METHOD, 
		ElementType.PARAMETER})
public @interface MyTarget {

}
