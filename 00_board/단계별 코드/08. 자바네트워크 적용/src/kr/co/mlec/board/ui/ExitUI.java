package kr.co.mlec.board.ui;

public class ExitUI extends GenericUI {
	@Override
	public void service() {
		System.out.println("게시판 프로그램을 종료합니다.");
		System.exit(0);
	}
}
