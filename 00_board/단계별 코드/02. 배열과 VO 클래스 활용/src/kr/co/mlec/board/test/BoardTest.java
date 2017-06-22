package kr.co.mlec.board.test;

import java.util.Scanner;

import kr.co.mlec.board.vo.BoardVO;

public class BoardTest {
	public static void main(String[] args) {
		
		final int INIT_SIZE = 3;
		
		// 입력된 정보를 저장하기 위한 배열 선언
		BoardVO[] list = new BoardVO[INIT_SIZE];
		
		// 입력될 위치 기억, 실제 저장된 데이터의 크기
		int pos = 0;
		
		// 게시물의 글번호 
		int no = 0;
		
		Scanner sc = new Scanner(System.in);
		outer: 
		while (true) {
			System.out.println("-----------------");
			System.out.println("1. 전체 게시물 조회");
			System.out.println("2. 글번호 조회");
			System.out.println("3. 글등록");
			System.out.println("4. 글수정");
			System.out.println("5. 글삭제");
			System.out.println("0. 종료");
			System.out.println("-----------------");
			System.out.print("메뉴 중 처리할 항목을 선택하세요 : ");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				System.out.println("---------------------------");
				System.out.println("번호\t제목\t글쓴이");
				System.out.println("---------------------------");
				for (int i = pos -1; i >= 0; i--) {
					BoardVO b = list[i];
					System.out.printf(
							"%d\t%s\t%s\n", b.no, b.title, b.writer);
				}
				if (pos == 0) {
					System.out.println("게시물이 존재하지 않습니다.");
				}
				System.out.println("---------------------------");
				break;
			case 2:
				System.out.print("조회할 글번호를 입력하세요 : ");
				int searchNo = Integer.parseInt(sc.nextLine());
				System.out.println("---------------------------");
				boolean flag = false;
				for (int i = 0; i < pos; i++) {
					if (searchNo == list[i].no) {
						flag = true;
						
						System.out.println("번호 : " + list[i].no);	
						System.out.println("제목 : " + list[i].title);	
						System.out.println("글쓴이 : " + list[i].writer);	
						System.out.println("내용 : " + list[i].content);	
						break;
					}
				}
				if (flag == false) {
					System.out.println(
							searchNo + "번에 해당하는 게시글이 존재하지 않습니다.");
				}
				System.out.println("---------------------------");
				break;
			case 3:
				// 데이터가 꽉 찼다면 배열의 크기를 증가
				if (pos == list.length) {
					BoardVO[] temp = new BoardVO[pos * 2];
					System.arraycopy(list, 0, temp, 0, pos);
					list = temp;
				}
				
				BoardVO board = new BoardVO();
				System.out.print("제목을 입력하세요 : ");
				board.title = sc.nextLine();
				System.out.print("글쓴이를 입력하세요 : ");
				board.writer = sc.nextLine();
				System.out.print("내용을 입력하세요 : ");
				board.content = sc.nextLine();
				
				board.no = ++no;
				
				list[pos++] = board;
				
				System.out.println("게시물이 등록되었습니다.");
				
				break;
			case 4:
				System.out.print("수정할 글번호를 입력하세요 : ");
				int modNo = Integer.parseInt(sc.nextLine());

				System.out.print("변경할 제목을 입력하세요 : ");
				String modTitle = sc.nextLine();
				System.out.print("변경할 내용을 입력하세요 : ");
				String modContent = sc.nextLine();
				
				boolean modFlag = false;
				for (int i = 0; i < pos; i++) {
					if (modNo == list[i].no) {
						modFlag = true;
						list[i].title = modTitle;
						list[i].content = modContent;
						break;
					}
				}
				if (modFlag == false) {
					System.out.println(
							modNo + "번에 해당하는 게시글이 존재하지 않습니다.");
				} else {
					System.out.println("게시물이 수정되었습니다.");
				}
				break;
			case 5:
				System.out.print("삭제할 글번호를 입력하세요 : ");
				int delNo = Integer.parseInt(sc.nextLine());
				int delIndex = -1;
				for (int i = 0; i < pos; i++) {
					if (delNo == list[i].no) {
						delIndex = i;
						break;
					}
				}
				
				if (delIndex == -1) {
					System.out.println(
							delNo + "번에 해당하는 게시글이 존재하지 않습니다.");
				} else {
					int moveCnt = pos - delIndex - 1;
					if (moveCnt > 0) {
						System.arraycopy(
								list, delIndex + 1, list, delIndex, moveCnt);
					}
					list[--pos] = null;
					System.out.println("게시글이 삭제되었습니다.");
				}
				break;
			case 0:
				System.out.println("게시판 프로그램을 종료합니다.");
				break outer;
			}
		}
	}
}









