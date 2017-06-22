package kr.co.mlec.board.ui;

import java.util.Scanner;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.util.ArrayList;

public class BoardUI {
	// 데이터 처리를 위한 DAO 클래스 생성
	BoardDAO dao = new BoardDAO();
	
	Scanner sc = new Scanner(System.in);

	public void service() {
		while (true) {
			switch (showMenu()) {
			case 1: searchBoard();    break;
			case 2: searchOneBoard(); break;
			case 3: writeBoard();     break;
			case 4: modifyBoard();    break;
			case 5: deleteBoard();    break;
			case 0: exitBoard();
			}
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
	
	private void exitBoard() {
		System.out.println("게시판 프로그램을 종료합니다.");
		System.exit(0);
	}
	
	private void writeBoard() {
		BoardVO board = new BoardVO();
		System.out.print("제목을 입력하세요 : ");
		board.setTitle(sc.nextLine());
		System.out.print("글쓴이를 입력하세요 : ");
		board.setWriter(sc.nextLine());
		System.out.print("내용을 입력하세요 : ");
		board.setContent(sc.nextLine());
		
		dao.insertBoard(board);
		
		System.out.println("게시물이 등록되었습니다.");
	}

	private void modifyBoard() {
		System.out.print("수정할 글번호를 입력하세요 : ");
		int no = Integer.parseInt(sc.nextLine());
		System.out.print("변경할 제목을 입력하세요 : ");
		String title = sc.nextLine();
		System.out.print("변경할 내용을 입력하세요 : ");
		String content = sc.nextLine();
		
		BoardVO board = new BoardVO();
		board.setNo(no);
		board.setTitle(title);
		board.setContent(content);
		
		boolean flag = dao.updateBoard(board);
		if (flag == false) {
			System.out.println(
					no + "번에 해당하는 게시글이 존재하지 않습니다.");
		} else {
			System.out.println("게시물이 수정되었습니다.");
		}
	}
	
	private void deleteBoard() {
		System.out.print("삭제할 글번호를 입력하세요 : ");
		int no = Integer.parseInt(sc.nextLine());
		// 삭제 요청
		// flag : true(삭제 성공), false(삭제 실패)
		boolean flag = dao.deleteBoard(no);
		if (flag == false) {
			System.out.println(
					no + "번에 해당하는 게시글이 존재하지 않습니다.");
		} else {
			System.out.println("게시글이 삭제되었습니다.");
		}
	}
	
	private void searchOneBoard() {
		System.out.print("조회할 글번호를 입력하세요 : ");
		int no = Integer.parseInt(sc.nextLine());
		System.out.println("---------------------------");
		// board : null(없다), null이 아닌경우(찾았다)
		BoardVO board = dao.selectOneBoard(no);

		if (board == null) {
			System.out.println(
					no + "번에 해당하는 게시글이 존재하지 않습니다.");
		} else {
			System.out.println("번호 : " + board.getNo());	
			System.out.println("제목 : " + board.getTitle());	
			System.out.println("글쓴이 : " + board.getWriter());	
			System.out.println("내용 : " + board.getContent());	
		}
		System.out.println("---------------------------");		
	}
	
	private void searchBoard() {
		ArrayList list = dao.selectBoard();
		
		System.out.println("---------------------------");
		System.out.println("번호\t제목\t글쓴이");
		System.out.println("---------------------------");
		for (int i = list.size() -1; i >= 0; i--) {
			BoardVO b = (BoardVO)list.get(i);
			System.out.printf(
					"%d\t%s\t%s\n", b.getNo(), b.getTitle(), b.getWriter());
		}
		if (list.size() == 0) {
			System.out.println("게시물이 존재하지 않습니다.");
		}
		System.out.println("---------------------------");
	}
}














