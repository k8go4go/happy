package kr.co.mlec.board.ui;

import kr.co.mlec.board.mapper.BoardMapper;
import kr.co.mlec.board.vo.BoardVO;

public class DetailUI extends GenericUI {

	private BoardMapper dao;
	public DetailUI(BoardMapper dao) {
		this.dao = dao;
	}
	
	public void service() throws Exception {
		System.out.print("조회할 글번호를 입력하세요 : ");
		int no = Integer.parseInt(sc.nextLine());
		System.out.println("---------------------------");
		// board : null(없다), null이 아닌경우(찾았다)
		BoardVO board = dao.selectBoardByNo(no);

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
}
