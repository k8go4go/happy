package day11;

import java.util.Scanner;

class JuminUI {
	
	private JuminService service;
	JuminUI() {
		service = new JuminService();
	}
	public void service() {
		Scanner sc = new Scanner(System.in);
		System.out.print("주민번호 입력 : ");
		try {
			service.valid(sc.nextLine());
			System.out.println("올바르게 처리되었음..");
		} catch (Exception e) {
			System.out.println("입력된 주민번호가 잘못되었습니다.");
			e.printStackTrace();
		}
	}
}
class JuminService {
	public boolean valid(String juminNo) 
			throws JuminNumberException {
		if (juminNo.length() != 13) {
			throw new JuminNumberException(juminNo);
		}
		return true;
	}
}
public class Test09 {
	public static void main(String[] args) {
		JuminUI ui = new JuminUI();
		ui.service();
	}
}








