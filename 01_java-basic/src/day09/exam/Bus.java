package day09.exam;

public class Bus {
	private int no;
	private int count;
	private static int totalCount;
	
	public Bus() {
	}
	
	public Bus(int no) {
		this.no = no;
		System.out.println(no + "번 버스 운행시작.");
	}
	
	public void setNo(int n) {
		no = n;
	}
	
	public void ride(){
		ride(1);
	}
	
	public void ride(int count){
		System.out.println("승객 " + count + "명 승차.");
		this.count += count;
		totalCount += count;
	}
	
	public void leave(){
		leave(1);
	}
	
	public void leave(int count){
		System.out.println("승객 " + count + "명 하차.");
		this.count -= count;
	}
	
	public void info() {
		System.out.println(no + "번 버스의 현재 승차인원: " + this.count + "명.");
	}
	
	public String toString(){
		return no + "번 버스의 현재 승차인원: " + this.count + "명.\n모든 버스의 누적 승차인원: " + totalCount + "명.";
	}
}
