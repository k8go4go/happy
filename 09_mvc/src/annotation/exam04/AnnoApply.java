package annotation.exam04;

@ClassAnno("클래스 설정")
@RunAnno1("런타임 설정")
public class AnnoApply {
	@RunAnno2(id="tester", msg="Hi~~")
	public void info() {}
	
	public void call() {}
}
