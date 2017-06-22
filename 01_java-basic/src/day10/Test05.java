package day10;

interface A {
	public void a();
}

interface B extends A {
	public void b();
}

public class Test05 {
	public static void main(String[] args) {
		System.out.println(TV.MAX_VOLUME);
		
//		TV.MAX_VOLUME = 200;
//		TV tv = new TV();
		TV tv = new SamsungTV();
		tv.powerOn();
		tv.channelUp();
		tv.powerOff();
		
		tv = new LgTV();
		tv.powerOn();
		tv.channelUp();
		tv.powerOff();
		
	}
}














