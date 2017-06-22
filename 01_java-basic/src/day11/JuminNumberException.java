package day11;

public class JuminNumberException extends Exception {

	public JuminNumberException() {
		super("주민번호는 13자리 입니다.");
	}
	public JuminNumberException(String msg) {
		super("주민번호(" + msg + ")는 13자리 입니다.");
	}

	
}
