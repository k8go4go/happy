package kr.co.mlec.board.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.util.ArrayList;

/**
 * 게시물에 대한 데이터를 처리하는 DAO 클래스
 * @author Administrator
 */
public class BoardDAO {
	
	private ArrayList list = new ArrayList();
	
	// 게시물의 글번호 
	int no = 0;
	
	public BoardDAO() {
		readData();
	}
	
	/**
	 * data/board.txt 파일의 내용을 읽어
	 * list 배열에 추가하는 기능
	 * 최초 한번만 수행해야 한다.
	 */
	private void readData() {
		File f = new File("data/board.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(f);
			while (sc.hasNextLine()) {
				String[] arr = sc.nextLine().split(":");
				BoardVO board = new BoardVO();
				this.no = Integer.parseInt(arr[0]);
				board.setNo(this.no);
				board.setTitle(arr[1]);
				board.setWriter(arr[2]);
				board.setContent(arr[3]);
				
				insertBoard(board);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *  문서화 주석문
	 *  클래스, 메서드, 멤버변수에 대한 설명을 할 경우 사용
	 *  전체 게시물을 조회하는 기능의 메서드 
	 */
	public ArrayList selectBoard() {
		return list;
	}
	
	public BoardVO selectOneBoard(int no) {
		for (int i = 0; i < list.size(); i++) {
			BoardVO b = (BoardVO)list.get(i);
			if (no == b.getNo()) {
				return b;
			}
		}
		return null;
	}

	public void insertBoard(BoardVO board) {
		if (board.getNo() == 0) {
			board.setNo(++no);
		}
		list.add(board);
	}
	public boolean updateBoard(BoardVO board) {
		for (int i = 0; i < list.size(); i++) {
			BoardVO b = (BoardVO)list.get(i);
			if (board.getNo() == b.getNo()) {
				b.setTitle(board.getTitle());
				b.setContent(board.getContent());
				return true;
			}
		}
		return false;
	}
	public boolean deleteBoard(int no) {
		int delIndex = -1;
		for (int i = 0; i < list.size(); i++) {
			if (no == ((BoardVO)list.get(i)).getNo()) {
				delIndex = i;
				break;
			}
		}
		if (delIndex == -1) {
			return false;
		} 
		
		list.remove(delIndex);
		
		return true;
	}
	
}









