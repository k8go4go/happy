package day07.exam;

public class TV {
	int channel = 7;
	int volume  = 20;
	boolean power = false;
	
	public void powerOn() {
		System.out.println("티비 전원을 켭니다.");
		power = true;
	}

	public int getVolume() {
		return volume;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int i) {
		channel = i;
	}

	public void channelUp() {
		channel++;
	}

	public void powerOff() {
		System.out.println("티비 전원을 끕니다.");
		power = false;
	}
	
}
