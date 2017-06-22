package kr.co.mlec.board.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import kr.co.mlec.board.vo.BoardVO;

/**
 * 게시물에 대한 데이터를 처리하는 DAO 클래스
 * @author Administrator
 */
public class BoardDAO {
	
	final int INIT_SIZE = 3;

	// 입력된 정보를 저장하기 위한 배열 선언
	BoardVO[] list = new BoardVO[INIT_SIZE];
	
	// 입력될 위치 기억, 실제 저장된 데이터의 크기
	int pos = 0;

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
				board.setNo(Integer.parseInt(arr[0]));
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
	public BoardVO[] selectBoard() {
		BoardVO[] result = new BoardVO[pos];
		System.arraycopy(list, 0, result, 0, pos);
		return result;
	}
	
	public BoardVO selectOneBoard(int no) {
		for (int i = 0; i < pos; i++) {
			if (no == list[i].getNo()) {
				return list[i];
			}
		}
		return null;
	}

	public void insertBoard(BoardVO board) {
		// 데이터가 꽉 찼다면 배열의 크기를 증가
		if (pos == list.length) {
			BoardVO[] temp = new BoardVO[pos * 2];
			System.arraycopy(list, 0, temp, 0, pos);
			list = temp;
		}
		// 변경된 부분 =============================
		no++;
		if (board.getNo() == 0) {
			board.setNo(no);
		}
		// 변경된 부분 =============================
		
		list[pos++] = board;
	}
	public boolean updateBoard(BoardVO board) {
		for (int i = 0; i < pos; i++) {
			if (board.getNo() == list[i].getNo()) {
				list[i].setTitle(board.getTitle());
				list[i].setContent(board.getContent());
				return true;
			}
		}
		return false;
	}
	public boolean deleteBoard(int no) {
		int delIndex = -1;
		for (int i = 0; i < pos; i++) {
			if (no == list[i].getNo()) {
				delIndex = i;
				break;
			}
		}
		if (delIndex == -1) {
			return false;
		} 
		// 삭제할 글번호가 존재할 경우
		int moveCnt = pos - delIndex - 1;
		if (moveCnt > 0) {
			System.arraycopy(
					list, delIndex + 1, list, delIndex, moveCnt);
		}
		list[--pos] = null;
		return true;
	}
	
}









