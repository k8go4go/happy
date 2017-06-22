package day10;

public class SamsungTV implements TV {
	@Override
	public void powerOn() {
		System.out.println("삼성 전원 켜다");
	}
	@Override
	public void powerOff() {
		System.out.println("삼성 전원 끄다");
	}
	@Override
	public void volumeUp() {
		System.out.println("삼성 소리 업");
	}
	@Override
	public void volumeDown() {
		System.out.println("삼성 소리 다운");
	}
	@Override
	public void channelUp() {
		System.out.println("삼성 채널 업");
	}
	@Override
	public void channelDown() {
		System.out.println("삼성 채널 다운");
	}
}




