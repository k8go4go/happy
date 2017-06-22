package kr.co.mlec.board.ui;

import java.util.Scanner;

import kr.co.mlec.board.mapper.BoardMapper;

public class BoardUI {
	// 데이터 처리를 위한 DAO 클래스 생성
	BoardMapper dao = new BoardMapper();
	Scanner sc = new Scanner(System.in);

	public void service() {
		GenericUI ui = null;
		while (true) {
			switch (showMenu()) {
			case 1: ui = new ListUI(dao); break;
			case 2: ui = new DetailUI(dao); break;
			case 3: ui = new WriteUI(dao); break;
			case 4: ui = new ModifyUI(dao); break;
			case 5: ui = new DeleteUI(dao); break;
			case 0: ui = new ExitUI(); break;
			}
			ui.service();
		}
	}
	
	private int showMenu() {
		System.out.println("-----------------");
		System.out.println("1. 전체 게시물 조회");
		System.out.println("2. 글번호 조회");
		System.out.println("3. 글등록");
		System.out.println("4. 글수정");
		System.out.println("5. 글삭제");
		System.out.println("0. 종료");
		System.out.println("-----------------");
		System.out.print("메뉴 중 처리할 항목을 선택하세요 : ");
		return Integer.parseInt(sc.nextLine());
	}
	
}














