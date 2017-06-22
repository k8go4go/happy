package day10;

public interface TV {
	// 상수로 사용됨
	// public final static
	/* public final static */ int MAX_VOLUME = 100;
	
	/* public abstract */
	void powerOn();
	public void powerOff();
	public void volumeUp();
	public void volumeDown();
	public void channelUp();
	public void channelDown();
	public default void shopping() {
		
	}
	public static void alarm() {
		System.out.println("알람입니다..");
	}
}

















