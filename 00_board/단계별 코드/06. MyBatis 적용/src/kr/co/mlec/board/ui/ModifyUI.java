package kr.co.mlec.board.ui;

import kr.co.mlec.board.mapper.BoardMapper;
import kr.co.mlec.board.vo.BoardVO;

public class ModifyUI extends GenericUI {

	private BoardMapper dao;
	
	public ModifyUI(BoardMapper dao) {
		this.dao = dao;
	}
	
	@Override
	public void service() {
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

}
