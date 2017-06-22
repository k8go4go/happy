package annotation.exam01;

@Marker
public class Test {
	
	@Type1(value="test")
	@Type2(name="aaa")
	public void call() {}
	
	@Type1("test")
//	@Type2("aaa")   // 에러발생
	public void test() {}
}










